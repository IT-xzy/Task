<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2017/12/27
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <script src="${pageContext.request.contextPath}/t8/js/jquery-3.2.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/t8/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/t8/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/t8/css/jnshu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/t8/css/cooperation.css">
    <title>战略合作企业</title>
</head>

<body>

<header>
    <tiles:insertAttribute name="head"/>
</header>


<div class="container-fluid">
    <div class="row">
        <img src="${pageContext.request.contextPath}/t8/img/cooperation-banner.png" alt="" class="img-responsive">
    </div>
</div>


<!-- 链式导航 -->
<div class="container link-line">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/u/jnshu">首页</a></li>
            <li class="active">合作企业</li>
        </ol>
    </div>
</div>
<!-- 合作企业 -->
<div class="container cooperation">
    <div class="row">
        <!-- 左列&企业名称 -->
        <div class="col-sm-3 company-name">
            <p class="">合作企业</p>
            <span></span>
            <ul>
                <li><span></span>阿里巴巴</li>
                <li><span></span>腾讯视频</li>
                <li><span></span>北京葡萄藤</li>
                <li class="active"><span></span>土豆网</li>
                <li><span></span>北京葡萄藤</li>
                <li><span></span>阿里巴巴</li>
                <li><span></span>阿里巴巴</li>
                <li><span></span>腾讯视频</li>
                <li><span></span>土豆网</li>
                <li><span></span>腾讯视频</li>
                <li><span></span>阿里巴巴</li>
                <li><span></span>北京葡萄藤</li>
                <li><span></span>腾讯视频</li>
                <li><span></span>北京葡萄藤</li>
            </ul>
        </div>
        <!-- 右列&企业信息 -->
        <div class="col-sm-9 company-info">
            <div class="row company-info-head">
                <img src="${pageContext.request.contextPath}/t8/img/tudou-log.png" alt="企业loge">
                <span>土豆网公司成立于1998年11月，是目前中国最大的互联网综合服务提供商之一，也是中国 服务用户最多的互联网企业之一。成立
					</span>
            </div>
            <div class="company-info-main">
                <p>土豆是中国最早和最具影响力的网络视频平台，是中国网络视频行业的领军品牌。其前身土豆网于2005年4月15日;土豆是中国最早和最具影响力的网络视频平台，是中国网络视频行业的领军品牌。其前身土豆网于2005年4月15日</p>
                <p>“每个人都是生活的导演”是土豆从创立第一天始的价值观。土豆相信年轻人的想象力、创造力，相信土豆的平台能帮助年轻;“每个人都是生活的导演”是土豆从创立第一天始的价值观。土豆相信年轻人的想象力、创造力，相信土豆的平台能帮助年轻</p>
                <p>2012年3月12日，优酷股份有限公司(NYSE: YOKU) (“优酷”) 和土豆股份有限公司 (NA;2012年3月12日，优酷股份有限公司(NYSE: YOKU) (“优酷”) 和土豆股份有限公司 (NA</p>
                <p>2013年2月，杨伟东成为土豆总裁，宣布打造土豆“成为中国年轻人最喜爱的视频网站”，并明确土豆“成为中国;2013年2月，杨伟东成为土豆总裁，宣布打造土豆“成为中国年轻人最喜爱的视频网站”，并明确土豆“成为中国</p>
                <p>2014年3月土豆推出“4+1”战略。其中“4”代表的是土豆在内容方面更专注动漫、音乐、韩国娱乐、时尚四;2014年3月土豆推出“4+1”战略。其中“4”代表的是土豆在内容方面更专注动漫、音乐、韩国娱乐、时尚四</p>
                <p>根据第三方调研公司艾瑞的数据，优酷土豆集团在PC端和移动端全平台各项数据持续占据视频行业绝对领先优势，;根据第三方调研公司艾瑞的数据，优酷土豆集团在PC端和移动端全平台各项数据持续占据视频行业绝对领先优势，</p>
            </div>
        </div>
    </div>
</div>

<footer>
    <tiles:insertAttribute name="tail"/>
</footer>
</body>
</html>
