//generate 1~9 random number
function random() {
  return Math.floor(Math.random() * 9 + 1);
}

//map number to color string
function colorMap(num) {
  switch (num) {
    case 1:
      return "HotPink";
    case 2:
      return "red";
    case 3:
      return "LightCyan";
    case 4:
      return "LightGreen";
    case 5:
      return "purple";
    case 6:
      return "blue";
    case 7:
      return "MediumPurple";
    case 8:
      return "Tomato";
    case 9:
      return "YellowGreen";
    case 10:
      return "GreenYellow";
  }
}

//detect repeatable number in array
function isContain(num, array) {
  for (var i = 0; i < array.length; i++) {
    if (array[i] == num) {
      return true;
    }
  }
  return false;
}

//shuffle
function shuffle(a){
  var length = a.length;
  var shuffled = Array(length);

  for(var index = 0,rand;index < length;index++){
    rand = (Math.floor(Math.random() * (index+1)));
    if(rand !== index){
      shuffled[index] = shuffled[rand];
    }
    shuffled[rand] = a[index];
  }
  return shuffled;
}

//randomly select 3 div
function select() {
  var units = new Array();
  units = document.getElementsByClassName("unit");

}

function changecolor() {
  var colors = new Array();
  var unitsId = select();


  //all div equals yellow
  for (var i = 1; i < 10; i++) {
    document.getElementById("unit-" + i).style.backgroundColor = "rgb(255, 166, 0)";
  }


  //randomly select colors
  for (var i = 0; i < 3;) {
    var tmp = random()
    if (isContain(tmp, colors)) {
      continue;
    } else {
      colors.push(tmp);
      i++;
    }
  }
  //randomly select div
  for (i = 0; i < 3; i++) {
    document.getElementById("unit-" + unitsId[i]).style.backgroundColor = colorMap(colors[i]);
  }
}

var status = 0;

//set a timer
function Timer() {
  changecolor();
  t = setTimeout("Timer()", 1000);
}

//start event
function start(){
  if(status == 0){
    status = 1;
    Timer();
  }
  else{
    return;
  }
}

//stop event
function stop(){
  window.clearTimeout(t);
  status = 0;
  for(i = 1;i<10;i++){
    document.getElementById("unit-" + i).style.backgroundColor = "rgb(255, 166, 0)";
  }
}

var a= [1,2,3,4,5,6,7,8,9,10];
console.log(shuffle(a));