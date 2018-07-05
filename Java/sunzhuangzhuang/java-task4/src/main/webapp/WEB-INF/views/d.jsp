<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/29
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>职业</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="t11.css" rel="stylesheet" type="text/css">
    <link href="base.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
    </div>

    <div class="row">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="../../imges/687.png"></div>
                    <div class="text">
                        <h4 class="">${list.get(0).name}</h4>
                        <p class="text-present">${list.get(0).duty}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="../../imges/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="../../imges/xx.png"><img src="../../imges/xx.png"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期: ${list.get(0).cycle}</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list.get(0).rare}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">${list.get(0).first}</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">1-3年</div>
                            <div class="rightWarp-wages">${list.get(0).second}</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">5年以上</div>
                            <div class="rightWarp-wages">${list.get(0).third}</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${a}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:${list.get(0).prompt}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">${list.get(0).name}</p>
                    <p class="flip-text">${list.get(0).introduce}</p>
                </div>
            </div>

        </div>
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="../../imges/687.png"></div>
                    <div class="text">
                        <h4 class="">${list.get(1).name}</h4>
                        <p class="text-present">${list.get(1).duty}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="../../imges/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="../../imges/xx.png"><img src="../../imges/xx.png"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期:${list.get(1).cycle}</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list.get(1).rare}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">${list.get(1).first}</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">1-3年</div>
                            <div class="rightWarp-wages">${list.get(1).second}</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">3年以上</div>
                            <div class="rightWarp-wages">${list.get(1).third}</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${b}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:${list.get(1).prompt}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">${list.get(1).name}</p>
                    <p class="flip-text">${list.get(1).introduce}</p>
                </div>
            </div>

        </div>
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="../../imges/687.png"></div>
                    <div class="text">
                        <h4 class="">${list.get(2).name}</h4>
                        <p class="text-present">${list.get(2).duty}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="../../imges/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="../../imges/xx.png"><img src="../../imges/xx.png"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期:${list.get(2).cycle}</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list.get(2).rare}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">${list.get(2).first}</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">1-3年</div>
                            <div class="rightWarp-wages">${list.get(2).second}</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">4年以上</div>
                            <div class="rightWarp-wages">${list.get(2).third}</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${c}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:${list.get(2).prompt}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">${list.get(2).name}</p>
                    <p class="flip-text">${list.get(2).introduce}</p>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
