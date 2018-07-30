//声明玩家总数
var players;
//声明输入框内数据
var inputNumber;
//获取input输入框内数据
document.getElementById("players").value = 8;

function getValue() {
    inputNumber = +document.getElementById("players").value;
    //判断条件
    if (inputNumber >= 4 && inputNumber <= 18) {
        players = inputNumber;
    }
}
//button判断效果
function change() {
    start()
    if (inputNumber >= 4 && inputNumber <= 18) {
        location.href = "gamePrepare.html";
    } else {
        alert("请输入正确的玩家数量");
    }
}
//声明杀手变量和村民变量
var killer;
var villager;
//获取杀手数量和村民数量
function makeId() {
    getValue();
    if (inputNumber > 18 || inputNumber < 4) {
        killer = " ";
        villager = " ";
    }
    if (players == undefined) {
        return;
    }
    if (players == 15) {
        killer = 4;
        villager = players - killer;
    } else if (players == 18) {
        killer = 5;
        villager = players - killer;
    } else {
        killer = Math.floor(players / 3);
        villager = players - killer;
    }

}


//声明身份数组
var playersArray = [];
//生成数组
function makeArray() {
    for (var x = 0; x < villager; x++) {
        for (var y = 0; y < killer; y++) {
            playersArray[y] = 1;
        }
        playersArray[killer + x] = 0;
    }
}
//打乱数组
function randomArray() {
    for (var i = playersArray.length - 1; i >= 0; i--) {
        var number = Math.floor(Math.random() * (i + 1))
        var temp = playersArray[i];
        playersArray[i] = playersArray[number];
        playersArray[number] = temp;
    }
}
//调用生成
function start() {
    //每次调用初始化变量值
    players = undefined;
    playersArray = [];
    makeId();
    document.getElementById("killer").innerHTML = killer;
    document.getElementById("villager").innerHTML = villager;
    //如果没有获取有效值、终止后续语句。
    if (players == undefined) {
        return;
    }
    makeArray();
    randomArray();
    console.log(playersArray);
    //存储到浏览器缓存
    //将数组转换为json字符串。再进行存储
    var temp = JSON.stringify(playersArray);
    sessionStorage.setItem("playersArray", temp);
    sessionStorage.setItem("players", players);
    //存储杀手和平民数

    sessionStorage.setItem("killer", killer);
    sessionStorage.setItem("villager", villager);
}
//监听
document.addEventListener("input", function () {
    start();
})