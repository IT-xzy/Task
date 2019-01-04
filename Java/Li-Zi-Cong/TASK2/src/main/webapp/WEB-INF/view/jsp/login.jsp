<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web</title>
<script> 
 
function openwin() { 
window.open (page.html, newwindow, height=100, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no) 

 } 
 
</script>
</head>
<body style="background-image:url('/images/mn.jpg');background-size:cover;" onload="openwin()">

		<!--<div hidden="true">-->
			<embed src="music/456.mp3" loop="true" hidden="true">
        <!--</div>&lt;!&ndash; 背景音乐(隐藏) embed标签内除了src其它都用不了&ndash;&gt;-->
		<!-- 有些浏览器不支持embed内的hidden,所以加多一次div的hidden -->
		
		
		<form action="/checkLogin" method="post" style="text-align: center;" >
			<div style="padding-top: 15%"> 
				<h1 style="color:white;">
				
					Account&nbsp;&nbsp;&nbsp;<input type="text" name="loginname" style="width:130px;height:30px 
					;padding-right: 90px;background-color:silver;"/><br/>
					
					Password&nbsp;<input type="password" name="password" style="width:120px;height:30px 
					;padding-right: 100px;background-color:silver;"/><br/><br/>
					
					<input type="submit" value="Sign In"style="width:200px;height:40px ;color: gray;font-size: 25px"/>
				</h1>
			</div>		
		</form>
	
</body>
</html>