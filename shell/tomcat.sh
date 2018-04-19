#! /bin/bash

#tomcat start

echo delete

cd /usr/apache-tomcat-8.5.29/webapps

sudo rm -rf  task2.war

sudo rm -rf  task2

echo shutdown

sh /usr/apache-tomcat-8.5.29/bin/shutdown.sh

echo deploy

cd

cd ..

cp task2.war /usr/apache-tomcat-8.5.29/webapps

echo start

sh /usr/apache-tomcat-8.5.29/bin/startup.sh


#test
