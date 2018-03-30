/**
 * Created by guojianfeng on 2017/10/15.
 **/
var killerNum, personNum;
var inputText = document.getElementById("text");
var inputRange = document.getElementById("range");
var getSplice = document.getElementById("splice");
var role = document.getElementById('setRoles');
var toHome = document.getElementById("back");
var next = document.getElementById("next");
var player = [];
// 输入人数
function toChange() {
    if (inputText.value >= 6 && inputText.value <= 18) {
        inputRange.value = inputText.value;
    } else {
        alert("请输入正确的人数6~18人");
        inputText.value = 6;
        inputRange.value = 6;
    }
}

// 连接滑动条与输入框
function moveChange() {
    inputText.value = inputRange.value;
}

// 减按钮
function less() {
    inputText.value--;
    if (inputText.value < 6) {
        alert("人太少了，再找几个小伙伴来吧");
        inputText.value = 6;
    } else {
        inputRange.value = inputText.value;
    }
}

// 加按钮
function plus() {
    inputText.value++;
    if (inputText.value > 18) {
        alert("人太多了，可以分一批人再开一局");
        inputText.value = 18;
    } else {
        inputRange.value = inputText.value;
    }
}

function getArray() {
    var playerNum = parseInt(inputRange.value);
    if (playerNum === 17) {
        killerNum = 5;
    } else {
        killerNum = Math.round(playerNum / 4);
    }//得到杀手的人数
    personNum = playerNum - killerNum;//得到水民的人数
// 生成对应数组
    var killerArr = "狼人";
    var personArr = "村民";
    var killer = [];
    for (var i = 0; i < killerNum; i++) {
        killer[i] = killerArr;
    }
    var person = [];
    for (var j = 0; j < personNum; j++) {
        person[j] = personArr;
    }
// 连接数组
    player = killer.concat(person);
}
// 洗牌
function aa() {
    var a = [];
    for (var e = player.length - 1; e >= 0; e--) {
        var randomIndex = ~~(Math.random() * (e + 1));
        var itemAtIndex = player[randomIndex];
        player[randomIndex] = player[e];
        player[e] = itemAtIndex;
    }
    return a;
}
// 清除旧节点
function removeChildren() {
    var childs = role.childNodes;
    for (var h = 0; h < childs.length; h++) {
        role.removeChild(childs.item(h));
    }
}

// 分配比例
getSplice.onclick = numChange;

function numChange() {
    removeChildren();//执行清除旧节点
    getArray();
    aa();
// 插入节点
    for (var g = 0; g < player.length; g++) {
        role.appendChild(document.createElement('span'));
    }
    var createNode = document.getElementsByTagName('span');
    for (var f = 0; f < player.length; f++) {
        createNode[f].innerText = player[f];
        if (createNode[f].innerText === "狼人") {
            createNode[f].className = "blue";
        } else {
            createNode[f].className = "orange";
        }
    }
    sessionStorage.setItem("killerNum",JSON.stringify(killerNum));
    sessionStorage.setItem("personNum",JSON.stringify(personNum));
    document.cookie = "player=" + JSON.stringify(player);
    console.log(document.cookie);
}
// 确认生成玩家人数
next.onclick = function() {
    if (player.length === parseInt(inputRange.value)) {
        window.location.href = "../html/show.html";
    }
    else{
        alert("请先点击设置身份");
    }
};
// 返回上一页
toHome.onclick = function () {
    window.history.back(-1);
};
