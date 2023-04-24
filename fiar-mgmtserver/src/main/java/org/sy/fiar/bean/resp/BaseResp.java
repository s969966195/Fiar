package org.sy.fiar.bean.resp;

import java.io.Serializable;

/**
 * description
 *
 * @author SY
 * @since 2022/8/21 22:03
 */
public class BaseResp<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    /**
     * 失败
     */
    public static final int error = 500;

    private int code;
    private String msg;
    private T data;

    public static <T> BaseResp<T> success() {
        return jsonResult(null, SUCCESS, "操作成功");
    }

    public static <T> BaseResp<T> success(T data) {
        return jsonResult(data, SUCCESS, "操作成功");
    }

    public static <T> BaseResp<T> error() {
        return jsonResult(null, error, "操作失败");
    }

    public static <T> BaseResp<T> error(String msg) {
        return jsonResult(null, error, msg);
    }

    public static <T> BaseResp<T> error(T data) {
        return jsonResult(data, error, "操作失败");
    }

    private static <T> BaseResp<T> jsonResult(T data, int code, String msg) {
        BaseResp<T> result = new BaseResp<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
