<%@ page  isELIgnored = "false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div align="center">
    </br>
    </br>
    <h2>欢迎进入修真院学生信息分页查询主页</h2>
    <form action="/students" method="get">
        <input type="hidden" name="currPage" value="1">
        每页显示学生信息数：<input type="text" name="pageSize"  value="10">
        </br>
        <span style="font-size:24px;color:red;">${msg}</span>
        </br>
        </br>
        <button type="submit">查询所有学生信息</button>
    </form>
</div>
</body>
</html>
