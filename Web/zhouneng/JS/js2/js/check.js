// 获取发牌时保存的数据
var data = JSON.parse(localStorage.getItem('key'));

// 返回按钮返回到发牌页面
function backtrack() {
    location.href = "../html/Player.html";
}

// 关闭按钮返回到主页面
function off() {
    // 点击关闭弹出提示窗口
    if (confirm("是否要退出游戏返回到主页面")) {
        location.href = "../html/start.html"; //点击确定返回到主页面
    } else {
        return false; //点击取消停留在当前页面
    }
}

var verso = document.getElementsByClassName("picture")[0];
var front = document.getElementsByClassName("circle-box")[0];
var player = document.getElementsByClassName("describe")[0];


var arr = []; //声明一个空数组
var arr = data; //把获取到本地的数据传到数组里
var m = -1;

// function button() {
//     console.log(arr)
//     arr[m];
//     m++;
//     console.log(arr[m]);

//     var a = 0;
//     var zz=document.getElementById("aaa");
//     if (a <= m) {
//         zz.innerHTML = m + 1;
        
//     }}


    // // if(m>arr.length-1){
    // //     location.href = "../html/Player.html";
    // // }
    //     // for(var i=0; i<arr.length; i++){
    //     //     m=" " + i + " " + arr[i];
    //     //     console.log(m);
    //     // }

    // }






  
    function button(){

            verso.style.display ="none";
            front.style.display ="inline-block";

            


    }
