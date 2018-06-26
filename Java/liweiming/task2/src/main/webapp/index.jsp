<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\6\6 0006
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tags" prefix="date" %>
<!doctype html>
<html>
<head>
    <meta  charset="UTF-8">
    <%--<meta name="viewport"--%>
          <%--content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
    <title>用户管理</title>

    <script src="https://cdn.bootcss.com/jquery/3.3.0/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
<div class="modal fade" id="userUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">

    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalUpdate">修改用户</h4>
            </div>

            <div class="modal-body">
                <%--从bootstrap中添加的表单模块--%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 custom-control-label">用户名</label>
                        <div class="col-sm-10">
                            <%--name属性可以让spring自动配置，要对应bean的属性--%>
                            <%--<input type="text" class="form-control" id="name_update_input"--%>
                                   <%--placeholder="name" name="name">--%>
                                <p class="form-control-static" id="name_update_input"></p>
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 custom-control-label">QQ</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="qq_update_input"
                                   placeholder="qq" name="qq">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 custom-control-label">学习类型</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="learning_type_update_input"
                                   placeholder="learning_type" name="learning_type">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <%--<div class="form-group">
                        <label class="col-sm-2 custom-control-label">入学时间</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="entrance_time_add_input"
                                   placeholder="entrance_time" name="entrance_time">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 custom-control-label">学校</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="school_add_input"
                                   placeholder="school" name="school">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 custom-control-label">线上学号</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="online_id_add_input"
                                   placeholder="online_id" name="online_id">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 custom-control-label">日报链接</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="daily_link_add_input"
                                   placeholder="daily_link" name="daily_link">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 custom-control-label">立愿</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="wish_add_input"
                                   placeholder="wish" name="wish">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 custom-control-label">线上师兄</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="tutor_add_input"
                                   placeholder="tutor" name="tutor">
                            <span class="help-block"></span>
                        </div>
                    </div>--%>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="user_update_btn">保存</button>
            </div>
        </div>
    </div>
