package com.ybb.exception.patient;

import com.ybb.exception.base.SmartBaseException;

/**
 * 患者不存在异常
 */
public class PatientNotFoundException extends SmartBaseException {

    public PatientNotFoundException() {
    }

    public PatientNotFoundException(String msg) {
        super(msg);
    }
}
