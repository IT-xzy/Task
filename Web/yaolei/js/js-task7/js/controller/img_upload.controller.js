//最后一个页面
angular.module('myApp').controller('AppController', function($scope,$http,$state,$stateParams,lists3,lists4) {
    //上传图片
    $scope.newArticle = '新增Article';
    $scope.ajaxAds = '/carrots-admin-ajax/a/u/img/task';
    // FileUploader.FileSelect.prototype.isEmptyAfterSelection = function () {
    //     return true;
    // };
    // $scope.uploader = new FileUploader({
    //     url: '/carrots-admin-ajax/a/u/img/task'
    // });
    // $scope.uploader2 = new FileUploader({
    //     url: '/carrots-admin-ajax/a/u/img/task'
    // });

    // $scope.uploader2.filters.push({
    //     name: 'syncFilter',
    //     fn: function(item, options) {
    //         console.log('syncFilter');
    //         return this.queue.length < 10;
    //     }
    // });
    // $scope.uploader2.filters.push({
    //     name: 'asyncFilter',
    //     fn: function(item, options, deferred) {
    //         console.log('asyncFilter');
    //         setTimeout(deferred.resolve, 1e3);
    //     }
    // });
    //
    // $scope.uploader2.onCompleteItem = function(fileItem, response) {
    //     $scope.m = response.data.url;
    //     console.log($scope.m)
    // };
    // $scope.uploader2.onCompleteAll = function() {
    // };
    //
    // $scope.img_del = function () {
    //     $scope.m = null
    // };
    //2个下拉菜单
    $scope.sites = lists3;
    //设定默认值
    $scope.select = $scope.sites[0];

    $scope.sites2 = lists4;
    $scope.selected = $scope.sites2[0];

    //富文本编辑器wangEditor
    $scope.editor = new wangEditor('div1');
    $scope.editor.create();


    $scope.submit = function (x) {
        //获取编辑器内容,官方给定的API
        $scope.http = $scope.editor.$txt.text();
        console.log($scope.http);
        //递交新增的article
        $http({
            method:'post',
            url:'/carrots-admin-ajax/a/u/article',
            params:{
                title:$scope.title,
                type:$scope.select.id,
                status:x,
                img:$scope.m,
                content:$scope.http,
                url:$scope.link,
                industry:$scope.selected.id
            }
        }).then(function successCallback(data) {
            console.log(data);
            if(data.data.code===0){
                $state.go('houtai.js6-2')
            }else {
                alert('操作失败!')
            }
        })
    };
    //正则表达式判定链接内容是否有效
    $scope.linkList = function () {
        $scope.reg = /^((https|http|ftp|rtsp|mms)?:\/\/)[^\s]+/;
        $scope.test = $scope.reg.test($scope.link);
        if($scope.test ===false){
            $scope.error = '请以http://样式开头，否则不通过！'
        }else {
            $scope.error = ''
        }
    };

//如果接受到参数则进行编辑流程
    if($stateParams.id) {
        //字符串转化成对象
        $scope.newArticle = '编辑Article';
        var n = JSON.parse($stateParams.json);
        console.log(n);
        $scope.title = n.title;
        $scope.select = $scope.sites[n.type + 1];
        $scope.editor.$txt.html(n.content);
        $scope.m = n.img;
        $scope.link = n.url;
        $scope.reg = /^((https|http|ftp|rtsp|mms)?:\/\/)[^\s]+/;
        $scope.test = $scope.reg.test($scope.link);
        if($scope.test ===false){
            $scope.error = '请以http://样式开头，否则不通过！'
        }else {
            $scope.error = ''
        }
        $scope.selected = $scope.sites2[n.industry + 1];
        $scope.submit = function (x) {
            $scope.http = $scope.editor.$txt.text();
            console.log($scope.html);
            if($scope.select.id !==3){
                $scope.selected = {};
            }
            //递交编辑后的内容
            $http({
                method:'put',
                url:'/carrots-admin-ajax/a/u/article/'+$stateParams.id,
                params:{
                    title:$scope.title,
                    type:$scope.select.id,
                    status:x,
                    img:$scope.m,
                    content:$scope.http,
                    url:$scope.link,
                    industry:$scope.selected.id,
                    createAt:n.createAt
                }
            }).then(function successCallback(data) {
                console.log(data);
                if(data.data.code===0){
                    $state.go('houtai.js6-2')
                }else {
                    alert('操作失败!')
                }
            })
        }
    }
//这边用来获取图片的64位字符串，暂时不用
// $scope.reader = new FileReader();   //创建一个FileReader接口
// $scope.img_upload = function(files) {       //单次提交图片的函数
//     $scope.guid = (new Date()).valueOf();   //通过时间戳创建一个随机数，作为键名使用
//     $scope.reader.readAsDataURL(files[0]);  //FileReader的方法，把图片转成base64
//     $scope.reader.onload =function (e) {
//         $scope.$apply(function () {
//             $scope.thumb[$scope.guid] = {
//                 imgSrc: e.target.result  //接收base64
//             };
//         });
//     };
// };
// $scope.form = {     //用于绑定提交内容，图片或其他数据
//     image:{}
// };
// $scope.thumb = {};
// $scope.img_del = function(key) {    //删除，删除的时候thumb和form里面的图片数据都要删除，避免提交不必要的
//     var guidArr = [];
//     for(var p in $scope.thumb){
//         guidArr.push(p);
//     }
//     delete $scope.thumb[guidArr[key]];
//     delete $scope.form.image[guidArr[key]];
// };
});


