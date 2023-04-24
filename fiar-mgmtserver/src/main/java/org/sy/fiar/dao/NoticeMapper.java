package org.sy.fiar.dao;

import org.sy.fiar.bean.Notice;

import java.util.List;

/**
 * description
 *
 * @author SY
 * @since 2022/8/14 9:38
 */
public interface NoticeMapper {

    /**
     * 创建
     *
     * @param notice notice
     * @return int
     */
    int createNotice(Notice notice);

    /**
     * 修改
     *
     * @param notice
     * @return
     */
    int updateNotice(Notice notice);

    /**
     * 分类列表（分页）
     *
     * @return
     */
    List<Notice> getNoticePage();

    /**
     * 删除
     *
     * @param id
     */
    void deleteNotice(Integer id);
}
