#! /bin/bash
#将10/Feb/2018全天的访问日志放到a.txt文本
cat /usr/local/nginx/logs/access_request_time.log | sed -rn '/10\/Feb\/2018/p' > a.txt 
#统计a.txt里面有多少个ip访问
cat a.txt | awk '{print $1}' | sort | uniq > ipnum.txt
#通过shell统计每个ip访问次数和访问响应时间
for i in `cat ipnum.txt`
do 
iptj=`cat a.txt | grep $i | grep -v 400 |wc -l`
iptime=`cat a.txt | grep $i | awk '{print $NF}' | awk -F "\"" '{sum+=$2}END{print sum}'`
if [ 0 != $iptj ];then
  iptimeavg=`echo "scale=4; $iptime/$iptj" | bc`
fi
echo "ip地址: "$i >> result.txt
echo "在2018-02-10日全天(24小时)\累计成功请求:  "$iptj"次;    平均每小时请求次数为： "$(($iptj/24))";    平均响应时间："$iptimeavg >> result.txt
done
