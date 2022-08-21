package org.sy.fiar.dao;

import org.springframework.stereotype.Repository;
import org.sy.fiar.bean.LoginLog;

import java.util.List;

/**
 * 登录日志mapper
 *
 * @author SY
 * @since 2022/8/21 22:55
 */
@Repository
public interface LoginLogMapper {
    /**
     * 创建登录日志
     *
     * @param loginLog loginLog
     * @return int
     */
    int createLoginOperationLog(LoginLog loginLog);

    /**
     * 分类列表（分页）
     *
     * @return List
     */
    List<LoginLog> getLoginOperationLogPage();
}
