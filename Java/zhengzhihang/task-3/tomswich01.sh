#!/bin/bash
# Description : start or stop tomcat

case "$1" in 
start)
cd /usr/tomcat/tomcat01/bin
./startup.sh
echo "tomcat start"
;; #;;表示结束该模式
stop)
cd /usr/tomcat/tomcat01/bin
./shutdown.sh
echo "tomcat stop"
;;
restart)
cd /usr/tomcat/tomcat01/bin
./shutdown.sh
echo "tomcat stop"
./startup.sh
;;
*)#捕获剩余模式
echo "tomcat:usger: tomcat01[start|stop|restart]"
exit 1
esac
exit 0
