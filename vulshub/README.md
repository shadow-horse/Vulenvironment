## 基于Docker的漏洞运行环境

Docker搭建环境指导：[https://github.com/shadow-horse/Learning-resource/blob/master/Docker/Docker%E6%90%AD%E5%BB%BA%E6%BC%8F%E6%B4%9E%E7%8E%AF%E5%A2%83.md](https://github.com/shadow-horse/Learning-resource/blob/master/Docker/Docker%E6%90%AD%E5%BB%BA%E6%BC%8F%E6%B4%9E%E7%8E%AF%E5%A2%83.md)

### 1. 准备工作 

首先安装Docker和Docker-compose，检查安装是否成功   

### 2.Mysql

Mysql可以作为共用的数据库，在此实例中DVWA和Apache均使用该数据库，不过需要提前运行Mysql服务。  
Mysql的数据采用数据卷的方式挂在本机，实现数据永久驻留。  
【注意】数据库设置的密码和开放的端口

### 3. Apache

该实例以ubuntu镜像为基础，通过命令安装apache2和php7.4，连接Mysql服务。  
【注意】配置Mysql的本机地址和端口，及root账号密码 
	
	http://127.0.0.1:8089/phpMyAdmin/
### 4. DVWA

DVWA漏洞验证环境，该实例基于ubuntu镜像基础，连接Mysql服务。    
【注意】配置Mysql的本机地址和端口，及root账号密码
	
	http://localhost:8082/dvwa/
	#默认登录账号密码
	admin/password
	gordonb/abc123
	1337/charley
	pablo/letmein
	smithy/password
	
### 5. Nginx+Php+Mysql 

该实例为Demo样例，在一个工程中启动多个应用容器，配合使用。  
