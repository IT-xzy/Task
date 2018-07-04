var data = JSON.parse(localStorage.getItem('identity'));      //原始数组
var box = document.getElementsByClassName('box');            //所有盒子节点
var id = document.getElementsByClassName('id');             //盒子内文字节点
var a;
var arr = JSON.parse(sessionStorage.getItem('data'));               //新的对象数组 
var arr2 = JSON.parse(sessionStorage.getItem('data4'));            // 投死的动作数组 
$("#homepage").click(function backHome() {
    sessionStorage.clear();                        //关闭按钮
    if (confirm("确定关闭游戏嘛 ")) {
        $(location).attr('href', '1.html');
    }
})
if (arr2 == null) {                    //第一天传来是空但是不是数组 所以这里给转成空数组
    arr2 = [];
}
for (let i = 0; i < data.length; i++) {           //循环生成 盒子和身份
    $(box[i]).css('display','block'); 
    if (data[i] == '好人') {
        $(id[i]).html('平民');
    } else {
        $(id[i]).html('狼人');
    }
}
for (let i = 0; i < data.length; i++) {                 //循环给死亡玩家变色
    if (arr[i].state == "died") {
        $(id[i]).css('backgroundColor','green');
    }
}
$(".box").click(function () {
    a = $(this).index();
});
$("#begin").click(function () {                     //投票按钮
    if (!a) {
        alert('请选中玩家')
        return
    };
    if (arr[a].state == 'died') {
        alert('该玩家已死');
        return
    }
    arr[0].day += 1;                              //投完 天数加1
    arr[a].state = 'died';
    arr2.push(arr[a].id + '号玩家被票出,真是身份是' + arr[a].name);
    sessionStorage.setItem('data4', JSON.stringify(arr2));
    window.sessionStorage.setItem('data', JSON.stringify(arr));
    var n = 0;                           //建立两个基础类型    根据活着的玩家 身份 判定输赢
    var m = 0;
    for(let i=0; i<data.length; i++){
        if(arr[i].state == 'live' && arr[i].name == '平民') {
               n += 1
        }   
        else if (arr[i].state == 'live' && arr[i].name == '狼人'){
            m += 1 ;
        }
    }
    sessionStorage.setItem('goodlive', JSON.stringify(n));
    sessionStorage.setItem('badlive', JSON.stringify(m));
    if(m == 0){                                        //狼人死光了 结束
        arr[0].day -= 1;                         //如果今天完成了判定输赢   就不生成另一天
        window.sessionStorage.setItem('data', JSON.stringify(arr));
        $(location).attr('href', '9.html');
        return
    }
    if( n == m ) {                                 //好人换人相等 游戏结束 狼人胜利
        $(location).attr('href', '9.html');
        arr[0].day -= 1;                           //如果今天完成了判定输赢   就不生成另一天
        window.sessionStorage.setItem('data', JSON.stringify(arr));       
        return
    }
    $(location).attr('href', '6.html');
})