console.log('JS文件');

$('#back').on('click', function () {
    var message = confirm("是否返回主页？"); //是否确定
    if (message) {
        location.replace('page2.html'); //返回首页
    }
}); //左上角按钮

$('#close').on('click', close); //右上角关闭按钮
function close() {
    var message = confirm("是否关闭游戏？"); //是否确定
    if (message) {
        location.replace('page2.html'); //返回首页
    }
}

var Num = sessionStorage.getItem("Num"); //玩家人数
var kiword = sessionStorage.getItem("kiword");
var ciword = sessionStorage.getItem('ciword');
var end = sessionStorage.getItem('end'); //游戏结果
var noteArr = JSON.parse(sessionStorage.getItem("noteArr")); //法官笔记

$('#sp1').text(Math.floor(Num / 3)); //设置杀手人数
$('#sp2').text(Num - Math.floor(Num / 3)); //设置杀手人数
$('#sp3').text(kiword); //杀手词汇
$('#sp4').text(ciword); //平民词汇


function note() {
    var notebox = $('#notebox');
    for (var i = 0; i <noteArr.length; i++) {
        notebox.append(
            `<p class="notep">` +
            noteArr[i] +
            `</p>`);
    } //生成角色模块
}
note();

window.onload = function () {
    if (end == "杀手胜利") {
        $('.endword').text('杀手胜利')
    } else if (end = "平民胜利") {
        $('.endword').text('平民胜利')
    }
}