var order = JSON.parse(localStorage.getItem('key'));
//读取上一个js的乱序数组
console.log(order);

a = document.getElementById("picture1");
//获取第一图片节点
b = document.getElementById("picture2");
//获取第二图片节点
// document.getElementById("number_up").innerText =
//获取头部序号节点
player = document.getElementById("player");



var I = document.getElementById("number-down");
var arr = []; //建立一个空数组
var arr = order; //将上一个页面的乱序数值赋值给它

var i = 0;
var m = 2;

function button() {
    if (i % 1 == 0) {
        a.style.display = "none";
        b.style.display = "block";
        player.style.display = "block";
        player.innerText = (arr[i]);
        console.log(arr)
        console.log(player);
        //获取职业

        console.log(I)

        document.getElementById("number_box").innerText = ("隐藏并传递给" + m + "号");
        //获取点击按钮样式节点
        i = i + 0.5;
        m = m + 1;

        console.log(i)


    } else {
        var n = m - 1;
        a.style.display = "block";
        b.style.display = "none";
        player.style.display = "none";
        document.getElementById("number_up").innerText = (n);
        document.getElementById("number_box").innerText = ("查看" + n + "号身份");
        i = i + 0.5;
        I = I++;
    }
    // if(i=arr.length){
    //     document.getElementById("number_box").innerText=("法官查看");

    // }
    if (m - 1 > arr.length) {
        document.getElementById("number_box").innerText = ("法官查看");
    }
    console.log(m - 1)
    if (i == arr.length) {
        location.href = "./home.html";
    }
    console.log()
}