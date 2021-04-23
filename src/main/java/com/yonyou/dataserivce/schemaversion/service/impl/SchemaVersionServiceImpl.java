package com.yonyou.dataserivce.schemaversion.service.impl;

import com.yonyou.dataserivce.schemaversion.constance.CommonParam;
import com.yonyou.dataserivce.schemaversion.dao.SchemaVersionRepository;
import com.yonyou.dataserivce.schemaversion.entity.SchemaVersion;
import com.yonyou.dataserivce.schemaversion.service.SchemaVersionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * UserService
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-15 16:45
 */
@Service
@Slf4j
public class SchemaVersionServiceImpl implements SchemaVersionService {
    @Autowired
    private SchemaVersionRepository schemaVersionRepository;

    /**
     * 保存或修改用户
     *
     * @param schemaVersion 用户对象
     * @return 操作结果
     */
//    @CachePut(value = "user", key = "#user.id")
    @Override
    public SchemaVersion saveOrUpdate(SchemaVersion schemaVersion) {
        String schemaVer = schemaVersionRepository.addSchemaVersion(schemaVersion);
        log.info("保存用户【user】= {}", schemaVer);
        return schemaVersion;
    }

    /**
     * 删除
     * @param schemaVersion
     */
//    @CacheEvict(value = "user", key = "#id")
    @Override
    public SchemaVersion findSchemaVersion(SchemaVersion schemaVersion) {
        return schemaVersionRepository.findSchemaVersion(schemaVersion);
    }

    @Override
    public List<String> listSchemaVersion(SchemaVersion schemaVersion) {
        return schemaVersionRepository.listSchemaVersion(schemaVersion);
    }

    /**
     * 删除
     *
     * @param
     */
//    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(String name) {
//        userRepository.deleteUser(name);
        log.info("删除用户【name】= {}", name);
    }
}
