"use strict"

//jquery
$(document).ready(function() {
//获取用户输入
	$("#login").on("click", function() {
		"use strict"
		let $username = $("#username").val();
		let $password = $("#password").val();

		$.post('/carrots-admin-ajax/a/login', {name: $username, pwd: $password}, function(data, textStatus, xhr) {
			var $data = JSON.parse(data);
			if ($data.message == "success") {
				window.location.href = "http://dev.admin.carrots.ptteng.com/";
			}
			else {
				$("#info").text($data.message);
			}
		});
	});
});


/*
//原生js
window.onload = function() {
//获取用户输入，监听登录按钮
	document.getElementById("login").addEventListener("click", function() {
		var userName = document.getElementById("username").value;
		var passWord = document.getElementById("password").value;

		var formData = new FormData();
		formData.append('name', userName);
		formData.append('pwd', passWord);

//创建XHR对象
		function createXHR() {
			//对IE7及其更高版本
			if (window.XMLHttpRequest) {
				return new XMLHttpRequest();
			}
			//以下为对IE7之前版本兼容
			else {
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		var xhr = createXHR();

//onreadystatechange事件处理程序
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var text = JSON.parse(xhr.responseText);
					if (text.message == "success") {
						console.log("success");
						window.location.href = "http://dev.admin.carrots.ptteng.com/";
					}
					else {
						document.getElementById("info").innerHTML = text.message;
					}
				}
				else {
					console.error("error" + xhr.status);
				}
			}
		}
		xhr.open("post", "/carrots-admin-ajax/a/login", true);
		xhr.send(formData);
	});
}
*/