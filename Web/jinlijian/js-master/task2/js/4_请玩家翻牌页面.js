//var data1 = JSON.parse(sessionStorage.getItem('key'));
// var data2 = JSON.parse(localStorage.getItem('key'));
// console.log("杀手组" + "=" + killer) ;
var randum_arr =JSON.parse(sessionStorage.getItem('随机组')) ;
console.log(randum_arr) ;

var x =document.getElementById("rever") ;
var y =document.getElementById("front") ;
var z =document.getElementById("id") ;
var a =document.getElementById("people") ;
var b =document.getElementById("btn1") ;
var c =document.getElementById("btn2") ;
var d =document.getElementById("circle") ;
var e =document.getElementById("k") ;
var f =document.getElementById("f") ;
var g =document.getElementById("g") ;
var i = 0 ;
var k = 1 ;
function cheak() {
        d.innerHTML = i+1 ;
        x.style.display="none" ;
        y.style.display="block" ;
        a.style.display="block" ;
        z.innerHTML =randum_arr[i] ;
        i++ ;
        b.style.display="none" ;
        c.style.display="block" ;
        console.log( "i" + "=" + i) ;

    if(i == randum_arr.length){
        b.style.display="none" ;
        c.style.display="none" ;
        g.style.display="block";
    }
}
function turn() {
        d.innerHTML = k+1 ;
        x.style.display="block" ;
        y.style.display="none" ;
        a.style.display="none" ;
        b.style.display="block" ;
        c.style.display="none" ;
        e.innerHTML= k+2 ;
        console.log( "k" + "=" + k) ;
        k++ ;
        f.innerHTML=i+1 ;
}
function local_to() {
    location.href="../html/5_法官日志.html" ;
}