package org.sy.fiar.bean;

import java.sql.Timestamp;

/**
 * 分类Bean
 *
 * @author SY
 * @since 2021/7/7 23:27
 */
public class Category {

    private Long id;

    private String cateName;

    private Timestamp date;

    public Category() {
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

}
