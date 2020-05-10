FROM ubuntu:16.04
MAINTAINER snowsec0 <snowsec0@gmail.com>
ENV DEBIAN_FRONTEND=noninteractive
#更新yum源
RUN mv /etc/apt/sources.list /etc/apt/sources.list.bak
COPY sources.list /etc/apt/
#命令分开写可能存在问题，建议update和install合并一行运行
#RUN apt-get clean && apt-get -o Acquire::Check-Valid-Until=false -o Acquire::Check-Date=false update --fix-missing \
RUN apt-get update
RUN apt-get install -y vim \
    && apt-get install -y wget \
    && apt-get install -y gnupg 
RUN wget -O - https://repo.saltstack.com/apt/ubuntu/16.04/amd64/2019.2/SALTSTACK-GPG-KEY.pub |  apt-key add -
COPY saltstack.list /etc/apt/sources.list.d/

RUN apt-get update \
	&& apt-get install -y salt-master \
	&& apt-get install -y salt-minion \
	&& apt-get install -y salt-ssh \
	&& apt-get install -y salt-syndic \
	&& apt-get install -y salt-cloud \
	&& apt-get install -y salt-api

#RUN rm -rf /var/lib/apt/lists/* 

#ENTRYPOINT [ "apachectl" ]
#CMD ["-D", "FOREGROUND"]

