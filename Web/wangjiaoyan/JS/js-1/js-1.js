// /**
//  * Created by Administrator on 2017/11/16.
// //  */
var a;
function start() {
    // 选取随机数
    function GetRandomNum(Min,Max)
    {
        var Range = Max - Min;
        var Rand = Math.random();
        return(Min + Math.round(Rand * Range));
    }
    // 随机选出三个不重复的数
    for (i=0;i<9;i++){
        var num1 = GetRandomNum(0,8);
        var num2 = GetRandomNum(0,8);
        var num3 = GetRandomNum(0,8);
        if (num1!==num2&&num2!=num3&&num1!==num3){
        break;
        }
    }
    // 获取dom节点
    var choose=document.getElementsByClassName("box");
    for (var j=0;j<choose.length;j++){
    choose[j].style.background="orange";
}
    // 随机颜色
    function bg1(){
        var r=Math.floor(Math.random()*256);
        var g=Math.floor(Math.random()*256);
        var b=Math.floor(Math.random()*256);
        return "rgb("+r+','+g+','+b+")";
    }
    // 给随机格子赋随机颜色
        choose[num1].style.backgroundColor = bg1();
        choose[num2].style.backgroundColor = bg1();
        choose[num3].style.backgroundColor = bg1();

    a = setTimeout("start()",1000);
}

function end() {
    clearTimeout(a);
    var choose = document.getElementsByClassName("box");
    for (var x = 0; x < choose.length; x++) {
        choose[x].style.backgroundColor = "orange";
    }
}