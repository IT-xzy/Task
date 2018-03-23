/**
 * Created by Administrator on 2018/1/5.
 */
// ['ui.bootstrap']
var m=angular.module ('app',['ui.router','ui.bootstrap','angularFileUpload']);

m .config(['$stateProvider','$urlRouterProvider',function ($stateProvider,$urlRouterProvider) {
    //默认页
    $urlRouterProvider.otherwise('/login');
    //路由规则
    $stateProvider
        .state('login',{
            url:'/login',
            templateUrl:'js-6.1.html',
            controller:'aController'

        })
        .state('page',{
            url:'/page',
            templateUrl:'js-6.2.html'
            // controller:'bController'
        })
        .state('page.welcome',{
            url:'/welcome',
            templateUrl:'son/welcome.html'
        })
      .state('page.page1',{
        url:'/page1',
        templateUrl:'son/page1.html'
    })
    .state('page.page2',{
        url:'/page2',
        templateUrl:'son/page2.html'
    })
    .state('page.page3',{
        url:'/page3',
        templateUrl:'son/page3.html'
    })
    .state('page.page4',{
        url:'/page4/?:id',
        templateUrl:'son/page4.html'
    });
}
]);
m.controller('aController',function ($scope,$state,$http) {
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            $('#on').click();
        }
    });
    $scope.name='';
    $scope.pass='';

    $scope.on=function () {
        var user = $scope.name;
        console.log(user);
        var pass = $scope.pass;
        console.log(pass);
        $http({
            method:'POST',
            url:'/carrots-admin-ajax/a/login',
            params:{
                'name':user,
                'pwd':pass
            }
        }).then(function(responce){
//响应成功
            console.log(responce);
//             var data=JSON.parse(data);
//             console.log(data);
            if (responce.data.code==0) {
                // var data=JSON.parse(data);
                console.log(responce);
                $state.go('page.welcome')
            }
            else{
                $("#message").html(responce.data.message)
            }
        }),function err(responce){
//处理响应失败
            $("#message").html(responce.data.message)
        };

    };
});
m.controller('bController',function ($scope,$state) {
    $(function () {
        var Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;
            var links = this.el.find('.link');
            links.on('click', {
                el: this.el,
                multiple: this.multiple
            }, this.dropdown);
        };
        Accordion.prototype.dropdown = function (e) {
            var $el = e.data.el;
            $this = $(this);$next = $this.next();
            $next.slideToggle();
            $this.parent().toggleClass('open');
            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
            }
        };
        var accordion = new Accordion($('#accordion'), false);
        
    });
    $(function a() {
        var Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;
            var links = this.el.find('.link');
            links.on('click', {
                el: this.el,
                multiple: this.multiple
            }, this.dropdown);
        };
        Accordion.prototype.dropdown = function (e) {
            var $el = e.data.el;
            $this = $(this);$next = $this.next();
            $next.slideToggle();
            $this.parent().toggleClass('open');
            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
            }
        };
        var accordion = new Accordion($('#accordionc'), false);

    });
});


m.filter("ChangeCode",function () {
    // var tt=$scope.list.type;
    return function (tt) {
        var changed = "";
        switch (tt){
            case 0:changed = "首页banner";break;
            case 1:changed = "找职位banner";break;
            case 2:changed = "找精英banner";break;
            case 3:changed = "行业大图";break;
        }
        return changed;
    }
});
m.filter("status",function () {
    return function (tt) {
        var changed = "";
        switch (tt){
            case 1:changed = "草稿";break;
            case 2:changed = "上线";break;
        }
        return changed;
    }
});
m.filter("restatus",function () {
    return function (tt) {
        var changed = "";
        switch (tt){
            case 1:changed = "上线";break;
            case 2:changed = "下线";break;
        }
        return changed;
    }
});
