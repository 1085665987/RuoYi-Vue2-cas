package com.zhy.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhy.common.config.ZhyConfig;
import com.zhy.common.utils.StringUtils;

/**
 * 首页
 *
 * @author zhy
 */
@RestController
public class SysIndexController
{
    /** 系统基础配置 */
    @Autowired
    private ZhyConfig zhyConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", zhyConfig.getName(), zhyConfig.getVersion());
    }
}
