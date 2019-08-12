package com.noxus.web.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sorata
 * @date 2019-07-23 17:29
 */
@Data
public class ResultData<T> {

    private ResultData() {
    }

    private static final ResultData OK = new ResultData<>(true, 200, null, "ok");
    private static final ResultData ERROR = new ResultData<>(false, 500, null, "err");

    private Integer code;

    private String message;

    private T data;

    private boolean success;

    private ResultData(boolean success, Integer code, T data, String message) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
    }


    public static <T> ResultData<T> ok(Integer code, T data, String message) {
        return new ResultData<>(true, code, data, message);
    }

    public static <T> ResultData<T> okMsg(T data, String message) {
        return new ResultData<>(true, 200, data, message);
    }

    public static <T> ResultData<T> ok(Integer code, T data) {
        return new ResultData<>(true, code, data, "ok");
    }

    public static <T> ResultData<T> ok(T data) {
        return new ResultData<>(true, 200, data, "ok");
    }

    public static ResultData ok() {
        return OK;
    }

    public static <T> ResultData<T> okMsg(String message) {
        return new ResultData<>(true, 200, null, message);
    }

    public static <T> ResultData<T> err(Integer code, T data, String message) {
        return new ResultData<>(false, code, data, message);
    }

    public static <T> ResultData<T> err(Integer code, String message) {
        return new ResultData<>(false, code, null, message);
    }

    public static <T> ResultData<T> err(String message) {
        return new ResultData<>(false, 500, null, message);
    }

    public static ResultData err() {
        return ERROR;
    }


    @SuppressWarnings("unchecked")
    public ResultData unwarp(Warp warp) {
        ResultData resultData = create(this);
        if (warp != null) {
            warp.apply((Map<String, Object>) resultData.getData());
        }
        return resultData;
    }

    public static ResultData ok(Integer code, Warp warp) {
        HashMap<String, Object> map = new HashMap<>(8);
        if (warp != null) {
            warp.apply(map);
        }
        return ok(code, map);
    }


    private static ResultData create(ResultData resultData) {
        HashMap<String, Object> map = new HashMap<>(8);
        if (resultData.getData() != null) {
            map.put("origin", resultData.getData());
        }
        return new ResultData<>(resultData.isSuccess(), resultData.getCode(),
                map, resultData.message);
    }

    @FunctionalInterface
    public interface Warp {
        /**
         * 对map进行扩展或者移除数据
         *
         * @param map 操作的map
         */
        void apply(Map<String, Object> map);
    }

}
