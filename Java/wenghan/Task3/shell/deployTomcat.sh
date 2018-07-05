#!/bin/bash

cd /data/xxx-home

echo "请输入要删除的部署文件名称"
read test1
rm -f $test1

cd /data/warFiles
echo "请输入要移入部署文件夹中的文件名称"
read test2
mv $test2 /data/xxx-home

cd /root
./deploy.sh

