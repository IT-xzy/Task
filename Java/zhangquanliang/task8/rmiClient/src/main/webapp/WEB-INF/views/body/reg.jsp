<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">

    function checkPhone()
    {
        var phone =document.getElementById('phone').value;
        console.log("手机号码 = "+phone)
        var partten = /^1[3,5,6,7,8]\d{9}$/;
        if(partten.test(phone))
        {
            return true;
        }
        else
        {
            alert('请使用手机号码');
        }
    }

    function checkEmail()
    {
        var email =document.getElementById('email').value;
        console.log("邮箱 = "+email)
        var partten = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
        if(partten.test(email))
        {
            return true;
        }
        else
        {
            alert('邮箱格式不对');
        }
    }

    function sendPhone() {
        var phone =document.getElementById('phone').value;
        console.log("sendPhone: phone = " + phone);
        $.ajax({

            url: '/user/phone',
            type: 'post',
            data: {
                'phone':phone,
            },
            dataType: 'text',
            success: function (data) {
                alert(data);
                console.log("sendCaptcha ==> success: data = " + (data));
            },
            error: function (data) {
                console.log("sendCaptcha ==> error: data = " + (data));

            }
        });
    }

    function sendEmail() {
        var email =document.getElementById('email').value;
        console.log("sendEmail: email = " + email);
        $.ajax({
            url: '/user/email',
            type: 'post',
            data: {
                'email':email,
            },
            dataType: 'text',
            success: function (data) {
                alert(data);

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                // 状态码
                console.log(XMLHttpRequest.status);
                // 状态
                console.log(XMLHttpRequest.readyState);
                // 错误信息
                console.log(textStatus);
                console.log(errorThrown);
            }

        });
    }

    // 刷新图片
  /*  function changeImg() {
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", changeUrl(src));
    }
    //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function changeUrl(url) {
        var timestamp = (new Date()).valueOf();
        var index = url.indexOf("?",url);
        if (index > 0) {
            url = url.substring(index, url.indexOf(url, "?"));
        }
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }*/
</script>


<div class="container-fluid">
    <div class="row">

        <div class="rowwwwww" style="width:100%; margin: 50px;">
            <div class="col-md-6" style="text-align: center">
                <div class="col-md-6" style="padding:100px">
                    <img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png">
                </div>
            </div>

            <div class="col-md-6">
                <div class="col-md-6" style="margin:200px auto">

                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active">
                            <a href="#emailPage" data-toggle="tab">
                                邮箱注册
                            </a>
                        </li>
                        <li><a href="#phonePage" data-toggle="tab">手机注册</a></li>
                    </ul>


                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="emailPage">
                            <form method="post" action="/reg/email" >

                                <span style="color: red; font-size: x-small;"><i>${message}</i></span><br>
                                <label>用户名：</label>
                                <input type="text" name="name" value=""><br>
                                <label>密&nbsp;&nbsp;&nbsp;码：</label>
                                <input type="text" name="pwd" value="" ><br>
                                <label>邮&nbsp;&nbsp;&nbsp;箱：</label>
                                <input type="text" name="email" value="" onchange="checkEmail()" id="email"><br>
                                <input type="text" name="msgCode"  value="" placeholder="请输入邮箱验证码"> <br>
                                <button type="button" class="btn btn-primary btn-lg active" onclick="sendEmail()">获取邮箱验证码</button><br>
                                <button type="submit" class="btn btn-orange btn-lg active" >注册</button>
                                <a class="tn btn-orange"  href="/login">已有账号？去登录</a>
                            </form>
                        </div>
                        <div class="tab-pane fade" id="phonePage">
                            <form method="post" action="/reg/phone">
                                <span style="color: red; font-size: x-small;"><i>${message}</i></span><br>
                                <label>用户名：</label>
                                <input type="text" name="name" value=""><br>
                                <label>密&nbsp;&nbsp;&nbsp;码：</label>
                                <input type="text" name="pwd" value=""><br>
                                <label>手&nbsp;&nbsp;&nbsp;机：</label>
                                <input type="text" name="phone" value="" onchange="checkPhone()" id="phone"><br>
                                <input type="text" name="msgCode"  value="" placeholder="请输入手机验证码"><br>
                                <button type="button" class="btn btn-primary btn-lg active" onclick="sendPhone()">获取手机验证码</button><br>
                                <button type="submit" class="btn btn-orange btn-lg active">注册</button>
                                <a class="tn btn-orange"  href="/login">已有账号？去登录</a>
                            </form>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>




