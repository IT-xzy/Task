// 顶部左侧和右侧页面跳转
var left = document.querySelector('.left'),
  leftLink = left.querySelector('a'),
  right = document.querySelector('.right'),
  rightLink = right.querySelector('a');

leftLink.addEventListener('click', function () {
  changePage('player-init.html')
});
rightLink.addEventListener('click', function () {
  changePage('index.html')
});
// 跳转页面
function changePage(href) {
  window.location.href = href;
}

/* 接受url 参数 */
var qSLen,
  liveKiller,
  livePerson,
  daynum = 1,
  stateCheck = 1,
  player = [],
  playerState = [],
  playDay = [],
  queryString = document.location.search.split('&');

queryString.shift();
qSLen = queryString.length;
// 字符转换数字 parseInt()
// 对于身份设置0 1 区分0 杀手 1 水民
var tmp = Math.floor(qSLen / 4),
  killer = qSLen / 4 - tmp < .5 ? tmp : tmp + 1,
  person = qSLen - killer;

liveKiller = killer;
livePerson = person;
// 杀手
for (var i = 0; i < killer; i++) {
  var index = parseInt(queryString[i]) - 1;
  player[index] = 0;
}
// 水民
for (var i = killer; i < qSLen; i++) {
  var index = parseInt(queryString[i]) - 1;
  player[index] = 1;
}
playerState = player.slice(0);

console.log(queryString);
console.log(player);
sessionStorage.setItem('liveKiller',liveKiller);
sessionStorage.setItem('livePerson',livePerson);
sessionStorage.setItem('daynum',daynum);
sessionStorage.setItem('state',stateCheck);
sessionStorage.setItem('player', player);
sessionStorage.setItem('playerState', JSON.stringify(playerState));
sessionStorage.setItem('playDay',JSON.stringify(playDay));
/* 点击事件改变DOM */
var box = document.querySelector('.box'),
  span = document.querySelector('.box > span'),
  p = document.querySelector('.box > p'),
  btn = document.querySelector('footer > a'),
  clickNum = 1,
  i = 0;

function createUrl(href, arr) {
  var url = href;
  for (var i = 0; i < arr.length; i++) {
    url += '&' + arr[i];
  }
  return url;
}

btn.onclick = function () {
  if (clickNum == 2 * i + 1 && i < player.length) {
    box.setAttribute('style',
      "background: #ffedc5 url(./img/IDinfo.png) no-repeat center 20%;background-size: 50%");
    // 根据数值判断显示
    if (player[i] === 0) {
      p.textContent = '杀手';
    } else {
      p.textContent = '水民';
    }
    // 最后点击按钮
    if (i == player.length - 1) {
      btn.textContent = '法官查看';
    } else {
      btn.textContent = '隐藏并传递给' + (i + 2) + '号';
    }

    clickNum++;
    i++;
    console.log('clickNum:' + clickNum);
    console.log('i:' + i);
    console.log(p.textContent);
  } else if (clickNum == 2 * i && i < player.length) {
    span.textContent = (i + 1);
    box.removeAttribute('style');
    p.textContent = '';
    btn.textContent = '查看' + (i + 1) + '号身份';
    clickNum++;

    console.log('clickNum:' + clickNum);
    console.log('i:' + i);
  } else {
    window.location.href = createUrl('judge.html?player=', player);
  }

}