</div>





      <%--用户添加模态框，bootstrap的JavaScript插件 ，在<<script></script>>里写上事件--%>
      <%--Modal--%>
      <div class="modal fade" id="userAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">

          <div class="modal-dialog" role="document">
              <div class="modal-content">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                      </button>
                      <h4 class="modal-title" id="myModalLabel">用户添加</h4>
                  </div>

                  <div class="modal-body">
                      <%--从bootstrap中添加的表单模块--%>
                      <form class="form-horizontal" accept-charset="UTF-8">
                          <div class="form-group">
                              <label class="col-sm-2 custom-control-label">用户名</label>
                              <div class="col-sm-10">
                                  <%--name属性可以让spring自动配置，要对应bean的属性--%>
                                  <input type="text" class="form-control" id="name_add_input"
                                         placeholder="name" name="name">
                                  <span class="help-block"></span>
                              </div>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 custom-control-label">QQ</label>
                              <div class="col-md-10">
                                  <input type="text" class="form-control" id="qq_add_input"
                                         placeholder="qq" name="qq">
                                  <span class="help-block"></span>
                              </div>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 custom-control-label">学习类型</label>
                              <div class="col-md-10">
                                  <input type="text" class="form-control" id="learning_type_add_input"
                                         placeholder="learning_type" name="learning_type">
                                  <span class="help-block"></span>
                              </div>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 custom-control-label">入学时间</label>
                              <div class="col-md-10">
                                  <input type="text" class="form-control" id="entrance_time_add_input"
                                         placeholder="entrance_time" name="entrance_time">
                                  <span class="help-block"></span>
                              </div>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 custom-control-label">学校</label>
                              <div class="col-md-10">
                                  <input type="text" class="form-control" id="school_add_input"
                                         placeholder="school" name="school">
                                  <span class="help-block"></span>
                              </div>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 custom-control-label">线上学号</label>
                              <div class="col-md-10">
                                  <input type="text" class="form-control" id="online_id_add_input"
                                         placeholder="online_id" name="online_id">
                                  <span class="help-block"></span>
                              </div>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 custom-control-label">日报链接</label>
                              <div class="col-md-10">
                                  <input type="text" class="form-control" id="daily_link_add_input"
                                         placeholder="daily_link" name="daily_link">
                                  <span class="help-block"></span>
                              </div>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 custom-control-label">立愿</label>
                              <div class="col-md-10">
                                  <input type="text" class="form-control" id="wish_add_input"
                                         placeholder="wish" name="wish">
                                  <span class="help-block"></span>
                              </div>
                          </div>

                          <div class="form-group">
                              <label class="col-sm-2 custom-control-label">线上师兄</label>
                              <div class="col-md-10">
                                  <input type="text" class="form-control" id="tutor_add_input"
                                         placeholder="tutor" name="tutor">
                                  <span class="help-block"></span>
                              </div>
                          </div>
                      </form>
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                      <button type="button" class="btn btn-primary" id="user_save_btn">更新</button>
                  </div>
              </div>
          </div>
      </div>




   <div class="container">
       <%--标题--%>
       <div class="row">
           <div class="col-md-12">
               <h2>用户管理</h2>
           </div>
       </div>
           <%--按钮--%>
       <div class="row">
               <div class="col-md-4 col-md-offset-8">
                   <button class="btn btn-primary" id="user_add_modal_btn">新增</button>
                   <button class="btn btn-danger" id="user_delete_all_btn">删除</button>
               </div>
       </div>

       <div class="row">
               <div class="col-md-12">
                   <table width="1000" class="table table-condensed table-bordered table-hover" id="user_table">
                       <thead>
                       <tr>
                           <th>编号</th>
                           <th>姓名</th>
                           <th>  QQ   </th>
                           <th>学习类型</th>
                           <th>入学时间</th>
                           <th>学校</th>
                           <th>线上学号</th>
                           <th>日报链接  </th>
                           <th>立愿  </th>
                           <th>在线师兄</th>
                           <th>创建时间</th>
                           <th>更新时间</th>
                           <th>操作</th>
                       </tr>
                       </thead>
                       <tbody>

                       </tbody>
                   </table>
               </div>
       </div>
           <%--显示分页数据--%>
       <div class="row">
           <%--分页信息--%>
           <div class="col-md-6" id="page_info_area"></div>
                   <%--分页条信息--%>
           <div class="col-md-6" id="page_nav_area"></div>
       </div>
   </div>
           <%--当页面加载完成后，发起ajax请求获得数据--%>
   <script type="text/javascript">

               //全员总记录数   当前页面
               var totalRecord, currentPage;

               /*页面加载完成后，直接发送一个ajax请求，要到分页数据*/
               $(function() {
                   //直接去第一页
                   to_page(1);
               });

               /*==========封装方法：跳到第几页=========*/
               //1、页面加载完成后，直接发送一个ajax请求，要到分页数据
               function to_page(pn) {
                   $.ajax({
                       url : "${pageContext.request.contextPath}/student",
                       data : "pn="+ pn ,
                       type : "GET",
                       success : function(result) {
                           //把获取到的信息输出到控制台上
                           // console.log(result);
                           //1/解析显示用户信息
                           build_user_table(result);

                           //2、解析并显示分页信息
                           build_page_info(result);
                           build_page_nav(result);

                       }
                   });
               }




          /*================解析用户数据，并添加到列表下面，形成完整列表模式框架==========*/
               function build_user_table(result) {
                   //在构建之前，先清空，不然数据会叠加
                   $("#user_table tbody").empty();

                   //    第一步：对照json数据，获得所有用户数据
                   var user = result.ext.pageInfo.list;
                   // console.log(user);
                   // //    第二步：jquery的遍历，user为要遍历的参数，后面的为每次遍历返回的内容；
                   $.each(user, function (index, item) {

                       var idTd=$("<td></td>").append(item.id);
                       var nameTd = $("<td></td>").append(item.name);
                       var qqTd = $("<td></td>").append(item.qq);
                       var typeTd =$("<td></td>").append(item.learning_type);
                       var entranceTd =$("<td></td>").append(item.entrance_time);
                       var schoolTd =$("<td></td>").append(item.school);
                       var online_idTd=$("<td></td>").append(item.online_id);
                       var daily_linkTd=$("<td></td>").append(item.daily_link);
                       var wishTd =$("<td></td>").append(item.wish);
                       var tutorTd =$("<td></td>").append(item.tutor);
                       var create_atTd =$("<td></td>").append(item.create_at);
                       var update_atTd=$("<td></td>").append(item.update_at);

                       //  添加编辑按钮
                       var editBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
                           .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");


                       //为编辑按钮添加一个自定义的属性，来表示当前员工的id，用于修改员工信息时候用
                       editBtn.attr("edit-id", item.id);


                       var delBtn =$("<button></button>").addClass("btn btn-danger btn-xs delete_btn")
                           .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
                       var btnTd =$("<td></td>").append(editBtn).append("").append(delBtn);

                       //为删除按钮添加一个自定义的属性，来表示当前删除员工的id
                       delBtn.attr("del-id", item.id);


                       //将上面的table表中td数据添加到tr中,这是一个链式操作
                       $("<tr></tr>").append(idTd)
                           .append(nameTd)
                           .append(qqTd)
                           .append(typeTd)
                           .append(entranceTd)
                           .append(schoolTd)
                           .append(online_idTd)
                           .append(daily_linkTd)
                           .append(wishTd)
                           .append(tutorTd)
                           .append(create_atTd)
                           .append(update_atTd)
                           .append(btnTd)
                           .appendTo("#user_table tbody")
                       ;
                   });
               }

        /*======================解析页面左下角的信息=======================*/
               function build_page_info(result) {
                   $("#page_info_area").empty();

       //    找到id=page_info_area的div块，进行操作
                    $("#page_info_area").append(
                        "当前"+result.ext.pageInfo.pageNum +"页，总共"
                        +result.ext.pageInfo.pages+"页，总共"
                        +result.ext.pageInfo.total +"记录"
                    );

                    totalRecord = result.ext.pageInfo.total;
                    currentPage=result.ext.pageInfo.pageNum;
               }

        /*===========用于解析右下角的分页条，创建分页条，并实现跳转功能=========*/
               function build_page_nav(result) {
                   $("#page_nav_area").empty();
                   //此处的建议对照之前的index.jsp的html部分的代码看，不如太作死
                   /*开始构建 首页 末页，第一页...等元素，最后一次性加进去下面 第一段代码就完成了
                     <li><a href="#">首页</a></li> 这段代码
                    */
                   var ul = $("<ul></ul>").addClass("pagination");

                   var firstPageLi = $("<li></li>").append(
                       $("<a></a>").append("首页").attr("href", "#"));
                   var prePageLi = $("<li></li>").append(
                       $("<a></a>").append("&laquo;"));
                   //判断能不能点击前一页或者首页
                   if (result.ext.pageInfo.hasPreviousPage == false) {
                       firstPageLi.addClass("disabled");
                       prePageLi.addClass("disabled");
                   } else {
                       //为元素添加点击翻页的事件
                       firstPageLi.click(function() {
                           to_page(1);
                       });
                       prePageLi.click(function() {
                           to_page(result.ext.pageInfo.pageNum - 1);
                       })
                   }

                   var nextPageLi = $("<li></li>").append(
                       $("<a></a>").append("&raquo;"));
                   var lastPageLi = $("<li></li>").append(
                       $("<a></a>").append("末页").attr("href", "#"));
                   //判断能不能点击下一页或者末页
                   if (result.ext.pageInfo.hasNextPage == false) {
                       nextPageLi.addClass("disabled");
                       lastPageLi.addClass("disabled");
                   } else {
                       nextPageLi.click(function() {
                           to_page(result.ext.pageInfo.pageNum + 1);
                       });
                       lastPageLi.click(function() {
                           to_page(result.ext.pageInfo.pages);
                       })
                   }

                   //先把首页和前一页图标加上去
                   ul.append(firstPageLi).append(prePageLi)
                   //遍历页码号 第一页第二页。。。遍历给ul中添加页码提示
                   $.each(result.ext.pageInfo.navigatepageNums, function(index,
                                                                            item) {
                       var numLi = $("<li></li>").append($("<a></a>").append(item));
                       //让当前页面高亮
                       if (result.ext.pageInfo.pageNum == item) {
                           numLi.addClass("active");
                       }
                       //添加单击事件
                       numLi.click(function() {
                           to_page(item);
                       })
                       ul.append(numLi);
                   });
                   //最后添加后一页和末页提示
                   ul.append(nextPageLi).append(lastPageLi);
                   //把ul加入到nav元素
                   var navEle = $("<nav></nav>").append(ul);
                   navEle.appendTo("#page_nav_area");
               }


       /*================================点击新增按钮弹出悬浮框====================================*/
               $("#user_add_modal_btn").click(function () {

                    $("#userAddModal").modal({
                        backdrop:"static"
                    });
               });


        /*=======================封装检验重复的方法，便于多处引用===============================*/
               function show_validate_msg(ele, status, msg) {
                   //应该清空这个元素之前的样式
                   $(ele).parent().removeClass("has-success has-error");
                   $(ele).next("span").text("");
                   if ("success" == status) {
                       $(ele).parent().addClass("has-success");
                       $(ele).next("span").text("");
                   } else if ("error" == status) {
                       $(ele).parent().addClass("has-error");
                       $(ele).next("span").text(msg);
                   }
       }

         /*============================点击按钮后，就会保存数据===========================*/
               $("#user_save_btn").click(function () {
           // var params = $("#userAddModal form").serialize();
           // params = decodeURIComponent(params,true);

           $.ajax({
               url:"${pageContext.request.contextPath}/student",
               type:"POST",
               data: $("#userAddModal form").serialize(),
               scriptCharset:"utf-8",
               contentType: "application/x-www-form-urlencoded;charset=UTF-8",
               success:function (result) {
               //    员工保存成功后，判断返回后台返回的救国状态码（JSR303）
                   if (result.code == 100){
                   //    1、关闭模态框,  使用bootstrap方法
                       $("#userAddModal").modal("hide");

                   } else {
                   //    有那个字段有错误信息就显示那个字段的，undefined是没有错误下会自动带上的信息
                       if (undefined != result.ext.errorFields.name){
                           show_validate_msg(
                               "#name_add_input",
                               "error",
                               result.ext.errorFields.name
                           );
                       }

                       if (undefined != result.ext.errorFields.learning_type){
                           show_validate_msg(
                               "#learning_type_add_input",
                               "error",
                               result.ext.errorFields.learning_type
                           );
                       }

                       if (undefined != result.ext.errorFields.qq){
                           show_validate_msg(
                               "#qq_add_input",
                               "error",
                               result.ext.errorFields.qq
                           );
                       }

                       if (undefined != result.ext.errorFields.school){
                           show_validate_msg(
                               "#school_add_input",
                               "error",
                               result.ext.errorFields.school
                           );
                       }

                   }

                   to_page(totalRecord);
               }
           });
               });
         /*==========================单个删除按钮========================*/
               $(document).on("click", ".delete_btn", function() {
                   //1、弹出确认是否删除对话框，找到列表中的第2个td（即姓名）
                   var userName = $(this).parents("tr").find("td:eq(1)").text();
                   var userId = $(this).attr("del-id");
                   //制定弹出框的内容
                   if (confirm("确认删除[" + userName + "]吗?")) {
                       //确认，发送ajax请求进行删除
                       $.ajax({
                           url : "http://localhost:8080/student/" + userId,
                           type : "DELETE",
                           success : function(result) {
                               to_page(currentPage);
                           }
                       });
                   }
               });


               /*===========================查询用户信息===========================*/

               function getUser(id){
                   $.ajax({
                      url:"${pageContext.request.contextPath}/student/" + id,
                      type:"GET",
                      success:function (result) {
                          var userDate = result.ext.user;

                          $("name_update_input").text(userDate.name);
                          $("qq_update_input").val(userDate.qq);
                          $("learning_type_update_input").val(userDate.learning_type);
                      }
                   });
               }

               /*===========================点击编辑，弹出悬浮框====================================*/
               //    发送ajax请求获得用户信息

       $(document).on("click",".edit_btn",function () {

           getUser($(this).attr("edit_id"));

           $("#user_update_btn").attr("edit_id",$(this).attr("edit_id"));

           $("#userUpdateModal").modal({
               backdrop:"static"
           });
       });

       /*===============================点击更新后，更新用户====================================*/
       $("#user_update_btn").click(function () {
           $.ajax({
               url:"${pageContext.request.contextPath}/student/"+$(this).attr("edit_id"),
               type:"PUT",
               data:$("#userUpdateModal form").serialize(),
               success:function (result) {
               //    关闭对话框
                   console.log(result);

                   $("#userUpdateModal").modal("hide");

                   to_page(currentPage);
               }
           });
       });

   </script>

</body>
</html>