## Fastjson漏洞验证环境 

### fastjson 1.2.68 autotype bypass 反序列化漏洞 

[https://zhzhdoai.github.io/2020/05/16/fastjson-1-2-68-%E7%BB%95%E8%BF%87autotype-%E6%9C%89%E9%99%90%E5%88%B6/](https://zhzhdoai.github.io/2020/05/16/fastjson-1-2-68-%E7%BB%95%E8%BF%87autotype-%E6%9C%89%E9%99%90%E5%88%B6/)   

[https://github.com/iSafeBlue/fastjson-autotype-bypass-demo](https://github.com/iSafeBlue/fastjson-autotype-bypass-demo)  

[https://b1ue.cn/archives/382.html](https://b1ue.cn/archives/382.html)

http://127.0.0.1:8080/   


### Spring boot项目打包WAR部署至Tomcat  

本示例代码基于Spring-boot编写，在部署时需要将maven等依赖全部打包。打包成JAR格式，会发现缺少依赖（需要查阅配置如何引入依赖），在此将以WAR包的格式打包发布。  

#### 1. 配置打WAR包格式
在pom.xml的<packaging>标签中进行配置：  


	<groupId>com.snowsec0</groupId>
    <artifactId>fastjson68</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>war</packaging>
    <name>fastjson68</name>
   <description>fastjson68</description>

#### 2. 发布至Tomcat运行的WAR包注释内置Tomcat
在项目本地运行时，可以采用内置的Tomcat，直接运行程序Run as java application,但是当需要部署至Tomcat时需要注释掉内置的Tomcat。  

  
 	<!-- WAR包部署Tomcat需要移除
 	<dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-tomcat</artifactId>
  	<scope>provided</scope>
 	</dependency> 
 	-->  

#### 3. 发布至Tomcat运行WAR需要修改启动类
修改启动类继承SpringBootServletInitializer：  

 	@SpringBootApplication
 	public class App extends SpringBootServletInitializer {

   	@Override
      protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
          return application.sources(App.class);
      }
  
  	public static void main(String[] args) {
   		SpringApplication.run(App.class, args);
  	}
 	}


#### 4. 配置maven clean package 包

通过eclipse导出的WAR包是无法部署在Tomcat中的，必须通过maven package： 

 Run Configurations 
 Maven Build
 Base directory: workspace选中项目  
 Goals:clean package 
 
 点击run，运行生成打包文件

以上步骤主要是解决springboot打包成War，部署到tomcat无法访问的问题 

#### 5. tomcat启动报错 java.util.zip.ZipException: invalid LOC header (bad signature)

此类问题，网上说是maven引入的jar缺失，无法定位具体的jar文件时，可以删除所有maven引入的仓库文件，重新maven update project.