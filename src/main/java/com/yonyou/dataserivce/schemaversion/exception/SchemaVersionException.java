package com.yonyou.dataserivce.schemaversion.exception;

/**
 * @author liulei
 * @Description 模型版本异常
 * @create 2021/4/23 16:45
 */
public class SchemaVersionException extends Exception {

    public SchemaVersionException() {

    }

    public SchemaVersionException(String message) {
        super(message);
    }
}
