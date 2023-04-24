package org.sy.fiar.service;

import org.sy.fiar.bean.OperationLog;
import org.sy.fiar.bean.req.PageReq;

import java.util.List;

/**
 * 操作日志接口
 *
 * @author SY
 * @since 2022/8/21 22:25
 */
public interface OperationLogService {
    /**
     * 保存操作日志
     *
     * @param operationLog operationLog
     */
    void saveOperationLog(OperationLog operationLog);

    /**
     * 操作日志列表（分页）
     *
     * @param pageReq pageReq
     * @return List
     */
    List<OperationLog> getOperationLogPage(PageReq pageReq);
}
