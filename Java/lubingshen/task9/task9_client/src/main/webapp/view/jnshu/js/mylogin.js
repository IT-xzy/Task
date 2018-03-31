$(document).ready(function () {

    $('#login_button').click(function () {
        if ($('#name').val() == '') {
            $('#name').focus().css({
                border: "1px solid ",
                boxShadow: "0 0 2px "
            });
            $('#loginCue').html("<font color='#B03469'><b>请输入用户名</b></font>");
            return false;
        }

        if ($('#password').val() == '') {
            $('#password').focus().css({
                border: "1px solid ",
                boxShadow: "0 0 2px "
            });
            $('#loginCue').html("<font color='#B03469'><b>请输入密码</b></font>");
            return false;
        }
        var myRegEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
        var myRegPhone = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0-9]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
        //如果是手机号
        if (myRegPhone.test($('#name').val())) {
            console.log($('#name').val());

            $.ajax({
                type: 'POST',
                url: '/a/login',
                dataType: 'json',
                data: {definition: $('#name').val(), key: $('#password').val(), type: "cellphone"},
                async: true,
                success: function (data) {
                    console.log(data)
                    var code = data.code;
                    var info = data.info;
                    if (code == "ok") {
                        $('#loginCue').html("<font color='#1e941e'><b>√ 登录成功 </b></font>");
                        location.href = "/a/home"
                    } else {
                        $('#loginCue').html("<font color='#B00A08'><b>" + info + "</b></font>");
                        return false;
                    }
                }
            })

        }
        // 如果是邮箱号码
        if (myRegEmail.test($('#name').val())) {
            console.log($('#name').val());
            $.ajax({
                type: 'POST',
                url: '/a/login',
                dataType: 'json',
                data: {definition: $('#name').val(), key: $('#password').val(), type: "mail"},
                async: true,
                success: function (data) {
                    console.log(data)
                    var code = data.code;
                    var info = data.info;
                    if (code == "ok") {
                        $('#loginCue').html("<font color='#1e941e'><b>√ 登录成功 </b></font>");
                        location.href = "/a/home"
                    } else {
                        $('#loginCue').html("<font color='#B00A08'><b>" + info + "</b></font>");
                        return false;
                    }
                }

            })
        }
        //如果是用户名
        if (!myRegPhone.test($('#name').val()) && !myRegEmail.test($('#name').val())) {

            if ($('#name').val().length < 4 || $('#name').val().length > 10) {

                $('#loginCue').html("<font color='#B00A08'><b>用户名4-10位</b></font>");
                return false;
            }
            if ($('#password').val().length < 6 || $('#password').val().length > 20) {

                $('#loginCue').html("<font color='#B00A08'><b>密码长度错误</b></font>");
                return false;
            }
            console.log($('#name').val());
            $.ajax({
                type: 'POST',
                url: '/a/login',
                dataType: 'json',
                data: {definition: $('#name').val(), key: $('#password').val(), type: "userName"},
                async: true,
                success: function (data) {
                    console.log(data)
                    var code = data.code;
                    var info = data.info;
                    if (code == "ok") {
                        $('#loginCue').html("<font color='#1e941e'><b>√ 登录成功 </b></font>");
                        location.href = "/a/home"
                    } else {
                        $('#loginCue').html("<font color='#B00A08'><b>" + info + "</b></font>");
                        return false;
                    }
                }
            })
        }

    })
    $('#name').focus(function () {
        $('#loginCue').html("<font color='#B03469'><b>帐号：用户名/手机号/邮箱</b></font>");
    })
})