//从sessionStorage中获取数据
all=JSON.parse(sessionStorage.getItem("all"));
console.log(all);

//渲染出标签
for (var i = 0; i < all.length; i++){
	var player='<div class="player"><div class="people"><div class="vocation"></div><div class="number"></div></div><div class="hover"><img src="img/knife.png"></div></div>'
	$(".main").prepend(player);
}
//给盒子加上对应玩家身份
for(var i=0;i<all.length;i++){
	$(".number").eq(i).text(i+1);
	if (all[i]==1){
		$(".vocation").eq(i).text("杀手");
	} 
	else{
		$(".vocation").eq(i).text("平民");
	}
}
//点击按钮功能
$(".footer").click(function(){
	location.href="game.html";
})
// 对死者渲染样式
died=JSON.parse(sessionStorage.getItem("died"));
if(died!=null){
	$(".footer span").text("返回"); //设置bottom按钮内容显示
	$(".header img").css("visibility", "hidden"); //头部标签样式改变
	for(i=0;i<died.length;i++){
		$(".people").eq(died[i]-1).css("opacity","0.5");
	};
}
//回退按钮设置
function backGame(){
	sessionStorage.clear();
	window.location.href="gameSet.html";
} 