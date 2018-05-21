"use strict"

$(document).ready(function() {
//从obj中取得储存数据(已打乱数组)
	var $order = JSON.parse(window.sessionStorage.getItem('obj'));
	//console.log($order);

//监听返回按钮
	$("#back").click(function() {
		window.location.href = "./parameter.html";
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

//设定点击计数变量
	var $count = 1;

//设置默认显示
	var $num = Math.floor($count / 2 + 1);
	$("#title").text("查看" + $num + "号身份");
	switch ($order[$num - 1]) {
		case 0: $("indentity").text("角色：平民");
		break;
		case 1: $("indentity").text("角色：杀手");
		break;
	}
	$("#number").css("transform", "rotateY(0)");
	$("#number").text($num);

//根据随机分配设定翻牌内容
	$("#check").click(function() {
		var $num = Math.floor($count / 2 + 1) + 1;
		if ($count % 2 == 1) {
			$("#card").css("transform", "rotateY(180deg)");
			$("#cover").addClass("hidden");
			$("#backCover").removeClass("hidden");
			$("#indentity").removeClass("hidden");
			$("#phrase").removeClass("hidden");
			$("#hint").removeClass("hidden");
			$("#check").text("点击并传给" + $num + "号");
			$("#number").css("transform", "rotateY(180deg)");
			$count++;
			if (($num - 1) == $order.length) {
				$("#check").text("法官查看");
				$("#check").click(function() {
					window.location.href = "./journal.html";
				});
			}
		}
		else {
			var $num = Math.floor($count / 2 + 1);
			$("#card").css("transform", "rotateY(0)");
			$("#cover").removeClass("hidden");
			$("#backCover").addClass("hidden");
			$("#indentity").addClass("hidden");
			$("#phrase").addClass("hidden");
			$("#hint").addClass("hidden");
			$("#check").text("查看身份");
			setTimeout(function() {
				$("#title").text("查看" + $num + "号身份");
				$("#number").text($num);
			}, 250);
			switch ($order[$num - 1]) {
				case 0: setTimeout(function() {
					$("#indentity").text("角色：平民")
				}, 500);
				break;
				case 1: setTimeout(function() {
					$("#indentity").text("角色：杀手")
				}, 500);
				break;
			}
			$("#number").css("transform", "rotateY(0)");
			$count++;
		}
	});
});