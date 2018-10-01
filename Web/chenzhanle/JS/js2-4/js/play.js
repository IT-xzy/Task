// 本地存储
var playertotal,
  liveKiller = +sessionStorage.getItem('liveKiller'),
  livePerson = +sessionStorage.getItem('livePerson'),
  daynum = +sessionStorage.getItem('daynum'),
  player = sessionStorage.getItem('player'),
  playerState = JSON.parse(sessionStorage.getItem('playerState')),
  playDay = JSON.parse(sessionStorage.getItem('playDay'));
// 初始化玩家数量
player = player.split(',');
playertotal = player.length;

// 生成玩家
var playNode = document.getElementById('play'),
  playerNode = playNode.getElementsByClassName('player');

for (var i = 0; i < playertotal - 1; i++) {
  var dupNode = playerNode[0].cloneNode(true);
  playNode.appendChild(dupNode);
}
// 改变玩家相应身份
for (var i = 0; i < playertotal; i++) {
  var playerName = playerNode[i].querySelector('.player-name > span'),
    playerNum = playerNode[i].querySelector('.player-num > span');

  if (player[i] == 0) {
    playerName.textContent = '杀手';
  } else {
    playerName.textContent = '水民';
  }
  playerNum.textContent = (i + 1) + '号';
}
// 根据url 确定页面显示：0 杀人 1 投票
var page =  +document.location.search.substring(1),
  headText = document.querySelector('.middle'),
  bigText = document.querySelector('.info > span'),
  littleText = document.querySelector('.top > span');

// 0 杀人页面；1 投票页面默认情况不用改变
if (page == 0) {
  headText.textContent = '杀手杀人';
  bigText.textContent = '杀手请睁眼，杀手请选择要杀的对象';
  littleText.textContent = '点击下方玩家头像，对被杀的玩家进行标记';
}
// 玩家死亡状态根据存储数据确定，并且表现在页面
for (var i = 0; i < playertotal; i++) {
  var playerNameNode = playerNode[i].querySelector('.player-name');

  if (Array.isArray(playerState[i])) {
    playerNameNode.setAttribute('style', 'background-color: #83b09a');
  }
}

// 杀人投票，所有均可点击，确认时判断
var dropNode = playNode.querySelectorAll('.player > .play-drop');

for (var i = 0; i < playertotal; i++) {
  playerNode[i].onclick = function () {
    var drop = this.querySelector('.play-drop');

    for (var j = 0; j < playertotal; j++) {
      dropNode[j].setAttribute('style', 'opacity = 0');
    }
    drop.style.opacity = '1';
  }
}
// 需要判断杀手和死亡玩家，符合规则直接跳转否则给出提示
var footLink = document.querySelector('footer > a');

footLink.onclick = function () {
  var death = getDeath();
  switch (true) {
    case death == -1:
      alert('未选定玩家');
      break;
    case page == 0 && player[death] == 0:
      // 杀人页面不能选定杀手
      alert('你是杀手不能杀死本职业，请选择其他玩家');
      break;
    case Array.isArray(playerState[death]):
      alert('当前玩家已死亡，请选择其他玩家');
      break;
    default:
      setDeath(death);
      // 跳转到法官台本 或者结束游戏
      if (liveKiller >= livePerson || liveKiller === 0) {
        window.location.href = 'result.html';
      } else {
        daynum += page == 1 ? 1 : 0;
        sessionStorage.setItem('daynum',daynum);
        window.location.href = 'everyday.html';
      }
  }
}

// 获取选定的玩家 点击之后添加行内属性style
function getDeath() {
  var playerChoosed = [];
  for (var i = 0; i < playertotal; i++) {
    playerChoosed[i] = dropNode[i].style.opacity;
  }
  // 要检索的字符串值没有出现，则该方法返回 -1；即未选定玩家
  return playerChoosed.indexOf('1');
}
// 设置死亡状态，扩充玩家数组为二位数组，
// 第一个为玩家身份不变，第二个为页面数字表示死于哪一步
function setDeath(n) {
  playerState[n] = [n,player[n], page];
  playDay.push(playerState[n]);
  if(player[n] == 0) {
    liveKiller -= 1;
  }else {
    livePerson -= 1;
  }
  sessionStorage.setItem('liveKiller', liveKiller);
  sessionStorage.setItem('livePerson', livePerson);
  sessionStorage.setItem('playerState', JSON.stringify(playerState));
  sessionStorage.setItem('playDay',JSON.stringify(playDay));
}