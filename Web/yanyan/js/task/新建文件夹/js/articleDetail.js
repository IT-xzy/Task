angular.module("myApp", ['angularFileUpload', 'ngMessages'])
    .controller("detailCtrl", function ($scope, $state, $http, types, addIndustry, FileUploader) {
        //常量
        $scope.types = types;
        $scope.addIndustry = addIndustry;
        $scope.params = $state.params;
        console.log($scope.params);
        $scope.id = $state.params.id || '';

        $scope.reg = /^([hH][tT]{2}[pP]:\/\/|[hH][tT]{2}[pP][sS]:\/\/)(([A-Za-z0-9-~]+)\.)+([A-Za-z0-9-~\/])+$/;

        // 上传图片插件
        $scope.uploader = new FileUploader({
            url: "/carrots-admin-ajax/a/u/img/task",
            queueLimit: 1
        });
        $scope.uploader.onSuccessItem = function (a, response) {
            $scope.params.img = response.data.url;
            console.log($scope.params.img);
        };


        //富文本编辑器
        var E = window.wangEditor;
        var editor = new E('#editor');
        editor.customConfig.onchange = function (html) {
            // html 即变化之后的内容
            console.log(html);
            $scope.params.content = html;
        };
        editor.customConfig.menus = [
            'head',  // 标题
            'bold',  // 粗体
            'italic',  // 斜体
            'underline',  // 下划线
            'strikeThrough',  // 删除线
            'foreColor',  // 文字颜色
            'backColor',  // 背景颜色
            'link',  // 插入链接
            'list',  // 列表
            'justify',  // 对齐方式
            'quote',  // 引用
            'code',  // 插入代码
            'undo',  // 撤销
            'redo'  // 重复
        ];
        editor.create();


        //编辑页&新增页----由孙剑立师兄指导后的成果
        if ($scope.id !== "") {
            $scope.addEdit = "编辑Article";
            method = "PUT";
            $http.get(
                "/carrots-admin-ajax/a/article/" + $scope.id
            ).then(function (res) {
                if(res.data.code === 0){
                    $scope.params = res.data.data.article;
                    console.log($scope.params);
                    //与富文本编辑器文本框绑定
                    editor.txt.html($scope.params.content);
                }else {
                    alert(res.data.message);
                }
            });
        }
        else {
            $scope.addEdit = "新增Article";
            method = "POST";
        }
        $scope.publish = function (status) {
            $scope.params.status = status;
            $http({
                method: method,
                url: "/carrots-admin-ajax/a/u/article/" + $scope.id,
                params: $scope.params,
                header: {"Content-Type": "application/x-www-form-urlencoded"}
            }).then(function (res) {
                if (res.data.code === 0) {
                    alert("编辑成功");
                    $state.go("main.article")
                } else {
                    alert(res.data.message);
                }
            })
        };


        //取消按钮
        $scope.cancel = function (abandon) {
            $scope.confirm = confirm(abandon);
            if ($scope.confirm === true) {
                $state.go("main.article")
            }
        };


        // 图片预览插件
        var fileInput = document.querySelector('input[type=file]'),
            previewImg = document.querySelector('img');
        fileInput.addEventListener('change', function () {
            var file = this.files[0];
            var reader = new FileReader();
            // 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
            reader.addEventListener("load", function () {
                previewImg.src = reader.result;
            }, false);
            // 调用reader.readAsDataURL()方法，把图片转成base64
            reader.readAsDataURL(file);
        }, false);
    });
