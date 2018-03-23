"use strict"

window.onload = function() {
//后退按钮监听
	document.getElementById("back").addEventListener("click", goHome);
	function goHome() {
		window.location.href = "./home.html";
	}

//发牌按钮监听
	document.getElementById("deal").addEventListener("click", deal);
	function deal() {
		var indentity = parameter();
		if (indentity != false) {
			var randomIndentity = shuffle(indentity);
			//存储数据到obj里(数组)
			window.sessionStorage.setItem('obj', JSON.stringify(randomIndentity));
			window.sessionStorage.removeItem('status');
			window.location.href = "./flip.html";
		}
	}

//1.检测是否为4-18的数字
	function check() {
		var num = document.getElementById("playerNum").value;
		var reg = /^\d+$/;
		if (reg.test(num)) {
			if (num <= 18 && num >= 4) {
				return num;
			}
			else {
				alert("请输入4-18之间的数字");
				return false;
			}
		}
		else {
			alert("请输入数字");
			return false;
		}
	}

//2.根据输入的人数分配职业，并保存在数组中
//输入框监听
	document.getElementById("playerNum").addEventListener("change", parameter);
	function parameter() {
		var player = check();
		var indentity = new Array();
		var kilNum = Math.floor(player / 4);//用1代表杀手
		var civNum = player - kilNum;//用0代表平民
		if (player != false) {
			for (var i = 0; i < kilNum; i++) {
				indentity.push(1);
			}
			for (var i = 0; i < civNum; i++) {
				indentity.push(0);
			}
			document.getElementById("slider").value = document.getElementById("playerNum").value;
			return indentity;
		}
		else {
			return false;
		}
	}

//设置按钮监听
	document.getElementById("setting").addEventListener("click", function() {
		var player = check();
		var indentity = new Array();
		var kilNum = Math.floor(player / 4);//用1代表杀手
		var civNum = player - kilNum;//用0代表平民
		document.getElementById("killerNum").innerHTML = "杀手" + kilNum + "人";
		document.getElementById("civilianNum").innerHTML = "平民" + civNum + "人";
	});

//滑块监听
	function change() {
			var val = document.getElementById("slider").value;
			document.getElementById("playerNum").value = val;
	}
	document.getElementById("slider").addEventListener("change", change);
//减号监听
	document.getElementById("miner").addEventListener("click", function() {
		var player = document.getElementById("slider");
		if (player.value >= 5) {
			player.value--;
			change();
		}
	});
//加号监听
	document.getElementById("plus").addEventListener("click", function() {
		var player = document.getElementById("slider");
		if (player.value <= 17) {
			player.value++;
			change();
		}
	});
	
//3.打乱数组Fisher-Yates Shuffle
	function shuffle(array) {
		var _array = array.concat();
		for (var i = _array.length - 1; i > 0; i--) {
			var j = Math.floor(Math.random() * (i + 1));
			var temp = _array[i];
			_array[i] = _array[j];
			_array[j] = temp;
		}
		return _array;
	}
}