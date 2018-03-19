var a = window.sessionStorage.getItem("name");
var aas = a.split(",")
var allNum = window.sessionStorage.getItem("allNum");
var allPlayers = JSON.parse(sessionStorage.getItem("allPlayers"));
var human = window.sessionStorage.getItem("died");
var killPlayer = window.sessionStorage.getItem("killPlayer");
var waterPlayer = window.sessionStorage.getItem("waterPlayer");
var deathKill = window.sessionStorage.getItem("deathKill");
var deathWater = window.sessionStorage.getItem("deathWater");
var surplusWater = window.sessionStorage.getItem("surplusWater");
var surplusKill = window.sessionStorage.getItem("surplusKill");
//角色添加，并将死亡的角色背景颜色设为红色
for (i = 0; i < allNum; i++) {
	$(".capacity").append(
		"<div class = 'player'>"
	   +"<div class='pack'>"
	   + "<div class='name'>"
	   + "<p>"
	   + aas[i]
	   + "</p>"
	   + "</div>"
	   + "<div class='number'>"
	   + "<p>"
	   + (i+1)
	   + "号"
	   + "</p>"
	   + "</div>"
	   + "</div>"
	   + "<div class='knife'>"
	   + "<img src='img/knife2.png' />"
	   + "</div>"
	   + "</div>"
	);
	var allPeople = $(".name");
	//var people = allPeople.find(".name");
	if (allPlayers[i].state == 0) {
		$(allPeople[i]).css('background-color','#ff6c5c');
	}
}
var killgame = new StateMachine({
	init: 'living',
	transitions:[
	    {name:'start',from:'living',to:'died'},
	    {name:'end',from:'died',to:'living'},
	    {name:'goto',from:'*',to:function(a) {return a}}
	],
	methods:{
		onLeaveLiving:function(){
			console.log(killgame.state);
		},
		onAfterStart:function(){
			console.log(killgame.state);
		}
	}
});
//方案2
/*function judge() {
	var output;
    for (i=0;i<allNum;i++) {
    	output = "<div class = 'player'> <div class='pack'> <div class='name'><p>" + aas[i] + "</p> </div> <div class='number'> <p>" + (i+1) + "号</p> </div> </div>";
    $("#judge").append(output);
    }
}
function read() {
	judge.innerHTML = '';
	judge();
}
$("#judge").eq(0).html(read());
*/
//当玩家被选择时，最后一个被选择杀死的玩家出局（但杀手只能杀平民）
/*var lastSelect;
for (var b = 0; b < allNum; b++) {
	allPeople[b].index = b;
	allPeople[b].onClick = function() {
		var deadNums = [];
		deadNum.push(allPlayer[this.index].number);
		sessionStorage.setItem('deadNums',JSON.stringify(deadNums));
		if (allPlayers[this.index].id === '杀手' || allPlayers[this.index].id === 0) {
			if (allPlayers[this.index].state === 0) {
				alert('请不要杀已经死的人');
			} else {
				alert("请不要杀你的同行，25仔")
			}
		}else {
			if (lastSelect !== undefined) {
				allPlayers[lastSelect].state = 1;
				$(allPeople[lastSelect]).css('background-color','#f5c97b');
			}
			$(allPeople[this.index]).css('background-color','#ff6c5c');
			allPlayers[this.index].state = 0;
			lastSelect = this.index;
		}
	}
}*/
var position;
allPeople.parent().click(function() {
	position = $(this).parents(".player").index();
	console.log(position);
	var player = allPlayers[position].id;
	$(".knife").css('visibility','hidden');	    
	//console.log(.knife:eq(position));
	if(player === '杀手'){
		alert('请不要杀你的同行，25仔');
		killgame.end();
	}else if(allPlayers[position].state == 0){
		alert('请不要鞭尸谢谢');
	}else{
		killgame.goto('living');
		killgame.start();
		//var died = killgame.state;
		//sessionStorage.setItem('died',died);
		//arr.push(position);
		//sessionStorage.setItem('arr',JSON.stringify(arr));
		//allPlayers[position].state = '0'; //改变成死亡
		//allPlayers[position].number = position+1; //死者序号
		//var deathPlayer = allPlayers[position].number;
			
		$(this).next().css('visibility','visible');
		//$(this).css('background-color','#ff6c5c');
		/*$('.name').off('click');
		$('.name').on('click',function(){
			alert("请不要重复杀人")
		});*/
	}
})
/*if(human == 'died') {
	$('.name').off('click');
	$('.name').on('click',function(){
		alert("请不要重复杀人")
	});
}*/
/*if(killgame.state == 'died'){	
	$(".confirm").on('click',function(){
		window.location.href= "js4.html";
	})	
} else {	
	$(".confirm").css("background-color","#9A9A9A");
}*/
var deathPlayer = JSON.parse(sessionStorage.getItem('deathPlayer'));
$(".confirm").click(function(){
	if (position == undefined) {
		alert('请至少选一个人好嘛');
	} else {
	    var player = allPlayers[position].id;
	    if (confirm("确定要杀这个人嘛")){
		    if (player === '杀手' ) {
			    alert('请选择一个不是杀手的好嘛');
		    } else if (allPlayers[position].state == 0) {
			    alert('请不要选择尸体好吗');
		    } else {
		        allPlayers[position].state = '0'; //改变成死亡
		        sessionStorage.setItem('died',died);
		        var died = killgame.state;
		        deathPlayer.push(allPlayers[position].number);
		        sessionStorage.setItem('deathPlayer',JSON.stringify(deathPlayer));
		        sessionStorage.setItem('allPlayers',JSON.stringify(allPlayers));
		        deathWater++;
		        sessionStorage.setItem("deathWater",deathWater);
		        surplusWater = waterPlayer - deathWater;
		        sessionStorage.setItem("surplusWater",surplusWater);
		        if(surplusWater <= surplusKill) {
		        	alert("杀手胜利");
		        	sessionStorage.setItem("killWiner","killWiner");
		        	window.location.href = "end.html"
		        } else {
		        	window.location.href= "js4.html";
		        };		        
		    };
	   };
	};	
});
$(".close").click(function(){
	if(confirm("确定要退出游戏嘛？")){
		sessionStorage.clear();
		window.location.href = "task13.html";
	}
})
