var flag = true;
var timer;
function choiceCube(){
    var array1 = [];
    for(var i = 0; i < 9; i++){
        array1[i] = i ;
    }
    var array2 = [];
    for(var i = 9; i > 0;){
        var randomNumber = Math.floor(Math.random() * i);
        array2.push(array1[randomNumber]);
        array1[randomNumber] = array1[--i];
    }
    var cube1 = array2[0];
    var cube2 = array2[1];
    var cube3 = array2[3];
    function getColor() {
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
    var x = document.getElementsByClassName("cube");
    x[cube1].style.backgroundColor = getColor();
    x[cube2].style.backgroundColor = getColor();
    x[cube3].style.backgroundColor = getColor();
}
function resetColor() {
    var x = document.getElementsByClassName("cube");
    for(i = 0; i < 9; i++){
        x[i].style.backgroundColor = "#fea500";
    }
}
function loopBlink() {
    setTimeout("choiceCube()",0);
    setTimeout("resetColor()",1000);
}
function startBlink() {
    if (flag){
        timer = setInterval("loopBlink()",1000);
        flag = false;
    }
}
function stopBlink() {
    clearInterval(timer);
    flag = true;
}

// var int;
// function start(){
// 	//计时器
// 		clearInterval(int);
// 		int=setInterval(run,1000);
// }
// 		function run(){
// 	//重置
// 		var box=document.getElementsByClassName('box');
//
// 		for (var i = 0; i < 9; i++) {
//
// 			box[i].style.background="orange";
//
// 		}
// 	//盒子
// 			var arr=new Array();
// 			for (var i = 0; i < 9; i++) {
// 				arr[i]=i;
// 				};
// 				arr.sort(function(){return 0.5-Math.random();}).slice(5,2);
// 					arr.length=3;
// 	//颜色
// 			var colors=new Array(3);
// 			for (var j = 0; j < colors.length; j++) {
// 				colors[j]="#"+(function(h){
// 					return new Array(7-h.length).join("0")+h
// 					})((Math.random()*0x1000000<<0).toString(16))
// 				}
// 	//运行
// 	for (var k = 0; k <3;k++) {
// 		box[arr[k]].style.background=colors[k];
// 	}
// 	}
//
//
// //点击停止按钮
// function stop(){
// 	clearInterval(int);
// 	var box=document.getElementsByClassName('box');
// 	for (var i = 0; i < 9; i++) {
// 		box[i].style.background="orange";
// 	}
// 	clearInterval(int);
// }
