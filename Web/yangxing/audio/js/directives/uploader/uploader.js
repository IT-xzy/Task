/*
 * eg： <simple-upload type="0" ng-model="vm.data.IDCardBack" multi=true></simple-upload>
 * multi控制单张或者多张上传
 * 多张上传 img: [{img: xxx, tye: 1}, {img: xxx, tye: 1}]
 * 单张上传 img: 'xxxx'
 * */
angular.module('admin').directive('simpleUpload', function(uploadService) {
    return  {
        restrict: 'AE',
        scope: {
            ngModel : '=',
            multi: '='
        },
        require: 'ngModel',
        template: '' +
        '<div class="uploader-box" ng-if="multi" ng-repeat="li in imgArray">'+
        '<img ng-src="{{li.link}}" />'+
        '<p ng-click="del($index)">点击删除图片</p>'+
        '</div>'+

        '<div class="uploader-box" ng-if="multi" ng-click="triggerSelect()">'+
        '<span ng-if="uploadStatus">上传中...</span>'+
        '<strong><i class="glyphicon glyphicon-plus"></i></strong>'+
        '</div>'+



        '<div class="uploader-box" ng-if="!multi" ng-click="triggerSelect()">'+
        '<img ng-if="img" ng-src="{{img}}" />'+
        '<span ng-if="uploadStatus">上传中...</span>'+
        '<p ng-if="!img">点击上传图片</p>'+
        '</div>'+


        '<input class="hidden" type="file" id="fileInput" onchange="angular.element(this).scope().uploadFile(this.files);">' +

        '',
        link: function(scope, element, attrs, ctrl) {


            if (scope.multi) { // 可上传多个
                scope.imgArray = (!scope.ngModel ? [] : scope.ngModel);
            } else { // 只能上传一个
                scope.img = scope.ngModel;
            }


            // 是否处于上传中状态
            scope.uploadStatus = false;

            // 点击div触发input:file
            scope.triggerSelect = function() {
                element.children('input[type=file]').trigger('click');
            };

            // 获取上传类型
            var type = attrs.type || 0;

            // 上传
            scope.uploadFile = function(files) {
                var fd = new FormData();
                // fd.append("file", files[0]);
                fd.append("image", files[0]);

                scope.uploadStatus = true;

                uploadService.upload(fd).then(function(res) {
                    if (scope.multi) { // 可上传多个
                        scope.imgArray.push({link: res.data.data.url, name: ''});
                        ctrl.$setViewValue(scope.imgArray);
                    } else { // 只能上传一个
                        scope.img = res.data.data.url;
                        ctrl.$setViewValue(scope.img);
                    }
                    scope.uploadStatus = false;
                });
            };


            scope.del = function(index) {
                if (scope.multi) {
                    scope.imgArray.splice(index, 1);
                }
            };

            scope.$watch('ngModel', function(newVal) {
                if(newVal) { scope.img = scope.ngModel;}
            }, true);


        }
    }
});
