var playerNum = document.getElementById("player");//玩家总人数
var sliderBlock = document.getElementById("slider");//滑块的值
var back = document.getElementById("back");
//设置游戏返回到初始页面
back.addEventListener("click", function () {
    sessionStorage.clear();
    window.location.href = ""
}, false);

//数组乱序
function shuffle(array) {
    var _array = array.concat();
    for (var i = _array.length; i--; ) {
        var j = Math.floor(Math.random() * (i + 1));
        var temp = _array[i];
        _array[i] = _array[j];
        _array[j] = temp;
    }
    return _array;
}

//点击设置玩家配比
function set() {
    var str = '';
    var arr = [];
    var a = playerNum.value;
    var killer = Math.floor(a/3);//杀手人数
    var people = a - killer;//平民人数
    for (var i = 0; i < killer; i++) {
        arr[i] = '<li class="killer">' + '杀 手' + '</li>';
    }
    for (var j = 0; j < people; j++) {
        arr[killer+j] = '<li class="people">' + '平 民' + '</li>';
    }
    arr = shuffle(arr);//打乱的新数组
    console.log(arr.length);
    for (i = 0;i < arr.length;i++){
        str += arr[i];
    }
    document.getElementById("ul-player").innerHTML = str;
    sessionStorage.setItem("playerArr",arr);//储存打乱的数组
}

//设置输入框的输入值范围
function number() {
    var value = playerNum.value;
    var reg = /(^[1-9]{1}[0-9]*$)/;
    if (playerNum.value >= 4 && playerNum.value <= 18) {//设置方框里面玩家人数范围
        sliderBlock.value = playerNum.value ;//将玩家总人数赋值给滑块的值，实现动态变化
    } else {
        alert("请输入正确的人数4-18");//人数超出范围的话，弹出警告框，并且将方框和滑块的值重置为4
        playerNum.value=4;
        sliderBlock.value=4;
    }
    if(!reg.test(value)){
        alert("请输入正确的人数4-18");
    }
}

//设置滑块
function numberChange() {// 滑块的值改变，运行这个函数
    playerNum.value = sliderBlock.value;//滑块的值改变的话，滑块的值赋值给方框，实现动态变化
}

//点击减少玩家人数
function minus() {
    playerNum.value--;//减的按钮，减掉玩家总人数的值
    if (playerNum.value < 4){
        alert("请输入正确的人数4-18");
        playerNum.value = 4;//人数超出范围的话，弹出警告框，并且将方框和滑块的值重置为4
    }
    else {
        sliderBlock.value = playerNum.value;// 将玩家人数赋值给滑轮的值
    }
}

//点击增加玩家人数
function add() {
    playerNum.value++;//加的按钮，减掉玩家总人数的值，上面的值已经相互关联了，所以方框的值改变，滑块的值也会改变
    if (playerNum.value > 18){
        alert("请输入正确的人数4-18");
        playerNum.value = 18;//人数超出范围的话，弹出警告框，并且将方框和滑块的值重置为18
    }
    else {
        sliderBlock.value = playerNum.value;// 将玩家人数赋值给滑轮的值
    }
}

//点击发牌按钮开始发牌，进入下一页面
function deal() {
    if(!sessionStorage.getItem("playerArr")){//判断是否点击设置
        alert("请设置人数");
    } else {
        var arr2 = sessionStorage.getItem("playerArr").split(",");
        if (parseInt(playerNum.value) !== arr2.length){
            alert("请设置人数")
        } else {
            window.location.href = "player-check.html";
        }
    }
}



