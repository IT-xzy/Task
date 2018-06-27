//玩家人数显示框
var txt2 = document.getElementsByTagName('input')[2];
//滚动条滚动数值
var txt3 = document.getElementsByTagName('input')[3];
//按钮一,递减;
var less = document.getElementsByTagName('button')[0];
//按钮二,递增;
var plus = document.getElementsByTagName('button')[1];
//文本:点击设置
var set = document.getElementById('click-set')
//给文本绑定点击事件
set.onclick = function set() {
  //杀手数量
  num1 = Math.floor(txt2.value / 3);
  //平民数量
  num2 = txt2.value - num1;
  //杀手数组
  var sha = Array(num1);
  var shaText = Array(num1);
  //平民数组
  var pin = Array(num2);
  var pinText = Array(num2);
  //历遍杀手数组
  for (i = 0; i < num1; i++) {
    sha[i] = "<li><img src='../images/13.png'> 杀手1人</li>";
    shaText[i]="杀手";
  }
  //历遍平民数组
  for (i = 0; i < num2; i++) {
    pin[i] = "<li><img src='../images/14.png'> 平民1人</li>";
    pinText[i]="平民";
  }
  //合并杀手和平民数组
  var allplayer = sha.concat(pin);
  var allplayerText = shaText.concat(pinText);
  //玩家数组乱序输出
  for (var i=0;i<txt2.value;i++){
    var all = i + Math.floor( Math.random()*(txt2.value - i));
    var temp = allplayer[i];
    var tempText = allplayerText[i];
    allplayer[i]=allplayer[all];
    allplayerText[i]=allplayerText[all];
    allplayer[all] = temp;
    allplayerText[all] = tempText;
  }
  
  //输出杀手和平民数组到HTML,并取消分隔符
  document.getElementsByTagName("ul")[0].innerHTML = allplayer.join("");
  //本地存储/存入变量
  sessionStorage.setItem("key1", txt2.value);
  var strtext=JSON.stringify(allplayerText);
  sessionStorage.setItem("key2", strtext);
  console.log(strtext);
  
}
//当输入框数字修改时,滑动块也跟着改变;
txt2.onchange = function changenumber() {
  if (txt2.value <= 16 && txt2.value >= 4) {
    txt3.value = txt2.value;
  }
  else {
    alert("请保证玩家人数在4~16之间");
  }
}
//当滑动条改变时,输入框数字也跟着改变;
txt3.oninput = function changethumb() {
  txt2.value = txt3.value;
}
//右边加号按钮,点击实现递增;
plus.onclick = function() {
  if (txt3.value < 16) {
    txt3.value++;
    txt2.value = txt3.value;
  }
  else {
    alert("玩家人数已经满啦!");
  }
  //滑动块所在的值距最左边的长度占滑动条总长度的百分比
  var suibian = (txt2.value - 4)/12*100 + '%';
  txt3.style.backgroundSize=suibian ;//给滑动条添加属性(驼峰法)
}
//左边减号按钮,点击实现递减;
less.onclick = function() {
  if (txt3.value > 4) {
    txt3.value--;
    txt2.value = txt3.value;
  }
  else {
    alert("玩家人数不能再少啦!");
  }
  //滑动块所在的值距最左边的长度占滑动条总长度的百分比
  var suibian = (txt2.value - 4)/12*100 + '%';
  txt3.style.backgroundSize=suibian ;//给滑动条添加属性(驼峰法)
}
//跳转至玩家配比页面
function peibi() {
  window.location.href = "../html/task234-peibi.html";
}
//跳转至上一个页面
function backto() {
  window.location.href = "../html/task234-01.html";
}
//在鼠标指针移动到元素上时触发。
txt3.onmousemove= function(){
  //滑动块所在的值距最左边的长度占滑动条总长度的百分比
  var suibian = (txt2.value - 4)/12*100 + '%';
  
  txt3.style.backgroundSize=suibian ;//给滑动条添加属性(驼峰法)
}
//元素上发生鼠标点击时触发。
txt3.onclick = function(){
  //滑动块所在的值距最左边的长度占滑动条总长度的百分比
  var suibian = (txt2.value - 4)/12*100 + '%';
  txt3.style.backgroundSize=suibian ;//给滑动条添加属性(驼峰法)
}
//设置 "去发牌"点击事件,页面跳转至查看身份页面;
document.getElementsByTagName("button")[2].onclick = function(){
  window.location.href = "../html/task234-watch.html";
}




