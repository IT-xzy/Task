myApp.controller('artCtrl',function($http,$scope,$state,$stateParams,list,industry1){
    $scope.list = list;
    $scope.industry1 = industry1;
    $scope.id = $state.params.id;//传过来的参数id值赋值给$scope.id
    console.log($scope.id);//确认是否有id值，能看出从哪个按钮过来
    console.log($state.params);//$stateParams里的数据信息
    if($scope.id === undefined){
        //新增页面
        console.log('新增页面');
        $scope.title1 = "新增Article";
    }else{
        //编辑页面
        console.log('编辑页面');
        $scope.title1 = "编辑Article";
        $http({
            method: 'get',
            url: '/carrots-admin-ajax/a/article/' + $scope.id,
            headers:{"Content-Type":"application/x-www-form-urlencoded"}
        }).then(function successCallback(respond){
            console.log(respond);
            if(respond.data.code === 0){
                $scope.respond = respond.data.data.article;
                $scope.title = $scope.respond.title;//名称
                console.log($scope.title);
                $scope.paramsType = ($scope.respond.type).toString();//类型
                console.log($scope.paramsType);
                $scope.src = $scope.respond.img;//图片
                console.log($scope.src);
                $scope.content = $scope.respond.content;//说明
                console.log($scope.content);
                $scope.url = $scope.respond.url;//跳转链接
                console.log($scope.url);
                $scope.industryNum =($scope.respond.industry).toString();//行业下拉框
                console.log($scope.industryNum);
                $scope.createAt = $scope.respond.createAt;
                console.log($scope.createAt);
            }else{
                alert(respond.data.message);
            }
        });
    }

    // //选择文件
    // $scope.fileReader = new FileReader();//创建FileReader接口
    // $scope.fileChanged = function(respond){
    //     $scope.$apply(function(){
    //         console.log(respond);
    //         $scope.files = respond.files[0];//保存要上传的图片信息到files,.respond.files[0]表示选择第一个上传的文件的数据。input标签设置了multiple属性的话，当上传两个文件时，则ele.files[1]可以选择到第二个上传的文件的数据。
    //         console.log($scope.files);
    //         $scope.input = respond; //保存input file这个DOM节点
    //         console.log($scope.input);
    //         $scope.fileName = $scope.files.name;//文件的名
    //         console.log($scope.fileName);
    //         $scope.fileSize = $scope.files.size/1024/1024;//文件大小
    //         console.log($scope.fileSize);
    //         $scope.progress=0;
    //     });
    // };

    // // 上传图片
    // $scope.upload = function(){
    //     //创建FormData用来存放上传的参数
    //     var formData = new FormData();
    //     //调用FileReader对象的方法，readAsDataURL该方法将文件读取为一段以 data: 开头的字符串，这段字符串的实质就是 Data URL，Data URL是一种将小文件直接嵌入文档的方案。这里的小文件通常是指图像与 html 等格式的文件
    //     $scope.fileReader.readAsDataURL($scope.files);
    //     //用append()方法以键值对的形式把参数存入formData中，按照接口文档请求参数key为file，value为上传的文件
    //     formData.append("file",$scope.files);
    //     console.log($scope.fileSize);
    //     if($scope.fileSize <= 5242880){
    //         $http({
    //             method: 'post',
    //             url: '/carrots-admin-ajax/a/u/img/task',
    //             data: formData,
    //             headers:{"Content-Type":undefined},
    //             //将事件侦听器绑定到XMLHttpRequest上传对象。用来监听progress事件，这个事件会在读取中时会触发。
    //             uploadEventHandlers: {
    //                 progress: function(respond){
    //                     console.log(respond);
    //                     //respond.loaded为已上传文件的大小，respond.total为要上传文件的总大小。两者相除得到的$scope.progress值是用来表示进度条的
    //                     $scope.progress = (respond.loaded/respond.total)*100;
    //                     console.log($scope.progress);
    //                 }
    //             }
    //         }).then(function successCallback(respond){
    //             $scope.status = respond.data.message;
    //             $scope.src = respond.data.data.url;
    //             console.log($scope.src);
    //             $scope.okIcon=true;
    //         });
    //     }else{
    //         alert('文件大于5MB');
    //         $scope.removeIcon=true;
    //     }
    // };
    //
    // //删除图片
    // $scope.delete = function(){
    //     $scope.src = undefined;
    //     $scope.fileName = '';
    //     $scope.progress = 0;
    //     $scope.input.value = '';// 防止删除一个文件后不能再次上传同一个文件的问题
    //     $scope.okIcon=false;
    // };

    //上线
    $scope.upLine = function(){
     if($scope.id === undefined){
         //新增页面
         $http({
             method: 'post',
             url: '/carrots-admin-ajax/a/u/article/',
             params: {
                 title: $scope.title,//名称
                 type: $scope.paramsType,//类型
                 status: 2,//上线
                 img: $scope.src,//图片
                 content: $scope.content,//说明
                 url: $scope.url,//跳转链接
                 industry:  $scope.industryNum//行业下拉框
                 },
             headers:{"Content-Type":"application/x-www-form-urlencoded"}
         }).then(function successCallback(respond){
             console.log($scope.industry);
             if(respond.data.code === 0){
                 bootbox.alert('成功上线');
                 $state.go('backstage.list',{
                     reload: true
                 })
             }else{
                 bootbox.alert('上线失败');
             }
         })
     }else{
         //编辑页面

         $http({
             method: 'put',
             url: '/carrots-admin-ajax/a/u/article/' + $scope.id,
             params: {
                 title: $scope.title,
                 type: $scope.paramsType,
                 status: 2,//上线
                 img: $scope.src,
                 content: $scope.content,
                 url: $scope.url,
                 industry: $scope.industryNum,
                 createAt: $scope.createAt
             },
             headers:{"Content-Type":"application/x-www-form-urlencoded"}
         }).then(function successCallback(respond){

             if(respond.data.code === 0){
                 bootbox.alert('成功上线');
                 $state.go('backstage.list',{
                     reload: true
                 })
             }else{
                 bootbox.alert('上线失败');
             }
         })
     }
    };

    //保存草稿
    $scope.save = function(){
        if($scope.id === undefined){
            //新增页面
            $http({
                method: 'post',
                url: '/carrots-admin-ajax/a/u/article/',
                params: {
                    title: $scope.title,//名称
                    type: $scope.paramsType,//类型
                    status: 1,//保存草稿
                    img: $scope.src,//图片
                    content: $scope.content,//说明
                    url: $scope.url,//跳转链接
                    industry:  $scope.industryNum//行业下拉框
                },
                headers:{"Content-Type":"application/x-www-form-urlencoded"}
            }).then(function successCallback(respond){
                console.log($scope.industry);
                if(respond.data.code === 0){
                    bootbox.alert('保存草稿成功');
                    $state.go('backstage.list',{
                        reload: true
                    })
                }else{
                    bootbox.alert('保存草稿失败');
                }
            })
        }else{
            //编辑页面

            $http({
                method: 'put',
                url: '/carrots-admin-ajax/a/u/article/' + $scope.id,
                params: {
                    title: $scope.title,
                    type: $scope.paramsType,
                    status: 1,//保存草稿
                    img: $scope.src,
                    content: $scope.content,
                    url: $scope.url,
                    industry: $scope.industryNum,
                    createAt: $scope.createAt
                },
                headers:{"Content-Type":"application/x-www-form-urlencoded"}
            }).then(function successCallback(respond){

                if(respond.data.code === 0){
                    bootbox.alert('保存草稿成功');
                    $state.go('backstage.list',{
                        reload: true
                    })
                }else{
                    bootbox.alert('保存草稿失败');
                }
            })
        }
    };

    //取消
    $scope.remove = function(){
        var remove = confirm('放弃本次编辑？');
        if(remove === true){
            $state.go('backstage.list');
        }else{
            return false;
        }
    };

});
