package com.minghui.common.framework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname:Result
 * @Auther:chenqinglin
 * @Date:2018/12/13 20:47
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 3185635969819089926L;

    private T datas;

    private Integer respCode;

    private String respMsg;

    public static <T> Result<T> succeed(String msg) {
        return succeedWith(null, ResultCode.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> succeed(T model, String msg) {
        return succeedWith(model, ResultCode.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> succeedWith(T datas, Integer code, String msg) {
        return new Result<T>(datas, code, msg);
    }

    public static <T> Result<T> failed(String msg) {
        return failedWith(null, ResultCode.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failed(T model, String msg) {
        return failedWith(model, ResultCode.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failedWith(T datas, Integer code, String msg) {
        return new Result<T>( datas, code, msg);
    }
}
