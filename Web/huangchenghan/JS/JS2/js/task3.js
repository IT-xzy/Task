var a = window.sessionStorage.getItem("name");
var aas = a.split(",")
var aaq = 1;
var deathPlayer = [];
window.sessionStorage.setItem("deathPlayer",JSON.stringify(deathPlayer));
var voteDeath = [];
window.sessionStorage.setItem("voteDeath",JSON.stringify(voteDeath));
var allNum = window.sessionStorage.getItem("allNum");
console.log(aas);
var deathKill = 0;
window.sessionStorage.setItem("deathKill",deathKill);
var deathWater = 0;
window.sessionStorage.setItem("deathWater",deathWater);
var fsm = new StateMachine({
	init: 'watch',
	transitions: [
	    { name: 'on', from: 'watch', to:'transmit'},
	    { name: 'off', from: 'transmit', to:'watch' },
	],
	methods: {
		onOn: function(){
			$("#begin").toggle();
	        $("#end").toggle();
	        $("#btn").hide();
	        $("#btn1").show();
	        if(aaq <= aas.length) {
	        	$('#btn1').text("隐藏并传递给" + aaq + "号");
	        }else {
	        	$('#btn1').text("法官查看");
	        }
	        $('#identity').text(aas[aaq-2]);
		},
		onOff: function(){
			$("#begin").toggle();
	        $("#end").toggle();
	        $("#btn1").hide();
	        $("#btn").show();
	        $('#btn').text("查看" + aaq + "号身份");
       	    $('#order').text(aaq)
		}
	}
});
	$("#btn").click(function(){
	aaq++;
	fsm.on();
});
	$('#btn1').click(function(){
	if($('#btn1').text()== "法官查看"){
		window.location.href = "js3-2.html" 
	} else {
		fsm.off();
	}
});
/*var gameRole = '';
for (var i in aas) {
	gameRole
	    += "<div class = 'player'>"
	    + "<div class='pack'>"
	    + "<div class='name'>"
	    + "<p>"
	    + aas[i]
	    + "</p>"
	    + "</div>"
	    + "<div class='number'>"
	    + "<p>"
	    + (++i)
	    + "号"
	    + "</p>"
	    + "</div>"
	    + "</div>"
}*/
function judge() {
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
//$("#judge").eq(0).html(gameRole);
var day = 1;
function playGame() {
	window.location.href = "js4.html";
	sessionStorage.setItem("dayTime",JSON.stringify(day));
}
var allPlayers = []; //定义一个空数组，对应所有玩家号码，角色，生死状态
for (var a = 0; a < allNum; a++) {
	allPlayers[a] = {};
	allPlayers[a].number = a + 1;
	allPlayers[a].id = aas[a];
	allPlayers[a].state = 1;
}
sessionStorage.setItem('allPlayers',JSON.stringify(allPlayers));
var deadNums = [];
sessionStorage.setItem('deadNums',JSON.stringify(deadNums));
var deadNum = [];
sessionStorage.setItem('deadNum',JSON.stringify(deadNum));
$(".close").click(function(){
	if(confirm("确定要退出游戏嘛？")){
		sessionStorage.clear();
		window.location.href = "task13.html";
	}
})
