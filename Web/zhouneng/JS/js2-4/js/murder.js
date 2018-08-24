// 关闭按钮返回到主页面
$('#off').click(function () {
    if (confirm("是否要退出游戏返回到主页面")) {
        location.href = "../html/start.html"; //点击确定返回到主页面
    } else {
        return false; //点击取消停留在当前页面
    }
})


// 获取一开始保存到本地的玩家属性的对象数组的数据
var data = JSON.parse(localStorage.getItem("store"));
console.log(data)
var arr = [];
arr = data;

// 循环出玩家对应的盒子
for (let i = 0; i < arr.length - 1; i++) {
    $('main').append($('.box').eq(0).clone(true)) //在main里面循环对应的玩家盒子
}


var x = 0; //声明一个变量记录玩家序号
// 循环玩家角色
for (let i = 0; i <= arr.length - 1; i++) {
    $('.role').eq(i).text(arr[i].breed) //把数组指标对应的玩家对象类型属性传入对应指标的盒子里
    x = arr[i].num; //获取数组指标对应的玩家对象的玩家序号
    $('.number').eq(i).text(x + "号"); //把玩家人数序号传入对应指标的盒子
}

// 把已经被投死和被杀死的玩家背景颜色改变
if (arr) {
    for (let i = 0; i <= arr.length - 1; i++) {
        if (arr[i].status == "杀死" || arr[i].status == "投死") {
            $('.box').eq(i).css("background", "#e4e4e4");
        }
    }

}

// 下拉菜单
$('.box').click(function () {
    $('.knife').hide(); //隐藏小刀
    $(this).find('.knife').show(); //点击玩家盒子搜索显示后代元素小刀
});


var a; //记录被杀手选中的玩家
$('.box').click(function () {
    a = $(this).index() - 2;
    console.log(a)
    console.log(arr[a])
})

// 获取被杀手杀死的玩家
var killarr = JSON.parse(localStorage.getItem("killarr"));
// 当第一天杀手杀人时创建一个被杀死的玩家数组
if (killarr == null) {
    var killarr = [];
}
console.log(killarr)

function Killed(num, breed) {
    this.num = num;
    this.breed = breed;
}

// 读取分配角色时储存的平民人数和剩下的平民人数
var civiliannum = JSON.parse(localStorage.getItem("civiliannum"));
var civilian = civiliannum; //定义一个平民变量，把获取的平民人数传到该变量
console.log(civilian)




// 点击杀人按钮
$('button').click(function () {
    // 当杀手未选择玩家时，跳出提示弹窗
    if (a == undefined) {
        alert("请选择要杀死的玩家")
    } else {
        // 当杀手点击平民并杀死时平民人数-1
        if (arr[a].breed == "平民") {
            civilian = civilian - 1;
            // 记录被杀玩家的序号push到被杀死的玩家数组
            killarr.push(new Killed(arr[a].num, arr[a].breed));
            // 保存push的死亡玩家数组
            localStorage.setItem("killarr", JSON.stringify(killarr));
        }
        // 时时保存平民剩余的人数
        localStorage.setItem("civiliannum", JSON.stringify(civilian));
        // 当平民人数为0时结束游戏
        if (civilian == "0") {
            location.href = "../html/result.html";
            return;
        }
        // 当点击被杀死和被投死的玩家，提示玩家已死亡
        if (arr[a].status == "杀死" || arr[a].status == "投死") {
            alert("该玩家已经死亡，请选择其他玩家");
        } else if (arr[a].breed == "杀手") {
            // 当杀手点击本职业玩家跳出窗口提示
            alert("你的职业是杀手，不能杀死本职业的玩家")
        } else {
            // 当杀手点击平民
            arr[a].status = "杀死"; //把玩家对象的status属性值改为杀死
            // 被杀玩家的背景改变
            $('.box').eq(a).css("background", "#e4e4e4");
            // 保存被杀死的玩家对象
            localStorage.setItem("store", JSON.stringify(arr));
            location.href = "../html/libretto.html"; //返回到游戏进度页面      
        }
    }
})