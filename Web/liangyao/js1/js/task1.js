/**
 * Created by Administrator on 2017/11/3/003.
 */
var box = document.getElementsByClassName('small-box');
var startBtn = document.getElementById("begin");
var endBtn = document.getElementById("end");

/*随机获取颜色*/
var getRandomColor = function(){
    return  '#' +
        (function(color){
            return (color +=  '0123456789abcdef'[Math.floor(Math.random()*16)])
            && (color.length == 6) ?  color : arguments.callee(color);
        })('');
}

/*让颜色恢复为原来的颜色*/
function flash() {
    for (var i = 0; i < 9; i++) {
        box[i].style.backgroundColor = "#FFA54F";
    }
    /*生成一个数组下标*/

    var newNum=new Array;
    for(var i=0;i<8;i++){
        newNum[i]=i;
    }
/*随机取出不重复数值*/
    var arr=[9];


        var reslut=[];
        for(var i=0;i<3;i++){
            var randomNum=Math.floor(Math.random()*newNum.length);/*选随机数*/
            reslut.push(newNum[randomNum]);/*给reslut加上一个随机数*/
            newNum.splice(randomNum,1);/*从下标数组删掉随机的那个值*/
        }


    box[reslut[0]].style.backgroundColor = getRandomColor();
    box[reslut[1]].style.backgroundColor = getRandomColor();
    box[reslut[2]].style.backgroundColor = getRandomColor();


}


var timer;/**/
startBtn.onclick = function () {
    clearInterval(timer);
    timer = setInterval("flash()",1000);
}

endBtn.onclick=function () {
    for (var i = 0; i < 9; i++) {
        box[i].style.backgroundColor = "#FFA54F";
    }
    clearInterval(timer);
}




