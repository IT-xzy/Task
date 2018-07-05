$(document).ready(function () {
    $("#again,.icon-home").click(function () { //点击再来一局跳转首页
        $(location).attr('href',"index.html");
        localStorage.clear();
    });
    var resault = JSON.parse(localStorage.getItem("resault")); //获得结果数据
    $("#resault-word").text(resault);
    var arryDay = JSON.parse(localStorage.getItem("arryDay")); //获得天数数组
    console.log(arryDay);
    var box = document.getElementsByClassName('box')[0]; //获取天数文本父级
    var day = document.getElementsByClassName("day"); //获取天数节点数组
    var day2 = document.getElementsByClassName("day")[0]; //获取天数节点本身
    var dienum = JSON.parse(localStorage.getItem('dieNum')); //获取杀人页面点击的索引数组
    var dienum2 = JSON.parse(localStorage.getItem('dieNum2')); //获取投死页面点击的索引数组2
    console.log(dienum);
    console.log(dienum2);
    var allPlayers = JSON.parse(localStorage.getItem('allP')); //获取储存的所有人序列号和对应身份和状态
    // console.log(allPlayers);
    var kNum = JSON.parse(localStorage.getItem("kNum")); //获取杀手人数
    var pNum = JSON.parse(localStorage.getItem("pNum")); //获取平民人数
    console.log(kNum, pNum);
    box.removeChild(day2); //删除原本天数文本
    $(".killer").text("杀手 " + kNum + " 人"); //填入剩余人数
    $(".villager").text("平民 " + pNum + " 人");
    for (var i = 0; i < arryDay.length; i++) { //循环添加每天结果
        var clone = day2.cloneNode(true); //复制身份牌
        box.appendChild(clone); //添加复制的天数结果
        $(day[i]).find(".day-number").text("第" + arryDay[i] + "天");
    };
    if (dienum !== null) { //如果杀死了人
        for (var i = 0; i < dienum.length; i++) { //循环添加每天结果
            $(day[i]).find(".moon").append((1 + ~~dienum[i]) + "号被杀死了,真实身份是" + allPlayers[~~dienum[i]].status);
        };
    };
    if (dienum2 !== null) { //如果投死了人
        for (var i = 0; i < dienum2.length; i++) { //循环添加每天结果
            $(day[i]).find(".sun").append((1 + ~~dienum2[i]) + "号被投死了,真实身份是" + allPlayers[~~dienum2[i]].status);
        };
    };
});