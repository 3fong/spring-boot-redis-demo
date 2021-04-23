package com.yonyou.dataserivce.schemaversion;

import com.yonyou.dataserivce.schemaversion.entity.SchemaVersion;
import com.yonyou.dataserivce.schemaversion.service.SchemaVersionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchemaVersionApplicationTests {

    @Autowired
    private SchemaVersionService schemaVersionService;

    @Test
    void saveTest() {
        System.out.println(schemaVersionService.saveOrUpdate(new SchemaVersion("1","1","1")));
    }

    @Test
    void findTest() {
        System.out.println(schemaVersionService.findSchemaVersion(new SchemaVersion("1","1","1")));
    }

    @Test
    void listTest() {
        System.out.println(schemaVersionService.listSchemaVersion(new SchemaVersion("1","1","1")));
    }
}
