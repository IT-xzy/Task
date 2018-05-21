angular.module("myApp")

    .filter("ChangeType", function (types) {
        return function (index) {
            return types[index]
        };
    })

    .filter("ChangeStatus", function (Status) {
        return function (index) {
            return Status[index]
        }
    })

    .filter("ChangeLine",function (Online) {
        return function (index) {
            return Online[index]
        }
    })