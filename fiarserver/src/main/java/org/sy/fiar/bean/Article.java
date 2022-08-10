package org.sy.fiar.bean;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * 文章Bean
 *
 * @author SY
 * @since 2021/7/7 19:53
 */
@Data
public class Article {

    private Long id;

    private String title;

    private String mdContent;

    private String htmlContent;

    private String summary;

    private Long cid;

    private Long uid;

    private Timestamp publishDate;

    private Integer state;

    private Integer pageView;

    private Timestamp editTime;

    private String[] dynamicTags;

    private String nickname;

    private String cateName;

    private List<Tags> tags;

    private String stateStr;
}
