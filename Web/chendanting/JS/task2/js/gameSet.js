var playerNum = document.getElementById("player");
var rangeNum = document.getElementById("range");

var btnLess = document.getElementById("btnSub");
var btnPlus = document.getElementById("btnAdd");
//header部分左右按钮的点击功能
$(".header img").eq(0).click(function(){
	location.href="index.html";
});
// 滑块部分 

// $("#range").bind("input", function(e){
//     $("#range").attr('value', this.value);
// 	$("#range").css( 'background-size', (this.value)*0.7 + '0% 100%' ); 
// });

function inputChange(){
	if (playerNum.value >=4 && playerNum.value <=18) {
		rangeNum.value = playerNum.value;
	}
	else {
		alert("请输入正确人数(4~18人)");
		playerNum.value = 8;
		rangeNum.value = 8;
	}
}
function moveChange(){
	playerNum.value = rangeNum.value;
}
function less(){
	rangeNum.value--;
	if (rangeNum.value<4) {
		alert("4个人都没有，你还是刷微博吧：）")
	} 
	else {
		playerNum.value = rangeNum.value;
	}
}
function add(){
	rangeNum.value++;
	if (rangeNum.value>18) {
		alert("你确定那么多小伙伴要打包？")
	} 
	else {
		playerNum.value = rangeNum.value;
	}
}

var ul = document.getElementById("list");
// 构造玩家数组
var all=[];
function getPlayer(){
	for(var i=0;i<playerNum.value;i++){
		if(i<Math.floor((1/3)*playerNum.value)){
			all.push(1);
		}
		else {
			all.push(0);
		}
	}
console.log(all);
}
//打乱人数
function shuffle(all){
	for (var i=playerNum.value-1,s,t; i>0; i--){
		s= Math.floor(Math.random()*i);
		t=all[i];
		all[i]=all[s];
		all[s]=t;
		}
	return all;
}
// 渲染出li样式
function getLi(){
	for (var i=0;i<playerNum.value;i++) {
		var li = document.createElement("li");
		ul.appendChild(li);
		if(all[i]==1){
			li.innerHTML = "杀手 1 人";
			li.style.color = "#002FA7";
		}
		else{
			li.innerHTML = "平民 1 人";
			li.style.color = "#29bde0";
		}
	}
}
// 点击事件
function getRole(){
	all=[];
	getPlayer(); //获取玩家人数
	ul.innerHTML = "";  //还原样式设置；
	shuffle(all);
	getLi();
	console.log(all);
	sessionStorage.setItem ("all",JSON.stringify(all));// 把数据存在sessionStorage上；
	// sessionStorage.all = JSON.stringify(all);
}
//点击发牌，跳转页面
$(".card").click(function(){
	console.log(all===[]);
	if(all.length==0){
		alert("请正确设置游戏参数！")
	}
	else {
		location.href="showRoles.html"
	}
})
//回退到首页
function backHome(){
	sessionStorage.clear();
	window.location.href="index.html";
} 


// 把卧底词组和平民词组存在sessionStorage上；
// function change(){
//  	var peopleWord=$(".wordPepole").val();
// 	console.log(peopleWord);
//  	sessionStorage.setItem ("peopleWord",JSON.stringify(peopleWord));
// 	var killerWord=$(".wordKiller").val();
// 	console.log(killerWord);
//  	sessionStorage.setItem ("killerWord",JSON.stringify(killerWord));
// }


//分成2个数组写的思路
// 将arr乱序
// function randomPlayer(){
// 	1.获取input.value来得到数组长度；
// 	2.分别渲染出2个数组li；function getkiller()；function getPeople();
// 	3.抽牌；function shuffle();
// }
// [{id:1;live:0},{id:0;live:0},{}]
// 0
//  var sum=12
// killer=4
// people=8
// var all=[]
// for(var i=0;i<sum-1;i++){
// if(i<4){
// 	all.push(1)
// }
// else{
// 	all.push(0)
// }
// }
// console.log(all);

// function(){
// 	1.用all=【0，1，0，1，，，】一个一个添加进一个总人数数组，0为平民，1为杀手，分别知道相应人数。
// 	2、打乱顺序
// 	3、渲染出li样式
//   （4、对all[i]添加存活状态属性）
// }
// 获得总人数数组

// var btn_set = document.getElementById("set");
// arr.length = playerNum.value;
// var killer = new Array();
// killer.length = Math.floor((1/3)*arr.length);
// var people = new Array();
// console.log(people);
// console.log(sa);
// people.length = arr.length-killer.length;
// arr = killer.concat(people);

// var arr = document.getElementById("list");
// var li = document.createElement("li");

// function getkiller(){
// 	for(var i=0;i<killer.length;i++){
// 		var li = document.createElement("li");
// 		arr.appendChild(li);
// 		li.innerHTML = "杀手 1 人";
// all[i]==
// 		li.style.color = "#002FA7";
// 	}
// console.log("arr");