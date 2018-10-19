#!/bin/bash
FilePath=/usr/local/nginx/logs/

cat "$FilePath"host.access.log | awk '{print $1 " " $NF*1000}' >"$FilePath"iptime.txt
for j in `cat "$FilePATH"host.access.log |awk '{print $1}'|sort |uniq`
do 
iptj=`cat "$FilePATH"iptime.txt|grep $j|wc -l`
iptm=`cat "$FilePATH"iptime.txt |awk '/'$j'/ {sum += $2};END {print sum}'`
avg=$(($iptm/$iptj))
echo "$avg"
echo "ip地址"$j" 累计成功请求"$iptj"次  共计"$iptm"毫秒，平均每次耗费"$avg"毫秒"
done

