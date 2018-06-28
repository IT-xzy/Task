var startButton = document.getElementsByClassName("grid");

var block = [];
for (var i = 0; i < startButton.length; i++) {
  block.push(i);
  //   console.log(block);
}
function change() {
  var num = 3;
  var number = [];
  var result = [];
  for (var i = 0; i < 9; i++) {
    startButton[i].style.background = "orange";
  }
  for (var i = 0; i < num; i++) {
    var flash = Math.floor(Math.random() * (block.length - i));
    console.log(flash);
    number.push(block[flash]);//将block里的索引为
    console.log(block);
    var need = number[i];
    result.push(startButton[need]);
    // block[flash] = block[block.length - i - 1];
    block.splice(flash, 1);
    console.log(block);
    console.log(result);
  }
  console.log(startButton);
  var c1 =
    "rgb(" +
    Math.floor(Math.random() * 256) +
    "," +
    Math.floor(Math.random() * 256) +
    "," +
    Math.floor(Math.random() * 256) +
    ")";
  var c2 =
    "rgb(" +
    Math.floor(Math.random() * 256) +
    "," +
    Math.floor(Math.random() * 256) +
    "," +
    Math.floor(Math.random() * 256) +
    ")";
  var c3 =
    "rgb(" +
    Math.floor(Math.random() * 256) +
    "," +
    Math.floor(Math.random() * 256) +
    "," +
    Math.floor(Math.random() * 256) +
    ")";
  result[0].style.background = c1;
  result[1].style.background = c2;
  result[2].style.background = c3;
  block.push.apply(block, number);
}
var time;
function clickStart() {
  //   console.log(block);

  clearInterval(time);
  time = setInterval("change()", 1000);
}
function clickOver() {
  clearTimeout(time);
  for (var i = 0; i < 9; i++) {
    startButton[i].style.background = "orange";
  }
}
