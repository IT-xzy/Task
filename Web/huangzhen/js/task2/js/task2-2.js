// 底部滑动条

var playerNum = document.getElementById("player");
console.log(playerNum);
var rangeNum = document.getElementById("myRange");
console.log(rangeNum);

// 绑定更替滑动条的值和input的值
rangeNum.onchange = function () {
  playerNum.value = rangeNum.value;
}
//  需要添加实时改变，让input的值显示到滑动条上
playerNum.onchange = function () {
  if (playerNum.value > 3 && playerNum.value < 19) {
    rangeNum.value = playerNum.value;
  } else {
    alert("请输入正确的值位于4-18之间") 
  }
} 

// 绑定加事件
var add = document.getElementById("add");
add.onclick = function () {
  if (playerNum.value < 18) {
    playerNum.value++;
    rangeNum.value = playerNum.value;
  } else {
    alert("人够多了，等下一局吧！");
  }
}

// 绑定减事件
var less = document.getElementById("less");
less.onclick = function () {
  if (playerNum.value > 4) {
    playerNum.value--;
    rangeNum.value = playerNum.value;
  } else {
    alert("人不够，快来人啦！");
  }
}
// 限制必须先设置好人数才能进入页面三
document.getElementsByClassName("goto")[0].addEventListener("click", function()
{
    if(playerNum.value!=document.getElementsByTagName("li").length){
      alert("玩家人数还没设置好");
    }
    else{
      window.location.href = './task3-1.html';
    }
});

// 设置本地存储
// localStorage.setItem("lastname", "Gates");

var killer = '<li class="pfs-killer">杀手1人</li>';
var civilian = '<li class="pfs-civilian">平民1人</li>';

// setting的事件
setting.onclick = function () {

  // // 洗牌算法
  // // 先隐藏ul标签中的内容
  // info.innerHTML = "";
  // // 确定 杀手和平民的个数
  // var player = [];
  // var killers = [];
  // var civilians = [];
  // killers.length = parseInt(playerNum.value / 3);
  // civilians.length = playerNum.value - killers.length;

  // console.log(killers.length);
  // console.log(civilians.length);

  // //将killers的每一项都设置为杀手元素
  // for (var i = 0; i < killers.length; i++) {
  //   killers[i] = killer;
  // }
  // //将civilians的每一项都设置为平民元素
  // for (var j = 0; j < civilians.length; j++) {
  //   civilians[j] = civilian;
  // }
  // // console.log(civilians);
  // // console.log(killers);

  // // 合并到总人数
  // player = killers.concat(civilians);
  // // console.log(player);
  // var x = player.length;
  // // console.log(player.length);
  // var out = [];
  // for (a = 0; a < x; a++) {
  //   var index = Math.floor(Math.random() * player.length);
  //   // console.log(player.length);
  //   // console.log(index);
  //   out[a] = player[index];
  //   player.splice(index, 1);
  // }
  // console.log(out);

  // // 传入数据
  // for (b = 0; b < out.length; b++) {
  //   info.innerHTML += out[b];
  // }


  // 自己的想法
  // 所有的人数数组

  var player = [];
  var str = "";
  player.length = playerNum.value;
  var killer = Math.floor(playerNum.value / 3);

  // 杀手人数随机定位
  var out = [];
  while (out.length < killer) {
    var randomindex = Math.floor(Math.random() * playerNum.value);
    if (out.indexOf(randomindex) < 0) {
      out.push(randomindex);
    }
    // console.log(out);
  }
  // 给杀手传参
  for (i = 0; i < out.length; i++) {
    // 注意这里的out[i]就是定义位置了
    player[out[i]] = '<li class="killer">' + '杀手' + '</li>';
  }


  for (i = 0; i < player.length; i++) {
    if (player[i] !== '<li class="killer">' + '杀手' + '</li>') {
      player[i] = '<li class="civilian">' + '平民' + '</li>';
    }
  }
  // console.log(player);

  for (var i = 0; i < player.length; i++) {
    str += player[i];
  }
  // console.log(str);

  document.getElementById("info").innerHTML = str;

  var obj = JSON.stringify(player);
  // console.log(obj);
  // 存入
  sessionStorage.player = obj;
  // 用sessionStorage实现页面之间的数据传输
}