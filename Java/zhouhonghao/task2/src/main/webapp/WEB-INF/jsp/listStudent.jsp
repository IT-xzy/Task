<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>


 <%@page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <script type="text/javascript" src="js/jquery.min.js"></script>

    <script type="text/javascript">
      $(function(){                    
           $(".delete").click(function(){
               var href=$(this).attr("href");
               $("#formdelete").attr("action",href).submit();
               return false;
           })
       })
         </script>

 <div style="width:500px;margin:0px auto;text-align:center">
	<table align='center'  border='1'  cellspacing='0'>
	
	    <tr>
	        <td>学号</td>
	        <td>姓名</td>
	        <td>学校</td>
	        <td>电话</td>
	        <td>时间</td>
	        <td>编辑</td>
	        <td>删除</td>
	    </tr>
	    <c:forEach items="${ss}" var="s" varStatus="st">
	        <tr>
	            <td>${s.id}</td>
	            <td>${s.name}</td>
	             <td>${s.address}</td>
	            <td>${s.phone}</td>
	            <td>${s.create_up}</td>
	            <td><a href="student/${s.id}">编辑</a></td>
	            <td><a class="delete" href="student/${s.id}">删除</a></td>
	        </tr>
	    </c:forEach>
	</table>
	<div style="text-align:center">
		<a href="?start=0">首 页</a>
        <c:if test="${page.start-page.count>=0}">
            <a href="?start=${page.start-page.count}">上一页</a>
        </c:if>
        <c:if test="${page.start-page.count<0}">
            <a href="javascript:void(0)">上一页</a>
        </c:if>
           
        <c:if test="${page.start+page.count<=page.last}">
            <a href="?start=${page.start+page.count}">下一页</a>
        </c:if>
        <c:if test="${page.start+page.count>page.last}">
            <a href="javascript:void(0)">下一页</a>
        </c:if>
        <a href="?start=${page.last}">末页</a>
	</div>
	
	
	<div style="text-align:center;margin-top:40px">

		<form method="post" action="student">
		<input type="hidden" name="_method"  value="PUT">
		姓名： <input name="name"  type="text"> <br><br>
		学校： <input name="address"  type="text"> <br><br>
	    电话： <input name="phone"  type="text"> <br><br>
	    <input name="create_up"  type="hidden" value=<%=new Date().getTime()%>> <br><br>
			<input type="submit" value="注册">
		</form>

	</div>
 </div>
<form id="formdelete" action="" method="POST" >
       <input type="hidden" name="_method" value="DELETE">
   </form>