//从sessionStorage中获取数据
all=JSON.parse(sessionStorage.getItem("all"));
console.log(all);
// 取到死亡的杀手数组，做判断的时候要用
diedKiller=JSON.parse(sessionStorage.getItem("diedKiller"));
// 创建被处决的杀手数组
if(diedKiller==null){
	var diedKiller=[];
	sessionStorage.setItem("diedKiller",JSON.stringify(diedKiller));
}
//渲染出标签
for (var i = 0; i < all.length; i++){
	var player='<div class="player"><div class="people"><div class="vocation"></div><div class="number"></div></div><div class="hover"><img src="img/knife.png"></div></div>'
	$(".main").prepend(player);
}
//给盒子加上对应玩家身份
for(var i=0;i<all.length;i++){
	$(".number").eq(i).text(i+1);
	if (all[i]==1){
		$(".vocation").eq(i).text("杀手");
	} 
	else{
		$(".vocation").eq(i).text("平民");
	}
}
// 要加条件判断 只有第一天！ 对$(".people").eq(-1)单独重置样式
// $(".people").eq(-1).css("opacity","1");

// 对死者渲染样式
died=JSON.parse(sessionStorage.getItem("died"));
console.log(died);
for(i=0;i<died.length;i++){
	$(".people").eq(died[i]-1).css("opacity","0.5");
};
// 获取选择的玩家身份和序号
var number;
var role;
$(".people").mouseenter(function (){
	number=$(this).find(".number").text();
	console.log(number);
	role=$(this).find(".vocation").text();
	console.log(role);	
})
//点击bottom按钮功能
$(".footer").click(function(){
	if(died.indexOf(number)!=-1){
		alert("请放过死者：）");		
	}
	if((died.indexOf(number)==-1)){
		died.push(number); //杀人后亡者放入死亡数组
		sessionStorage.setItem("died",JSON.stringify(died));
		var votedRole=JSON.parse(sessionStorage.getItem("votedRole"));
		if(votedRole==null){
			var votedRole=[]; //创建被投死的玩家身份数组
		}
		votedRole.push(role);
		sessionStorage.setItem("votedRole",JSON.stringify(votedRole));
		console.log(votedRole);
		if(all[number-1]==1){
			diedKiller.push(number);
			sessionStorage.setItem("diedKiller",JSON.stringify(diedKiller));
			console.log(diedKiller);
		};
		// 健在的杀手人数:survivorKiller.length=Math.floor((1/3)*all.length)-diedKiller.length //杀人总人数-死亡的杀人人数;
		// 幸存者人数:survivor.length=Math.ceil((2/3)*all.length)-(died.length-diedKiller.length) //总平民人数-死亡的平民人数 
		// var diedKiller=JSON.parse(sessionStorage.getItem("diedKiller"));
		// console.log(diedKiller);
		if((Math.floor((1/3)*all.length)-diedKiller.length)==0||(Math.floor((1/3)*all.length)-diedKiller.length)>=(Math.ceil((2/3)*all.length)-(died.length-diedKiller.length)) ){
			window.location.href="result.html";
		}
		else{
			day=sessionStorage.getItem("day");
			// day=JSON.parse(sessionStorage.getItem("day"));
		    day++; // 如果继续游戏,天数增加;
		    console.log(day);
			sessionStorage.setItem("day",day);
			window.location.href="game.html";			
		}
	}
});
	   
if(sessionStorage.getItem("trans2")!=null&&sessionStorage.getItem("trans3")!=null&&sessionStorage.getItem("trans4")!=null){
	sessionStorage.removeItem("trans1");	
	sessionStorage.removeItem("trans2");	
	sessionStorage.removeItem("trans3");	
	sessionStorage.removeItem("trans4");	
}
