// 顶部左侧和右侧页面跳转
var left = document.querySelector('.left'),
  leftLink = left.querySelector('a'),
  right = document.querySelector('.right'),
  rightLink = right.querySelector('a'),
  footLink = document.querySelector('footer > a');

leftLink.addEventListener('click', function () {
  window.location.href = 'player-init.html';
});
rightLink.addEventListener('click', function () {
  window.location.href = 'index.html';
});
// 底部跳转
footLink.addEventListener('click', function () {
  window.location.href = 'everyday.html';
})

var playertotal,
  page = +document.location.search.substring(1),
  player = sessionStorage.getItem('player'),
  playerState = JSON.parse(sessionStorage.getItem('playerState')),
  playNode = document.getElementById('play'),
  playerNode = playNode.getElementsByClassName('player');

player = player.split(',');
playertotal = playerState.length;
// 设置session storage
// 生成玩家
for (var i = 0; i < playertotal - 1; i++) {
  dupNode = playerNode[0].cloneNode(true);
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

if (page == 2) {
  footLink.textContent = '返回';
}
// 玩家死亡状态根据存储数据确定，并且表现在页面
for (var i = 0; i < playertotal; i++) {
  var playerNameNode = playerNode[i].querySelector('.player-name');

  if (Array.isArray(playerState[i])) {
    playerNameNode.setAttribute('style', 'background-color: #83b09a');
  }
}