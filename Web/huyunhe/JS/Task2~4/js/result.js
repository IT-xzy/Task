
var logArray = JSON.parse(sessionStorage.logArray);
var state = JSON.parse(sessionStorage.state);

if(sessionStorage.win == "citizen"){
  $(".picture").children().attr("src","./resource/citizenWin.png");
}
else if(sessionStorage.win == "killer"){
  $(".picture").children().attr("src","./resource/killerWin.png");
}

$(".remain__killer").html("杀手： " + sessionStorage.killerRemain + " 人");
$(".remain__citizen").html("平民： " + sessionStorage.citizenRemain + " 人");

//动态生成内容
for(var i = 0;i<state.day - 1;i++){

var listItem =  '<div class="list-item">' +
'<div class="list-date">'+
'  <span class="list-day">'+
'    第'+(i+1)+'天'+
'  </span>'+
'</div>'+
'<div class="list-night">'+
'  晚上：'+logArray[2*i].kill +'号被杀手杀死，'+logArray[2*i].kill+'号是水民'+
'</div>'+
'<div class="list-daytime">'+
'  白天：'+logArray[2*i+1].kill +'号被全民投票投死，'+logArray[2*i+1].kill +'号是'+
(logArray[2*i+1].identity == 0?"杀手":"水民" ) +
'</div>'+
'</div>'

$(".list").append(listItem);
}
if(logArray[2*i]){
  var listItem =  '<div class="list-item">' +
'<div class="list-date">'+
'  <span class="list-day">'+
'    第'+(i+1)+'天'+
'  </span>'+
'</div>'+
'<div class="list-night">'+
'  晚上：'+logArray[2*i].kill +'号被杀手杀死，'+logArray[2*i].kill+'号是水民'+
'</div>'+
'<div class="list-daytime">'+
'  白天：'+
'</div>'+
'</div>'
$(".list").append(listItem);
}




$(".oncemore").click(function (e) {
  sessionStorage.clear();
  location.href = "./task2-assign.html";
});