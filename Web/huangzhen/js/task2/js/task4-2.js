var obj = JSON.stringify(player);
obj = sessionStorage.player;
var player = JSON.parse(obj);

for (i = 0; i < player.length; i++) {
    var sub = player[i];
    sub = (sub.substring(sub.length - 8, sub.length - 5));
    console.log(sub);
    $(".items").append('<div class="item"><p class="id"><span>' + sub + '</span></p><p class="number">' + (i + 1) + '号</p><p class="choose"><img src="./img/kill.png" alt=""></p></div>');
}

$(".item").click(function (e) {
    // 点击的盒子的索引
    var i = $(".item").index($(this));
    // 这里的item是盒子的最外层类名，如果填入id,index将不起作用，具体原因百度也不知道
    console.log(i);
    //  :eq() 选择器选取带有指定 index 值的元素。
    $(".id").eq(i).addClass("another");
})

// 确定死活状态  boolean,true 活；false 死
// var status = ture;
// 确定死活状态及身份  0 死；1 平民；2 杀手？
var status = [0, 1, 2];
$(".confirm").click(function () {
    window.location.href = "task4-1.html";
    // item[i]
})