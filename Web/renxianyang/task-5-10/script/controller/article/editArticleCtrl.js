angular.module('app').controller('editArticleCtrl',
    ['articleCount', '$scope', '$stateParams', '$interval', '$timeout', '$state', 'hasHistory', 'FileUploader', '$httpTools', 'ajaxAds', function (articleCount, $scope, $stateParams, $interval, $timeout, $state, hasHistory, FileUploader, $httpTools, ajaxAds) {
        var vm = this;
        vm.domData = articleCount;
        vm.id = $stateParams.id;
        vm.history = hasHistory();
        vm.httpSend = angular.copy(articleCount.defaultHttpData);
        //刷新页面，之后从本地存储id 继续获取；
        if (vm.id || vm.history.editArticleID) {
            let id = vm.id || vm.history.editArticleID;
            let promise = $httpTools.get(ajaxAds.article.aItem + id);
            promise.then(function (Success) {
                if (Success.data.code == 0 && Success.data.message === 'success') {
                    var infoById = Success.data.data.article;
                    for (var i in infoById) {
                        vm.httpSend[i] = infoById[i];
                    }
                    if (vm.id) {
                        vm.history.editArticleID = vm.id;
                        sessionStorage.history = JSON.stringify(vm.history);
                    }
                } else {
                    alert(Success.data.message);
                }
            }, function (Error) {
                alert('请求错误');
                $timeout(function () {
                    $state.go('dashboard.articleList');
                }, 1500)
            })
        }
        vm.ways = {
            savaArticle: function (status) {
                let promise;
                vm.httpSend.status = status;
                let id = vm.id || vm.history.editArticleID;
                if (id) {
                    promise = $httpTools.put(ajaxAds.article.editItem + id, vm.httpSend);
                } else {
                    //新增
                    promise = $httpTools.post(ajaxAds.article.editItem, vm.httpSend);
                }
                promise.then(function (Success) {
                    if (Success.data.code == 0 && Success.data.message === 'success') {
                        alert('操作成功');
                    } else {
                        alert(Success.data.message);
                    }
                    $state.go('dashboard.articleList');
                }, function (Error) {
                    alert('操作失败!');
                    $state.go('dashboard.articleList');
                });
            }
        }
        vm.upload = {
            isLoading: false,
        }
    }]);