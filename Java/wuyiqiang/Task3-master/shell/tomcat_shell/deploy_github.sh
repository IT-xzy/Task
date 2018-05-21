#! /bin/sh
#进入项目mvn clean
cd /root/github/task3/student
mvn clean
#进入github项目目录
cd /root/github/task3
#同步项目
git pull
#修改数据库密码
sed -i 's/MYSQLPASSWORD/mysqlpassword/g' /root/github/task3/student/src/main/resources/datasource/mysql.properties
#进入项目mvn package
cd /root/github/task3/student
mvn package
#进入tomcat bin
cd /usr/local/apache-tomcat-8.5.27/bin
#执行deploy.sh
./deploy.sh /root/github/task3/student/target/student.war

