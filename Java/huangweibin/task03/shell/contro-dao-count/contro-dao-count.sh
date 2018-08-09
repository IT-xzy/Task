#!/bin/bash
log='/home/admin/logs/warn.log'
sum=0
	
echo "访问 database 所用时间统计：" > count-database-controller.txt

grep -n 'mapper' ${log} | awk '{print $(NF-1),$NF}' >> count-database-controller.txt

echo "---------------------------------------------" >> count-database-controller.txt



echo "controller 处理时间统计：" >> count-database-controller.txt

grep -n "controller" ${log} | awk '{print $(NF-1),$NF}' >> count-database-controller.txt

 
echo "---------------------------------------------" >> count-database-controller.txt
echo "---------------------------------------------" >> count-database-controller.txt

# "响应时间在在10ms以内的为:${datasum}

echo "其中 database 执行小于10ms"  >> count-database-controller.txt

sed -n '/mapper/p'  ${log} |awk '{if($(NF-1)+0<10) print $5 $6}'|sort -n -r -k6 >> count-database-controller.txt


echo "---------------------------------------------" >> count-database-controller.txt

# "响应时间在10-100ms以内的为:${datasum}

echo "其中 database 执行大于10ms小于100ms"  >> count-database-controller.txt

sed -n '/mapper/p' ${log} | awk '{if($(NF-1)+0>10&&$(NF-1)+0<100) print $5 $6}'|sort -n -r -k6  >> count-database-controller.txt

echo "---------------------------------------------" >> count-database-controller.txt

# "响应时间在200ms以上的为:${datasum}

echo "其中 database 执行大于100ms"  >> count-database-controller.txt

sed -n '/mapper/p' ${log} | awk '{if($(NF-1)+0>100) print $5 $6}'|sort -n -r -k6 >> count-database-controller.txt


echo "---------------------------------------------" >> count-database-controller.txt
echo "---------------------------------------------" >> count-database-controller.txt

# "响应时间在在10ms以内的为:${datasum}

echo "其中 controller 执行小于10ms"  >> count-database-controller.txt

sed -n '/controller/p'  ${log} |awk '{if($(NF-1)+0<10) print $5 $6}'|sort -n -r -k6 >> count-database-controller.txt


echo "---------------------------------------------" >> count-database-controller.txt

# "响应时间在50-200ms以内的为:${datasum}

echo "其中 controller 执行大于10ms小于100ms"  >> count-database-controller.txt

sed -n '/controller/p' ${log} | awk '{if($(NF-1)+0>10&&$(NF-1)+0<100) print $5 $6}'|sort -n -r -k6  >> count-database-controller.txt

echo "---------------------------------------------" >> count-database-controller.txt

# "响应时间在200ms以上的为:${datasum}

echo "其中 controller 执行大于100ms"  >> count-database-controller.txt

sed -n '/controller/p' ${log} | awk '{if($(NF-1)+0>100) print $5 $6}'|sort -n -r -k6 >> count-database-controller.txt
