#!/bin/bash
webapps_home=/usr/local/tomcat-8.5/webapps
resin_home=/usr/local/resin/webapps
name=$1
case $2 in

tomcat)

# cd $webapps_home
# if [ -f ${name}.war ] ; then
# rm -rf $webapps_home/*
# cd /data
# cp *.war $webapps_home
# echo "存在旧项目，删除后部署成功"
# else cd /data
# cp *.war $webapps_home
# echo "部署成功"
# fi
 if [ ! -d "/data/project/apps" ] ; then
 unzip ${name}.war -d /data/project/apps
 echo "部署到tomcat成功"
 else
 rm -rf /data/project/apps
 unzip ${name}.war -d /data/project/apps
 echo "删除原项目，重新部署成功"
 fi

;;

#resin)
#cd /data
# if [ ! -d "$resin_home/apps" ] ; then
# unzip *.war -d $resin_home/apps
# echo "部署到resin成功"
# else
# rm -rf $resin_home/apps
# unzip *.war -d $resin_home/apps
# echo "删除原项目，重新部署成功"
# fi
#;;

esac
