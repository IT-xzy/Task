var allNum = window.sessionStorage.getItem("allNum");
var allPlayers = JSON.parse(sessionStorage.getItem("allPlayers"));
var deathPlayer = JSON.parse(sessionStorage.getItem('deathPlayer'));
var voteDeath = JSON.parse(sessionStorage.getItem('voteDeath'));
var dayTime = window.sessionStorage.getItem("dayTime");
var killPlayer = window.sessionStorage.getItem("killPlayer");
var waterPlayer = window.sessionStorage.getItem("waterPlayer");
var deathKill = window.sessionStorage.getItem("deathKill");
var deathWater = window.sessionStorage.getItem("deathWater");
var surplusWater = window.sessionStorage.getItem("surplusWater");
var surplusKill = window.sessionStorage.getItem("surplusKill");
var killWiner = window.sessionStorage.getItem("killWiner");
if(killWiner !== "killWiner"){
	for ( i = 0; i <dayTime;i++){
	var day = i;
	var html = '<div class="list">'
				+	'<div class="title">'
				+		'<span class="day">第' + (day+1) +'天</span>'
				+	    '<span class="time">0小时07分</span>'
				+	'</div>'
				+	'<div class="about">'
				+		'<p>晚上：'+ deathPlayer[day] +'号被杀手杀死，他是'+ allPlayers[deathPlayer[day]-1].id + '</p>'
				+		'<p>白天：'+ voteDeath[day] +'号被投票杀死，他是'+ allPlayers[voteDeath[day]-1].id + '</p>'
				+	'</div>'
				+'</div>';
	$(".record").append(html);
} 
}else {
	for ( i = 0; i <dayTime-1;i++){
	var day = i;
	var html = '<div class="list">'
				+	'<div class="title">'
				+		'<span class="day">第' + (day+1) +'天</span>'
				+	    '<span class="time">0小时07分</span>'
				+	'</div>'
				+	'<div class="about">'
				+		'<p>晚上：'+ deathPlayer[day] +'号被杀手杀死，他是'+ allPlayers[deathPlayer[day]-1].id + '</p>'
				+		'<p>白天：'+ voteDeath[day] +'号被投票杀死，他是'+ allPlayers[voteDeath[day]-1].id + '</p>'
				+ '<p class="p2"></p>'
				+	'</div>'
				+'</div>';
	$(".record").append(html);
	var html1 = '<div class="list">'
	            +   '<div class="title">'
				+		'<span class="day">第' + (day+2) +'天</span>'
				+	    '<span class="time">0小时07分</span>'
				+	'</div>'
				+	'<div class="about">'
				+		'<p>晚上：'+ deathPlayer[deathPlayer.length-1] +'号被杀手杀死，他是'+ allPlayers[deathPlayer[day+1]-1].id + '</p>'
				+ '<p class="p2"></p>'
				+	'</div>'
				+'</div>';
	$(".list").eq(deathPlayer.length-2).after(html1);
	}
}
/*
for ( i = 0; i <dayTime;i++){
	var day = i;
	var html = '<div class="list">'
				+	'<div class="title">'
				+		'<span class="day">第' + (day+1) +'天</span>'
				+	    '<span class="time">0小时07分</span>'
				+	'</div>'
				+	'<div class="about">'
				+		'<p>晚上：'+ deathPlayer[day] +'号被杀手杀死，他是'+ allPlayers[deathPlayer[day]-1].id + '</p>'
				/*+		'<p>白天：'+ voteDeath[day] +'号被投票杀死，他是'+ allPlayers[voteDeath[day]-1].id + '</p>'
				+ '<p class="p2"></p>'
				+	'</div>'
				+'</div>';
	$(".record").append(html);
	/*if(deathPlayer[day]) {
		var html1 = '<p>晚上：'+ deathPlayer[day] +'号被杀手杀死，他是'+ allPlayers[deathPlayer[day]-1].id + '</p>';
		$(".p1").html(html1);
	};
	if(voteDeath[day]){
		var html2 = '<p>白天：'+ voteDeath[day] +'号被投票杀死，他是'+ allPlayers[voteDeath[day]-1].id + '</p>';
		$(".p2").html(html2);
	}
}*/
$(".spk").text(surplusKill);
$(".spw").text(surplusWater);
if(surplusKill == 0){
	$(".winer").text("平民胜利");
} else {
	$(".winer").text("杀手胜利");
	$(".tips").text("本轮游戏共抓出杀手" + deathKill + "人，平民被杀"+ deathWater + "人，共经历了" + voteDeath.length + "个白天。");
}
$(".return").click(function(){
	sessionStorage.clear();
})
