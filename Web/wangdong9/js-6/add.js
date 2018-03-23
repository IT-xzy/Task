/**
 * Created by Administrator on 2017/12/27.
 */
angular.module ('app')
 .controller('AppController',  function($scope, FileUploader,$stateParams,$http,$state) {
    // $scope.selected=$stateParams.type;
    // console.log($stateParams.type);
    $scope.types=[
        {value: '',name:'请选择'},
        {value:0,   name:'首页banner'},
        {value:1, name:'找职位banner'},
        {value:2, name:'找精英banner'},
        {value:3, name:'行业大图'}
    ];
     $scope.industrys=[
         {value: '',name:'请选择'},
         {value:0,   name:'移动互联网'},
         {value:1, name:'电子商务'},
         {value:2, name:'企业服务'},
         {value:3, name:'020'},
         {value:4,   name:'教育'},
         {value:5, name:'金融'},
         {value:6, name:'游戏'}
     ];
    id=$stateParams.id;
// console.log(id);
    if(!id){
        var  uploader = $scope.uploader = new FileUploader();
        uploader.url='/carrots-admin-ajax/a/u/img/task';
        // FILTERS
        console.log(uploader);
        uploader.onAfterAddingFile = function(fileItem) {   //添加图片之后
            console.info('onAfterAddingFile', fileItem);
            console.log($scope.imgtitle)
        };
//图片上传成功后获取图片的url
        uploader.onSuccessItem = function(data,fileItem) {
            console.log(fileItem);
            // console.info('onSuccessItem', fileItem, response, status, headers);
            $scope.imageSrc1 = fileItem.data.url ;
            console.log( $scope.imageSrc1);
            $scope.params.img=$scope.imageSrc1;
        };
        $scope.params={};
        $scope.up=function (data) {
            $.ajax({
                type:'POST',
                url: '/carrots-admin-ajax/a/u/article',
                datatype:'json',
                data:$scope.params,
                success:function (data) {
                    dataa =JSON.parse(data);
                }
            })
        };
        
        $scope.online=function (data,fileItem) {
            $scope.params.content=editor.txt.text();
            console.log($scope.params);
            console.log($scope.params);
            console.log($scope.imageSrc1);
            $scope.params.status='2';
            $scope.up($scope.params);
        };
        $scope.ifonline=function (data, fileItem) {
            $scope.online(data, fileItem);
            bootbox.alert("上线成功");
            $state.go('page.page3')
        };
        
        $scope.draft=function (data,fileItem) {
            $scope.params.content=editor.txt.text();
            console.log($scope.params);
            console.log($scope.params);
            console.log($scope.imageSrc1);
            $scope.params.status='1';
            $scope.up($scope.params);
        };
        $scope.ifdraft=function (data, fileItem) {
            $scope.draft(data, fileItem);
            bootbox.alert("存草稿成功");
            $state.go('page.page3');
        };
        var E = window.wangEditor;
        var editor = new E('#editor');
        editor.customConfig.uploadFileName = 'file';
        editor.customConfig.uploadImgServer = '/carrots-admin-ajax/a/u/img/task' ; // 上传图片到服务器
        editor.customConfig.uploadImgHooks = {
            success: function (xhr, editor, result) {
                console.log(result);
            },
            customInsert: function (insertImg, result, editor) {
                var url = result.data.url;
                insertImg(url);
                // result 必须是一个 JSON 格式字符串！！！否则报错
            }
        };
        editor.create();
    }
    else {
        console.log(id);
        (function () {
            $http({
                method:'get',
                url:'/carrots-admin-ajax/a/article/'+id,
                params:{}
            }).then(function (responce) {
                if(responce.data.code==0) {
                    console.log(responce);
                    $scope.params=responce.data.data.article;
                    editor.txt.html($scope.params.content);
                }
            });
        })();
        var uploader = $scope.uploader = new FileUploader();
        uploader.url = '/carrots-admin-ajax/a/u/img/task';
        // FILTERS
        console.log(uploader);
        uploader.onAfterAddingFile = function (fileItem) {   //添加图片之后
            console.info('onAfterAddingFile', fileItem);
        };
//图片上传成功后获取图片的url
        uploader.onSuccessItem = function (data, fileItem) {
            console.log(fileItem);
            // console.info('onSuccessItem', fileItem, response, status, headers);
            $scope.imageSrc1 = fileItem.data.url;
            console.log($scope.imageSrc1);
            if(!$scope.imageSrc1){
                console.log($scope.params.img);
            }
            else{
                $scope.params.img=$scope.imageSrc1;
                console.log( $scope.params.img);
            }
        };
        $scope.params = {};
        $scope.eup=function (data) {
            $.ajax({
                type:'put',
                url: '/carrots-admin-ajax/a/u/article/'+id,
                datatype:'json',
                data:$scope.params,
                success:function (data) {
                    dataa =JSON.parse(data);
                    console.log(dataa);
                }
            })
        };
        $scope.online = function (data, fileItem) {
            $scope.params.content=editor.txt.text();
            console.log($scope.params);
            $scope.eup($scope.params);
        };
        $scope.ifonline=function (data, fileItem) {
            $scope.online(data, fileItem); 
            bootbox.alert("上线成功");
            $state.go('page.page3')
        };
        
        $scope.draft=function (data,fileItem) {
            $scope.params.content=editor.txt.text();
            console.log($scope.params);
            console.log($scope.params);
            console.log($scope.imageSrc1);
            $scope.params.status='1';
            $scope.eup($scope.params);
        };
        $scope.ifdraft=function (data, fileItem) {
            $scope.draft(data, fileItem);
            bootbox.alert("存草稿成功");
            $state.go('page.page3')
        };
        var E = window.wangEditor;
        var editor = new E('#editor');
        editor.customConfig.uploadFileName = 'file';
        editor.customConfig.uploadImgServer = '/carrots-admin-ajax/a/u/img/task' ; // 上传图片到服务器
        editor.customConfig.uploadImgHooks = {
            success: function (xhr, editor, result) {
                console.log(result);
            },
            customInsert: function (insertImg, result, editor) {
                var url = result.data.url;
                insertImg(url);
                // result 必须是一个 JSON 格式字符串！！！否则报错
            }

        };
        editor.create();
    }
});