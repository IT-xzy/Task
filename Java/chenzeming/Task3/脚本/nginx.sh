#!/bin/bash
tomcat_home=/local/kencery/tomcat
SHUTDOWN=$tomcat_home/bin/shutdown.sh
STARTTOMCAT=$tomcat_home/bin/startup.sh
NGINX=/local/nginx/sbin/nginx
war=$1

#获取当前的目录


if [ ! -n "${war}" ]; then

    echo "***Usage: $0 [project.war]"

    exit 0

fi

if [ ! -f "${war}" ]; then

    echo "***Error: ${war} does not exist."

    exit 0

fi

if [ ! "${war##*.}" = "war" ]; then

    echo "***Error: ${war} is not a war file."

    exit 0

fi

echo "Deploy ${war##*/}..."


rm -rf /local/kencery/tomcat/webapps/czm/ && unzip -qo ${war} -d /local/kencery/tomcat/webapps/czm/


echo "Restart tomcat..."

$SHUTDOWN

pidlist=`ps -ef |grep tomcat  |grep -v "grep"|awk '{print $2}'`

kill -9 $pidlist

rm  $tomcat_home/work/* -rf

sleep 5

echo "启动$tomcat_home"

$STARTTOMCAT

sleep 3

$NGINX