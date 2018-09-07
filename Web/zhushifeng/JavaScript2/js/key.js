var arrow=document.getElementsByClassName("arrow")[0];
var cross=document.getElementsByClassName("cross")[0];

arrow.onclick=function(){
    window.history.go(-1);
    console.log(7848)
}
cross.onclick=function(){
    localStorage.clear();
    location.href="home.html";
}