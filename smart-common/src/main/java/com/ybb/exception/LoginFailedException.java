package com.ybb.exception;

import com.ybb.exception.base.SmartBaseException;

/**
 * 登陆失败异常
 */
public class LoginFailedException extends SmartBaseException {

    public LoginFailedException() {
    }

    public LoginFailedException(String msg) {
        super(msg);
    }
}
