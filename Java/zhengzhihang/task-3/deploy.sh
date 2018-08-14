#/bin/bash
#description 部署tomcat war包

echo "输入要部署的war包名"
read war_name
echo "输入要部署到的tomcat 序号，只能是数字"
read number
echo "#########正在进行部署########"
cd /data/task
cp -f  ${war_name}  /data/tomwar
echo "已经把 ${war_name}移动到tomwar目录"
cd /data/tomwar
mv   ${war_name}  task${number}.war
echo "已经对${war_name}的名称更改成: task${number}.war "

cd /root
./tomswich${number}.sh restart

echo "#########项目部署成功#######"

