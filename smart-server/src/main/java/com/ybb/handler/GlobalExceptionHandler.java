package com.ybb.handler;

import com.ybb.exception.base.SmartBaseException;
import com.ybb.result.Result;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SmartBaseException.class)
    public String exceptionHandler(SmartBaseException ex){
        log.info("全局捕获业务异常: {}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    @ExceptionHandler
    public String exceptionHandler(SQLException ex){
        log.info("全局捕获Sql异常: {}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    @ExceptionHandler
    public String exceptionHandler(SignatureException ex){
        log.info("全局捕获jwt异常: {}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    //..

}
