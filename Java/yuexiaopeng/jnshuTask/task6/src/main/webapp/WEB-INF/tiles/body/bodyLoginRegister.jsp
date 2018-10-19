<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<main>
    <%--定义一个简单的css style--%>

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
                        <p style="color: #000000;font-size: 20px;" > | 账户注册 | </p>
                    </div>
                    <div class="main-rb">
                        <form action="${pageContext.request.contextPath}/login/registering" method="post">
                            <table>
                                <tr>
                                    <td style="color: #ff5c00;font-size: 20px;">账户名:</td>
                                    <td><input type="text" name="loginAccount" value=""></td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #999999;font-size: 11px;">
                                (8-12位),由字母数字或下划线组成，必须字母开头</td>
                                </tr>
                                <tr>
                                    <td style="color: #ff5c00;font-size: 20px;">账户密码:</td>

                                    <td><input type="text" name="loginPassword" value=""></td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #999999;font-size: 11px" >
                                (6-10位),由字母数字或下划线组成</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="text-align: center;color: #FFFFFF">
                                    <input style="background-color: #ff5050;"
                                           type="button" value="注册" onclick="submit()">
                                </tr>
                            </table>
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



