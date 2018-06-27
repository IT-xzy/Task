$(function () {
    var little = document.getElementsByClassName('little-box')[0]; //获取身份牌小盒子
    var people = document.getElementsByClassName('people'); //获取身份节点
    var order = document.getElementsByClassName('order'); //获取序列号节点
    var identity = JSON.parse(localStorage.getItem("key")); //获取存储的身份数组数据
    // console.log(identity);
    $(".little-box").remove(); //删除原身份盒子
    for (var i = 0; i < identity.length; i++) { //动态添加身份牌节点
        var clone = little.cloneNode(true); //复制身份牌
        $(".big-box").append(clone); //添加身份牌
        people[i].innerHTML = identity[i]; //添加身份文字
        order[i].innerHTML = i + 1 + "号"; //添加序列号
    };
    var allPlayers = []; //创建空数组储存所有人序列号和对应身份
    for (var k = 0; k < identity.length; k++) {
        allPlayers[k] = {};
        allPlayers[k].number = k + 1; //身份序列号
        allPlayers[k].status = identity[k]; //身份
        allPlayers[k].state = 1; //状态为存活
    };
    // console.log(allPlayers);
    $("#go").on("click", function () { //开始游戏按钮点击事件
        $(location).attr('href',"step.html"); //点击开始游戏按钮跳转游戏步骤页面
        localStorage.setItem('steps', 'none'); //存储初始步骤为none
        localStorage.setItem('allP', JSON.stringify(allPlayers)); //储存序列号和身份数据
    });
    back("check.html"); //点击返回按钮返回查看身份页面
    close(); //点击关闭按钮弹窗
    hidden(); //点击取消弹窗消失
    enter(); //enter键等同底部按钮
});