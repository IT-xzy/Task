'use strict';
angular.module('admin')
    .factory('path', function(commonUtil) {
        return {
            //login
            // login: "/ajax/a/login",
            login: "/admin/login",
            // logout: "/ajax/a/logout",
            logout: "/admin/u/logout",
            //manager
            manager: function (mid) {
                if (mid == undefined || mid == "") {
                    return "/ajax/a/u/manager";
                } else {
                    return "/ajax/a/u/manager/" + mid;
                }

            },
            manager_list: "/ajax/a/u/manager/list",
            manager_multi_detail: function (params) {
                return "/ajax/a/u/multi/manager" + commonUtil.concactArrayParam("ids", params);
            },

            //pwd
            changePwd: "/ajax/a/u/pwd",
            //role
            role: function (rid) {

                if (rid == undefined || rid == "") {
                    return "/ajax/a/u/role";
                } else {
                    return "/ajax/a/u/role/" + rid;
                }

            },
            role_list: "/ajax/a/u/role/",
            role_multi_detail: function (params) {
                return "/ajax/a/u/multi/role" + commonUtil.concactArrayParam("ids", params);
            },
            //role修改角色的
            changeDetails: function(ridList){
                return "/ajax/a/u/role"+commonUtil.concactArrayParam("rid",ridList);
            },

            role_module: function (rid) {
                return "/ajax/a/u/role/" + rid + "/module"
            },
            role_manager: function (rid) {
                return "/ajax/a/u/role/" + rid + "/manager"
            },
            role_set: function (rid) {
                return "/ajax/a/u/role/" + rid
            },

            //module
            module: function (mid) {
                if (mid == undefined || mid == "") {
                    return "/ajax/a/u/module";
                } else {
                    return "/ajax/a/u/module/" + mid
                }
            },
            module_list: "/ajax/a/u/module/",
            module_multi_detail: function (params) {
                return "/ajax/a/u/multi/module" + commonUtil.concactArrayParam("ids", params);

            },

                //article
                article:function(aid){
                    if(aid==undefined||aid==""){
                        return "/ajax/a/u/article";
                    }else{
                        return "/ajax/a/u/article/"+aid;
                    }


                } ,
                article_list: "/ajax/a/u/article/",
                article_multi_detail:function(params){
                    return "/ajax/a/u/multi/article"+commonUtil.concactArrayParam("ids",params);

                },
                article_status:function(aid){
                 return   "/ajax/a/u/article/"+aid+"/status"
                },
                upload_url:"/admin/u/file"

        }
    })









    .factory('loginService', function($http, path) {
        return {
            login: function(params) {
                return $http.post(path.login,params);
            },
            logout: function() {
                return $http.post(path.logout);
            },
            changePwd: function(params) {
                // params: id|password
                return $http.put(path.changePwd, params);
            }
        }
    })

    .factory('pwdService', function($http, path) {
        return {

            changePwd: function(params) {
                // params: id|password
                return $http.put(path.changePwd, params);
            }


        }
    })
    .factory('managerService', function($http, path,commonUtil,$rootScope,$state) {
        return {
            //这个是增加单元
            getManager: function(mid) {
                return $http.get(path.manager(mid));
            },
            //end这个是增加单元
            addManager: function(params) {
                return $http.post(path.manager(), params);
            },
            updateManager: function(mid,params) {
                return $http.put(path.manager(mid), params);
            },
            deleteManager: function(mid) {
                return $http.delete(path.manager(mid) );
            },
            getManagerList: function(params) {
                return $http.get(path.manager_list,commonUtil.process4Page(params)).then(function(res){
                    return commonUtil.processPageResult(res);
                });
            },
            batchGetManager:function(params){
                return $http.get(path.manager_multi_detail(params));
            },

            saveOrUpdateManager:function(mid,params,url){
                if(mid==undefined||mid==""){
                    this.addManager(params).then(function(res){
                        commonUtil.showReturnMsg(res,url);
                    });
                }else{
                    this.updateManager(mid,params).then(function(res){
                        commonUtil.showReturnMsg(res,url);
                    });

                }

            },

            saveSelfDetail:function(manager){
                localStorage["self"]=JSON.stringify(manager);

            },

            getSelfDetail:function(){
                if(localStorage["self"]==undefined){
                    console.log("not get ptteng-paging data ,relogin ");
                    return undefined;
                }else{

                    console.log();
                    return JSON.parse(localStorage["self"]);
                }

            },
            clearSelfDetail:function(){
                localStorage.removeItem("self");
            }


        }
    })
    //role的
    .factory('roleDetailsService', function($http,project_path) {
        return {
            roleDetails:function(ridList){
                return $http.get(project_path.details(ridList));
            },

            //role details
            roleChange:function(ridList){
                return $http.put(project_path.changeDetails(),ridList);
            }
        }

    })
    .factory('roleService', function($http, path,moduleService,commonUtil) {
        return {
            getRole: function(rid) {
                return $http.post(path.role(rid));
            },
            addRole: function(params) {
                return $http.post(path.role(), params);
            },
            updateRole: function(rid,params) {
                return $http.put(path.role(rid), params);
            },
            deleteRole: function(rid) {
                return $http.delete(path.role(rid) );
            },
            getRoleList: function(params) {
                return $http.get(path.role_list,commonUtil.process4Page(params)).then(function(res){
                    return commonUtil.processPageResult(res);
                });
            },
            getRoleModule:function(rid){
                return $http.get(path.role_module(rid));
            },
            getRoleManager:function(rid){
                return $http.get(path.role_manager(rid));
            },
            getRoleModuleDetail:function(rid){
                var res=this.getRoleModule(rid);
                var moduleIDS=res.data;
                return moduleService.batchGetModule(moduleIDS);

            },

            batchGetRole:function(params){
                return $http.get(path.role_multi_detail(params));
            },
            batchGetr:function(params){
                return $http.get(path.r_multi_detail(params));
            },

            saveOrUpdateRole:function(mid,params,url){
                if(mid==undefined||mid==""){
                    this.addRole(params).then(function(res){
                        commonUtil.showReturnMsg(res,url);
                    });
                }else{
                    this.updateRole(mid,params).then(function(res){
                        commonUtil.showReturnMsg(res,url);
                    });

                }

            }
        }
    })
    .factory('moduleService', function($http, path,commonUtil) {
        return {
            getModule: function(mid) {
                return $http.get(path.module(mid));
            },
            addModule: function(params) {
                return $http.post(path.module(), params);
            },
            updateModule: function(mid,params) {
                return $http.put(path.module(mid), params);
            },
            deleteModule: function(mid) {
                return $http.delete(path.module(mid) );
            },
            getModuleList: function(params) {
                return $http.get(path.module_list,commonUtil.process4Page(params)).then(function(res){
                    return commonUtil.processPageResult(res);
                });
            },
            batchGetModule:function(params){


                return $http.get(path.module_multi_detail(params));
            },

            saveOrUpdateModule:function(mid,params,url){
                if(mid==undefined||mid==""){
                    this.addModule(params).then(function(res){
                        commonUtil.showReturnMsg(res,url);
                    });
                }else{
                    this.updateModule(mid,params).then(function(res){
                        commonUtil.showReturnMsg(res,url);
                    });

                }

            }


        }
    });

