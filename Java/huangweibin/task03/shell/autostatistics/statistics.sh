#!/bin/bash
reset_terminal=$(tput sgr0) 
nginx_log_path='/usr/local/nginx/logs/access.log'
 
#the log of nginx after filter
nginx_log_awkpath='/usr/local/nginx/logs/mynginx.log'
 
#filter log only with http code
#ca 是指查看access1.log 文件，grep 是查找与规则相同的内容，awk 则是按条件分割相关的内容，>是指匹配分割后的内容存至 mynginx.log 文件下
cat ${nginx_log_path} | grep -ioE "HTTP\/1\.[1|0]\"[[:blank:]][0-9]{3}"| awk '{print $2}' > ${nginx_log_awkpath}
 
 #定义函数
echoFun(){
        echo -e '\E[32m' "$1" $reset_terminal $2
}
 
 
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
 
check_http_status
check_http_code
