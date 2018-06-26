<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/24
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="header">
    <div class="container black">
        <div class="qrcode">
            <div class="littlecode">
                <img width="16px" src="img/little_qrcode.jpg" id="licode">
                <div class="showqrs" id="showqrs">
                    <div class="shtoparrow"></div>
                    <div class="guanzhuqr">
                        <img src="img/guanzhu_qrcode.png" width="80">
                        <div class="shmsg" style="margin-top:5px;">
                            请扫码关注
                        </div>
                        <div class="shmsg" style="margin-bottom:5px;">
                            接收重要信息
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="nav">
            <a href="https://www.alipay.com/" class="logo"><img src="img/alipay_logo.png" height="30px"></a>
            <span class="divier"></span>
            <a href="http://open.alipay.com/platform/home.htm" class="open" target="_blank">开放平台</a>
            <ul class="navbar">
                <li><a href="https://doc.open.alipay.com/doc2/detail?treeId=62&articleId=103566&docType=1" target="_blank">在线文档</a></li>
                <li><a href="https://cschannel.alipay.com/portal.htm?sourceId=213" target="_blank">技术支持</a></li>
            </ul>
        </div>
    </div>
    <div class="container blue">
        <div class="title">支付宝即时到账(create_direct_pay_by_user)</div>
    </div>
</div>
<div class="content">
    <%-- <form action="${ctx}/aliPay/open" class="alipayform" method="POST" target="_blank"> --%>
    <div class="element" style="margin-top:60px;">
        <div class="legend">支付宝即时到账交易接口快速通道 </div>
    </div>
    <div class="element">
        <div class="etitle">商户订单号:</div>
        <div class="einput"><input type="text" name="WIDout_trade_no" id="out_trade_no"></div>
        <br>
        <div class="mark">注意：商户订单号(out_trade_no).必填(建议是英文字母和数字,不能含有特殊字符)</div>
    </div>

    <div class="element">
        <div class="etitle">商品名称:</div>
        <div class="einput"><input type="text" name="WIDsubject" id="WIDsubject" value="test商品123"></div>
        <br>
        <div class="mark">注意：产品名称(subject)，必填(建议中文，英文，数字，不能含有特殊字符)</div>
    </div>
    <div class="element">
        <div class="etitle">付款金额:</div>
        <div class="einput"><input type="text" name="WIDtotal_fee" id="WIDtotal_fee" value="0.01"></div>
        <br>
        <div class="mark">注意：付款金额(total_fee)，必填(格式如：1.00,请精确到分)</div>
    </div>
    <div class="element">
        <div class="etitle">商品描述:</div>
        <div class="einput"><input type="text" name="WIDbody" id="WIDbody" value="即时到账测试"></div>
        <br>
        <div class="mark">注意：商品描述(body)，选填(建议中文，英文，数字，不能含有特殊字符)</div>
    </div>
    <div class="element">
        <input type="button" class="alisubmit" id="sbumitBtn" value ="确认支付">
    </div>
</div>
<div id="returnAli"></div>
<div class="footer">
    <p class="footer-sub">
        <a href="http://ab.alipay.com/i/index.htm" target="_blank">关于支付宝</a><span>|</span>
        <a href="https://e.alipay.com/index.htm" target="_blank">商家中心</a><span>|</span>
        <a href="https://job.alibaba.com/zhaopin/index.htm" target="_blank">诚征英才</a><span>|</span>
        <a href="http://ab.alipay.com/i/lianxi.htm" target="_blank">联系我们</a><span>|</span>
        <a href="#" id="international" target="_blank">International Business</a><span>|</span>
        <a href="http://ab.alipay.com/i/jieshao.htm#en" target="_blank">About Alipay</a>
        <br>
        <span>支付宝版权所有</span>
        <span class="footer-date">2004-2016</span>
        <span><a href="http://fun.alipay.com/certificate/jyxkz.htm" target="_blank">ICP证：沪B2-20150087</a></span>
    </p>
    $(function (){
    $("#sbumitBtn").on('click', function(){
    $.ajax({
    type : "post",
    data : {
    WIDout_trade_no : $('#out_trade_no').val(),
    WIDsubject : $('#WIDsubject').val(),
    WIDtotal_fee : $('#WIDtotal_fee').val(),
    WIDbody : $('#WIDbody').val()
    },
    url : "${ctx}/aliPay/open",
    success : function(data) {
    $('#returnAli').append(data.sHtmlText);
    },
    error : function(da){
    }
    });
    })

    });

</div>
</body>
</html>
