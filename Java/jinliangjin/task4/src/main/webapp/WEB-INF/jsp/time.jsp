<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="ltd" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>times</title>
</head>
<body>
<h1>
    时间1：${date1}&nbsp;&nbsp;直接输出date类型的时间。<br/>
    时间2：${date2}&nbsp;&nbsp;通过工具类格式化date类型的时间。<br/>
    时间3：${date3}&nbsp;&nbsp;直接输出Long类型的时间。<br/>
    时间4：<ltd:dateTag value="${date3}"/>&nbsp;&nbsp;通过自定义标签格式化String类型的时间。<br/>
    时间5：${date4}&nbsp;&nbsp;通过工具类格式化Long类型的时间。<br/>
    时间6：<fmt:formatDate value="${date5}" type="date" />&nbsp;&nbsp;通过fmt格式化date型时间,输出日期。<br/>
    时间7：<fmt:formatDate value="${date6}" type="time" />&nbsp;&nbsp;通过fmt格式化date型时间,输出时间。<br/>
    时间8：<fmt:formatDate value="${date7}" type="both" />&nbsp;&nbsp;通过fmt格式化date型时间,输出日期和时间。<br/>
</h1>
</body>
</html>