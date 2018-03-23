//获取每页
var gamePage = document.getElementsByClassName("gamePage");
//获取游戏标题
var gameType = document.getElementById("gameType");
//获取箭头
var flipLeft = document.getElementById("flipLeft");
flipLeft.style.opacity = "0";
var flipRight = document.getElementById("flipRight");
//获取指示点
var indicatorDot = document.getElementsByClassName("indicatorDot");
//声明页数（从0开始）
var count = 3;
//声明标题数组
var title = ["游戏4", "游戏3", "游戏2", "游戏1"];


//左箭头轮播函数
function toLeft() {
	if (count < 3) {
		gamePage[count + 1].style.transform = "translateX(0)";
		gamePage[count + 1].style.opacity = "1";
		gameType.innerHTML = title[count + 1];
		count++;
		indicatorDot[3 - count].classList.add("active");
		indicatorDot[4 - count].classList.remove("active");
		if (count == 3) {
			flipLeft.style.opacity = "0";
		}
		else {
			flipRight.style.opacity = "1";
		}
	}
	return count;
}
//右箭头轮播函数
function toRight() {
	if (count > 0) {
		gamePage[count].style.transform = "translateX(-100%)";
		gamePage[count].style.opacity = "0";
		gameType.innerHTML = title[count - 1];
		count--;
		indicatorDot[3 - count].classList.add("active");
		indicatorDot[2 - count].classList.remove("active");
		if (count == 0) {
			flipRight.style.opacity = "0";
		}
		else {
			flipLeft.style.opacity = "1";
		}
	}
	return count;
}

//indicator指示点
for (var j = 0; j < indicatorDot.length; j++) {
	indicatorDot[j].index = j;
	indicatorDot[j].onmouseover = function() {
		for (var a = 0; a < indicatorDot.length; a++) {
		indicatorDot[a].classList.remove("active");			
		}
		indicatorDot[this.index].classList.add("active");
		count = 3 - this.index;
		gameType.innerHTML = title[count];
		for (var c = 0; c <= 3; c++) {
			gamePage[c].style.transform = "translateX(0)";
			gamePage[c].style.opacity = "1";
		}
		for (var b = 3; b > count; b--) {
			gamePage[b].style.transform = "translateX(-100%)";
			gamePage[b].style.opacity = "0";
		}
		if (count == 0) {
			flipRight.style.opacity = "0";
			flipLeft.style.opacity = "1";
		}
		else if (count == 3) {
			flipLeft.style.opacity = "0";
			flipRight.style.opacity = "1";
		}
		else {
			flipLeft.style.opacity = "1";
			flipRight.style.opacity = "1";
		}
	}
}