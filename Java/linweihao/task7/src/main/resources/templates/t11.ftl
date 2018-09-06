<#include "header.ftl">
<head>
  <link href="/css/t11.css" rel="stylesheet" type="text/css">
  <#--<link href="/css/base.css" rel="stylesheet" type="text/css">-->
  <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <style type="text/css">
    .icon-people img{
      width: 200px;
      height: 150px;
    }
  </style>
</head>
<div class="container">
  <div class="nav-title">首页&gt;职业</div>
  <div class="nav-bar">
    <span class="">方向：</span>
    <a class="nav-bar-a a-selected" href="">全部</a>
    <a class="nav-bar-a" href="">前端开发</a>
    <a class="nav-bar-a" href="">后端开发</a>
    <a class="nav-bar-a" href="">移动开发</a>
    <a class="nav-bar-a" href="">整站开发</a>
    <a class="nav-bar-a" href="">运营维护</a>
  </div>
  <div class="caption">
    <h4>前端开发方向</h4>
  </div>

  <div class="row">
  <#list JobList as Job>
    <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
      <div class="warp-border">
        <div class="clearfix">
          <div class="icon-people"><img src="${Job.pic}"></div>
          <div class="text">
            <h4 class="">${Job.type}</h4>
            <p class="text-present">${Job.descrition}</p>
          </div>
        </div>
        <div class="warp-class2">
          <div class="warp-class2-text">
            <div class="iconfont text-padding">门槛
              <#list  1..Job.skill as t>
              <img src="/images/xx.png">
              </#list>
            </div>
          </div>
          <div class="warp-class2-text">
            <div class="iconfont text-padding text-border-left">难易程度
              <#list  1..Job.diffcut as t>
              <img src="/images/xx.png">
              </#list>
              </div>

          </div>
        </div>
        <div class="warp-class2">
          <div class="warp-class2-text">
            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${Job.time}</span>年</div>
          </div>
          <div class="warp-class2-text">
            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${Job.needcompany}</span>家公司需要</div>
          </div>
        </div>

        <div class="warp-class2">
          <div class="leftWarp">
            薪资待遇
          </div>
          <div class="rightWarp">
            <div class="rightWarp-class">
              <div class="rightWarp-year">0-1年</div>
              <div class="rightWarp-wages">5k-10k/月</div>
            </div>
            <div class="rightWarp-class">
              <div class="rightWarp-year">0-1年</div>
              <div class="rightWarp-wages">5k-10k/月</div>
            </div>
            <div class="rightWarp-class border-bottom">
              <div class="rightWarp-year">0-1年</div>
              <div class="rightWarp-wages">5k-10k/月</div>
            </div>
          </div>
        </div>

        <div class="warp-class2">
          <b class="text-b">有${Job.num}人正在学</b>
        </div>
        <div class="warp-class2">
          <p class="text-p">${Job.warning}</p>
        </div>
        <div class="flip-container">
          <p class="flip-title">${Job.type}</p>
          <p class="flip-text">${Job.detail}</p>
        </div>
      </div>
    </div>
    </#list>
</div>
</div>
<#include "footer.ftl">