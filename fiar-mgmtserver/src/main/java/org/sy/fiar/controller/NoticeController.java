package org.sy.fiar.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sy.fiar.bean.Notice;
import org.sy.fiar.bean.req.PageReq;
import org.sy.fiar.bean.resp.BaseResp;
import org.sy.fiar.bean.resp.PageResp;
import org.sy.fiar.pub.utils.PageUtil;
import org.sy.fiar.service.NoticeService;

import java.util.List;

/**
 * 通知类
 *
 * @author SY
 * @since 2022/8/21 21:58
 */
@Api(tags = "公告管理")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    /**
     * 分页查询列表
     *
     * @param pageReq
     * @return
     */
    @ApiOperation(value = "公告列表")
    @PostMapping("/list")
    public BaseResp<Object> listPage(@RequestBody @Valid PageReq pageReq) {
        List<Notice> noticeList = noticeService.getNoticePage(pageReq);
        PageInfo pageInfo = new PageInfo(noticeList);
        PageResp pageResp = PageUtil.getPageResult(pageReq, pageInfo);
        return BaseResp.success(pageResp);
    }

    /**
     * 添加公告
     *
     * @return
     */
    @ApiOperation(value = "添加公告")
    @PostMapping("/create")
    public BaseResp<Object> categoryCreate(@RequestBody @Valid Notice notice) {
        int isStatus = noticeService.saveNotice(notice);
        if (isStatus == 0) {
            return BaseResp.error("添加公告失败");
        }
        return BaseResp.success();
    }

    /**
     * 修改公告
     *
     * @return
     */
    @ApiOperation(value = "修改公告")
    @PostMapping("/update")
    public BaseResp<Object> categoryUpdate(@RequestBody @Valid Notice notice) {
        int isStatus = noticeService.updateNotice(notice);
        if (isStatus == 0) {
            return BaseResp.error("修改公告失败");
        }
        return BaseResp.success();
    }

    /**
     * 删除
     *
     * @return
     */
    @ApiOperation(value = "删除公告")
    @PostMapping("/delete/{id}")
    public BaseResp<Object> categoryDelete(@PathVariable(value = "id") int id) {
        noticeService.deleteNotice(id);
        return BaseResp.success();
    }
}
