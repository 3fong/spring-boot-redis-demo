package com.yonyou.dataserivce.schemaversion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户实体
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-15 16:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchemaVersion implements Serializable {
    private static final long serialVersionUID = 2892248514883451461L;

    public SchemaVersion(String tid, String pid, String sid) {
        this.tid = tid;
        this.pid = pid;
        this.sid = sid;
    }
    /**
     * 租户id
     */
    private String tid;
    /**
     * 项目id
     */
    private String pid;
    /**
     * schemaid
     */
    private String sid;

    /**
     * 版本id
     */
    private String version;
}
