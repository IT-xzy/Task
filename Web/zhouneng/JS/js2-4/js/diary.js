// 返回按钮返回到发牌页面
$('#backtrack').click(function () {
    location.href = "../html/check.html";
})

// 关闭按钮返回到主页面
$('#off').click(function () {
    if (confirm("是否要退出游戏返回到主页面")) {
        location.href = "../html/start.html"; //点击确定返回到主页面
    } else {
        return false; //点击取消停留在当前页面
    }
})

// 获取发牌时保存的数据
var data = JSON.parse(localStorage.getItem('key'));
var arr = []; //声明一个数组
var arr = data; //把获取的数据传递到数组
console.log(arr);

// 循环出玩家对应的盒子
for (let i = 0; i < arr.length - 1; i++) {
    $('main').append($('.box').eq(0).clone(true)) //在main里面循环对应的玩家盒子
}

var x = 0; //声明一个变量记录玩家序号
// 循环玩家角色
for (let i = 0; i <= arr.length - 1; i++) {
    $('.role').eq(i).text(arr[i]) //把数组指标对应的玩家对象类型属性传入对应指标的盒子里
    x = i + 1; //获取数组指标对应的玩家对象的玩家序号
    $('.number').eq(i).text(x + "号"); //把玩家人数序号传入对应指标的盒子
}

// 点击button生成构造函数
$('button').click(function () {
    // 创建构造函数
    function Part(breed, status, num) {
        this.breed = breed;
        this.status = status;
        this.num = num;
    }
    var PartArr = [] //声明一个数组，把构造函数的对象放到该数组

    for (let i = 0; i < arr.length; i++) {
        var temp = arr[i] //获取玩家对应的角色属性传到对象里
        var num = i + 1 //生成玩家数量序号传入到对象
        PartArr.push(new Part(temp, "存活", num)); //把生成的玩家对象push到数组
    }
    // 把玩家对象数组储存到浏览器本地
    localStorage.setItem("store", JSON.stringify(PartArr));
    // console.log(PartArr);
    location.href = "../html/libretto.html"; //进入下一个页面
})












// var button = document.getElementsByTagName("button")[0];
// button.onclick = function () {
//     // 创建构造函数
//     function Part(breed, status, num) {
//         this.breed = breed;
//         this.status = status;
//         this.num = num;
//     }

//     var PartArr = [] //声明一个数组，把构造函数的对象放到该数组

//     // 构造函数生成玩家对象
//     for (var i = 0; i < arr.length; i++) {
//         var temp = arr[i] //获取玩家对应的角色属性传到对象里
//         var num = i + 1 //生成玩家数量序号传入到对象
//         PartArr.push(new Part(temp, "存活", num)); //把生成的玩家对象push到数组
//     }
//     // 把玩家对象数组储存到浏览器本地
//     localStorage.setItem("store", JSON.stringify(PartArr));
//     // console.log(PartArr);


//     location.href = "../html/libretto.html"; //进入下一个页面
// }
