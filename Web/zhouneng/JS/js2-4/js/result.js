$('.left').click(function () {
    if (confirm("返回到主页")) {
        localStorage.clear(); //清除所有数据
        location.href = "../html/start.html";
    } else {
        return false;
    }
})

// 读取剩下的杀手人数
var Killernum = JSON.parse(localStorage.getItem("Killernum"));
// 读取剩下的平民人数
var civiliannum = JSON.parse(localStorage.getItem("civiliannum"));

$('.killer').text("杀手" + Killernum + "人"); //显示存活的杀手人数
$('.civilian').text("平民" + civiliannum + "人"); //显示存活的平民人数


// 获取每一天被杀手杀死的玩家
var killarr = JSON.parse(localStorage.getItem("killarr"));
console.log(killarr)
// 获取每一天被投票投死的玩家
var castarr = JSON.parse(localStorage.getItem("castarr"));
console.log(castarr)

if (killarr != null) {
    // 循环出天数
    for (let i = 0; i < killarr.length - 1; i++) {
        $('main').append($('ul').eq(0).clone(true));
    }

    var x = 0 //定义一个进行了多少天数的变量
    for (let i = 0; i < killarr.length; i++) {
        // 每一天黑夜杀手杀人的数据
        $('.night').eq(i).text("黑夜：" + killarr[i].num + "号被杀死，真实身份是" + killarr[i].breed);
        x = i + 1 //循环的天数+1
        // 显示对应的天数
        $('.days').eq(i).text("第" + x + "天");
    }
}
if (castarr != null) {
    // 每一天白天被投死的数据
    for (let i = 0; i < castarr.length; i++) {
        $('.daytime').eq(i).text("白天：" + castarr[i].num + "号被投死，真实身份是" + castarr[i].breed);
    }
}


// 点击再来一局
$('button').click(function () {
    localStorage.clear(); //清除所有数据
    location.href = "../html/Player.html" //返回到分配玩家页面
})