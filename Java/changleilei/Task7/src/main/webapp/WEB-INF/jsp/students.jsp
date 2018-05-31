<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lucifer
  Date: 2018/03/29
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="登录"/>
    <meta name="keywords" content="FDU fudan PT private tracker"/>
    <title>所有学生列表</title>
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
            <a href="/s">跳过登记</a><a href="/migration">一键迁移</a>
            <form action="/students" method="GET" accept-charset="UTF-8"
                  name="frmLogin">
                <div class="tborder login">
                    <h3 class="catbg"><span class="left"></span>
                        欢迎你 ！${result}<input type="submit" value="提交更改" class="button_submit"/>
                    </h3>
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
<c:forEach items="${studentList}" var="obj">
    <table border="2">
        <tr>
            <td>序号：${obj.id}&nbsp;&nbsp;</td>
            <td>姓名：${obj.name}&nbsp;</td>
            <td>QQ：${obj.qq}&nbsp;</td>
            <td>职业：${obj.type}&nbsp;</td>
            <td>入学：${obj.enrolmenttime}&nbsp;</td>
            <td>院校：${obj.graduated}&nbsp;</td>
            <td>学号：${obj.number}&nbsp;</td>
            <td>日报：${obj.daily}&nbsp;</td>
            <td>立愿：${obj.ambition}&nbsp;</td>
            <td>师兄：${obj.responsible}&nbsp;</td>
            <td>来源：${obj.wfrom}&nbsp;</td>
            <td>手机：${obj.telipone}&nbsp;</td>
            <td>邮箱：${obj.email}&nbsp;</td>
            <td>头像：${obj.portrait}&nbsp;</td>
            <td>创建：${obj.createAt}&nbsp;</td>
            <td>更新：${obj.updateAt}&nbsp;</td>
            <td>
                <form action="${ctx}/student/${obj.id}" method="post">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="submit" value="删除">
                </form>
            </td>
            <td><a href="/student/${obj.name}">详细</a>&nbsp;</td>
            <td><a href="/student/modify">更新</a>&nbsp;</td>
            <td><a href="/student/register">新增</a>&nbsp;</td>
            <td><a href="/">首页</a><br/><br/></td>
        </tr>
    </table>
</c:forEach>
</body>
</html>