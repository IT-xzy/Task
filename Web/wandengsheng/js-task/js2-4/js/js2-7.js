var ka = 1;
console.log(ka)
//提取死人数组
var dead = JSON.parse(sessionStorage.getItem("deadArray"));
// var deadArray =dead.split(",")
console.log("deadArray")
console.log(dead)
//提所有人数组
var playerState = JSON.parse(sessionStorage.getItem("playerState"));
console.table(playerState);
//判断杀手胜利还是平民胜利
var victory = sessionStorage.getItem("victory")
console.log(victory)
if (victory == "平民胜利") {
    $(".result").text("平民胜利");

} else {
    $(".result").text("杀手胜利");

}
//获取天数
var day = sessionStorage.getItem("day")

//获取死人数组
var pfs = sessionStorage.getItem("player");
var player = pfs.split("1人");
var time = 1;
var index = 0;

player.pop();
$("#page1").show();
$(".check").show();
$(".number1").text(1);
console.log(player);

//循环天数
for (let i = 1; i < day; i++) {

    var lastnum1 = "";
    var lastid1 = "";
    var lastnum2 = "";
    var lastid2 = "";
 
    $(".foot").append(
       
        '<div class="date">' + '第<span>' + i + '</span>' + '天' +'<span class="time">'+'0小时07分</span>' + '</div>'
    )

    for (let p = 0; p < dead.length; p++) {
        if (dead[p].state == "dead" && dead[p].how == "sha" && dead[p].day == i) {
            lastnum1 = dead[p].num;
            lastid1 = dead[p].identity;

        }

    }
    for (let p = 0; p < dead.length; p++) {
        if (dead[p].state == "dead" && dead[p].how == "tou" && dead[p].day == i) {
            lastnum2 = dead[p].num;
            lastid2 = dead[p].identity;

        }

    }
    if (lastid2) {
        $(".foot").append(
            '<div class="box">' +
            '<div class="night">黑夜:&nbsp;' + lastnum1 + '号被杀手杀死，' +'真实身份是'+ lastid1 + '</div>' +
            '<div class="night">白天:&nbsp;' + lastnum2 + '号被全民投死，' + '真实身份是'+  lastid2+'</div>' +
            '</div>'
    
        )
    
        
    }else {
        $(".foot").append(
            '<div class="box">' +
            '<div class="night">黑夜:&nbsp;' + lastnum1 + '号被杀手杀死，' +'真实身份是'+ lastid1 + '</div>' +
          
            '</div>'
    
        )
    }

 
}
var civArray = playerState.filter(function (item,index,playerState) {
    if (item.identity = "平民") {
        return(item)
        
    }
    
})
console.log(civArray);
var d = day-1;
var all = playerState.length

$(".center").text("本轮游戏共"+all+"人，共经历了"+d+"天，在杀人游戏中击败了67%的玩家！")

//返回首页
$(".button1").click(function () {
    location.href = "js2-1.html"
    
})