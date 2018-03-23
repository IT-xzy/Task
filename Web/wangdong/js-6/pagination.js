/**
 * Created by likui on 2016/6/26.
 */
angular.module('admin')
    .directive('pagination', function ($state) {
    return {
        restrict: 'EA',
        templateUrl: 'js/directives/ptteng-paging/pagination.html',
        replace: true,
        scope: {
            total: '@',
            defaultPage:"=defaultPage"
        },
        link: function (scope, element, attrs) {
            //当前页
            var activePage = parseInt($state.params.page);
            //size
            scope.size = $state.params.size ? parseInt($state.params.size) : 50;
            //总页数
            var totalPage = Math.ceil(parseInt(scope.total) / scope.size);
            defaultPage = scope.defaultPage||4;//默认显示多少页,在指令调用的时候可以加上这个属性进行设置，不设置默认4页
            scope.activePage = activePage;
            scope.totalPage = totalPage;
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
                //...在两边
                if (isHavePreDot() && isHaveNextDot()) {
                    for (var i = 0; i < defaultPage; i++) {
                        pageList.push(activePage + i);
                    }
                    pageList.unshift("...");
                    pageList.push("...");
                }
                //...在前面
                if (isHavePreDot() && !isHaveNextDot()) {
                    for (var i = totalPage - (defaultPage-1); i <= totalPage; i++) {
                        pageList.push(i);
                    }
                    pageList.unshift("...");
                }
                //...在后面
                if (!isHavePreDot() && isHaveNextDot()) {

                    if (totalPage > defaultPage) {
                        for (var i = 0; i < defaultPage; i++) {
                            pageList.push(activePage + i);
                        }
                    } else {
                        for (var i = 1; i < totalPage; i++) {
                            pageList.push(i);
                        }
                    }
                    pageList.push("...");
                }
                //没有...
                if (!isHavePreDot() && !isHaveNextDot()) {

                    for (var i = 1; i <= totalPage; i++) {
                        pageList.push(i);
                    }
                }
                return pageList;
            }
            //是否有前面的 ...
            function isHavePreDot() {
                if (activePage > defaultPage) {
                    return true;
                }
                return false;
            }
            //是否有后面的 ...
            function isHaveNextDot() {
                if (activePage < totalPage - (defaultPage-1)) {
                    return true;
                }
                return false;
            }
            function isDisabled(page) {
                if (Number(page) === activePage || page === '...' || Number(page) > totalPage) {
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
            scope.changeInput = function () {
                scope.jumpPage = scope.jumpPage.replace(/[^0-9]/g, '');
                if (scope.jumpPage > totalPage) {
                    scope.jumpPage = totalPage;
                }
            };
            scope.changeSize = function () {
                scope.size = scope.size.replace(/[^0-9]/g, '');
                if (parseInt(scope.size) === 0) {
                    scope.size = 50;
                }
            };
            //跳页
            scope.goPage = function (page) {
                if (isDisabled(page)) return;
                $state.go($state.current, {page: page || 1, size: scope.size}, {reload: true});
            };
        }
    }
});