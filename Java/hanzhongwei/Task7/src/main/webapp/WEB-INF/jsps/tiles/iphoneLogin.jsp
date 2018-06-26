<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/6/4
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<h2 align="center">登录界面</h2>
<form name=form1 action="/iphoneLogin" method="post" onsubmit="return isValidate(form1)">
    <table align="center">
        <tr>
            <td>手机号：</td>
            <td><input type="text" id="mobile" value="请输入手机号码" name="userIphone"
                       onfocus="if (this.value == '请输入手机号码') {this.value = '';}"
                       onblur="if (this.value == '') {this.value = '请输入手机号码';}">
            </td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input disabled="disabled" id="code" class="inputCode" type="text" value="请先获取验证码" name="code"
                       onfocus="if (this.value == '请输入验证码') {this.value = '';}"
                       onblur="if (this.value == '') {this.value = '请输入验证码';}">
                <input class="btn" type="button" value="获取验证码">
            </td>
        </tr>
        <tr>
            <td><input type="button"  value="注册" onclick="location.href='/main2'"></td>
            <td><input type="reset" value="重置"></td>
            <td><input type="reset" value="使用账号登录" onclick="location.href='/main'"></td>
            <td><input type="submit" value="确定"></td>
        </tr>
    </table>
</form>

<%--<script>
    $(".btn").click(function () {
        var iphone = $("#mobile").val();
        console.log(typeof(iphone));
        $.ajax({
            /*url也可以是json之类的文件等等*/
            url: '${pageContext.request.contextPath }/SMS',
            type: 'POST', /*DELETE、POST */
            data:'userIphone=' + iphone,
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
    })
</script>--%>


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
                data:'userIphone=' + $("#mobile").val(),
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
