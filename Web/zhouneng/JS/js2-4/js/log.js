// 获取一开始保存到本地的玩家属性的对象数组的数据
var arr = JSON.parse(localStorage.getItem("store"));
console.log(arr)


var player = ''; //定义一个空字符串；
// 循环出对应的玩家盒子
for (let i = 0; i < arr.length; i++) {
    player += `
        <div class="box">
        <span class="role"> ${arr[i].breed} </span> 
        <span class="number"> ${arr[i].num}号 </span> 
        </div>`
}
$('main').html(player) //把循环出来盒子全部一次添加到main标签里


// 循环出玩家对应的盒子
// for (let i = 0; i < arr.length - 1; i++) {
//     $('main').append($('.box').eq(0).clone(true)); //在main里面循环对应的玩家盒子
// }

// var x = 0; //声明一个变量记录玩家序号
// 循环玩家角色
// for (let i = 0; i <= arr.length - 1; i++) {
//     $('.role').eq(i).text(arr[i].breed) //把数组指标对应的玩家对象类型属性传入对应指标的盒子里
//     x = arr[i].num; //获取数组指标对应的玩家对象的玩家序号
//     $('.number').eq(i).text(x + "号"); //把玩家人数序号传入对应指标的盒子
// }

for (let i = 0; i <= arr.length - 1; i++) {
    // 把已经被投死和被杀死的玩家背景颜色改变
    if (arr[i].status == "杀死" || arr[i].status == "投死") {
        $('.box').eq(i).css("background", "#e4e4e4");
    }
}

$('button').click(function () {
    location.href = "../html/libretto.html"
})