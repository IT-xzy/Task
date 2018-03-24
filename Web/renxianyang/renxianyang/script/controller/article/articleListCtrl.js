angular.module('app').controller('articleListCtrl', ['$location', 'articleCount', '$httpTools', '$state', '$stateParams', 'getStatusInfo', 'dateToNum', '$http', 'hasHistory', 'ajaxAds',
    function ($location, articleCount, $httpTools, $state, $stateParams, getStatusInfo, dateToNum, $http, hasHistory, ajaxAds) {
        var vm = this;
        console.log($stateParams)
        vm.domData = articleCount;
        vm.ajaxData = {};
        vm.history = hasHistory();//历史
        vm.httpSend = angular.copy(articleCount.defaultHttpData);
        ~function () {
            for (var i in $stateParams) {
                if ($stateParams[i]) {
                    vm.httpSend[i] = $stateParams[i];
                }
            }
        }();
        console.log(vm.httpSend);
        vm.datepicker = {//日历
            startAtOpen: false,
            endAtOpen: false,
            options: {
                'maxDate': new Date(),
            },
        };
        vm.uibPage = {//分页
            page: 1,
            size: 10,
            totle: 0,
            pageChange: function () {
                vm.httpSend.page = vm.uibPage.page;
                vm.ways.getData();
            },
            toggleFlag: false,
        };
        vm.ways = {
            getData: function () {
                vm.httpSend.startAt = dateToNum(vm.httpSend.startAt);
                //结束时间加上84924000毫秒，没有setHours()精确，那个方法是后来知道的，懒得改了~
                //Date竟然有个setHours()！1！！  setHours(0,0,0)、setHours(23,59,59)
                vm.httpSend.endAt = angular.isNumber(dateToNum(vm.httpSend.endAt)) ? dateToNum(vm.httpSend.endAt) + 84924000 : dateToNum(vm.httpSend.endAt);
                let promise = $httpTools.get(ajaxAds.article.searchItem, vm.httpSend);
                promise.then(function (Success) {
                    if (Success.data.code == 0 && Success.data.message === 'success') {
                        vm.ajaxData = Success.data;//Dom数据
                        //分页优化
                        vm.uibPage.total = vm.ajaxData.data.total;
                        vm.uibPage.size = vm.httpSend.size;
                        vm.uibPage.page = vm.httpSend.page;
                        if (vm.uibPage.total <= vm.uibPage.size) {
                            vm.uibPage.toggleFlag = true;
                            if (vm.uibPage.total <= 10) {
                                vm.httpSend.size = 10;
                            } else {
                                vm.httpSend.size = vm.uibPage.total;
                            }
                        } else {
                            vm.uibPage.toggleFlag = false;
                        }
                        //地址栏改变url
                        $location.search(function () {
                            var res = {};
                            for (var i in vm.httpSend) {
                                vm.httpSend[i] && (res[i] = vm.httpSend[i]);
                            }
                            return res;
                        }());
                        //本地存储
                        vm.httpSend.endAt = angular.isNumber(dateToNum(vm.httpSend.endAt)) ? dateToNum(vm.httpSend.endAt) - 84924000 : dateToNum(vm.httpSend.endAt);
                        vm.history.articleSend = vm.httpSend;
                        sessionStorage.history = JSON.stringify(vm.history);
                    } else {
                        alert(Success.data.message);
                    }
                }, function (Error) {
                    alert('请求错误');
                });
            },
            clearHistory: function () {
                //保存一下size
                let size = vm.httpSend.size;
                angular.copy(articleCount.defaultHttpData, vm.httpSend);
                vm.httpSend.size = size;
                vm.ways.getData();
            },
            changeStatus: function (id, status) {
                let statusInfo = getStatusInfo(function (status) {
                    var res = status === 1 ? true : false;
                    return res;
                }(status));
                let send = {
                    status: statusInfo.status === true ? 1 : 2,
                    id: id,
                }
                let uibModalpromise = confirm.apply(null, statusInfo.content);
                uibModalpromise.then(function (resolved) {
                    //确认之后$http
                    let promise = $httpTools.put(ajaxAds.article.status, send);
                    promise.then(function (Success) {
                        if (Success.data.code === 0 && Success.data.message === 'success') {
                            alert('操作成功');
                            // 更新dom
                            vm.ways.getData();
                        } else {
                            alert(Success.data.message)
                        }
                    }, function (Error) {
                        alert('请求错误!');
                    })
                }, function (rejected) {
                    //取消
                    alert('操作已经取消')
                })
            },
            deleteItem: function (id) {
                let uibModalpromise = confirm.apply(null, ['是否确认删除?']);
                uibModalpromise.then(function (resolved) {
                    //确认之后$http
                    let promise = $httpTools.delete(ajaxAds.article.editItem + id, '');
                    promise.then(function (Success) {
                        if (Success.data.code === 0 && Success.data.message === 'success') {
                            alert('删除成功');
                            // 更新dom
                            vm.ways.getData();
                        } else {
                            alert(Success.data.message)
                        }
                    }, function (Error) {
                        alert('请求错误');
                    })
                }, function (rejected) {
                    //取消
                    alert('操作已经取消')
                })
            },
            addArticle: function () {
                if (vm.history.editArticleID) {
                    vm.history.editArticleID = undefined;
                    sessionStorage.history = JSON.stringify(vm.history);
                }
                $state.go('dashboard.editArticle');
            }

        }
        //页面初始化
        vm.ways.getData();
    }])