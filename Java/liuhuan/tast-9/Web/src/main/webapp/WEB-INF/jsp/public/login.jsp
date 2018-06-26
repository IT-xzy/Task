<%@ page import="java.net.URLDecoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/5/14
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 登陆模块 --%>
<c:if test="${cookie.username.value!=null }">
    <%!String username = "请输入用户名"; %>
    <%
        Cookie[] cookies = request.getCookies();
        for(int i = 0 ; i < cookies.length ; i++){
            if(cookies[i].getName().equals("username")){
                username = cookies[i].getValue();
                break;
            }
        }
    %>
</c:if>

<!-----start-main---->
<div class="main">
    <div class="login-form">
        <h1>后台登陆</h1>
        <div class="head">
            <img src="${pageContext.request.contextPath }/static/images/user.png"
                 alt=""/>
        </div>
        <form action="${pageContext.request.contextPath }/validate" method="post">
            <input type="text" name="au_username" value="<%=URLDecoder.decode(username) %>"
            <%-- 光标选中 如果是默认字符串 不显示内容 --%>
                   onfocus="if (this.value == '<%=URLDecoder.decode(username) %>') {this.value = '';}"
            <%-- 失去焦点 value为空 显示内容 --%>
                   onblur="if (this.value == '') {this.value = '<%=URLDecoder.decode(username) %>';}">
            <input type="password" value="Password" name="au_password"
                   onfocus="if (this.value == 'Password') {this.value = '';}"
                   onblur="if (this.value == '') {this.value = 'Password';}">
            <input type="text" id="mobile" value="请输入手机号码" name="telephone"
                   onfocus="if (this.value == '请输入手机号码') {this.value = '';}"
                   onblur="if (this.value == '') {this.value = '请输入手机号码';}">
            <input disabled="disabled" id="code" class="inputCode" type="text" value="请先获取验证码" name="code"
                       onfocus="if (this.value == '请输入验证码') {this.value = '';}"
                       onblur="if (this.value == '') {this.value = '请输入验证码';}">
            <input class="btn" type="button" value="获取验证码">
            <div class="submit">
                <input type="submit" value="登陆">
            </div>
            <p><a href="#">忘记密码 ?</a></p>
        </form>
    </div>
    <!--//End-login-form-->
    <!-----start-copyright---->
    <div class="copy-right">
        <p>Template by <a
                href="${pageContext.request.contextPath }/">.技能树.</a></p>
    </div>
    <!-----//end-copyright---->
</div>
<!-----//end-main---->
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.4.4.min.js"></script>
<script>
    $(function(){
        $(".btn").click(function(){
            var disabled = $(".btn").attr("disabled");
            if(disabled){
                return false;
            }
            if($("#mobile").val() == "" || isNaN($("#mobile").val()) || $("#mobile").val().length != 11 ){
                alert("请填写正确的手机号！");
                return false;
            }
            var _inpdisabled = $(".inputCode");
            var url = '${pageContext.request.contextPath }/SMS';
            /*得到href的值*/
            $.ajax({
                url: url, /*url也可以是json之类的文件等等*/
                type: 'POST', /*DELETE、POST */
                data:'telePhone=' + $("#mobile").val(),
                success: function (result) {
                    //判断result结果
                    if (result) {
                        console.log(result);
                        /* 放开Code 输入框 */
                        _inpdisabled.attr("disabled",false);
                        _inpdisabled.val("请输入验证码");
                        settime();
                    } else {
                        alert("短信发送失败!")
                    }
                }
            });
        });
        var countdown=60;
        var _get_code = $(".btn");

        function settime() {
            if (countdown == 0) {
                _get_code.attr("disabled",false);
                _get_code.val("获取验证码");
                countdown = 60;
                return false;
            } else {
                $(".btn").attr("disabled", true);
                _get_code.val("重新发送(" + countdown + ")");
                countdown--;
            }
            setTimeout(function() {
                settime();
            },1000);
        }
    })
</script>