angular.module("myApp").controller('addCtrl',function ($scope,$state,$http,$stateParams,FileUploader,picktype_add,pick_industry,ArticleService) {
    $scope.picktype_add=picktype_add;
    $scope.pick_industry=pick_industry;
    let vm =this;
    //图片上传
    let uploader=$scope.uploader=new FileUploader();/*实例化一个FileUploader对象*/
    uploader.url='/carrots-admin-ajax/a/u/img/task';/*以下是设置了两个必须的属性*/
        uploader.queueLimit= 1;//文件个数
        uploader.queue=[];
    uploader.onSuccessItem = function(fileItem, response, status, headers) {
        $scope.imgSrc =response.data.url;
    };
    uploader.onErrorItem = function( fileItem, response, status) {
        if(status===413){
            bootbox.alert('图片太大了。')
        }
    };
    $scope.removeSrc=function(){
        $scope.imgSrc=false;//清除图片
    };
    $scope.goBack= function() {
        $state.go('backstage.list')
    };//取消按钮后退
//wangEditor富文本编辑器
    let E = window.wangEditor;
    let editor = new E('#wang');
    editor.customConfig.menus = [
        'bold',  // 粗体
        'fontSize',  // 字号
        'fontName',  // 字体
        'italic',  // 斜体
        'underline',  // 下划线
        'foreColor',  // 文字颜色
        'justify',  // 对齐方式
        'emoticon',  // 表情
        'image',  // 插入图片
        'code',  // 插入代码
        'undo',  // 撤销
        'redo'  // 重复
    ];
    editor.create();
//params 整合
    vm.params={};
    vm.set_params = function () {
        vm.params.title= $scope.add_title;
        vm.params.type= $scope.add_type;
        vm.params.industry= $scope.add_industry;
        vm.params.content= editor.txt.html();
        vm.params.url= $scope.add_url;
        vm.params.img= $scope.imgSrc;
    };
    //提交按钮
    $scope.submit=function (x) {
        vm.set_params();
        vm.params.status = x;
        ArticleService.addArticle(vm.params).then(function (res) {
            if (res.data.code === 0) {
                bootbox.alert("新增成功");
                $scope.goBack();
            } else {
                bootbox.alert(res.data.message);
            }
        });
    };
    //编辑按钮跳过来传参
    $scope.headText="新增";
    if( $stateParams.id){
        $scope.headText="编辑";
        ArticleService.getArticle($stateParams.id).then(function (response) {
            $scope.add_title =response.data.data.article.title;
            $scope.add_type =response.data.data.article.type;
            $scope.add_industry =response.data.data.article.industry  ;
            editor.txt.html(response.data.data.article.content);
            $scope.add_url =response.data.data.article.url;
            $scope.imgSrc =response.data.data.article.img;
            // let {title,type,industry,content,url,img}=response.data.data.article;
            // let test={title,type,industry,content,url,img};//解构提取想要的值
            // console.log(test);
        });
        $scope.submit=function (x) {
            vm.set_params();
            vm.params.status=x;
            vm.params.createAt =new Date().getTime();
            ArticleService.editArticle( $stateParams.id, vm.params).then(function (res) {
                if (res.data.code === 0) {
                    bootbox.alert("编辑成功");
                    $scope.goBack();
                } else {
                    bootbox.alert(res.data.message);
                }
            });
        };
    }
}) ;
