<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
         <%--pageEncoding="UTF-8" import="java.util.*"%>--%>
<%--<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--&lt;%&ndash;<%@ page language="java" contentType="text/html; charset=UTF-8"&ndash;%&gt;--%>
         <%--&lt;%&ndash;pageEncoding="UTF-8" import="java.util.*"%>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;<main>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="container">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class=" main-t">&ndash;%&gt;--%>
            <%--&lt;%&ndash;首页 > <span>账户</span>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;左侧内容&ndash;%&gt;&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="col-md-3 main-l">&ndash;%&gt;--%>

            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;中间内容&ndash;%&gt;&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="col-md-6 main-r">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<div class="mr-in">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div style="text-align: center" class="main-rt">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;&lt;%&ndash;<img src="${pageContext.request.contextPath}/img/shamgod.gif" class="i-tdw" />&ndash;%&gt;&ndash;%&gt;--%>
                     <%--&lt;%&ndash;<p style="color: #000000;font-size: 20px;" > | 账户登录 | </p>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="main-rb">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<form action="${pageContext.request.contextPath}/login/logining" method="post">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<table>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<table>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<td style="color: #ff5c00;font-size: 20px;">账户名:</td>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<td>${login.loginAccount} </td>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<td style="color: #ff5c00;font-size: 20px;">密码:</td>&ndash;%&gt;--%>

                                        <%--&lt;%&ndash;<td>${login.loginPassword}</td>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<td style="color: #ff5c00;font-size: 20px;">昵称:</td>&ndash;%&gt;--%>

                                        <%--&lt;%&ndash;<td>${login.loginName}</td>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<td style="color: #ff5c00;font-size: 20px;">头像:</td>&ndash;%&gt;--%>

                                        <%--&lt;%&ndash;<td>${login.loginPicture}</td>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</table>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</form>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;右侧内容&ndash;%&gt;&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="col-md-3 main-l">&ndash;%&gt;--%>
                <%--&lt;%&ndash;*********&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</main>&ndash;%&gt;--%>
<%--<div style="text-align:center">--%>
    <%--<json:object>--%>
        <%--<br><br><json:array name="login" var="login" items="${login}">--%>
            <%--<json:object>--%>
                <%--<json:property name="lgoinAccount" value="${login.loginAccount}"/>--%>
                <%--<json:property name="lgoinPassword" value="${login.loginPassword}"/>--%>
                <%--&lt;%&ndash;<json:property name="updateAt" value="${stu.updateAt}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<json:property name="name" value="${stu.name}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<json:property name="qq" value="${stu.qq}"/><br><br>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<json:property name="studyType" value="${stu.studyType}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<json:property name="studyId" value="${stu.studyId}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<json:property name="joinTime" value="${stu.joinTime}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<json:property name="university" value="${stu.university}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<json:property name="dailyLink" value="${stu.dailyLink}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<json:property name="slogen" value="${stu.slogen}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<json:property name="master" value="${stu.master}"/>&ndash;%&gt;--%>
            <%--</json:object>--%>
        <%--</json:array>--%>
    <%--</json:object>--%>
<%--</div>--%>


