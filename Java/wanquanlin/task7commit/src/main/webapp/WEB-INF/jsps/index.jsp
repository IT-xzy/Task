﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link  href="<%=basePath %>resource/images/style.css" rel="stylesheet" type="text/css" />
<title>云通付即时到账交易接口快速通道</title>
</head><body style="background:#F3F3F4">
<br />
<br />
<table border="0" cellpadding="0" cellspacing="0" class="tb_style">
  <form action="<%=basePath %>shanpay.do" method="post" name="shanpayment" target="_blank" id="shanpayment">
    <tr>
      <td width="210"   height="50"  class="td_border"><a href="http://www.passpay.net"><img src="<%=basePath %>resource/images/logo.png" border="0"></a></td>
      <td width="412"  class="td_border">&nbsp;</td>
      <td width="178"  class="td_border"><strong><a href="http://www.passpay.net">官方网站</a></strong></td>
    </tr>
  </form>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="tb_style">
  <form name="shanpayment" action="shanpay.do" method="post" target="_blank">
    <tr>
      <td height="50"  colspan="3"class="td_title"><span class="title">云通付即时到账交易接口快速通道</span></td>
    </tr>
    <tr>
      <td   height="50"  class="td_border"><font color="#FF0000">* </font>商品订单号：</td>
      <td colspan="2"  class="td_border"><input name="WIDout_trade_no" type="text" value="10000000" size="35"  />        
        <font color="#FF0000">* 必填</font> &nbsp;&nbsp;&nbsp;商户网站订单系统中唯一订单号</td>
    </tr>
    <tr>
      <td   height="50"  class="td_border"><font color="#FF0000">* </font>商品的名称：</td>
      <td colspan="2"  class="td_border"><input  name="WIDsubject" type="text" value="购买云通付" size="35" />        <font color="#FF0000">* 必填</font> &nbsp;&nbsp;&nbsp;商户网站的商品名称</td>
    </tr>
    <tr>
      <td   height="50"  class="td_border"><font color="#FF0000">* </font>交易的金额：</td>
      <td colspan="2"  class="td_border"><input name="WIDtotal_fee" type="text" value="0.1" size="35" />        <font color="#FF0000">* 必填</font> &nbsp;&nbsp;&nbsp;商品的交易金额</td>
    </tr>
    <tr>
      <td   height="100"  class="td_border"><font color="#FF0000">* </font>商品的说明:</td>
      <td height="80" colspan="2"  class="td_border"><textarea name="WIDbody" cols="35" rows="10" class="L_r_content">云通付收银助你秒开发....</textarea></td>
    </tr>
    <tr>
      <td   height="50"  class="td_border">&nbsp;</td>
      <td  class="td_border"><input type="submit" name="Submit" value="立即下单" class="btn_save" id="addnew"/>
      &nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td  class="td_border">&nbsp;</td>
    </tr>
  </form>
</table>

<div class="bottom">
 Powered BY <a href="http://www.passpay.net" target="_blank">云通付</a>
 &copy; 2013-2016&nbsp;&nbsp;<a href="http://www.passpay.net" target="_blank">PassPAY Inc.</a>
  
</div>
</body>
</html>
