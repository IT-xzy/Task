var winOject = JSON.parse(localStorage.getItem("win")) //取回胜利的人
var outValue = JSON.parse(localStorage.getItem("outValue")) //取回人
console.log(outValue)
var dayTime = JSON.parse(localStorage.getItem("dayTime")) //取回日志
console.log(dayTime)
var cunNum=JSON.parse(localStorage.getItem("cunNum")) //取回人数
var langNum=JSON.parse(localStorage.getItem("langNum")) //取回人数
$(".win").text(winOject)
if (winOject == "村民胜利") {   //根据对象添加文字
    $(".header-main-title").text("你知道么，杀人游戏中只有20%的村民才能胜利")
} else if (winOject == "杀手胜利") {
    $(".header-main-title").text("你知道么，杀人游戏中只有20%的杀手才能胜利")
}else{
   // console.log(11)
    $(".header-main-title").text("你知道么，杀人游戏中只有20%的傻逼会结束游戏")
}
for(let i=0;i<dayTime.length-1;i++){   //循环复制节点
    let clone=$(".main").find("li")[0].cloneNode(true)
    $(".main").append($(clone))
}
for(let i=0;i<dayTime.length;i++){  //循环填入数据
   sha(i)
   quan(i)
}
function sha(day){
   if(dayTime[day].gurad){
       let index=dayTime[day].gurad;
     
    $(".gurad-test")[day].innerHTML=index+"号被杀死了，真是身份是"+outValue[index-1]
   }
}
function quan(day){
    if( dayTime[day].vote){
        let index=dayTime[day].vote
     $(".vote")[day].innerHTML=index+"号被投死了，真是身份是"+outValue[index-1]
    }
 }
$(".cun").text("村 民"+cunNum+"人    ")
$(".werwolf").text("杀 手"+langNum+"人     ")
$(".again").on("click",function(){   //点击再来一局
    window.location.href="peopleNumber.html"
})
$(".home").on("click",function(){
    window.location.href="1.html";
})
