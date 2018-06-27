'use strict';
angular.module('admin')
    .factory('commonUtil', function ($rootScope, $state, $filter,$http) {

        return {
            pageDefault: {page: 1, size: 10, next: true, type: ""},
            pageClass: {page: 1, size: 10, next: true, type: ""},

            process4Page: function (params) {
                if (params == undefined) {
                    params = {};
                } else {

                }
                if (params.page == undefined) {
                    params.page = $state.params.page || this.pageDefault.page;
                }
                if (params.size == undefined) {
                    params.size = $state.params.size || this.pageDefault.size;
                }
                if (params.next == undefined) {
                    params.next = $state.params.next || this.pageDefault.next;
                }

                if (params.type == undefined) {
                    params.type = $state.params.type || this.pageDefault.type;
                }
                if (params.status == undefined) {
                    params.status = $state.params.status || this.pageDefault.status;
                }
                if (params.endAt == undefined) {
                    params.endAt = $state.params.endAt || this.pageDefault.endAt;
                }
                if (params.startAt == undefined) {
                    params.startAt = $state.params.startAt || this.pageDefault.startAt;
                }
                return {"params": params};
            },

            process4Class: function (params) {
                if (params == undefined) {
                    params = {};
                } else {

                }
                if (params.page == undefined) {
                    params.page = $state.params.page || this.pageDefault.page;
                }
                if (params.size == undefined) {
                    params.size = $state.params.size || this.pageDefault.size;
                }
                if (params.next == undefined) {
                    params.next = $state.params.next || this.pageDefault.next;
                }
                return {"params": params};
            },

            processPageResult: function (res) {


                $state.params.next = res.data.data.next;
                return res;
            },

            setPage: function (res) {
                this.page = {current: res.data.data.page, size: res.data.data.size, next: res.data.data.next}
            },


            resetPage: function () {
                this.page = {current: 1, size: 5, next: true}
            },
            page: {current: 1, size: 10, next: true},
            concactArrayParam: function (name, params) {
                var tempUrls = "?";
                angular.forEach(params, function (data, index, array) {
                    tempUrls = tempUrls + name + "=" + data + "&";
                });
                var url = tempUrls.substring(0, tempUrls.length - 1);
                // console.log("url is " + url);
                return url;
            },
            showErrMsg: function (res) {
                if (res.data.code == -5020) {
                    $rootScope.alert(res.data.message, function () {
                        console.log(res.data.code + " get error  message is " + res.data.message);
                        $state.go("login", {}, {reload: true});
                    });
                } else {
                    $rootScope.alert(res.data.message, function () {
                        console.log(res.data.code + " get error  message is " + res.data.message);
                    });
                }
            },
            showReturnMsg: function (res, path) {

                switch (res.data.code) {
                    case 0:
                        $rootScope.alert(res.data.message, function () {
                            console.log(res.data.code + " get error  message is " + res.data.message);
                            if (path == undefined) {

                            } else {
                                $state.go(path, {}, {reload: true});
                            }
                        });
                        break;
                    case -5021:
                        $rootScope.alert(res.data.message, function () {
                            console.log(res.data.code + " get error  message is " + res.data.message);
                            if (path == undefined) {

                            } else {
                                $state.go(path, {}, {reload: true});
                            }
                        });
                        break;
                    case -5020:
                        $rootScope.alert(res.data.message, function () {
                            console.log(res.data.code + " get error  message is " + res.data.message);
                            $state.go("login", {}, {reload: true});
                        });
                        break;
                    default :
                        $rootScope.alert(res.data.message, function () {
                            console.log(res.data.code + " get error  message is " + res.data.message);
                        });

                }


            },
            isUpdate: function (id) {
                if (id == undefined) {
                    return false;
                } else {
                    return true;
                }
            },
	        restParms: function (params) {
		        angular.forEach(params, function (item, key) {
			        params[key] = '';
		        });
		        params.page = 1;
		        params.size = 10;
		        return params
	        },
            // 处理模块列表数据，将map添加进list结果
            buildTree: function (modules) {
                var tree = [];
                return this.buildTreeNode(0, null, tree, modules);
            },
            buildTreeNode: function (pid, node, tree, modules) {
                var now = this;
                angular.forEach(modules, function (data, index, array) {
                    var module = data;
                    if (module.parentID == pid) {
                        tree = now.buildTreeNode(module.id, module, tree, modules);
                        if (pid == 0) {
                            tree.push(module);
                        } else {
                            if (node.nodes == undefined) {
                                node.nodes = [];
                            }
                            node.nodes.push(module);
                        }
                    }
                });
                return tree;
            },
            arrayContains: function (array, obj) {
                for (var i = 0; i < array.length; i++) {
                    if (array[i] === obj) {
                        return true;
                    }
                }
                return false;
            },

            map2list: function (map) {

                var list = [];
                for (var p in map) {

                    list.push(map[p]);

                }
                // 最后显示所有的属性

                console.log(JSON.stringify(map) + " convert " + JSON.stringify(list));
                return list;
            },

            // 判断tag输入框内是否有值
            isNone: function (tag) {
                if (tag) {
                    return false
                }
                else {
                    return true
                }
            },
            //时间戳处理
            querySearchParams: function(params) {
                for (var k in params) {
                    if (params[k] instanceof Date) {
                        params[k] = new Date(params[k]).getTime();
                    }
                    // 处理结束时间末尾，要求参数中包含endtime或end
                    if ((k.toLowerCase().indexOf('endtime') != -1 && params[k])||(k.toLowerCase().indexOf('end') != -1 && params[k])) {
                        var timeString = String(params[k]);
                        var str = timeString.substring(timeString.length - 1, timeString.length);
                        if (str != '9') {
                            params[k] = params[k] + 86400000 - 1;
                        }
                    }
                    if (k === 'page') {
                        params[k] = 1;
                    }
                }
                return params;
            },

            // 设置指定时间为当天的0点0分0秒
            setStartDate: function (date) {
                date = new Date(date);
                date.setHours(0);
                date.setMinutes(0);
                date.setSeconds(0);
                date.setMilliseconds(0);
                return date.getTime();
            },
            // 设置指定时间为当天的23点59分59秒
            setEndDate: function (date) {
                date = new Date(date);
                date.setHours(23);
                date.setMinutes(59);
                date.setSeconds(59);
                date.setMilliseconds(999);
                return date.getTime();
            },
        }

    })
    .factory('uploadService', function (path) {
        return {
            uploadFile: function (FileUploader) {
                if (url == undefined || url == "") {
                    return new FileUploader({
                        url: path.upload_url
                    });
                } else {
                    return new FileUploader({
                        url: url
                    });
                }
                return new FileUploader({
                    url: path.upload_url
                });
            }
        }
    })
    .factory('checkboxArray', function () {
        return {
            checked: checked,
            checkAllOrNot: checkAllOrNot,
            removeChecked: removeChecked
        };
        function checked(list) {
            var result = [];
            angular.forEach(list, function (item) {
                if (item.$checked) {
                    result.push(item);
                }
            });
            return result;
        }

        function checkAllOrNot(list, bool) {
            angular.forEach(list, function (item) {
                item.$checked = bool;
            });
            return list;
        }

        function removeChecked(list) {
            var result = [];
            angular.forEach(list, function (item) {
                if (!item.$checked) {
                    result.push(item);
                }
            });
            return result;
        }
    });



