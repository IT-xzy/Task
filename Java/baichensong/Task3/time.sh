#!/bin/bash

#nginx 的日志路径
LogNginx=/usr/local/nginx/logs/bai.shiyingjie.access.log
#tomcat 的日志路径
LogTomcat=/home/ubuntu/usr/tomcat/apache-tomcat-8.5.31/webapps/SSM/logs/app.log
echo "添加n---查看Nginx统计"
echo "添加T----查看后端统计"

function n(){
echo "访问次数前十的ip"
awk '{print $1}' "$LogNginx"|sort |uniq -c |sort -rn |head -n 10

#查看访问最频繁的5个页面
echo "访问最平最频繁的5个页面"
awk '{print $7}' "$LogNginx" |sort |uniq -c |sort -rn |head -n 5

echo "当前访问的Url"
cat "$LogNginx"|tail -n 2 |awk '{print $7}'

echo "根据ip 统计访问量"
awk '{print $1}' "$LogNginx" |sort |uniq -c |wc -l

echo "按时间段儿统计ip访问量"
grep "25/May/2018:0[4-9]" "$LogNginx" |awk '{print $1}' |sort |uniq -c |sort -rn |wc -l
echo -e "\n"

echo " 页面访问超过3ms的 网址统计前 10 个"
cat "$LogNginx" |awk '($NF>0.003){print $7}' |sort |uniq -c |sort -rn |head -n 10
echo -e "\n"
}



function T(){
echo "Controller方法耗时的统计"
grep "Controller方法执行耗时" "$LogTomcat" |awk '{print $10,$(NF-1),$NF}' |sort -k 11 |head -n 10
echo -e "\n"

 echo "Service方法执行时间"
grep "DB执行耗时" "$LogTomcat" |awk '{print $(NF-1),$NF," ",$10}' | sort -rn|head -n 10
echo -e "\n"
}
#$1 获取用户 输入的第一个命令 
case $1 in
n)
n
;;
T)
T
;;
*)
echo "请加命令"
#结束
esac
