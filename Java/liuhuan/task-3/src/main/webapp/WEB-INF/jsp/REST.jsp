<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" >
    <title>REST风格测试</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    //json插入请求
    function insertJson(){
        $.ajax({
            type:'PUT',
            url:'${pageContext.request.contextPath}/rest/api/',
            contentType:'application/json;charset=utf-8',
            // dataType:'json',
            //数据格式是json串,用户信息
            data:'{"username":"王五","qq":"1756513254","profession":"UI","join_date":1523883709,"school":"武汉大学","online_id":"3879","daily_url":"www.google.com","declaration":null,"counselor":"加油","create_time":1523883709,"update_time":1523883709}',
            success:function(data){//返回json结果
                    alert("json格式创建请求已发送执行结果为:\n" + data);
            }
        });
    }
    //json插入错误请求
    function insertJsonError(){
        $.ajax({
            type:'PUT',
            url:'${pageContext.request.contextPath}/rest/api/',
            contentType:'application/json;charset=utf-8',
            // dataType:'json',
            //数据格式是json串,用户信息
            data:'{"username":"王五王五王五王五王五王五王五王五王五王五王五王五王五王五王五王五","qq":"1756513254","profession":"js","school":"武汉大学","online_id":"3879","daily_url":"www.google.com","declaration":null,"counselor":"加油"}',
            success:function(data){//返回json结果
                alert("json格式创建请求已发送执行结果为:\n" + data);
            }
        });
    }

    //key/value插入请求
    function insertKey() {
        $.ajax({
            type: 'PUT',
            url: '${pageContext.request.contextPath}/rest/api/key/',
            //请求的是key/value，这里不需要指定contentType，因为默认就是key/value类型
            //数据格式是 key/value
            /* 注意 key/value 发送时sping会使用自动转换来处理传入数据,这里的时间格式必须使用转换后的时间格式,否则自动转换时会失败*/
            data: 'username=王五&qq=1756513254&profession=JAVA&join_date=2018-04-17 22:33:48&create_time=2018-04-17 22:33:48&update_time=2018-04-17 22:33:48',
            success: function (data) {//返回json结果
                alert("key/value格式创建请求已发送执行结果为:\n" + data);
            }
        });
    }
    //key/value插入错误请求
    function insertKeyError() {
        $.ajax({
            type: 'PUT',
            url: '${pageContext.request.contextPath}/rest/api/key/',
            //请求的是key/value，这里不需要指定contentType，因为默认就是key/value类型
            //数据格式是 key/value
            /* 注意 key/value 发送时sping会使用自动转换来处理传入数据,这里的时间格式必须使用转换后的时间格式,否则自动转换时会失败*/
            data: 'username=王五王五王五王五王五王五王五王五王五&qq=1756513254&profession=ki',
            success: function (data) {//返回json结果
                alert("key/value格式创建请求已发送执行结果为:\n" + data);
            }
        });
    }

        //json更新请求
        function updateJson(){
        //获取id为updateId的值
        var id = $("#updateId")[0].value;
            $.ajax({
                type:'POST',
                url:'${pageContext.request.contextPath}/rest/api/' + id,
                /* 如果是 key/value 格式,不需要声明,因为接收的时候并不是json格式的 */
                contentType:'application/json;charset=utf-8',
                //数据格式是 key/value
                /* 注意 json格式发送的数据是自动映射到对象属性的.spring不会进行数据转换处理*/
                data:'{"username":"王五","qq":"1756513254","profession":"UI","join_date":1523883709,"school":"武汉大学","online_id":"3879","daily_url":"www.google.com","declaration":null,"counselor":"加油","create_time":1523883709,"update_time":1523883709}',
                success:function(data){//返回json结果
                    alert("json格式更新请求已发送执行结果为:\n" + data);
                }
            });
        }
    //json更新错误请求
    function updateJsonError(){
        //获取id为updateId的值
        var id = $("#updateId")[0].value;
        $.ajax({
            type:'POST',
            url:'${pageContext.request.contextPath}/rest/api/' + id,
            /* 如果是 key/value 格式,不需要声明,因为接收的时候并不是json格式的 */
            contentType:'application/json;charset=utf-8',
            //数据格式是 key/value
            /* 注意 json格式发送的数据是自动映射到对象属性的.spring不会进行数据转换处理*/
            data:'{"username":"王五王五王五王五王五王五王五王五王五王五王五","qq":"1756513254","profession":"js","join_date":1523883709,"school":"武汉大学","online_id":"0","daily_url":"www.google.com","declaration":null,"counselor":"加油","create_time":1523883709,"update_time":1523883709}',
            success:function(data){//返回json结果
                alert("json格式更新请求已发送执行结果为:\n" + data);
            }
        });
    }
    //key/value更新请求
    function updateKey() {
        var id = $("#updateId")[0].value;
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/rest/api/key/' + id,
            //请求的是key/value，这里不需要指定contentType，因为默认就是key/value类型
            //数据格式是 key/value
            /* 注意 key/value 发送时sping会使用自动转换来处理传入数据,这里的时间格式必须使用转换后的时间格式,否则自动转换时会失败*/
            data: 'username=王五&qq=1756513254&join_date=2018-04-17 22:33:48',
            success: function (data) {//返回json结果
                alert("key/value更新创建请求已发送执行结果为:\n" + data);
            }
        });
    }

    //key/value更新请求
    function updateKeyError() {
        var id = $("#updateId")[0].value;
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/rest/api/key/' + id,
            //请求的是key/value，这里不需要指定contentType，因为默认就是key/value类型
            //数据格式是 key/value
            /* 注意 key/value 发送时sping会使用自动转换来处理传入数据,这里的时间格式必须使用转换后的时间格式,否则自动转换时会失败*/
            data: 'username=王五王五王五王五王五王五王五王五王五王五王五&online_id=0&profession=js',
            success: function (data) {//返回json结果
                alert("key/value更新创建请求已发送执行结果为:\n" + data);
            }
        });
    }
</script>
<body>
<input type="button" onclick="insertJson()" value="json 格式插入数据"/>
<input type="button" onclick="insertKey()" value="key/value 格式插入数据"/>
<br>
<input type="button" onclick="insertJsonError()" value="json 格式插入数据效验错误测试"/>
<input type="button" onclick="insertKeyError()" value="key/value 格式插入数据"/>
<hr>
更新id: <input type="text" id="updateId" value="131">
<br>
<input type="button" onclick="updateJson()" value="json 更新数据"/>
<input type="button" onclick="updateKey()" value="key/value 更新数据"/>
<br>
<input type="button" onclick="updateJsonError()" value="json 更新错误数据"/>
<input type="button" onclick="updateKeyError()" value="key/value 更新错误数据"/>
</body>
</html>