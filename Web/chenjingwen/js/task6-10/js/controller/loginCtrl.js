var app=angular.module("app");
var a=0;
app.filter("to_trusted",['$sce',function($sce){//过滤器
    return function(text){
        return $sce.trustAsHtml(text);
    };
}]);
app.controller("loginCtrl",function($scope,$http,$state){
    $scope.usr=function(name){
        if(name==undefined){
            $scope.usrtip="用户名不能为空";
            $scope.usrjudge=true;
        }
        else if(name!=undefined&&name.length<3){
            $scope.usrtip="用户名长度不能小于3";
            $scope.usrjudge=true;
        }
        else if(name.length>8){
            $scope.usrtip="用户名长度不能大于8";
            $scope.usrjudge=true;
        }
        else{
            $scope.usrtip="";
            $scope.usrjudge=false;
        }
    };
    $scope.pwd=function(password){
        if(password==undefined){
            $scope.pwdtip="密码不能为空";
            $scope.pwdjudge=true;
        }
        else if(password!=undefined&&password.length<5){
            $scope.pwdtip="密码长度不能小于5";
            $scope.pwdjudge=true;
        }
        else if(password.length>10){
            $scope.pwdtip="密码长度不能大于10";
            $scope.pwdjudge=true;
        }
        else{
            $scope.pwdtip="";
            $scope.pwdjudge=false;
        }
    };
    $scope.login=function(){
        $http({
            method:"POST",
            url:"/carrots-admin-ajax/a/login",
            headers:{'Content-Type':'application/x-www-form-urlencoded'},
            data:{name:$scope.name,pwd:$scope.password},
            transformRequest:function(obj){//参数序列化
                var str=[];
                for(var p in obj){
                    str.push(encodeURIComponent(p)+"="+encodeURIComponent(obj[p]));                    
                }
                return str.join("&");
            }
        }).then(function(response){
            var code;
            console.log(response);
            sessionStorage.code=response.data.code;
            if(response.data.code==0){
                a=1;
                sessionStorage.a=a;
                console.log(sessionStorage.a);
                $state.go("backstage");
                console.log("登录成功");                 
            }
            else{
                $scope.errormessage=response.data.message;
            }
        });
    };
});

