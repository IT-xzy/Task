  #!/bin/bash

 if [ $1 ==" " ]
 then
        echo "Usage: ./loganalysis.sh logname"
  exit 0
  else
        cat $1 | awk '{print $NF}'  | awk -F "\"" '{print $2}'  >  /usr/local/nginx/logs/time.txt
        echo "split request_time over!!!"
 
        paste  -d " " $1 time.txt > new.log
        echo "build new logfile over!!!"
 
        awk '($NF>1){print$1" "$4" "$6" "$7" "$NF}' new.log > slowtime.txt
        echo "please see slowtime in slowtime.txt!!!" 
 
        rm -f time.txt
        rm -f new.log
 fi