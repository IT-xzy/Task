

var log            = console     .log;
window.onload      = function () {
    //初始化变量
    var playerStr  = sessionStorage.getItem('playersMsg'), //提取玩家数组
        playersMsg  = JSON.parse(playerStr),
         //返回按钮
        playerNum  = document    .getElementById('playerNum'), //玩家编号
        playId     = document    .getElementById('playId'), //游戏身份
        showImg    = document    .getElementsByClassName('show-img')[0], //显示图片
        hideImg    = document    .getElementsByClassName('hide-img')[0], //隐藏图片
        checkBtn   = this        .document.getElementById('checkBtn'), //发牌按钮
        playersArr = playersMsg.random, //字符串转数组
        len        = playersArr  .length, //数组长度
        index      = 1,
        tNum       = 1;
    
    playerNum.innerText    = index; //玩家编号初始化
    playId.style.innerText = '';
    showImg.style.display  = 'none';
    checkBtn.innerHTML     = '查看<span>' + index + '</span>号身份';
    //es6模板字符串写法
    // checkBtn.innerHTML = `查看<span>${index}</span>号身份`; 
    checkBtn.addEventListener('click', function () {
        var newNum = Math.round(tNum / 2);//取整
        if (newNum === index) {
            playId.innerText = playersArr[index - 1];
            showImg.style.display = 'block';
            hideImg.style.display = 'none';
            index += 1;
            tNum += 1;
            if (newNum === len) {
                checkBtn.innerHTML = '法官查看';
            } else {
                checkBtn.innerHTML = '隐藏并传递给<span>' + index + '</span>号';
            }
        } else {
            if (newNum === len) {
                window.location.href = 'judeSee.html';
                return;
            }
            playerNum.innerText = index;
            hideImg.style.display = 'block';
            showImg.style.display = 'none';
            playId.style.innerText = '';
            tNum += 1;
            checkBtn.innerHTML = '查看<span>' + index + '</span>号身份';
        }
    }, false);
};