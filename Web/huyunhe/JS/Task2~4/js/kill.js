function getParams() {
  var postFixPattern = /\?.*/;
  return postFixPattern.exec(location.href);
}


$(".confirm").show();


var state = JSON.parse(sessionStorage.state);
var log = {
  day: "",
  kill: "",
  identity: ""
};
if (!sessionStorage.logArray) {
  var logArray = new Array();
} else {
  var logArray = JSON.parse(sessionStorage.logArray);
}
var persons = JSON.parse(sessionStorage.persons);
var index = 0;
var selectedId;
//是杀手杀人页面为true，是投票页面为false;
var status;
var col = '<div class="col">' +
  '<div class="identity">' +
  '<div class="identity__name" id="identity1">水民</div>' +
  '<div class="identity__number">1号</div>' +
  '</div>' +
  '<div class="identity__kill"><img src=./resource/kill.png></div>' +
  '</div>';

//如果是投票阶段，修改标题
if (sessionStorage.phase == "vote") {
  $(".header__title").html("投票");
}

//动态生成内容
var mod = persons.length % 3;
var main = $("main");
for (var i = 0; i < Math.floor(persons.length / 3); i++) {
  main.append($('<div class="row"></div>'));
  var lastRow = $(".row").last();
  for (var j = 0; j < 3; j++) {
    if (persons[index].identity == 0) {
      var newcol = col.replace("水民", "杀手");
    } else {
      newcol = col;
    }
    newcol = newcol.replace(/\d+/g, ++index);
    lastRow.append($(newcol))
  }
}
main.append($('<div class="row"></div>'));
for (j = 0; j < mod; j++) {
  var lastRow = $(".row").last();
  if (persons[index].identity == 0) {
    var newcol = col.replace("水民", "杀手");
  } else {
    newcol = col;
  }
  newcol = newcol.replace(/\d+/g, ++index);
  lastRow.append($(newcol))
}

//检测人员的存活情况，如果死亡调整透明度
for (i = 0; i < persons.length; i++) {
  if (persons[i].isAlive == 0) {
    $("#identity" + persons[i].id).parent().css("opacity", "0.5");
  }
}

$(".identity").addClass("identity__hover");

$(".identity").click(function (e) {
  var pattern = /\d+/;
  selectedId = parseInt(pattern.exec(e.target.id));
});

$(".confirm").click(function (e) {
  if (!selectedId) {
    alert("请选择！");
    return;
  }
  if (persons[selectedId - 1].isAlive == 0) {
    alert("该玩家已经死亡，请选择其他玩家！");
    return;
  }else if (sessionStorage.phase == "kill") {
    if (persons[selectedId - 1].identity == 0) {
      alert("杀手不能杀死自己的同伴，请选择其他玩家！");
      return;
    }
  }
    //杀死选择的人
    persons[selectedId - 1].isAlive = 0;
    log.day = state.day;
    log.kill = persons[selectedId - 1].id;
    log.identity = persons[selectedId - 1].identity;
    logArray.push(log);
    if(sessionStorage.phase == "vote"){
      state.step = "1";
      state.day = parseInt(state.day)+1;
    }
    sessionStorage.persons = JSON.stringify(persons);
    sessionStorage.logArray = JSON.stringify(logArray);
    sessionStorage.state = JSON.stringify(state);

    //杀死人过后检查平民/杀手是否还有存活，如没有存活，跳转到结果页面
    var isCitizenAliveCount = 0;
    var isKillerAliveCount = 0;
    for(i = 0;i<persons.length;i++){
      if(persons[i].identity == "1" && persons[i].isAlive == "1"){
        isCitizenAliveCount++;
      }
      else if(persons[i].identity == "0" && persons[i].isAlive == "1"){
        isKillerAliveCount++;
      }
    }
    sessionStorage.killerRemain = isKillerAliveCount;
    sessionStorage.citizenRemain = isCitizenAliveCount;

    if(isCitizenAliveCount == 0 || (isKillerAliveCount >= isCitizenAliveCount && sessionStorage.phase == "vote")){
      sessionStorage.win = "killer";
      location.assign("./task2-result.html");
      return;
    }
    else if(isKillerAliveCount == 0){
      sessionStorage.win = "citizen";
      location.assign("./task2-result.html");
      return;
    }

    location.href = "./task2-start.html" + getParams();

});

//点击关闭按钮
$(".close").click(function() {
  var s = confirm("结束本轮游戏吗?");
  if(s == true){
    location.href = "./task2-home.html";
  }
  else{
    return;
  }
});