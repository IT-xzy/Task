#!/bin/bash
echo "请输入参数（tomcat、jetty、*）"
read a
deploy(){
rm -rf /SSM/$b/webapps/*
cd /SSM/webapps
if [ -f *.war ] ; then
cp *.war /SSM/$b/webapps
sleep 2
cd /SSM/$b/webapps
ls
echo "$b"
echo "部署成功"
else
echo "$b"
echo "项目不存在"
fi
}
cd /usr/local/shell
case $a in
tomcat)
b=$a
deploy
;;
jetty)
b=$a
deploy
;;
*)
b=tomcat
deploy
b=jetty
deploy
;;
esac
