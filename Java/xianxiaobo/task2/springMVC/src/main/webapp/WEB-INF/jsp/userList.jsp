<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/10/25
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.8.2/jquery.js"></script>
</head>
<body>

<div style="padding: 100px 100px 10px;">
    <div class="panel  panel-primary">

        <div class="panel-heading">搜索框</div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">姓名</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="name" placeholder="请输入名字">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="sex" class="col-sm-3 control-label">性别</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="sex">
                                    <option value="">全部</option>
                                    <option value="1">男</option>
                                    <option value="2">女</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-8">
                        <div class="form-group">
                            <div class="col-sm-9 text-right">
                                <button type="button" class="btn btn-success" id="searchButton">搜索</button>
                            </div>
                        </div>
                    </div>
                </div>

            </form>
        </div>
    </div>
    <div class="panel  panel-primary">
        <div class="panel-heading">
            用户列表
            <button class="btn btn-success btn-xs pull-right" onclick="window.location.href='/user/add'">新增+</button>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>性别</th>
                        <th>手机号</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userListData}" var="item">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.sex == 1?"男":"女"}</td>
                        <td>${item.phone}</td>
                        <td>
                            <button class="btn btn-sm btn-primary" onclick="window.location.href='/user/edit/${item.id}'">修改</button>
                            <button class="btn btn-sm btn-danger" onclick="window.location.href='/user/delete/${item.id}'">删除</button>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div>${total} 条</div>
            <ul class="pagination">
                <%--<li><a class="pageButton" id="prev">&laquo;</a></li>--%>
                <c:forEach items="${pageData}" var="item">
                    <li><a class="pageButton" id="${item}" style="cursor: pointer">${item}</a></li>
                </c:forEach>
                <%--<li><a class="pageButton" id="next">&raquo;</a></li>--%>
            </ul>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return decodeURI(r[2]); return null;
        }
        function init(){
            var name = getQueryString("name");
            var sex = getQueryString("sex");
            var page =  getQueryString("page");
            console.log(name);
            // console.log(total);
            $("#name").val(name);
            $("#sex").val(sex);
            $("#"+page).parent().addClass("active");
        }
        <%--function pageInit(){--%>
            <%--var total = ${total};--%>
            <%--console.log(total);--%>
        <%--}--%>
        init();
        // pageInit();
       $("#searchButton").click(function(){
           var name = $("#name").val();
           var sex = $("#sex").val();
           var page = 1;
           window.location.href='/user/list?name='+name+'&sex='+sex+'&page='+page;
       });
       $(".pageButton").click(function(){
           console.log($(this).attr('id'));
           var name = $("#name").val();
           var sex = $("#sex").val();
           var page = $(this).attr('id');
           window.location.href='/user/list?name='+name+'&sex='+sex+'&page='+page;
       })
    });

</script>
</body>
</html>
