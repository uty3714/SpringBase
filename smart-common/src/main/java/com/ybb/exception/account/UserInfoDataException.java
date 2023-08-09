package com.ybb.exception.account;

import com.ybb.exception.base.SmartBaseException;

/**
 * 用户数据异常
 */
public class UserInfoDataException extends SmartBaseException {

    public UserInfoDataException() {
    }

    public UserInfoDataException(String msg) {
        super(msg);
    }
}
