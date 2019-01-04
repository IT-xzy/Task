<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/11/16
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding: 100px 100px 10px;">
    <div class="panel  panel-primary">
        <div class="panel-heading">
            用户注册
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <form action="register" method="post">
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">注册</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="application/javascript">
    //发送表单ajax请求
    // $(':submit').on('click',function(){
    //     $.ajax({
    //         url:"register",
    //         type:"POST",
    //         data:JSON.stringify($('form').serializeObject()),
    //         contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
    //         success:function(){
    //             alert("成功");
    //         }
    //     });
    // });
    //
    // /**
    //  * 自动将form表单封装成json对象
    //  */
    // $.fn.serializeObject = function() {
    //     var o = {};
    //     var a = this.serializeArray();
    //     $.each(a, function() {
    //         if (o[this.name]) {
    //             if (!o[this.name].push) {
    //                 o[this.name] = [ o[this.name] ];
    //             }
    //             o[this.name].push(this.value || '');
    //         } else {
    //             o[this.name] = this.value || '';
    //         }
    //     });
    //     return o;
    // };
</script>