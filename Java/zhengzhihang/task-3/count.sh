#!/bin/bash
cd /Users/log4j/tomcat01

echo "总访问次数为"
awk '{print $NF}' infoLog.log|wc -l

echo "有关Controller的行"

echo "controller 0-5 毫秒"
grep 'com.controller' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1<5 && $1>0)print $1 }'|wc -l

echo "controller 10-20 毫秒"
grep 'com.controller' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1>=10 && $1<20)print $1 }'|wc -l

echo "controller 20-50  毫秒"
grep 'com.controller' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1>=20 && $1<50)print $1 }'|wc -l

echo "controller 50-100 毫秒"
grep 'com.controller' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1>=50 && $1<100)print $1 }'|wc -l

echo "controller 大于100 毫秒"
grep 'com.controller' infoLog.log | awk '{print $6}'|tr -d "onto"| awk '{if($1>=100)print $1 }'|wc -l
