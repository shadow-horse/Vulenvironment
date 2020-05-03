FROM ubuntu:latest
MAINTAINER snowsec0 <snowsec0@gmail.com>
ENV DEBIAN_FRONTEND=noninteractive
#命令分开写可能存在问题，建议update和install合并一行运行
RUN apt-get -o Acquire::Check-Valid-Until=false -o Acquire::Check-Date=false update \
    && apt-get install -y apache2 \
    && apt-get install -y php \
    && apt-get install -y libapache2-mod-php \
    &&  apt-get install -y php-mysqli \
    && apt-get install -y php-fpm php-mysql php-curl php-json php-mbstring php-xml  php-intl php-odbc php-cgi \
    && apt-get install -y vim 
RUN echo "php_flag display_errors    on" >> /etc/apache2/apache2.conf 
RUN echo "php_value error_reporting  2039" >> /etc/apache2/apache2.conf 
RUN /etc/init.d/apache2 restart 
RUN rm -rf /var/lib/apt/lists/* 

COPY ./phpMyAdmin /var/www/html/ 
COPY config.inc.php /var/www/html/phpMyAdmin/
COPY phpinfo.php /var/www/html/
#配置DVWA
ADD ../DVWA/DVWA-master.zip /var/www/html/
COPY ../DVWA/config.inc.php /var/www/html/DVWA-master/config/