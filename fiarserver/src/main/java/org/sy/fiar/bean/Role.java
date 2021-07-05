package org.sy.fiar.bean;

/**
 * @Description 角色Bean
 * @Author sy
 * @Date 2021/7/4 19:15
 * @Version 1.0
 */
public class Role {

    private long id;

    private String name;

    public Role() {

    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
