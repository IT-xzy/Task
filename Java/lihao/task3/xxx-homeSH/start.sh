#!/bin/bash

echo "开始脚本启动jetty/tomcat================>>>>>>>>>>>>>>>>"

function START_JETTY() {
    sh /opt/jetty/bin/jetty.sh start
}

function STOP_JETTY() {
    sh /opt/jetty/bin/jetty.sh stop
}

function START_TOMCAT() {
    sh /usr/local/tomcat9/bin/startup.sh
}

function STOP_TOMCAT() {
    sh /usr/local/tomcat9/bin/shutdown.sh
}

function DEPLOY_SERVER() {
    
case $key1 in

a)case $key2 in

1)
    echo "正在启动服务器组..."

  START_JETTY
  START_TOMCAT

    echo "已启动服务器组" ;;

2)
    echo "正在关闭服务器组..."

  STOP_JETTY
  STOP_TOMCAT

    echo "已关闭服务器组, 目前开始重启服务器组..."

  START_JETTY
  START_TOMCAT

    echo "已重启服务器组" ;;

3)
    echo "正在关闭服务器组..."

  STOP_JETTY
  STOP_TOMCAT

    echo "已关闭服务器组" ;;

esac

;;

j)case $key2 in

1)
    echo "正在启动jetty服务器..."

  START_JETTY

    echo "已启动jetty服务器" ;;

2)
    echo "正在关闭jetty服务..."

  STOP_JETTY

    echo "已关闭jetty, 目前开始重启jetty服务..."

  START_JETTY

    echo "已重启jetty服务器" ;;

3)
    echo "正在关闭jetty服务器..."

  STOP_JETTY

    echo "已关闭jetty服务器" ;;

esac

;;

t)case $key2 in

1)
    echo "正在启动tomcat服务器..."

  START_TOMCAT

    echo "已启动tomcat服务器" ;;

2)
    echo "正在关闭tomcat服务..."

  STOP_TOMCAT

    echo "已关闭tomcat, 目前开始重启tomcat服务..."

  START_TOMCAT

    echo "已重启tomcat服务器" ;;

3)
    echo "正在关闭tomcat服务器..."

  STOP_TOMCAT

    echo "已关闭tomcat服务器" ;;

esac

;;

esac

}

if [ ! $2 ]

then

read -p "请选择控制项目   a: 全部    j:Jetty   t:Tomcat :" key1

read -p "请选择控制操作   1: 启动    2:重启     3:停止   :" key2

DEPLOY_SERVER $key1 $key2

else

key1=$1

key2=$2

DEPLOY_SERVER $key1 $key2

fi