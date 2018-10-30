angular.module('myApp')
    .controller('add', function ($http, $scope, Upload, articleConstant, $timeout, $state, beg, $filter) {
        var url; //定义图片url
        console.log(url)

        $scope.uploadPic = function (file) { //图片上传
            file.upload = Upload.upload({ //post请求
                url: '/carrots-admin-ajax/a/u/img/task',
                data: {
                    username: $scope.username,
                    file: file,
                },
            });
            file.upload.then(function (response) {
                $timeout(function () { //获取返回的url
                    file.result = response.data.data.url;
                    url = file.result;
                    console.log(url)
                });
            }, function (response) {
                if (response.status > 0)
                    $scope.errorMsg = response.status + ': ' + response.data;
            }, function (evt) {
                // Math.min is to fix IE which reports 200% sometimes
                file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
            });
        }

        var E = window.wangEditor//富文本编辑器
        var editor = new E('#editor')
        editor.create();
        $scope.editor=editor.txt.text();//获取富文本编辑器的内容

        let params = $state.params; //获取传参数据
        var id = $state.params.id //获取编辑项的id
        console.log(params);

        $scope.typeItem = articleConstant.addType; //类型列表
        $scope.industryItem = articleConstant.industryItem; //行业列表
        $scope.selectedIndustry = ~~$state.params.industry;



        $scope.uploadImg = function () { //选择图片
            $scope.hideImg=true;//隐藏编辑渲染的图片
            if ($scope.size != undefined && $scope.name != undefined) {
                $scope.size = undefined; //清空图片大小
                $scope.name = undefined; //清空图片名称
            } else if ($scope.size == undefined && $scope.name == undefined) {
                let num = $scope.picFile.size; //获取图片大小
                console.log(num);
                let size = num / 1024; //除以1024转换为kb
                $scope.size = size.toFixed(2) + "KB" //四舍五入
                console.log($scope.size)
                $scope.name = $scope.picFile.name; //获取图片名称
            }
        }

        $scope.delete = function () { //点击删除按钮
            $scope.picFile = undefined //删除选择的图片
            $scope.size = undefined; //清空图片大小
            $scope.name = undefined; //清空图片名称
            console.log($scope.picFile)
        }

        $scope.data = function () { //封装请求的数据
            $scope.params = {}; //定义新增发起请求的数据
            $scope.params.title = $scope.title; //标题
            $scope.params.type = $scope.selectedType; //类型
            $scope.params.industry = $scope.selectedIndustry //行业
            $scope.params.img = url; //图片
            $scope.params.content = editor.txt.text(); //说明，editor.txt.text()用于获取富文本编辑器内容
            $scope.params.url = $scope.skipUrl; //跳转连接
            $scope.params.status = $scope.status; //状态
            $scope.params.updateAt = $scope.today; //编辑时间
            $scope.params.id = id; //编辑id
        }


        //判断传参如果是新增
        if ($state.params.skip == "add") {
            $scope.hideImg=true;//隐藏编辑时渲染的图片
            $scope.Title = "新增"; //传参为add修改标题为新增

            $scope.selectedType = ~~$state.params.type; //类型列表


            $scope.beg = function () { //封装新增请求方法
                $scope.data(); //调用请求的数据
                beg.postAdd($scope.params).then(function (response) { // 调用新增请求方法
                    console.log($scope.params);
                    console.log(response)
                    if (response.data.code == "0") {//请求返回的code为0
                        if (confirm("上传成功")) {
                            $state.go('home.list'); //点击确定上传并返回到list列表页面
                        } else {
                            $state.reload(); //点击取消上传并刷新当前页面
                        }
                    } else if (response.data.code != "0") {//请求返回的code不为0
                        alert("上传错误")//提示上传错误
                    }
                })
            }

            $scope.online = function () { //点击上线按钮
                if (url == undefined) {
                    alert("请先上传图片"); //未上传图片提示上传图片
                } else if (url != undefined) {
                    $scope.status = 2; //定义status为上线
                    $scope.beg(); //调用新增请求
                }
            }

            $scope.draft = function () {//点击草稿按钮
                if (url == undefined) {
                    alert("请先上传图片"); //未上传图片提示上传图片
                } else if (url != undefined) {
                    $scope.status = 1; //定义status为草稿
                    $scope.beg(); //调用新增请求
                }
            }

            //判断传参如果是编辑
        } else if ($state.params.skip == "compile") {
            $scope.hideImg=false;//显示渲染图片
            $scope.Title = "编辑"; //传参为compile修改标题为编辑
            beg.getListOne(id).then(function (response) { //调用获取单个请求
                console.log(response.data.data.article) //渲染返回的数据
                $scope.title = response.data.data.article.title; //标题
                $scope.selectedType = response.data.data.article.type; //类型
                $scope.selectedIndustry = response.data.data.article.industry; //行业
                $scope.skipUrl = response.data.data.article.url; //跳转连接
                $scope.img = response.data.data.article.img; //图片
                $("p").text(response.data.data.article.content);//说明
                
                if(response.data.data.article.type=="3"){//当编辑的内容为行业大图时显示行业类型
                    $scope.industryHide = false; //定义行业为显示
                }else if(response.data.data.article.type!="3"){//当编辑的内容不是行业大图时隐藏行业类型
                    $scope.industryHide = true; //定义行业为隐藏
                }
            })


            $scope.beg = function () { //封装编辑请求
                $scope.today = new Date().getTime(); //获取单前时间并装换为字符串
                console.log($scope.today);
                $scope.data(); //调用请求数据
                beg.putUpdate($scope.params).then(function (response) { //调用编辑请求
                    console.log(response);
                    if (response.data.code == "0") {//请求返回的code为0
                        if (confirm("上传成功")) {
                            $state.go('home.list'); //点击确定上传并返回到list列表页面
                        } else {
                            $state.reload(); //点击取消上传并刷新当前页面
                        }
                    } else if (response.data.code != "0") {//请求返回的code不为0
                        alert("上传错误")//提示上传错误
                    }
                })
            }

            $scope.url=function(){//封装图片的url
                if(url==undefined){
                    url=$scope.img;//当没有从新上传图片时使用旧图片的url
                }else if(url!=undefined){
                    url=url;//当从新上传图片后使用最新的图片url
                }
            }

            $scope.online = function () { //点击上线按钮
                $scope.status = 2; //修改状态为上线
                $scope.url();//调用图片url
                $scope.beg() //调用请求数据方法
                console.log($scope.params)
            }

            $scope.draft = function () { //点击草稿按钮
                $scope.status = 1; //修改状态为草稿
                $scope.url();//调用图片url
                $scope.beg(); //调用请求数据方法
            }
        }

        $scope.industryHide = true; //定义行业为隐藏
        $scope.type = function () { //点击类型选择框
            console.log($scope.selectedType)
            if ($scope.selectedType == 3) { //当选择行业大图时显示行业选择框，
                $scope.industryHide = false;
            } else { //当不选择行业大图时隐藏行业下拉框
                $scope.industryHide = true;
            }
        }

        $scope.off = function () {
            if (confirm("确定退出当前页面，并终止单前一切操作")) {
                $state.go("home.list");
            } else {
                return
            }
        }
    });