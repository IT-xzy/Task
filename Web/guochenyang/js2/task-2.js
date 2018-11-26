//获取人数DOM
var playerNumber = document.getElementById("PlayerNumber");
var rangeNumber = document.getElementById("RangeNumber");
//关联rangeNumber和playerNumber两个input
function playernumber() {
    if (playerNumber.value >=4 && playerNumber.value <=18) {
        rangeNumber.value = playerNumber.value;
    }
    else {
        alert("玩家数应在4-18人");
    }
}
function rangenumber() {
    playerNumber.value = rangeNumber.value;
}
//关联加号和减号按钮
function btmadd() {
    rangeNumber.value++;
    if (playerNumber.value >= 18) {
         alert("玩家人数必须小于等于18");
     }
     else {
        playerNumber.value = rangeNumber.value;
     }
}
function btmmin() {
    rangeNumber.value--;
    if (playerNumber.value <= 4) {
        alert("玩家人数必须大于等于4");
    }
    else {
        playerNumber.value = rangeNumber.value;
    }
}
//设置玩家配比
function Playermix() {
    role();
    //玩家人数
    var people = playerNumber.value;
    // 清空所有子元素
    var ul = document.getElementById("player");
    while (ul.hasChildNodes()) {
        ul.removeChild(ul.firstChild);
    }
    if (people < 4 || people > 18) {
        alert("玩家人数不能小于4大于18");
    }
    else {
        //增加人数
        for (var i = 0; i < people; i++) {
            var element = document.getElementById("player");
            var People = document.createElement("li");
            var Square = document.createElement("span");
            var node = document.createTextNode(playerpeople[i] + "1人");
            element.appendChild(People);
            People.appendChild(Square);
            People.appendChild(node);
            People.className = 'people';
        }
        //console.log(i);
        //console.log(role());
    }
}
function role() {
    var killerNumber = Math.floor(playerNumber.value / 4);
    var civilianNumber = playerNumber.value - killerNumber;
        //创建数组
        playerpeople = [];
        for (var k = 0; k < killerNumber; k++) {
            playerpeople.push("杀手");
        }
        //将平民加入数组
        for (var c = 0; c < civilianNumber; c++) {
            playerpeople.push("平民");
        }
        //洗牌，打乱数组
        for (var l = playerpeople.length - 1; l >= 0; l--) {
            var rand = Math.floor(Math.random() * (l + 1));
            var p = playerpeople[rand];
            playerpeople[rand] = playerpeople[l];
            playerpeople[l] = p;
        }
        return playerpeople;
    //console.log(playerpeople);
 }
//返回主页面
function Back() {
    var b = confirm("是否退回到主页面");
        if (b == true) {
        sessionStorage.clear();
        window.location.href = "zhuoyou.html";
        }
}
var civword=document.getElementById("civTxt");
var killword=document.getElementById("killTxt");
function start() {
    Playermix();
    if (
        playerpeople.length != 0 && civword.value !="" && killword.value !=""
    ){
        sessionStorage.Num=playerNumber.value;
        sessionStorage.playerpeople=JSON.stringify(playerpeople);
        sessionStorage.civword=civword.value;
        sessionStorage.killword=killword.value;
        location.href="flop.html";
    }else if ( playerpeople.length==0  ) {
            alert("不设置玩家人数吗");
    }else if ( civword.value=="" ) {
            alert("请输入平民词汇");
    }else if ( killword.value=="") {
            alert("请输入杀手词汇");
    }
}