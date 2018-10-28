<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <title>添加学生信息</title>
    <%--统一样式--%>
    <style>
        label {display:inline-block; width: 10em; margin-right: 1em; text-align: right; }
    </style>
    <title>Document</title>
</head>
<body>


<div>
    <form  action="${pageContext.request.contextPath}/student" method="post">

        <!-- 将POST请求转化为PUT请求 -->
        <input type="hidden" name="_method" value="PUT"/>
        <input type="hidden" name="createAt" value="<%=System.currentTimeMillis()%>">
        <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>">

        <%--
          解决数据库中字段全为not null 时，表单中string类型----默认为字符长度为0，不是null,可以正常提交
          而int,long基本类型，没有默认值，要求必填，不填的话，页面400错误，同时数据库操作失败

          required 属性 要求必填或者必选，是html5的新特性·
          oninvalid="this.setCustomValidity('请输入姓名')" ------在字段无效时显示自定义消息
          oninput="setCustomValidity('')"---------------------- 删除经过验证的字段上的invalidate消息 --%>


        <label>姓名：</label><input name="name" type="text" required=""
                                 oninvalid="this.setCustomValidity('请输入姓名')" oninput="setCustomValidity('')" />
        <br/>
        <label>QQ：</label><input type="text" name="qq"  required="" maxlength="15"
                                 oninvalid="this.setCustomValidity('请输入qq')" oninput="setCustomValidity('')" />
        <br/>
        <label>修真类型：</label><input type="text" name="profession" required=""
                                   oninvalid="this.setCustomValidity('修正类型不能为空')" oninput="setCustomValidity('')" />
        <br/>
        <label>入学时间：</label><input type="date"  name="startTime" required=""
                                   oninvalid="this.setCustomValidity('入学时间不能为空')" oninput="setCustomValidity('')"/>
        <br/>
        <label>毕业院校：</label><input type="text" name="graduatedFrom"  required=""
                                   oninvalid="this.setCustomValidity('毕业院校不能为空')" oninput="setCustomValidity('')"/>
        <br/>

        <label>学号：</label><input type="number" name="onlineId" min="1" max="2147483647" required />

        <br/>
        <label>日报连接：</label><input type="text" name="dailyLink"  required=""
                                   oninvalid="this.setCustomValidity('日报链接不能为空')" oninput="setCustomValidity('')"/>
        <br/>
        <label>立愿：</label><input type="text" name="wish"  required=""
                                 oninvalid="this.setCustomValidity('立愿不能为空')" oninput="setCustomValidity('')"/>
        <br>
        <label>辅导师兄：</label><input type="text" name="counselor"  required=""
                                   oninvalid="this.setCustomValidity('辅导师兄不能为空')" oninput="setCustomValidity('')"/>
        <br/>
        <label>哪里知道修真院：</label><input type="text" name="way"  required=""
                                      oninvalid="this.setCustomValidity('了解方式不能为空')" oninput="setCustomValidity('')"/>
        <br/>
        <label></label><input id="btn" type="submit" name="ok" value="保存"/><input type="reset" name="r" value="清空">
    </form>

</div>

</body>
</html>
