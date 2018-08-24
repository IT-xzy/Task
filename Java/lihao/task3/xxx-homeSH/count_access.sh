#!/bin/bash
#
#自定义jetty访问日志
log="/usr/local/nginx/logs/8080_access.log"

echo -e "*****************统计访问请求次数*****************\n"
# 统计访问请求次数
# awk '{print $2}' ${log} | sort | uniq -c
total_visit=`wc -l ${log} | awk '{print $1}'`
# 统计日志文件行数，对第一个字段进行打印
echo -e "*******80端口（jetty）服务器总访问次数为：${total_visit} 次*******\n"


echo -e "*******不同IP访问次数统计(前30)*******\n"
# 统计不同IP访问次数
cat ${log} | awk '{print $1}' |sort|uniq -c|sort -k 1 -n -r|head -30

# 统计状态码
echo -e "*******访问状态码统计*******\n"
awk '{print $9}' ${log} | sort | uniq -c | sort -n -r

echo -e "*****************响应时间和处理总时间*****************\n"
# 统计响应时间和处理时间
cat ${log} | awk '{print "响应时间：  " $(NF-3)  "    处理总时间：" $NF  "    ip: " $1 "   "}' | sort -k 1 -nr

echo -e " ********************统计结束********************\n"

