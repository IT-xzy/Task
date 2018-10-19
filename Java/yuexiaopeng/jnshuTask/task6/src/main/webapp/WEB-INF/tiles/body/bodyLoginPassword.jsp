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
                        <p style="color: #000000;font-size: 20px;">| 账户设置 | </p>
                    </div>
                    <div class="main-rb">
                        <form  method="post">
                            <table>
                                <tr>
                                    <td style="color: #ff5c00;font-size: 20px;">账户名:</td>
                                    <td><input type="text" name="loginAccount" value="Your Account"></td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #999999;font-size: 11px" >
                                        提示：(8-12位),由字母数字或下划线组成，并且字母开头</td>
                                </tr>
                                <tr>
                                    <td style="color: #ff5c00;font-size: 20px;">新密码:</td>

                                    <td><input type="text" name="loginPassword" value="new password"></td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #999999;font-size: 11px" >
                                        (6-10位),由字母数字或下划线组成</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="text-align: center;color: #FFFFFF">
                                        <button style="background-color: #ff5050;"
                                                type="submit" formaction="${pageContext.request.contextPath}/login/passwording" >修改密码</button>
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



