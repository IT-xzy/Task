<%--
  Created by IntelliJ IDEA.
  User: zhimowen
  Date: 2018-05-14
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<style>
    #menuDis {
        display: inline-block;
        width: 100px;
        height: 720px;

        float:left;
        border:1px solid #e7e7e7;
        background-color:#f8f8f8;

        text-align: center;

    }

    .menuA {
        text-decoration:none;
    }

    .menuDiv {
        border:1px solid #e7e7e7;
        height: 30px;
        line-height: 30px;
    }

</style>

<div id="menuDis" align="center">

    <div class="menuDiv">
        <a id="tip1" class="menuA" href="/jnshu/welcome">欢迎页面</a>
    </div>
    <div class="menuDiv">
        <a id="tip2" class="menuA" href="/jnshu/manage">学生管理</a>
    </div>
    <div class="menuDiv">
        <a id="tip3" class="menuA" href="/time/long">时间转换</a>
    </div>




</div>
