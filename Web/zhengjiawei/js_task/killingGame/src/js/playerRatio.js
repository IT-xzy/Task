var killer = document.getElementById("killerNum");
var killerNumber = "";
var police = document.getElementById("policeNum");
var policeNumber = "";
var sharpShoot = document.getElementById("sharpShooterNum");
var sharpShootNumber = "";
var doctor = document.getElementById("doctorNum");
var doctorNumber = "";
var roturier = document.getElementById("roturierNum");
var roturierNumber = "";
/* 获取span标签和为需要添加的人数定义一个变量来储存 */

var impotContent = 0; /* 定义变量保存input数值 */

var popupMenu = document.getElementById("popup");

window.onload = initialization(); /* 载入页面后的样式 */

function playChangeNum() {
    clearNumber(); /* 初始化人数 */
    getInput(); /* 获取输入值 */
    judgeNumber(); /* 判断输入值后分配人数 */
    initialization(); /* 为span添加人数 */
} /* input输入值后调用该函数 */

function deal() {
    identity = [];/* 初始化身份数组 */
    sessionStorage.clear();/* 清除本地储存 */
    playChangeNum();/* 每次点击发牌重新分配身份 */
    addIdentityArray(); /* 身份添加进数组 函数 */
    shuffle(identity); /* 身份数组乱序 函数*/
    textarray(); /* 转为json格式，存入sessionStorage */
    if (impotContent < 5 || impotContent > 20) {
        popupMenu.style.display = "flex";
    } /* 如果输入内容不正确，跳出提示框 */
    else {
        window.location.href = "lookIdentity.html"; /* 跳转至下一个页面 */
    }
} /* 点击发牌 */

function closePopup() {
    popupMenu.style.display = "none";
} /* 点击确定、点击取消后隐藏弹窗 */

/* ——————————————————功能函数区———————————————————— */

function clearNumber() {
    killerNumber = "";
    policeNumber = "";
    sharpShootNumber = "";
    doctorNumber = "";
    roturierNumber = "";
} /* 初始化人数 */

function getInput() {
    inputStyle = document.getElementById("inputText");
    inputStyle.maxLength = 2; /* 限制输入长度 */
    inputStyle.onkeyup = function () {
        this.value = this.value.replace(/\D/g, '');
    } /* 限制只能输入数字 */
    impotContent = document.getElementById("inputText").value;
    impotContent = ~~impotContent; /* 输入的数值会变成string类型，~~转换成number类型 */
    console.log("input内容类型为 " + typeof impotContent);
    return impotContent;
} /* 获取input内容 */

function initialization() {
    killer.innerHTML = "杀手 " + killerNumber + " 人";
    police.innerHTML = "警察 " + policeNumber + "人";
    sharpShoot.innerHTML = "狙击手 " + sharpShootNumber + " 人";
    doctor.innerHTML = "医生 " + doctorNumber + " 人";
    roturier.innerHTML = "村民 " + roturierNumber + " 人";
} /* 输入人数 */


function judgeNumber() {
    if (impotContent > 4 && impotContent < 21) {
        sharpShootNumber = "1";
        doctorNumber = "1";
    }

    switch (impotContent) {
        case 5:
            killerNumber = "1";
            policeNumber = "1";
            roturierNumber = "1";
            break;
        case 6:
            killerNumber = "1";
            policeNumber = "1";
            roturierNumber = "2";
            break;
        case 7:
            killerNumber = "1";
            policeNumber = "1";
            roturierNumber = "3";
            break;
        case 8:
            killerNumber = "1";
            policeNumber = "1";
            roturierNumber = "4";
            break;
        case 9:
            killerNumber = "2";
            policeNumber = "1";
            roturierNumber = "4";
            break;
        case 10:
            killerNumber = "2";
            policeNumber = "1";
            roturierNumber = "5";
            break;
        case 11:
            killerNumber = "2";
            policeNumber = "1";
            roturierNumber = "6";
            break;
        case 12:
            killerNumber = "3";
            policeNumber = "2";
            roturierNumber = "5";
            break;
        case 13:
            killerNumber = "3";
            policeNumber = "2";
            roturierNumber = "6";
            break;
        case 14:
            killerNumber = "3";
            policeNumber = "2";
            roturierNumber = "7";
            break;
        case 15:
            killerNumber = "4";
            policeNumber = "3";
            roturierNumber = "6";
            break;
        case 16:
            killerNumber = "4";
            policeNumber = "3";
            roturierNumber = "7";
            break;
        case 17:
            killerNumber = "5";
            policeNumber = "4";
            roturierNumber = "6";
            break;
        case 18:
            killerNumber = "5";
            policeNumber = "4";
            roturierNumber = "7";
            break;
        case 19:
            killerNumber = "5";
            policeNumber = "4";
            roturierNumber = "8";
            break;
        case 20:
            killerNumber = "5";
            policeNumber = "4";
            roturierNumber = "9";
            break;
    } /*  */
} /* 输入的人数判断、分配人数 */

var identity = new Array(); /* 存放身份数组 */

function addIdentityArray() {
    for (var i = 0; i < killerNumber; i++) {
        identity.push("杀手");
    }
    for (var i = 0; i < policeNumber; i++) {
        identity.push("警察");
    }
    for (var i = 0; i < roturierNumber; i++) {
        identity.push("村民");
    }
    for (var i = 0; i < 1; i++) {
        identity.push("狙击手");
        identity.push("医生");
    }
} /* 身份添加至数组 */


function shuffle(array) {
    var _array = array.concat();

    for (var i = _array.length; i--;) {
        var j = Math.floor(Math.random() * (i + 1));
        var temp = _array[i];
        _array[i] = _array[j];
        _array[j] = temp;
    }
    return _array;
} /* 洗牌算法 数组乱序 */

function textarray() {
    identity = shuffle(identity);
    console.log(identity);
    identity = JSON.stringify(identity);
    sessionStorage.setItem("identity", identity);
} /* 转为json格式，存入sessionStorage */

/* ————————————————测试localstorage—————————————————— */