
app.controller('addListCtrl',function ($scope,$state,$http,$stateParams,myTypes,myIndustry) {
    //载入页面时
    $scope.Types = myTypes.slice(1);//取出type
    $scope.Industry = myIndustry;//取出industry
    $scope.id = $stateParams.id;//get out "id"
    $scope.showMe = false;
    console.log($stateParams);
    if(!$scope.id){//新增页面
        $scope.titleA='新增Article';
        console.log('new page');
    }else{
        $scope.titleA='编辑Article';
        $http({
            method: 'GET',
            url: '/carrots-admin-ajax/a/article/'+$scope.id,
            headers:{"Content-Type":"application/x-www-form-urlencoded"}
        }).then(function callBackSuccess(res) {
            if(res.data.code===0){
                console.log(res);
                $scope.list=res.data.data.article;
                $scope.type=$scope.list.type;
                $scope.title=$scope.list.title;
                $scope.content=$scope.list.content;
                $scope.url=$scope.list.url;
                $scope.img=$scope.list.img;
                $scope.industry=$scope.list.industry;
                $scope.createAt=$scope.list.createAt;//以上数据为取出的response
                //初始化数据
                //将Type数组的第$scope.type项赋给select当前项
                $scope.currentType=$scope.Types[$scope.type];//默认选择的type
                $scope.currentIndustry=$scope.Industry[$scope.industry];//默认选择的industry
                console.log($scope.img);
                console.log("img-src打印："+$scope.img);
            }else{
                alert(res.data.message);
            }
        });
    }
    //选择文件
    // $scope.uploadImage=function (fu) {
    //     $scope.$apply(function () {
    //         console.log(fu);//fu即为input元素
    //         $scope.INPUT= fu;//将这个input元素节点赋给INPUT
    //         $scope.file=fu.files[0];
    //         $scope.fileName=$scope.file.name;
    //         $scope.fileSize=$scope.file.size;
    //         console.log($scope.fileName);
    //         $scope.progress=0;
    //         $scope.showMe=true;
    //     })
    // };
    // //上传图片/删除图片
    // $scope.fr=new FileReader();//创建fileReader接口
    // $scope.upload=function(){
    //     //创建FormDate
    //     let formData=new FormData();
    //     //调用FileReader的readAsDataURL方法
    //     $scope.fr.readAsDataURL($scope.file);
    //     //将数据以append方法传给formDate
    //     formData.append('file',$scope.file);
    //     $scope.fr.onprogress=function (a) {
    //         console.log("a是什么"+a);
    //     };
    //     //文件大小不得超过5M
    //     if($scope.fileSize < 5242880 ){
    //         $http({
    //             method: 'POST',
    //             url: '/carrots-admin-ajax/a/u/img/task/',
    //             data: formData,
    //             dataType: 'json',
    //             headers: {"Content-Type": undefined},
    //             uploadEventHandlers: {//upload事件监听
    //                 progress: function (res) {
    //                     console.log(res);
    //                     $scope.progress = (res.loaded/res.total)*100;
    //                     console.log($scope.progress);
    //                 }
    //             }
    //         }).then(function successCallBack(response) {
    //             console.log(response);
    //             $scope.img= response.data.data.url;
    //             console.log($scope.img);
    //         })
    //     }
    // };
    // //删除上传地图片
    // $scope.deleteImg=function(){
    //     $scope.file='';
    //     $scope.fileName='';
    //     $scope.fileSize='';
    //     $scope.progress=0;
    //     $scope.img='';
    //     $scope.INPUT.value = '';// 防止删除一个文件后不能再次上传同一个文件的问题
    // };
    //立即上线
    $scope.online=function () {
        if($scope.id){//编辑页面状态
            $http({
                method: 'PUT',
                url: '/carrots-admin-ajax/a/u/article/'+$scope.id,
                params: {
                    title: $scope.title,
                    status: 2,
                    img: $scope.img,
                    url: $scope.url,
                    createAt: $scope.createAt,
                    type: $scope.currentType.type,
                    id: $scope.id,
                    industry: $scope.currentIndustry,
                    content: $scope.content,
                },
                dataType: 'json',
                headers: {'Content-Type': undefined}
            }).then(function successCallBack(res) {
                if(res.data.code===0){
                    bootbox.alert('上线成功');
                    $state.go('frameState.articleList',{},{reload:true})
                }else{
                    bootbox.alert('上线失败');
                }
            })
        }else{//新增页面
            $http({
                method: 'POST',
                url: '/carrots-admin-ajax/a/u/article/',
                params: {
                    status: 2,
                    title: $scope.title,
                    type: $scope.currentType.type,
                    industry: $scope.currentIndustry,
                    content: $scope.content,
                    link: $scope.link,
                    img: $scope.img,
                },
                dataType: 'json',
                headers: {'Content-Type': undefined}
            }).then(function (res) {
                if(res.data.code===0){
                    bootbox.alert('上线成功');
                    $state.go('frameState.articleList',{},{reload:true})
                }else{
                    bootbox.alert('上线失败');
                }
            })
        }
    };
    //存为草稿
    $scope.sketch=function () {
        if($scope.id){//编辑列表
            $http({
                method: 'PUT',
                url: '/carrots-admin-ajax/a/u/article/'+$scope.id,
                params: {
                    id: $scope.id,
                    status: 1,
                    title: $scope.title,
                    type: $scope.currentType.type,
                    industry: $scope.currentIndustry,
                    content: $scope.content,
                    img: $scope.img,
                    createAt: $scope.createAt,
                    url: $scope.url
                },
                dataType: 'json',
                headers: {'Content-Type': undefined}
            }).then(function successCallBack(res) {
                if(res.data.code===0){
                    bootbox.alert('存稿成功');
                    $state.go('frameState.articleList',{},{reload:true})
                }else{
                    bootbox.alert('存稿失败');
                }
            })
        }else{//新增列表
            $http({
                method: 'POST',
                url: '/carrots-admin-ajax/a/u/article',
                params: {
                    status: 1,
                    title: $scope.title,
                    type: $scope.currentType.type,
                    industry: $scope.currentIndustry,
                    content: $scope.content,
                    link: $scope.link,
                    img: $scope.img,
                },
                dataType: 'json',
                headers: {'Content-Type': undefined}
            }).then(function (res) {
                if(res.data.code===0){
                    bootbox.alert('存稿成功');
                    $state.go('frameState.articleList',{},{reload:true})
                }else{
                    bootbox.alert('存稿失败');
                }
            })
        }
    };
    //取消
    $scope.cancel=function () {
        let keep=confirm('确定取消吗？');
        if(keep===true){
            $state.go('frameState.addArticleList',{},{reload:true});
        }else{
            return false;
        }
    };
});


