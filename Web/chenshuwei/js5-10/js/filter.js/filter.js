angular
    .module("myApp")
    .filter('showType',function (type) {
    return function (input) {
        return type[input]
    }
})
    .filter('showStatus', function (status) {
    return function (input) {
        return status[input]
    }
})
    .filter('changeStatus',function (changeStatus) {
    return function (input) {
        return changeStatus[input]
    }
}).filter('fileSize',function () {
    return function (bytes) {
        var s = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB'];
        var e = Math.floor(Math.log(bytes)/Math.log(1024));
        return (bytes/Math.pow(1024, Math.floor(e))).toFixed(2)+" "+s[e];
    }
})