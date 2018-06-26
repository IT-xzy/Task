<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/20
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>bootstrap用户注册界面表单验证-jq22.com</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <style>
        /* track base Css */
        .container {
            margin-top:15px;
        }
        .red {
            color:red;
        }
        #ehong-code-input {
            width:42px;
            letter-spacing:2px;
            margin:0px 8px 0px 0px;
        }
        .ehong-idcode-val {
            position:relative;
            padding:1px 4px 1px 4px;
            top:0px;
            *top:-3px;
            letter-spacing:4px;
            display:inline;
            cursor:pointer;
            font-size:16px;
            font-family:"Courier New",Courier,monospace;
            text-decoration:none;
            font-weight:bold;
        }
        .ehong-idcode-val0 {
            border:solid 1px #A4CDED;
            background-color:#ECFAFB;
        }
        .ehong-idcode-val1 {
            border:solid 1px #A4CDED;
            background-color:#FCEFCF;
        }
        .ehong-idcode-val2 {
            border:solid 1px #6C9;
            background-color:#D0F0DF;
        }
        .ehong-idcode-val3 {
            border:solid 1px #6C9;
            background-color:#DCDDD8;
        }
        .ehong-idcode-val4 {
            border:solid 1px #6C9;
            background-color:#F1DEFF;
        }
        .ehong-idcode-val5 {
            border:solid 1px #6C9;
            background-color:#ACE1F1;
        }
        .ehong-code-val-tip {
            font-size:12px;
            color:#1098EC;
            top:0px;
            *top:-3px;
            position:relative;
            margin:0px 0px 0px 4px;
            cursor:pointer;
        }
    </style>
</head>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <form action="http://wwww.baidu.com" class="">

            <div class="form-group has-feedback">
                <label for="username">用户名</label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input id="username" class="form-control" placeholder="请输入用户名" maxlength="20" type="text">
                </div>

                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class=" glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <label for="password">密码</label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="password" class="form-control" placeholder="请输入密码" maxlength="20" type="password">
                </div>

                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <label for="passwordConfirm">确认密码</label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="passwordConfirm" class="form-control" placeholder="请再次输入密码" maxlength="20" type="password">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>




            <div class="row">
                <div class="col-xs-7">
                    <div class="form-group has-feedback">
                        <label for="idcode-btn">验证码</label>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-qrcode"></span></span>
                            <input id="idcode-btn" class="form-control" placeholder="请输入验证码" maxlength="4" type="text">
                        </div>
                        <span style="color:red;display: none;" class="tips"></span>
                        <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                        <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                </div>
                <div class="col-xs-5" style="padding-top: 30px">
                    <div id="idcode" style="background: transparent;"></div>
                </div>
            </div>

            <div class="form-group has-feedback">
                <label for="phoneNum">手机号码</label>
                <div class="input-group">
                    <span  class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                    <input name="phonenum"  id="phoneNum" class="form-control" placeholder="请输入手机号码" maxlength="11" type="text">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
                <div class="row">
                    <div class="col-xs-7">
                        <div class="form-group has-feedback">
                            <label for="idcode-btn">校验码</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-qrcode"></span></span>
                                <input  id="vcode" class="form-control" placeholder="请输入校验码" maxlength="6" type="text">
                            </div>
                            <span style="color:red;display: none;" class="tips"></span>
                            <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                            <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="col-xs-5 text-center" style="padding-top: 26px">
                        <input type="submit" <%--id="loadingButton" class="btn btn-primary"--%>  value="获取短信校验码" formaction="/phonenum" formmethod="post"></input>
                    </div>
                </div>
            </div>



            <div class="form-group">
                <input class="form-control btn btn-primary" id="submit" value="立&nbsp;&nbsp;即&nbsp;&nbsp;注&nbsp;&nbsp;册" type="submit">
            </div>

            <div class="form-group">
                <input value="重置" id="reset" class="form-control btn btn-danger" type="reset">
            </div>
        </form>
    </div>
</div>

