'use strict';
angular.module('admin')
// 上下架状态
    .filter('statusFilter', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "下架";
                case 1:
                    return "上架";
            }
        }
    })
    // 房贷情况
    .filter('estateFilter', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "";
                case 1:
                    return "有房贷";
                case 2:
                    return "有房无贷";
                case 3:
                    return "无房";
            }
        }
    })
    // 车产情况
    .filter('carFilter', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "";
                case 1:
                    return "有车贷";
                case 2:
                    return "有车无贷";
                case 3:
                    return "无车";
            }
        }
    })
    // 信用卡情况
    .filter('cardFilter', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "";
                case 1:
                    return "有信用卡";
                case 2:
                    return "无信用卡";
            }
        }
    })

    // 保单情况
    .filter('lifeInsuranceFilter', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "";
                case 1:
                    return "有保单";
                case 2:
                    return "无保单";
            }
        }
    })
    // 年保费情况
    .filter('feeInsuranceFilter', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "";
                case 1:
                    return "<2400";
                case 2:
                    return ">2400";
            }
        }
    })
    // 居住情况
    .filter('livingTimeFilter', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "";
                case 1:
                    return "<6个月";
                case 2:
                    return ">6个月";
            }
        }
    })
    // 职业
    .filter('professionFilter', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "";
                case 1:
                    return "白领";
                case 2:
                    return "公务员";
                case 3:
                    return "私企业主";
            }
        }
    })
    //是否配置
    .filter('proConfig', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "未配置";
                case 1:
                    return "已配置";
            }
        }
    })
    //切换配置
    .filter('proConfigB', function () {
        return function (status) {
            switch (status) {
                case 0:
                    return "配置";
                case 1:
                    return "取消配置";
            }
        }
    })