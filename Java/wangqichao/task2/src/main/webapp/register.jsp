<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/4/11
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>初涉江湖</title>
</head>
<body>
<h2 align="center">请输入注册信息</h2>
<form action="login.jsp" method="get" align="center">
<table align="center"  width="600">
    <tr>
        <td align="right" width="200"><font color="red">*</font><strong>用户名:</strong></td>
        <td align="left" ><input type="text" name="username" style="background-color:LavenderBlush"><font color="red" size="-1"><strong>用户名不得少于三个字符</strong></font> </td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>密码:</strong></td>
        <td align="left"><input type="password" name="passward" style="background-color:LavenderBlush"></td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>确认密码:</strong></td>
        <td align="left"><input type="password" name="repassward" style="background-color:LavenderBlush"></td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>Email:</strong></td>
        <td align="left"><input type="text" name="Email" style="background-color:LavenderBlush"></td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>真实姓名:</strong></td>
        <td align="left"><input type="text" name="realname" style="background-color:LavenderBlush"></td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>性别:</strong></td>
        <td align="left" size="10"name="gender" ><select style="background-color:LavenderBlush">
            <option>少侠</option>
            <option>女侠</option>
            <option>东方不败</option>
        </select></td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>生日:</strong></td>
        <td align="left" size="10" name="birthday" ><select style="background-color:LavenderBlush">
            <option>1980</option>
            <option>1981</option>
            <option>1982</option>
            <option>1983</option>
            <option>1984</option>
            <option>1985</option>
            <option>1986</option>
            <option>1987</option>
            <option>1988</option>
            <option>1989</option>
            <option>1990</option>
            <option>1991</option>
            <option>1992</option>
            <option>1993</option>
            <option>1994</option>
            <option>1995</option>
            <option>1996</option>
            <option>1997</option>
            <option>1998</option>
            <option>1999</option>
            <option>2000</option>
            <option>2001</option>
            <option>2002</option>
        </select>
            <select style="background-color:LavenderBlush">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
            </select>
            <select style="background-color:LavenderBlush">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
                <option>13</option>
                <option>14</option>
                <option>15</option>
                <option>16</option>
                <option>17</option>
                <option>18</option>
                <option>19</option>
                <option>20</option>
                <option>21</option>
                <option>22</option>
                <option>23</option>
                <option>24</option>
                <option>25</option>
                <option>26</option>
                <option>27</option>
                <option>28</option>
                <option>29</option>
                <option>30</option>
                <option>31</option>
            </select>
        </td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>手机号码:</strong></td>
        <td align="left"><input type="text" name="telephoneNumber" style="background-color:LavenderBlush"></td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>住址:</strong></td>
        <td align="left" size="10"name="address" ><select style="background-color:LavenderBlush">
            <option>浙江省</option>
            <option>江苏省</option>
            <option>上海市</option>
        </select>
            <select style="background-color:LavenderBlush">
            <option>杭州市</option>
            <option>湖州市</option>
            <option>嘉兴市</option>
        </select>
            <select style="background-color:LavenderBlush">
                <option>下城区</option>
                <option>西湖区</option>
                <option>萧山区</option>
            </select>
        </td>
    </tr>
    <tr>
        <td align="right"><font color="red">*</font><strong>QQ号码:</strong></td>
        <td align="left"><input type="text" name="QQNumber" style="background-color:LavenderBlush"></td>
    </tr>
    <tr>
    <td align="right"></td>
    <td align="left" ><font color="#00bfff" size="-1"> 设置我的QQ在线状态</font></td>
</tr>
</table>
    <div align="center"><input type="submit" value="注册并登陆" ></div>
    <div align="center"><img src="image/2.jpg"/></div>
</form>
<jsp:include page="WEB-INF/views/footer.jsp" >
    <jsp:param  name="year" value="2018" />
</jsp:include>
</body>
</html>