<script>
    var settings = {
        e: 'idcode',
        codeType: {
            name: 'follow',
            len: 4
        }, //len是修改验证码长度的
        codeTip: '换个验证码?',
        inputID: 'idcode-btn' //验证元素的ID
    };

    var _set = {
        storeLable: 'codeval',
        store: '#ehong-code-input',
        codeval: '#ehong-code'
    }
    $.idcode = {
        getCode: function(option) {
            _commSetting(option);
            return _storeData(_set.storeLable, null);
        },
        setCode: function(option) {
            _commSetting(option);
            _setCodeStyle("#" + settings.e, settings.codeType.name, settings.codeType.len);

        },
        validateCode: function(option) {
            _commSetting(option);
            var inputV;
            if (settings.inputID) {
                inputV = $('#' + settings.inputID).val();

            } else {
                inputV = $(_set.store).val();
            }
            if (inputV.toUpperCase() == _storeData(_set.storeLable, null).toUpperCase()) { //修改的不区分大小写
                return true;
            } else {
                _setCodeStyle("#" + settings.e, settings.codeType.name, settings.codeType.len);
                return false;
            }
        }
    };

    function _commSetting(option) {
        $.extend(settings, option);
    }

    function _storeData(dataLabel, data) {
        var store = $(_set.codeval).get(0);
        if (data) {
            $.data(store, dataLabel, data);
        } else {
            return $.data(store, dataLabel);
        }
    }

    function _setCodeStyle(eid, codeType, codeLength) {
        var codeObj = _createCode(settings.codeType.name, settings.codeType.len);
        var randNum = Math.floor(Math.random() * 6);
        var htmlCode = ''
        if (!settings.inputID) {
            htmlCode = '<span><input id="ehong-code-input" type="text" maxlength="4" /></span>';
        }
        htmlCode += '<div id="ehong-code" class="ehong-idcode-val ehong-idcode-val';
        htmlCode += String(randNum);
        htmlCode += '" href="#" onblur="return false" onfocus="return false" oncontextmenu="return false" onclick="$.idcode.setCode()">' + _setStyle(codeObj) + '</div>' + '<span id="ehong-code-tip-ck" class="ehong-code-val-tip" onclick="$.idcode.setCode()">' + settings.codeTip + '</span>';
        $(eid).html(htmlCode);
        _storeData(_set.storeLable, codeObj);
    }

    function _setStyle(codeObj) {
        var fnCodeObj = new Array();
        var col = new Array('#BF0C43', '#E69A2A', '#707F02', '#18975F', '#BC3087', '#73C841', '#780320', '#90719B', '#1F72D8', '#D6A03C', '#6B486E', '#243F5F', '#16BDB5');
        var charIndex;
        for (var i = 0; i < codeObj.length; i++) {
            charIndex = Math.floor(Math.random() * col.length);
            fnCodeObj.push('<font color="' + col[charIndex] + '">' + codeObj.charAt(i) + '</font>');
        }
        return fnCodeObj.join('');
    }

    function _createCode(codeType, codeLength) {
        var codeObj;
        if (codeType == 'follow') {
            codeObj = _createCodeFollow(codeLength);
        } else if (codeType == 'calc') {
            codeObj = _createCodeCalc(codeLength);
        } else {
            codeObj = "";
        }
        return codeObj;
    }

    function _createCodeCalc(codeLength) {
        var code1, code2, codeResult;
        var selectChar = new Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        var charIndex;
        for (var i = 0; i < codeLength; i++) {
            charIndex = Math.floor(Math.random() * selectChar.length);
            code1 += selectChar[charIndex];

            charIndex = Math.floor(Math.random() * selectChar.length);
            code2 += selectChar[charIndex];
        }
        return [parseInt(code1), parseInt(code2), parseInt(code1) + parseInt(code2)];
    }

    function _createCodeFollow(codeLength) {
        var code = "";
        var selectChar = new Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

        for (var i = 0; i < codeLength; i++) {
            var charIndex = Math.floor(Math.random() * selectChar.length);
            if (charIndex % 2 == 0) {
                code += selectChar[charIndex].toLowerCase();
            } else {
                code += selectChar[charIndex];
            }
        }
        return code;
    }
    var regUsername = /^[a-zA-Z_][a-zA-Z0-9_]{4,19}$/;
    var regPasswordSpecial = /[~!@#%&=;':",./<>_\}\]\-\$\(\)\*\+\.\[\?\\\^\{\|]/;
    var regPasswordAlpha = /[a-zA-Z]/;
    var regPasswordNum = /[0-9]/;
    var password;
    var check = [false, false, false, false, false, false];

    //校验成功函数
    function success(Obj, counter) {
        Obj.parent().parent().removeClass('has-error').addClass('has-success');
        $('.tips').eq(counter).hide();
        $('.glyphicon-ok').eq(counter).show();
        $('.glyphicon-remove').eq(counter).hide();
        check[counter] = true;

    }

    // 校验失败函数
    function fail(Obj, counter, msg) {
        Obj.parent().parent().removeClass('has-success').addClass('has-error');
        $('.glyphicon-remove').eq(counter).show();
        $('.glyphicon-ok').eq(counter).hide();
        $('.tips').eq(counter).text(msg).show();
        check[counter] = false;
    }

    // 用户名匹配
    $('.container').find('input').eq(0).change(function() {


        if (regUsername.test($(this).val())) {
            success($(this), 0);
        } else if ($(this).val().length < 5) {
            fail($(this), 0, '用户名太短，不能少于5个字符');
        } else {
            fail($(this), 0, '用户名只能为英文数字和下划线,且不能以数字开头')
        }

    });



    // 密码匹配

    // 匹配字母、数字、特殊字符至少两种的函数
    function atLeastTwo(password) {
        var a = regPasswordSpecial.test(password) ? 1 : 0;
        var b = regPasswordAlpha.test(password) ? 1 : 0;
        var c = regPasswordNum.test(password) ? 1 : 0;
        return a + b + c;

    }

    $('.container').find('input').eq(1).change(function() {

        password = $(this).val();

        if ($(this).val().length < 8) {
            fail($(this), 1, '密码太短，不能少于8个字符');
        } else {


            if (atLeastTwo($(this).val()) < 2) {
                fail($(this), 1, '密码中至少包含字母、数字、特殊字符的两种')
            } else {
                success($(this), 1);
            }
        }
    });


    // 再次输入密码校验
    $('.container').find('input').eq(2).change(function() {

        if ($(this).val() == password) {
            success($(this), 2);
        } else {

            fail($(this), 2, '两次输入的密码不一致');
        }

    });


    // 验证码
    $.idcode.setCode();

    $('.container').find('input').eq(3).change(function() {
        var IsBy = $.idcode.validateCode();
        if (IsBy) {
            success($(this), 3);
        } else {
            fail($(this), 3, '验证码输入错误');
        }
    });

    // 手机号码
    var regPhoneNum = /^[0-9]{11}$/
    $('.container').find('input').eq(4).change(function() {
        if (regPhoneNum.test($(this).val())) {
            success($(this), 4);
        } else {
            fail($(this), 4, '手机号码只能为11位数字');
        }
    });

    //短信验证码
    var regMsg = /111111/;
    $('.container').find('input').eq(5).change(function() {
        if (check[4]) {
            if (regMsg.test($(this).val())) {
                success($(this), 5);
            } else {
                fail($(this), 5, '短信验证码错误');
            }
        } else {
            $('.container').find('input').eq(4).parent().parent().removeClass('has-success').addClass('has-error');
        }

    });


    $('#loadingButton').click(function() {

        if (check[4]) {
            $(this).removeClass('btn-primary').addClass('disabled');

            $(this).html('<span class="red">59</span> 秒后重新获取');
            var secondObj = $('#loadingButton').find('span');
            var secondObjVal = secondObj.text();

            function secondCounter() {

                var secondTimer = setTimeout(function() {
                    secondObjVal--;
                    secondObj.text(secondObjVal);
                    secondCounter();
                }, 1000);
                if (secondObjVal == 0) {
                    clearTimeout(secondTimer);
                    $('#loadingButton').text('重新获取校验码');
                    $('#loadingButton').removeClass('disabled').addClass('btn-primary');

                }
            }

            secondCounter();
        } else {
            $('.container').find('input').eq(4).parent().parent().removeClass('has-success').addClass('has-error');
        }

    })

    $('#submit').click(function(e) {
        if (!check.every(function(value) {
                return value == true
            })) {
            e.preventDefault();
            for (key in check) {
                if (!check[key]) {
                    $('.container').find('input').eq(key).parent().parent().removeClass('has-success').addClass('has-error')
                }
            }
        }
    });

    $('#reset').click(function() {
        $('input').slice(0, 6).parent().parent().removeClass('has-error has-success');
        $('.tips').hide();
        $('.glyphicon-ok').hide();
        $('.glyphicon-remove').hide();
        check = [false, false, false, false, false, false, ];
    });
</script>

</body>
</html>
