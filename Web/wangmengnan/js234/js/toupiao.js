allPeople = JSON.parse(localStorage.getItem('allPeople'));
arr = JSON.parse(localStorage.getItem('arr'));
arrEz = JSON.parse(localStorage.getItem('arrEz'));
var arrT = [];
arrT.push(-1); //确定 n 号
localStorage.setItem('arrT', JSON.stringify(arrT)); //传递 n 号


//播放控件
function play() {
    var audio = document.getElementById('music');
    if (audio.paused) {
        audio.play(); //audio.play();// 音乐播放
    } else {
        audio.pause(); // 暂停
    }
};

var oC = 1;

function tianji() {
    var oDiv1 = document.getElementById("TT"); //获取
    var oDiv2 = document.createElement("div"); //创建 div标签             
    oDiv2.className = "player"; //赋值class
    var oDiv3 = document.createElement("div"); //创建 div标签
    oDiv3.className = "play"; //赋值class
    var oP1 = document.createElement("p"); //创建 p标签
    oP1.innerText = allPeople[arr[oC - 1]]; //输入玩家角色
    oP1.className = "text";
    var oP2 = document.createElement("p"); //创建 p标签
    oP2.innerText = " " + oC + "号";
    oP2.className = "number"
    var oImg = document.createElement("div"); //输入玩家编号
    oDiv1.appendChild(oDiv2);
    oDiv2.appendChild(oDiv3);
    oDiv2.appendChild(oImg);
    oDiv3.appendChild(oP1); //各种div p嵌套
    oDiv3.appendChild(oP2);

}
var oC = 1;
while (oC < arr.length + 1) {
    tianji(); //循环生成多个
    oC++;
}

arrZt = JSON.parse(localStorage.getItem('arrZt')); //获取死亡人员状态

for (var m = 0; m < arrZt.length; m++) {
    if (arrZt[m] === "dead") { //对数组遍历 寻找死亡人员
        $(".text")[m].style.backgroundColor = "rgb(255, 0, 0)"; //对死亡人员进行渲染颜色
    }
}
$(".play").on("click", function () { //当点击方块执行以下方法（函数）
    $(".play").css("border", "2px solid #fff");
    var T = parseInt($(this).find(".number").html())
    var arrT = [];
    arrT.push(T); //确定 n 号
    localStorage.setItem('arrT', JSON.stringify(arrT)); //传递 n 号
    console.log($(this).find(".text").css('background-color')); //判断条件 是否选择内容有杀手（不可杀自己） 和 选择内容有红色（已死之人不能选）
    if ($(this).find(".text").html() == "杀手" || $(this).find(".text").css('background-color') == "rgb(255, 0, 0)") {
        alert("大哥，您杀错了吧，请重新选择");
    } else {
        $(this).css("border", "2px solid #f00");
    }

});

function kill() {
    arrT = JSON.parse(localStorage.getItem('arrT')); //接收 n 号

    if ($(".main >div:nth-child(" + arrT[0] + ") .text").html() == "杀手" //判断条件1 选中内容为杀手
        ||
        $(".main >div:nth-child(" + arrT[0] + ") .text").css('background-color') == "rgb(255, 0, 0)" //判断条件2 选中内颜色为红色
        ||
        arrT[0] == -1) { //判断条件3 未选
            alert("已选择未杀人");
        arrKill1 = JSON.parse(localStorage.getItem('arrKill1'));
        arrKill1.push("夜晚：杀手选择放弃，无人死亡");
        localStorage.setItem('arrKill1', JSON.stringify(arrKill1));
        window.location.assign('./judgetaiben.html');
    } else {
        arrZt[arrT[0] - 1] = "dead"; //转换被点击的生死状态
        var arrAll = [];
        arrX = JSON.parse(localStorage.getItem('arrX'));
        arrX.push(arrT[0]); //确定 n 号
        localStorage.setItem('arrX', JSON.stringify(arrX)); //传递 n 号
        for (var b = 0; b < arrZt.length; b++) {
            arrAll.push(arrEz[b] + arrZt[b]); //创建一个多维数组
        }
        arrKill1 = JSON.parse(localStorage.getItem('arrKill1'));
        arrKill1.push("夜晚："+arrT[0]+"号被杀手杀害，真实身份是平民");
        localStorage.setItem('arrKill1', JSON.stringify(arrKill1));
        localStorage.setItem('arrAll', JSON.stringify(arrAll));
        localStorage.setItem('arrZt', JSON.stringify(arrZt));
        console.log(1);
        if (isInArray(arrAll, "平民alive")) {
            window.location.assign('./judgetaiben.html');
        } else {
            window.location.assign('./jieguo.html');
            arrV = JSON.parse(localStorage.getItem('arrV'));
            arrV[0] = "杀手胜利";
            localStorage.setItem('arrV', JSON.stringify(arrV));
        }
    }
}

function isInArray(arr, value) {
    for (var i = 0; i < arr.length; i++) {
        if (value === arr[i]) {
            return true; //判断元素是否存在
        }
    }
    return false;
}