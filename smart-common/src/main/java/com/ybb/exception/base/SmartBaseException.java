package com.ybb.exception.base;

/**
 * 业务异常
 */
public class SmartBaseException extends RuntimeException {


    public SmartBaseException(){}

    public SmartBaseException(String msg){
        super(msg);
    }

}
