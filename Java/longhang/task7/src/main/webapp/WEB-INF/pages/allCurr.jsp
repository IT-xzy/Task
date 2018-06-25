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
            <h1>课程管理</h1>
        </div>
    </div>
    <!-- 按钮 -->
    <div class="row">
        <tr>
            <form action="${pageContext.request.contextPath}/toPOST"  >
                <p id="insertButton"><input  type="submit"  value="新增">
            </form>
        </tr>
    </div>
    <!-- 表格  -->
    <div class="row">
        <div class="col-md-12">
            <table align='center' border='1' cellspacing='0'>
                <tr>
                    <td>id</td>
                    <td>图片</td>
                    <td>课程名</td>
                    <td>介绍</td>
                    <td>门槛</td>
                    <td>难度</td>
                    <td>周期</td>
                    <td>需求</td>
                    <td>工资1</td>
                    <td>工资2</td>
                    <td>工资3</td>
                    <td>提示</td>
                    <td>在学人数</td>
                    <td colspan="2">操作</td>
                </tr>
                <c:forEach items="${curriculumes}" var="curriculum">
                    <tr>
                        <form>
                            <td>${curriculum.id}</td>
                            <td>${curriculum.picture}</td>
                            <td>${curriculum.name}</td>
                            <td>${curriculum.introduce}</td>
                            <td>${curriculum.threshold}</td>
                            <td>${curriculum.difficulty}</td>
                            <td>${curriculum.cycle}</td>
                            <td>${curriculum.demand}</td>
                            <td>${curriculum.wages1}</td>
                            <td>${curriculum.wages2}</td>
                            <td>${curriculum.wages3}</td>
                            <td>${curriculum.prompt}</td>
                            <td>${curriculum.onnum}</td>
                        </form>
                        <td>
                            <form action="${pageContext.request.contextPath}/toCurr/${curriculum.id}"  >
                                <p id="editButton"><input  type="submit"  value="编辑">
                            </form>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/jnshu/${curriculum.id}"  method="post">
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