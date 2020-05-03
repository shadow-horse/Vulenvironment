FROM ubuntu:latest
MAINTAINER snowsec0 <snowsec0@gmail.com>
ENV DEBIAN_FRONTEND=noninteractive
#命令分开写可能存在问题，建议update和install合并一行运行
RUN apt-get -o Acquire::Check-Valid-Until=false -o Acquire::Check-Date=false update \
    && apt-get install -y apache2 \
    && apt-get install -y php \
    && apt-get install -y libapache2-mod-php \
    &&  apt-get install -y php-mysqli \
    && apt-get install -y php-fpm \
    && apt-get install -y php-mysql 
    #&& apt-get install -y php-curl \
    #&& apt-get install -y php-json \
    #&& apt-get install -y php-mbstring \
    #&& apt-get install -y php-xml \
    #&& apt-get install -y php-intl \
    #&& apt-get install -y php-odbc \
    #&& apt-get install -y php-cgi \
RUN echo "php_flag display_errors    on" >> /etc/apache2/apache2.conf 
RUN echo "php_value error_reporting  2039" >> /etc/apache2/apache2.conf 
RUN /etc/init.d/apache2 stop 
#RUN rm -rf /var/lib/apt/lists/* 

COPY ./phpMyAdmin /var/www/html/phpMyAdmin/ 
COPY config.inc.php /var/www/html/phpMyAdmin/
COPY phpinfo.php /var/www/html/

ENTRYPOINT [ "apachectl" ]
CMD ["-D", "FOREGROUND"]

