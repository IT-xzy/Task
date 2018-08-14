#!/bin/sh
echo '####################开始自动部署####################'
path=`pwd` #当前路径
tomcatPath=/data/zwp-home/project #指定tomcat文件目录名称
cd /data/zwp-home/script
#cd $tomcatPath/bin #进入tomcat的bin目录
PID=$(ps -fu `whoami`|grep tomcat|grep -v grep|awk '{print $2}')
if [ -z "$PID" ];then
 echo "no tomcat process"
else
./stop.sh #停止tomcat服务
fi
sleep 1 #休眠1s
cd $tomcatPath/webapps #进入tomcat的webapps目录
rm -fr project #删除test文件目录
mv project.war project.war.$(date +%Y%m%d) #备份webapps下的test16 cp $path/test.war ./ #复制test.war到webapps路径下
sleep 1 #休眠1s
cd /data/zwp-home/script
./start.sh #启动tomcat服务
echo '####################部署结束####################'
