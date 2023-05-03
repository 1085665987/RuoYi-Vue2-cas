package com.zhy.datapersist.service;

import com.zhy.datapersist.domain.ZhySelfdevMessageLog;

import java.util.List;

/**
 * 消息日志Service接口
 *
 * @author zhy
 * @date 2023-04-22
 */
public interface IZhySelfdevMessageLogService
{
    /**
     * 查询消息日志列表
     *
     * @param zhySelfdevMessageLog 消息日志
     * @return 消息集合
     */
    public List<ZhySelfdevMessageLog> selectZhySelfdevMessageLogList(ZhySelfdevMessageLog zhySelfdevMessageLog);

    /**
     * 新增消息日志
     *
     * @param zhySelfdevMessageLog 消息日志
     * @return 结果
     */
    public int insertZhySelfdevMessageLog(ZhySelfdevMessageLog zhySelfdevMessageLog);


    /**
     * 删除消息日志
     *
     * @param id 消息日志主键
     * @return 结果
     */
    public int deleteZhySelfdevMessageLogByLogId(Long id);

    /**
     * 批量删除消息日志
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZhySelfdevMessageLogByLogIds(Long[] ids);
}
