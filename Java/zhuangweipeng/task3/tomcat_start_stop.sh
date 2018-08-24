#!/bin/sh
TOMCAT_PATH=/usr/local/tomcat/tomcat
SHUTDOWN=$TOMCAT_PATH/bin/shutdown.sh
STARTTOMCAT=$TOMCAT_PATH/bin/startup.sh
echo "请输入你要操作的名称：start、stop、restart?"
read aHandler
echo "你输入的操作是：$aHandler!"
case $aHandler in
start)
echo "启动$TOMCAT_PATH"
$STARTTOMCAT
;;
stop)
echo "关闭$TOMCAT_PATH"
$SHUTDOWN
;;
restart)
echo "关闭$TOMCAT_PATH"
$SHUTDOWN
sleep 5
echo "开启$TOMCAT_PATH"
$STARTTOMCAT
;;
*)
echo "没有该操作！请重新运行程序，输入操作指令！"
esac
