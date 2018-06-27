// 设置状态机
var fsm = new StateMachine({
	init:'none',
	transitions:[
		{name:'transOne',from:'none',to:'kill'},
		{name:'transTwo',from:'kill',to:'speak'},
		{name:'transThr',from:'speak',to:'talk'},
		{name:'transFour',from:'talk',to:'vote'},
		{name:'transFive',from:'vote',to:'none'},
		{name:'goto',form:'*',to:function(state){return state}}
	],
	methods:{
		onTransOne: function(){
			var trans1=fsm.state;
			sessionStorage.setItem ("trans1",JSON.stringify(trans1));
			console.log(fsm.state);
			window.location.href="kill.html";
		},
		// onEnterKill: function(){
		// 	$(".content").eq(0).addClass('dark');
		// 	$(".triangle-left").eq(0).addClass('darkLeft');
		// },
		onTransTwo:function(){
			var trans2=fsm.state;
			sessionStorage.setItem("trans2",JSON.stringify(trans2));
			alert("请死者发表遗言！");
		},
		onEnterSpeak:function(){
			$(".content").eq(4*day-3).addClass('dark');
			$(".triangle-left").eq(4*day-3).addClass('darkLeft');
		},
		onTransThr:function(){
			var trans3=fsm.state;
			sessionStorage.setItem ("trans3",JSON.stringify(trans3));
			alert("请玩家依次发表！");
		},
		onEnterTalk:function(){
			$(".content").eq(4*day-2).addClass('dark');
			$(".triangle-left").eq(4*day-2).addClass('darkLeft');
		},
		onTransFour:function(){
			var trans4=fsm.state;
			sessionStorage.setItem ("trans4",JSON.stringify(trans4));
			window.location.href="vote.html";
		},
	}
});
console.log(fsm.state);
// 定义天数变量
var day = sessionStorage.getItem("day");
if(day==null){
	day=1;
	sessionStorage.setItem("day", day);
}
console.log(day);
// 第二天之后
for(i=1;i<day;i++){
	$(".main").append($(".day").eq(0).clone());
}
// 已进行的天数默认为折叠状态
for(i=1;i<day;i++){
	$(".game").eq(i-1).hide(1000);
}
// 给已进行的天数的样式渲染
for(i=4;i<4*day;i++){
	$(".content").eq(i-4).addClass("dark");
	$(".content").eq(i-4).addClass("alert");
	$(".triangle-left").eq(i-4).addClass("darkLeft");
}
// 给非活动天数按钮添加弹出框
$(".alert").click(function(){
	alert("好好玩你的游戏，别手贱：）");
});
// 取到亡者数组
died=JSON.parse(sessionStorage.getItem("died"));
// 取到被处决的玩家身份数组
votedRole=JSON.parse(sessionStorage.getItem("votedRole"));
// 渲染已进行的天数的游戏过程
for(i=1;i<day;i++){
	// 渲染被杀手杀死的死者身份
	$(".row").eq(4*i-4).after('<div class="died"></div>');
	$(".died").eq(2*i-2).text(died[2*i-2]+"号玩家被杀死，真实身份是平民");
	// 渲染被处决的玩家身份
	$(".row").eq(4*i-1).after('<div class="died"></div>');
	$(".died").eq(2*i-1).text(died[2*i-1]+"号玩家被投票处决，真实身份是"+votedRole[i-1]);
}
// 对天数进行渲染
for(i=0;i<day;i++){
	$(".date").eq(i).text("第"+(i+1)+"天");
}
// 点击天数时的样式toggle效果;
$(".date").click(function(){
	$(this).next().toggle(500);
});
// 给当前天数的四个按钮绑定上相应的状态机状态，分配状态
// 第一个按钮
$(".content").eq(4*day-4).click(function(){
	if(fsm.state=="none"){
		fsm.transOne();		
	}
	else{
		alert("请按游戏顺序进行");
	}
});
// 杀人页面跳转回来后，从sessionStorage上拿取当前状态，跳转到kill状态，好执行下一步；
trans1=JSON.parse(sessionStorage.getItem("trans1"));
died=JSON.parse(sessionStorage.getItem("died"));
console.log(died);
if(trans1=="kill"){
	fsm.goto("kill"); 
	$(".content").eq(4*day-4).addClass('dark');
	$(".triangle-left").eq(4*day-4).addClass('darkLeft');
	$(".row").eq(4*day-4).after('<div class="died"></div>');
	$(".died").eq(2*day-2).text(died[2*day-2]+"号玩家被杀死，真实身份是平民");
}
// 第二个按钮
$(".content").eq(4*day-3).click(function(){
	if(fsm.state=="kill"){
		fsm.transTwo();
	}
	else{
		alert("请按游戏顺序进行");
	}
});
// 刷新后从sessionStorage上将刷新前保存的状态拿取下来
trans2=JSON.parse(sessionStorage.getItem("trans2"));
if(trans2=="speak"){
	fsm.goto("speak");
}
// 第三个按钮
$(".content").eq(4*day-2).click(function(){
	if(fsm.state=="speak"){
		fsm.transThr();
	}
	else{
		alert("请按游戏顺序进行");
	}
});
trans3=JSON.parse(sessionStorage.getItem("trans3"));
if(trans3=="talk"){
	fsm.goto("talk");
}
// 第四个按钮
$(".content").eq(4*day-1).click(function(){
	if(fsm.state=="talk"){
		fsm.transFour();
	}
	else{
		alert("请按游戏顺序进行");
	}
});
// 法官日志按钮
$(".right").click(function(){
	window.location.href="infor.html";
});
// 投票页面跳转回来后，从sessionStorage上拿取当前状态，跳转到vote状态，好执行下一步；
trans4=JSON.parse(sessionStorage.getItem("trans4"));
// 拿到投票页面死者的身份和玩家序号
votedRole=JSON.parse(sessionStorage.getItem("votedRole"));
console.log(votedRole);
if(trans4=="vote"){
	fsm.goto("vote"); 
	fsm.goto("none"); //从投票页面回来后回到初始状态
}
//回退按钮设置
function backGame(){
	sessionStorage.clear();
	window.location.href="gameSet.html";
} 
function backHome(){
	sessionStorage.clear();
	window.location.href="index.html";
} 
