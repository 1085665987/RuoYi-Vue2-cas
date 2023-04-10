package com.zhy.web.controller.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.zhy.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zhy.common.constant.Constants;
import com.zhy.common.core.domain.AjaxResult;
import com.zhy.common.core.domain.entity.SysMenu;
import com.zhy.common.core.domain.entity.SysUser;
import com.zhy.common.core.domain.model.LoginBody;
import com.zhy.common.utils.SecurityUtils;
import com.zhy.framework.web.service.SysLoginService;
import com.zhy.framework.web.service.SysPermissionService;
import com.zhy.system.service.ISysMenuService;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;

/**
 * 登录验证
 *
 * @author zhy
 */
@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }


    @Resource
    private RedisCache redisCache;

    /**
     * 测试DeferredResult
     *
     * @return
     */
    @GetMapping("DeferredResult")
    public DeferredResult<String> isVmLine() {
        // 返回超时时间10s，返回值为否（1/是，0/否）
        DeferredResult<String> deferredResult = new DeferredResult<>(10 * 1000L, "0");
        new Thread(() -> {
            while (true) {
                String droneBoxMessage = redisCache.getCacheObject("droneBoxMessage");
                if (droneBoxMessage != null && !"".equals(droneBoxMessage)) {
                    deferredResult.setResult(droneBoxMessage);
                }
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            redisCache.setCacheObject("droneBoxMessage", "555555555555555555555555555");
        }).start();
        return deferredResult;
    }
}
