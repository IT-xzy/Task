<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="登录"/>
    <meta name="keywords" content="FDU fudan PT private tracker"/>
    <title>手机注册</title>
    <link rel="stylesheet" type="text/css"
          href="https://pt.vm.fudan.edu.cn/Themes/default/A.css,,_index.chinese-utf8.css+css,,_themes_shared.css+tracker,,_css,,_smoothness,,_jquery-ui-1.8.22.custom.css+tracker,,_css,,_jquery.atwho.min.css,Mcc.-ypKyuL-ZH.css.pagespeed.cf.ECRET79nzE.css"/>
</head>
<body>
<div id="header">
    <div class="frame">
        <div id="top_section">
            <h1 class="forumtitle">
                <a href="https://www.jnshu.com">IT修真院报名系统</a>
            </h1>
        </div>
        <div id="upper_section" class="middletext">
        </div>
        <br class="clear"/>
        <div id="main_menu">
            <ul class="dropmenu" id="menu_nav">
                <li id="button_home">
                    <a class="active firstlevel" href="/">
                        <span class="last firstlevel">首页</span>
                    </a>
                </li>
                <li id="button_register">
                    <a class="firstlevel" href="/registerE">
                        <span class="last firstlevel">邮箱注册</span>
                    </a>
                </li>
                <li id="button_link">
                    <a class="firstlevel" href="/EmailL">
                        <span class="last firstlevel">邮箱链接</span>
                    </a>
                </li>
            </ul>
        </div>
        <br class="clear"/>
        <div class="navigate_section">
            <ul>
                <li class="last">
                    <%--<a href="/index"><span>PT@Platform</span></a>--%>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="content_section">
    <div class="frame">
        <div id="main_content_section">
            <form action="/registerP" method="post" accept-charset="UTF-8" name="frmLogin">
                <div class="tborder login">
                    <h3 class="catbg"><span class="left"></span><span class="right"></span>
                        登录${result}
                    </h3>
                    <h3 class="catbg"><span class="left"></span><span class="right"></span>手机注册${result}</h3>
                    <span class="upperframe"><span></span></span>
                    <div class="roundframe" id="trad">
                        <dl>
                            <dt>用户昵称:</dt>
                            <dd><input type="text" name="name" size="40"/></dd>
                            <dt>手机号码:</dt>
                            <dd><input id="phone" type="text" name="phone" size="40"/></dd>
                            <dt>用户密码:</dt>
                            <dd><input type="password" name="password" size="40"/></dd>
                            <dt>验证 码:</dt>
                            <dd><input type="text" name="check" size="40"/></dd>
                        </dl>
                        <p class="centertext"><input type="submit" value="提交" class="button_submit"/></p>
                        <hr/>
                        <dl>
                            <dd></dd>
                        </dl>
                    </div>
                    <span class="lowerframe"><span></span></span>

                </div>
            </form>
        </div>
    </div>
</div>
<div id="footer_section">
    <div class="frame">
        <ul class="reset">
        </ul>
    </div>
</div>
</body>
</html>
