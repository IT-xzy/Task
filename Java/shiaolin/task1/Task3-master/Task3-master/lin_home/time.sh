#! /bin/sh
reset_terminal=$(tput sgr0)
function c(){
echo "controller响应10ms的次数："
grep "性能测试：c" /root/apache-tomcat-7.0.86/webapps/demo/logs/controller/debug-log.log |awk '{if($NF>10&&$NF<20)print $NF}'| wc -l
}
function s(){
echo "service响应10ms的次数："
grep "性能测试：s" /root/apache-tomcat-7.0.86/webapps/demo/logs/controller/debug-log.log |awk '{if($NF>10&&$NF<20)print $NF}'| wc -l
}
echo  "                       " 
echo  "( what are you doing? )" 
echo  ---------------------
echo  "      o   ^__^ " 
echo  "       o  (oo)\_______" 
echo  "          (__)\       )\/\ " 
echo  "              ||----w |    "   
echo  "              ||     ||    "


echoFoFun(){
        echo -e '\E[32m' "$1" $reset_terminal $2  
}
echoFoFun "查询controller耗时10ms的次数请加命令 c"
echoFoFun "查询service耗时10ms的次数请加命令 s"
$1
