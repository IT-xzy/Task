<%--
  Created by IntelliJ IDEA.
  User: zhimowen
  Date: 2018-05-14
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<%@ taglib uri="/tags" prefix="date"%>

<%--<date:date value ="1234567890000"/>--%>

<style>

    #body1 {
        display: inline-block;
        line-height:30px;
        background-color:#eeeeee;
        height:720px;
        width:1200px;
        margin-left: 2px;
    }

</style>

<div id="body1" align="center">
    <%--<button onclick="go(123)">body按钮</button>--%>
    <form method="post" action="/tiles/second">
        Long类型时间<input id="time" name="nowtime" type="text" value="${currenttime}"> <br>
        <input type="submit" value="查询时间">
    </form>
</div>

