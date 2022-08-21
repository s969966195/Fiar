package org.sy.fiar.bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 登录日志
 *
 * @author SY
 * @since 2022/8/21 22:52
 */
@Data
public class LoginLog {
    /** 主键id */
    private Integer id;

    /** 登录账号 */
    private String loginName;

    /** 登录IP地址 */
    private String ipAddress;

    /** 登录地点 */
    private String loginLocation;

    /** 浏览器类型 */
    private String browserType;

    /** 操作系统 */
    private String os;

    /** 登录状态，默认0, 0-成功, 1-失败 */
    private Integer loginStatus;

    /** 创建时间 */
    private LocalDateTime createTime;
}
