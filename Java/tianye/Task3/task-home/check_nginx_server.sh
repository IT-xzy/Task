#!/bin/bash

settrem=$(tput sgr0)

Check_Nginx_Server_Log()
{
    httpCode=(`cat /usr/local/nginx/logs/access.log |  grep -ioE "HTTP/1\.[1|2]\"[[:blank:]][0-9]{3}" | 
    awk -F "[ ]+" '{

        $2!=""?code[$2]++:""
        if($2>=100&&$2<200)
            {i++}
        else if($2>=200&&$2<300)
            {j++}
        else if($2>=300&&$2<400)
            {k++}
        else if($2>=400&&$2<500)
            {n++}
        else if($2>=500)
            {p++}   
    }END{print i?i:0,j?j:0,k?k:0,n?n:0,p?p:0,i+j+k+n+p,code[404],code[403],code[500]}'`)
    echo -e '\E[32m'"The status number [100+] num:" $settrem ${httpCode[0]}
    echo -e '\E[32m'"The status number [200+] num:" $settrem ${httpCode[1]}
    echo -e '\E[32m'"The status number [300+] num:" $settrem ${httpCode[2]}
    echo -e '\E[32m'"The status number [400+] num:" $settrem ${httpCode[3]}
    echo -e '\E[32m'"The status number [500+] num:" $settrem ${httpCode[4]}
    echo -e '\E[32m'"The status all  num:" $settrem ${httpCode[5]}
    echo -e '\E[32m'"The status 404  num:" $settrem ${httpCode[6]}
    echo -e '\E[32m'"The status 403  num:" $settrem ${httpCode[7]}
    echo -e '\E[32m'"The status 500  num:" $settrem ${httpCode[8]}
}

Check_Nginx_Server_Log
