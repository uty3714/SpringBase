package com.ybb.exception.account;

import com.ybb.exception.base.SmartBaseException;

/**
 * 用户token解析异常
 */
public class UserTokenParseException extends SmartBaseException {

    public UserTokenParseException() {
    }

    public UserTokenParseException(String msg) {
        super(msg);
    }
}
