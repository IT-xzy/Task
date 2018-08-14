angular.module('myApp')
    .controller("addArticleController", function ($scope, $http, $state,articleConstant, addtype,deg) {
        var E = window.wangEditor;
        var editor = new E('#editor');
        editor.create();
        $scope.params = {};
        $scope.selectype = articleConstant.typeItem; //填入type类型列表
        $scope.params.type = undefined; //设置默认type类型列表样式
        $scope.industry = addtype.industry; //填入当type。类型为行业大图的时候
        $scope.params.status = undefined; //设置默认像industry显示
        var imgInput = document.getElementById("image-file"); // 捕捉上传图片节点
        var imgfile; //捕捉上传文件的第一个节点
        var imgPreview = document.getElementById('image-preview'); //捕捉配图浏览区
        imgPreview.src = '';
        var img; //定义上传的图片数据
        imgInput.addEventListener('change', function () { //上传按钮的change事件
            $scope.imgchange = false; //去除进度条
            // 数据清空
            $scope.params.img = undefined;
            imgfile = imgInput.files[0]; //捕捉上传文件的第一个节点
            var read = new FileReader(); //建立图片读取对象
            read.readAsDataURL(imgfile); //添加64位编码、
            read.onload = function (e) { //当图片加载成功添加链接
                let result = e.target.result; //读取64位编码
                // console.log(result);
                imgPreview.src = result;
            };
            img = new FormData();
            console.log(imgfile);
            img.append('file', imgfile);
            // console.log(img);
            $scope.$apply(
                function () {
                    $scope.imgName = imgfile.name, //显示图片名称
                        $scope.imgSize = imgfile.size; //显示图片大小
                }
            );
            $scope.$apply(
                function () {
                    $scope.imgTip = '请上传'; //清楚消息
                }
            );
        });
        $scope.up = function () { //上传请求
           deg.img(img).then(function (resp) {
                console.log(resp);
                if (resp.data.code == 0) {
                    $scope.imgTip = '上传成功'; //重置信息  
                    $scope.imgchange = true;
                    $scope.params.img = resp.data.data.url;
                    console.log($scope.params.img)
                    // console.log($scope.imgchange);
                 } 
            },function(){
                $scope.imgTip = '图片过大，请选择1M以下的文件'; //显示报错
            });
        };
        $scope.del = function () { //删除函数
            $scope.imgchange = false; //取消进度条
            imgPreview.src = ''; //显示图片为空
            $scope.imgTip = '请上传图片'; //提示上传图片
            //文字提示清空
            $scope.imgName = '';
            $scope.imgSize = '';
            // 数据清空
            $scope.params.img = undefined;
        };
        $scope.upLoading = function (load) {
            // console.log($scope.params)
            $scope.params.status = load;
            $scope.params.content=editor.txt.html();
           deg.addArticle($scope.params).then(
                function(resp){
                    if(resp.data.code==0){
                        $state.go('u.article')
                    }
                }
            )
        };
    });