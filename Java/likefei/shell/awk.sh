#! /bin/sh
awk -F: '
/method:action.StudentController/{ if($3>20) a++;else if($3<20 && $3>10) b++;else if($3<10) c++;}
END {printf " >20ms: " a;printf "\n";printf" 10ms~20ms: " b;printf "\n";printf" <10ms:" c;printf "\n"}
' log4j.log

