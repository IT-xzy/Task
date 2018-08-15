#!/bin/sh
#-----------------------------------------------------------------------------
#停止tomcat
echo $(date) 关闭tomcat
cd /root/apache-tomcat-8.5.31/bin/
./shutdown.sh
echo tomcat停止运行
#判断Tomcat是否已经停止工作
echo $(date) 判断tomcat是否停止工作，如果没有，则间隔一段时间后强制关闭
int=0
while (($int < 5))
do
    #a = show processes for all users 显示所有用户的进程

    #u = display the process's user/owner 显示用户
    #x = also show processes not attached to a terminal 显示无控制终端的进程
        pid=$(ps aux|grep tomcat-|grep -v grep|awk '{print $2}')
        #grep -v grep 防止列表出grep的进程号。
        #awk '{print $2}' 一行一行的读取指定的内容， 以空格作为分隔符，打印第二个字段   （awk就是把文件逐行的读入，以空格为默认分隔符将每行切片，切开的部分再进行各种分析处理。）
        if [ "$pid" = "" ]
        then
                echo $pid 不存在
                int=5
        else
                echo $pid 存在,休息20s
                #let 后面接运算符表达式，不加引号应该也可以
                let "int++"
                sleep 20s
                if [ "$int" = "4" ]
                then
                        echo $(date) 强制关闭tomcat
                        #强制杀掉进程  Ctrl-2==Ctrl+C
                        kill -9 $pid
                fi
        fi
done

