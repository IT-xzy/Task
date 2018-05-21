"use strict"
//ready()简写
$(function() {
//判断胜利一方并显示
	var $win = window.sessionStorage.getItem('win');
	switch ($win) {
		case '1': $("#result").text("杀手胜利");
		break;
		case '0': $("#result").text("平民胜利");
		break;
	}

//显示剩余人数
	var $kilCount = window.sessionStorage.getItem('kilcount');
	var $civCount = window.sessionStorage.getItem('civcount');
	$("#killer").text("杀手" + $kilCount + "人");
	$("#civilian").text("平民" + $civCount + "人");

//显示历史记录
	var $history = JSON.parse(window.sessionStorage.getItem('history'));
	$($history).each(function() {
		let $index = $($history).index($(this));
		let $days = $index + 1;
		if (this != null && $index != 0 && this.history2 != null) {
			let $cloneHistory = $(".history").eq(0).clone();
			$("main").append($cloneHistory);
			$(".days").eq($index).text("第" + $days + "天");
			$(".night").eq($index).text("黑夜：" + this.history1);
			$(".daytime").eq($index).text("白天：" + this.history2);
		}
		else if (this.history2 == null) {
			let $cloneHistory = $(".history").eq(0).clone();
			if ($index != 0) {
				$("main").append($cloneHistory);
			}
			$(".days").eq($index).text("第" + $days + "天");
			$(".night").eq($index).text("黑夜：" + this.history1);
			$(".daytime").eq($index).text("");
		}
		else {
			$(".days").eq($index).text("第" + $days + "天");
			$(".night").eq($index).text("黑夜：" + this.history1);
			$(".daytime").eq($index).text("白天：" + this.history2);
		}
	});

	//清空sessiongStorage
	function clear() {
		window.sessionStorage.clear();
	}

	//home键
	$("#home").click(function() {
		clear();
		window.location.href = "./home.html";
	});
	$("#again").click(function() {
		clear();
		window.location.href = "./parameter.html";
	});
});