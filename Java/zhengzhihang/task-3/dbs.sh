#!/bin/bash
cd /Users/log4j/tomcat01

echo "总访问次数为"
awk '{print $NF}' infoLog.log|wc -l

echo "有关dao的行"

echo "dao 0-5 毫秒"
grep 'com.dao' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1<5 && $1>0)print $1 }'|wc -l

echo "dao 10-20 毫秒"
grep 'com.dao' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1>=10 && $1<20)print $1 }'|wc -l

echo "dao 20-50  毫秒"
grep 'com.dao' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1>=20 && $1<50)print $1 }'|wc -l

echo "dao 50-100 毫秒"
grep 'com.dao' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1>=50 && $1<100)print $1 }'|wc -l

echo "dao 大于100 毫秒"
grep 'com.dao' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1>=100)print $1 }'|wc -l
