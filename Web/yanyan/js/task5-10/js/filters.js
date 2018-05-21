angular.module("myApp")
    .filter("typeFilter", function (type) {
        return function (value) {
            return type[value].name;
        }
    })
    .filter("statusONOFFFilter", function (statusONOFF) {
        return function (value) {
            return statusONOFF[value - 1].name;
        };
    })
    .filter("statusFilter", function (status) {
        return function (value) {
            return status[value - 1].name;
        };
    });

// angular.module('myApp', [])
//     .filter("ChangeCode", function () {
//     return function (inputData) {
//         var changed = "";
//         switch (inputData) {
//             case '0':changed = "首页";break;
//             case '1':changed = "找职位";break;
//             case '2':changed = "找精英";break;
//             case '3':changed = "行业大图";break;
//         }
//         return changed;
//     }
// });