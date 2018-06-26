var myapp=angular.module('myApp',['ui.router']);

myapp.config(function($stateProvider){
    $stateProvider.state('contacts',{
        url:'/contacts/:name',
        resolve:{
            //字符串格式:使用一个既有的服务
            first:'aService',
            //函数:函数的返回值就是将被注入的服务
            second:function(){
                return {data:'second的data'}
            },
            //函数:在函数中注入既有的服务
            third:function(anotherService,$stateParams){
                var data = anotherService.getName($stateParams.name);
                return {data:data}
            },
            //函数:返回一个promise对象,最终得到的将是resolve里的内容
            fourth:function($q,$timeout){
                var defer = $q.defer();
                $timeout(function(){
                    defer.resolve({data:'我是fourth的data'});
                    //注意,如果一个state的resolve里的某个promise被拒绝了,那这个state直接无法继续下去了.
                    //defer.reject({data:'我是fourth的data'})
                },2000);
                return defer.promise;
            },
            //函数:返回$http返回的promise返回的promise,最终得到的是.then里面return的内容
            fifth:function($http){
                return $http({
                    method:'GET',
                    url:'/contacts/name'
                }).then(function(res){
                    return {data:res.data}
                },function(){

                })
            },
            //函数:返回$http返回的promise,最终得到的就是后台返回值.
            sixth:function($http){
                return $http({
                    method:'GET',
                    url:'/contacts/name'
                })
            }
        },
        templateUrl:function($stateParams){
            return 'partials/contacts.' + $stateParams.name + '.html'
        },
        controller:'ctrl'
    })
});
myapp.factory('aService',function(){
    return {
        getName:function(){
            alert('我是aService服务的getName方法')
        },
        data:'first的data'
    }
});
myapp.factory('anotherService',function(){
    return {
        getName:function(data){
            return data.toUpperCase()
        }
    }
});
myapp.controller('ctrl',function($scope,first,second,third,fourth,fifth,sixth){
    first.getName();
    $scope.data1 = first.data;
    $scope.data2 = second.data;
    $scope.data3 = third.data;
    $scope.data4 = fourth.data;
    $scope.data5 = fifth.data;
    $scope.data6 = sixth.data;
});