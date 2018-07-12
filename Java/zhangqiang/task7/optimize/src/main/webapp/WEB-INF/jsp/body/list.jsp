<%--
  Created by IntelliJ IDEA.
  User: GhostSugar
  Date: 2018/6/13
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--核心标签 支持 c:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--json标签 支持<json:object>--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--page 支持EL表达式 ${name}--%>
<%@ page isELIgnored="false" %>


    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/stat/js/layer/layer.js"></script>

    <script>
        function del(id){
            alert(id);
            layer.msg('不允许删除！');
        }
    </script>



<div class="container" style="margin-top: 50px;">
    <div class="row ">
        <div class="col-md-12 column ">
            <table class="table table-condensed table-hover">
                <colgroup style="display: none">
                    <col style="width:10%">
                    <col style="width:10%">
                    <col style="width:10%">
                    <col style="width:10%">
                    <col style="width:10%">
                    <col style="width:10%">
                    <col style="width:10%">
                    <col style="width:10%">
                </colgroup>
                <thead>
                <tr>
                    <th style="width:8%">ID</th>
                    <th style="width:8%">姓名</th>
                    <th style="width:8%">头像</th>
                    <th style="width:8%">性别</th>
                    <th style="width:8%">年龄</th>
                    <th style="width:8%">院校</th>
                    <th style="width:25%">立愿</th>
                    <th style="width:25%">宣言</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${!empty requestScope.nowPages.pages}">
                    <c:forEach items="${requestScope.nowPages.pages}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.stuName}</td>
                            <td><img src="${item.stuPhoto}" style="width:50px;"></td>
                            <td>
                                <c:if test="${item.sex == 0}">女
                            </c:if>
                                <c:if test="${item.sex == 1}">男
                                </c:if>
                            </td>
                            <td>${item.age}</td>
                            <td>${item.school}</td>
                            <td>${item.office}</td>
                            <td>${item.recommend}</td>
                            <td>
                                <form  id="itemUpdFrom" action="/u/student/${item.id}">
                                    <input type="hidden" name="id" value="${item.id}" >
                                    <button type="submit" id="itemUpdFb${item.id}"  class="btn btn-info btn-sm"  >编辑</button>
                                </form>
                                <form id="itemDelFrom" method="post" >
                                    <input type="hidden" name="_method" value="delete">
                                    <input name="id" type="hidden" name="id" value="${item.id}" placeholder="${user.id}">
                                    <button type="button"  class="btn  btn-sm" onclick="del(${item.id})" >删除</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>

                <tr>
                    <td colspan="9">
                        <ul class="pagination">

                            <li><a >第${requestScope.nowPages.currPage}/${requestScope.nowPages.totalPage}页</a>&nbsp;<a >总记录:${requestScope.nowPages.totalConut}条,每页显示${requestScope.nowPages.pageSize}条</a></li>
                            <li><a href="/u/list?nowPage=1">首页</a>
                                <c:if test="${requestScope.nowPages.currPage != 1}">
                                    <a href="/u/list?nowPage=${requestScope.nowPages.currPage-1}">上一页</a>
                                </c:if>

                                <c:if test="${requestScope.nowPages.currPage != requestScope.nowPages.totalPage}">
                                    <a href="/u/list?nowPage=${requestScope.nowPages.currPage+1}">下一页</a>
                                    <a href="/u/list?nowPage=${requestScope.nowPages.totalPage}">尾页</a>
                                </c:if>
                                   <form action="/u/list" style="display: inline-block; width: 20%" class="form-inline"> 跳转到第&nbsp;<input type="text" name="nowPage" id="" class="form-control" style="text-align: center; width: 20%;"/>&nbsp;页&nbsp;<button type="submit" class="btn btn-default">Go</button></form>
                            </li>
                        </ul>

                    </td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>
