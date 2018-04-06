<%--
  Created by IntelliJ IDEA.
  User: lucifer
  Date: 2018/03/29
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="用户登记界面"/>
    <meta name="keywords" content="FDU fudan PT private tracker"/>
    <title>用户登记界面--邮箱版</title>
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
                <li id="button_login">
                    <a class="firstlevel" href="/Phone">
                        <span class="firstlevel">手机注册</span>
                    </a>
                </li>
                <li id="button_register">
                    <a class="firstlevel" href="/Email">
                        <span class="last firstlevel">邮箱注册</span>
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
            <form action="/recordE" method="post" accept-charset="UTF-8"
                  name="frmLogin">
                <div class="tborder login">
                    <h3 class="catbg"><span class="left"></span><span class="right"></span>
                        用户登记${result}<a href="/students">跳过登记</a>
                    </h3>
                    <span class="upperframe"><span></span></span>
                    <div class="roundframe" id="trad">
                        <dl>
                            <dt>用户姓名:</dt>
                            <dd><input type="text" name="name" size="40" maxlength="5"/></dd>
                            <dt>用户QQ:</dt>
                            <dd><input type="text" name="qq" size="40" maxlength="13"/></dd>
                            <dt>用户职业:</dt>
                            <dd><input type="text" name="type" size="40" maxlength="5"/></dd>
                            <dt>入学时间:</dt>
                            <dd><input type="text" name="enrolmenttime" size="40"/></dd>
                            <dt>毕业院校:</dt>
                            <dd><input type="text" name="graduated" size="40"/></dd>
                            <dt>用户学号:</dt>
                            <dd><input type="text" name="number" size="40" maxlength="5"/></dd>
                            <dt>日报链接:</dt>
                            <dd><input type="text" name="daily" size="40"/></dd>
                            <dt>学习立愿:</dt>
                            <dd><input type="text" name="ambition" size="40"/></dd>
                            <dt>辅导师兄:</dt>
                            <dd><input type="text" name="responsible" size="40" maxlength="5"/></dd>
                            <dt>推广来源:</dt>
                            <dd><input type="text" name="wfrom" size="40" maxlength="8"/></dd>
                            <%--<dt>手机号码:</dt>--%>
                            <%--<dd><input type="text" name="telipone" size="40"/></dd>--%>
                            <dt>用户邮箱:</dt>
                            <dd><input type="text" name="email" size="40"/></dd>
                        </dl>
                        <p class="centertext"><input type="submit" value="获取验证码" class="button_submit"/></p>
                        <hr/>
                        <dl>
                            <dd></dd>
                        </dl>
                    </div>
                    <span class="lowerframe"><span></span></span>
                    <input type="hidden" name="hash_passwrd" value=""/>
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
