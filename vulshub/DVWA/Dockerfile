FROM ubuntu:latest
MAINTAINER snowsec0 <snowsec0@gmail.com>
ENV DEBIAN_FRONTEND=noninteractive
#命令分开写可能存在问题，建议update和install合并一行运行
RUN apt-get -o Acquire::Check-Valid-Until=false -o Acquire::Check-Date=false update \
    && apt-get install -y apache2 \
    && apt-get install -y php7.4 \
    && apt-get install -y libapache2-mod-php \
    &&  apt-get install -y php-mysqli \
    && apt-get install -y php-fpm \
    && apt-get install -y php-mysql 
RUN echo "php_flag display_errors    on" >> /etc/apache2/apache2.conf 
RUN echo "php_value error_reporting  2039" >> /etc/apache2/apache2.conf 
RUN echo "allow_url_fopen = On" >> /etc/php/7.4/apache2/php.ini
RUN echo "allow_url_include = On" >> /etc/php/7.4/apache2/php.ini
RUN echo "extension = gd2" >> /etc/php/7.4/apache2/php.ini
RUN /etc/init.d/apache2 stop 
#RUN rm -rf /var/lib/apt/lists/* 

COPY ./DVWA-master/ /var/www/html/dvwa/ 
COPY config.inc.php /var/www/html/dvwa/config/
RUN chmod 777 /var/www/html/dvwa/hackable/uploads
RUN chmod 777 /var/www/html/dvwa/external/phpids/0.6/lib/IDS/tmp
RUN chmod 777 /var/www/html/dvwa/config
ENTRYPOINT [ "apachectl" ]
CMD ["-D", "FOREGROUND"]

