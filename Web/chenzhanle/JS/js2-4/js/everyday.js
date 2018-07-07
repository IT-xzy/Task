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
// 获取session storage
var daynum = +sessionStorage.getItem('daynum'),
  stateCheck = +sessionStorage.getItem('state'),
  player = sessionStorage.getItem('player'),
  playerState = JSON.parse(sessionStorage.getItem('playerState')),
  playDay = JSON.parse(sessionStorage.getItem('playDay'));
// 页面DOM
var content = document.getElementsByClassName('content'),
  contentHead = document.getElementsByClassName('content-hd');
// 根据天数、玩家状态、游戏进度生成页面
// 根据天数生成页面结构
for (var i = 0; i < daynum - 1; i++) {
  var dupNode = content[0].cloneNode(true);
  content[0].parentNode.appendChild(dupNode);
}
// 改变天数 点击事件
for (var i = 0; i < daynum; i++) {
  var gameday = content[i].querySelector('.gameday');
  // 游戏状态
  gameday.textContent = num2han(i + 1);
  // 天数行添加点击函数显示隐藏  
  contentHead[i].onclick = function () {
    var nextNode = this.nextElementSibling;
    switch (true) {
      case nextNode.style.display == "" || nextNode.style.display == 'block':
        nextNode.style.display = 'none';
        break;
      case nextNode.style.display == 'none':
        nextNode.style.display = 'block';
    }
  }
}
// 设置隐藏和点击效果
for (var i = 0; i < daynum - 1; i++) {
  var order = content[i].querySelectorAll('.play-order');

  contentHead[i].nextElementSibling.setAttribute('style', 'display: none');
  for (var j = 0; j < 4; j++) {
    order[j].setAttribute('class', 'play-order-click');
  }
}
// 显示死亡信息
var deathTotal = playDay !== null ? playDay.length : 0;
for (var i = 0; i < deathTotal; i++) {
  var j = Math.floor(i / 2);
  if (i == 2 * j) {
    var killContent = content[j].querySelector('.killContent');
    killContent.textContent = (playDay[i][0] + 1) + '号被杀手杀死，真实身份是水民';
  } else {
    var voteContent = content[j].querySelector('.voteContent');
    voteContent.textContent = (playDay[i][0] + 1) + '号被投票投死，真实身份是' + (playDay[i][1] == 0 ? '杀手' : '水民');
  }
}

var orderdiv = content[daynum - 1].querySelectorAll('.play-order'),
  orderFirst = orderdiv[0],
  orderSecond = orderdiv[1],
  orderThird = orderdiv[2],
  orderFourth = orderdiv[3];
/* 有限状态机 */
var orderList = new StateMachine({
  init: 'ready',
  transitions: [{
      name: 'order1',
      from: 'ready',
      to: 'kill'
    },
    {
      name: 'order2',
      from: 'kill',
      to: 'speak'
    },
    {
      name: 'order3',
      from: 'speak',
      to: 'talk'
    },
    {
      name: 'order4',
      from: 'talk',
      to: 'vote'
    }
  ],
  methods: {
    // 5个全局事件
    //- fired before any transition
    onBeforeTransition: function (lifecycle) {
      console.log('onBeforeTransition:' + lifecycle.transition);
    },
    //- fired when leaving any state
    onLeaveState: function (lifecycle) {
      console.log('onLeaveState:' + lifecycle.from);
    },
    //- fired during any transition
    onTransition: function (lifecycle) {
      console.log('onTransition:' + lifecycle.transition);
    },
    //- fired when entering any state
    onEnterState: function (lifecycle) {
      console.log('onEnterState:' + lifecycle.to);
    },
    //- fired after any transition
    onAfterTransition: function (lifecycle) {
      console.log('onAfterTransition:' + lifecycle.transition);
    },
    // 4个指定事件-每个过渡transition

    onEnterKill: function (lifecycle) {
      orderFirst.setAttribute('class', 'play-order-click');
    },

    onEnterSpeak: function (lifecycle) {
      orderSecond.setAttribute('class', 'play-order-click');
    },

    onEnterTalk: function (lifecycle) {
      orderThird.setAttribute('class', 'play-order-click');
    },

    onEnterVote: function (lifecycle) {
      orderFourth.setAttribute('class', 'play-order-click');
    },

  }
});
// 检测状态
switch (stateCheck) {
  case 1:
    break;
  case 2:
    orderList.order1();
    break;
  case 3:
    orderList.order1();
    orderList.order2();
    break;
  case 4:
    orderList.order1();
    orderList.order2();
    orderList.order3();
}
// 选项
orderFirst.onclick = function () {
  if (stateCheck == 1) {
    orderList.order1();
    stateCheck += 1;
    sessionStorage.setItem('state', 2);
    window.location.href = 'play.html?0';
  } else {
    alert('请按顺序操作');
  }
};
orderSecond.onclick = function () {
  if (stateCheck == 2) {
    if (window.confirm('请死者亮明身份，发表遗言')) {
      orderList.order2();
      stateCheck += 1;
      sessionStorage.setItem('state', 3);
    }
  } else {
    alert('请按顺序操作');
  }
};
orderThird.onclick = function () {
  if (stateCheck == 3) {
    if (window.confirm('玩家依次发言')) {
      orderList.order3();
      stateCheck += 1;
      sessionStorage.setItem('state', 4);
    }
  } else {
    alert('请按顺序操作');
  }
};
orderFourth.onclick = function () {
  if (stateCheck == 4) {
    orderList.order4();
    stateCheck = 1;
    sessionStorage.setItem('state', 1);
    window.location.href = 'play.html?1';
  } else {
    alert('请按顺序操作');
  }
};

/* 页面跳转 */
// 顶部左侧和右侧页面跳转
var left = document.querySelector('.left'),
  leftLink = left.querySelector('a'),
  right = document.querySelector('.right'),
  rightLink = right.querySelector('a'),
  foot = document.querySelectorAll('footer a');

leftLink.addEventListener('click', function () {
  window.location.href = 'judge.html';
});
rightLink.addEventListener('click', function () {
  window.location.href = 'index.html';
});
foot[0].addEventListener('click', function () {
  if (window.confirm('确认结束游戏？')) {
    window.location.href = 'result.html';
  }
})
foot[1].addEventListener('click', function () {
  window.location.href = 'judge.html?2';
})