#!/bin/bash

##Writen by fangguanghui 2018-06-30

#set env
export PATH=$PATH:/bin:/sbin:/usr/bin:/usr/sbin
export LANG=zh_CN.UTF8

#nginx日志
accessLog=/usr/local/nginx/logs/host.access.log
#项目日志
debugLog=/usr/local/tomcat7/webapps/SSM2/logs/debug.log


function Monitor() {
#while :
#do
#nginx日志信息
TopIP=$(awk '{print $1}' "$accessLog" | sort | uniq -c | sort -rn | head -n 5)
TopPage=$(awk '{print $7}' "$accessLog" | sort | uniq -c | sort -rn | head -n 10)
requestTime=$(cat "$accessLog"|awk '{if($NR>20) print $7}'  | sort | uniq -c | sort -rn )
#项目日志信息
DaoTime=$(cat "$debugLog"|grep "dao"|awk '{print $11,$12}'|sort -rn )
ControlTime=$(cat "$debugLog"|grep "controller"|awk '{print $11,$12}'|sort -rn)
#系统日志信息
free_Mem=$(free -m|awk 'NR==2'|awk '{print $4}')
Use_Dev=$(df -hl|awk 'NR==2'|awk '{print $5}')



echo "剩余内存 Free Mem = ${free_Mem} M     使用硬盘 USE% = ${Use_Dev}"
echo ""
echo "Dao层方法响应时间 ms "
echo "${DaoTime}"
echo ""
echo "Controller层接口响应时间 ms"
echo "${ControlTime}"
echo "-----------------------------------------------"
echo "     访问次数前5的IP："
echo "$TopIP"

echo "-----------------------------------------------"
echo ""
echo " 访问次数前十的页面"
echo "$TopPage"
echo "-----------------------------------------------"
echo "请求时间超过10ms页面"
echo "${requestTime}"

#done
}

Monitor
