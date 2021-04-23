package com.yonyou.dataserivce.schemaversion.controller;

import com.yonyou.dataserivce.schemaversion.entity.SchemaVersion;
import com.yonyou.dataserivce.schemaversion.service.SchemaVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liulei
 * @Description 用户控制器
 * @create 2021/4/23 10:33
 */
@RestController
@RequestMapping("schemaversion")
public class SchemaVersionController {

    @Autowired
    private SchemaVersionService schemaVersionService;

    /**
     * 编辑模型版本
     * @param schemaVersion
     * @return
     */
    @PostMapping("saveorupdate")
    public SchemaVersion saveOrUpdate(@RequestBody SchemaVersion schemaVersion){
        return schemaVersionService.saveOrUpdate(schemaVersion);
    }

    /**
     * 查询在用版本
     * @param schemaVersion
     * @return
     */
    @PostMapping("find")
    public SchemaVersion findSchemaVersion(@RequestBody SchemaVersion schemaVersion){
        return schemaVersionService.findSchemaVersion(schemaVersion);
    }

    /**
     * 获取模型版本列表
     * @param schemaVersion
     * @return
     */
    @PostMapping("list")
    public List<String> listSchemaVersion(@RequestBody SchemaVersion schemaVersion){
        return schemaVersionService.listSchemaVersion(schemaVersion);
    }
}
