angular.module('app').controller('editArticleCtrl',
    ['articleStatus', '$scope', '$stateParams', '$timeout', '$state', 'isHistory', 'articleType', 'FileUploader', 'articleIndustry', '$httpTools', '$httpSend', 'ajaxAds', function (articleStatus, $scope, $stateParams, $timeout, $state, isHistory, articleType, FileUploader, articleIndustry, $httpTools, $httpSend, ajaxAds) {
        var vm = this;
        vm.count = { //constant
            status: articleStatus,
            type: articleType,
            industry: articleIndustry,
        }
        vm.id = $stateParams.id;
        vm.history = isHistory();
        vm.ajaxData = {};
        vm.$httpSend = angular.copy($httpSend);
        //刷新页面，之后从本地存储id 继续获取；
        if (vm.id || vm.history.id) {
            let id = vm.id || vm.history.id;
            let getDataById = $httpTools().get(ajaxAds.aItem + id);
            getDataById.then(function (Success) {
                vm.$httpSend = Success.data.data.article;
                if (vm.id) {
                    vm.history.id = vm.id;
                    sessionStorage.history = JSON.stringify(vm.history);
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
                let $httpPromise;
                vm.$httpSend.status = status;
                let id = vm.id || vm.history.id;
                if (id) {
                    $httpPromise = $httpTools().put(ajaxAds.editItem + id, vm.$httpSend);
                } else {
                    //新增
                    $httpPromise = $httpTools().post(ajaxAds.editItem, vm.$httpSend);
                }
                $httpPromise.then(function (Success) {
                    alert('操作成功');
                }, function (Error) {
                    alert('请求错误');
                });
                $state.go('dashboard.articleList');
            }
        }
        vm.imgUp = {
            instance: new FileUploader({
                url: ajaxAds.imgUpload,
                removeAfterUpload: true,
                queueLimit: 1,//上传文件的数量
            }),
            uploadAitem: function ($index) {
                this.instance.uploadItem(this.instance.queue[$index]);
                this.uploadBtnFlag = true;
                this.deleteBtnFlag = false;
            },
            cancelAitem: function ($index) {
                this.instance.cancelItem(this.instance.queue[$index]);
            },
            clearQueue: function () {
                this.instance.clearQueue();
            },
            imgInfoPanel: false,
            uploadBtnFlag: false,
            deleteBtnFlag: true,
        }
        //sdnfkjshfkhsakhfkshfjshkfhskjdfhksjadhfsksjdhfkjhsdfhiusyfioJN MWENFKJHWEFHSDJKNGKSBDFHJ
        with (vm.imgUp.instance) {
            onAfterAddingAll = function () {
                vm.imgUp.imgInfoPanel = true;
            }
            onSuccessItem = function (item, response, status, headers) {
                vm.$httpSend.img = response.data.url;
                vm.imgUp.uploadBtnFlag = false;
                vm.imgUp.imgInfoPanel = false;
                vm.imgUp.deleteBtnFlag = true;
            }
            onErrorItem = function (item, response, status, headers) { //成功后
                alert('图片上传失败，检查一下图片');
                vm.$httpSend.img = undefined;
            }
            onCancelItem = function (item, response, status, headers) { //取消上传时，
                vm.imgUp.uploadBtnFlag = false;
                vm.imgUp.deleteBtnFlag = true;
                alert("文件:" + item._file.name + '已经取消上传!');
            }
            onCompleteItem = function (item, response, status, headers) { //上传，或取消上传成功后触发
                vm.imgUp.uploadBtnFlag = false;
                vm.imgUp.deleteBtnFlag = true;
            }
        }
    }])