package org.sy.fiar.controller;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.sy.fiar.bean.LoginLog;
import org.sy.fiar.bean.RespBean;
import org.sy.fiar.bean.User;
import org.sy.fiar.pub.constants.UserConstant;
import org.sy.fiar.pub.utils.IpUtil;
import org.sy.fiar.pub.utils.ServletUtil;
import org.sy.fiar.service.LoginLogService;
import org.sy.fiar.service.impl.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 登录&&注册Controller
 *
 * @author sy
 * @since 2021-07-04
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Resource
    private LoginLogService loginLogService;

    /**
     * @return org.sy.fiar.bean.RespBean
     * @Description 用户注册 @Author sy @Date 20:32 2021/7/4 @Param [user]
     */
    @PostMapping("/register")
    public RespBean register(User user) {
        int result = userService.register(user);
        if (result == UserConstant.RegisterResult.SUCCESS) {
            return new RespBean("success", "注册成功！");
        } else if (result == UserConstant.RegisterResult.DUPLICATE_USERNAME) {
            return new RespBean("error", "用户名重复，注册失败！");
        } else {
            return new RespBean("error", "注册失败！");
        }
    }

    /**
     * @return org.sy.fiar.bean.RespBean
     * @Description 未登录 @Author sy @Date 20:34 2021/7/4 @Param []
     */
    @RequestMapping("/login_page")
    public RespBean loginPage() {
        return new RespBean("error", "尚未登录，请登录！");
    }

    /**
     * @return org.sy.fiar.bean.RespBean
     * @Description 登录成功 @Author sy @Date 20:37 2021/7/4 @Param []
     */
    @RequestMapping("/login_success")
    public RespBean loginSuccess() {
        return new RespBean("success", "登录成功！");
    }

    /**
     * @return org.sy.fiar.bean.RespBean
     * @Description 登录失败 @Author sy @Date 21:51 2021/7/5 @Param []
     */
    @RequestMapping("login_error")
    public RespBean loginError() {
        return new RespBean("error", "登录失败！");
    }

    // TODO 登录日志操作添加

    /**
     * 获取登录日志
     */
    public void getLoginInfoLog(User user, Integer status) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =
                (HttpServletRequest)
                        Objects.requireNonNull(requestAttributes)
                                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
        // 解析agent字符串
        UserAgent userAgent =
                UserAgent.parseUserAgentString(ServletUtil.getRequest().getHeader("User-Agent"));

        // 登录账号
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginName(user.getUsername());

        // 登录IP地址
        String ipAddr = IpUtil.getIpAddr(request);
        loginLog.setIpAddress(ipAddr);
        // 登录地点
        String ipInfo = IpUtil.getIpInfo(ipAddr);
        loginLog.setLoginLocation(ipInfo);
        // 浏览器类型
        String browser = userAgent.getBrowser().getName();
        loginLog.setBrowserType(browser);
        // 操作系统
        String os = userAgent.getOperatingSystem().getName();
        loginLog.setOs(os);
        // 登录状态
        loginLog.setLoginStatus(status);
        loginLogService.saveOperationLog(loginLog);
    }
}
