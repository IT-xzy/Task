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
                     <p style="color: #000000;font-size: 20px;" > | 失败!!! | </p>
                    </div>
                    <div class="main-rb">

                            <table>

                                <tr>
                                    <td colspan="2" style="color: #ff5050;font-size: 14px" >
                                         what???是忘记密码了??
                                        <a href="${pageContext.request.contextPath}/login/log" />点点点我</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #ff5050;font-size: 14px" >
                                        what???是修改内容格式错误了??
                                        <a href="${pageContext.request.contextPath}/login/set" />点点点我</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #ff5050;font-size: 14px" >
                                        what???不知道怎么过来了??，回首页吧...
                                        <a href="${pageContext.request.contextPath}/home" />点点点我</td>
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



