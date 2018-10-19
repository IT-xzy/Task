<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>task10</title>
  <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="/css/Untitled-3.css" rel="stylesheet" type="text/css">
  <link href="/css/Untitled-1base.css" rel="stylesheet" type="text/css">
  <script src="/js/jquery.min.js"></script>
  <script  src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container  hidden-xs">
  <div class="row header-top">
    <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
      <div>
        <a href="#" target="_blank"> <img alt=""  src="/images/54537.png"></a>
        <a href="#" target="_blank"><img alt=""  src="/images/45678678.png"></a>
        <a href="#" target="_blank"> <img alt=""  src="/images/54375483543.png"></a>
      </div>
    </div>
  </div>
</div>
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <a href="#" class="navbar-brand">
        <img src="/images/logo.png" alt="Brand" class="img-responsive">
      </a>
      <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
      <ul class="nav navbar-nav navbar-right text-center list-inline">
        <li><a href="/test">首页</a></li>
        <li><a href="/u/t11">职业</a></li>
        <#if username??>
          <li><a href="#">${username}</a></li>
          <li><a href="/logout">注销</a></li>
        <#else>
          <li><a href="/login">登录</a></li>
          <li><a href="/register">注册</a></li>
        </#if>
      </ul>
    </div>

  </div>
</nav>