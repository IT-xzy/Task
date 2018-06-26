//从sessionStorage中获取数据
all=JSON.parse(sessionStorage.getItem("all"));
console.log(all);

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
// 定义杀人页面的状态机
// var fsm = new StateMachine({
// 	init:"none",
// 	transitions:[
// 		{name:"ready",from:"none",to:"choose"},
// 		// {name:"begin",from:"choose",to:"sure"},
// 	],
// 	methods:{
// 		onReady:function(){
// 		}
// 	},
// })
// 获取选择的玩家身份和序号
var role; //在全局中定义变量role,后面else判断条件才能执行，否者会出现role未定义，执行到if里面的condition的时候就报错，就不会执行到else语句。
// 对死者渲染样式
died=JSON.parse(sessionStorage.getItem("died"));
console.log(died);
if(died!=null){
	for(i=0;i<died.length;i++){
		$(".people").eq(died[i]-1).css("opacity","0.5");
	};	
};
$(".people").mouseenter(function (){
	number=$(this).find(".number").text();
	console.log(number);
	role=$(this).find(".vocation").text();
	console.log(role);	
})
//点击bottom按钮功能
$(".footer").click(function(){
	console.log(role);
	if(role=="杀手"){
		alert("不是吧，对自己人下黑手！")
	}
	if(role=="平民"){
		var died=JSON.parse(sessionStorage.getItem("died"));
		if(died==null){
			var died=[];
		}
		died.push(number);
		console.log(died);
		sessionStorage.setItem("died",JSON.stringify(died));
		window.location.href="game.html";
	}
	if(role==undefined){
		alert("杀个人再走吧，兄弟！");
	}
})

// survivor.length=(2/3)*all.length-(died.length-diedKiller.length);
// 幸存者人数:survivor.length=(2/3)*all.length-(died.length-diedKiller.length) //总平民人数-死亡的平民人数 
// diedKiller[]在投票页面，条件判断后放入构成;