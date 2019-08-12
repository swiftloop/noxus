package com.noxus.common.exception;

/**
 * @author sorata
 * @date 2019-08-12 10:34
 */
public class ApiException extends WebAppRuntimeException {

    public ApiException(Integer code, String msg) {
        super(code, msg);
    }
}
