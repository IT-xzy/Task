
$("#return").on("click", function () {
    window.location.href = "task13-1.html";
    // 获取后退按钮节点跳转页面
});
// document.getElementById("return").addEventListener("click", goHome);
// function goHome() {
//     window.location.href = "task13-1.html";
// }
function check() {
    var num = document.getElementById("playernum").value;
        if (num <= 18 && num >= 4) {
            return num;
        }
        else {
            alert("请输入4-18之间的数字");
            return false;
        }
}
//滑动条同步
function change() {
    var num =document.getElementById("Range").value;
    document.getElementById("playernum").value = num;
    show();
}
// 加号
function add() {
    var player =document.getElementById("Range");
        player.value++;
        change();
}
// 减号
function reduce() {
    var player =document.getElementById("Range");
    // if (player.value >= 5) {
        player.value--;
        change();
    // }
}
//输入框onchange
function getnumber() {
    check();
    var num =document.getElementById("playernum").value;
    document.getElementById("Range").value = num;
    change();
}
//分配角色
function randarr() {
    //生成杀手人数，平民人数的数组
    var num = document.getElementById("Range").value;
    var Arr = [];
    var  n = 1;//分配杀手的参数
    for (var i = 0; i < num; i++) {
        Arr[i] = "平民";
        if ( i+1 >= 3 * n) {
            Arr[i] = "杀手";
            n++;
        }
    }
    console.log(Arr);
    //数组乱序洗牌
    for (var i = 0; i < num; i++) {
        var index,
            temp;
        index = Math.floor(Math.random() * num);
        if (i != index) {
            temp = Arr[i];
            Arr[i] = Arr[index];
            Arr[index] = temp;
        }
    }
    console.log(Arr);
    return Arr;
}
function show() {
    $("#board").empty();
    var  Arr = randarr();
    var  killer=0;
    var  people;
    var num =document.getElementById("playernum").value;
    for (var i=0; i<num; i++){
        // $("#board").append($("<div></div>").text(Arr[i]));
        $("#board").append(' <div >\n' +
            '                    <span class="circle"></span>\n' +
            '                    <div >' + Arr[i] + '</div>\n' +
            '                </div>')
        if (Arr[i] === "杀手") {
            $(".circle").eq(i).css({"background": "orange"});
            killer = killer+1;
            people = num - killer
        }
    }
    console.log(killer);
    console.log(people);
    // sessionStorage.setItem("killer",killer);
    // sessionStorage.setItem("people",people);
    sessionStorage.setItem("killer", JSON.stringify(killer));
    sessionStorage.setItem("people", JSON.stringify(people));
    sessionStorage.setItem("Arr", JSON.stringify(Arr)); //存入sessionstorage;
}
function go() {
    setTimeout(function(){window.location.href = "js-task3.html"},1000);
    var x = document.getElementById("board").childElementCount;
    if (x==0)
        show();
}

