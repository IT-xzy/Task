<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title><tiles:insertAttribute name="title" ignore="true" /></title>

    <tiles:insertAttribute name="cssresources" />

    <style>
        #body2 {
            background-color:red;
            color:green;
            text-align:center;
            padding:5px;
            height: 750px;
            margin: auto;
        }
    </style>
</head>
<body class="sticky-header">

<div id="header2">
    <tiles:insertAttribute name="header" />
</div>
<div id="body2">
    <div id="menu1">
        <tiles:insertAttribute name="menu" />
    </div>
    <div id="body1">
        <tiles:insertAttribute name="body" />
    </div>
</div>
<div id="footer2">
    <tiles:insertAttribute name="footer" />
</div>
</body>
<tiles:insertAttribute name="jsresources" />
</html>
