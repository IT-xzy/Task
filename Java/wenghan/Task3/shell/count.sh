#!/bin/bash

cat tomcat1Logs.log |grep "DB:"|awk '{print $10}'  > /root/logs/DBLog.log
cat tomcat1Logs.log |grep "Controller"|awk '{print $10}'  > /root/logs/ControllerLog.log
echo "DB：查询操作的总次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "queryUserById"| cut -f3 -d":" | cut -f1 -d"m" |wc -l
echo "DB：更新操作的总次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "reviseUserById"  | cut -f3 -d":"| cut -f1 -d"m"|wc -l
echo "DB：删除操作的总次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "cutUserById"  | cut -f3 -d":"| cut -f1 -d"m"|wc -l
echo "DB：添加操作的总次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "addUser" | cut -f3 -d":" | cut -f1 -d"m"|wc -l

echo "DB：查询操作耗时大于20ms的次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "queryUserById"| cut -f3 -d":" | cut -f1 -d"m" | awk '{if($1>20) print $1}'|wc -l
echo "DB：更新操作耗时大于20ms的次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "reviseUserById"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>20) print $1}'|wc -l
echo "DB：删除操作耗时大于20ms的次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "cutUserById"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>20) print $1}'|wc -l
echo "DB：添加操作耗时大于20ms的次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "addUser" | cut -f3 -d":" | cut -f1 -d"m"| awk '{if($1>20) print $1}'|wc -l

echo "DB：查询操作耗时大于10ms的次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "queryUserById"| cut -f3 -d":" | cut -f1 -d"m" | awk '{if($1>10) print $1}'|wc -l
echo "DB：更新操作耗时大于10ms的次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "reviseUserById"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>10) print $1}'|wc -l
echo "DB：删除操作耗时大于10ms的次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "cutUserById"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>10) print $1}'|wc -l
echo "DB：添加操作耗时大于10ms的次数："
awk '{ print $1}' /root/logs/DBLog.log| grep "addUser" | cut -f3 -d":" | cut -f1 -d"m"| awk '{if($1>10) print $1}'|wc -l

echo "Controller:查询操作的总次数为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "editORQuery"  | cut -f3 -d":"| cut -f1 -d"m"|wc -l
echo "Controller:更新操作的总次数为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "update"  | cut -f3 -d":"| cut -f1 -d"m"|wc -l
echo "Controller:删除操作的总次数为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "delate"  | cut -f3 -d":"| cut -f1 -d"m"|wc -l
echo "Controller:添加操作的总次数为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "add"  | cut -f3 -d":"| cut -f1 -d"m"|wc -l

echo "Controller:查询操作耗时大于20ms的为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "editORQuery"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>20) print $1}'|wc -l
echo "Controller:更新操作耗时大于20ms的为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "update"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>20) print $1}'|wc -l
echo "Controller:删除操作耗时大于20ms的为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "delate"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>20) print $1}'|wc -l
echo "Controller:添加操作耗时大于20ms的为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "add"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>20) print $1}'|wc -l

echo "Controller:查询操作耗时大于10ms的为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "editORQuery"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>10) print $1}'|wc -l
echo "Controller:更新操作耗时大于10ms的为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "update"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>10) print $1}'|wc -l
echo "Controller:删除操作耗时大于10ms的为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "delate"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>10) print $1}'|wc -l
echo "Controller:添加操作耗时大于10ms的为："
awk '{ print $1}' /root/logs/ControllerLog.log| grep "add"  | cut -f3 -d":"| cut -f1 -d"m"| awk '{if($1>10) print $1}'|wc -l
