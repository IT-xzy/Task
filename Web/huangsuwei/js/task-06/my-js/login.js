
    myApp.controller("login",function ($scope, $http ,$state) {
        $scope.ccc= function(){
            $http({
                method:"POST",
                url:"/carrots-admin-ajax/a/login",
                params:$scope.params
            }).then(function successCallback(response){
                console.log(response);
                if (response.data.code===0){
                    $state.go('list.option1',{},{reload:true})
                }else if (response.data.code!==0){
                   alert(response.data.message)
                }
            });

        }
    });