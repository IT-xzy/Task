<%--
  Created by IntelliJ IDEA.
  User: luojiac
  Date: 2018/5/1
  Time: 下午9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<!DOCTYPE html>
<html>
<head>
     <tiles:insertAttribute name="title" />
</head>
<body>
     <tiles:insertAttribute name="header" />
     <tiles:insertAttribute name="body" />
     <tiles:insertAttribute name="footer" />
</body>
</html>
