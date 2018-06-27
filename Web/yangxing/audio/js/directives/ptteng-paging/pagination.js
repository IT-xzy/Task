/**
 * 分页
 *
 * 用法：
 *
 vm.totalPage = res.data.totalPage;

 <nav class="pull-right" ng-if="vm.totalPage">
 <pagination total-page="{{vm.totalPage}}"></pagination>
 </nav>
 */
angular.module('admin').directive('page', function ($state) {
    return {
        restrict: 'EA',
        templateUrl: 'js/directives/ptteng-paging/pagination.html',
        replace: true,
        scope: {
            totalPage: '@'
        },
        link: function (scope) {
            //当前页
            var activePage = parseInt($state.params.page) || 1;
            // size
            scope.size = parseInt($state.params.size) ? parseInt($state.params.size) : 10;
            //总页数
            // var totalPage = Math.ceil(parseInt(scope.totalPage)/scope.size);
            var totalPage = parseInt(scope.totalPage);
            scope.activePage = activePage;
            scope.total = totalPage;
            scope.isHaveNextPage = isHaveNextPage;
            scope.isHavePrePage = isHavePrePage;
            scope.pageList = getPageList();
            scope.isDisabled = isDisabled;
            scope.isActive = isActive;


            //是否有下一页
            function isHaveNextPage() {
                if (activePage === totalPage) {
                    return false;
                }
                return true;
            }

            //是否有上一页
            function isHavePrePage() {
                if (activePage !== 1) {
                    return true;
                }
                return false;
            }

            //获得pageList
            function getPageList() {
                var pageList = [];

                if (totalPage <= 9) {
                    // 判断总页数如果小于等于分页的长度，若小于则直接显示
                    for (i = 1; i <= totalPage; i++) {
                        pageList.push(i);
                    }
                } else {
                    // 总页数大于分页长度（此时分为三种情况：1.左边没有...2.右边没有...3.左右都有...）
                    // 计算中心偏移量
                    var offset = Math.ceil((9 - 1) / 2);
                    if (activePage <= offset) {
                        // 左边没有...
                        for (var i = 1; i <= offset + 1; i++) {
                            pageList.push(i);
                        }
                        pageList.push('...');
                        pageList.push(totalPage);
                    } else if (activePage > totalPage - offset) {
                        pageList.push(1);
                        pageList.push('...');
                        for (var i = offset + 1; i >= 1; i--) {
                            pageList.push(totalPage - i);
                        }
                        pageList.push(totalPage);
                    } else {
                        // 最后一种情况，两边都有...
                        pageList.push(1);
                        pageList.push('...');

                        for (var i = Math.ceil(offset / 2); i >= 1; i--) {
                            pageList.push(activePage - i);
                        }
                        pageList.push(activePage);
                        for (var i = 1; i <= offset / 2; i++) {
                            pageList.push(activePage + i);
                        }

                        pageList.push('...');
                        pageList.push(totalPage);
                    }
                }


                return pageList;
            }


            function isDisabled(page) {
                if (page === activePage || page === '...') {
                    return true;
                }
                return false;
            }

            function isActive(page) {
                if (page === activePage) {
                    return true;
                }
                return false;
            }

            //跳页
            scope.goPage = function (page) {
                if (isDisabled(page)) return;
                $state.go($state.current, {page: page}, {reload: true});
            };
        }
    }


});