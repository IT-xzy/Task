"use strict";

$(document).ready(function() {
//返回建
	$("#back").click(function() {
		window.location.href = "./flip.html";
	});

//清空sessionStorage
	function clear() {
		window.sessionStorage.clear();
	}

//关闭按钮
	function closewin(){
	    if (navigator.userAgent.indexOf("Firefox") != -1 || navigator.userAgent.indexOf("Chrome") !=-1) {
	        window.location.href="about:blank";
	        window.close(); 
	    } else {
	        window.opener = null;
	        window.open("", "_self");
	        window.close();
	    }
	}
	$("#close").on("click", function() {
		if (confirm("确认关闭？")) {
			closewin();
			clear();
		}
	});

//创建刷新页面函数
	function $addTag(text1, text2) {
		return $('<div class="block"><p class="name">' + text1 + '</p><p class="number">' + text2 + "号" + '</p></div>');
	}

//判断死活并显示
	var $killed = JSON.parse(window.sessionStorage.getItem('status'));
	//console.log($killed);
	//非第一次
	if($killed != null) {
		for (let $x in $killed) {
			//刷新页面，根据人数刷新块
			let $num = parseInt($x) + 1;
			$("main").append($addTag($killed[$x].role, $num));
			//判断死活，显隐相应的块
			if($killed[$x].state == "dead") {
				$(".block").eq($x).addClass("death");
			}
		}
		//将结果对象存在status里
		window.sessionStorage.setItem('status', JSON.stringify($killed));
	}
	//第一次
	else {
		//获取打乱的数组obj
		var $order = JSON.parse(window.sessionStorage.getItem('obj'));
		//console.log($order);

		//创建一个对象制造器，用于转化数组
		function $player(a, b) {
			this.role = a;
			this.state = b;
		}

		//将数组转化为对象
		for (let $x in $order) {
			//创建对象
			if ($order[$x] == 0) {
				$order[$x] = new $player("平民", "alive");
			}
			else if ($order[$x] == 1) {
				$order[$x] = new $player("杀手", "alive");
			}
			//刷新页面，根据人数刷新块
			let $num = parseInt($x) + 1;
			$("main").append($addTag($order[$x].role, $num));
		}
		//console.log($order);
		//将转化后的对象存在status里
		window.sessionStorage.setItem('status', JSON.stringify($order));
	}

//开始游戏键
	var $x = window.sessionStorage.getItem('flag');
	if ($x == 1) {
		$("#start").text("返回");
		$("#start").click(function() {
			window.sessionStorage.removeItem('flag');
			window.history.back();
		});
	}
	else {
		$("#start").click(function() {
			window.location.href = "./book.html";
		});
	}
});	