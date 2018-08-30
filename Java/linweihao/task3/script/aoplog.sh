#!/bin/bash
AopLogPath=/data/log/

num=`cat "$AopLogPath"aop.log |awk '$7=="DB"{a+=1}END{print a}'`
echo "DB访问请求了$num次"

num=`cat "$AopLogPath"aop.log |awk '$7=="Controller"{a+=1}END{print a}'`
echo "Controller访问请求了$num次"


num=`cat "$AopLogPath"aop.log |awk '$7=="DB"&&$9<10{a+=1}END{print a}'`

echo "DB访问小于10ms有$num次"

num=`cat "$AopLogPath"aop.log |awk '$7=="DB"&&$9>9&&$9<20{a+=1}END{print a}'`

echo "DB访问大于等于10ms小于20ms有$num次"

num=`cat "$AopLogPath"aop.log |awk '$7=="DB"&&$9>19&&$9<50{a+=1}END{print a}'`

echo "DB访问大于等于20ms小于50ms有$num次"

num=`cat "$AopLogPath"aop.log |awk '$7=="DB"&&$9>49{a+=1}END{print a}'`

echo "DB访问大于50ms有$num次"

num=`cat "$AopLogPath"aop.log |awk '$7=="Controller"&&$9<10{a+=1}END{print a}'`

echo "Controller访问小于10ms有$num次"

num=`cat "$AopLogPath"aop.log |awk '$7=="Controller"&&$9>9&&$9<20{a+=1}END{print a}'`

echo "Controller访问大于等于10ms小于20ms有$num次"

num=`cat "$AopLogPath"aop.log |awk '$7=="Controller"&&$9>19&&$9<50{a+=1}END{print a}'`

echo "Controller访问大于等于20ms小于50ms有$num次"

num=`cat "$AopLogPath"aop.log |awk '$7=="Controller"&&$9>49{a+=1}END{print a}'`

echo "Controller访问大于50ms有$num次"

