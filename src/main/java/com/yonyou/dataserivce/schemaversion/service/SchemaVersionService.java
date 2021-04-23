package com.yonyou.dataserivce.schemaversion.service;


import com.yonyou.dataserivce.schemaversion.entity.SchemaVersion;

import java.util.List;

/**
 * <p>
 * UserService
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-15 16:45
 */
public interface SchemaVersionService {
    /**
     * 保存或修改版本
     *
     * @param schemaVersion 模型版本
     * @return 操作结果
     */
    SchemaVersion saveOrUpdate(SchemaVersion schemaVersion);

    /**
     * 获取当前版本
     *
     * @param schemaVersion 模型版本
     * @return 返回结果
     */
    SchemaVersion findSchemaVersion(SchemaVersion schemaVersion);

    /**
     * 获取版本列表
     * @param schemaVersion 查询条件
     * @return
     */
    List<String> listSchemaVersion(SchemaVersion schemaVersion);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(String name);
}
