 // 正常弹窗函数
 function popupwindow(text) {
    let headlink = document.getElementsByClassName("headlink")[0];
    let p = headlink.getElementsByTagName("p")[0];
    p.innerHTML = text;
   // console.log(1);
    // 弹出弹框
    popup("flex")

}
var button = document.getElementsByClassName("headlink")[0].getElementsByTagName("button")[0];
//console.log(button);
button.onclick = function () {
    popup("none");
}
// 弹出弹框
function popup(flex) {
    let popupStyle = document.getElementsByClassName("popup-style")[0];
    popupStyle.style.display = flex;
}

//女巫弹窗
var witchwindow=document.getElementsByClassName("witch-popup")[0]
function witchPopup(stateNumber){
witchwindow.getElementsByTagName("p")[0].innerHTML=stateNumber+"号被杀";
witchwindow.style.display="flex";
}
var witchclose=witchwindow.getElementsByTagName("button")[1];
witchclose.addEventListener("click",function(){
    witchwindow.style.display="none";
})
