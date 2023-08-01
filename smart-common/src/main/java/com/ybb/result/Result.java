package com.ybb.result;

import com.ybb.constant.HttpRespCodeConstant;
import com.ybb.json.GsonUtil;

import java.io.Serializable;

/**
 * 后端接口统一返回结果封装 VO
 * @param <T> data 类型
 */
public class Result<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public static <T> String success(){
        Result<T> result = new Result<>();
        result.code = HttpRespCodeConstant.HTTP_SUCCESS;
        result.data = null;
        result.msg = null;
        return GsonUtil.get().toJson(result);
    }

    public static <T> String success(T data){
        Result<T> result = new Result<>();
        result.code = HttpRespCodeConstant.HTTP_SUCCESS;
        result.msg = null;
        result.data = data;
        return GsonUtil.get().toJson(result);
    }


    public static <T> String error(String msg){
        Result<T> result = new Result<>();
        result.code = HttpRespCodeConstant.HTTP_FAILED;
        result.msg = msg;
        result.data = null;
        return GsonUtil.get().toJson(result);
    }


}
