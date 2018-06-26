console.log(14324);


// var lod = document.getElementById("logn");
// var user = document.getElementById("zhanghao")
// var password =document.getElementById("mima")

// lod.onclick = function fat() {
//     var uservalue = user.value;
//     var passwordvalue = password.value;
//     var xmlhttp;
// 	if (window.XMLHttpRequest)
// 	{

// 		xmlhttp=new XMLHttpRequest();
// 	}
// 	else
// 	{

// 		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
// 	}
// 	xmlhttp.onreadystatechange=function()
// 	{
// 		if (xmlhttp.readyState==4 && xmlhttp.status==200)
// 		{
// 			document.getElementById("zhanghao").innerHTML=xmlhttp.responseText;
// 		}
// 	}
// 	xmlhttp.open("GET","carrots-admin-ajax/a/login",true);
// 	xmlhttp.send();

// }
// //js 发送请求
// var lod = document.getElementById("logn");
// var user = document.getElementById("zhanghao");
// var password = document.getElementById("mima");



// lod.onclick = function login() {
// 	function isStudentNo(str) {
// 		var reg = /^[0-7]{6}$/; /*定义验证表达式*/
// 		return reg.test(str); /*进行验证*/
// 	}
// 	function ischina(str) {
// 		var reg=/^[\u4E00-\u9FA5]{2,4}$/;   /*定义验证表达式*/
// 		return reg.test(str);     /*进行验证*/
// 	}



// 	function fun1() {
// 		if (ischina(document.getElementById("zhanghao").value)) {
// 			// alert("账号");
// 			document.getElementsByTagName("p")[0].innerHTML = "账号不能为中文";
// 			document.getElementById("zhanghao").focus();
// 			return false;
// 		}
// 		if (!isStudentNo(document.getElementById("mima").value)) {
// 			// alert("密码是6位数字");
// 			document.getElementsByTagName("p")[0].innerHTML = "密码是6位数字";
// 			document.getElementById("mima").focus();
// 			return false;
// 		}
		

// 		alert("提交成功")
// 		return true;


// 	}
// 	var random = fun1();
// 	console.log(random);
// 	if (random == true) {
// 		console.log(user.value);
// 		console.log(password.value);
// 		var xmlhttp = new XMLHttpRequest();


// 		xmlhttp.onreadystatechange = function () {
// 			if (xmlhttp.readyState === 4) {
// 				if (xmlhttp.status === 200) {
// 					var jsons = JSON.parse(xmlhttp.responseText);
// 					console.log(jsons);
// 					if (jsons.code === 0) {
// 						// window.location.href = "http://dev.admin.carrots.ptteng.com/#/dashboard"
// 					} else {
// 						document.getElementsByTagName("p")[0].innerHTML = "账号或密码错误";

// 					}
// 				}
// 			}
// 		};

// 		xmlhttp.open("Post", "/carrots-admin-ajax/a/login", true);
// 		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
// 		xmlhttp.send("name=" + user.value + "&pwd=" + password.value);

// 	}




// }



//jquery 发送请求
var tips = document.getElementById("tex")

$("button").click(function () {


	$.ajax({
		url: '/carrots-admin-ajax/a/login',

		type: 'post',
		dataType: 'json',
		data: {
			name: $("#zhanghao").val(),
			pwd: $("#mima").val(),
		},
		success: function (data) {
			console.log(data);
			if (data.code == '0') {
				location.href = 'https://blog.csdn.net/abvedu/article/details/54754645';


			} else if (data.code == '-5003') {
				// alert("此用户不存在")
				$("p").html ('此用户不存在');
				// $("#tex").append ('此用户不存在');


			} else if (data.code == '-5004') {
				$("p").html ('密码错误');
				
			}
		},


	})

});

$("button").click(function name(params) {
	$("p").text("dasdasda")
})