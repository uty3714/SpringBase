package com.ybb.exception.account;

import com.ybb.exception.base.SmartBaseException;

/**
 * 密码不正确异常
 */
public class PasswordIncorrectException extends SmartBaseException {

    public PasswordIncorrectException() {
    }

    public PasswordIncorrectException(String msg) {
        super(msg);
    }
}
