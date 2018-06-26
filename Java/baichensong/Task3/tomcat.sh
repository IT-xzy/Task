#!/bin/bash
#This is a test
tomcat_home=/home/ubuntu/usr/tomcat/apache-tomcat-8.5.31
SHUTDOWN=$tomcat_home/bin/shutdown.sh
STARTTOMCAT=$tomcat_home/bin/startup.sh

echo "操作Tomcat"
echo "start|stop|restart"

case $1 in
start)
echo "启动$tomcat_home"
$STARTTOMCAT
;;
stop)
echo "关闭$tomcat_home"
$SHUTDOWN
pidlist=`ps -ef |grep tomcat |grep -v "grep"|awk '{print $2}'`
kill -9 $pidlist

#删除日志文件
rm $tomcat_home/logs/* -rf
#删除tomcat的临时目录
rm $tomcat_home/work/* -rf
;;
restart)
echo "关闭$tomcat_home"
$SHUTDOWN
pidlist=`ps -ef |grep tomcat |grep -v "grep"|awk '{print $2}'`
kill -9 $pidlist

#删除日志文件
rm $tomcat_home/logs/* -rf
#删除tomcat的临时目录
rm $tomcat_home/work/* -rf

sleep 5
echo "启动$tomcat_home"
$STARTTOMCAT
#查看日志
#tail -f $tomcat_home/logs/catalina.out
;;
logs)
cd /mnt/alidata/apache-tomcat-8.5.31/logs

tail -f catalina.out
;;
esac

