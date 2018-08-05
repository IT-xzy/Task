#!/bin/bash
tomcat_home=/var/tomcat-8.5.32
SHUTDOWN=$tomcat_home/bin/shutdown.sh
STARTTOMCAT=$tomcat_home/bin/startup.sh
 
JETTY_HOME=/usr/local/jetty
RESIN_HOME=/usr/local/resin
NGINX_HOME=/usr/local/nginx
LOG_HOME=$NGINX_HOME/logs

JETTY_SH=$JETTY_HOME/bin/jetty.sh
RESIN_SH=$RESIN_HOME/bin/resin.sh
NGINX_SH=$NGINX_HOME/sbin/nginx
LOG_SH=$LOG_HOME/log.sh

case $1 in

#Nginx
startNginx)
echo 启动Nginx
$NGINX_SH
;;

stopNginx)
echo 关闭Nginx
"$NGINX_SH" -s stop 
;;

restartNginx)
echo 重启Nginx
"$NGINX_SH" -s stop 
$NGINX_SH
;;

#Tomcat
startTomcat)
echo "启动tomcat"
$STARTTOMCAT
;;
stopTomcat)
echo "关闭tomcat"
$SHUTDOWN
;;
restartTomcat)
echo "重启tomcat"
$SHUTDOWN
pidlist=`ps -ef |grep tomcat  |grep -v "grep"|awk '{print $2}'`
kill -9 $pidlist
sleep 5
echo "启动$tomcat_home"
$STARTTOMCAT
;;

#Jetty
startJetty)
echo 启动Jetty
"$JETTY_SH" start "$@"
;;

stopJetty)
echo 关闭Jetty
"$JETTY_SH" stop "$@"
;;

restartJetty)
echo 重启Jetty
"$JETTY_SH" stop "$@"
"$JETTY_SH" start "$@"
;;

#Resin
startResin)
echo 启动Resin
"$RESIN_SH" start 
;;

stopResin)
echo 关闭Resin
"$RESIN_SH" stop 
;;

restartResin)
echo 重启resin
"$RESIN_SH" restart 
;;

startAll)
echo 启动所有
echo "启动tomcat"
$STARTTOMCAT
echo 启动Jetty
"$JETTY_SH" start "$@"
echo 启动Resin
"$RESIN_SH" start 
;;

stopAll)
echo 关闭所有
echo "关闭tomcat"
$SHUTDOWN
echo 关闭Jetty
"$JETTY_SH" stop "$@"
echo 关闭Resin
"$RESIN_SH" stop 
;;

restartAll)
echo 重启所有
echo "重启tomcat"
$SHUTDOWN
pidlist=`ps -ef |grep tomcat  |grep -v "grep"|awk '{print $2}'`
kill -9 $pidlist
sleep 5
echo "启动$tomcat_home"
$STARTTOMCAT
echo 重启Jetty
"$JETTY_SH" stop "$@"
"$JETTY_SH" start "$@"
echo 重启resin
"$RESIN_SH" restart 
;;

#日志
log)
echo 查看访问日志
$LOG_SH
;;

deleteLog)
echo 清空访问日志
cat /dev/null >$LOG_HOME/AOP.log 
cat /dev/null >$LOG_HOME/host.access.log

esac

