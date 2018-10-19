#!/bin/bash

ST() {
     sh /usr/local/apache-tomcat-9.0.10/bin/startup.sh 
} 

SJ() {
     sh /usr/local/jetty-distribution-9.4.11/bin/jetty.sh start 
} 

CT() { 
    sh /usr/local/apache-tomcat-9.0.10/bin/shutdown.sh 
} 

CJ() { 
    sh /usr/local/jetty-distribution-9.4.11/bin/jetty.sh stop 
} 

TD() {

case $key1 in

a)case $key2 in

1)ST SJ

  echo "已启动服务器组" ;;

2)CT CJ ST SJ

  echo "已重启服务器组" ;;

3)CT CJ

  echo "已关闭服务器组" ;;

esac

;;

j)case $key2 in

1)SJ

  echo "已启动服务器" ;;

2)CJ SJ

  echo "已重启服务器" ;;

3)CJ

  echo "已关闭服务器" ;;

esac

;;

t)case $key2 in

1)ST 

  echo "已启动服务器" ;;

2)CT ST

  echo "已重启服务器" ;;

3)CT

  echo "已关闭服务器" ;;

esac

;;

esac

} 

if [ ! $2 ] 

then

read -p "请选择控制项目   a：全部     j:Jetty     t:Tomcat :" key1

read -p "请选择控制操作   1：启动     2:重启      3:停止 :"  key2

TD $key1 $key2

else

key1=$1

key2=$2

TD $key1 $key2

fi