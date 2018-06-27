<%--<%@ taglib uri="/tags" prefix="date"%>--%>
<%--<date:date value ="${student.create_at}"/>--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%--%>
    <%--pageContext.setAttribute("path", request.getContextPath());--%>
<%--%>--%>

<!DOCTYPE HTML>
<html>
<body>
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>用户管理</h1>
        </div>
    </div>
    <!-- 按钮 -->
    <div class="row">
        <tr>
                <form action="${pageContext.request.contextPath}/POST"  >
                    <p id="insertButton"><input  type="submit"  value="新增">
                </form>
            <form action="${pageContext.request.contextPath}/json/student"  method="get" >
                <%--<form action="${pageContext.request.contextPath}/student/${student.id}"  method="get" >--%>
                <p id="queryButton"><input  type="submit"  value="查询">
                    <input type="text" name="id"><br>
            </form>
        </tr>

    </div>
    <!-- 表格  -->
    <div class="row">
        <div class="col-md-12">
            <table align='center' border='1' cellspacing='0'>
                <tr>
                    <td>id</td>
                    <td>姓名</td>
                    <td>qq</td>
                    <td>愿言</td>
                    <td>修真类型</td>
                    <td>创建时间</td>
                    <td>修改时间</td>
                    <td>图片</td>
                    <td>是否工作</td>
                    <td>是否结业</td>
                    <td>优秀学员</td>
                    <td colspan="3">操作</td>
                </tr>
                <c:forEach items="${studentList}" var="student">
                    <tr>
                        <form>
                            <td>${student.id }</td>
                            <td>${student.name }</td>
                            <td>${student.qq }</td>
                            <td>${student.wish}</td>
                            <td>${student.major}</td>
                            <td>${student.create_at}</td>
                            <td>${student.update_at}</td>
                            <td>${student.picture}</td>
                            <td>${student.goodwork}</td>
                            <td>${student.graduation}</td>
                            <td>${student.goodstu}</td>
                        </form>
                        <td>
                            <form action="${pageContext.request.contextPath}/toStudent/${student.id }"  >
                                <p id="editButton"><input  type="submit"  value="编辑">
                            </form>
                        </td>
                        <td>
                        <form  action="${pageContext.request.contextPath}/student/${student.id}"  method="get">
                          <input  type="submit"  value="详细信息">
                        </form>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/student/${student.id}"  method="post">
                            <p id="deleteButton"><input  type="submit"  value="删除">
                                <input type="hidden" name="_method" value="DELETE" />
                        </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>


        </div>
    </div>
</div>
</body>
</html>