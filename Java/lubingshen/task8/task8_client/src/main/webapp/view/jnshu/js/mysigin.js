// 切换
$(function () {

    $('#switch_qlogin').click(function () {
        $('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_bottom').animate({left: '0px', width: '70px'});
        $('#qlogin').css('display', 'none');
        $('#web_qr_login').css('display', 'block');

    });
    $('#switch_login').click(function () {

        $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_bottom').animate({left: '183px', width: '70px'});

        $('#qlogin').css('display', 'block');
        $('#web_qr_login').css('display', 'none');
    });
    if (getParam("a") == '0') {
        $('#switch_login').trigger('click');
    }

});

//根据参数名获得该参数 pname等于想要的参数名
function getParam(pname) {
    var params = location.search.substr(1); // 获取参数 平且去掉？
    var ArrParam = params.split('&');
    if (ArrParam.length == 1) {
        //只有一个参数的情况
        return params.split('=')[1];
    }
    else {
        //多个参数参数的情况
        for (var i = 0; i < ArrParam.length; i++) {
            if (ArrParam[i].split('=')[0] == pname) {
                return ArrParam[i].split('=')[1];
            }
        }
    }
}

// 手机号码注册验证，渲染

$(document).ready(function () {

        $('#phreg').click(function () {

            if ($('#puser').val() == '') {
                $('#puser').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("<font color='red'><b>请输入用户名</b></font>");
                return false;
            }

            if ($('#puser').val().length < 4 || $('#puser').val().length > 10) {

                $('#puser').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("<font color='red'><b>用户名位4-10字符</b></font>");
                return false;
            }
            if ($('#phpasswd').val().length < 6) {
                $('#phassword').focus();
                $('#userCue').html("<font color='red'><b>密码不能小于6位</b></font>");
                return false;
            }
            if ($('#phpasswd').val().length > 20) {
                $('#phassword').focus();
                $('#userCue').html("<font color='red'><b>密码不能大于20位</b></font>");
                return false;
            }
            if ($('#phpasswd').val() != $('#phpasswd2').val()) {
                $('#passwd2').focus();
                $('#userCue').html("<font color='red'><b>两次密码不一致</b></font>");
                return false;
            }
            if ($('#phoneNum').val() == '') {

                $('#phoneNum').focus();
                $('#userCue').html("<font color='red'><b>请输入手机号</b></font>");
            }

            if ($('#phoneCode').val() == '') {
                $('#phoneCode').focus();
                $('#userCue').html("<font color='red'><b>请获取验证码</b></font>");
                return false;
            }

            var info;
            var code;

            $.ajax({
                type: 'POST',
                url: '/a/cellphone/check',
                dataType: 'json',
                data: {userName: $('#puser').val(), cellphone: $('#phoneNum').val(), phoneCode: $('#phoneCode').val()},
                async: false,
                success: function (data) {
                    console.log(data);
                    code = data.code;
                    info = data.info;
                }
            });


            if (code != "ok") {
                $('#phoneCode').focus();
                $('#userCue').html("<font color='red'><b>" + info + "</b></font>");
                return false;
            }

        })
    }
)

// 邮箱号码注册验证，渲染

$(document).ready(function () {

    $('#emailreg').click(function () {
        if ($('#euser').val() == '') {
            $('#euser').focus().css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $('#euserCue').html("<font color='red'><b>请输入用户名</b></font>");
            return false;
        }

        if ($('#euser').val().length < 4 || $('#euser').val().length > 10) {

            $('#euser').focus().css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $('#euserCue').html("<font color='red'><b>用户名位4-10字符</b></font>");
            return false;
        }
        if ($('#epasswd').val().length < 6) {
            $('#epasswd').focus();
            $('#euserCue').html("<font color='red'><b>密码不能小于6位</b></font>");
            return false;
        }
        if ($('#epasswd').val().length > 20) {
            $('#epasswd').focus();
            $('#euserCue').html("<font color='red'><b>密码不能大于20位</b></font>");
            return false;
        }
        if ($('#epasswd').val() != $('#epasswd2').val()) {
            $('#epasswd2').focus();
            $('#euserCue').html("<font color='red'><b>两次密码不一致</b></font>");
            return false;
        }

        if ($('#email').val() == '') {
            $('#email').focus();
            $('#euserCue').html("<font color='red'><b>请输入邮箱注册</b></font>");
            return false;
        }
        var myRegEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
        if (!myRegEmail.test($('#email').val())) {
            $('#epasswd2').focus();
            $('#euserCue').html("<font color='red'><b>邮箱格式错误</b></font>");
            return false;
        }
        var rescode;
        var resinfo;
        $.ajax({
            type: 'POST',
            url: '/a/mail/link',
            dataType: 'json',
            data: {name: $('#euser').val(), key: $('#epasswd').val(), mailbox: $('#email').val()},
            async: false,
            success: function (data) {
                console.log(data);
                rescode = data.code;
                resinfo = data.info;
            }
        });
        if (rescode != "ok") {
            $('#euserCue').html("<font color='red'><b>" + resinfo + "</b></font>");
            return false;
        }
    })
})

