'use strict';
angular.module('admin')
  .controller('MediumCtr',function ($state, $rootScope, adminService) {
      var vm = this;
      vm.params = $state.params;
      adminService.mediumList(vm.params).then(function (res) {
          if (res.data.code === 0) {
              vm.mediumList = res.data.data;
              //计算总页数
              vm.totalPage = Math.ceil(res.data.total / res.data.size);
          } else {
              $rootScope.alert(res.data.message)
          }
      })

      // 搜索
      vm.search = function () {
          vm.params.page = 1;
          $state.go($state.current, vm.params, {reload: true});
      }
      // 重置
      vm.clear = function () {
          angular.forEach(vm.params, function (item, index, array) {
              array[index] = "";
          });
          vm.params.page = 1;
          $state.go($state.current, vm.params, {reload: true});
      }

      // 新增
      vm.add = function () {
          vm.title = "新增";
          $rootScope.prompt(vm.title, "", function (content) { // 点击确认后的回调函数
              vm.params.name = content;
              adminService.addMedium(vm.params).then(function (res) {
                  if(res.data.code === 0){
                      $rootScope.alert("新增成功", function () {
                          $state.go($state.current,{},{reload:true})
                      })
                  } else {
                      $rootScope.alert(res.data.message)
                  }
              })
          },function () {
              // 点击取消执行的函数
          })
      }

      // 上下架对话框
      vm.upDown = function (id, status) {
          if(status==1){
              vm.alertMessage = "确定要上架吗？"
              vm.confirmMessage = "上架成功"
          }else {
              vm.alertMessage = "确定要下架吗？"
              vm.confirmMessage = "下架成功"
          }
          $rootScope.confirm(vm.alertMessage, function(){
              adminService.upDownMedium(id, status).then(function(res){
                  if(res.data.code == 0){
                      $rootScope.alert(vm.confirmMessage, function () {
                          $state.go($state.current,{},{reload:true})
                      })
                  }else {
                      $rootScope.alert(res.data.message)
                  }
              })
          },function () {
              // 点击取消执行的函数
          })
      }

      // 编辑
      vm.edit = function (id, name) {
          vm.title = "编辑";
          vm.params.id = id;
          $rootScope.prompt(vm.title, name, function (res) {
              vm.params.name = res;
              adminService.editMedium(vm.params.id, vm.params).then(function (res) {
                  if(res.data.code == 0){
                      $rootScope.alert("编辑成功",function () {
                          $state.go($state.current,{},{reload:true})
                      })
                  }else {
                      $rootScope.alert(res.data.message)
                  }
              })
          },function () {
              // 点击取消执行的函数
          })
      };

      // 跳转排序
      vm.goSort=function (li) {
          $state.go("field.productCustomer",{mediumId:li.id,from:'medium'},{reload:true})
      }
  });