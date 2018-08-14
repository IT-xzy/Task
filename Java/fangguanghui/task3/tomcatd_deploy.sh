#!/bin/bash

. /etc/init.d/functions

#set evn
export PATH=$PATH:/bin:/sbin:/usr/bin:/usr/sbin
export LANG=zh_CN.UTF8

#war包存放路径
workPath=/root/war
#项目工作路径
deployDir=/usr/local/tomcat7/webapps

#删除webbapps下项目文件
function del(){
    echo "clean ${deployDir} ..."
    rm -rf ${deployDir}/SSM2 >/dev/null 2>&1
    if [ $? -eq 0 ]
        then
            echo "Item has been deleted."
            add
        else
            echo "deleted failed"
    fi
        return 2
}




function add(){
     if [ ! -f "${workPath}/SSM2.war" ]
        then
            echo "请将文件放置root目录下"
        else
            echo "deploy..."
            unzip -oq ${workPath}/SSM2.war -d ${workPath}/SSM2
            if [ $? -eq 0 ]
                then
                    echo "Decompression succeeded！"
                    cp -r ${workPath}/SSM2 ${deployDir} 
                    [ $? -eq 0 ]&& bash /usr/local/bin/tomcatd.sh restart
                    sleep 2
                    echo "deploy succeeded!"
		    rm -rf ${workPath}/SSM2  
                else
                    echo "Decompression failed！"
            fi
     fi
     return 3
}


function deploy(){
    if [ -d "${deployDir}/SSM2" ]
        then
            echo " Whether to delete the item ? "
            read -p "Y/N :" answer
                case ${answer} in
                     "Y"|"y")
                      del
                      ;;
                      "N"|"n")
                      action "drop out." /bin/true
                      ;;
                      *)
                      echo "please enter Y/N "
                 esac
        else
            add
    fi
}

deploy
