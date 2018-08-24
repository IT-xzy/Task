$('#off').click(function () {
    if (confirm("是否要退出游戏返回到主页面")) {
        location.href = "../html/start.html"; //点击确定返回到主页面
    } else {
        return false; //点击取消停留在当前页面
    }
})

// 获取一开始保存到本地的玩家属性的对象数组的数据
var data = JSON.parse(localStorage.getItem("store"));
var arr = [];
arr = data;
// console.log(arr)

// 循环出玩家对应的盒子
for (let i = 0; i < arr.length - 1; i++) {
    $('main').append($('.box').eq(0).clone(true)); //在main里面循环对应的玩家盒子
}

var x = 0; //声明一个变量记录玩家序号
// 循环玩家角色
for (let i = 0; i <= arr.length - 1; i++) {
    $('.role').eq(i).text(arr[i].breed) //把数组指标对应的玩家对象类型属性传入对应指标的盒子里
    x = arr[i].num; //获取数组指标对应的玩家对象的玩家序号
    $('.number').eq(i).text(x + "号"); //把玩家人数序号传入对应指标的盒子

    // 把已经被投死和被杀死的玩家背景颜色改变
    if (arr[i].status == "杀死" || arr[i].status == "投死") {
        $('.box').eq(i).css("background", "#e4e4e4");
    }
}

// 下拉菜单
$('.box').click(function () {
    $('.knife').hide(); //隐藏小刀
    $(this).find('.knife').show(); //点击玩家盒子搜索显示后代元素小刀
})

var a; //记录被杀手选中的玩家
$('.box').click(function () {
    a = $(this).index() - 2;
    console.log(a)
    console.log(arr[a])
})

// 获取被投票投死的玩家
var castarr = JSON.parse(localStorage.getItem("castarr"));
// 当第一天投票时创建一个被投死的玩家数组
if (castarr == null) {
    var castarr = [];
}

function Cast(num, breed) {
    this.num = num;
    this.breed = breed;
}

// 读取分配角色时储存的杀手人数和剩下的杀手人数
var Killernum = JSON.parse(localStorage.getItem("Killernum"));
// 读取剩下的平民人数
var civiliannum = JSON.parse(localStorage.getItem("civiliannum"));
var Killer = Killernum; //定义一个杀手变量，把获取的杀手人数传到该变量
console.log(Killer)
var civilian = civiliannum; //定义一个平民变量，把获取的平民人数传到该变量
console.log(civilian)

// 点击投票按钮
$('button').click(function () {
    // 当未选择玩家时，跳出提示弹窗
    if (a == undefined) {
        alert("请选择要投死的玩家")
    } else {
        // 记录投杀玩家的序号push到投死的玩家数组
        castarr.push(new Cast(arr[a].num, arr[a].breed));
        // 保存push的死亡玩家数组
        localStorage.setItem("castarr", JSON.stringify(castarr));
        // 点击杀手投票投死时杀手人数-1
        if (arr[a].breed == "杀手") {
            Killer = Killer - 1;
        } else if (arr[a].breed == "平民") {
            // 点击平民投票投死时平民人数-1
            civilian = civilian - 1;
        }
        // 时时保存杀手剩余的人数
        localStorage.setItem("Killernum", JSON.stringify(Killer));
        // 时时保存平民剩余的人数
        localStorage.setItem("civiliannum", JSON.stringify(civilian));
        // 当杀手人数或平民人数为0时结束游戏
        if (Killer == "0" || civilian == "0") {
            location.href = "../html/result.html";
            return;
        }
        // 当点击被杀死和被投死的玩家，提示玩家已死亡
        if (arr[a].status == "杀死" || arr[a].status == "投死") {
            alert("该玩家已经死亡，请选择其他玩家");
        } else {
            // 当选中其他玩家投票
            arr[a].status = "投死"; //把玩家对象的status属性值改为投死
            // 投杀玩家的背景改变
            $('.box').eq(a).css("background", "#e4e4e4");
            // 保存被投死的玩家对象
            localStorage.setItem("store", JSON.stringify(arr));
            location.href = "../html/libretto.html"; ////返回到游戏进度页面  
        }
    }
})