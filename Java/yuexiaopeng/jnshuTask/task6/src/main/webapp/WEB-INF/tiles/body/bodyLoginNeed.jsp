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
                     <p style="color: #000000;font-size: 20px;" > | 需要什么来着?? | </p>
                    </div>
                    <div class="main-rb">

                            <table>

                                <tr>
                                    <td colspan="2" style="color: #ff5050;font-size: 16px" >
                                         what???登录!!
                                        <a href="${pageContext.request.contextPath}/login/log" />点点点我登录</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #3232ff;font-size: 16px" >
                                        what???么有账号!!
                                        <a href="${pageContext.request.contextPath}/login/reg" />点点点我注册</td>
                                </tr>
                            </table>

                    </div>
                </div>
            </div>
            <%--右侧内容--%>
            <div class="col-md-3 main-l">

            </div>
        </div>
    </div>
</main>



