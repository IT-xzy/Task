arrKill1 = JSON.parse(localStorage.getItem('arrKill1'));
arrKill2 = JSON.parse(localStorage.getItem('arrKill2'));

function fhkill() {
    window.location.assign('./kill.html');
}
arrD = JSON.parse(localStorage.getItem('arrD'));

function tianjia() {
    var oD = document.getElementById("CC");
    var oDiv0 = document.createElement("div");
    oDiv0.className = "someday";
    var oDiv1 = document.createElement("div");
    oDiv1.className = "day";
    var oP1 = document.createElement("p");
    oP1.innerHTML = "第" + zh[oC] + "天";
    var oDiv2 = document.createElement("div");
    oDiv2.id = "triangle-up";
    var oDiv3 = document.createElement("div");
    oDiv3.className = "shunxu";
    var oDiv31 = document.createElement("div");
    oDiv31.id = "kill";
    var oP2 = document.createElement("p");
    oP2.innerHTML = "杀手杀人";
    var oDiv32 = document.createElement("div");
    oDiv32.id = "yiyan";
    var oP3 = document.createElement("p");
    oP3.innerHTML = "亡灵发表遗言";
    var oDiv33 = document.createElement("div");
    oDiv33.id = "player";
    var oP4 = document.createElement("p");
    oP4.innerHTML = "玩家依次发言";
    var oDiv34 = document.createElement("div");
    oDiv34.id = "playertoupiao";
    var oP5 = document.createElement("p");
    oP5.innerHTML = "投票";

    var oDiv99 = document.createElement("div");
    var oDiv100 = document.createElement("div");
    var oDiv101 = document.createElement("div");
    var oDiv102 = document.createElement("div");
    oD.appendChild(oDiv0);
    oDiv0.appendChild(oDiv1);
    oDiv1.appendChild(oP1)
    oDiv0.appendChild(oDiv2);
    oDiv0.appendChild(oDiv3);
    oDiv3.appendChild(oDiv31);
    oDiv31.appendChild(oDiv99);
    oDiv31.appendChild(oP2);
    oDiv3.appendChild(oDiv32);
    oDiv32.appendChild(oDiv100);
    oDiv32.appendChild(oP3);
    oDiv3.appendChild(oDiv33);
    oDiv33.appendChild(oDiv101);
    oDiv33.appendChild(oP4);
    oDiv3.appendChild(oDiv34);
    oDiv34.appendChild(oDiv102);
    oDiv34.appendChild(oP5);

}
arrZ = JSON.parse(localStorage.getItem('arrZ'));
var zh = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二", "十三"];
var oC = 0;
while (oC < arrZ[0]) {
    tianjia(); //循环生成多个  
    oC++;
}

function yanshi() {
    function dayone2() {
        var oDiv7 = document.getElementsByClassName("someday");
        var oP7 = document.createElement("p");
        oP7.className = "die1";
        oP7.innerHTML = arrKill2[oG];
        oDiv7[oG].appendChild(oP7); 
    }

    function dayone() {
        var oDiv7 = document.getElementsByClassName("someday");
        var oP6 = document.createElement("p");
        oP6.className = "die2";
        oP6.innerHTML = arrKill1[oV];
        oDiv7[oV].appendChild(oP6);

    }
    var oV = 0;
    while (oV < arrKill1.length) {
        dayone(); //循环生成多个  
        oV++;
    }
    var oG = 0;
    while (oG < arrKill2.length) {
        dayone2(); //循环生成多个  
        oG++;
    }
}
setTimeout("yanshi()", 20);


$(".someday #kill").each(function (i) {
    this.index = i;
    var oI = i + 1;
    $(this).click(function () {
        if ($("#CC >div:nth-child(" + oI + ") #kill").css('background-color') == "rgb(190, 190, 190)") {
            alert("请安顺序执行 ，不要乱点");
        } else {
            arrD[0] = 2;
            arrD[1] = i + 1;
            localStorage.setItem('arrD', JSON.stringify(arrD));
            window.location.assign('./toupiao.html');
        }
    })
})

$(".someday #yiyan").each(function (i) {
    this.index = i;
    var oI = i + 1;
    $(this).click(function () {
        if ($("#CC >div:nth-child(" + oI + ") #kill").css('background-color') == "rgb(190, 190, 190)" && $("#CC >div:nth-child(" + oI + ") #yiyan").css('background-color') == "rgb(41, 189, 224)") {
            arrD[0] = 3;
            arrD[1] = i + 1;
            localStorage.setItem('arrD', JSON.stringify(arrD));
            window.location.reload();
            alert("请死者亮明身份并发表遗言");
        } else {
            alert("请安顺序执行 ，不要乱点");
        }
    })
})

$(".someday #player").each(function (i) {
    this.index = i;
    var oI = i + 1;
    $(this).click(function () {
        if ($("#CC >div:nth-child(" + oI + ") #yiyan").css('background-color') == "rgb(190, 190, 190)" && $("#CC >div:nth-child(" + oI + ") #player").css('background-color') == "rgb(41, 189, 224)") {
            arrD[0] = 4;
            arrD[1] = i + 1;
            localStorage.setItem('arrD', JSON.stringify(arrD));
            window.location.reload();
            alert("玩家依次发言讨论");

        } else {
            alert("请安顺序执行 ，不要乱点");
        }
    })
})

$(".someday #playertoupiao").each(function (i) {
    this.index = i;
    var oI = i + 1;
    $(this).click(function () {
        if ($("#CC >div:nth-child(" + oI + ") #player").css('background-color') == "rgb(190, 190, 190)" && $("#CC >div:nth-child(" + oI + ") #playertoupiao").css('background-color') == "rgb(41, 189, 224)") {
            arrD[0] = 1;
            arrD[1] = i + 2;
            arrZ[0] = arrZ[0] + 1;
            localStorage.setItem('arrZ', JSON.stringify(arrZ));
            localStorage.setItem('arrD', JSON.stringify(arrD));
            window.location.assign('./toupiao2.html');
        } else {
            alert("请安顺序执行 ，不要乱点");
        }
    })
})
var oC = 1;
while (oC < arrD[0]) {
    $(" .shunxu >div:nth-child(" + oC + ")").css("background-color", "rgb(190, 190, 190)");
    $(" .shunxu >div:nth-child(" + oC + ") div").css("border-right-color", "rgb(190, 190, 190)");
    oC++;
}
var oW = 0
while (oW < arrD[1]) {
    $("#CC >div:nth-child(" + oW + ") .shunxu >div ").css("background-color", "rgb(190, 190, 190)");
    $("#CC >div:nth-child(" + oW + ") .shunxu >div div").css("border-right-color", "rgb(190, 190, 190)");
    oW++;
}

arrEz = JSON.parse(localStorage.getItem('arrEz'));
arrX = JSON.parse(localStorage.getItem('arrX'));

// alert(arrX.length);

// var oQ = 1;
// while (oQ < 2) {
//     var oPH = document.createElement("p");
//     oPH.className = "diepeople" + oQ;
// }