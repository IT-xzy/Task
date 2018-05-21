#!/bin/sh
echo "根据访问IP统计UV"
awk '{print $1}' /usr/local/webserver/nginx/logs/access.log | sort -n | uniq | wc -l

echo "统计访问URL统计PV"
awk '{print $7}' /usr/local/webserver/nginx/logs/access.log|wc -l

echo "查询访问最频繁的URL"
#awk '{print $7}' /usr/local/webserver/nginx/logs/access.log|sort | uniq -c |sort -n -k 1 -r|more

echo "查询访问最频繁的IP"
#awk '{print $1}' /usr/local/webserver/nginx/logs/access.log|sort | uniq -c |sort -n -k 1 -r|more

echo "统计响应时间"
#awk '{print $1,"	日期:"$4,$5"	响应时间:"$12*1000"ms"}' /usr/local/webserver/nginx/logs/access.log|sort -r| uniq -c |more

echo "统计反向代理响应时间"
#awk '{print $1,"	日期:"$4,$5"	响应时间:"$13*1000"ms"  }' /usr/local/webserver/nginx/logs/access.log|sort -r| uniq -c |more

echo "10ms以下"
awk '{if($12""<0.01) print $1,	$12*1000"ms"}' /usr/local/webserver/nginx/logs/access.log |wc -l
awk '{if($12""<0.01) print $1,	$12*1000"ms"}' /usr/local/webserver/nginx/logs/access.log | uniq -c |sort -n -r -k 3

echo "10ms以上，20ms以下"
awk '{if($12"">0.01"" && $12""<0.02) print $1,	$12*1000"ms"}' /usr/local/webserver/nginx/logs/access.log |wc -l
awk '{if($12"">0.01"" && $12""<0.02) print $1,	$12*1000"ms"}' /usr/local/webserver/nginx/logs/access.log | uniq -c |sort -n -r -k 3

echo "20ms以上"
awk '{if($12"">0.02) print $1,	$12*1000"ms"}' /usr/local/webserver/nginx/logs/access.log |wc -l
awk '{if($12"">0.02) print $1,	$12*1000"ms"}' /usr/local/webserver/nginx/logs/access.log | uniq -c |sort -n -r -k 3

