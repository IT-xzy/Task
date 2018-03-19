var a = window.sessionStorage.getItem("name");
var aas = a.split(",")
var allNum = window.sessionStorage.getItem("allNum");
var allPlayers = JSON.parse(sessionStorage.getItem("allPlayers"));
var human = window.sessionStorage.getItem("died");
var dayTime = window.sessionStorage.getItem("dayTime");
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
var position;
allPeople.parent().click(function() {
	position = $(this).parents(".player").index();
	console.log(position);
	var player = allPlayers[position].id;
	$(".knife").css('visibility','hidden');	    
	//console.log(.knife:eq(position));
	if(allPlayers[position].state == 0){
		alert('请不要鞭尸谢谢');
	}else{
		killgame.goto('living');
		killgame.start();
		$(this).next().css('visibility','visible');
	}
});
var voteDeath = JSON.parse(sessionStorage.getItem('voteDeath'));
$(".confirm").click(function(){
	if (position == undefined) {
		alert('请至少选一个人好嘛');
	} else {
	    var player = allPlayers[position].id;
	    if (confirm("确定要杀这个人嘛")){
		    if (allPlayers[position].state == 0) {
			    alert('请不要选择尸体好吗');
		    } else {
		        allPlayers[position].state = '0'; //改变成死亡
		        sessionStorage.setItem('died',died);
		        var died = killgame.state;
		        voteDeath.push(allPlayers[position].number);
		        sessionStorage.setItem('voteDeath',JSON.stringify(voteDeath));
		        sessionStorage.setItem('allPlayers',JSON.stringify(allPlayers));
		        if (allPlayers[position].id === '杀手'){
		        	deathKill++;
		        	sessionStorage.setItem("deathKill",deathKill);
		        	surplusKill = killPlayer - deathKill;
		        	sessionStorage.setItem("surplusKill",surplusKill);
		        } else if (allPlayers[position].id ==='平民'){
		        	deathWater++;
		        	sessionStorage.setItem("deathWater",deathWater);
		        	surplusWater = waterPlayer - deathWater;
		        	sessionStorage.setItem("surplusWater",surplusWater);
		        };		        
		        if(surplusKill == 0 || surplusWater <= surplusKill) {
		        	window.location.href = "end.html"
		        } else {
		            dayTime++;//进入下一天
		            sessionStorage.setItem('dayTime',dayTime);//
		            sessionStorage.removeItem('stateDie');
		            sessionStorage.removeItem('stateLast');
		            sessionStorage.removeItem('stateSay');
		            sessionStorage.removeItem('stateVote');
		            window.location.href= "js4.html";
		        }
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
