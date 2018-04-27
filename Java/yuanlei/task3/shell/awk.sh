#! /bin/sh
awk -F: '
/method:com.ssm_yl.controller.CategoryController/{ if($4>20) a++;else if($4<20 && $4>10) b++;else if($4<10) c++;}
END { printf " >20ms: " a;printf "\n";printf" 10ms~20ms: " b;printf "\n";printf" <10ms:" c;printf "\n"}
' log.log
