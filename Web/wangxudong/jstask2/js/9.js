var n = JSON.parse(sessionStorage.getItem('goodlive'));         //好人活着几个人
var m = JSON.parse(sessionStorage.getItem('badlive'));        //坏人活着几个人
var arr = JSON.parse(sessionStorage.getItem('data'));          //对象数组  用来获取天数
var arr1 = JSON.parse(sessionStorage.getItem('data3'));         //杀人动作
var arr2 = JSON.parse(sessionStorage.getItem('data4'));         //投票动作
var num = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"]
$("#homepage").click(function backHome() {        //首页按钮
    sessionStorage.clear();
    $(location).attr('href', '1.html');
})
if (n == null) {                              //有多少人活着  好人坏人分别是多少   如果没动作直接结束 的判断所有人活着
    $("#good").html('所有好人存活');
    $("#bad").html('所有狼人存活');
} else {
    $("#good").html('好人存活' + n);
    $("#bad").html('坏人存活' + m);
}
if (n == m && n != null) {                      //好人 坏人胜利  游戏直接结束  分别不同的图片
    $("#img").attr("src", "img/ssvtr.png");
} else if (m == 0) {
    $("#img").attr("src", 'img/pmvtr.png');
} else {
    $("#img").attr("src", 'img/end.png');
}
var night = document.getElementsByClassName('night');                 //晚上动作
var daytime = document.getElementsByClassName('daytime');             //投票动作

for (let i = 0; i < arr[0].day; i++) {                         //动态生成 列表
    $("#list").append(`<li>
    <p><span class="day">第一天</span><span></span></p>
    <p class="night"></p>
    <p class="daytime"></p></li>`)
    $(".day")[i].innerHTML = '第' + num[i] + "天";     //第几天 
    if (arr1 == null && arr2 == null) {                //判断如果 没动作 直接结束时候  的内容  和正常传过来的动作内容
        $(night[i]).html('晚上:');
        $(daytime[i]).html('白天:');

    } else if (arr2 == null) {
        $(night[i]).html('晚上:' + arr1[i]);
        $(daytime[i]).html('白天:');

    } else {
        if (arr1[i] == undefined) {              //没动作没值 就是空的
            arr1[i] = '';
        }
        if (arr2[i] == undefined) {
            arr2[i] = '';
        }
        $(night[i]).html('晚上:' + arr1[i]);
        $(daytime[i]).html('白天:' + arr2[i]);
    }
}

$("#next").click(function Next() {                    //再来一局按钮
    sessionStorage.clear();
    $(location).attr('href', '3.html');
})