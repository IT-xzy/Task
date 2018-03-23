angular.module("myApp")
    .directive('startTime', function () {//开始时间自定义指令
        return {
            restrict: 'AE',
            template: "<input type=\"text\" class=\"form-control\" name=\"start\" id=\"qBeginTime\" ng-model=\"arti.startDate\"/>",
            controller: function () {
                //开始时间
                $('#qBeginTime').datepicker({
                    format: 'yyyy/mm/dd',
                    todayBtn: "linked",
                    autoclose: true,
                    todayHighlight: true,
                    language:'zh-CN'

                }).on('changeDate', function (e) {
                    var startTime = e.date;
                    $('#qEndTime').datepicker('setStartDate', startTime);
                });
            }
        }
    })//结束时间自定义指令
    .directive('endTime', function () {
        return {
            restrict: "AE",
            template: "<input type=\"text\" class=\"form-control\" name=\"end\" id=\"qEndTime\" ng-model=\"arti.endDate\"/>",
            controller: function () {
                $('#qEndTime').datepicker({
                    format: 'yyyy/mm/dd',
                    todayBtn: "linked",
                    autoclose: true,
                    todayHighlight: true,
                }).on('changeDate', function (e) {
                    var endTime = e.date;
                    $('#qBeginTime').datepicker('setEndDate', endTime);
                });
            }
        }
    })//上传图片自定义指令
    .directive('upLoad', ['$http',function ($http) {
        return{
            restrict:'AE',
            templateUrl:'upLoad.html',
            link:function ($scope) {
                $scope.files=null;
                $scope.fileChanged=function (ele) {
                    $scope.$apply(function () {//以下几个需要放进$scope.$apply里，不然不会更新数据。
                        $scope.files=ele.files;//获取文件属性
                        $scope.input=ele;
                        $scope.forbit=false;//上传按钮恢复可用
                        $scope.progress=0;//进度条重置
                        $scope.succeed=false;
                        $scope.mistake=true;
                    });
                };
                $scope.upLoad=function () {
                    var fd=new FormData();
                    fd.append('file',$scope.files[0]);//给formdata键值对
                    if($scope.files[0].size>5242880){
                        bootbox.alert('请选择小于5m的文件')
                    }
                    else {
                        $http({
                            method: 'POST',
                            url: '/carrots-admin-ajax/a/u/img/3',
                            uploadEventHandlers: {
                                progress: function (e) {
                                    $scope.progress = Math.floor(e.loaded / e.total * 100)//获取上传文件进度
                                }
                            },
                            data: fd,
                            headers: {'Content-Type': undefined},//angular默认是json格式发送，所以改成undefined
                        }).then(function (data) {
                                $scope.imgSrc = data.data.data.url
                                $scope.succeed = true;
                                $scope.mistake = false
                            }
                        );
                        $scope.forbit = true;
                    }
                };
                $scope.delete=function () {
                    //点击清空图片的imgSrc 由于ng-src会生存一个img的路径,所以要一并清空
                    var imgSrc=document.getElementById('imgReader');
                        imgSrc.src='';//清空img 的src
                        $scope.imgSrc='';//清空ng-src
                        $scope.input.value='';//清空input file的value值，防止选择同一文件时不触发onchange事件
                        $scope.files='';
                }
            }
        }
    }]);
