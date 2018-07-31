#!/bin/sh
#pwd：显示当前路径
cd /usr/local/tomcat/apache-tomcat-8.5.32/bin
bin=/usr/local/tomcat/apache-tomcat-8.5.32/bin
#ps 表示显示当前进程 grep文本搜索工具，grep -v 表示输出除之外的所有行 ，awk 是处理文本文件的语言；
pid=$(ps aux | grep tomcat | grep -v grep | grep -v restart | grep ${bin} | awk '{print $2}') 

if [ -n "${pid}" ]; then
    echo "Shutdown..."
    sh ${bin}/shutdown.sh
    sleep 3

    pid=$(ps aux | grep tomcat | grep -v grep | grep -v restart | grep ${bin} | awk '{print $2}')
    if [ -n "${pid}" ]; then
        kill -9 ${pid}
        sleep 1
    fi
fi

echo "Startup..."
sh ${bin}/startup.sh
if [ "$1" = "-v" ]; then
    tail -f ${bin}/../logs/catalina.out
fi

