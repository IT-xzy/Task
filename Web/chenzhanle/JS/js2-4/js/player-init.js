/* 20180612 */
/* 玩家身份初始化，确定玩家数量，分配玩家 */

/*分配玩家  */
// 输入框和玩家数量同步
var killer, person;
var inputNum = document.getElementById('number'),
  player = document.querySelectorAll('.player-list > span'),
  playerNum = inputNum.value;

// 判断输入框数值符合要求
inputNum.onchange = function () {
  var reg = /^\d{1,2}$/;
  playerNum = inputNum.value;
  range.value = inputNum.value;
  if (reg.test(playerNum) && playerNum >= 4 && playerNum <= 18) {
    playerUpdate();
  } else {
    alert('请输入数字4-18之间');
    inputNum.value = '';
  }
}

// 输入框与滑动块同步
var range = document.getElementById('range'),
  minus = document.getElementById('minus'),
  plus = document.getElementById('plus');

range.onchange = function () {
  inputNum.value = range.value;
  playerNum = inputNum.value;
  playerUpdate();
}
minus.onclick = function () {
  range.value--;
  inputNum.value = range.value;
  playerNum = inputNum.value;
  playerUpdate();
}
plus.onclick = function () {
  range.value++;
  inputNum.value = range.value;
  playerNum = inputNum.value;
  playerUpdate();
}

// 分配玩家身份
var playerId = [],
  killerId = [],
  personId = [];

function createArray(n) {
  var arr = [];
  for (var i = 0; i < n; i++) {
    arr.push(i + 1);
  }
  return arr;
}

// https://stackoverflow.com/questions/2450954/how-to-randomize-shuffle-a-javascript-array?utm_source=caibaojian.com
// the Fisher-Yates (aka Knuth) Shuffle
function shuffle(array) {
  var currentIndex = array.length,
    temporaryValue, randomIndex;

  // While there remain elements to shuffle...
  while (0 !== currentIndex) {

    // Pick a remaining element...
    randomIndex = Math.floor(Math.random() * currentIndex);
    currentIndex -= 1;

    // And swap it with the current element.
    temporaryValue = array[currentIndex];
    array[currentIndex] = array[randomIndex];
    array[randomIndex] = temporaryValue;
  }

  return array;
}

function createPlayer() {
  playerNum = inputNum.value;
  playerId = createArray(playerNum);
  playerId = shuffle(playerId);
  killerId = playerId.slice(0, killer);
  personId = playerId.slice(-person);
  console.log('玩家：' + playerId.length + ' ; ' + playerId);
  console.log('杀手：' + killerId.length + ' ; ' + killerId);
  console.log('水民：' + personId.length + ' ; ' + personId);
  console.log('\n');
}

function playerUpdate() {
  var tmp = Math.floor(playerNum/4);
  killer = playerNum/4 - tmp <.5 ? tmp : tmp+1;
  person = playerNum - killer;
  player[0].textContent = '杀 手 ' + killer + ' 人';
  player[1].textContent = '水 民 ' + person + ' 人';
  createPlayer();
  urlNext = createUrl('player-show.html?playerId=', playerId);
  console.log(urlNext);
}
// 初始化
inputNum.value = 8;
playerNum = 8;
playerUpdate();
// 顶部和底部页面跳转
var left = document.querySelector('.left'),
  leftLink = left.querySelector('a'),
  footer = document.querySelector('footer'),
  footerLink = footer.querySelector('a'),
  urlNext;


// 跳转页面
function changePage(href) {
  window.location.href = href;
}

function createUrl(href, arr) {
  var url = href;
  for (var i = 0; i < arr.length; i++) {
    url += '&' + arr[i];
  }
  return url;
}

leftLink.addEventListener('click', function () {
  changePage('index.html')
});
footerLink.addEventListener('click', function () {
  changePage(urlNext)
});