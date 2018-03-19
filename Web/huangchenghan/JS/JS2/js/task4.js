var allPlayers = JSON.parse(sessionStorage.getItem("allPlayers"));
var deathPlayer = JSON.parse(sessionStorage.getItem('deathPlayer'));
var voteDeath = JSON.parse(sessionStorage.getItem('voteDeath'));
var dayTime = window.sessionStorage.getItem('dayTime');
var killPlayer = 0 ;
var waterPlayer = 0;
var deathKill = window.sessionStorage.getItem("deathKill");
var deathWater = window.sessionStorage.getItem("deathWater");
var game = new StateMachine({
	init: 'step0',
	transitions: [
	    { name: 'kill', from: 'step0', to:'step1'},
	    { name: 'words', from: 'step1', to:'step2'},
	    { name: 'say', from: 'step2', to:'step3'},
	    { name: 'vote', from: 'step3', to: 'step0'},
	    { name: 'goto', from: '*', to: function(a) {return a}}
	],
	methods: {
		onKill:function(){
			$("#step1 p").css("background-color","#9A9A9A");
			$("#step1 .caret-l").css("border-top-color","#9A9A9A");
			var stateDie = game.state;
			window.sessionStorage.setItem("stateDie",stateDie);
			window.location.href = "kill.html";
		},
		onWords:function(){
			$("#step2 p").css("background-color","#9A9A9A");
			$("#step2 .caret-l").css("border-top-color","#9A9A9A");
			var stateLast = game.state;
			window.sessionStorage.setItem("stateLast",game.state);			
		},
		onSay:function(){
			$("#step3 p").css("background-color","#9A9A9A");
			$("#step3 .caret-l").css("border-top-color","#9A9A9A");
			alert("请存活玩家依次发言");
			window.sessionStorage.setItem("stateSay",game.state);
		},
		onVote:function(){
			$("#step4 p").css("background-color","#9A9A9A");
			$("#step4 .caret-l").css("border-top-color","#9A9A9A");
			$(window).attr('location','vote.html');
			window.sessionStorage.setItem("stateVote",game.state);
		},		
	},
});
$("#step1").click(function(){
	game.goto('step0');
	sessionStorage.setItem('died','');
	game.kill();	
});
var stateDie = window.sessionStorage.getItem("stateDie");
if(stateDie === "step1"){
	game.goto("step1");
	$("#step1 p").css("background-color","#9A9A9A");
	$("#step1 .caret-l").css("border-top-color","#9A9A9A");
	$("#step1").off("click");
	$(".kill").css("visibility","visible");
	$(".kill>span:eq(0)").text(deathPlayer[0]);
    $(".kill>span:eq(1)").text(allPlayers[deathPlayer[0]-1].id);
    };
if(game.state == "step1") {
$("#step2").click(function(){
	game.goto('step1');
	alert("请死者发表遗言");
	game.words();
	$("#step2").off("click");
});
} else if (game.state === "step0"){
	$("#step2").click(function(){
	alert("请先杀人");
	});
}
var stateLast = window.sessionStorage.getItem("stateLast");
if(stateLast === "step2"){
	game.goto('step2');
	$("#step2 p").css("background-color","#9A9A9A");
	$("#step2 .caret-l").css("border-top-color","#9A9A9A");
	$("#step2").off("click");
};
$("#step3").click(function(){
	if(game.state == 'step2'){
	    game.goto('step2');
	    game.say();
	    $("#step3").off("click");
	} else {
		alert("还没到这个步骤哦！");
	}
});
var stateSay = window.sessionStorage.getItem("stateSay");
if(stateSay === "step3"){
	game.goto('step3');
	$("#step3 p").css("background-color","#9A9A9A");
	$("#step3 .caret-l").css("border-top-color","#9A9A9A");
	$("#step3").off("click");
};
$("#step4").click(function(){
	if(game.state == 'step3'){
		game.goto('step3');		
		game.vote();
	} else {
		alert("还没到这个步骤哦！");
	}
});
var stateVote = window.sessionStorage.getItem("stateVote");
if(stateVote === "step0"){
	game.goto('step0');
	$("#step4 p").css("background-color","#9A9A9A");
	$("#step4 .caret-l").css("border-top-color","#9A9A9A");
	$("#step4").off("click");
	$(".vote").css("visibility","visible");
	$(".vote>span:eq(0)").text(voteDeath[0]);
    $(".vote>span:eq(1)").text(allPlayers[voteDeath[0]-1].id);
}

