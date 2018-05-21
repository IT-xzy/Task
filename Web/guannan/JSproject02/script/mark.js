"use strict";

$(document).ready(function() {
//获取状态对象status
	var $fromJournal = JSON.parse(window.sessionStorage.getItem('status'));
	//console.log($fromJournal);

//创建刷新页面函数
	function $addTag(text1, text2) {
		return $('<button class="block" type="button"><p class="name">' + text1 + '</p><p class="number">' + text2 + "号" + '</p></button>');
	}

//使用status将页面刷新
	for (let $x in $fromJournal) {
		//刷新页面，根据人数刷新块
		let $num = parseInt($x) + 1;
		$("main").append($addTag($fromJournal[$x].role, $num));
		//判断死活，显隐相应的块
		if($fromJournal[$x].state == "dead") {
			$(".block").eq($x).addClass("death");
			$(".block").eq($x).addClass("deadBody");
		}
	}

//获取点击处索引，改变其显示样式
	$(".block").click(function() {
		let $stageCheck = window.sessionStorage.getItem('stages');
		//console.log("阶段" + $stageCheck);

		let $index = $(".block").index(this);

		if ($fromJournal[$index].role == "杀手" && $stageCheck == "1") {
			alert("杀手不能杀自己人!");
			window.sessionStorage.removeItem('isfocus');
		}
		else {
			//存储数据用于判断是否有点击
			window.sessionStorage.setItem('isfocus', 'true');

			//存储点击处索引
			window.sessionStorage.setItem('index', $index);

			$(this).addClass("death");
		}
		$(".block").each(function() {
			if ($(this).is(".deadBody") == false && $(this).is(":focus") == false) {
				$(this).removeClass("death");
			}
			else if ($(this).is(".deadBody") == true) {
				$(this).blur();
			}
		});
	})

//判断存活人数，计算存活人中角色比例，若杀手为0，或者杀手人数大于等于平民人数，则游戏结束
//点击确认存储当前状态
	$("#confirm").click(function() {
		//检测是否有选择，有则跳转，无则提示
		let $isFocus = window.sessionStorage.getItem('isfocus');
		if ($isFocus) {
			//清除用于选择检测的isfocus
			window.sessionStorage.removeItem('isfocus');

			//修改focus处对应index的state属性值
			let $index = window.sessionStorage.getItem('index');
			$fromJournal[$index].state = "dead";

			//当前状态存储在status里
			window.sessionStorage.setItem('status', JSON.stringify($fromJournal));

			let $num = parseInt($index) + 1;
			let $status = JSON.parse(window.sessionStorage.getItem('status'));
			let $dayCheck = window.sessionStorage.getItem('days');
			let $check = window.sessionStorage.getItem('stages');

			//新建数组用于存储历史记录
			var $arr = new Array();

			if ($dayCheck == null) {
				$dayCheck = 0;
			}
			var $history = JSON.parse(window.sessionStorage.getItem('history'));
			if ($check == 1) {
				if ($history != null) {
					$history[$dayCheck] = new Object();
					$history[$dayCheck].history1 = $num + "号被杀手杀死，真实身份是" + $status[$index].role;
				}
				else {
					$arr[$dayCheck] = new Object();
					$arr[$dayCheck].history1 = $num + "号被杀手杀死，真实身份是" + $status[$index].role;
				}
			}
			else if ($check == 4) {
				$history[$dayCheck - 1].history2 = $num + "号被大家投死，真实身份是" + $status[$index].role;
			}

			//储存阶段标记
			if ($check == "0" || $check == "1") {
				window.sessionStorage.setItem('stages', "1");
			}
			else if ($check == "4") {
				window.sessionStorage.setItem('stages', "0");
			}
			else {
				window.sessionStorage.setItem('stages', "4");
			}

			//声明杀手、平民人数，并清零
			let $kilCount = 0;
			let $civCount = 0;
			for (let $x = 0; $x < $fromJournal.length; $x++) {
				if ($fromJournal[$x].role == "杀手" && $fromJournal[$x].state == "alive") {
					$kilCount++;
				}
				else if ($fromJournal[$x].role == "平民" && $fromJournal[$x].state == "alive") {
					$civCount++;
				}
			}
			if ($kilCount >= $civCount || $kilCount == 0) {
				window.sessionStorage.setItem('kilcount', $kilCount);
				window.sessionStorage.setItem('civcount', $civCount);
				window.sessionStorage.setItem('history', JSON.stringify($history));
				if ($kilCount >= $civCount) {
					window.sessionStorage.setItem('win', 1);
				}
				else {
					window.sessionStorage.setItem('win', 0);
				}
				//console.log($history);
				window.location.href = "./result.html";
			}
			else {
				if ($history == null) {
					window.sessionStorage.setItem('history', JSON.stringify($arr));
				}
				else {
					window.sessionStorage.setItem('history', JSON.stringify($history));
				}
				window.location.href = "./book.html";
			}
		}
		else {
			alert("请选择一名玩家");
		}
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
});