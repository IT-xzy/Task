<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>职业</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/default.css">
  <link rel="stylesheet" href="css/job.css">
</head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
  <!-- 头部 -->
  <header>
    <div class="container">
      <!-- 第一行 -->
      <div class="row hd-info">
        <!-- center-vertical垂直居中 -->
        <p class="col-sm-5 col-md-5 col-xs-5 center-vertical text-ellipsis">客服热线：010-594-78634</p>
        <div class="col-sm-7 col-md-7 col-xs-7 center-vertical">
          <a class="hd-icon" href="#"><img src="img/weibo.png" alt="weibo"></a>
          <a class="hd-icon" href="#"><img src="img/qq.png" alt="qq"></a>
          <a class="hd-icon" href="#"><img src="img/wechat.png" alt="wechat"></a>
        </div>
      </div>
    </div>  
    <!-- 第二行 导航栏 -->
    <nav class="navbar navbar-default navbar-user" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle btn-user" data-toggle="collapse"
            data-target="#example-navbar-collapse">
            <span class="sr-only">切换导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home.jsp">
            <img src="img/navlogo.png" alt="logo">
          </a>        
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
          <!-- .navbar-right 宽度大于768px导航栏右浮动 -->
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="home">首页</a>
            </li>
            <li class="active">
              <a href="job">职业</a>
            </li>
            <li>
              <a href="offer">推荐</a>
            </li>
            <%--<li>--%>
              <%--<a href="about.html">关于</a>--%>
            <%--</li>--%>
          </ul>
        </div>
      </div>
    </nav>
  </header>

  <main>
    <div class="container">
      <h4>
        <a href="home.jsp"><strong>首页</strong></a>
        &gt;
        <a href="job.jsp"><strong>职业</strong></a>
      </h4>
      <nav>
        <span>方向：</span>
        <a class="nav-focus" href="#"> 全部 </a>
        <a href="#fe"> 前端开发 </a>
        <a href="#be"> 后端开发 </a>
        <a href="#mobile"> 移动开发 </a>
        <a href="#site"> 整站开发 </a>
        <a href="#op"> 运营维护 </a>
      </nav>
      <h4 id="fe"><strong>前端开发方向</strong></h4>
      <div class="row">
        <div class="col-sm-6 col-md-4">
        <section class="dev">
          <section>
            <header>
              <img src="img/dev-icon.png" alt="dev-icon">
              <h4><strong>${students[0].name}</strong></h4>
              <p>${students[0].target}</p>
            </header>
            <table class="table table-bordered">
              <tbody>
                <tr>
                  <td>
                    <span>门槛</span>
                    <img src="img/star.png" alt="star">
                  </td>
                  <td>
                    <span>难易程度</span>
                    <img src="img/star.png" alt="star">
                    <img src="img/star.png" alt="star">
                  </td>
                </tr>
                <tr>
                  <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                  <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                </tr>
                <tr>
                  <td rowspan="3">薪资待遇</td>
                  <td><span>0-1年</span><span class="fl-right">${students[0].university}</span></td>
                </tr>
                <tr>
                  <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                </tr>
                <tr>
                  <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                </tr>
                <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
              </tbody>
            </table>
            </section>
            <div class="dev-hov">
              <h4>iOS工程师</h4>
              <p>
                  ${students[1].source}
              </p>
            </div>
          </section>
        </div>
        <div class="col-sm-6 col-md-4">
          <section class="dev">
            <section>
              <header>
                <img src="img/dev-icon.png" alt="dev-icon">
                <h4><strong>${students[1].name}</strong></h4>
                <p>${students[1].target}</p>
              </header>
              <table class="table table-bordered">
                <tbody>
                  <tr>
                    <td>
                      <span>门槛</span>
                      <img src="img/star.png" alt="star">
                    </td>
                    <td>
                      <span>难易程度</span>
                      <img src="img/star.png" alt="star">
                      <img src="img/star.png" alt="star">
                    </td>
                  </tr>
                  <tr>
                    <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                    <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                  </tr>
                  <tr>
                    <td rowspan="3">薪资待遇</td>
                    <td><span>0-1年</span><span class="fl-right">${students[1].university}</span></td>
                  </tr>
                  <tr>
                    <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                  </tr>
                  <tr>
                    <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                  </tr>
                  <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                  <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
                </tbody>
              </table>
              </section>
              <div class="dev-hov">
                <h4>iOS工程师</h4>
                <p>
                  iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                  国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                  国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                </p>
              </div>
          </section>
        </div>
        <div class="col-sm-6 col-md-4">
        <section class="dev">
          <section>
            <header>
              <img src="img/dev-icon.png" alt="dev-icon">
              <h4><strong>${students[2].name}</strong></h4>
              <p>${students[2].target}</p>
            </header>
            <table class="table table-bordered">
              <tbody>
                <tr>
                  <td>
                    <span>门槛</span>
                    <img src="img/star.png" alt="star">
                  </td>
                  <td>
                    <span>难易程度</span>
                    <img src="img/star.png" alt="star">
                    <img src="img/star.png" alt="star">
                  </td>
                </tr>
                <tr>
                  <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                  <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                </tr>
                <tr>
                  <td rowspan="3">薪资待遇</td>
                  <td><span>0-1年</span><span class="fl-right">${students[2].university}</span></td>
                </tr>
                <tr>
                  <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                </tr>
                <tr>
                  <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                </tr>
                <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
              </tbody>
            </table>
            </section>
            <div class="dev-hov">
              <h4>iOS工程师</h4>
              <p>
                iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
              </p>
            </div>
          </section>
        </div>
      </div>
      <h4 id="be"><strong>后端开发方向</strong></h4>
      <div class="row">
        <div class="col-sm-6 col-md-4">
        <section class="dev">
          <section>
            <header>
              <img src="img/dev-icon.png" alt="dev-icon">
              <h4><strong>${students[3].name}</strong></h4>
              <p>${students[3].target}</p>
            </header>
            <table class="table table-bordered">
              <tbody>
                <tr>
                  <td>
                    <span>门槛</span>
                    <img src="img/star.png" alt="star">
                  </td>
                  <td>
                    <span>难易程度</span>
                    <img src="img/star.png" alt="star">
                    <img src="img/star.png" alt="star">
                  </td>
                </tr>
                <tr>
                  <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                  <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                </tr>
                <tr>
                  <td rowspan="3">薪资待遇</td>
                  <td><span>0-1年</span><span class="fl-right">${students[3].university}</span></td>
                </tr>
                <tr>
                  <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                </tr>
                <tr>
                  <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                </tr>
                <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
              </tbody>
            </table>
            </section>
            <div class="dev-hov">
              <h4>iOS工程师</h4>
              <p>
                iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
              </p>
            </div>
          </section>
        </div>
        <div class="col-sm-6 col-md-4">
          <section class="dev">
            <section>
              <header>
                <img src="img/dev-icon.png" alt="dev-icon">
                <h4><strong>${students[4].name}</strong></h4>
                <p>${students[4].target}</p>
              </header>
              <table class="table table-bordered">
                <tbody>
                  <tr>
                    <td>
                      <span>门槛</span>
                      <img src="img/star.png" alt="star">
                    </td>
                    <td>
                      <span>难易程度</span>
                      <img src="img/star.png" alt="star">
                      <img src="img/star.png" alt="star">
                    </td>
                  </tr>
                  <tr>
                    <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                    <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                  </tr>
                  <tr>
                    <td rowspan="3">薪资待遇</td>
                    <td><span>0-1年</span><span class="fl-right">${students[4].university}</span></td>
                  </tr>
                  <tr>
                    <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                  </tr>
                  <tr>
                    <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                  </tr>
                  <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                  <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
                </tbody>
              </table>
              </section>
              <div class="dev-hov">
                <h4>iOS工程师</h4>
                <p>
                  iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                  国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                  国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                </p>
              </div>
          </section>
        </div>
        <div class="col-sm-6 col-md-4">
        <section class="dev">
          <section>
            <header>
              <img src="img/dev-icon.png" alt="dev-icon">
              <h4><strong>${students[5].name}</strong></h4>
              <p>${students[5].target}</p>
            </header>
            <table class="table table-bordered">
              <tbody>
                <tr>
                  <td>
                    <span>门槛</span>
                    <img src="img/star.png" alt="star">
                  </td>
                  <td>
                    <span>难易程度</span>
                    <img src="img/star.png" alt="star">
                    <img src="img/star.png" alt="star">
                  </td>
                </tr>
                <tr>
                  <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                  <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                </tr>
                <tr>
                  <td rowspan="3">薪资待遇</td>
                  <td><span>0-1年</span><span class="fl-right">${students[5].university}</span></td>
                </tr>
                <tr>
                  <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                </tr>
                <tr>
                  <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                </tr>
                <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
              </tbody>
            </table>
            </section>
            <div class="dev-hov">
              <h4>iOS工程师</h4>
              <p>
                iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
              </p>
            </div>
          </section>
        </div>
      </div>
      <h4 id="mobile"><strong>移动开发方向</strong></h4>
      <div class="row">
        <div class="col-sm-6 col-md-4">
        <section class="dev">
          <section>
            <header>
              <img src="img/dev-icon.png" alt="dev-icon">
              <h4><strong>${students[6].name}</strong></h4>
              <p>${students[6].target}</p>
            </header>
            <table class="table table-bordered">
              <tbody>
                <tr>
                  <td>
                    <span>门槛</span>
                    <img src="img/star.png" alt="star">
                  </td>
                  <td>
                    <span>难易程度</span>
                    <img src="img/star.png" alt="star">
                    <img src="img/star.png" alt="star">
                  </td>
                </tr>
                <tr>
                  <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                  <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                </tr>
                <tr>
                  <td rowspan="3">薪资待遇</td>
                  <td><span>0-1年</span><span class="fl-right">${students[6].university}</span></td>
                </tr>
                <tr>
                  <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                </tr>
                <tr>
                  <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                </tr>
                <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
              </tbody>
            </table>
            </section>
            <div class="dev-hov">
              <h4>iOS工程师</h4>
              <p>
                iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
              </p>
            </div>
          </section>
        </div>
        <div class="col-sm-6 col-md-4">
          <section class="dev">
            <section>
              <header>
                <img src="img/dev-icon.png" alt="dev-icon">
                <h4><strong>${students[7].name}</strong></h4>
                <p>${students[7].target}</p>
              </header>
              <table class="table table-bordered">
                <tbody>
                  <tr>
                    <td>
                      <span>门槛</span>
                      <img src="img/star.png" alt="star">
                    </td>
                    <td>
                      <span>难易程度</span>
                      <img src="img/star.png" alt="star">
                      <img src="img/star.png" alt="star">
                    </td>
                  </tr>
                  <tr>
                    <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                    <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                  </tr>
                  <tr>
                    <td rowspan="3">薪资待遇</td>
                    <td><span>0-1年</span><span class="fl-right">${students[7].university}</span></td>
                  </tr>
                  <tr>
                    <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                  </tr>
                  <tr>
                    <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                  </tr>
                  <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                  <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
                </tbody>
              </table>
              </section>
              <div class="dev-hov">
                <h4>iOS工程师</h4>
                <p>
                  iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                  国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                  国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                </p>
              </div>
          </section>
        </div>
      </div>
      <h4 id="site"><strong>整站开发方向</strong></h4>
      <div class="row">
        <div class="col-sm-6 col-md-4">
        <section class="dev">
          <section>
            <header>
              <img src="img/dev-icon.png" alt="dev-icon">
              <h4><strong>${students[1].name}</strong></h4>
              <p>${students[1].target}</p>
            </header>
            <table class="table table-bordered">
              <tbody>
                <tr>
                  <td>
                    <span>门槛</span>
                    <img src="img/star.png" alt="star">
                  </td>
                  <td>
                    <span>难易程度</span>
                    <img src="img/star.png" alt="star">
                    <img src="img/star.png" alt="star">
                  </td>
                </tr>
                <tr>
                  <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                  <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                </tr>
                <tr>
                  <td rowspan="3">薪资待遇</td>
                  <td><span>0-1年</span><span class="fl-right">${students[1].university}</span></td>
                </tr>
                <tr>
                  <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                </tr>
                <tr>
                  <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                </tr>
                <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
              </tbody>
            </table>
            </section>
            <div class="dev-hov">
              <h4>iOS工程师</h4>
              <p>
                iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
              </p>
            </div>
          </section>
        </div>
        <div class="col-sm-6 col-md-4">
          <section class="dev">
            <section>
              <header>
                <img src="img/dev-icon.png" alt="dev-icon">
                <h4><strong>${students[2].name}</strong></h4>
                <p>${students[2].target}</p>
              </header>
              <table class="table table-bordered">
                <tbody>
                  <tr>
                    <td>
                      <span>门槛</span>
                      <img src="img/star.png" alt="star">
                    </td>
                    <td>
                      <span>难易程度</span>
                      <img src="img/star.png" alt="star">
                      <img src="img/star.png" alt="star">
                    </td>
                  </tr>
                  <tr>
                    <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                    <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                  </tr>
                  <tr>
                    <td rowspan="3">薪资待遇</td>
                    <td><span>0-1年</span><span class="fl-right">${students[2].university}</span></td>
                  </tr>
                  <tr>
                    <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                  </tr>
                  <tr>
                    <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                  </tr>
                  <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                  <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
                </tbody>
              </table>
              </section>
              <div class="dev-hov">
                <h4>iOS工程师</h4>
                <p>
                  iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                  国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                  国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                </p>
              </div>
          </section>
        </div>
        <div class="col-sm-6 col-md-4">
        <section class="dev">
          <section>
            <header>
              <img src="img/dev-icon.png" alt="dev-icon">
              <h4><strong>${students[3].name}</strong></h4>
              <p>${students[3].target}</p>
            </header>
            <table class="table table-bordered">
              <tbody>
                <tr>
                  <td>
                    <span>门槛</span>
                    <img src="img/star.png" alt="star">
                  </td>
                  <td>
                    <span>难易程度</span>
                    <img src="img/star.png" alt="star">
                    <img src="img/star.png" alt="star">
                  </td>
                </tr>
                <tr>
                  <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                  <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                </tr>
                <tr>
                  <td rowspan="3">薪资待遇</td>
                  <td><span>0-1年</span><span class="fl-right">${students[3].university}</span></td>
                </tr>
                <tr>
                  <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                </tr>
                <tr>
                  <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                </tr>
                <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
              </tbody>
            </table>
            </section>
            <div class="dev-hov">
              <h4>iOS工程师</h4>
              <p>
                iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
              </p>
            </div>
          </section>
        </div>
      </div>
      <h4 id="op"><strong>运营维护方向</strong></h4>
      <div class="row">
        <div class="col-sm-6 col-md-4">
        <section class="dev">
          <section>
            <header>
              <img src="img/dev-icon.png" alt="dev-icon">
              <h4><strong>${students[4].name}</strong></h4>
              <p>${students[4].target}</p>
            </header>
            <table class="table table-bordered">
              <tbody>
                <tr>
                  <td>
                    <span>门槛</span>
                    <img src="img/star.png" alt="star">
                  </td>
                  <td>
                    <span>难易程度</span>
                    <img src="img/star.png" alt="star">
                    <img src="img/star.png" alt="star">
                  </td>
                </tr>
                <tr>
                  <td><span>成长周期</span><span class="color-red">1-3</span><span>年</span></td>
                  <td><span>稀缺程度</span><span class="color-red">345</span><span>家公司需要</span></td>
                </tr>
                <tr>
                  <td rowspan="3">薪资待遇</td>
                  <td><span>0-1年</span><span class="fl-right">${students[4].university}</span></td>
                </tr>
                <tr>
                  <td><span>1-3年</span><span class="fl-right">10k-20k/月</span></td>
                </tr>
                <tr>
                  <td><span>3-5年</span><span class="fl-right">20k-50k/月</span></td>
                </tr>
                <tr><td colspan="2"><strong>有 <span class="color-red">286</span>人正在学</strong></td></tr>
                <tr><td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td></tr>
              </tbody>
            </table>
            </section>
            <div class="dev-hov">
              <h4>iOS工程师</h4>
              <p>
                iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
              </p>
            </div>
          </section>
        </div>
      </div>
    </div>
  </main>

  <!-- 底部 -->
  <footer>
    <div class="ft-top">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-4 col-sm-4">
            <h4>
              <a href="#">技能树&nbsp;—&nbsp;改变你我</a> 
            </h4>
            <p>
              <a href="#">关于我们&nbsp;&nbsp;|&nbsp;&nbsp;</a>
              <a href="#">联系我们&nbsp;&nbsp;|&nbsp;&nbsp;</a>
              <a href="#">合作企业</a>
            </p>
          </div>
          <div class="col-lg-5 col-md-5 col-sm-5">
            <h4>旗下网站</h4>
            <p>
              <span><a href="#">草船云孵化器</a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
              <span><a href="#">最强IT训练营</a></span>
            </p>
            <p>
                <span><a href="#">葡萄藤轻游戏</a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <span><a href="#">桌游精灵</a></span>
              </p>
          </div>
          <div class="col-lg-3 col-md-3 col-sm-3">
            <div class="pull-right">
              <h4>微信公众平台</h4>
              <img src="img/qrcode.png" alt="qrcode">
            </div>    
          </div>
        </div>
      </div>
    </div>
    
    <!-- 版权信息 -->
    <div class="ft-btm">
      <div class="container">
        <div class="row text-center">
          <span> Copyright &copy; 2015  </span>
          <a href="#">技能树www.jnshu.com </a>
          <span> All Right Reserved</span>
          <a href="#">| 京ICP备13005880号</a>
        </div>
      </div>
    </div>
  </footer>
  <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
  <script src="js/jquery-1.12.4.min.js"></script>
  <!-- 包括所有已编译的插件 -->
  <script src="js/bootstrap.min.js"></script>
</body>
</html>