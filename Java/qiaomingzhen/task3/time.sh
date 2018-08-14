#!/bin/bash
cd /usr/local/shell/
echo "">time.txt
echo "响应时间划分">>time.txt
echo "响应时间10ms以内">>time.txt
tail -100 /var/log/nginx/access.log | awk 'BEGIN{sum=0}{if($13<0.01) sum++;} END{print sum}' >>time.txt
echo "响应时间10ms-20ms之间">>time.txt
tail -100 /var/log/nginx/access.log | awk 'BEGIN{sum=0}{if((0.01<=$13)&&($13<0.02)) sum++} END{print sum}' >>time.txt
echo "响应时间20ms-50ms之间">>time.txt
tail -100 /var/log/nginx/access.log | awk 'BEGIN{sum=0}{if((0.02<=$13)&&($13<0.05)) sum++} END{print sum}' >>time.txt
echo "响应时间50ms-100ms之间">>time.txt
tail -100 /var/log/nginx/access.log | awk 'BEGIN{sum=0}{if((0.05<=$13)&&($13<0.1)) sum++} END{print sum}' >>time.txt
echo "响应时间大于100ms">>time.txt
tail -100 /var/log/nginx/access.log | awk 'BEGIN{sum=0}{if($13>=0.1) sum++} END{print sum}' >>time.txt
echo "访问次数">>time.txt
cat /var/log/nginx/access.log | awk 'BEGIN{sum=0}{if(-n "$9") sum++} END{print sum}' >>time.txt


echo "DB访问时间统计">>time.txt
echo "DB访问时间10ms以内">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==2)&&($12<10)) sum++;} END{print sum}' >>time.txt
echo "DB访问时间10-20ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==2)&&($12<20)&&($12>=10)) sum++;} END{print sum}' >>time.txt
echo "DB访问时间20-30ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==2)&&($12<30)&&($12>=20)) sum++;} END{print sum}' >>time.txt
echo "DB访问时间30-40ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==2)&&($12<40)&&($12>=30)) sum++;} END{print sum}' >>time.txt

echo "DB访问时间40-50ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==2)&&($12<50)&&($12>=40)) sum++;} END{print sum}' >>time.txt

echo "DB访问时间50-100ms之间">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==2)&&($12>=50)&&($12<100)) sum++;} END{print sum}' >>time.txt
echo "DB访问时间大于100ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==2)&&($12>=100)) sum++;} END{print sum}' >>time.txt

echo "controller方法执行时间统计">>time.txt


echo "方法执行时间10ms以内">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==2)&&($12<10)) sum++;} END{print sum}' >>time.txt
echo "方法执行时间10-20ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==1)&&($12<20)&&($12>=10)) sum++;} END{print sum}' >>time.txt
echo "方法执行时间20-30ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==1)&&($12<30)&&($12>=20)) sum++;} END{print sum}' >>time.txt
echo "方法执行时间30-40ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==1)&&($12<40)&&($12>=30)) sum++;} END{print sum}' >>time.txt

echo "方法执行时间40-50ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==1)&&($12<50)&&($12>=40)) sum++;} END{print sum}' >>time.txt

echo "方法执行时间50-100ms之间">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==1)&&($12>=50)&&($12<100)) sum++;} END{print sum}' >>time.txt
echo "方法执行时间大于100ms">>time.txt
cat /SSM/logs/info.log | awk 'BEGIN{sum=0}{if(($10==1)&&($12>=100)) sum++;} END{print sum}' >>time.txt

