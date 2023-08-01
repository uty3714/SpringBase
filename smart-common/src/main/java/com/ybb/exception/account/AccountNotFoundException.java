package com.ybb.exception.account;

import com.ybb.exception.base.SmartBaseException;

/**
 * 账号不存在异常
 */
public class AccountNotFoundException extends SmartBaseException {

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
