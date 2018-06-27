// 获取盒子的DOM
var boxs = document.getElementsByClassName("box");
console.log(boxs.length);
// 将盒子从类数组转变为，类数组
var arr = Array.prototype.slice.call(boxs);
console.log(arr.length);
// 获取两个点击按钮
var btn=document.getElementById("start");
var btn_stop=document.getElementById("close");
// 取到3个随机的盒子
function getBoxs(){
	for(var shuffled = arr.slice(0), i = arr.length-1, min = i - 2, temp, index;i>min;i--){
		index = Math.floor((i + 1) * Math.random());
		temp = shuffled[index];
		shuffled[index] = shuffled[i];
		shuffled[i] = temp;
	}
	return shuffled.slice(min);
	console.log(shuffled.slice(min));
}
// 给取到的随机3个盒子改变背景颜色
function getColor(ar){
	for(var i=0;i<3;i++){
		console.log(ar[i]);
		ar[i].style.backgroundColor = colorRandom();
	}
}
// 取随机背景颜色
function colorRandom(){
	var color = "#"+("00000"+((Math.random()*16777215+0.5)>>0).toString(16)).slice(-6);
    console.log(color);
    return color;
};
// 恢复背景颜色
function reColor(ar){
	for (var i = 0; i < arr.length; i++) {
		console.log(arr[i]);
		arr[i].style.backgroundColor= "#2196F3";
	}
}
// 执行点击事件
function begin(){
	reColor();
	getBoxs();
	var ar = getBoxs();
	console.log(ar);
	getColor(ar);
}
// 点击功能
var set;
function start(){
	if (set==undefined){set = setInterval("begin()",1300);
	}
	else {
		return false;
	}
}
function stop(){
	clearInterval(set);
	set=undefined;
	reColor();
}