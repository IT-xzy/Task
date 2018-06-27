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

    #body21 {
        display: inline-block;
        line-height:30px;
        background-color:#eeeeee;
        height:720px;
        width:1200px;
        /*float:left;*/
        /*padding:5px;*/
        margin-left: 2px;
    }

</style>

<div id="body21" align="center">

    转换后的时间：<date:date value ="${nowtimea}"/>

</div>

