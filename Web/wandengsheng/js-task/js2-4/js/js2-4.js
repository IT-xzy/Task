var a =sessionStorage.getItem("id");
var man = document.getElementById("mans");

var id = a.split(",");
console.log(id)

var time = 1 ;
sessionStorage.setItem("time",time);

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



$("p").click(function () {
    $("p").css("background-color","#f5c97b");
    $(".playText").css("background-color","#83b09a");  
    $(this).css("background-color","yellow");   
})

$("p:contains('杀手')").click(function () {
    alert("我是杀手，杀错人了")
    $("p").css("background-color","#f5c97b");
    $(".playText").css("background-color","#83b09a");
    
})

var playerState = [];
for (let i = 0; i < id.length; i++) {
    playerState[i] = {
        identity: id[i],
        num: i + 1,
        state: "live",
        way: "",
        how:"",
        day : ""

    };

};
console.log(playerState)


$(".start").click(function () {
    $(this).css("background-color","yellow");
    // sessionStorage.setItem("people",id);
    var ar = sessionStorage.setItem("ayerState",JSON.stringify(playerState));
    console.log(ar);
    
    
    window.location.href = "js2-5.html";
});
//重新游戏
$(".right").click(function () {
    confirm("确定要退出本局游戏么？") ? location.href = "js2-1.html" : x;
    // var qd = confirm("确定要退出本局游戏么？")
    // if (qd = true) {
    //     location.href = "js2-1.html"
    // }else{
    //     location.href != "js2-1.html"
        
    // }

});


