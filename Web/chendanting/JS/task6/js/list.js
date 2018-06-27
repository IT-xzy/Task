// 文章列表
app.controller("listCtrl", function ( $state, $stateParams, serviceHTTP) {
    // 判断是否已登录
    user = JSON.parse(sessionStorage.getItem("user"));
    var vm = this;
    if(user){
        var data = {
            page: $state.params.page,
            type: $state.params.type,
            status: $state.params.status,
            startAt: $state.params.start,
            endAt: $state.params.end
        };
        serviceHTTP.searchHTTP(data).then(function(res) {
          var lists = res.data.data.articleList;
          vm.lists = lists;
          var data = res.data.data;
          vm.data = data;
          // var vm = vm;
          console.log(res.data.data);
          // 分页部分
          // 根据服务器返回的数据算出总页数
          vm.page = Math.ceil(data.total / data.size);
          // 创建分页页码的数组
          vm.totalPage = [];
          for (var i = 1; i < vm.page + 1; i++) {
            //从1开始，将页面页码装入数组
            vm.totalPage.push(i);
          }
          // 分页的首页
          vm.indexPage = function() {
            if ($state.params.page == 1) {
              alert("别点啦，这是首页了");
            } else {
              $state.go("backstage.list", { page: 1 }, { reload: true });
            }
          };
          // 末页
          vm.endPage = function() {
            if ($state.params.page == vm.page) {
              alert("别点啦，这是末页了");
            } else {
              $state.go("backstage.list", { page: vm.page }, { reload: true });
            }
          };
          //点击才跳转到列表页时，给出默认页面值，防止直接点击下一页/下一页出错
          if ($state.params.page == undefined) {
            vm.currentPage = 1;
          }
          // 定义当前页面,从路由中拿取保存的当前页面值
          else {
            vm.currentPage = $state.params.page;
          }
          // 上一页
          vm.prePage = function() {
            if ($state.params.page == 1) {
              alert("别点啦，这是首页了");
            }
            if (vm.currentPage != 1) {
              $state.go("backstage.list", { page: vm.currentPage - 1 }, { reload: true });
            }
          };
          // 下一页
          vm.nextPage = function() {
            if ($state.params.page != vm.page) {
              $state.go("backstage.list", { page: vm.currentPage - 0 + 1 }, { reload: true });
            }
            if ($state.params.page == vm.page) {
              alert("别点啦，这是末页了");
            }
          };
          // 点击时展示分页当前页面
          vm.showPage = function(x) {
            $state.go("backstage.list", { page: x }, { reload: true });
          };
        });
        // 跳转到指定页面
        // vm.goPage = function(y){
        //     $state.go("backstage.list", { page: vm.y }, { reload: true });
        // }
        // 类型和状态的渲染
        vm.type = $state.params.type;
        vm.status = $state.params.status;
        //将路由里的时间戳转换为input(type="date")类型的时间格式，让input日期展示出来
        function changeDate(date) {
            Y = date.getFullYear() + '-';
            M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
            D = date.getDate() + ' ';
            return Y + M + D;
        }
        // 发布日期转换
        if ($state.params.start != undefined & $state.params.start != '') {
            var dateAd = new Date(Number($state.params.start));
            var dateBegin = changeDate(dateAd);
            vm.start = new Date(dateBegin);
        }
        // 截至日期转换
        if ($state.params.end != undefined) {
            var dateEd = new Date(Number($state.params.end));
            var dateEnd = changeDate(dateEd);
            vm.end = new Date(dateEnd);
        }
        // 搜索功能
        vm.search = function () {
            // 无任何搜索条件时
            if ((vm.start == undefined | vm.start == '') & (vm.end == undefined | vm.end == '') & vm.type == undefined & vm.status == undefined){
                alert("请输入搜索条件！")
            }
            else{  //正常搜索时
                if (vm.start != undefined){
                    var startNum = new Date(vm.start).getTime();   
                }     
                if (vm.end != undefined) {
                    var endNum = new Date(vm.end).getTime();
                }    
                // 根据搜索条件带参数搜索 
                $state.go("backstage.list", { 
                    page: 1,  //每次点击搜索后从第一页开始显示
                    type: vm.type, 
                    status: vm.status, 
                    start: startNum,
                    end: endNum
                }, 
                { reload: true }); 
            }
        }
        // 清空
        vm.clear = function (){
            if ((vm.start == undefined | vm.start == '') & (vm.end == undefined | vm.end == '') & vm.type == undefined & vm.status == undefined){
                alert("没有内容啦");
            }
            else{  
                $state.go("backstage.list", { 
                    type: "", 
                    status: "", 
                    start: "", 
                    end: "" 
                }, { reload: true });
            }
        }
        // 编辑文章按钮
        vm.write = function (id) {
            $state.go("backstage.write", {id: id}, { reload: true });        
        }
        // 删除功能
        vm.delete = function (id){
            var clear = confirm("是否删除此文章？");
            if(clear){
                serviceHTTP.delateHTTP(id).then(function successCallback(res){
                    if(res.data.code==0){
                        alert("删除成功！");
                        $state.go("backstage.list", {}, { reload: true });
                    }
                });
            }
        }
        // 下线功能
        vm.offline = function (id,status){
            var sure = confirm("是否上/下架?");
            if(sure){
                var newStatus = status == 1 ? 2 : 1;
                var state = {
                    id : id,
                    status: newStatus
                }
                serviceHTTP.offlineHTTP(state).then(function successCallback(res){
                    $state.go ("backstage.list",{},{ reload: true });
                });
            }
            else{
                alert("操作已取消！")
            }
        };
    }
    else{
        alert("请先登录！")
        $state.go("login");
    }
})