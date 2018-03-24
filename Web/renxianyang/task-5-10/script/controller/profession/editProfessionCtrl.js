angular.module('app')
    .controller('editProfessionCtrl', ['$http', '$state', '$timeout', 'hasHistory', 'professionCount', 'ajaxAds', '$stateParams', '$httpTools', function ($http, $state, $timeout, hasHistory, professionCount, ajaxAds, $stateParams, $httpTools) {
        var vm = this;
        vm.id = $stateParams.id;
        vm.status = $stateParams.status;
        vm.domData = professionCount;
        vm.history = hasHistory();
        vm.httpSend = angular.copy(professionCount.defaultHttpData);
        //福利标签
        vm.getTagsByCompanyId = [];
        //刷新页面，之后从本地存储id 继续获取；
        if (vm.id || vm.history.editProfessionID) {
            let id = vm.id || vm.history.editProfessionID;
            let promise = $httpTools.get(ajaxAds.profession.aItem + id);
            promise.then(function (Success) {
                var infoById = Success.data.data;
                //这里根据传入的status，在for之前
                vm.httpSend['status'] = vm.status;
                for (var i in infoById) {
                    vm.httpSend[i] = infoById[i];
                }
                if (vm.id) {
                    //获取公司福利标签,通过companyId
                    $httpTools.get('/carrots-admin-ajax/a/tags/' + infoById.companyId).then(function (Success) {
                        if (Success.data.code == 0 && Success.data.message === 'success') {
                            var res = Success.data.tags;
                            var getTagsById = vm.httpSend.tags;
                            for (var i in res) {
                                vm.getTagsByCompanyId.push({content: res[i], isCheck: false});
                            }
                            for (var j in getTagsById) {
                                for (var k in vm.getTagsByCompanyId) {
                                    if (getTagsById[j].tag === vm.getTagsByCompanyId[k].content.tag) {
                                        vm.getTagsByCompanyId[k].isCheck = true;
                                    }
                                }
                            }
                        } else {
                            alert(Success.data.message);
                        }
                    }, function () {
                        console.log('福利标签获取失败!');
                    });
                    vm.history.editProfessionID = vm.id;
                    sessionStorage.history = JSON.stringify(vm.history);
                }
            }, function () {
                alert('请求错误');
                $timeout(function () {
                    $state.go('dashboard.professionList');
                }, 1500)
            })
        }
        vm.ways = {
            cancel: function () {
                var promise = confirm('是否取消，更改将不会保存!');
                promise.then(function (s) {
                    $state.go('dashboard.professionList');
                }, function (e) {
                    return;
                })
            },
            savaProfession: function () {
                //处理一下数据。。
                var $httpData = {};
                $httpData['profession'] = angular.copy(vm.httpSend);
                $httpData['tags'] = $httpData['profession']['tags'];
                delete $httpData['profession']['tags'];
                delete $httpData['profession']['startAt'];
                delete $httpData['profession']['endAt'];
                delete $httpData['profession']['page'];
                delete $httpData['profession']['size'];
                var $httpPromise = $httpTools.put(ajaxAds.profession.editItem + vm.id, $httpData, true);
                $httpPromise.then(function (Success) {
                    if (Success.data.code == 0 && Success.data.message === 'success') {
                        alert('操作成功');
                    } else {
                        alert(Success.data.message);
                    }
                }, function (Error) {
                    alert('请求错误');
                });
                $state.go('dashboard.professionList');
            },
            changeCheck: function ($index, tag, isCheck) {
                if (isCheck) {
                    //已经选中
                    for (let i in vm.httpSend.tags) {
                        if (vm.httpSend.tags[i].tag === tag) {
                            vm.httpSend.tags.splice(i, 1);
                            vm.getTagsByCompanyId[$index].isCheck = false;
                        }
                    }
                } else {
                    //没有选中
                    vm.httpSend.tags.push({tag: tag});
                    vm.getTagsByCompanyId[$index].isCheck = true;
                }
            }
        }
    }])