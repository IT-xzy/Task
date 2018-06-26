#!/bin/sh
#-----------------------------------------------------------------------------
#备份
#-----------------------------------------------------------------------------
file=$(date '+%m-%d')
#下面一行在控制台打印语句class文件
echo $(date) 备份/root/apache-tomcat-8.5.31/webapps/Task2.1/WEB-INF/下的文件
cd /root/backups/
mkdir $file
cd $file
cp /root/apache-tomcat-8.5.31/webapps/Task2.1/WEB-INF/ . -r
#-----------------------------------------------------------------------------
#更新
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
#备份log日志
echo $(date) 备份log日志
cd /root/apache-tomcat-8.5.31/logs/
#把前面文件的内容剪切到后面的文件（后面文件的内容直接被override）
mv catalina.out catalina-$file.out
#拷贝更新文件
echo $(date) 把更新文件拷贝到运行目录
cd /home/shop/cc/
#cp * 复制当前文件下的所有文件
cp * /root/apache-tomcat-8.5.31/webapps/Task2.1/ -r
#设置ulimit -n 65000
echo $(date) 设置ulimit
cd /root/apache-tomcat-8.5.31/bin/
#Linux对于每个用户，系统限制其最大进程数。为提高性能，可以根据设备资源情况通过ulimit设置各linux 用户的最大进程数
ulimit -n 65000
#启动
echo $(date) 启动tomcat
./startup.sh
#-----------------------------------------------------------------------------
