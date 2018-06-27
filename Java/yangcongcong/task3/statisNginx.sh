#!/bin/bash

nginxAccessLog=/usr/local/nginx/logs/access.log
alllogsTxt=/data/jnshu-home/statisNginx/alllogs.txt
ipNumTxt=/data/jnshu-home/statisNginx/ipnum.txt
resultTxt=/data/jnshu-home/statisNginx/result.txt

echo "" > ${resultTxt}

#将某天的访问日志放到txt文本
cat ${nginxAccessLog} | sed -rn '/13\/Apr\/2018/p' | grep -v 400   > ${alllogsTxt} 
#统计txt里面有多少个ip访问
cat ${alllogsTxt} |awk '{print $1}'| sort | uniq > ${ipNumTxt}

case $1 in
uv)
#通过shell统计每个ip访问次数
for i in `cat ${ipNumTxt}`
do 
ip_amount=`cat  ${alllogsTxt} |grep $i | grep -v 400 |wc -l`
#输出追加重定向>>  
echo "ip地址"$i"在2018-4-13日全天累计成功请求"${ip_amount}"次，平均每分钟请求次数为："$((${ip_amount}/1440)) >> ${resultTxt}
done
cat ${resultTxt}
;;
time)
echo "  Nginx响应时间的范围分布"
#统计小于10ms
cat ${alllogsTxt}  | awk 'BEGIN{ sum=0; } {if($9>0 && $9<=0.010) sum++;} END{ print "响应时间小于10ms的次数：" , sum }'
#统计10~20ms
cat ${alllogsTxt}  | awk 'BEGIN{ sum=0; } {if($9>0.010 && $9<=0.020) sum++;} END{ print "响应时间在10~20ms的次数：" , sum }'
#统计20~40ms
cat ${alllogsTxt}  | awk 'BEGIN{ sum=0; } {if($9>0.020 && $9<=0.040) sum++;} END{ print "响应时间在20~40ms的次数：" , sum }'
#统计40~60ms
cat ${alllogsTxt}  | awk 'BEGIN{ sum=0; } {if($9>0.040 && $9<=0.060) sum++;} END{ print "响应时间在40~60ms的次数：" , sum }'
#统计60~80ms
cat ${alllogsTxt}  | awk 'BEGIN{ sum=0; } {if($9>0.060 && $9<=0.080) sum++;} END{ print "响应时间在60~80ms的次数：" , sum }'
#统计80~100ms
cat ${alllogsTxt}  | awk 'BEGIN{ sum=0; } {if($9>0.080 && $9<=0.100) sum++;} END{ print "响应时间在80~100ms的次数：" , sum }'
#统计大于100ms
cat ${alllogsTxt}  | awk 'BEGIN{ sum=0; } {if($9>0.080 && $9<=0.100) sum++;} END{ print "响应时间在80~100ms的次数：" , sum }'
;;
esac
