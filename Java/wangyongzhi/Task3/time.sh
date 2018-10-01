#!/bin/bash
#设置脚本环境变量，方便操作
LOG=/usr/local/nginx/logs/tomcat.access.log

#统计所有操作数，一行算一个操作
echo 所有的操作数是------------
cat tomcat.access.log | wc -l

#统计访问主页次数
echo 访问主页次数为------------
grep -o 'GET /Task2/ HTTP/1.1" 200' tomcat.access.log | wc -l


#统计访问主页次数方法二
echo 访问主页次数为------------
cat tomcat.access.log | grep -c 'GET /Task2/ HTTP/1.1" 200'

#统计访问相应延迟
echo 最近100次访问相应延时-----
tail -n 100 tomcat.access.log | awk '{print $1}'

#按时间分布统计响应时间
echo 最近100次访问响应时间分布---
echo 响应时间在0.01秒以内
tail -n 100 ${LOG} | awk 'BEGIN{sum=0}{if($1<=0.01)sum++;}END{print sum}'

echo 响应时间在0.01到0.02秒之间
tail -n 100 ${LOG} | awk 'BEGIN{sum=0}{if(($1>0.01)&&($1<0.02))sum++;}END{print sum}'

echo 响应时间在0.02秒以上
tail -n 100 ${LOG} | awk 'BEGIN{sum=0}{if($1>0.02)sum++;}END{print sum}'


