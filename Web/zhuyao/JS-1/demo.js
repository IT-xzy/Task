var boxes=document.getElementsByClassName("box");
var my;
function getColor(){
    var colorArray = ["0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"];
    var color="#";//定义一个存放十六进制颜色值的字符串变量，先将#存放进去
    //使用for循环语句生成剩余的六位十六进制值
    for(var i=0;i<6;i++){
        //colorArray[Math.floor(Math.random()*16)]随机取出
        // 由16个元素组成的colorArray的某一个值，然后将其加在color中，
        //字符串相加后，得出的仍是字符串
        color+=colorArray[Math.floor(Math.random()*16)];
    }
    return color;
}
var arr=new Array(3);//创建数组容纳随机数
var arr1=new Array(3);//创建数组容纳随机颜色
begin.onclick=function(){ //点击开始
    clearInterval(my);//清除定时器
    my=setInterval(function(){start();},1000);//使用定时器,调用函数，设置时间
};
end.onclick=function(){  //停止按钮的
    for(i=0;i<boxes.length;i++){
        boxes[i].style.background="#FF8000";//遍历清除颜色
    }
    clearInterval(my);  //停止定时器
}
function start(){
    for(var i=0;i<boxes.length;i++){//每次随机颜色时遍历将背景设置好
        boxes[i].style.background="#FF8000";
    }
    for(var i = 0;i < arr.length; i++){//创建第一组数组
        var a = Math.floor(Math.random()*9);//取0~9的随机整数，赋值给a
        console.log(a);
        if( i === 0 ){//第一个数字直接导入数组
            arr[i]=a;
        }else{
            for(var j=0;j<i;j++){//第二个与第三个数字进行判断
                if(a==arr[j]){//如果重复从新开始
                    i--
                }else{
                    arr[i]=a;
                }
            }
        }
    }
    for(var i=0;i<3;i++){//取三个随机颜色
        arr1[i]=getColor();
    }
    for(var i=0;i<arr.length;i++){
        boxes[arr[i]].style.background=arr1[i];//将随机的颜色给随机的地址
    }
}





