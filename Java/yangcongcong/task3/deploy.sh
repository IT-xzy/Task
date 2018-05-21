#!/bin/bash

webappsROOT=/usr/local/tomcat/webapps/ROOT/
catalinaLocalhost=/usr/local/tomcat/work/Catalina/localhost/
restartSh=/data/jnshu-home

war=$1

echo '####################开始自动部署####################'
if [ ! -n "${war}" ]; then
    echo "***Usage: $0 [project.war]"
    exit 0
fi
if [ ! -f "${war}" ]; then
    echo "***Error: ${war} does not exist."
    exit 0
fi
#删掉最后一个点及其左边的字符串，结果为"war"
if [ ! "${war##*.}" = "war" ]; then
    echo "***Error: ${war} is not a war file."
    exit 0
fi

echo "Deploy ${war##*/}..."
#unzip 解压缩
#-q 安静模式，执行时不显示任何信息
#-o 不必先询问用户，unzip执行后覆盖原有文件
#-d   指 定文件解压缩后所要存储的目录。
#&& 表示前一条命令执行成功时，才执行后一条命令 
rm -rf ${webappsROOT} && unzip -qo ${war} -d ${webappsROOT}
rm -rf ${catalinaLocalhost}
echo '####################部署结束####################'
echo " 正在调用tomcat重启脚本 ..."
exec ${restartSh}/restart.sh
