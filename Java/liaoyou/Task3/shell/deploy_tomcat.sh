#!/bin/bash
#自动部署应用到tomcat

#	1、获取tomcat进程ID
#	以全格式显示所有进程，找到含tomcat字符串的进程，精确找到含apache-tomcat-7.0.90字符串进程，过滤grep本身的进程，对该进程信息的第二个字段进行输出
tomcatID=$(ps -ef|grep 'tomcat'|grep -w 'apache-tomcat-7.0.90'|grep -v 'grep'|awk '{print $2}')

#	2、获取tomcat启动脚本、原应用项目缓存及部署目录、待部署新项目目录
tomcatStart=/mysoft/apache-tomcat-7.0.90/bin/startup.sh
ssmCache=/mysoft/apache-tomcat-7.0.90/work/Catalina/localhost/ssm
webApps=/mysoft/apache-tomcat-7.0.90/webapps
ssm=/mysoft/apache-tomcat-7.0.90/webapps/ssm
ssmWar=/mysoft/apache-tomcat-7.0.90/webapps/ssm.war
ssmWarNew=/mydata/myproject/deploy/ssm.war

#	3、判断tomcat是否正在运行，若运行中则关闭
echo "正在检查tomcat是否运行...[$(date +'%F %H:%M:%S')]"
if [ ${tomcatID} ]
then
	echo "tomcat正在运行，其进程ID为：${tomcatID}"
	echo '正在关闭tomcat进程'
	kill -9 ${tomcatID}
	# 这里采用杀进程方式而没有采用tomcat自带的shutdown.sh脚本，原因是当部署多个tomcat时，使用自带脚本时可能在关一个tomcat时把其他的tomcat也一起关闭了
	# 休眠3s等待tomcat进程完全关闭
	sleep 3
	# 使用rm命令清理缓存及部署文件
	echo '正在清理原项目'
	# -f 即使原档案属性设为唯读，亦直接删除，无需逐一确认；-r 将目录及目录里的文档逐一删除
	rm -rf ${ssmCache}
	echo '已删除缓存'
	rm -rf ${ssm}
	rm -f ${ssmWar}
	echo '已删除部署文件'
else
	echo 'tomcat没有启动'
	echo '正在清理原项目'
    # -f 即使原档案属性设为唯读，亦直接删除，无需逐一确认；-r 将目录及目录里的文档逐一删除
    rm -rf ${ssmCache}
    echo '已删除缓存'
    rm -rf ${ssm}
    rm -f ${ssmWar}
    echo '已删除部署文件'
fi

#	4、部署新应用
# -i 在覆盖目标文件之前给出提示，要求用户确认是否覆盖，回答"y"时目标文件将被覆盖（以防万一，若出现此提示，说明前面清理过程出现问题）
echo '正在将应用复制到webapps目录下'	
cp -i ${ssmWarNew} ${webApps}
echo '复制完成'

#	5、启动tomcat
echo '正在启动启动tomcat'
${tomcatStart} 
echo 'tomcat启动成功，部署完毕'
