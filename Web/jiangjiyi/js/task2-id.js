


var key = localStorage.getItem("Arr");
var kk = JSON.parse(key);
var test;
console.log(kk)

// var link=kk.length;

var count = 1;
var cnt = 1;
let cto =1;
let ceo =1;
let num=0;
//声明一个变量，变量等于布尔值真。

$(".bottom-vote").click(function(){
    topnum();
    backgro();
    next();
    now();
    show();
    name();
    Nextpage();
});

function name() {
    console.log(kk[num])
    $("#water").text(kk[num]);
};
function math() {
    cto +=0.5 ;
    let tt = Math.floor(cto);
    num = Math.floor(cto)-1;
    return tt;
}
function math2() {
    ceo +=0.5 ;
    return ceo;
}
function math1() {
    count +=0.5;
    let ti = Math.floor(count);
    return ti;
}
function another() {
    cnt +=0.5 ;
    let ti = Math.floor(cnt)+1;
    return ti;
}
function topnum() {
    $(".id").text(math());
}
function linklenth() {

}

//----------------------------用来改变顶部数字身份身份使用

//----------------------------用来改变第变化背景图片使用
function  backgro(){
    $(".ss").toggle();
    $(".bottom-vote p").toggle();
}
//----------------------------用来影藏初始的水民使用
$(".p").hide();
//----------------------------用来改变第一个按钮的文字使用
function next() {
    $(".next").text(another());
}
//----------------------------用来改变第一个按钮的文字使用
function now() {
    $(".now").text(math1());
}
//----------------------------用来影藏初始的水民使用
$("#water").hide();



//----------------------------用来跳转页面使用和显示身份

function show() {

    $("#water").toggle();
}
//----------------------------用来跳转页面使用

function Nextpage() {
    if ((kk.length+0.5) === math2()){
        $(".te").show()
        $(".ttt").hide()
        $(".dsd").show()


    }
}





