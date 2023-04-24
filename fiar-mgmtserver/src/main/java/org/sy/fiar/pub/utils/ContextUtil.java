package org.sy.fiar.pub.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.sy.fiar.bean.User;

/**
 * 上下文工具类
 *
 * @author SY
 * @since 2021/7/6 22:54
 */
public class ContextUtil {

    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
