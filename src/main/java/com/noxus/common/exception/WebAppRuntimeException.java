package com.noxus.common.exception;

/**
 * @author sorata
 * @date 2019-08-12 10:30
 */
public class WebAppRuntimeException extends RuntimeException {

    private String msg;

    private Integer code;

    public WebAppRuntimeException(Integer code,String msg){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
