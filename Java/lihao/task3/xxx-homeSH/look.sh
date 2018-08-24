#!/bin/bash
host_dir=`echo ~`
# 进程名
proc_name="start.jar"
pid=0

# 计算进程数
proc_num()
{
        num=`ps -ef | grep $proc_name | grep -v grep | wc -l`
        return $num
}

# 进程号
proc_id()
{
        pid=`ps -ef | grep $proc_name | grep -v grep | awk '{print $2}'`
}

proc_num
number=$?
echo "pid number is $number"

# 判断进程是否存在
if [ $number -eq 0 ]
then
        /etc/init.d/jetty restart    # 重启进程的命令，请相应修改
        # service jetty start        #也可以使用该条命令
        proc_id                      # 获取新进程号
        echo "jetty is restart, and the new  pid is ${pid}"  # 将输出新进程号
fi
# 写好脚本后，创建一个定时任务，定时执行就ok了。
