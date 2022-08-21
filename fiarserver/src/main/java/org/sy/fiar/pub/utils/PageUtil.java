package org.sy.fiar.pub.utils;

import com.github.pagehelper.PageInfo;
import org.sy.fiar.bean.req.PageReq;
import org.sy.fiar.bean.resp.PageResp;

/**
 * 分页工具类
 *
 * @author SY
 * @since 2022/8/21 22:16
 */
public class PageUtil {
    /**
     * 分页信息封装
     *
     * @param pageReq
     * @param pageInfo
     * @return
     */
    public static PageResp getPageResult(PageReq pageReq, PageInfo<?> pageInfo) {
        PageResp pageResp = new PageResp();
        pageResp.setPageNum(pageInfo.getPageNum());
        pageResp.setPageSize(pageInfo.getPageSize());
        pageResp.setTotalSize(pageInfo.getTotal());
        pageResp.setTotalPages(pageInfo.getPages());
        pageResp.setResult(pageInfo.getList());
        return pageResp;
    }
}
