// 获取session storage
var liveKiller = +sessionStorage.getItem('liveKiller'),
  livePerson = +sessionStorage.getItem('livePerson'),
  daynum = +sessionStorage.getItem('daynum'),
  playerState = JSON.parse(sessionStorage.getItem('playerState')),
  playDay = JSON.parse(sessionStorage.getItem('playDay'));
// 初始化玩家数量
var deathPerson = 0,
  deathKiller = 0,
  deathTotal = playDay !== null ? playDay.length : 0;
for (var i = 0; i < deathTotal; i++) {
  deathPerson += playDay[i][1] == 1 ? 1 : 0;
  deathKiller += playDay[i][1] == 0 ? 1 : 0;
}
// 页面DOM
var gameResult = document.querySelector('.top > .vict > span'),
  deathNode = document.querySelectorAll('.top > p > span'),
  liveNode = document.querySelectorAll('.top > .total > .prof-num > span'),
  content = document.querySelector('.content'),
  contentPer = document.querySelector('.content >li');
// 数字转汉字天数
function num2han(section) {
  var chnNumChar = ["零", "一", "二", "三", "四", "五", "六", "七", "八", "九"],
    chnUnitChar = ["", "十", "百", "千"];

  var strIns = '',
    chnStr = '',
    unitPos = 0,
    zero = true;
  while (section > 0) {
    var v = section % 10;
    if (v === 0) {
      if (!zero) {
        zero = true;
        chnStr = chnNumChar[v] + chnStr;
      }
    } else {
      zero = false;
      strIns = chnNumChar[v];
      strIns += chnUnitChar[unitPos];
      chnStr = strIns + chnStr;
    }
    unitPos++;
    section = Math.floor(section / 10);
  }
  return chnStr;
}
// 游戏胜利
switch (true) {
  case liveKiller >= livePerson && playDay !== null:
    gameResult.textContent = '杀手胜利';
    break;
  case liveKiller === 0 && playDay !== null:
    gameResult.textContent = '水民胜利';
    break;
  default:
    gameResult.textContent = '游戏结束';
}
// 游戏总结
deathNode[0].textContent = deathPerson;
deathNode[1].textContent = deathKiller;
deathNode[2].textContent = daynum;
// 剩余玩家
liveNode[0].textContent = liveKiller;
liveNode[1].textContent = livePerson;
// 游戏过程
for (var i = 0; i < daynum - 1; i++) {
  var dupNode = contentPer.cloneNode(true);
  content.appendChild(dupNode);
}
var hanDay = document.querySelectorAll('.colmn > span'),
  contenTotal = document.querySelectorAll('.content >li'),
  dayContent = document.createElement('p');
for (var i = 0; i < daynum; i++) {
  hanDay[i].textContent = '第' + num2han(i + 1) + '天';
}
for (var i = 0; i < deathTotal; i++) {
  var j = Math.floor(i/2);
  var cloneDay = dayContent.cloneNode(true);
  if (i == 2 * j) {    
    cloneDay.textContent = '晚上：' + (playDay[i][0] + 1 )+ '号被杀手杀死，真实身份是水民';
    contenTotal[j].appendChild(cloneDay);
  } else{    
    cloneDay.textContent = '白天：' + (playDay[i][0] + 1 )+ '号被投票投死，真实身份是' + (playDay[i][1] == 0 ? '杀手' : '水民');
    contenTotal[j].appendChild(cloneDay);
  }
}