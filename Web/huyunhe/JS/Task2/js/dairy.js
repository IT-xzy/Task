var index = 0;
var totle = sessionStorage.totle.split(",");

var id = 1;
var number = totle.length;
var mod = number % 3;
var col = '<div class="col">' +
  '<div class="identity id="identity' + id++ + '">' +
  '<div class="identity__name">水民</div>' +
  '<div class="identity__number">1号</div>' +
  '</div>' +
  '<div class="identity__kill"><img src=./resource/kill.png></div>' +
  '</div>';

var main = $("main");
for (var i = 0; i < Math.floor(number / 3); i++) {
  main.append($('<div class="row"></div>'));
  var lastRow = $(".row").last();
  for (var j = 0; j < 3; j++) {
    if(totle[index] == 0){
      var newcol = col.replace("水民","杀手");
    }
    else{
      newcol = col;
    }
    newcol = newcol.replace("1",++index);
    lastRow.append($(newcol))
  }
}
main.append($('<div class="row"></div>'));
for (j = 0; j < mod; j++) {
  var lastRow = $(".row").last();
  if(totle[index] == 0){
      var newcol = col.replace("水民","杀手");
    }
    else{
      newcol = col;
    }
    newcol = newcol.replace("1",++index);
    lastRow.append($(newcol))
}
