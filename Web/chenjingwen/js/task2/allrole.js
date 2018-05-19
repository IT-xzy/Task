//提取sessionStorage中储蓄的order()和role()数组。

objorder=JSON.parse(sessionStorage.objorder);
objrole=JSON.parse(sessionStorage.objrole);
console.log(objorder);
console.log(objrole);
//给指定标签创建子标签
for(i=0;i<objrole.length;i++){
    var  parent=document.getElementById("squares");
    var  div=document.createElement("div");
    parent.appendChild(div);
    div.className="square";
    var parentDiv=document.getElementsByClassName("square");
    var  upper=document.createElement("div");
    var  lower=document.createElement("div");
    parentDiv[i].appendChild(upper);
    parentDiv[i].appendChild(lower);
    upper.className="upper";
    lower.className="lower"; 
    document.getElementsByClassName("upper")[i].innerHTML=objrole[i];
    document.getElementsByClassName("lower")[i].innerHTML=objorder[i]+"号";
}
//点击事件函数，跳转到下一页面，开始游戏
function jumurl(){
    window.location.href="diary.html";
}