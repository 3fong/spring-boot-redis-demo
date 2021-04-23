package com.yonyou.dataserivce.schemaversion.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author liulei
 * @Description 统一异常处理
 * @create 2021/4/23 16:46
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    public SchemaVersionException handlerException(Exception e){
        return new SchemaVersionException(e.getMessage());
    }
}
