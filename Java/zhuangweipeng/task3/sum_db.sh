#!/bin/sh
LOG_PATH=/usr/local/webserver/tomcat/logs
echo "正在统计DB方法执行时间相应分布情况，请稍后..."
echo "DB方法执行时间在0~10ms的有："
tail -10000 $LOG_PATH/AOPDB.log | awk 'BENGIN{sum=0}{if($NF<=10)sum++;} END{print sum}'

echo "DB方法执行时间在10~20ms的有："
tail -10000 $LOG_PATH/AOPDB.log | awk 'BENGIN{sum=0}{if($NF<=20&&$NF>10)sum++;} END{print sum}'

echo "DB方法执行时间在20~30ms的有："
tail -10000 $LOG_PATH/AOPDB.log | awk 'BENGIN{sum=0}{if($NF<=30&&$NF>20)sum++;} END{print sum}'

echo "DB方法执行时间在30~40ms的有："
tail -10000 $LOG_PATH/AOPDB.log | awk 'BENGIN{sum=0}{if($NF<=40&&$NF>30)sum++;} END{print sum}'

echo "DB方法执行时间在大于40ms的有："
tail -10000 $LOG_PATH/AOPDB.log | awk 'BENGIN{sum=0}{if($NF>40)sum++;} END{print sum}'
