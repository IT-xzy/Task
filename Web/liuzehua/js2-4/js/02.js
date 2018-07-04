window.onload = function () { //页面加载完成后初始化
    localStorage.clear(); //清除本地缓存
    add_input(6); //初始化并传递默认人数8人
}

var kill_num = document.getElementsByClassName("txt")[0]; //狼人人数DOM节点
var farmer_num = document.getElementsByClassName("txt")[1]; //狼村民人数DOM节点

function add_input(value) {
    var kill = "x"; // 杀手人数
    var farmer = "x"; //平民人数
    if (value >= 4 && value <= 18) {
        kill = Math.floor((value / 3)); //得到狼人人数
        farmer = value - kill; //得到村民人数
        change(kill, farmer); //输出html文本
    } else {
        kill_num.innerHTML = "狼人 0 人";
        farmer_num.innerHTML = "村民 0 人";
    }
}

function change(kill, farmer) {
    kill_num.innerHTML = "狼人 " + kill + " 人";
    farmer_num.innerHTML = "村民 " + farmer + " 人";

    var arr = []; //放入身份的数组
    for (var i = 0; i < kill; i++) {
        arr.push("狼人");
    }
    for (var k = 0; k < farmer; k++) {
        arr.push("村民");
    }
    arr = shuffle(arr);
    document.getElementsByClassName("middle")[0].innerHTML = arr;
    console.log(arr);
    local_arr = JSON.stringify(arr);
}


function go() {
    var players = document.getElementById("input").value;
    if (players >= 4 && players <= 18) {

        localStorage.setItem("players", local_arr); //存储一个值;
        window.location.href = "03.html";
    } else {
        alert("请输入正确的玩家数量");
    }
}

function shuffle(arr) { //传入一个数组
    let length = arr.length; //获得数组长度
    let random; //随机数
    for (let i = 0; i < length; i++) {
        random = parseInt(Math.random() * (i + 1))
        if (random != i) { //如果随机数和顺序位不相等
            let temp = arr[i]; //临时保存原数组的1位
            //随机位的元素和顺序位交换
            arr[i] = arr[random];
            arr[random] = temp;
        }
    }
    return arr;
}