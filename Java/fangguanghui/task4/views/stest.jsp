<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/7/23
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


     <%
               pageContext.setAttribute("name","xxx");
               request.setAttribute("name","yyy");
            %>
           <br>
        pageContext.findAttribute("name"): <%= pageContext.findAttribute("name") %>      <br>
        EL:${name }
        <hr>
        pageContext.getAttribute("name",pageContext.REQUEST_SCOPE):<%=pageContext.getAttribute("name",pageContext.REQUEST_SCOPE) %><br>
        EL: ${requestScope.name }
        <br>
        <hr>
        pageContext.getAttribute("age"):<%=pageContext.getAttribute("age") %><br>
        EL: ${age}


</body>
</html>
