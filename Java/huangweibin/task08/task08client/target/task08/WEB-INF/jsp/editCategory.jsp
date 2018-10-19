<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/14
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="width:500px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">
        <form method="POST" action="../category/${c.id}">
            分类名称： <input name="name" value="${c.name}" type="text"> <br><br>
                    <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="修改分类">
        </form>

    </div>
</div>
