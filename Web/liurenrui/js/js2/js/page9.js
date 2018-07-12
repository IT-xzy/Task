console.log('JS文件');

var noteArr = JSON.parse(sessionStorage.getItem("noteArr")); //法官笔记

$('#back').on('click', function () {
    history.back();
}); //左上角返回按钮
$('#close').on('click', close); //右上角关闭按钮
function close() {
    var message = confirm("是否结束本轮游戏？"); //是否确定
    if (message) {
        location.replace('page2.html'); //返回首页
    }
}

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

$('#btn-back').on('click', function () {
    history.back();
}); //左上角返回按钮
$('#btn-close').on('click', close); //右上角关闭按钮
function close() {
    var message = confirm("是否结束本轮游戏？"); //是否确定
    if (message) {
        location.replace('page2.html'); //返回首页
    }
}