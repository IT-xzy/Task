var input = document.getElementById('myinput') //获取节点
var arr = [];//全局变量声明
    
function change() { //创建一个人数分配函数组
    var x = document.getElementById("myinput").value; //总人数 
    var z = Math.round(x / 2 + x / 6 + x / 24.1); //平民人数
    var y = x - z; //杀手人数
    document.getElementById("killer").innerHTML = y; //HTML显示杀手人数
    document.getElementById("civ").innerHTML = z; //HTML显示平民人数
    if (4 > x || 18 < x) { //人数不正确判断
        document.getElementById("killer").innerHTML = ""; //输出空
        document.getElementById("civ").innerHTML = ""; //输出空

    } else {
        arr = [];
        for (var i = 0; i < y; i++) {
            arr.push("杀手")
        }
        for (var i = 0; i < z; i++) {
            arr.push("平民")
        }
        console.log(arr)
    }
}


change() //先运行一遍

input.oninput = function myf() {
    change()
}


// 这是点击事件
function button() {
    var x = document.getElementById("myinput").value; //变量X为输入的总人数
    if (4 > x || 18 < x) { //判断条件
        confirm('人数不对') //对话框
    } else {
        var res = []; //乱序，不过看不懂啊！！！！！！！！！
        for (var i = 0, len = arr.length; i < len; i++) {
            var randomIndex = Math.floor(Math.random() * arr.length);
            res[i] = arr[randomIndex];
            arr.splice(randomIndex, 1);
        }
        localStorage.setItem("key", JSON.stringify(res));//保存数据
        console.log(res);
    }
    location.href = "./allot.html";
    return false;
}


var back = document.getElementById("back");
back.onclick = function () {
    console.log(11)
    if (confirm("返回页面")) {
        location.href = "./home.html";
    } else {
        return false;
    }
}





//键盘事件，抬起按键触发
document.onkeyup = function (v) { //a时按键信息对象以函数参数的形式传递进来
    //取出按键信息中的按键代码（大部分浏览器通过keyCode属性获取按键代码，但少部分浏览器使用的是charCode
    var x = v.keyCode;
    if (x === 13) { //13为回车键的编码

        //按下回车键执行如下代码
        var y = document.getElementById("myinput").value;
        if (y < 4 || y > 18) {
            confirm("人数不对")
        } else {
            button()

            location.href = "./allot.html";
        }
    }
}
// var team=[1,2,3,4];
// var res=[];
// for(var i=0,len=team.length;i<len;i++){
//     var randomIndex=Math.floor(Math.random()*team.length);
//     res[i]=team[randomIndex];
//     team.splice(randomIndex,1);

// }
// console.log(res);