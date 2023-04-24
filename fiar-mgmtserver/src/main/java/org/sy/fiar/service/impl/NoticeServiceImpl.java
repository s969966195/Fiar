package org.sy.fiar.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sy.fiar.bean.Notice;
import org.sy.fiar.bean.req.PageReq;
import org.sy.fiar.dao.NoticeMapper;
import org.sy.fiar.service.NoticeService;

import java.util.List;

/**
 * description
 *
 * @author SY
 * @since 2022/8/14 9:37
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticePage(PageReq pageReq) {
        int pageNum = pageReq.getPageNum();
        int pageSize = pageReq.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return noticeMapper.getNoticePage();
    }

    @Override
    public int saveNotice(Notice notice) {
        return noticeMapper.createNotice(notice);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public void deleteNotice(Integer noticeId) {
        noticeMapper.deleteNotice(noticeId);
    }
}
