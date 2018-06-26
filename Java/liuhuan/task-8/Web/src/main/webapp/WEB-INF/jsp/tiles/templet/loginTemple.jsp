<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<head>
    <%-- 页面 title --%>
    <title><title:insertAttribute name="title"/></title>

        <link href="${pageContext.request.contextPath }/static/css/login.css"
              rel="stylesheet" type="text/css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--webfonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700'
              rel='stylesheet' type='text/css'>
        <!--//webfonts-->
</head>
<body>
<%-- 内容 --%>
<tiles:insertAttribute name="body"/>
</body>