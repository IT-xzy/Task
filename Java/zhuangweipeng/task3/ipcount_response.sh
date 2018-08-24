#!/bin/sh
LOG_PATH=/usr/local/webserver/nginx/logs

echo "请输入你需要查看的内容：1、查看访问次数 2、查看访问最高ip访问数 3、查看网页延时相应分布统计。"
read aHander
echo "你输入的选项是：$aHander"
case $aHander in 
1)
echo "正在统计今天访问量，请稍后..."
cat $LOG_PATH/access.log| sed -n /`date "+%d\/%b\/%Y"`/p |awk '{print $7}' |sort|wc -l
;;
2)
echo "正在对今天访问ip量进行倒序排序，请稍后..."
cat  $LOG_PATH/access.log| sed -n /`date "+%d\/%b\/%Y"`/p |awk '{print $1}'|sort | uniq -c |sort -n -k 1 -r|more
;;
3)
echo "正在统计网页延时相应分布情况，请稍后..."
echo "响应时间延迟0~10ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF<=0.001)sum++;} END{print sum}'

echo "响应时间延迟10~20ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF<=0.002&&$NF>0.001)sum++;} END{print sum}'

echo "响应时间延迟20~30ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF<=0.003&&$NF>0.002)sum++;} END{print sum}'

echo "响应时间延迟30~40ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF<=0.004&&$NF>0.003)sum++;} END{print sum}'

echo "响应时间延迟大于40ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF>0.004)sum++;} END{print sum}'
;;
*)
echo "没有该选项！请重新运行程序，输入操作指令！"
esac
