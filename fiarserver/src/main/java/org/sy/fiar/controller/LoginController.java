package org.sy.fiar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sy.fiar.bean.RespBean;
import org.sy.fiar.bean.User;
import org.sy.fiar.pub.constants.UserConstant;
import org.sy.fiar.service.UserService;

/**
 * 登录&&注册Controller
 *
 * @since 2021-07-04
 * @author sy
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * @Description 用户注册
     * @Author sy
     * @Date 20:32 2021/7/4
     * @Param [user]
     * @return org.sy.fiar.bean.RespBean
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
     * @Description 未登录
     * @Author sy
     * @Date 20:34 2021/7/4
     * @Param []
     * @return org.sy.fiar.bean.RespBean
     */
    @RequestMapping("/login_page")
    public RespBean loginPage() {
        return new RespBean("error", "尚未登录，请登录！");
    }

    /**
     * @Description 登录成功
     * @Author sy
     * @Date 20:37 2021/7/4
     * @Param []
     * @return org.sy.fiar.bean.RespBean
     */
    @RequestMapping("/login_success")
    public RespBean loginSuccess() {
        return new RespBean("success", "登录成功！");
    }

    /**
     * @Description 登录失败
     * @Author sy
     * @Date 21:31 2021/7/5
     * @Param []
     * @return org.sy.fiar.bean.RespBean
     */
    @RequestMapping("login_error")
    public RespBean loginError() {
        return new RespBean("error", "登录失败！");
    }

}
