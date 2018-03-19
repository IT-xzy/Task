var a = window.sessionStorage.getItem("name");
var aas = a.split(",")
var allNum = window.sessionStorage.getItem("allNum");
var allPlayers = JSON.parse(sessionStorage.getItem("allPlayers"));
var dayTime = window.sessionStorage.getItem("dayTime");
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
$(".close").click(function(){
	if(confirm("确定要退出游戏嘛？")){
		sessionStorage.clear();
		window.location.href = "task13.html";
	}
})
