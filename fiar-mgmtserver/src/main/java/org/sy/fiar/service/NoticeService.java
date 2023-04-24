package org.sy.fiar.service;

import org.sy.fiar.bean.Notice;
import org.sy.fiar.bean.req.PageReq;

import java.util.List;

/**
 * 通知接口
 *
 * @author SY
 * @since 2022/8/14 9:35
 */
public interface NoticeService {

    /**
     * 获取所有的分类（分页）
     *
     * @param pageReq pageReq
     * @return List
     */
    List<Notice> getNoticePage(PageReq pageReq);

    /**
     * 新建分类
     *
     * @param notice notice
     * @return int
     */
    int saveNotice(Notice notice);

    /**
     * 修改分类
     *
     * @param notice notice
     * @return int
     */
    int updateNotice(Notice notice);

    /**
     * 删除分类
     *
     * @param noticeId noticeId
     */
    void deleteNotice(Integer noticeId);
}
