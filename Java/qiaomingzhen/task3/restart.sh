#!/bin/bash
echo "输入参数（tomcat、jetty）"
read a

start(){
if [ -n "$a" ] ; then
case $a in
tomcat)
echo "start tomcat"
startup.sh
;;
jetty)
echo "start jetty"
cd /SSM/jetty
sh start.sh
;;
esac
else
echo "参数不足，start失败"
fi
}

stop(){
if [ -n "$a" ] ; then
case $a in
tomcat)

PID=`ps aux | grep tomcat | grep java |awk '{print $2}'`
if [ in "$PID" ] ; then
shutdown.sh
echo "tomcat stop"
sleep 6
else echo "NO tomcat runing"
fi
PID2=`ps aux | grep tomcat | grep java | awk '{print $2}'`
if [ in "$PID2" ] ; then
kill -9 $PID2
echo "kill $PID2"
else
echo "NO tomcat PID"
fi


;;
jetty)
echo "stop jetty"
pidlist=`ps -ef | grep start.jar |grep -v "grep" | awk '{print $2}'`
if [ -n $pidlist ] ; then
for pid in ${pidlist}
do
kill -9 $pid
done
fi
;;
esac
else
echo "参数不足，start失败"
fi
}


#执行
echo "请输入参数（start、stop、restart）:"
read b
if [ -n "$b" ] ; then
case $b in
start)
start
;;

stop)
stop
;;
restart)
stop
start
;;
esac
else
echo "参数不足"
fi
