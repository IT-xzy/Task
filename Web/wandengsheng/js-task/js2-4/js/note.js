var playerState = JSON.parse(sessionStorage.getItem("playerState"))
console.table(playerState);

//渲染所有人样式
var man = document.getElementById("mans");
var a =sessionStorage.getItem("id");
var id = a.split(",");
for (var i = 0;i < id.length;i++){
    var div = document.createElement("div");
    var text = document.createElement("p");
    var number = document.createElement("p");
    div.className = "wrap";
    text.textContent = id[i];
    number.className = "playText";
    number.textContent = (i+1)+"号";
    div.appendChild(text);
    div.appendChild(number);
    man.appendChild(div);
    
}
//渲染死人样式
for (let i = 0; i < playerState.length; i++) {
    if (playerState[i].state == "dead") {
        $(".wrap").eq(i).css("opacity","0.4");
        
    }
    
    
}
//返回
$(".start").click(function () {
    location.href = "js2-5.html"
    
})
