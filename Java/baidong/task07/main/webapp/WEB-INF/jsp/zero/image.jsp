<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图片</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="/css/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/image" method="post" enctype="multipart/form-data">
    图片<input type="file" name="file">
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
