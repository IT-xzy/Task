#!/bin/bash

echo "****测试专用脚本****"

# use variable
# your_name="Skr~~ ~~~~~~~ ~~~~ ~~~"
# echo $your_name
# your_name="alibaba"
# echo $your_name

# set readonly
# myUrl="http://www.google.com"
# readonly myUrl
# myUrl="http://www.runoob.com"

# delete variable
# myUrl="http://www.runoob.com"
# unset myUrl
# echo $myUrl

# shuangyinhao 
# your_name='paper'
# str="Hello, I know you are \"$your_name\"! "
# echo $str

# your_name="runoob"
# # 使用双引号拼接
# greeting="hello, "$your_name" !"
# greeting_1="hello, ${your_name} !"
# echo $greeting  $greeting_1
# # 使用单引号拼接
# greeting_2='hello, '$your_name' !'
# greeting_3='hello, ${your_name} !'
# echo $greeting_2  $greeting_3

#输出 4
# string="abcd"
# echo ${#string} 

# string="runoob is a great site"
# echo ${string:1:4} # 输出 unoo

# string="runoob is a great site"
# echo `expr index "$string" i`  # 输出 4

# string="beach fit man"
# echo `expr index "$string" m`

# my_array=(A B "C" D)

# echo "第一个元素为: ${my_array[0]}"
# echo "第二个元素为: ${my_array[1]}"
# echo "第三个元素为: ${my_array[2]}"
# echo "第四个元素为: ${my_array[3]}"

# my_array[0]=A
# my_array[1]=B
# my_array[2]=C
# my_array[3]=D

# echo "数组的元素为: ${my_array[*]}"
# echo "数组的元素为: ${my_array[@]}"

# my_array[0]=A
# my_array[1]=B
# my_array[2]=C
# my_array[3]=D

# echo "数组元素个数为: ${#my_array[*]}"
# echo "数组元素个数为: ${#my_array[@]}"

# val=`expr 2 + 2`
# echo "两数之和为 : $val"

# a=10
# b=20

# val=`expr $a + $b`
# echo "a + b : $val"

# val=`expr $a - $b`
# echo "a - b : $val"

# val=`expr $a \* $b`
# echo "a * b : $val"

# val=`expr $b / $a`
# echo "b / a : $val"

# val=`expr $b % $a`
# echo "b % a : $val"

# if [ $a == $b ]
# then
#    echo "a 等于 b"
# fi
# if [ $a != $b ]
# # then
# #    echo "a 不等于 b"
# # fi

# a=10
# b=20

# if [ $a -eq $b ]
# then
#    echo "$a -eq $b : a 等于 b"
# else
#    echo "$a -eq $b: a 不等于 b"
# fi
# if [ $a -ne $b ]
# then
#    echo "$a -ne $b: a 不等于 b"
# else
#    echo "$a -ne $b : a 等于 b"
# fi
# if [ $a -gt $b ]
# then
#    echo "$a -gt $b: a 大于 b"
# else
#    echo "$a -gt $b: a 不大于 b"
# fi
# if [ $a -lt $b ]
# then
#    echo "$a -lt $b: a 小于 b"
# else
#    echo "$a -lt $b: a 不小于 b"
# fi
# if [ $a -ge $b ]
# then
#    echo "$a -ge $b: a 大于或等于 b"
# else
#    echo "$a -ge $b: a 小于 b"
# fi
# if [ $a -le $b ]
# then
#    echo "$a -le $b: a 小于或等于 b"
# else
#    echo "$a -le $b: a 大于 b"
# # fi

# a=10
# b=20

# if [ $a != $b ]
# then
#    echo "$a != $b : a 不等于 b"
# else
#    echo "$a != $b: a 等于 b"
# fi
# if [ $a -lt 100 -a $b -gt 15 ]
# then
#    echo "$a 小于 100 且 $b 大于 15 : 返回 true"
# else
#    echo "$a 小于 100 且 $b 大于 15 : 返回 false"
# fi
# if [ $a -lt 100 -o $b -gt 100 ]
# then
#    echo "$a 小于 100 或 $b 大于 100 : 返回 true"
# else
#    echo "$a 小于 100 或 $b 大于 100 : 返回 false"
# fi
# if [ $a -lt 5 -o $b -gt 100 ]
# then
#    echo "$a 小于 5 或 $b 大于 100 : 返回 true"
# else
#    echo "$a 小于 5 或 $b 大于 100 : 返回 false"
# fi


