var app = angular.module('myApp', ['ui.router', 'ui.bootstrap', 'angularFileUpload']);

//过滤数字，改为文字。
app.filter('online', function () {
    return function (text) {
        if (text === 1) {
            return "上线"

        } else if (text === 2) {
            return "下线"
        }
    }
});

app.filter('reverse', function () {
    return function (text) {
        if (text === 1) {
            return "草稿"

        } else if (text === 2) {
            return "上线  "
        }
    }
});
//用filter渲染页面的状态，页面传过来的是数据利用数字去渲染页面，上下一样。
app.filter('else', function () {
    return function (character) {
        if (character === 0) {
            return '首页banner'
        } else if (character === 1) {
            return "找职位banner"
        } else if (character === 2) {
            return "找精英banner"
        } else if (character === 3) {
            return "行业大图"
        }
    }
});
//定义的第一个控制器。
app.controller('myOne', function ($scope, $http, $state, $stateParams, FileUploader) {
    console.log($stateParams);
    //富文本编辑器
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.create();
  //http请求
    function ssasas() {
        //进入页面发送http请求获取接口给的参数。
        $http({
            method: 'get',
            url: 'http://localhost//carrots-admin-ajax/a/article/search',
            headers: {
                "Content-Type": "application/x-www-form-urlencoded;"
            },
            params: {
                //传给http的，这里传的东西是传给http请求的，需要用到这里传的东西请求数据。
                page: $stateParams.page,
                startAt: $stateParams.startAt,
                endAt: $stateParams.endAt,
                type: $stateParams.type,
                status: $stateParams.status
            }
            //给currentPage赋值，保存需要第几页的数据。
        }).then(function fn(omg) {
            //分页总共分几页。
            $scope.totalItems = omg.data.data.total;
            //给datum赋值数据，用datum去页面上渲染数据。
            $scope.datum = omg.data.data.articleList;
        });
    }
    ssasas();
    //go路由传参。
    $scope.one = function () {
        if ($scope.startAt === undefined) {
            $scope.startAt = '';
        } else {
            $scope.startAt = $scope.startAt.getTime();
        }

        if ($scope.endAt === undefined) {
            $scope.endAt = '';
        } else {
            $scope.endAt = $scope.endAt.getTime();
        }
        $state.go('two', {
            //变相路由传给指定的html文件，取得时候用到stateParams，所有的数据全部传进stateParsams里面。
            page: $scope.currentPage,
            startAt: $scope.startAt,
            endAt: $scope.endAt,
            type: $scope.type,
            status: $scope.status
        }, {reload: true});
    };
    //http删除。
    $scope.omit = function (asd) {
        $http({
            method: 'delete',
            url: 'http://localhost//carrots-admin-ajax/a/u/article/' + asd
        });
        //单纯的刷新页面刷新出页面删除的文件。
        $state.go('two', {}, {reload: true}
        );
        console.log('asd')
    };
    //上线下线。
    $scope.line = function (go, to) {
        //弹窗赋值给变量
        var n = confirm('是否确定');
        //点击取消为false 点击确定为true。 把所有需要执行的东西放进确定里面。
        if (n === true) {
            if (to === 1) {
                to = 2
            } else {
                to = 1
            }
            $http({
                method: 'put',
                url: 'http://localhost//carrots-admin-ajax/a/u/article/status',
                params: {
                    id: go,
                    status: to
                }
            })
            $state.go('two', {}, {reload: true})
        }
    }
    //绑定分页的跳转。
    $scope.currentPage = $stateParams.page;

    //侧边栏手风琴
    $scope.myVar = true;
    $scope.toggle = function () {
        $scope.myVar = !$scope.myVar
    };
    //日期插件。
    $scope.format = "yyyy/MM/dd";
    $scope.altInputFormats = ['yyyy/M!/d!'];
    $scope.popup1 = {
        opened: false
    };
    $scope.open1 = function () {
        $scope.popup1.opened = true;
    };
    //日历第二个。
    $scope.popup2 = {
        opened: false
    };
    $scope.open2 = function () {
        $scope.popup1.opened2 = true;
    };
    var uploader = $scope.uploader = new FileUploader({
        url: 'http://localhost//carrots-admin-ajax/a/u/img/task'
    });
    $scope.mm = function () {
        console.log($scope.type)
    };
    //图片上传
    uploader.onSuccessItem = function (fileItem, response, status, headers) {
        console.info('onSuccessItem', fileItem, response, status, headers);
        $scope.img = response.data.url
    };
    //新建数据
    $scope.news = function (status) {
        $http({
            method: 'post',
            url: 'http://localhost//carrots-admin-ajax/a/u/article',
            params: {
                title: $scope.title,
                type: $scope.type,
                status: status,
                img: $scope.omg,
                url: $scope.url,
                industry: $scope.industry
            }
        })
    };
    //数据编辑
    $scope.edit = function (id) {
       $state.go('three',{id:id},{reload: true});
    };
    ////
    $scope.Id=$stateParams.id;
 if($scope.Id!==undefined&&$scope.Id!==''){
     console.log($scope.Id);
     $http({
         method:'get',
         url:'http://localhost//carrots-admin-ajax/a/article/'+$scope.Id
     }).then(function (getData) {
         $scope.title=getData.data.data.article.title;
         $scope.type=getData.data.data.article.type;
         $scope.type= $scope.type.toString();
         $scope.createAt=getData.data.data.article.createAt;
         $scope.content=getData.data.data.article.content;
         $scope.url=getData.data.data.article.url;
         $scope.img=getData.data.data.article.img;
         console.log($scope.content)
     });

 }
    $scope.editor=function (status) {
     if($scope.Id) {
         $http({
             method: 'put',
             url: 'http://localhost//carrots-admin-ajax/a/u/article/' + $scope.Id,
             params: {
                 title: $scope.title,
                 status: status,
                 img: $scope.img,
                 content: $scope.content,
                 url: $scope.url,
                 industry: $scope.industry,
                 createAt: $scope.createAt,
                 type: $scope.type
             }
         })
     }else{
         $http({
             method: 'post',
             url: 'http://localhost//carrots-admin-ajax/a/u/article/',
             params: {
                 title: $scope.title,
                 status: status,
                 img: $scope.img,
                 content: $scope.content,
                 url: $scope.url,
                 industry: $scope.industry,
                 createAt: $scope.createAt,
                 type: $scope.type
             }
         })
     }
    }
});
// app.controller('myCtrl',function ($http,$scope,$stateParams,FileUploader) {

    // $scope.Id=$stateParams.id;
    // $http({
    //     method:'get',
    //     url:'http://localhost//carrots-admin-ajax/a/article/'+$scope.Id
    // }).then(function (getData) {
    //     $scope.title=getData.data.data.article.title;
    //     $scope.type=getData.data.data.article.type;
    //     $scope.type= $scope.type.toString();
    //     $scope.createAt=getData.data.data.article.createAt;
    //     $scope.content=getData.data.data.article.content;
    //     $scope.url=getData.data.data.article.url;
    //     $scope.img=getData.data.data.article.img;
    // });
    // $scope.edit=function (status) {
    //     $http({
    //         method:'put',
    //         url:'http://localhost//carrots-admin-ajax/a/u/article/'+$scope.Id,
    //         params:{
    //             title:$scope.title,
    //             status:status,
    //             img:$scope.img,
    //             content:$scope.content,
    //             url:$scope.url,
    //             industry:$scope.industry,
    //             createAt:$scope.createAt,
    //             type:$scope.type
    //         }
    //     })
    // }
// });
//路由跳转
//路由接受参数
app.config(['$stateProvider', function ($stateProvider) {
    $stateProvider
        .state('one', {
            url: '/one',
            template: '<h1>Welcome</h1>'
        })
        .state('two', {
            url: '/two/:page/:startAt/:endAt/:type/:status/',
            templateUrl: 'JS6-2.html'
        })
        .state('three', {
            url: '/three/:id',
            templateUrl: 'JS6-3.html'
        })
}]);
