//如果数组里没有人数，弹出警告，数组赋值后可以跳转
function task3() {
    if (kills.length === 0) {
        alert("请先设置人数");
    }
    else {
        localStorage.setItem('killInit', JSON.stringify(kills));
        window.location.href = "task3-js.html";
    }
}

function jumpback() {
    window.location.href = "task2-first.html";
}


//给数组中的每一个人一个身份牌
var police;
var famer;
var sniper;
var kills = [];
function appendText() {
    $("ul").empty();
    put();
    var txt = [];
    var kn = kills.filter(function (item, index, array) {
        return (item === "杀手")
    });
    var fm = kills.length - kn.length - 1;
    if (kills.length > 4 && kills.length < 19) {
        txt1 = $("<li></li>").text("杀手" + kn.length + "人").addClass("orange");
        txt2 = $("<li></li>").text("平民" + fm + "人").addClass("blue");
        txt3 = $("<li></li>").text("狙击手" + 1 + "人").addClass("purple");
        $("ul").append(txt1, txt2, txt3);
    }
}


//将表单里的数值赋给滑块
function range(){
    people=document.getElementById("test");
    slider =document.getElementById("range");
    slider.value=people.value;
}
//将滑块里的值赋给表单
function input(){
    people=document.getElementById('test');
    slider=document.getElementById("range");
    people.value=slider.value;
}
//点击减少人数
function minus(){
    slider=document.getElementById("range").value;
    if (slider<=5) {
       alert("不能再少啦");
    }else{
        slider--;
    }

    document.getElementById("range").value=slider;
    document.getElementById('test').value=slider;

}
//点击增加人数
function add(){
    slider=document.getElementById("range").value;
    if (slider>=18) {
        alert("不能再多啦");
    }else{
        slider++;
    }

    document.getElementById("range").value=slider;
    document.getElementById('test').value=slider;
}
//输入框
function over(){
    people=document.getElementById('test').value;
    if (people>18) {
        alert("请输入4-18个人数");
    }else if(people<5){
        alert("请输入4-18个人数");
    }
}


function put() {
    kills = [];
    var num = $("#test").val();
    switch (num) {
        case "4":
        case "5":
            police = 1;
            sniper = 1;
            famer = num - police - sniper;
            break;
        case "6":
        case "7":
            police = 2;
            sniper = 1;
            famer = num - police - sniper;
            break;
        case "8":
        case "9":
            police = 2;
            sniper = 1;
            famer = num - police - sniper;
            break;
        case "10":
        case "11":
            police = 3;
            sniper = 1;
            famer = num - police - sniper;
            break;
        case "12":
        case "13":
            police = 3;
            sniper = 1;
            famer = num - police - sniper;
            break;
        case "14":
        case "15":
            police = 4;
            sniper = 1;
            famer = num - police - sniper;
            break;
        case "16":
        case "17":
        case "18":
            police = 5;
            sniper = 1;
            famer = num - police - sniper;
            break;
        default:
            alert("人数太少啦");
    }
    for (i = 0; i < police; i++) {
        kills.push("杀手");
    }
    for (i = 0; i < famer; i++) {
        kills.push("平民");
    }
    for (i = 0; i < sniper; i++) {
        kills.push("狙击手");
    }
    kills.sort(function () {
        return 0.5 - Math.random()
    });
}