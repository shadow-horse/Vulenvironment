FROM tomcat
MAINTAINER snowsec0/xxxx
ENV DIR_WEBAPP /usr/local/tomcat/webapps/
RUN  rm -rf $DIR_WEBAPP/*
COPY fastjson68.war $DIR_WEBAPP/
CMD ["catalina.sh", "run"]
