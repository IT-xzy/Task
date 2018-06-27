app.controller("writeCtrl", function ($scope,serviceHTTP, $state, $stateParams,$timeout){
    var id = $state.params.id;
    var vm = this
    $timeout(function () {  //因为渲染数据的时候，富文本编辑器的节点还没渲染出来，所以加了延时函数
    vm.titleWarp = "新增文章";
    // 初始化富文本编辑器
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.create();
    if (id){
        vm.titleWarp = "编辑文章";
        serviceHTTP.getArticle(id).then(function successCallback(res) {
            var article = res.data.data.article;            
            // 渲染编辑页面 或者储存数据到作用域里
            vm.title = article.title;
            vm.type = String(article.type);
            vm.industry = String(article.industry);
            vm.status = article.status;
            vm.imgurl = article.img;
            vm.url = article.url;
            vm.createAt = article.createAt;
            editor.txt.html(article.content);
            if(article.img){
                vm.showImg = true;
                // $("#preview").attr("src", article.img);
                vm.file = article.img;
            }
        });        
    }   
    // 选择图片后显示相关信息
    vm.click = function () {
        var file = $("#img").get(0).files[0];
        vm.file = file;
        var filename = file.name;
        console.log(file);
        
        // vm.$apply(function () {
        //     vm.file = file;
        // })
        //$scope.$apply(
            // $timeout(function(){
            //     vm.files = file,
            //         console.log(vm.files),
            //         $scope.$apply()
            // })
           
        //)
        var filesize = (file.size / (1024 * 1024)).toFixed(2);
        var str = "<div style='padding-top: 20px;'> <strong>图片名称：</strong>" + "<span style='margin-left: -20px;'>" + filename + "</span>" + "<strong style='padding-left: 40px;'>图片大小：</strong style='margin-left: -20px;'>" + "<span>" + filesize + "</span>" + "MB</div>";
        vm.str = str;
        $("#text").html(str);
        vm.showImg = true;
        vm.showProgress = true;
    };
    // 初始化假进度条进度
    vm.progress = 0;
    // 上传图片
    vm.upload = function () {        
        if ((vm.file == vm.imgurl) & (vm.file != undefined) & (vm.file != "")){
            alert("该图片不需要重新上传！")
        }
        if (!vm.file) {
           alert("请先选择图片！");
        } 
        if ((vm.file != vm.imgurl) & (vm.file != undefined) & (vm.file != "")){
            var formData = new FormData(); // 创建formData对象用于上传图片
            formData.append("file", vm.file);
            serviceHTTP.uploadHTTP(formData).then(function(res) {
                if (res.data.code == 0) {
                    var progressPlus = function() {
                        for (vm.progress = 0; vm.progress < 100; ) {
                            vm.progress++;
                        }
                    };
                    progressPlus();
                    vm.imgurl = res.data.data.url;
                    // $("#preview").attr("src", vm.imgurl);
                }
                else { alert("上传失败！") }
            });
        }
    }
    // 删除已选择图片
    vm.clear = function () {
        if (!vm.file) {
            alert("还未选择图片！")
        }
        else {
            vm.file = '';
            vm.imgurl = '';
            // vm.str = "";
            vm.progress = 0;
            $("#text").html(vm.str); //重新渲染图片信息部分
            vm.showImg = false; //移除图片预览部分
            vm.showProgress = false; // 移除进度条DOM
        }
    };
    // 编辑文章请求
    vm.write = function (articleStatus) {
        var article = { 
            status: articleStatus, 
            title: vm.title, 
            type: vm.type, 
            img: String(vm.imgurl), 
            content: editor.txt.html(), 
            url: vm.url, 
            industry: vm.industry, 
            createAt: vm.createAt 
        };
        console.log(editor.txt.html());
        if(!id){
            serviceHTTP.addOfflineHTTP(article).then(function (res) {
                if (res.data.code == 0) {
                    alert("新增文章成功！");
                    $state.go("backstage.list", {}, { reload: true });
                }
                else {
                    alert("新增文章失败。");
                }
            })
        }
        if(id){
            serviceHTTP.writeOfflineHTTP(id, article).then(function(res) {
                if (res.data.code == 0) {
                alert("编辑文章成功！");
                $state.go("backstage.list", {}, { reload: true });
                console.log(article.content);
                } else {
                alert("编辑文章失败。");
                }
            })            
        }
    }
    // 上线
    vm.online = function (articleStatus = 2) {
        if (!vm.imgurl) {
            alert("请先上传图片！")
        }
        else (
            vm.write(articleStatus)
            // write.upload(articleStatus,id)
        )
    };
    // 存为草稿
    vm.draft = function (articleStatus = 1) {
        if (!vm.imgurl) {
            alert("请先上传图片！")
        }
        else (
            vm.write(articleStatus)
            // write.upload(articleStatus,id)
        )
    };
    })
})
