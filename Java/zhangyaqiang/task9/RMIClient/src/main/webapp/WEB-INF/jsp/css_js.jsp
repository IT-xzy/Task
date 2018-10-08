<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/8/21
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>css-14-2</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/scss/headerfooter.css">
    <link rel="stylesheet" type="text/css" href="/../module/carousel/carousel.css">
    <link rel="stylesheet" type="text/css" href="/scss/carousel.css">
    <link rel="stylesheet" type="text/css" href="/scss/grid.css">
    <link rel="stylesheet" type="text/css" href="/scss/css14.css">
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js">
    </script>
</head>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js">
</script>
<script>
    $(".button1").click(function () {
        $(this).css("background-color", "#29b078");
        $(".button2").css("background-color", "#fff");
    });
    $(".button2").click(function () {
        $(".button1").css("background-color", "#fff");
        $(".button2").css("background-color", "#fff");
        $(this).css("background-color", "#29b078");
    })
</script>
</html>
