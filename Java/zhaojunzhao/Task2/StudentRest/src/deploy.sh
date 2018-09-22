#!/bin/sh

war=$1
bin="/usr/local/apache-tomcat-9.0.11/bin"
pid=$(ps aux | grep tomcat | grep -v grep | grep -v restart | grep ${bin} | awk '{print $2}')

# 通过判断参数是否存在来判断是否输入war包
if [ ! -n "${war}" ]; then
    echo "***Usage: $0 指定war包"
    exit 0
fi

#  判断war包是否存在
if [ ! -f "${war}" ]; then
    echo "******Error: ${war} 文件不存在******"
    exit 0
fi

# 判断文件是不是一个war文件
if [ ! "${war##*.}" = "war" ]; then
    echo "******Error: ${war} 不是一个war包******"
    exit 0
fi

echo "******删除与要部署的包同名的文件和文件夹******"
# 截取字符串
filename=${war##*/}
foldername=${filename%.*}

rm ${bin}/../webapps/${filename}
rm -rf ${bin}/../webapps/${foldername}

echo "******部署${war}包******"
# 复制文件
cp ${war} ${bin}/../webapps/

if [ -n "${pid}" ]; then
    echo "******关闭Tomcat服务******"
    # 用关闭脚本关闭Tomcat
    sh ${bin}/shutdown.sh

    # 如果Tomcat进程还存在用kill命令关闭Tomcat
    pid=$(ps aux | grep tomcat | grep -v grep | grep -v restart | grep ${bin} | awk '{print $2}')
    if [ -n "${pid}" ]; then
        kill -9 ${pid}
    fi
fi

echo "******启动Tomcat******"
sh ${bin}/startup.sh

echo "******重启Nginx******"
service nginx restart