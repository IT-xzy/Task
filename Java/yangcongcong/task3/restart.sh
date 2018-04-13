#!/bin/bash

tomcatPath=/usr/local/tomcat/bin
#取出进程号
pid=$(ps aux | grep tomcat | grep -v grep | grep -v restart | grep ${tomcatPath} | awk '{print $2}') 

if [ -n "${pid}" ]; then
    echo "  tomcat Shutdown..."
    sh ${tomcatPath}/shutdown.sh
    sleep 3

    pid=$(ps aux | grep tomcat | grep -v grep | grep -v restart | grep ${tomcatPath} | awk '{print $2}')
    if [ -n "${pid}" ]; then
        kill -9 ${pid}
        sleep 1
    fi
fi
echo "  tomcat Startup..."
sh ${tomcatPath}/startup.sh

if [ "$1" = "-v" ]; then
    tail -f ${tomcatPath}/../logs/catalina.out
fi