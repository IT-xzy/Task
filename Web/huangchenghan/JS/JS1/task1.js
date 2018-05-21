var contain= document.getElementsByClassName("box"); //获取box元素集合
var start = document.getElementById("start"); //定义开始变量
var end = document.getElementById("end"); //定义结束变量
var init;//初始化
function randomColor(){ 
	var r = Math.floor(Math.random()*256); 
	var g = Math.floor(Math.random()*256); //由于Math.random取值是0~1 * 256后范围为0~255.9999之间，用Math.floor向下取整，为0~255 
	var b = Math.floor(Math.random()*256); 
	return "rgb(" + r + "," + g + "," + b +")";
}
function base(){
	for(var i= 0;i<contain.length;i++) {
		contain[i].style.background = "#FFA500";  //定义初始的方块颜色
	}
}
function btn(){   //定义方块变化
	var container = [];
for (var i = 0; i < contain.length; i++) {
	container[i] = i;                            //给变量i一个0的初始值，然后当i小于box元素集合组成的数组长度时（9），遍+1
}
function randomNum(n) {
	var result = [];
	for (var i =  0; i < n; i++) {
		var random = Math.floor(Math.random()*container.length); //random获取一个0~1的小数乘container数组长度，然后向下取整
		result.push(container[random]);   //push()可向数组末尾添加一个或者多个元素，并返回新的长度 
		container.splice(random,1);
	}
	return result;
}
	base();
	var num = randomNum(3);
	var one = num[0]; //计算机中，是从0开始计数的
    var two = num[1];
    var three = num[2];
	contain[one].style.background = randomColor();
    contain[two].style.background = randomColor();  //给与方块随机颜色
    contain[three].style.background = randomColor();
}

start.onclick = function() { //定义开始点击函数
	clearInterval(init);//初始化
	init = setInterval(btn,1000);//1秒变化一次
}
end.onclick = function() { //定义结束点击函数
	clearInterval(init);//初始化
	base();//恢复原来的颜色
}
