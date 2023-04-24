package org.sy.fiar.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.sy.fiar.bean.OperationLog;
import org.sy.fiar.bean.req.PageReq;
import org.sy.fiar.dao.OperationLogMapper;
import org.sy.fiar.service.OperationLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author SY
 * @since 2022/8/21 22:26
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Resource
    OperationLogMapper operationLogMapper;

    @Override
    public void saveOperationLog(OperationLog operationLog) {
        operationLogMapper.createOperationLog(operationLog);
    }

    @Override
    public List<OperationLog> getOperationLogPage(PageReq pageReq) {
        int pageNum = pageReq.getPageNum();
        int pageSize = pageReq.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return operationLogMapper.getOperationLogPage();
    }
}
