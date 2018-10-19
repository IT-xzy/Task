#!/bin/bash

nginx_log="/usr/local/nginx/logs/8080_access.log"
jetty_log="/opt/jetty/logs/2018_08_20.jetty.log"

echo -e ""
echo "正在提取项目日志中数据库连接时间..."

cat ${jetty_log} | grep "执行了" > /data/task3/DBex.txt

cat /data/task3/DBex.txt | grep "StudentController" > /data/task3/DB.txt

echo "@成功提取项目日志"

echo "正在提取Nginx日志..."

cat ${nginx_log} |grep "spring_mybatis_2" > /data/task3/nginx.txt

echo "@成功提取nginx日志"

echo "正在定位到/data/task3"

cd /data/task3

echo "再次提取nginx中请求时间..."

echo "@成功提取访问DB时间"
cat nginx.txt | awk '{print " 处理总时间：" $NF}' > requestTime.txt

echo "再次提取项目日志的数据库连接时间..."

echo -e "@成功提取Controller处理时间\n"
cat DB.txt | awk  '{print $NF}' > DBTime.txt



echo " ####开始统计####"

echo "数据库连接时间小于20ms"

cat DBTime.txt | awk  'BEGIN{sum=0}{if($1<20) sum++;}END{print sum "个"}'

echo "数据库连接时间大于20ms小于50ms"

cat DBTime.txt | awk 'BEGIN{sum=0}{if(($1>20)&&($1<50)) sum++;}END{print sum "个"}'

echo "数据库连接时间大于50ms小于100ms"

cat DBTime.txt | awk 'BEGIN{sum=0}{if(($1>50)&&($1<100)) sum++;}END{print sum "个"}'

echo "数据库连接时间大于100ms"

cat DBTime.txt | awk 'BEGIN{sum=0}{if($1>100)sum++;}END{print sum "个"}'

echo "抽取Nginx中的延迟时间"

cat nginx.txt | awk '{print $NF }' > nginxTime.txt

echo "nginx延迟时间小于20ms"

cat nginxTime.txt | awk  'BEGIN{sum=0}{if($1<20/1000) sum++;}END{print sum "个"}'

echo "数据库连接时间大于20ms小于50ms"

cat nginxTime.txt | awk 'BEGIN{sum=0}{if(($1>20/1000)&&($1<50/1000)) sum++;}END{print sum "个"}'

echo "数据库连接时间大于50ms小于100ms"

cat nginxTime.txt | awk 'BEGIN{sum=0}{if(($1>50/1000)&&($1<100/1000)) sum++;}END{print sum "个"}'

echo "数据库连接时间大于100ms"

cat nginxTime.txt | awk 'BEGIN{sum=0}{if($1>100/1000)sum++;}END{print sum "个"}'
