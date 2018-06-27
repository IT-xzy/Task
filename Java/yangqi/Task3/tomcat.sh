#! /bin/bash
#tomcat 脚本 重启关闭 开启

tomcat_home=/usr/local/tomcat
SHUTDOWN=$tomcat_home/bin/shutdown.sh
STARTTOMCAT=$tomcat_home/bin/startup.sh

case $1 in
start)
echo "启动$tomcat_home"
$STARTTOMCAT
;;
stop)
echo "关闭$tomcat_home"
$SHUTDOWN
pidlist=`ps -ef|grep tomcat |grep -v "grep"|awk '{print $2}'`
kill -9 $pidlist

#删除日志文件
rm $tomcat_home/logs/* -rf
#删除tomcat的临时目录
rm $tomcat_home/work/* -rf
;;
restart)
echo "关闭$tomcat_home"
$SHUTDOWN
pidilist=`ps -ef|grep tomcat |grep -v "grep"|awk '{print $2}'`
kill -9 $pidlist

#删除日志文件
rm $tomcat_home/logs/* -rf
rm $tomcat_home/logs/* -rf
#删除tomcat的临时目录
rm $tomcat_home/work/* -rf

sleep5
echo "启动$tomcat_home"
$STARTTOMCAT
#查看日志
#tail -f $tomcat_home/logs/catalina.out
;;
logs)
cd /usr/local/tomcat/logs

tail -f catalina.out
;;
esac

