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

/**
 * Simple class keeping all the key patterns to avoid the proliferation of
 * Strings through the code.
 * 
 * @author Costin Leau
 */
abstract class KeyUtils {
	static final String SCHEMAVERSIONCURRNT = "svc:";
	static final String SCHEMAVERSIONSET = "svs:";
	static final String TID = "t:";
	static final String PID = "p:";
	static final String SID = "s:";

	static String tid(String tid) {
		return TID + tid;
	}

	static String pid(String pid) {
		return PID + pid;
	}
	static String sid(String sid) {
		return SID + sid;
	}

	public static String schemaVersion() {
		return "schema-version";
	}

	public static String schemaVersionCurrentKey(String tid,String pid,String sid) {
		return SCHEMAVERSIONCURRNT + TID + tid + PID + pid + SID + sid;
	}

	public static String schemaVersionSetKey(String tid,String pid,String sid) {
		return SCHEMAVERSIONSET + TID + tid + PID + pid + SID + sid;
	}

	static String globalTid() {
		return "global:tid";
	}
	static String globalPid() {
		return "global:pid";
	}

	static String globalSid() {
		return "global:sid";
	}
}