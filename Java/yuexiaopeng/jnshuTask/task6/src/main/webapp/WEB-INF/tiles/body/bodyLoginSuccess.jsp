<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<main>
    <div class="container">
        <div class=" main-t">
            首页 > <span>账户</span>
        </div>
        <div class="row">
            <%--左侧内容--%>
            <div class="col-md-3 main-l">

            </div>
            <%--中间内容--%>
            <div class="col-md-6 main-r">
                <div class="mr-in">
                    <div style="text-align: center" class="main-rt">
                        <%--<img src="${pageContext.request.contextPath}/img/shamgod.gif" class="i-tdw" />--%>
                     <p style="color: #000000;font-size: 20px;" > | 成功!!! | </p>
                    </div>
                    <div class="main-rb">
                        <%--<form action="login/log" method="post">--%>
                            <table>

                                <tr>
                                    <td colspan="2" style="color: #ff5050;font-size: 16px" >
                                         选择进入首页???
                                        <a href="${pageContext.request.contextPath}/home" >点点点我</a>
                                        或点击右上角栏目
                                    </td>

                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #ff5050;font-size: 16px" >
                                        查看json数据???
                                        <a href="${pageContext.request.contextPath}/login/json" >点点点我</a>

                                    </td>

                                </tr>
                            </table>
                        <%--</form>--%>
                            <form action="${pageContext.request.contextPath}/login/json">
                                <input type="text" name="loginAccount" value="">
                                <input type="text" name="loginPassword" value="">
                                <input style="background-color: #ff5050;"
                                       type="button" value="登录" onclick="submit()">
                        </form>
                    </div>
                </div>
            </div>
            <%--右侧内容--%>
            <div class="col-md-3 main-l">

            </div>
        </div>
    </div>
</main>



