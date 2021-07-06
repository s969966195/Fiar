package org.sy.fiar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sy.fiar.bean.RespBean;
import org.sy.fiar.pub.utils.ContextUtil;
import org.sy.fiar.service.UserService;

import java.util.List;

/**
 * 用户Controller
 *
 * @author SY
 * @since 2021/7/6 22:51
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/currentUserName")
    public String currentUserName() {
        return ContextUtil.getCurrentUser().getNickname();
    }

    @RequestMapping("/currentUserId")
    public Long currentUserId() {
        return ContextUtil.getCurrentUser().getId();
    }

    @RequestMapping("/currentUserEmail")
    public String currentUserEmail() {
        return ContextUtil.getCurrentUser().getEmail();
    }

    @RequestMapping("/isAdmin")
    public Boolean isAdmin() {
        List<GrantedAuthority> authorities = ContextUtil.getCurrentUser().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().contains("超级管理员")) {
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/updateUserEmail", method = RequestMethod.PUT)
    public RespBean updateUserEmail(String email) {
        if (userService.updateUserEmail(email) == 1) {
            return new RespBean("success", "更新邮箱成功！");
        }
        return new RespBean("error", "更新邮箱失败！");
    }

}
