package org.sy.fiar.service;

import org.sy.fiar.bean.LoginLog;
import org.sy.fiar.bean.req.PageReq;

import java.util.List;

/**
 * 登录日志接口
 *
 * @author SY
 * @since 2022/8/21 22:53
 */
public interface LoginLogService {
    /**
     * 添加登录日志
     *
     * @param loginLog loginLog
     */
    void saveOperationLog(LoginLog loginLog);

    /**
     * 登录日志列表（分页）
     *
     * @param pageReq pageReq
     * @return List
     */
    List<LoginLog> getLoginOperationLogPage(PageReq pageReq);
}
