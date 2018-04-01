var step  ;
var a =document.getElementsByClassName("process") ;
console.log(step) ;
var be_killed  =  JSON.parse(sessionStorage.getItem("be_killed")) ;

console.log(be_killed) ;
if(be_killed != undefined){
    if( be_killed.length%2 != 0 ){
        a[0].style.cssText="background-color:rgb(105,105,105)" ;
        step = 1 ;
    }
}
var c =  getComputedStyle(a[0]).backgroundColor ;
if(c  =="rgb(l05,105,105)"){
    a[0].disabled=true ;
}
function step1() {
    if(step == undefined){
        location.href = "../html/7_杀人页面.html" ;
    }else if(step === 1){
        alert("don't") ;
    }else if(step === 2){
        alert("don't") ;
    }else if(step === 3){
        alert("don't") ;
    }
}
function step2() {
    if(step == undefined){
        alert("don't") ;
    }else if(step === 1){
        step = 2
        a[1].style.cssText="background-color:rgb(105,105,105)" ;
        alert("请亡灵发言") ;
    }else if(step === 2){
        alert("don't") ;
    }else if(step === 3){
        alert("don't") ;
    }
}
function step3() {
    if(step ==undefined){
        alert("don't") ;
    }else if(step === 1){
        alert("don't") ;
    }else if(step === 2){
        step = 3 ;
        a[2].style.cssText="background-color:rgb(105,105,105)" ;
        alert("请轮流发言") ;
    }else if(step === 3){
        alert("don't") ;
    }
}
function step4() {
    if(step ==undefined){
        alert("don't") ;
    }else if(step === 1){
        alert("don't") ;
    }else if(step === 2){
        alert("don't") ;
    }else if(step === 3){
        step = 4 ;
        sessionStorage.setItem("step",step) ;
        a[3].style.cssText="background-color:rgb(105,105,105)" ;
        location.href= "../html/8_投人页面.html" ;
    }
}


a[0].onclick = function () {
    step1() ;
}
a[1].onclick = function () {
    step2() ;
}
a[2].onclick = function () {
    step3() ;
}
a[3].onclick = function () {
    step4() ;
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

