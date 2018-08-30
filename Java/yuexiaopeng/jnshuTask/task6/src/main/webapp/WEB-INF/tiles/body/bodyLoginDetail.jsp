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
                        <p style="color: #000000;font-size: 20px;">| 账户信息 | </p>
                    </div>
                    <div class="main-rb">
                        <form  method="post">
                            <table>
                                <tr>
                                    <td style="color: #ff5c00;font-size: 20px;">账户名:</td>
                                    <td>${login.loginAccount} </td>
                                </tr>
                                <tr>
                                    <td style="color: #ff5c00;font-size: 20px;">密码:</td>

                                    <td>${login.loginPassword}</td>
                                </tr>
                                <tr>
                                    <td style="color: #ff5c00;font-size: 20px;">昵称:</td>

                                    <td>${login.loginName}</td>
                                </tr>
                                <tr>
                                    <td style="color: #ff5c00;font-size: 20px;">头像:</td>

                                    <td>${login.loginPicture}</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="text-align: center;color: #FFFFFF">
                                    <input style="background-color: #ff5050;color: #FFFFFF;"
                                               type="button" value="修改信息"
                                               onclick="location.href='${pageContext.request.contextPath}/login/set'">
                                </tr>
                                <tr>
                                    <td colspan="2" style="text-align: center;color: #FFFFFF">
                                        <input style="background-color: #3232ff;color: #FFFFFF;"
                                        type="button" value="退出登录"
                                        onclick="location.href='${pageContext.request.contextPath}/login/can'">
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



