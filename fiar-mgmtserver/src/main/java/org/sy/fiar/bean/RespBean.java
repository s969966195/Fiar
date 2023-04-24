package org.sy.fiar.bean;

import lombok.Data;

/**
 * @Description 通用响应体 @Author sy @Date 2021/7/4 19:08 @Version 1.0
 */
@Data
public class RespBean {

    private String status;

    private String msg;

    public RespBean() {
    }

    public RespBean(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RespBean{" + "status='" + status + '\'' + ", msg='" + msg + '\'' + '}';
    }
}
