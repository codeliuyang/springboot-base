package com.lerr.demo.core;

import lombok.Data;

/**
 * -
 *
 * @auther: yangliu
 * create date: 11-06-2019
 */
@Data
public class HttpResult<T> {

    private Integer code;

    private String msg;

    private T data;

    public HttpResult() {
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static HttpResult success(Object data) {
        HttpResult resultUtil = new HttpResult();
        resultUtil.setCode(0);
        resultUtil.setMsg("请求处理成功");
        resultUtil.setData(data);
        return resultUtil;
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static HttpResult success(Object data, String msg) {
        HttpResult resultUtil = new HttpResult();
        resultUtil.setCode(0);
        resultUtil.setMsg(msg);
        resultUtil.setData(data);
        return resultUtil;
    }

    /**
     * 成功
     *
     * @return
     */
    public static HttpResult success() {
        HttpResult resultUtil = new HttpResult();
        resultUtil.setCode(0);
        return resultUtil;
    }

    /**
     * 错误返回
     *
     * @param resultEnum
     * @return
     */
    public static HttpResult error(HttpResult resultEnum) {
        HttpResult resultUtil = new HttpResult();
        resultUtil.setCode(resultEnum.getCode());
        resultUtil.setMsg(resultEnum.getMsg());
        return resultUtil;
    }

    /**
     * 返回失败
     *
     * @param msg
     * @return
     */
    public static HttpResult error(String msg) {
        HttpResult resultUtil = new HttpResult();
        resultUtil.setCode(-1);
        resultUtil.setMsg(msg);
        return resultUtil;
    }

}
