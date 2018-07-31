console.log("JS文件-page3");

function back(){
    history.back();
}//左上角后退
function help(){
    location.assign("page2-help.html")
}//右上角帮助

var inputNum= document.getElementById("players");//input节点
var rangeNum= document.getElementById("thumb");//滑块节点

function InputValue() {    
    rangeNum.value=inputNum.value;
    if (inputNum.value>=4&&inputNum.value<=18){
        setGame();
    }else{
        alert("请输入正确人数（4-18人）！")
    }//判断4-18人
}

function rangeValue(){
    inputNum.value=rangeNum.value;
    setGame();
}//滑块的值

function reduceNum(){
    rangeNum.value=rangeNum.value-1;
    inputNum.value=rangeNum.value;
    setGame();
}//减号按钮
function addNum(){
    rangeNum.value=parseInt( rangeNum.value)+1;//加法有链接字符串的功能，所有要先转化成数字 
    inputNum.value=rangeNum.value;
    setGame();
}//加号按钮

var playersArr=new Array();//新建角色身份数组
function role(){
    playersArr=[];
    var killer= Math.floor(inputNum.value/3);//杀手人数
    sessionStorage.kiNum = killer;
    sessionStorage.ciNum = inputNum.value - killer;
    for (var i=0;i<killer;i++ ){
        playersArr[i]="杀手";
    }
    for (var i=killer;i<inputNum.value;i++){
        playersArr[i]="平民";
    }
    for (var i = playersArr.length-1; i >=0; i--) { 
        var random = Math.floor(Math.random()*(i+1)); 
        var player = playersArr[random]; 
        playersArr[random] = playersArr[i]; 
        playersArr[i] = player; 
    }//洗牌算法，数组乱序
    return playersArr;
}

function setGame(){
   playersArr=role();
   var ul=document.getElementById("identity");
   while(ul.hasChildNodes()){
        ul.removeChild(ul.firstChild);
    }//当ul下还存在子节点时 循环继续

    for (i = 0; i < inputNum.value; i++) {
        var li = document.createElement("li");//创建子节点

    // var textnode=document.createTextNode(text());
    // function text(){
    //     var text=<span>+</span>+ playersArr[i]+"1人";怎么都不能添加span标签，估计是createTextNode只能条件本文内容
    //     return text;
    // }
    
    li.innerHTML ='<span class="dot" id="dot" ></span>' +playersArr[i] +"1人";
    ul.appendChild(li);

   }
//    var dot=document.getElementById("dot");
//    var dotArr=new Array();
//    for (i = 0; i < inputNum.value; i++) {
//        dotArr=[];
//        dotArr[i]=dot;
//         var r =i %4;
//         console.log(r);
//         switch(r){
//             case 2:
//             case 3:
//             dotArr[i].style.background="#29bde0";
//             console.log(dotArr);
//             console.log(dotArr[i]);
//         }
//   }
   
}
var ciworld=document.getElementById("ciword");
var kiworld=document.getElementById("kiword");

function play(){
    if (
        playersArr.lenght != 0 &&
        ciworld.value != "" &&
        kiworld.value != "" 
    ){
        sessionStorage.Num=inputNum.value;
        // sessionStorage.setItem("Num", inputNum.value);
        sessionStorage.playArr=JSON.stringify(playersArr);
        sessionStorage.ciword=ciword.value;
        sessionStorage.kiword=kiword.value;
        location.href="page4.html";
    }else if (playersArr.length==0 ){
        alert("请设置玩家数量")
    }else if (ciworld.value =="" ){
        alert("请输入平民词汇")
    }else if (kiworld.value =="" ){
        alert("请输入杀手词汇")
    }
}