#!/bin/bash    
tomcat_home=/usr/local/tomcat
SHUTDOWN=$tomcat_home/bin/shutdown.sh  
STARTTOMCAT=$tomcat_home/bin/startup.sh  

case $1 in
start)
echo "启动$tomcat_home"
$STARTTOMCAT
;;
stop)
echo "关闭  $tomcat_home"

PID=`ps aux | grep $tomcat_home |grep java | awk '{print $2}'`

if [ -n "$PID" ]; then
	echo "will kill tomcat:$PID"
	sh "$tomcat_home/shutdown.sh"
	sleep 6
else echo "No Tomcat Process $PID"
fi

PID2=`ps aux | grep $tomcat_home | grep java |awk '{print $2}'`

if [ -n "$PID2" ]; then
	kill -9 $PID2
	echo "Try to kill $PID2"
else echo "No Tomcat Process $PID2"
fi
;;
restart)
echo "关闭$tomcat_home"
$SHUTDOWN
pidlist=`ps aux | grep $tomcat_home | grep java |awk '{print $2}'`
kill -9 $pidlist
  
#删除日志文件，如果你不先删除可以不要下面一行
#rm  $tomcat_home/logs/* -rf
#删除tomcat的临时目录
rm  $tomcat_home/work/* -rf

sleep 5
echo "启动$tomcat_home"
$STARTTOMCAT
#看启动日志
tail -f $tomcat_home/logs/catalina.out
;;
esac