#! /bin/sh
echo '####################开始自动部署####################'
cd /root/apache-tomcat-8.5.31/bin #进入tomcat的bin目录
PID=$(ps -ef|grep tomcat|grep -v grep|awk '{print $2}')
if [ -z "$PID" ];then
echo "no tomcat process"
else
./shutdown.sh #停止tomcat服务
fi
sleep 1 #休眠1s
cd /root/apache-tomcat-8.5.31/webapps #进入tomcat的webapps目录
rm -fr Task2.1  #删除test文件目录
cd /root/data/task-home
mv Task2.1.war /root/apache-tomcat-8.5.31/webapps
sleep 1 #休眠1s
cd /root/apache-tomcat-8.5.31/bin
./startup.sh #启动tomcat服务
echo '####################部署结束####################'
