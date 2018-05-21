angular.module('myApp', ['ngMessages','angularFileUpload','meta.umeditor'])
    .controller('addArticle', function ($scope, $http, $state, FileUploader,$stateParams,industries,types) {
        $scope.industries = industries;
        $scope.types = types;
        $scope.id = $state.params.id || '';
        $scope.reg ="^(http|https|ftp)\://([a-zA-Z0-9\.\-]+(\:[a-zA-Z0-9\.&%\$\-]+)*@)*" +
            "((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\." +
            "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\." +
            "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\." +
            "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|localhost|([a-zA-Z0-9\-]+\.)*[a-zA-Z0-9\-]+\." +
            "(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(\:[0-9]+)*(/($|[a-zA-Z0-9\.\,\?\'\\\+&%\$#\=~_\-]+))*$";

        console.log($scope.id);
        console.log($state.params);

        // 判断是新增\编辑
        if ($scope.id !== '') {
            $http({
                url: '/carrots-admin-ajax/a/article/' + $scope.id,
                method: 'GET'
                // headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (rep) {
                $scope.alldata       = rep.data.data.article;
                $scope.titleName     = rep.data.data.article.title;
                $scope.addType       = rep.data.data.article.type;
                $scope.articleStatus = rep.data.data.article.status;
                $scope.img           = rep.data.data.article.img;
                $scope.url           = rep.data.data.article.url;
                $scope.addContent    = rep.data.data.article.content;
                $scope.Industry      = rep.data.data.article.industry;
                $scope.addArticleTitle = '编辑页';
                $scope.statusText = true;
                console.log(typeof $scope.addType);
            })
        } else {
            $scope.addArticleTitle = '新增页';
        }


        $scope.config = {};
        $scope.addContent = {
            text: '<p>Hello World</p>'
        };

        var uploader = $scope.uploader = new FileUploader({
            url: "/carrots-admin-ajax/a/u/img/task"
        });

        $scope.clearItems = function () {
            uploader.clearQueue();
            $scope.statusText = "";
        };

        uploader.onSuccessItem = function (FileItem, response) {
            $scope.img = response.data.url;
            $scope.statusText = true;
        };

        uploader.onErrorItem = function (FileItem, response) {
            $scope.statusText = response.data.message;
        };

        function inst () {
            if($scope.addType===3){$scope.industry=$scope.Industry}
            else {$scope.industry=''}
        }


        function myPostData() {
            inst ();
            $scope.postData = {
                title: $scope.titleName,
                type: $scope.addType,
                status: $scope.articleStatus,
                img: $scope.img,
                url: $scope.url,
                content: $scope.addContent,
                industry: $scope.industry
            };
        }

        function allData() {
            inst ();
            $scope.alldata.title  = $scope.titleName;
            $scope.alldata.type   = $scope.addType;
            $scope.alldata.status = $scope.articleStatus;
            $scope.alldata.img    = $scope.img;
            $scope.alldata.url    = $scope.url;
            $scope.alldata.content  = $scope.addContent;
            $scope.alldata.industry = $scope.industry;
        }

        function postFromData(postData) {
            $http({
                method: "POST",
                url: "/carrots-admin-ajax/a/u/article",
                params: postData,
                header: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
            }).then(function (response) {
                if (response.data.code === 0) {
                    alert("成功增加");
                    $state.go("welcome.article");
                } else {
                    alert(response.data.message);
                }
            });
        }

        function putFromData(id, putData) {
            $http({
                method: "PUT",
                url: "/carrots-admin-ajax/a/u/article/" + id,
                params: putData,
                header: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
            }).then(function (response) {
                if (response.data.code === 0) {
                    alert("成功编辑");
                    $state.go("welcome.article");
                } else {
                    alert(response.data.message);
                }
            });
        }



        $scope.OnLine = function () {
            $scope.articleStatus = 2;
            if ($scope.id === "") {
                myPostData();
                postFromData($scope.postData);
            } else {
                allData();
                putFromData($scope.id, $scope.alldata);
            }
        };

        $scope.draft = function () {
            $scope.articleStatus = 1;
            if ($scope.id === "") {
                myPostData();
                postFromData($scope.postData);
            } else {
                allData();
                putFromData($scope.id, $scope.alldata);
            }
        };


        $scope.remove = function () {
            var remove = confirm("放弃本次编辑？！");
            if (remove === true) {
                $state.go("welcome.article");
            } else {
                return false;
            }
        };


    });



