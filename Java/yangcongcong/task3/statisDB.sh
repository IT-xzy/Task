#！/bin/bash
dailyPath=/usr/local/tomcat_logs/jnshu-home/ssm/dailyLog.log
dailyDB=/data/jnshu-home/statisDB/dailyDB.txt
dailyController=/data/jnshu-home/statisDB/dailyController.txt

echo "" > ${dailyDB}
echo "" > ${dailyController}

cat ${dailyPath} | sed -rn '/com\.ssm\.dao/p' > ${dailyDB}
cat ${dailyPath} | sed -rn '/com\.ssm\.controller/p' > ${dailyController}

case $1 in
database)
echo "  统计访问DB的时间范围分布"
#统计0-20ms
cat ${dailyDB} | awk 'BEGIN { sum=0; } {if($5>=0 && $5<20) sum++;} END{print "访问DB时间在(0-20ms)之间的次数：",sum }'
#统计20-40ms
cat ${dailyDB} | awk 'BEGIN { sum=0; } {if($5>=20 && $5<40) sum++;} END{print "访问DB时间在(20-40ms)之间的次数：",sum }'
#统计40-60ms
cat ${dailyDB} | awk 'BEGIN { sum=0; } {if($5>=40 && $5<60) sum++;} END{print "访问DB时间在(40-60ms)之间的次数：",sum }'
#统计60-80ms
cat ${dailyDB} | awk 'BEGIN { sum=0; } {if($5>=60 && $5<80) sum++;} END{print "访问DB时间在(60-80ms)之间的次数：",sum }'
#统计80-100ms
cat ${dailyDB} | awk 'BEGIN { sum=0; } {if($5>=80 && $5<100) sum++;} END{print "访问DB时间在(80-100ms)之间的次数：",sum }'
#统计大于100ms
cat ${dailyDB} | awk 'BEGIN { sum=0; } {if($5>=100) sum++;} END{print "访问DB时间大于100ms的次数：",sum }'
;;
controller)
echo "  controller处理时间的范围分布"
#统计0-20ms
cat ${dailyController} | awk 'BEGIN { sum=0; } {if($5>=0 && $5<20) sum++;} END{print "controller处理时间在(0-20ms)之间的次数：",sum }'
#统计20-40ms
cat ${dailyController} | awk 'BEGIN { sum=0; } {if($5>=20 && $5<40) sum++;} END{print "controller处理时间在(20-40ms)之间的次数：",sum }'
#统计40-60ms
cat ${dailyController} | awk 'BEGIN { sum=0; } {if($5>=40 && $5<60) sum++;} END{print "controller处理时间在(40-60ms)之间的次数：",sum }'
#统计60-80ms
cat ${dailyController} | awk 'BEGIN { sum=0; } {if($5>=60 && $5<80) sum++;} END{print "controller处理时间在(60-80ms)之间的次数：",sum }'
#统计80-100ms
cat ${dailyController} | awk 'BEGIN { sum=0; } {if($5>=80 && $5<100) sum++;} END{print "controller处理时间在(80-100ms)之间的次数：",sum }'
#统计大于100ms
cat ${dailyController} | awk 'BEGIN { sum=0; } {if($5>=100) sum++;} END{print "controller处理时间大于100ms的次数：",sum }'
;;
esac
