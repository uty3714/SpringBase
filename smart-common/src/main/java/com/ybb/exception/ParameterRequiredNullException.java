package com.ybb.exception;

import com.ybb.exception.base.SmartBaseException;

/**
 * 必要参数为空异常
 */
public class ParameterRequiredNullException extends SmartBaseException {
    public ParameterRequiredNullException() {
    }

    public ParameterRequiredNullException(String msg) {
        super(msg);
    }
}
