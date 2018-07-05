#!/bin/bash
cd /usr/local/nginx/logs

echo "总访问次数为："
awk '{print $NF}' myaccess.log|wc -l

echo "其中响应时间大于0.005的次数为："
awk '{print $NF}' myaccess.log |cut -c4-6 |awk '{if($1>5)print $1}' |wc -l


echo "其中响应时间大于0.01的次数为："
awk '{print $NF}' myaccess.log |cut -c4-6 |awk '{if($1>10)print $1}' |wc -l

echo "其中响应时间大于0.02的次数为："
awk '{print $NF}' myaccess.log |cut -c4-6 |awk '{if($1>20)print $1}' |wc -l 
