// var input = document.getElementsByClassName("input");
// var footer = document.getElementsByTagName("footer")[0];
// var warm = document.getElementsByClassName("warm")[0];

// var x;
// var y;
// var res;
// input[0].oninput = function () {
// 	x = input[0].value;
// }
// input[1].oninput = function () {
// 	y = input[1].value;
// }


// // if(input[0].onload){
// // 	input[0].innerHTML="";
// // }
// // if(input[1].onload){
// // 	input[1].innerHTML="";
// // }
// input[0].onclick=function(){
// 	input[0].placeholder="";
// 	console.log(11)
// }
// input[1].onclick=function(){
// 	input[1].placeholder="";
// }




// footer.onclick = function () {
// 	var xmlhttp;
// 	var data = "name=" + x + "&pwd=" + y;
// 	console.log(data)
// 	if (window.XMLHttpRequest) {
// 		xmlhttp = new XMLHttpRequest();
// 	}

// 	xmlhttp.onreadystatechange = function () {
// 		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

// 			console.log(xmlhttp.responseText); //可以console出来，不能在打印台打印
// 			res = JSON.parse(xmlhttp.responseText); //json转换，这里的括号内不需要加单引号
// 			if (res.code == -5003) {
// 				warm.innerHTML = "用户不存在";
// 				return;
// 			}
// 			if (res.code == -5004) {
// 				warm.innerHTML = "密码错误";
// 				return;
// 			}
// 			if (res.code == 0) {
// 				location.href = "http://dev.admin.carrots.ptteng.com/"
// 			}
// 		}

// 	}
	 
// 	xmlhttp.open("POST", "/carrots-admin-ajax/a/login", true);
// 	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
// 	xmlhttp.send(data);
// }


var user;
var psw;
$('input').blur(function(){//blur：失去焦点
	user=$('input').eq(0).val();
	psw=$('input').eq(1).val();
	console.log(user)
	console.log(psw)
})
$('input').bind('input propertychange',function(){//bind：获取焦点
	$('.warm').text("");
})

$('footer').click(function(){
	let datum={
		name:user,
		pwd:psw
	};
	console.log(datum);
})
	
if(user==undefined||user==""||psw==undefined||psw==""){
	$('.warm').text("请输入账号密码");
}else if(user!=undefined&&psw!=undefined){
	$.post('/carrots-admin-ajax/a/login',datum,function(data){
		let arr=[];

		if(arr.code=="-5003"){
			$('.warm').text(arr.message);
		}
		else if(arr.code=="-5004"){
			$('.warm').text(arr.message);
		}else if(arr.code=="0"){
			$('.warm').text("登陆成功");
			location.href = "http://dev.admin.carrots.ptteng.com/";
		}
	})
}

















// $('footer').click(function(){
//     var xmlhttp;
//     if (window.XMLHttpRequest){
//         xmlhttp=new XMLHttpRequest();
//     }

//     xmlhttp.onreadystatechange=function()
// 	{
// 		if (xmlhttp.readyState==4 && xmlhttp.status==200)
// 		{
// 			document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
// 		}
// 	}
// 	xmlhttp.open("POST","/carrots-admin-ajax/",true);
// 	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//     xmlhttp.send();



// })