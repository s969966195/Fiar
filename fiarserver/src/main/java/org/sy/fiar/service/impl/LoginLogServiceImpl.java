package org.sy.fiar.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.sy.fiar.bean.LoginLog;
import org.sy.fiar.bean.req.PageReq;
import org.sy.fiar.dao.LoginLogMapper;
import org.sy.fiar.service.LoginLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录日志实现类
 *
 * @author SY
 * @since 2022/8/21 22:54
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Resource private LoginLogMapper loginLogMapper;

    @Override
    public void saveOperationLog(LoginLog loginLog) {
        loginLogMapper.createLoginOperationLog(loginLog);
    }

    @Override
    public List<LoginLog> getLoginOperationLogPage(PageReq pageReq) {
        int pageNum = pageReq.getPageNum();
        int pageSize = pageReq.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return loginLogMapper.getLoginOperationLogPage();
    }
}
