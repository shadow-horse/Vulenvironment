FROM php:7.0-fpm
MAINTAINER snowsec0 <snowsec0@gmail.com>

RUN apt-get update && apt-get install -y libpng-dev libjpeg-dev \
  && rm -rf /var/lib/apt/lists/* \
  && docker-php-ext-configure gd --with-png-dir=/usr --with-jpeg-dir=/usr \
  && docker-php-ext-install gd mysqli pdo_mysql zip opcache

COPY ./config/php.ini /usr/local/etc/php/conf.d/