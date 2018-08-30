<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<head>--%>
	<%--<meta charset="UTF-8">--%>
	<%--<meta name="viewport", content="device-width,initial-scale=1.0, manimun-scale=1.0,user-scaleble=no" />--%>
	<%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
	<%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
	<%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
	<%--<title>task8</title>--%>
	<%--<link rel="stylesheet" type="text/css" href="js/style.css" />--%>
<%--</head>--%>


	<div class="container head-t">
		<div class="row">
			<div class="col-sm-4 ht-left hidden-xs">
				客服热线：010-8888-8888
			</div>
			<div class=" ht-entry">
				<a style="color: crimson" href="${pageContext.request.contextPath}/${status[2]}">${status[0]}</a>
				<span>|</span>
				<a style="color: crimson" href="${pageContext.request.contextPath}/${status[3]}">${status[1]}</a>
				${message}
			</div>
			<div class="col-sm-4 ht-right hidden-xs">
				<%--登录--%>
				<%--退出--%>
				<img src="${pageContext.request.contextPath}/img/首页/h-tr1.png" />
				<img src="${pageContext.request.contextPath}/img/首页/h-tr2.png" />
				<img src="${pageContext.request.contextPath}/img/首页/h-tr3.png" />
			</div>

		</div>
	</div>
	<div class="head-b">
		<div class="container">
			<div class="row hbin">
				<%--<a href="../html/task8.html">--%>
					<img src="${pageContext.request.contextPath}/img/企业/ptt.png" class="i-ptt"/>
				</a>
				<nav class="navbar navbar-default" role="navigation">
					<div class="container-fluid" >
						<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
								data-target="#example-navbar-collapse">
							<span class="sr-only">切换导航</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						</div>
						<div class="collapse navbar-collapse" id="example-navbar-collapse"
							 >
							<ul class="nav navbar-nav  navbar-right">
								<li class="text-center"><a class="hta" href="${pageContext.request.contextPath}/home">首页</a></li>
								<li class="text-center"><a class="hta" href="${pageContext.request.contextPath}/company">合作企业</a></li>
								<li class="text-center"><a class="hta" href="${pageContext.request.contextPath}/u/job">职业推荐</a></li>
								<%--<li class="text-center"><a class="hta" href="${pageContext.request.contextPath}/login">账户相关</a></li>--%>
								<%--<li class="text-center"><a class="hta" href="#">关于</a></li>--%>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>


