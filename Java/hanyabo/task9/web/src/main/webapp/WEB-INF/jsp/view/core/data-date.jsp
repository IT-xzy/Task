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

<style>

    #bodyDateDate {

        text-align: center;
        border:1px solid #e7e7e7;
        height: 720px;
        margin-left: 102px;
    }

</style>

<div id="bodyDateDate" align="center">
    </br>
    转换后的时间：<date:date value ="${changeTime}"/>

</div>

