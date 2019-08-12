package com.noxus.common.exception;

/**
 * @author sorata
 * @date 2019-08-12 10:33
 */
public class WebArgumentException extends WebAppRuntimeException {

    public WebArgumentException(Integer code, String msg) {
        super(code, msg);
    }
}
