package org.sy.fiar.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sy.fiar.bean.LoginLog;
import org.sy.fiar.bean.OperationLog;
import org.sy.fiar.bean.req.PageReq;
import org.sy.fiar.bean.resp.BaseResp;
import org.sy.fiar.bean.resp.PageResp;
import org.sy.fiar.pub.utils.PageUtil;
import org.sy.fiar.service.LoginLogService;
import org.sy.fiar.service.OperationLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录/操作日志接口
 *
 * @author SY
 * @since 2022/8/21 22:59
 */
@Api(tags = "操作日志")
@RestController
@RequestMapping("/log")
public class OperationLogController {
    @Resource private LoginLogService loginLogService;

    @Resource private OperationLogService operationLogService;

    /**
     * 操作日志列表
     *
     * @param pageReq pageReq
     * @return BaseResp
     */
    @ApiOperation(value = "操作日志列表")
    @PostMapping("/operation/list")
    public BaseResp<Object> OperationLogListPage(@RequestBody @Valid PageReq pageReq) {
        List<OperationLog> operationLogPage = operationLogService.getOperationLogPage(pageReq);
        PageInfo pageInfo = new PageInfo(operationLogPage);
        PageResp pageResult = PageUtil.getPageResult(pageReq, pageInfo);
        return BaseResp.success(pageResult);
    }

    /**
     * 登录日志列表
     *
     * @param pageReq pageReq
     * @return BaseResp
     */
    @ApiOperation(value = "登录日志列表")
    @PostMapping("/login/list")
    public BaseResp<Object> LoginOperationLogListPage(@RequestBody @Valid PageReq pageReq) {
        List<LoginLog> loginOperationLogPage = loginLogService.getLoginOperationLogPage(pageReq);
        PageInfo pageInfo = new PageInfo(loginOperationLogPage);
        PageResp pageResult = PageUtil.getPageResult(pageReq, pageInfo);
        return BaseResp.success(pageResult);
    }
}
