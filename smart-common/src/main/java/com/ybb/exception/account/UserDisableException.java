package com.ybb.exception.account;

import com.ybb.exception.base.SmartBaseException;

/**
 * 用户已禁用异常
 */
public class UserDisableException extends SmartBaseException {

    public UserDisableException() {
    }

    public UserDisableException(String msg) {
        super(msg);
    }
}
