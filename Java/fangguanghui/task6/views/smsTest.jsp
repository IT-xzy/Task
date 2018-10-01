<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/7/30
  Time: 7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>短信注册界面</title>

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">


        var param;
        var getPhone = function () {
            param = $('#phone').val();
            console.log(typeof(param));
        }
        var InterValObj; //timer变量，控制时间
        var count = 60; //间隔函数，1秒执行
        var curCount;//当前剩余秒数

        function sendMessage() {
            curCount = count;
            // 设置button效果，开始计时
            if (param==null||param.length!=11) {
                alert("请输入正确的手机号码！")
            }else{
                document.getElementById("btn").setAttribute("disabled","true" );//设置按钮为禁用状态
                document.getElementById("btn").value="请在" + curCount + "后再次获取";//更改按钮文字
                InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器timer处理函数，1秒执行一次

                // 向后台发送处理数据
                $.ajax({
                    type: "POST", // 用POST方式传输
                    dataType: " ", // 数据格式:JSON
                    url: "${pageContext.request.contextPath}/sendms", // 目标地址
                    data: {phone:param},
                    success:
                        function (result) {
                            if (result) {
                                alert("发送成功")
                            } else {
                                alert("验证码发送失败！")
                            }
                        }
                });
            }
        }

        //timer处理函数
        function SetRemainTime() {
            if (curCount == 0) {
                window.clearInterval(InterValObj);// 停止计时器
                document.getElementById("btn").removeAttribute("disabled");//移除禁用状态改为可用
                document.getElementById("btn").value="重新发送验证码";
            }else {
                curCount--;
                document.getElementById("btn").value="请在" + curCount + "秒后再次获取";
            }
        }

    </script>
</head>
<body>

                <div >
                    身份验证
                </div>
                <p id="p1"></p>
                <form name="form1" action="${pageContext.request.contextPath}/verify" method="post">

                    <div>
                        <input id="phone"  name="name" onblur="getPhone()" type="text"
                               placeholder="手机号/邮箱" autocomplete="off" value=${inExist}>
                    </div>

                    <div>
                        <input name="RandCode" id="code_btn" type="text" placeholder="验证码" value=${MsgCode}>
                        <input type="button" id="btn"  value="获取验证码" onclick="sendMessage();"/>
                    </div>

                    <div>
                        <button type="submit" >确定</button>
                    </div>

                </form>

</body>
</html>
