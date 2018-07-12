'use strict';


angular


    .module('app', ['angularFileUpload'])


    .controller('AppController', ['$scope', 'FileUploader', function ($scope, FileUploader) {
        var uploader = $scope.uploader = new FileUploader({
            url: 'imgUpload.html'
        });

        // FILTERS

        uploader.filters.push({
            name: 'imageFilter',
            fn: function (item /*{File|FileLikeObject}*/ , options) {
                var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
        });

        uploader.onAfterAddingFile = function (fileItem) {
            var reader = new FileReader();
            reader.addEventListener("load", function (e) {
                //文件加载完之后，更新angular绑定
                $scope.$apply(function () {
                    $scope.iconUrl = e.target.result;
                });
            }, false);
            reader.readAsDataURL(fileItem._file);
        };

        // CALLBACKS

        uploader.onWhenAddingFileFailed = function (item /*{File|FileLikeObject}*/ , filter, options) {
            console.info('onWhenAddingFileFailed', item, filter, options);
        };
        uploader.onAfterAddingFile = function (fileItem) {
            console.info('onAfterAddingFile', fileItem);
        };
        uploader.onAfterAddingAll = function (addedFileItems) {
            console.info('onAfterAddingAll', addedFileItems);
        };
        uploader.onBeforeUploadItem = function (item) {
            console.info('onBeforeUploadItem', item);
        };
        uploader.onProgressItem = function (fileItem, progress) {
            console.info('onProgressItem', fileItem, progress);
        };
        uploader.onProgressAll = function (progress) {
            console.info('onProgressAll', progress);
        };
        uploader.onSuccessItem = function (fileItem, response, status, headers) {
            console.info('onSuccessItem', fileItem, response, status, headers);
        };
        uploader.onErrorItem = function (fileItem, response, status, headers) {
            console.info('onErrorItem', fileItem, response, status, headers);
        };
        uploader.onCancelItem = function (fileItem, response, status, headers) {
            console.info('onCancelItem', fileItem, response, status, headers);
        };
        uploader.onCompleteItem = function (fileItem, response, status, headers) {
            console.info('onCompleteItem', fileItem, response, status, headers);
        };
        uploader.onCompleteAll = function () {
            console.info('onCompleteAll');
        };

        console.info('uploader', uploader);



        $(function () {
            //取值title
            if (localStorage.getItem('title')) {
                for (var i = 0; i < JSON.parse(localStorage.getItem('title')).length; i++) {
                    if (JSON.parse(localStorage.getItem('title'))[i] == 1) {
                        $(".list_dt[index=" + i + "]").css("background-color", "red");
                        $(".list_dt[index=" + i + "]+ul").css("display", "block");
                    } else {
                        $(".list_dt[index=" + i + "]").css("background-color", "transparent");
                        $(".list_dt[index=" + i + "]+ul").css("display", "none");
                    }
                }
            }

            //取list数组
            if (localStorage.getItem('list_li')) {
                for (var i = 0; i < JSON.parse(localStorage.getItem('list_li')).length; i++) {
                    for (var j = 0; j < JSON.parse(localStorage.getItem('list_li'))[i].length; j++) {
                        if (JSON.parse(localStorage.getItem('list_li'))[i][j] == 1) {
                            $(".list_dt[index=" + i + "]").siblings("ul.body").children(".list_li[index=" + j + "]").css("background-color", "#00ee00");
                        } else {
                            $(".list_dt[index=" + i + "]").siblings('ul.body').children(".list_li[index=" + j + "]").css("background-color", "transparent");
                        }
                    }
                }
            }


            //存数组title
            $('.list_dt').click(function () {
                    var title = [];
                    $(".list_dt").css('background-color', 'transparent');
                    $("ul.body").css("display", "none");
                    $(this).css('background-color', 'red');
                    $(this).siblings('ul.body').toggle();
                    if ($(this).siblings('ul.body').css('display') === 'block') {
                        title[Number($(this).attr("index"))] = 1;
                        console.log(title[Number($(this).attr("index"))]);
                        localStorage.setItem('title', JSON.stringify(title));
                    } else if ($(this).siblings('ul.body').css('display') === 'none') {
                        title[Number($(this).attr("index"))] = 0;
                        localStorage.setItem('title', JSON.stringify(title));
                    }
                    console.log($(this).siblings('ul.body').css("display"));
                }
            )

            //存数组list
            $('.list_li').click(function () {
                    //定义二维数组
                    var list = new Array(6);
                    for (var i = 0; i < 6; i++) {
                        list[i] = new Array(5);
                    }
                    //重置.list的背景色
                    $(".list_li").css('background-color', 'transparent');
                    $(this).css('background-color', '#00ee00');
                    //用Number转化index的字符串值
                    list[Number($(this).parent().attr("index"))][Number($(this).attr("index"))] = 1;
                    //存数组需先把数组转化为JSON
                    localStorage.setItem('list_li', JSON.stringify(list));
                }
            )
        });



    }]);