//后台页面侧边栏控制器
angular.module('App')
    .controller('listCtrl', function ($scope, $http, $state, ArticleManagementService) {
        var log_in = JSON.parse(sessionStorage.getItem('log-in'));
        if(log_in === 1){
            $(function(){
                // nav收缩展开
                $('.nav-item>a').on('click',function(){
                    if (!$('.nav').hasClass('nav-mini')) {
                        if ($(this).next().css('display') == "none") {
                            //展开未展开
                            $('.nav-item').children('ul').slideUp(300);
                            $(this).next('ul').slideDown(300);
                            $(this).parent('li').addClass('nav-show').siblings('li').removeClass('nav-show');
                        }else{
                            //收缩已展开
                            $(this).next('ul').slideUp(300);
                            $('.nav-item.nav-show').removeClass('nav-show');
                        }
                    }
                });
                //nav-mini切换
                $('#mini').on('click',function(){
                    if (!$('.nav').hasClass('nav-mini')) {
                        $('.nav-item.nav-show').removeClass('nav-show');
                        $('.nav-item').children('ul').removeAttr('style');
                        $('.nav').addClass('nav-mini');
                    }else{
                        $('.nav').removeClass('nav-mini');
                    }
                });
            });

            //退出
            $scope.off = function () {
                bootbox.confirm("确定要退出登录吗?", function (result) {
                    if(result){
                        ArticleManagementService.outLogin()
                            .then(function (response) {
                                if(response.data.code === 0){
                                    $state.go('login');
                                    sessionStorage.clear();
                                }else {
                                    bootbox.alert(response.data.message);
                                }
                            })
                    }else {
                        return
                    }
                })
            }
        }else {
            $state.go('login');
        }
    });