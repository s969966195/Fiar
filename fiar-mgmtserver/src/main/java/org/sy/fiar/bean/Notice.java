package org.sy.fiar.bean;

import java.time.LocalDateTime;

/**
 * 通知公告
 *
 * @author SY
 * @since 2022/8/14 9:32
 */
public class Notice {

    /**
     * 主键
     */
    private int noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告类型，默认0, 0-公告, 1-通知, 2-提醒
     */
    private int noticeType;

    /**
     * 状态，默认0, 0-正常, 1-关闭
     */
    private int status;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
