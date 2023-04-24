package org.sy.fiar.bean;

import lombok.Data;

/**
 * @Description 角色Bean @Author sy @Date 2021/7/4 19:15 @Version 1.0
 */
@Data
public class Role {

    private long id;

    private String name;

    public Role() {
    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
