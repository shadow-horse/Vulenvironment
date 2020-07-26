FROM tomcat:8.5.15-jre8
MAINTAINER snowsec0
ENV DIR_WEBAPP /usr/local/tomcat/webapps/
RUN  rm -rf $DIR_WEBAPP/*
COPY shiro.war $DIR_WEBAPP/
CMD ["catalina.sh", "run"]
