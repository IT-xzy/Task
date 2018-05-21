
/**
 * Created by Administrator on 2017/11/9/009.
 */

var oplayNum=document.getElementById("player");//获取玩家总人数
var osliderBlock=document.getElementById("slider");//滑块的值
function limit() {
   if(event.keyCode === 13)
       alert(/^-?\d+$/.test(this.value));
}

function on_change(){
    if (oplayNum.value>=4 && oplayNum.value<=18){//设置input里面的玩家人数范围
        osliderBlock.value=oplayNum.value;//将玩家总人数的值付给滑块，关联起来
    }else{
        alert("请输入正确的人数4~18");
        oplayNum.value=4;
        osliderBlock=4;
    }//超出范围弹框，且重置为6
}
function moveChange() {//滑块的值改变，运行这个函数
    oplayNum.value=osliderBlock.value;
}
function less() {
    oplayNum.value--;
    if (oplayNum.value<4){
        alert("人数太少，请凑齐再来");
        oplayNum.value=4;
    }else{
        osliderBlock.value=oplayNum.value;
    }
}
function push() {
    oplayNum.value++;
    if (oplayNum.value>18){
        alert("人数太多，请分开游戏");
        oplayNum.value=18;
    }else {
        osliderBlock.value=oplayNum.value;
    }

}

//点击重新设置触发事件
function reseting(){
    var blackBoard=document.getElementById("blackboard");
    //   删除div
    blackBoard.innerHTML="";
//杀手数量or平民数量
    if(oplayNum.value>=4 && oplayNum.value<=5){
        var kNum=1;
    }else if(oplayNum.value>=6 && oplayNum.value<=8){
        var kNum=2;
    }else if(oplayNum.value>=9 && oplayNum.value<=11){
        var kNum=3;
    }else if(oplayNum.value>=12 && oplayNum.value<=14){
        var kNum=4;
    }else if(oplayNum.value>=15 && oplayNum.value<=17){
        var kNum=5;
    }else if(oplayNum.value=18 ){
        var kNum = 6;
    }

    var fNum=oplayNum.value-kNum;

//for循环为数组赋值
    var killer=new Array(kNum);
    for(var i=0;i<kNum;i++){
        killer[i]='杀手';
    }

    var farmer=new Array(fNum);
    for(var i=0;i<fNum;i++){
        farmer[i]='平民';
    }

//杀手数组与平民数组相加
    var sum=killer.concat(farmer);
//洗牌算法数组乱序
    Array.prototype.shuffle = function() {
        var input = this;
        for (var i = input.length-1; i >=0; i--) {
            var randomIndex = Math.floor(Math.random()*(i+1));
            var itemAtIndex = input[randomIndex];
            input[randomIndex] = input[i];
            input[i] = itemAtIndex;
        }
        return input;
    }
    sum.shuffle();
    console.log(sum);


    for(var i=0;i<oplayNum.value;i++){
        var Div=document.createElement("div");
        var Span=document.createElement("span");
        //为div添加id或者class等
        Div.setAttribute("class","m-killer");
        if(sum[i]==="杀手"){
            Span.setAttribute("class","m-k-span");
        }else {
            Span.setAttribute("class","m-span");
        }
        Div.innerHTML=sum[i];
        //在blackBoard插入div
        blackBoard.appendChild(Div);
        Div.appendChild(Span);
    }

    localStorage.setItem('randomArray',sum);
    // localStorage.removeItem('random');
    console.log(localStorage);
}

function nextOne() {
    window.location="http://student.task.web.ptteng.com/liangyao/js/task2-4/check-id.html";

}



