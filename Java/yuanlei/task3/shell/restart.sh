#!/bin/sh
#dirname $0:取得当前执行脚本文件的父目录  cd`dirname $0`:进入这个目录 pwd:显示当前目录（cd执行后）
bin=$(cd `dirname $0`; pwd)

#ps aux：显示所有进程和其状态  grep:搜索  grep -v grep：过滤掉带有grep的行   awk:依次对每一行进行处理然后输出，print $2：输出第二个字段 
pid=$(ps aux | grep tomcat | grep -v grep | grep -v restart | grep ${bin} | awk '{print $2}') 

# -n:用于判断字符串是否存在 
#如果已经启动就先shutdown再启动，如果shutdown之后3s没有停掉tomcat进程，则kill掉原来的进程再启动。
#如果tomcat没有启动则直接启动。

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