package org.sy.fiar.bean.req;

import lombok.Data;

/**
 * description
 *
 * @author SY
 * @since 2022/8/10 22:38
 */
@Data
public class PageReq {

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页数据条数
     */
    private int pageSize;
}
