#! /bin/sh

#取得war包
war=$1
#进入script的父目录并显示
bin=$(cd `dirname $0`; pwd)

#判断war字符串长度
if [ ! -n "${war}" ];then
	echo ""***Usage: $0 [project.war]""
	exit 0
fi
#判断war包是否存在
if [ ! -f "${war}" ];then 
	echo "***Error: ${war} does not exist."
	exit 0
fi
#判断是否为war包，从左到右截取最后一个.后的字符串
if [ ! "${war##*.}" = "war" ];then
	echo "***Error: ${war} is not a war file."
	exit 0
fi

echo "Deploy ${war##*/}..."
#删除ROOT下的文件，解压war包到ROOT下
rm -rf ${bin}/../webapps/ROOT/ && unzip -qo ${war} -d ${bin}/../webapps/ROOT/
#删除旧的classes文件
rm -rf ${bin}/../work/Catalina/localhost/
echo "Restart tomcat..."
#重启
exec ${bin}/restart.sh
