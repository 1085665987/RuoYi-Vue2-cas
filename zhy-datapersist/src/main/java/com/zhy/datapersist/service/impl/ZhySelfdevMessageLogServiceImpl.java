package com.zhy.datapersist.service.impl;

import com.zhy.datapersist.domain.ZhySelfdevMessageLog;
import com.zhy.datapersist.mapper.ZhySelfdevMessageLogMapper;
import com.zhy.datapersist.service.IZhySelfdevMessageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZhySelfdevMessageLogServiceImpl implements IZhySelfdevMessageLogService {

    @Autowired
    private ZhySelfdevMessageLogMapper zhySelfdevMessageLogMapper;

    /**
     * 查询消息日志列表
     *
     * @param zhySelfdevMessageLog 消息日志
     * @return 消息集合
     */
    @Override
    public List<ZhySelfdevMessageLog> selectZhySelfdevMessageLogList(ZhySelfdevMessageLog zhySelfdevMessageLog) {
        return zhySelfdevMessageLogMapper.selectZhySelfdevMessageLogList(zhySelfdevMessageLog);
    }

    /**
     * 新增消息日志
     *
     * @param zhySelfdevMessageLog 消息日志
     * @return 结果
     */
    @Override
    public int insertZhySelfdevMessageLog(ZhySelfdevMessageLog zhySelfdevMessageLog) {
        return zhySelfdevMessageLogMapper.insertZhySelfdevMessageLog(zhySelfdevMessageLog);
    }

    /**
     * 删除消息日志
     *
     * @param id 消息日志主键
     * @return 结果
     */
    @Override
    public int deleteZhySelfdevMessageLogByLogId(Long id) {
        return zhySelfdevMessageLogMapper.deleteZhySelfdevMessageLogByLogId(id);
    }

    /**
     * 批量删除消息日志
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    @Override
    public int deleteZhySelfdevMessageLogByLogIds(Long[] ids) {
        return zhySelfdevMessageLogMapper.deleteZhySelfdevMessageLogByLogIds(ids);
    }
}
