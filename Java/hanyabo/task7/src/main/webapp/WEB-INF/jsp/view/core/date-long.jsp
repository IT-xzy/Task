<%--
  Created by IntelliJ IDEA.
  User: zhimowen
  Date: 2018-05-14
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<style>

    #bodyDateLong {
        text-align: center;
        border:1px solid #e7e7e7;
        height: 720px;
        margin-left: 102px;
    }

</style>

<div id="bodyDateLong" align="center">
    </br>
    <form method="post" action="/time/date">
        Long类型时间<input id="time" name="nowTime" type="text" value="${currentTime}"> <br>
        </br>
        <input type="submit" value="查询时间">
    </form>
</div>

