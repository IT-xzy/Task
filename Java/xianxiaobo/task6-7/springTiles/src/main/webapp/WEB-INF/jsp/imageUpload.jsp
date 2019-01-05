<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/11/14
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<div class="main container">
    <div class="page-header">
        <h3>FormData图片上传</h3>
        <form id="uploadForm" enctype="multipart/form-data">
            <div class="form-group">
                <div class="h4">图片预览</div>
                <div class="fileinput fileinput-new" data-provides="fileinput" id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;min-height:100px;">
                        <%--<img id="picImg" style="width: 100%;height: auto;max-height: 140px;" src="images/noimage.png" alt="">--%>
                    </div>
                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                    <div>
                        <span class="btn btn-primary btn-file">
                        <span class="fileinput-new">选择文件</span>
                        <span class="fileinput-exists">换一张</span>
                        <input type="file" name="file" id="picID" accept="image/gif,image/jpeg,image/x-png">
                        </span>
                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                    </div>
                </div>
            </div>
            <button type="button" id="uploadSubmit" class="btn btn-info">提交</button>
        </form>
    </div>
</div>


<div class="main container">
    <!--第一部分开始-->
    <div class="main-a row">
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div class="row text-center">
                <ul class="list-unstyled">
                    <li class="col-xs-12 up-1">
                        <img alt="" src="/static/image/45354312.png">
                    </li>
                    <li class="up-2 col-xs-12">高效</li>
                    <li class="up-3 col-xs-12">将三到七年的成长时间,缩短到一年到两年</li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div class="row text-center">
                <ul class="list-unstyled">
                    <li class="col-xs-12 up-1">
                        <img alt="" src="/static/image/879789.png">
                    </li>
                    <li class="up-2 col-xs-12">规范</li>
                    <li class="up-3 col-xs-12">标准到实战教程,不会走弯路</li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div class="row text-center">
                <ul class="list-unstyled">
                    <li class="col-xs-12 up-1">
                        <img alt="" src="/static/image/786453654365.png">
                    </li>
                    <li class="up-2 col-xs-12">人脉</li>
                    <li class="up-3 col-xs-12">同班好友,同院学长,技术大师,入学就混职脉圈,为以后铺平道路</li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 text-center">
            <p>
                <img src="/static/image/453254312.png">${totalStudent}<br>
                <span class="up-3">累计在线学习人数</span>
            </p>
            <p>
                <img src="/static/image/453254312.png">${graduatedStudent}<br>
                <span class="up-3">学员已经找到满意工作</span>
            </p>
        </div>
    </div>

    <!--第二部分开始-->
    <div class="main-b row">
        <h3 class="text-center main-tab">如何学习</h3>
        <ul class="list-unstyled text-center">
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">1</span>
                <p class="up-2">匹配你现在的个人情况寻找适合自己的岗位</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">2</span>
                <p class="up-2">了解职业前景薪金待遇，竞争压力等</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">3</span>
                <p class="up-2">掌握行业内顶级技能</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">4</span>
                <p class="up-2">查看职业目标任务</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">5</span>
                <p class="up-2">参考学习资料，掌握技能点，逐个完成任务</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">6</span>
                <p class="up-2">加入班级，和小伙伴们互帮互动，一块学习</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">7</span>
                <p class="up-2">选择导师，一路引导，加速自己成长</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">8</span>
                <p class="up-2">完成职业 技能，升级业界大牛</p>
                <span class="up-3 invisible"></span>
            </li>
        </ul>
    </div>

    <!--第三部分开始-->
    <div class="main-c row">
        <h3 class="text-center main-tab">优秀学员展示</h3>
        <ul class="list-unstyled text-center">
            <c:forEach var="item" items="${data}" varStatus="now">
                <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                    <div>
                        <img src="${item.img}">
                        <span>${item.position}:${item.name}</span>
                        <p class="text-left">${item.description}</p>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

    <!--第四部分开始-->
    <div class="row main-bottom">
        <h3 class="text-center">战略合作企业</h3>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <ul class="logo">
                <li>
                    <a href=""><img src="/static/image/123132.png"></a>
                </li>
                <li>
                    <a href=""> <img src="/static/image/1549865.png"></a>
                </li>
                <li>
                    <a href=""> <img src="/static/image/785345.png"></a>
                </li>
                <li>
                    <a href=""> <img src="/static/image/1471.png"></a>
                </li>
                <li>
                    <a href="">  <img src="/static/image/7861.png"></a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="main-e">
    <h3 class="text-center main-tab ">友情链接</h3>
    <div class="container">
        <ul class="text-justify">
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">找工作</a></li>
        </ul>
    </div>
</div>
<script>
    $(document).ready(function(){
        //比较简洁，细节可自行完善
        $('#uploadSubmit').click(function() {
            var data = new FormData($('#uploadForm')[0]);
            $.ajax({
                url: 'fileUpload',
                type: 'POST',
                data: data,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function(data) {
                    var data = JSON.parse(data);

                    if(data.code===200&&data.message==="success"){
                        // 上传图片成功之后
                        var avatar = data.data.url;
                        getMyInfo(avatar);

                    }
                },
                error: function(data) {
                    console.log(data.status);
                }
            });
        });
        function putUserInfo(userInfo){
            console.log(userInfo);
            $.ajax({
                url: 'myInfo',
                type: 'PUT',
                data:JSON.stringify(userInfo),
                contentType:"application/json",
                success: function(res) {
                    var res = JSON.parse(res);
                    if(res.code===200&&res.message==="success"){
                        alert("更新成功");
                        window.location.href="home";
                    }
                },
                error: function(data) {
                    alert("请求失败")
                }
            });
        }
        function getMyInfo(avatar){
            $.ajax({
                url: 'myInfo',
                type: 'GET',
                success: function(res) {
                    var res = JSON.parse(res);
                    if(res.code===200&&res.message==="success"){
                        var userInfo = res.data;
                        userInfo.avatar = avatar;
                        putUserInfo(userInfo);
                    }
                },
                error: function(data) {
                    alert("请求失败")
                }
            });
        }
        /**
         * 自动将form表单封装成json对象
         */
        $.fn.serializeObject = function() {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function() {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [ o[this.name] ];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    })
</script>