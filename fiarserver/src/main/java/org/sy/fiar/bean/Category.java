package org.sy.fiar.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 分类Bean
 *
 * @author SY
 * @since 2021/7/7 23:27
 */
@Data
public class Category {

    private Long id;

    private String cateName;

    private Timestamp date;

    public Category() {}
}
