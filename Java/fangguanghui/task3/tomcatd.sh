#shell何种程序来解释脚本
#!/bin/bash



. /etc/init.d/functions

# set env
# export 将变量输出为环境变量
export PATH=$PATH:/bin:/sbin:/usr/sbin
export LANG="zh_CN.UTF8"
export TOMCATP=/usr/local/tomcat7/bin/startup.sh

# whoami 打印当前使用用户
# 文件描述符0键盘输入，1显示器输出，2错误返回值
# exit 1 ：表示非正常退出
if [[ "$(whoami)" != "root" ]]; then
       echo "Please run this script as root." >&2
       exit 1
fi

#Source function library
# -f filename 如果 filename为常规文件，则为真
if [ ! -f ${TOMCATP} ]; then
                echo "tomcat is not exit.please install"
                exit 1
fi

# ps -ef ps显示系统状态进程 -e显示环境变量 f显示程序之间相互关系
# ps -ef |grep java 把ps -fe结果作为grep java的输入 在进程中寻找包含java进程
# -v 反向搜索  显示除条件之外的值
# grep -v grep|grep -v sh 筛选不包含grep 和 sh的进程
# wc计算字符数  -l输出行数； eq 0  等于0   gt大于
# This is a fuction for start tomcat
function start(){
        if [ `ps -ef |grep java|grep -v grep|grep -v sh|wc -l` -eq 0 ]
                then
                        /bin/sh ${TOMCATP} >/dev/null 2>&1
                        #$?上个命令退出码
                        [ $? -eq 0 ]&&\
                        sleep 1
                        #/bin/true 返回0
                        action "tomcat start." /bin/true
                else
                        action "tomcat had been started." /bin/true
                        exit 3
        fi
}

#This is a function for stop
function stop(){
        if [ `ps -ef |grep java|grep -v grep|grep -v sh|wc -l` -gt 0 ]
                then
                        PID=`ps -ef |grep java|grep -v grep|awk '{print $2}'`
                        kill -9 $PID
                        [ $? -eq 0 ]&&\
                        sleep 1
                        action "tomcat  been stoped." /bin/true
                else
                        action "tomcat had been stoped." /bin/true
                        exit 4

        fi
}

#This is a function for restart
function restart(){
	if [ `ps -ef|grep java|grep -v grep|grep -v sh|wc -l` -gt 0 ]
		then
			PID1=`ps -ef |grep java|grep -v grep|awk '{print $2}'`
			kill -9 $PID1
			[ $? -eq 0 ]&&/bin/sh ${TOMCATP} >/dev/null 2>&1
			[ $? -eq 0 ]&&echo "tomcat is restarting..."
			sleep 1
			action "tomcat is restartted!" /bin/true
		else
			action "tomcat is not running! Starting... " /bin/true
			[ $? -eq 0 ]/bin/sh ${TOMCATP}>/dev/null 2>&1
			sleep 2
			action "tomcat start." /bin/true
			exit 5
	fi
}



#This is a function for status
function status(){
        if [ `ps -ef|grep java|grep -v grep|wc -l` -gt 0 ]
                then 
                        action "tomcat is runing." /bin/true
                else
                        action "tomcat is stopped." /bin/true
                        exit 5
        fi
}


#
 case $1 in
         start)
         start
 ;;
         stop)
	 stop
 ;;
         restart)
         restart
 ;;
         status)
	 status
 ;;
 
         *)
	echo "USAG:start|stop|restart|status"

#shell 的风格，用倒序的字母单词和 正序的单词配对
esac
