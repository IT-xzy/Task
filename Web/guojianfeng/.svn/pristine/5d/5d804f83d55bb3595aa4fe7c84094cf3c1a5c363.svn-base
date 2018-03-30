angular.module("App")
    .filter("changeStatus", function (status) {
        return function (index) {
            return status[index-1].name;
        };
    })
    .filter("changeLine", function (onLine) {
        return function (index) {
            return onLine[index-1].name;
        };
    })
    .filter("changeType", function (type) {
        return function (index) {
            return type[index].name;
        };
    });

