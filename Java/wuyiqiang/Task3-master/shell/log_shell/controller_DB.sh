#! /bin/bash
# 访问DB和controller时间统计
# 获取日志中controller相关的操作
cat /var/resin/log/default/stdout.log | sed -rn '/DB_Controller/p' > controller.txt
# 获取contoller中有几种不同操作
cat controller.txt | awk '{print $4}' | sort | uniq > exec.txt
# 日期
echo `date` >> countTime.txt
# 循环遍历，统计每个操作的总次数和不同时间段内完成次数
for i in `cat exec.txt`
  do
  connum=`cat controller.txt | grep -w $i | wc -l`
  cat controller.txt | grep -w $i | awk '{print $NF}' > time.txt
  k=0
  l=0  
    for j in `cat time.txt`
    do
     if [ $j -lt 10 ]; then
        k=$(($k+1))
        else
        l=$(($l+1))
     fi
    done 
echo "执行： "$i >> countTime.txt
echo "总次数："$connum";         耗时低于10ms： "$k";         耗时高于10ms： "$l >> countTime.txt
done

