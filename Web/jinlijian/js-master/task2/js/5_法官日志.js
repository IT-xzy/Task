var result1 = JSON.parse(sessionStorage.getItem('随机组'));
//得到数组后隐藏盒子(盒子是写好的）
var i;
for(i = 17 ; i > result1.length - 1 ; i-- ){
    document.getElementsByClassName("id12f")[i].style.display="none";
}
//给每个盒子的身份赋值
var a = document.getElementsByClassName("id1-1") ;
for(b = 0 ; b <result1.length;b++){
    if(result1[b] =="杀手"){
        a[b].innerHTML ="杀手" ;
    }else{
        a[b].innerHTML ="平民" ;
    }
}

function clear1() {
    sessionStorage.removeItem("对象组") ;
    sessionStorage.removeItem("随机组") ;
    sessionStorage.removeItem("杀手组") ;
    sessionStorage.removeItem("平民组") ;
    sessionStorage.removeItem("civilian") ;
    sessionStorage.removeItem("condition") ;
    sessionStorage.removeItem("step") ;
    sessionStorage.removeItem("kill_rell") ;
    sessionStorage.removeItem("w");
    sessionStorage.removeItem("u") ;
    sessionStorage.removeItem("p") ;
    sessionStorage.removeItem("rrrsul");
    sessionStorage.removeItem("be_killed") ;
    location.href="../1_index.html" ;
}
// document.getElementsByClassName("button1-2")[0].addEventListener("click", function () {
//
// })


function start() {
    location.href = "../html/6_天黑请闭眼页面.html" ;
}