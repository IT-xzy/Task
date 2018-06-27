//初次渲染

	oodiv=
	'<div class="container">'
		+'<p class="days">'+'</p>'
		+'<ul>'
			+'<li class="step1">'
				+'<img class="img_1" src="images/js2-5_2.png">'
				+'<div class="triangle triangle-1">'+'</div>'+"杀手杀人"
			+'</li>'
			+'<div class="deadMessage">'+'</div>'
			+'<li class="step2">'+'<div>'+'</div>'+"亡灵发表遗言"+'</li>'
			+'<li class="step3">'
				+'<img class="img_2" src="images/js2-5_1.png">'
				+'<div class="triangle  triangle-2">'+'</div>'+"玩家依次发言"
			+'</li>'
			+'<li class="step4">'+'<div>'+'</div>'+"全民投票"+'</li>'
				+'<div class="voteMessage">'+'</div>'
		+'</ul>'
	+'</div>'
	+'<div class="btn">'
		+'<button id="next">'+"进入下一天"+'</button>'
	+'</div>'

		$(".main").append(oodiv);


$(".days").on("click",function(){
	$(".container ul").toggle();
})
//返回上一页
//跳转下一页
// var alive=[];
$(".btn button").on("click",function(){
	//去除死者
		for (var i = 0; i < allDeads.length; i++) {
		players.splice(allDeads[i],1);
	}
	//遍历剩余玩家数
	var shaShou=0;
	var pinMin=0;
	for (var j = 0; j <players.length; j++) {
		if (players[j]=="杀手") {
		 shaShou++;
		console.log(shaShou);
	}
	if (players[j]=="平民") {
		pinMin++
	console.log(pinMin);
		}
	}
	//游戏结果
	if (shaShou>pinMin) {
		alert("杀手获胜")
	}else if(shaShou==0){
		alert("平民获胜")
	}else {
	$(".container ul").toggle();
		$(".main").append(oodiv)
		

		}



});


//取玩家身份
var arr = sessionStorage.players;
players = JSON.parse(arr);
console.log("玩家"+players)
//设置天数
var days=1;

for(var d=0;d<days;d++){
		$(".main").append(oodiv);
sessionStorage.days=days;
$(".container p").text("第"+days+"天")
}
//本页死亡信息
var deads=sessionStorage.deads;
deads=parseInt(deads);
//本次投票信息
var vote=sessionStorage.vote;
vote=parseInt(vote)
//所有死亡信息
// var allDeads=new Array();
// for (var i = 0; i < 3; i++) {
// 	allDeads.push(deads)
// 	allDeads.push(vote)
// 	str=JSON.stringify(allDeads)
// 	sessionStorage.allDeads=str;
// }
//
//
//
//
// console.log(sessionStorage.allDeads);



//显示杀人结果
if(deads){
	var deadMessage='昨天'+(deads+1)+"号玩家被杀，他的身份是"+players[deads];
		$(".deadMessage").text(deadMessage);
}
//显示投票结果
if(vote){
	var voteMessage='昨天'+(vote+1)+"号玩家被投，他的身份是"+players[vote];
		$(".voteMessage").text(voteMessage);
		$(".btn").addClass("show")
		$(".step1").addClass("bRed");
		$(".triangle-1").addClass("triangle2");
		$(".step2").addClass("bRed");
		$(".triangle-2").addClass("triangle2");
		$(".step3").addClass("bRed");
		$(".step4").addClass("bRed");
}else {
		$(".btn").addClass("hidden")

}

//返回页面的样式

if(sessionStorage.kill){
	pages=sessionStorage.kill;
		$(".step1").addClass("bRed");
		$(".triangle-1").addClass("triangle2");
}else {
	pages="0";
}
//事件
$('.step1').on("click",function(){
	if (pages=="0") {
			menu.transition();
	}else{
		alert("请按顺序点击");
	}
})
$('.step2').on("click",function(){
	if (pages=="1") {
			menu.transition();
	}else{
		alert("请按顺序点击");
	}
})
$('.step3').on("click",function(){
	if (pages=="2") {
			menu.transition();
	}else{
		alert("请按顺序点击");
	}
})
$('.step4').on("click",function(){
	if (pages=="3") {
			menu.transition();
	}else{
		alert("请按顺序点击");
	}
})
//
// $(".main li:eq("+pages+")").click(function(){
//
// })

var menu = {

　　　　// 当前状态
　　　　currentState: pages,

　　　　// 状态转换
　　　　transition: function(event){
　　　　　　switch(this.currentState) {
　　　　　　　　case "0":
						$(".step1").addClass("bRed");
						$(".triangle-1").addClass("triangle2");
								alert("进入杀人页")
								$(".step1").addClass("bRed");
								  location.href="js2-6.html";
								　this.currentState = "1";
								sessionStorage.kill=this.currentState;
									pages=sessionStorage.kill;
　　　　　　　　　break;
							case "1":
							$(".step1").addClass("bRed");
							$(".triangle-1").addClass("triangle2");
							$(".step2").addClass("bRed");
								console.log(pages)
　　　　　　　　　　this.currentState = "2";
									sessionStorage.kill=this.currentState;
										pages=sessionStorage.kill;
									alert("请亡灵发表遗言")
　　　　　　　　　　break;
							case "2":
							$(".step1").addClass("bRed");
							$(".triangle-1").addClass("triangle2");
							$(".step2").addClass("bRed");
							$(".triangle-2").addClass("triangle2");
							$(".step3").addClass("bRed");
　　　　　　　　　　this.currentState = "3";
									sessionStorage.kill=this.currentState;
										pages=sessionStorage.kill;
										alert("请玩家依次发言")
　　　　　　　　　　break;
							case "3":
							$(".step1").addClass("bRed");
							$(".triangle-1").addClass("triangle2");
							$(".step2").addClass("bRed");
							$(".triangle-2").addClass("triangle2");
							$(".step3").addClass("bRed");
							$(".step4").addClass("bRed");
　　　　　　　　　　this.currentState = "0";
									sessionStorage.kill=this.currentState;
										pages=sessionStorage.kill;
									alert("进入全民投票");
									location.href="js2-7.html";
　　　　　　　　　　break;
　　　　　　}
　　　　}
};
