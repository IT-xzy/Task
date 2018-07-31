
function redirect() {
  var postFixPattern = /\?.*/;
  var postFix = postFixPattern.exec(location.href);
  location.href = "./task2-identity.html" + postFix;
  return postFix;
}

function getParams() {
  var postFixPattern = /\?.*/;
  return postFixPattern.exec(location.href);
}



//创建一个构造函数来生成每个人的示例，用于保存身份，存活情况和id
var Person = function (identity, isAlive, id) {
  this.identity = identity;
  this.isAlive = isAlive;
  this.id = id;
}

var day;
var index = 0;
var selectedId;
var status;
var col = '<div class="col">' +
  '<div class="identity">' +
  '<div class="identity__name" id="identity1">水民</div>' +
  '<div class="identity__number">1号</div>' +
  '</div>' +
  '<div class="identity__kill"><img src=./resource/kill.png></div>' +
  '</div>';

$(".confirm").hide();
$(".return").hide();


//如果是第一次打开游戏，则从上一个页面获取分配的数据来生成persons
if (!sessionStorage.persons || sessionStorage.totle) {
  var totle = sessionStorage.totle.split(",");
  var number = totle.length;
  var persons = new Array(number);
  for (var i = 0; i < number; i++) {
    persons[i] = new Person(totle[i], 1, i + 1);
  }
}
//如果是从法官台本返回，则直接读取sessionStorage的内容
else {
  var persons = JSON.parse(sessionStorage.persons);
  if (sessionStorage.reStart == "true") {
    $(".start").show();
    $(".return").hide();
    $(".arrow-left").css("visibility", "visible");
  } else if (sessionStorage.reStart == "false"){
    $(".start").hide();
    $(".return").show();
    $(".arrow-left").css("visibility", "hidden");
  }
}

//第一次打开游戏，day=1
if (!sessionStorage.state) {
  var state = {
    "day": "1",
    "step": "1"
  };
} else {
  var state = JSON.parse(sessionStorage.state);
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

//点击返回按钮事情
$(".return").click(function (e) {
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

//清除sessionStorage中的totle来确保能正确显示人数
sessionStorage.removeItem("totle");

//开始游戏
$(".start").click(function () {
  sessionStorage.reStart = "false";
  location.href = "./task2-start.html" + getParams();
});


sessionStorage.persons = JSON.stringify(persons);