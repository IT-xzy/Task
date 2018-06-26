'use strict';
angular.module('admin')
    .factory('project_path', function (commonUtil) {
        return {
            //客户列表
            productList: function () {
                return "/admin/u/product/list"
            },
            //产品排序
            productSort:function () {
                return "/admin/u/product/sort"
            },
            //产品详情
            productDetail:function(id){
                return "/admin/u/product/"+id+"/detail"
            },
            //编辑产品
            productEdit:function(id){
                return "/admin/u/product/"+id
            },
            //产品上下架
            updateProStatus:function(id,status){
                return "/admin/u/product/"+id+"/status/"+status
            },
            //分单产品配置
            updateProConf:function(id,status){
                return "/admin/u/product/"+id+"/config/"+status
            },
            //banner上下架
            updateBanStatus:function(id,status){
                return "/admin/u/banner/"+id+"/status/"+status
            },
            //新增客户
            productAdd: function () {
                return "/admin/u/product"
            },
            //用户列表
            usrList: function () {
                return "/admin/u/user/list"
            },
            //媒介列表
            mediumList: function () {
                return "/admin/u/medium/list"
            },
            //新增媒介
            addMedium: function () {
                return "/admin/u/medium"
            },
            //修改媒介
            editMedium: function (id) {
                return "/admin/u/medium/" + id
            },
            //媒介名称验证
            testMedium: function () {
                return "/admin/u/medium/name"
            },
            //媒介上下架
            upDownMedium: function (id, status) {
                return "/admin/u/medium/" + id + "/" + status
            },
            //媒体链接
            mediumLink: function (mediumId) {
                return "/admin/u/link/" + mediumId + "/list"
            },
            //媒体链接新增
            addMediumLink: function () {
                return "/admin/u/link"
            },
            //删除媒介链接
            removeMediumLink: function (id) {
                return "/admin/u/link/" + id
            },
            //媒介统计
            mediumstatistics: function () {
                return "/admin/u/medium/statistics"
            },
            //分单统计
            productstatistics: function () {
                return "/admin/u/product/statistics"
            },
            //banner列表
            bannerList: function () {
                return "/admin/u/banner/list"
            },
            //新增banner
            bannerAdd: function () {
                return "/admin/u/banner"
            },
            //banner详情
            bannerDetail:function(id){
                return "/admin/u/banner/"+id+"/detail"
            },
            //编辑banner
            bannerEdit:function(id){
                return "/admin/u/banner/"+id
            },
            //删除banner
            bannerDel:function(id){
                return "/admin/u/banner/"+id
            },
            //新建账户
            addManager:function(){
                return "/admin/u/manager"
            },
            //修改密码
            newPwd:function (id) {
                return "/admin/u/manager/"+id+"/password"
            }
        }
    });