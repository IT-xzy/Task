# !/bin/bash

#nignx的日志
LogNginx=/usr/local/nginx/logs/lixiaobai.xin.log
#tomcat的日志
LogTomcat=/usr/local/tomcat/webapps/Tiles/logs/controller/info-log.log
echo "添加n-----查看nginx统计"
echo "添加T-----查看后端统计"

function n(){
echo "访问次数前十的ip"
awk '{print $1}' "$LogNginx" |sort |uniq -c |sort -rn |head -n 10

#查看访问最频繁的五个页面
echo "访问最频繁的5个页面"
awk '{print $7}' "$LogNginx" |sort |uniq -c |sort -rn |head -n 5

echo "当前访问的Url"
cat "$LogNginx" | tail -n 2| awk '{print $7}'

echo "根据ip 统计访问量"
awk '{print $1}' "$LogNginx" |sort |uniq -c |wc -l

echo "按时间段统计ip访问量"
grep "5/six/2018:0[4-9]" "$LogNginx" | awk '{print $1}' |sort |uniq -c | sort -rn |wc -l
echo -e "\n"

echo "页面访问超过3ms的网址统计前十"
cat "$LogNginx" |awk '($NF>0.0003){print $7}' |sort |uniq -c |sort -rn |head -n 10 
echo -e "\n"
}





function T(){

echo "Controller方法耗时的统计"
grep "Controller方法执行耗时" "$LogTomcat" | awk '{print $10,$(NF-1),$NF}' | sort -k 11 |head -n 10
echo -e "\n"

echo "Service方法执行时间"
grep "DB执行耗时" "$LogTomcat" | awk '{print $(NF-1),$NF,"",$10}' | sort -rn | head -n 10
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