/*if(stateVote !== null){
	$(".arrow").hide();
	$(".detail").hide();
}*/
$('.daySet').text('第' + dayTime + '天');
if (dayTime > 1) {
	for( i=0;i<dayTime-1;i++){
		var day = i + 1;
		var dayss = i;
		var html = '<div class="container-8">'
			+ '<div class="tle">'
			+	'<div class="day">第' + day +'天</div>'
			+    '<div class="caret-r"></div>'
			+'</div>'
			+'<p class="arrow hidden1"></p>'
			+ '<div class="detail hidden1">'
			+    '<div class="chose">'
			+		'<img src="img/流程_03.png" class="list">'	
			+		'<span class="caret-l grays"></span>'
			+		'<p class= "gray">杀手杀人</p>'					
			+	'</div>'
			+	'<div class="message kill message1">'					
			+		'<span class="span1"></span>号被杀手杀死，真实身份是<span class="span2"></span>'
			+	'</div>'
			+	'<div class="chose">'
			+		'<img src="img/流程_06.png" class="list">'	
			+        '<span class="caret-l grays"></span>'
			+		'<p class= "gray">亡灵发表遗言</p>'
			+	'</div>'
			+	'<div class="chose">'
			+		'<img src="img/123.png" class="list">'
			+		'<span class="caret-l grays"></span>'
			+		'<p class= "gray">玩家依次发言</p>'
			+	'</div>'
			+	'<div class="chose">'
			+		'<img src="img/123.png" class="list">'
			+		'<span class="caret-l grays"></span>'
			+		'<p class= "gray">全民投票</p>'
			+	'</div>'
			+	'<div class="message vote message2">'
			+		'<span class="span1"></span>号被投票杀死，真实身份是<span class="span2"></span>'
			+	'</div>'
			+ '</div>'			
		    +'</div>';
		$(".days").before(html);
		$(".hidden1").hide();
		$(".message1").css("visibility","visible");
		$(".message1").eq(dayss).children(".span1").text(deathPlayer[dayss]);
		$(".message1").eq(dayss).children(".span2").text(allPlayers[deathPlayer[dayss]-1].id);
		$(".message2").css("visibility","visible");	         
		$(".message2").eq(dayss).children(".span1").text(voteDeath[dayss]);
        $(".message2").eq(dayss).children(".span2").text(allPlayers[voteDeath[dayss]-1].id);
	}
}
$(".tle").click(function(){
	$(this).next().toggle();
	$(this).next().next().toggle();
})
for (var i = 0; i < allPlayers.length; i++) {
	allPlayers[i].id;
	console.log(allPlayers[i].id);
	if(allPlayers[i].id == "杀手") {
		killPlayer++;
		window.sessionStorage.setItem("killPlayer",killPlayer)
	} else if (allPlayers[i].id == "平民") {
		waterPlayer++;
		window.sessionStorage.setItem("waterPlayer",waterPlayer)
	}
}
var surplusWater = waterPlayer - deathWater;
window.sessionStorage.setItem("surplusWater",surplusWater);
var surplusKill = killPlayer - deathKill;
window.sessionStorage.setItem("surplusKill",surplusKill);
$(".close").click(function(){
	if(confirm("确定要退出游戏嘛？")){
		sessionStorage.clear();
		window.location.href = "task13.html";
	}
});//退出游戏并清除sessionStorage
