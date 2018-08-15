#!/bin/bash
#month=$1
#day=$2

echo ""> /czm-home/logss/alllogs.txt
cat /local/nginx/logs/access.log |sed -rn '/15\/Jul\/2018/p' > /czm-home/logss/alllogs.txt 
count=`awk '{print $1}' alllogs.txt | sort -n | uniq | wc -l`
echo "访问量为：$count"

echo "响应时间延迟0~5ms的有： " 
tail -100 /local/nginx/logs/access.log | awk 'BENGIN{sum=0}{if($25<=0.005)sum++;} END{print sum}' 

echo "响应时间延迟6~10ms的有： " 
tail -100 /local/nginx/logs/access.log | awk 'BENGIN{sum=0}{if($25<=0.01&&$25>0.005)sum++;} END{print sum}' 

echo "响应时间延迟11~15ms的有： " 
tail -100 /local/nginx/logs/access.log | awk 'BENGIN{sum=0}{if($25<=0.015&&$25>0.01)sum++;} END{print sum}' 

echo "响应时间延迟0~5ms的有： " 
tail -100 /local/nginx/logs/access.log | awk 'BENGIN{sum=0}{if($25<=0.02&&$25>0.015)sum++;} END{print sum}' 