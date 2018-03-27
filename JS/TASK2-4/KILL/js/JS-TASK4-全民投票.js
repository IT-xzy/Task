
var voteKill;//存储被投死的玩家
var die = sessionStorage.getItem("die");
die = JSON.parse(die);
var judgeBtn = die;
console.log(die);

click = JSON.parse(sessionStorage.getItem("c"));

for(var i =0;
    i < die.length;
    i++
    ) {
    $(".character").eq(die[i]*1).css("background-color","#83b09a");
    $(".character").eq(die[i]*1).parent().find("img").hide();
}

//选择并储存


// $("#vote").click(function(){
//     click = click + 1;
//     sessionStorage.setItem("c",JSON.stringify(click));
//     console.log("点击" + click + "次");
// })