// 手机验证码生成，校验

$(document).ready(function () {

        $('#phqyzm').click(function () {

            var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0-9]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
            var nameReg = /[^a-zA-Z0-9一-龥]/;

            if ($('#puser').val() == '') {
                $('#puser').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("<font color='red'><b>请输入用户名</b></font>");
                return false;
            }

            if (nameReg.test($('#puser').val())) {

                $('#puser').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("<font color='red'><b>用户名不能含有非法字符</b></font>");
                return false;
            }

            if ($('#puser').val().length < 4 || $('#puser').val().length > 10) {

                $('#puser').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("<font color='red'><b>用户名位4-10字符</b></font>");
                return false;
            }
            if ($('#phpasswd').val().length < 6) {
                $('#phassword').focus();
                $('#userCue').html("<font color='red'><b>密码不能小于6位</b></font>");
                return false;
            }
            if ($('#phpasswd').val().length > 20) {
                $('#phassword').focus();
                $('#userCue').html("<font color='red'><b>密码不能大于20位</b></font>");
                return false;
            }
            if ($('#phpasswd').val() != $('#phpasswd2').val()) {
                $('#passwd2').focus();
                $('#userCue').html("<font color='red'><b>两次密码不一致</b></font>");
                return false;
            }

            if ($('#phoneNum').val() == '') {

                $('#phoneNum').focus();
                $('#userCue').html("<font color='red'><b>请输入手机号</b></font>");
                return false;
            }

            if (!myreg.test($('#phoneNum').val())) {
                $('#phoneNum').focus();
                $('#userCue').html("<font color='red'><b>手机号不存在，请再次确认</b></font>");
                return false;
            }

            $.post("/a/cellphone/code", {
                cellphone: $('#phoneNum').val(),
                userName: $('#puser').val()
            }, function (data, status) {
                var obj = JSON.parse(data);
                var code = obj.code;
                var info = obj.info;
                $('#userCue').html
                ("<font color= '#D4A838'><b>" + info + "</b></font>");
                console.log(data);
                console.log("status:" + status);
            });


        })
    }
)

// 邮箱注册填写校验

$(document).ready(function () {
    //————用户名输入框失去焦点

    $('#euser').blur(function () {

        if ($('#euser').val() != '') {

            var nameReg = /[^a-zA-Z0-9一-龥]/;

            if (nameReg.test($('#euser').val())) {

                $('#euser').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#euserCue').html("<font color='red'><b>用户名不能含有非法字符</b></font>");
                return false;
            } else {
                $.ajax({
                    type: 'POST',
                    url: '/a/mail/check',
                    dataType: 'json',
                    data: {userName: $('#euser').val(), mail: $('#email').val()},
                    async: true,
                    success: function (data) {
                        var code = data.code;
                        var info = data.info;
                        if (code != "ok") {
                            $('#euser').focus();
                            $('#euserCue').html("<font color='red'><b>" + info + "</b></font>");
                        }
                    }
                })
            }


        }


    })

    //—————邮箱输入框失去焦点
    $('#email').blur(function () {

        if ($('#email').val() != '') {
            var myRegEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
            if (!myRegEmail.test($('#email').val())) {
                $('#euserCue').html("<font color='red'><b>邮箱格式错误</b></font>");
                return false;
            } else {

                $.ajax({
                    type: 'POST',
                    url: '/a/mail/check',
                    dataType: 'json',
                    data: {userName: $('#euser').val(), mail: $('#email').val()},
                    async: true,
                    success: function (data) {
                        var code = data.code;
                        var info = data.info;
                        if (code != "ok") {
                            $('#euser').focus();
                            $('#euserCue').html("<font color='red'><b>" + info + "</b></font>");
                        }
                    }
                })
            }
        }


    })
})


