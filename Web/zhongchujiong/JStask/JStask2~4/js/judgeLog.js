var playerBox=JSON.parse(sessionStorage.playerBox);      //玩家数组
//跳转到游戏步骤
$(".goToNext").on("click",function () {
  window.location.href="gameStep.html";
});
//跳转到首页
function goToIndex() {
  sessionStorage.clear();
  window.location.href = "index.html";
}
//将玩家渲染到页面
for(var i=0;i<=playerBox.length-1;i++){
  document.getElementsByClassName("number")[i].style.display="flex";
  document.getElementsByClassName("numberTop")[i].innerHTML=playerBox[i].identity;
  document.getElementsByClassName("numberBtm")[i].innerHTML=i+1+"号";
}
//将前面死过的人变色
playerBox.forEach(function (item,index) {
  if(item.live==0){
    $(".numberTop").eq(index).css("background","red");
  }
});
