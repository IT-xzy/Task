#! /bin/bash
#Power by shiaolin 
#让光标在末尾
echo  "                       " 
echo  "( what are you doing? )" 
echo  ---------------------
echo  "      o   ^__^ " 
echo  "       o  (oo)\_______" 
echo  "          (__)\       )\/\ " 
echo  "              ||----w |    "   
echo  "              ||     ||    "

reset_terminal=$(tput sgr0)
#日期的格式
date=`date +%Y-%m-%d`
#日志文件
nginx_log_path=/root/nginx/logs/host.access.log
#输出日志的目录
logdir=/root/nginx/logs
#过滤后的文件
nginx_log_awkpath=${logdir}/access_${date}.log
#进程文件
pid=`cat /root/nginx/logs/nginx.pid`
#如果不存在日志文件目录就创建一个目录
if [ ! -d $logdir ]; then
    mkdir -p $logdir
fi
echo "access_${date}"
#如果不存在日志文件就创建一个
touch ${nginx_log_awkpath}
 
cat ${nginx_log_path} | grep -ioE "HTTP\/1\.[1|0]\"[[:blank:]][0-9]{3}"| awk '{print $2}' > ${nginx_log_awkpath}
echoFun(){  
        echo -e '\E[32m' "$1" $reset_terminal $2  
} 
#提取访问状态码，并显示访问量
check_http_status(){  
  
        http_code_100=$(grep -o '1[0-9][0-9]' ${nginx_log_awkpath} | wc -l)  
        http_code_200=$(grep -o '2[0-9][0-9]' ${nginx_log_awkpath} | wc -l)  
        http_code_300=$(grep -o '3[0-9][0-9]' ${nginx_log_awkpath} | wc -l)  
        http_code_400=$(grep -o '4[0-9][0-9]' ${nginx_log_awkpath} | wc -l)  
        http_code_500=$(grep -o '5[0-9][0-9]' ${nginx_log_awkpath} | wc -l)  
        http_code_total=$(grep -o '[1-5][0-9][0-9]' ${nginx_log_awkpath} | wc -l)  
  
        echoFun "http status[100+]" "${http_code_100}"  
        echoFun "http status[200+]" "${http_code_200}"  
        echoFun "http status[300+]" "${http_code_300}"  
        echoFun "http status[400+]" "${http_code_400}"  
        echoFun "http status[500+]" "${http_code_500}"  
        echoFun "http status total" "${http_code_total}"  
}
check_http_code(){  
  
        http_code_403=$(grep -o '403' ${nginx_log_awkpath} | wc -l)  
        http_code_404=$(grep -o '404' ${nginx_log_awkpath} | wc -l)  
  
        echoFun "http status[403]" "${http_code_403}"  
        echoFun "http status[404]" "${http_code_404}"  
  
  
}
start_tongji(){
    	check_http_status  
    	check_http_code 
}

echoFun "统计流量请添加命令：start_tongji"

echoFun "查看访问延时:start_response"
start_response(){
awk '{print $NF}' /root/nginx/logs/host.access.log
 awk '{print $NF}' /root/nginx/logs/host.access.log > /root/data/logs/time.log
}
$1 
