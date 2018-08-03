#!/bin/bash
FilePATH=/usr/local/nginx/logs/
#统计a.txt里面有多少个ip访问
cat "$FilePATH"host.access.log|awk '{print $1 " " $6*1000}' >"$FilePATH"iptime.txt
#通过shell统计每个ip访问次数
for j in `cat "$FilePATH"host.access.log |awk '{print $1}'|sort |uniq`
do 
iptj=`cat "$FilePATH"iptime.txt|grep $j|wc -l`
iptm=`cat "$FilePATH"iptime.txt |awk '/'$j'/ {sum += $2};END {print sum}'`
printf "%-30s %-20s %-20s %-30s\n" ip地址$j 累计请求$iptj次 共计$iptm毫秒 平均每次耗费$(($iptm/$iptj))毫秒
done

 #总请求次数
num=`cat "$FilePATH"AOP.log|awk '{a+=1}END{print a}'`
echo "一共请求了"$num"次"

#使用Tomcat
num=`cat "$FilePATH"AOP.log|grep Tomcat | awk '{a+=1}END{print a}'`
echo "使用Tomcat的有"$num"次"

#使用Jetty
num=`cat "$FilePATH"AOP.log|grep Jetty | awk '{a+=1}END{print a}'`
echo "使用Jetty的有"$num"次"

#使用Resin
num=`cat "$FilePATH"AOP.log|grep Resin | awk '{a+=1}END{print a}'`
echo "使用Resin的有"$num"次"

#数据库总请求
num=`cat "$FilePATH"AOP.log|grep 数据库操作总耗时： |awk '{a+=1}END{print a }'`
echo "数据库共请求"$num"次"

#请求时间小于10ms
num=`cat "$FilePATH"AOP.log|grep 数据库操作总耗时： |awk '$7<10{a+=1}END{print a }'`
echo "请求时间小于10ms的有"$num"次"

#请求时间大于10ms小于20ms
num=`cat "$FilePATH"AOP.log|grep 数据库操作总耗时： |awk '$7>=10&&$7<20{a+=1}END{print a}'`
echo "请求时间大于10ms小于20ms的有"$num"次"

#请求时间大于20ms小于30ms
num=`cat "$FilePATH"AOP.log|grep 数据库操作总耗时： |awk '$7>=20&&$7<30{a+=1}END{print a}'`
echo "请求时间大于20ms小于30ms的有"$num"次"

#请求时间大于30ms
num=`cat "$FilePATH"AOP.log|grep 数据库操作总耗时： | awk '$7>=30{a+=1}END{print a}'`
echo "请求时间大于30ms的有"$num"次"

