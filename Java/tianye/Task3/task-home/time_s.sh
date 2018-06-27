#!/bin/bash
settrem=$(tput sgr0)

service_Log()
{
    httpCode=(`cat /root/apache-tomcat-8.5.31/logs/catalina.out | grep "方法 com.task2.service"|awk -F "[ ]+" ' 
    {

        $4!=""?code[$4]++:""
        if($4>=0&&$4<10)
            {i++}
        else if($4>=10&&$4<20)
            {j++}
        else if($4>=20&&$4<40)
            {k++}
        else if($4>=40&&$4<100)
            {n++}
        else if($4>=100)
            {p++}   
    }END{print i?i:0,j?j:0,k?k:0,n?n:0,p?p:0,i+j+k+n+p}'`)
    echo -e '\E[32m'"访问DB时间10ms以内 num:" $settrem ${httpCode[0]}
    echo -e '\E[32m'"访问DB时间10ms到20ms num:" $settrem ${httpCode[1]}
    echo -e '\E[32m'"访问DB时间20ms到40ms num:" $settrem ${httpCode[2]}
    echo -e '\E[32m'"访问DB时间40ms到100ms num:" $settrem ${httpCode[3]}
    echo -e '\E[32m'"访问DB时间100ms以上 num:" $settrem ${httpCode[4]}
    
}


service_Log
