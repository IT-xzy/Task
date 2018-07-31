<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/7/14
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <div>
        <strong> welcome,${sessionScope.user.username}! </strong>
    </div>
    this is success page!

    <form method="post" action="/u/page">
        <%--<input type="hidden" name="_method" value="DELETE">--%>
        <table>
            <tr>
                <td><input type="submit" value="退出登录"></td>
            </tr>
        </table>
    </form>
</div>
