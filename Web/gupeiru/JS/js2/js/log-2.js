$(document).ready(function () {
    var big = document.getElementsByClassName('big-box')[0]; //获取身份牌大盒子
    var little = document.getElementsByClassName('little-box')[0]; //获取身份牌小盒子
    var people = document.getElementsByClassName('people'); //获取身份节点
    var order = document.getElementsByClassName('order'); //获取序列号节点
    var identity = JSON.parse(localStorage.getItem("key")); //获取存储的身份数组数据
    big.removeChild(little);
    //动态生成身份牌
    for (var i = 0; i < identity.length; i++) { //动态添加身份牌节点
        var clone = little.cloneNode(true); //复制身份牌
        big.appendChild(clone); //添加身份牌
        people[i].innerHTML = identity[i]; //添加身份文字
        order[i].innerHTML = i + 1 + "号"; //动态添加序列号文字
    };
    var step = localStorage.getItem('steps'); //获取步骤页面存储的步骤状态
    var allPlayers = JSON.parse(localStorage.getItem('allP')); //获取储存的所有人序列号和对应身份和状态
    var allPeople = document.getElementsByClassName('yellow-box'); //获取身份牌节点
    for (var e = 0; e < identity.length; e++) {
        if (allPlayers[e].state === 0) { //如果为死亡则背景颜色改变
            allPeople[e].style.backgroundColor = "#83b09a";
        };
    };
    //底部按钮点击事件
    $('#go').click(function () {
        $(location).attr('href',"step.html");
    });
    document.onkeydown = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) { //键盘enter键确认输入等同点击底部按钮
            go.click();
        };
    };
});