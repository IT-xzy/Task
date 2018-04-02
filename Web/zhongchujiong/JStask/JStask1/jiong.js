var oBox = document.getElementsByClassName('square'),    //获取节点
  oBoxTimer,     //存放定时器
  boxStop = false,
  boxState = false;     //判断是否是运行状态
//随机颜色
function getRandomColor() {
  return 'rgb(' + Math.round(Math.random() * 255) + ',' + Math.round(Math.random() * 255) + ',' + Math.round(Math.random() * 255) + ')';
}

//随机格子跑起来
function randomBox() {
  var tempBox = [];
  for (var i = 0; i <= 8; i++) {    //把格子重置颜色
    oBox[i].style.background = 'orange';
    tempBox.push(i);
  }
  for (var r = 0; r < 3; r++) {   //随机算法取得三个格子并上色
    var randomNub = Math.floor(Math.random() * tempBox.length - 1);
    var supscript = tempBox.splice(randomNub, 1);
    oBox[supscript].style.background = getRandomColor();
  }
}
//开始闪烁
function startBox() {
  if (boxState == boxStop) {
    oBoxTimer = setInterval(function () {
      randomBox();
    }, 1000);
    boxState = true;
  }
}

//停止
function stopBox() {
  for (var i = 0; i <= 8; i++) {
    oBox[i].style.background = 'orange';
  }
  clearInterval(oBoxTimer);        //关闭定时器
  boxState = false;
}


