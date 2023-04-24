package org.sy.fiar.dao;

import org.sy.fiar.bean.OperationLog;

import java.util.List;

/**
 * 操作日志mapper
 *
 * @author SY
 * @since 2022/8/21 22:27
 */
public interface OperationLogMapper {
    /**
     * 创建操作日志
     *
     * @param operationLog operationLog
     * @return int
     */
    int createOperationLog(OperationLog operationLog);

    /**
     * 分类列表（分页）
     *
     * @return List
     */
    List<OperationLog> getOperationLogPage();
}
