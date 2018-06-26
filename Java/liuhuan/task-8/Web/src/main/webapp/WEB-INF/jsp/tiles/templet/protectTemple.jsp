<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<head>
    <title><title:insertAttribute name="title"/></title>
    <%-- 添加样式 --%>
    <style>
        table, table td, table th {
            border: 1px solid;
            border-collapse: collapse;
            text-align: center;
        }
        table{
            table-layout:fixed;
        }
        td{
            width:100%;
            word-break:keep-all;/* 不换行 */
            white-space:nowrap;/* 不换行 */
            overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */
            /*text-overflow:ellipsis;!* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用*!*/
        }

        input {
            width: 100%;
            text-align: center;
            padding-left: 2px
        }

        #name, #name2 {
            width: 95%;
            text-align: center;
            padding-left: 2px
        }
    </style>
</head>

<html>
<tiles:insertAttribute name="body"/>
<%-- Sprict--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.4.4.min.js"></script>--%>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</html>