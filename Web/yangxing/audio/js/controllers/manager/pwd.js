angular.module('admin')
    .controller('pwdCtr',function ($scope, $state, adminService,$rootScope) {
        var vm = this;
        vm.updatePwd=function(){
          if(vm.data.newPassword!==vm.data.newPasswordAgain){
              $rootScope.alert('两次密码输入不一致');
              return
          };
          var self=JSON.parse(localStorage.getItem("self"));
          if(self){
              var userId=self.id;
              adminService.newPwd(userId,vm.data).then(function (res) {
                  if(res.data.code==0){
                      $rootScope.alert('修改成功');
                      $state.go('field.home',{},{reload:true})
                  }else {
                      $rootScope.alert(res.data.message)
                  }
              })
          }else {
              $rootScope.alert('用户id不存在，请重新登录')
          }
        };




        //取消
        vm.cancel=function () {
            history.back()
        };
    });