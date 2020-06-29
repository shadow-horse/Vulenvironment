FROM tomcat
MAINTAINER yuanjunhu/11087568
ENV DIR_WEBAPP /usr/local/tomcat/webapps/
RUN  rm -rf $DIR_WEBAPP/*
COPY fastjson68.war $DIR_WEBAPP/
CMD ["catalina.sh", "run"]