# a=10
# b=20

# if [[ $a -lt 100 && $b -gt 100 ]]
# then
#    echo "返回 true"
# else
#    echo "返回 false"
# fi

# if [[ $a -lt 100 || $b -gt 100 ]]
# then
#    echo "返回 true"
# else
#    echo "返回 false"
# fi

# a="abc"
# b="efg"

# if [ $a = $b ]
# then
#    echo "$a = $b : a 等于 b"
# else
#    echo "$a = $b: a 不等于 b"
# fi
# if [ $a != $b ]
# then
#    echo "$a != $b : a 不等于 b"
# else
#    echo "$a != $b: a 等于 b"
# fi
# if [ -z $a ]
# then
#    echo "-z $a : 字符串长度为 0"
# else
#    echo "-z $a : 字符串长度不为 0"
# fi
# if [ -n "$a" ]
# then
#    echo "-n $a : 字符串长度不为 0"
# else
#    echo "-n $a : 字符串长度为 0"
# fi
# if [ $a ]
# then
#    echo "$a : 字符串不为空"
# else
#    echo "$a : 字符串为空"
# fi

# file="/data/xxx-home/test.sh"
# if [ -r $file ]
# then
#    echo "文件可读"
# else
#    echo "文件不可读"
# fi
# if [ -w $file ]
# then
#    echo "文件可写"
# else
#    echo "文件不可写"
# fi
# if [ -x $file ]
# then
#    echo "文件可执行"
# else
#    echo "文件不可执行"
# fi
# if [ -f $file ]
# then
#    echo "文件为普通文件"
# else
#    echo "文件为特殊文件"
# fi
# if [ -d $file ]
# then
#    echo "文件是个目录"
# else
#    echo "文件不是个目录"
# fi
# if [ -s $file ]
# then
#    echo "文件不为空"
# else
#    echo "文件为空"
# fi
# if [ -e $file ]
# then
#    echo "文件存在"
# else
#    echo "文件不存在"
# fi


# printf "%-10s %-8s %-4s\n" 姓名 性别 体重kg  
# printf "%-10s %-8s %-4.2f\n" 郭靖 男 66.1234 
# printf "%-10s %-8s %-4.2f\n" 杨过 男 48.6543 
# printf "%-10s %-8s %-4.2f\n" 郭芙 女 47.9876 


# # format-string为双引号
# printf "%d %s\n" 1 "abc"

# # 单引号与双引号效果一样 
# printf '%d %s\n' 1 "abc" 

# # 没有引号也可以输出
# printf %s abcdef

# # 格式只指定了一个参数，但多出的参数仍然会按照该格式输出，format-string 被重用
# printf %s abc def

# printf "%s\n" abc def

# printf "%s %s %s\n" a b c d e f g h i j

# # 如果没有 arguments，那么 %s 用NULL代替，%d 用 0 代替
# printf "%s and %d \n" 

# num1=100
# num2=100
# if test $[num1] -eq $[num2]
# then
#     echo '两个数字相等'
# else
#     echo '两个数不相等'
# fi

# if conditon
# then
#     command1
#     command2
#     ...
#     commandN
# fi

# if [ $(ps -ef | grep -c "ssh") -gt 1 ]; then echo "true"; fi

# for loop in 1 2 3 4 5
# do
#     echo "The value is: $loop"
# done

# for str in 'This is a string'
# do
#     echo $str
# done

# int=1
# while(( $int<=100 ))
# do
#     echo $int
#     let "int++"
# done

# echo '按下 <CTRL-D> 退出'
# echo -n '输入你最喜欢的网站名: '
# while read FILM
# do
#     echo "是的！$FILM 是一个好网站"
# done

# for (( ; ; ))

# a=0

# until [ ! $a -lt 10 ]
# do
#     echo $a
#     a=`expr $a + 1`
# done

# echo '输入 1 到 4 之间的数字:'
# echo '你输入的数字为:'
# read aNum
# case $aNum in
#     1)  echo '你选择了 1'
#     ;;
#     2)  echo '你选择了 2'
#     ;;
#     3)  echo '你选择了 3'
#     ;;
#     4)  echo '你选择了 4'
#     ;;
#     *)  echo '你没有输入 1 到 4 之间的数字'
#     ;;
# esac

echo "查看tomcatID"

tomcatID=$(ps -ef|grep 'tomcat'|grep -w 'apache-tomcat-9.0.10.0'|grep -v 'grep'|awk '{print $2}')

