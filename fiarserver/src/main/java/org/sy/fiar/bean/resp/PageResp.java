package org.sy.fiar.bean.resp;

import lombok.Data;

/**
 * description
 *
 * @author SY
 * @since 2022/8/10 22:41
 */
@Data
public class PageResp {

    /** 当前页码 */
    private int pageNum;

    /** 每页数量 */
    private int pageSize;

    /** 总条数 */
    private int totalSize;

    /** 总页数 */
    private int totalPages;
}
