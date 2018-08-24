#!/bin/sh
LOG_PATH=/usr/local/webserver/nginx/logs

echo "正在统计网页延时相应分布情况，请稍后..."

echo "响应时间延迟0~10ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF<=0.001)sum++;} END{print sum}'

echo "响应时间延迟10~20ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF<=0.002&&$NF>0.01)sum++;} END{print sum}'

echo "响应时间延迟20~30ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF<=0.003&&$NF>0.02)sum++;} END{print sum}'

echo "响应时间延迟30~40ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF<=0.04&&$NF>0.03)sum++;} END{print sum}'

echo "响应时间延迟大于40ms的有："
tail -10000 $LOG_PATH/access.log | awk 'BENGIN{sum=0}{if($NF>0.04)sum++;} END{print sum}'