/*
 * Copyright 2011 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      https://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yonyou.dataserivce.schemaversion.dao;

import com.yonyou.dataserivce.schemaversion.constance.CommonParam;
import com.yonyou.dataserivce.schemaversion.entity.SchemaVersion;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.hash.BeanUtilsHashMapper;
import org.springframework.data.redis.hash.DecoratingStringHashMapper;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository
public class SchemaVersionRepository {

	private final StringRedisTemplate template;
	private final HashOperations<String, String, String> hashOps;
	private final SetOperations<String, String> setOps;
	private final RedisAtomicLong schemaVersionIdCounter;

	private final HashMapper<SchemaVersion, String, String> postMapper = new DecoratingStringHashMapper<>(
			new BeanUtilsHashMapper<>(SchemaVersion.class));

	public SchemaVersionRepository(StringRedisTemplate template) {
		this.template = template;
		hashOps = template.opsForHash();
		setOps = template.opsForSet();
		schemaVersionIdCounter = new RedisAtomicLong(KeyUtils.globalSid(), template.getConnectionFactory());
	}

	public String addSchemaVersion(SchemaVersion schemaVersion) {
		String version = StringUtils.isEmpty(schemaVersion.getVersion()) ?
				String.valueOf(schemaVersionIdCounter.incrementAndGet()): schemaVersion.getVersion();
		schemaVersion.setVersion(version);
		hashOps.putAll(KeyUtils.schemaVersionCurrentKey(
				schemaVersion.getTid(),schemaVersion.getPid(),schemaVersion.getSid()),postMapper.toHash(schemaVersion));
		setOps.add(KeyUtils.schemaVersionSetKey(
				schemaVersion.getTid(),schemaVersion.getPid(),schemaVersion.getSid()),version);
		return schemaVersion.toString();
	}

	public SchemaVersion findSchemaVersion(SchemaVersion schemaVersion) {
		return postMapper.fromHash(hashOps.entries(KeyUtils.schemaVersionCurrentKey(
				schemaVersion.getTid(),schemaVersion.getPid(),schemaVersion.getSid())));
	}

	public List<String> listSchemaVersion(SchemaVersion schemaVersion) {
		return new ArrayList<>(setOps.members(KeyUtils.schemaVersionSetKey(
				schemaVersion.getTid(),schemaVersion.getPid(),schemaVersion.getSid())));
	}
}