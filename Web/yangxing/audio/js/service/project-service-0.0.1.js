'use strict';
angular.module('admin')
    .factory('adminService', function ($http, project_path) {
        return {
            //产品列表
            productList: function (params) {
                return $http.get(project_path.productList(), {
                    params: params
                })
            },
            //产品排序
            productSort: function (params) {
                return $http({
                    url: project_path.productSort(),
                    method: "POST",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: JSON.stringify(params),
                    transformRequest: function (data, headersGetter) {
                        return data;
                    }
                });
            },
            //产品详情
            productDetail: function (id) {
                return $http.get(project_path.productDetail(id))
            },
            //编辑产品
            productEdit:function (id,params) {
                return $http.post(project_path.productEdit(id),params)
            },
            //产品上下架
            updateProStatus:function (id,status) {
                return $http.post(project_path.updateProStatus(id,status))
            },
            //分单产品配置
            updateProConf:function (id,status) {
                return $http.post(project_path.updateProConf(id,status))
            },
            //新增客户
            productAdd: function (params) {
                return $http.post(project_path.productAdd(), params)
            },
            //用户列表
            usrList: function (params) {
                angular.forEach(params, function (item, key) {
                    if (item === ''||item===undefined){
                        delete params[key]
                    }
                });

                return $http.get(project_path.usrList(), {
                    params:params
                })
            },
            // 媒介列表
            mediumList: function (params) {
                return $http.get(project_path.mediumList(), {
                    params: params
                })
            },
            // 新增媒介
            addMedium: function (params) {
                return $http.post(project_path.addMedium(),params)
            },
            // 编辑媒介
            editMedium: function (id, params) {
                return $http.post(project_path.editMedium(id),params)
            },
            // 媒介名称验证
            testMedium: function (params) {
                return $http.get(project_path.testMedium(), {
                    params: params
                })
            },
            // 媒介列表上下架
            upDownMedium: function (id, status) {
                return $http.post(project_path.upDownMedium(id, status),{})
            },
            // 媒介列表链接
            mediumLink: function (params) {
                return $http.get(project_path.mediumLink(params.mediumId),{
                    params: {
                        link: params.link
                    }
                })
            },
            // 媒介列表链接单独通过id获取
            mediumLinkS: function (mediumId) {
                return $http.get(project_path.mediumLink(mediumId))
            },
            // 新增媒介链接
            addMediumLink: function (params) {
                return $http.post(project_path.addMediumLink(), params)
            },
            // 删除媒介链接
            removeMediumLink: function (id) {
                return $http.delete(project_path.removeMediumLink(id), {})
            },
            // 媒介统计
            mediumStatistics: function (params) {
                return $http.get(project_path.mediumstatistics(), {
                    params: params
                })
            },
            // 分单统计
            productStatistics: function (params) {
                return $http.get(project_path.productstatistics(), {
                    params: params
                })
            },
            //banner列表
            bannerList: function (params) {
                return $http.get(project_path.bannerList(), {
                    params: params
                })
            },
            //新增banner
            bannerAdd: function (params) {
                return $http.post(project_path.bannerAdd(), params)
            },
            //banner详情
            bannerDetail: function (id) {
                return $http.get(project_path.bannerDetail(id))
            },
            //编辑banner
            bannerEdit:function (id,params) {
                return $http.post(project_path.bannerEdit(id),params)
            },
            //删除banner
            bannerDel:function (id) {
                return $http.delete(project_path.bannerDel(id))
            },
            //banner上下架
            updateBanStatus:function (id,status) {
                return $http.post(project_path.updateBanStatus(id,status))
            },
            //新建账户
            addManager:function (params) {
                return $http.post(project_path.addManager(),params)
            },
            //修改密码
            newPwd:function (id,params) {
                return $http.post(project_path.newPwd(id),params)
            },
        }
    })
    //六、上传
    .factory('uploadService', function ($http, path) {
        return {
            upload: function (formData) {
                return $http.post(path.upload_url, formData, {
                    withCredentials: true,
                    headers: {
                        'Content-Type': undefined
                    },
                    transformRequest: angular.identity
                })
            }
        }
    })
