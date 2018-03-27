var numberOfplayers = document.getElementById("player");
var numberOfbar = document.getElementById("slider");


function nextOne() {
    window.location.href = "玩家选择游戏页面.html";
}

function matchingValue() {
    if (numberOfplayers.value <= 18 && numberOfplayers.value >= 4) {
        numberOfbar.value = numberOfplayers.value;
    } else {
        alert("玩家数在4 ~ 18之间");
        numberOfbar.value = 4;
        numberOfplayers.value = 4;
    }
}
//获取数据
function changeValue() {
    numberOfplayers.value = numberOfbar.value;
}
//数据匹配
function reduce() {
    numberOfbar.value--;
    numberOfplayers.value = numberOfbar.value;
    if (numberOfplayers.value < 4) {
        numberOfbar.value = 4;
    } else {
        numberOfplayers.value = numberOfbar.value;
    }
}
//减号逻辑
function increase() {
    numberOfbar.value++;
    numberOfplayers.value = numberOfbar.value;
    if (numberOfplayers.value > 18) {
        numberOfbar.value = 18;
    } else {
        numberOfplayers.value = numberOfbar.value;
    }
}
//加号逻辑
var farmer = [];
var killer = [];
function shuffle(array) {
    killer = Math.floor(numberOfplayers.value/3);
    farmer = numberOfplayers.value - killer;
    var arrayMons = array.concat();
    for(var f = 0; f < numberOfplayers.value; f++) {
        arrayMons[f] = '平民';
    }
    for(var k = 0; k < killer; k++) {
        arrayMons[k] = '杀手';
    }
    //洗牌算法
    for (var i = numberOfplayers.value; i--;) {
        var j =Math.floor(Math.random() * (i + 1));
        var temp = arrayMons[i];
        arrayMons[i] = arrayMons[j];
        arrayMons[j] = temp;
    }
    return arrayMons
}
var arrayMons = [];
var q;
function setPlayerNumber() {
    q = shuffle(arrayMons);
    var randomRole = '';
    for (x = 0; x < numberOfplayers.value; x++) {
        randomRole
            += '<div class="dynamic ">'
            + '<span class="dynamic-role">'
            + q[x]
            + '</span >'

            + '<span class="dynamic-num">'
            + (x+1)
            + '号</span>'
            + '</div>';
    }
    $(".list-style").eq(0).html(randomRole);
}
function playingCards() {
    if (killer.length !== 0 ) {
        sessionStorage.setItem('playerRoleTrans', JSON.stringify(q));    //储存玩家角色属性
        console.log(q);
        sessionStorage.setItem('playBar', numberOfplayers.value);     //储存玩家号码属性
        window.location.href = '玩家详情.html';
    } else {
        alert('请分配玩家身份!');
    }
}
console.log("运行正常");

