// //卧底游戏拿到的卧底、平民词组
// peopleWord=JSON.parse(sessionStorage.getItem("peopleWord"));
// console.log(peopleWord);
// killerWord=JSON.parse(sessionStorage.getItem("killerWord"));
// console.log(killerWord);

// function(){
// 	1、写出页面（按钮内容、div中的内容通过JS获取）；
// 	2、通过按钮添加点击事件，用toggle函数写出多个函数，用每个函数写出页面对应内容；
// 	3、每个函数里改变样式的时候，关键词通过$(".wordPepole").val()和$(".wordKiller").val()获取；
// 	4、$(".show").toggle（）里function 的次数；
// 	5、序号写成i=1;i++这种形式，两张图为一对，奇数图显示相同的，偶数图身份加if判断来取；
// 	6、优化其他按键功能。
// }

// function(){
// 	1、i=鼠标点击按钮次数<(all.length)*2-1(查看每个玩家身份需要点击两次)，执行点击函数;
// 	2、i为奇数的时候显示身份，为偶数的时候显示翻牌页。
// 	3、身份序号为 Math.ceil((1/2)*i);
// 	4、角色用if判断，词组获取对应的；
// }

//header部分左右按钮的点击功能
$(".header img").eq(0).click(function(){
	sessionStorage.clear();
	location.href="gameSet.html";
});
$(".header img").eq(1).click(function(){
	sessionStorage.clear();
	location.href="index.html";
});
//从sessionStorage中获取数据
all=JSON.parse(sessionStorage.getItem("all"));
console.log(all);
//定义变量存放点击按钮次数
var i =0; 
$(".footer").click(function(){
	i=i+1;
	if(i<(all.length)*2-1){
		if(i%2==0){ //点击次数为偶数时
			$(".index").html(Math.ceil((1/2)*(i+1)));
			$(".bg").html(null);	
			$(".bg").prepend('<img src="img/hidden.png" style="width: 68%;padding-top: 16rem">');
			$(".footer span").text("查看"+Math.ceil((1/2)*(i+2))+"号身份");
		}
		else{ //点击次数为奇数时
			$(".index").html(Math.ceil((1/2)*(i+1)));
			$(".bg").html(null);
			$(".bg").prepend('<img src="img/flop.png">');
			// $(".bg img").css({"width":"50%","padding-top":"13rem"});
			if(all[Math.ceil((1/2)*i)-1]==1){
				$(".bg img").after('<div style="padding-top: 5rem; font-size: 6rem; color: #29bde0">角色：杀手</div>');
			}
			else{
				$(".bg img").after('<div style="padding-top: 5rem; font-size: 6rem; color: #29bde0">角色：平民</div>');
			}
			$(".footer span").text("隐藏并传递给"+Math.ceil((1/2)*(i+2))+"号");
		}
	}
	else if(i==(all.length)*2-1){
		$(".index").html(Math.ceil((1/2)*(i+1)));
		$(".bg").html(null);
		$(".bg").prepend('<img src="img/flop.png">');
		if(all[Math.ceil((1/2)*i)-1]==1){
			$(".bg img").after('<div style="padding-top: 5rem; font-size: 6rem; color: #29bde0">角色：杀手</div>');
		}
		else{
			$(".bg img").after('<div style="padding-top: 5rem; font-size: 6rem; color: #29bde0">角色：平民</div>');
		}
		$(".footer span").text("法官查看");
	}
	// 点击次数超过游戏玩家人数时跳转
	else{ 
		location.href="infor.html"
	}
})

