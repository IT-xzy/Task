var arr = JSON.parse(sessionStorage.getItem('data'));   //对象数组
var arr1 = JSON.parse(sessionStorage.getItem('data3'));  //杀人后返回的新对象数组
var arr2 = JSON.parse(sessionStorage.getItem('data4'));  //投票后 返回的新对象数组
$("#end").click(function () {                   //结束游戏按钮
    $(location).attr('href', '9.html');
})
$("#back").click(function () {                 //返回按钮
    sessionStorage.clear();
    $(location).attr('href', '3.html');
})
$("#homepage").click(function () {            //关闭按钮
    sessionStorage.clear();
    if (confirm("确定关闭游戏嘛 ")) {
        $(location).attr('href', '1.html');
    }
});
var m = 0;                                              //用来点击加1 
function create() {                                 //这个函数 是动态生成列表内容   天数 和天数那里点击事件
    var num = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"]
    $("#list").append( `<span class="day"></span>
    <div class="matter">
    <div class="dot"></div>
    <div class="moon"></div>
    <span class="kill">杀手杀人<div class="trianglea" ></div></span>
    <p class="killResult"></p>
    <div class="sun"></div>
    <span class="ghost">亡灵发表遗言<div class="triangleb" ></div></span>
    <span class="player">玩家依次发言<div class="trianglec" ></div></span>
    <span class="vote">投票<div class="triangled" ></div></span>
    <p class="voteResult"></p>
    </div>`) 
    $(".day").eq(m).html('第' + num[m] + '天');
    m += 1;
    for (let i = 0; i < m; i++) {
        $(".day")[i].onclick = function () {
            if ( $(".matter").eq(i).css("display")=='block') {
                $(".matter").eq(i).hide();
            } else if ( $(".matter").eq(i).css("display")=='none' )  {
                $(".matter").eq(i).show();
            }
        }
    }
}
for (let i = 0; i < arr[0].day; i++) {   //循环生成动态的列表内容
    create()
}
if (arr1 != undefined) {                  //杀人返回来的值  杀人动作  和 杀人按钮变色
    console.log(arr1[0])
    for (let i = 0; i < arr[0].day; i++) {
        if (arr1[i] != undefined) {
            $(".killResult")[i].innerHTML = arr1[i];
            $(".sun")[i].style.top = '6.4rem';
            $(".kill").eq(i).css("backgroundColor",'#ccc');
            $(".trianglea")[i].style.borderRight = '.7rem solid #ccc';
        }
    }
}
if (arr2 != undefined) {                      //投票回来的值   投死了谁    所有按钮变色
    for (let i = 0; i < arr[0].day; i++) {
        if (arr2[i] != undefined) {
            $(".voteResult")[i].innerHTML = arr2[i];
            $(".ghost").eq(i).css('backgroundColor','#ccc');
            $(".triangleb")[i].style.borderRight = '.7rem solid #ccc';
            $(".player").eq(i).css('backgroundColor','#ccc');
            $(".trianglec")[i].style.borderRight = '.7rem solid #ccc';
            $(".vote").eq(i).css('backgroundColor','#ccc');
            $(".triangled")[i].style.borderRight = '.7rem solid #ccc';
            $(".matter").eq(i).css('display','none');
        }
    }
}
for (let i = 0; i < arr[0].day; i++) {          //根据按钮颜色 判断 点击后生成的语言   告诉你该点什么
    //杀人 转按钮
    $(".kill").eq(i).click(function () {
        if ($(".kill").eq(i).css('backgroundColor') == 'rgb(204, 204, 204)') {
            alert('请进行下一项');
            return
        }
        sessionStorage.setItem('data', JSON.stringify(arr));
        $(location).attr('href', '7.html');
    }) 
    //亡灵发表遗言按钮
    $(".ghost").eq(i).click(function () {
        if ($(".kill").eq(i).css('backgroundColor') != 'rgb(204, 204, 204)') {
            alert('按顺序走');
            return
        }
        if ($(".ghost").eq(i).css('backgroundColor') == 'rgb(204, 204, 204)') {
            alert('请进行下一项');
            return
        }
        alert('表明身份发表遗言');
        $(".ghost").eq(i).css('backgroundColor','#ccc');
        $(".triangleb")[i].style.borderRight = '.7rem solid #ccc';
    })
    //玩家依次发言按钮
    $(".player").eq(i).click(function () {
        if ($(".ghost").eq(i).css('backgroundColor') != 'rgb(204, 204, 204)') {
            alert('按顺序走');
            return;
        }
        if ($(".player").eq(i).css('backgroundColor') == 'rgb(204, 204, 204)') {
            alert('请进行下一项');
            return
        }
        alert('玩家依次发言');
        $(".player").eq(i).css('backgroundColor','#ccc');
        $(".trianglec")[i].style.borderRight = '.7rem solid #ccc';
    })
    //投票按钮
    $(".vote").eq(i).click(function () {
        if ($(".player").eq(i).css('backgroundColor') != 'rgb(204, 204, 204)') {
            alert('按顺序走');
            return;
        }
        if ($(".vote").eq(i).css('backgroundColor') == 'rgb(204, 204, 204)') {
            alert('请进行下一项');
            return
        }
        sessionStorage.setItem('data', JSON.stringify(arr));
        $(location).attr('href', '8.html');
    })
}