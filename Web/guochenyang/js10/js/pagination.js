/**
 * Created by ken on 2017/4/23.
 */
/*  分页指令
*   对外暴露的有两个参数，一个是当前页page，一个是最大页数maxPage
*   对最大页数进行监听，如果改变了就更新最大页数数组
 * */
app.directive('pagination', function() {
    return {
        //元素
        restrict: 'E',
        //作用域
        scope:{
            page: '=',  //等号是双向绑定
            maxPage: '='
        },
        //html
        template:
        '<div class="pagination">' +
        '<ul class="pager">' +
        '<li><a href="javascript:void(0)" ng-click="pageGo(1)">首页</a></li>' +
        '<li><a href="javascript:void(0)" ng-click="pagePre()">上一页</a></li>' +
        '</ul>' +
        '<ul>' +
        '<li ng-repeat="num in pageShowList" ng-class="{active: clickPage == num}">' +
        '<a href="javascript:void(0)" ng-click="pageGo(num)">{{num}}</a>' +
        '</li>' +
        '</ul>' +
        '<ul class="pager">' +
        '<li><a href="javascript:void(0)" ng-click="pageNext()">下一页</a></li>' +
        '<li><a href="javascript:void(0)" ng-click="pageGo(maxPage)">尾页:{{maxPage}}</a></li>' +
        '</ul>' +
        '</div>',
        //替换
        replace: true,
        //link函数
        link: function ($scope) {
            //变量
            var pageList = [];
            $scope.page = 1;    //初始默认为第一页
            $scope.pageShowList = [];    //最大显示7个格子

            /*  监听最大页数，如果页数变化，重新生成页数数组
            * */
            var watch = $scope.$watch('maxPage', function (newValue, oldValue, scope) {
                pageList = [];
                for (var i = 1; i <= newValue; i++) {   //一个个压入页码
                    pageList.push(i);
                }
                resetPageOrder($scope.page);
            });

            /*  直接跳页
             * */
            $scope.pageGo = function (num) {
                $scope.page = num;
                resetPageOrder($scope.page);
            };

            /*  上一页
             * */
            $scope.pagePre = function () {
                if( $scope.page > 1){
                    $scope.page --;
                    resetPageOrder($scope.page);
                }
            };

            /*  下一页
             * */
            $scope.pageNext = function () {
                if ( $scope.page < $scope.maxPage ){
                    $scope.page ++;
                    resetPageOrder($scope.page);
                }
            };

            /*  重新设置页码
            *   @param num当前页码
             * */
            function resetPageOrder(num) {
                $scope.clickPage = num; //变色
                //点击小于4的页数
                if (num < 4 ) {
                    $scope.pageShowList = pageList.slice(0, 7);  //只显示最大7个
                }
                //点击大于4
                else{
                    //在总页数尾部
                    if ( num > $scope.maxPage -4 ){    //去除多出的页数
                        $scope.pageShowList = pageList.slice($scope.maxPage-7, $scope.maxPage);
                    }
                    //之前两种情况的中间
                    else{
                        $scope.pageShowList = [
                            num - 3,
                            num - 2,
                            num - 1,
                            num,
                            num + 1,
                            num + 2,
                            num + 3
                        ];
                    }
                }
            }
        }
    }
});