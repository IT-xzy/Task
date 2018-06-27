<%--
  Created by IntelliJ IDEA.
  User: zpyt5
  Date: 2018/5/16
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>REST风格api测试</title>
</head>
<script type="text/javascript"
        src="${pageContext.request.contextPath }/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    //请求的是json，返回插入id
    function requestJson() {
        $.ajax({
            type: 'PUT',
            url: '${pageContext.request.contextPath}/rest/api/',
            contentType: 'application/json;charset=utf-8',
            // dataType:'json',
            //数据格式是json串,用户信息
            data: '{"username":"王五","qq":"1756513254","profession":"UI","join_date":1523883709,"school":"武汉大学","online_id":"3879","daily_url":"www.google.com","declaration":null,"counselor":"加油","create_time":1523883709,"update_time":1523883709}',
            success: function (data) {//返回json结果
                if (data > 0) {
                    alert("json格式创建成功,id为:" + data);
                } else alert("创建失败")
            }
        });
    }
    //请求是key/value，返回插入id
    function requestJson2() {
        $.ajax({
            type: 'PUT',
            url: '${pageContext.request.contextPath}/rest/api/key/',
            //请求的是key/value，这里不需要指定contentType，因为默认就是key/value类型
            //数据格式是 key/value
            /* 注意 key/value 发送时sping会使用自动转换来处理传入数据,这里的时间格式必须使用转换后的时间格式,否则自动转换时会失败*/
            data: 'username=王五&qq=1756513254&join_date=2018-04-17 22:33:48',
            success: function (data) {//返回json结果
                if (data > 0) {
                    alert("key/value 格式创建成功,id为:" + data);
                } else alert("创建失败")
            }
        });
    }
    //请求是json，返回bool
    function requestJson3() {
        //获取id为updateId的值
        var id = $("#updateId")[0].value;
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/rest/api/' + id,
            /* 如果是 key/value 格式,不需要声明,因为接收的时候并不是json格式的 */
            contentType: 'application/json;charset=utf-8',
            //数据格式是 key/value
            /* 注意 json格式发送的数据是自动映射到对象属性的.spring不会进行数据转换处理*/
            data: '{"username":"王五","qq":"1756513254","profession":"UI","join_date":1523883709,"school":"武汉大学","online_id":"3879","daily_url":"www.google.com","declaration":null,"counselor":"加油","create_time":1523883709,"update_time":1523883709}',
            success: function (data) {//返回json结果
                if (data) {
                    alert("json 格式更新成功,id为:" + id);
                } else alert("更新失败")
            }
        });
    }
    //请求是key/value，返回bool
    function requestJson4() {
        var id = $("#updateId")[0].value;
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/rest/api/key/' + id,
            //请求的是key/value，这里不需要指定contentType，因为默认就是key/value类型
            //数据格式是 key/value
            /* 注意 key/value 发送时sping会使用自动转换来处理传入数据,这里的时间格式必须使用转换后的时间格式,否则自动转换时会失败*/
            data: 'username=王五&qq=1756513254&join_date=2018-04-17 22:33:48',
            success: function (data) {//返回json结果
                if (data > 0) {
                    alert("key/value 格式更新成功,id为:" + id);
                } else alert("更新失败")
            }
        });
    }
</script>
<body>
<input type="button" onclick="requestJson()" value="json 格式插入数据"/>
<input type="button" onclick="requestJson2()" value="key/value 格式插入数据"/>
<hr>
<input type="text" id="updateId">
<input type="button" onclick="requestJson3()" value="json 更新入数据"/>
<input type="button" onclick="requestJson4()" value="key/value 更新入数据"/>
</body>
</html>