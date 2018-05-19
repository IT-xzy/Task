
<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/4/8
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>百晓生排行榜</title>
</head>
<body>
<div style="width:1000px;margin:0px auto;text-align: center">
    <font color="blue" size="6" ><strong>英 雄 榜</strong></font><br/><br/>
    <span align="left"><form method="GET" style="display: inline" action="${pageContext.request.contextPath}/task2/person/newone">
        <input type="submit" value="新增英雄"/>
    </form></span>&nbsp;&nbsp;&nbsp;
    <span align="center">
    <form method="get" style="display: inline" action="${pageContext.request.contextPath}/task2/person/name">
       <input type="text" name="name" value="" size="10" placeholder="请输入姓名">
        <input type="submit" value="姓名查询">
    </form></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span align="right">
    <form action="${pageContext.request.contextPath}/task2/list" style="display: inline" method="get">
        <input type="submit" value="返回主页">
    </form></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
    <table align="center" border="1" cellspacing="0">
        <tr bgcolor="#a9a9a9" size="4">
            <th width="200" ><strong>姓名</strong></th>
            <th width="200" ><strong>战斗力</strong></th>
            <th width="300" ><strong>绝技</strong></th>
            <th width="150" ><strong>查看详情</strong></th>
            <th width="150" ><strong>点击删除</strong></th>
        </tr>
        <%--注意这里的遍历内容，是遍历pagemsg中的lists--%>
        <c:forEach items="${requestScope.pagemsg.lists}" var="person">
        <tr>
            <th>${person.name}</th>
            <th>${person.fightingCapacity}</th>
            <th>${person.uniqueSkill}</th>
            <th>
                <form action="${pageContext.request.contextPath}/task2/person/${person.id}" method="get">
                    <input type="submit" value="查看详情">
                </form>
            </th>
            <th><form action="${pageContext.request.contextPath}/task2/person/${person.id}" method="post">
                <input type="hidden" value="DELETE" name="_method">
                <input type="submit" value="点击删除">
            </form>
            </th>
        </tr>
    </c:forEach>
        <c:forEach items="${person}" var="person">
            <tr>
                <th>${person.name}</th>
                <th>${person.fightingCapacity}</th>
                <th>${person.uniqueSkill}</th>
                <th>
                    <form action="${pageContext.request.contextPath}/task2/person/${person.id}" method="get">
                        <input type="submit" value="查看详情">
                    </form>
                </th>
                <th><form action="${pageContext.request.contextPath}/task2/person/${person.id}" method="post">
                    <input type="hidden" value="DELETE" name="_method">
                    <input type="submit" value="点击删除">
                </form>
                </th>
            </tr>
        </c:forEach>
        <c:if test="${null==person}">
        <tr bgcolor="#add8e6">
            <%--合并横向单元格，使用td样式--%>
            <td colspan="5" class="td">
                <%--显示当前页数，requestScope.pagemsg.currentPage等价于request.getAttribute(pagemsg.currentPage)等价于${pagemsg.currentPage}--%>
                <span>第${requestScope.pagemsg.currentPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
                <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
                    <span>
                    <form  style="display: inline" action="${pageContext.request.contextPath}/task2/list">
                        <input type="text" name="currentPage" size="5" placeholder="跳转到">
                        <input type="submit" value="跳转">
                    </form>
                </span>&nbsp;&nbsp;
                    <span>
                    <%--利用此判断可以杜绝第一页还可以点击到上一页的情况，也可以在controller中设置限制条件--%>
       <c:if test="${requestScope.pagemsg.currentPage != 1}">
           <%--默认出现第一页，点击首页按钮会跳转到第一页--%>
           <a href="${pageContext.request.contextPath }/task2/list?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <%--点击上一页，currentPage属性会-1,即输入controller层中输入的参数currentPage会-1,从而实现上一页的功能--%>
           <a href="${pageContext.request.contextPath }/task2/list?currentPage=${requestScope.pagemsg.currentPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>
                        <%--避免在最后一页可以点击下一页--%>
       <c:if test="${requestScope.pagemsg.currentPage != requestScope.pagemsg.totalPage}">
           <a href="${pageContext.request.contextPath }/task2/list?currentPage=${requestScope.pagemsg.currentPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/task2/list?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
            </td>
        </tr>
        </c:if>
    </table>
</div>
<jsp:include page="footer.jsp" >
    <jsp:param  name="year" value="2018" />
</jsp:include>
</body>
</html>
