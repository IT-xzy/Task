'use strict';
myApp.controller('AppController', ['$scope', 'FileUploader','$http','$rootScope', function($scope, FileUploader,$http,$rootScope) {
        var uploader = $scope.uploader = new FileUploader({
            url: '/carrots-admin-ajax/a/u/img/3',
            queueLimit:1
        });

        uploader.filters.push({
            name: 'imageFilter',
            fn: function(item /*{File|FileLikeObject}*/, options) {
                var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png |jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
        });
        uploader.onSuccessItem = function(fileItem, response, status, headers) {
            $rootScope.PicUrl = response.data.url;
        };
    }]);