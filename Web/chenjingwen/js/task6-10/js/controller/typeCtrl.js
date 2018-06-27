app=angular.module('app');
app.controller('typeCtrl',function($scope,FileUploader,$state,$http,$stateParams,types,industrys,articleOper){
    $scope.types=types;
    $scope.industrys=industrys;
    //图片上传
    var uploader=$scope.uploader=new FileUploader();
    uploader.url='/carrots-admin-ajax/a/u/img/task';
    uploader.queueLimit=1;//限制上传文件个数
    uploader.queue=[];
    uploader.onSuccessItem = function(data,response,fileItem,$stateParams) {
        $scope.imageSrc=response.data.url;
      };
    //点击删除，图片预览消失
    var item=$scope.item;
    $scope.clearImg=function(){
        $scope.imageSrc=false;
    };
    //wangeditor富文本编辑器 
    var editor = new wangEditor("#wEditor");
    editor.customConfig.zIndex=100;
    editor.customConfig.uploadImgShowBase64 = true; 
    editor.customConfig.menus = [
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    'strikeThrough',  // 删除线
    'foreColor',  // 文字颜色
    'backColor',  // 背景颜色
    'link',  // 插入链接
    'justify',  // 对齐方式
    'quote',  // 引用
    'emoticon',  // 表情
    'image',  // 插入图片
    'table',  // 表格
    'video',  // 插入视频
    'code',  // 插入代码
    ];  
    // 使用 base64 保存图片
    editor.create(); 
    //取消键，后退至list页面
    $scope.retreat=function(){
        $state.go('backstage.list');
    };    
    $scope.param={}; 
    if(isNaN(parseInt($stateParams.id))){
         //新增
        $scope.ttitle="新增Article";
        $scope.submit=function(param,imageSrc,value){
            $scope.param.img=imageSrc;
            $scope.param.status=value;//value=1 上线  value=2 草稿
            $scope.param.content=editor.txt.html();
            articleOper.addList($scope.param)//新增请求
            .then(function(response){
                if(response.data.code==0){                    
                    bootbox.alert({  
                        buttons: {  
                           ok: {  
                                label: '确定',  
                                className: 'btn-myStyle'  
                            }  
                        },  
                        message: '新增成功',  
                        callback: function() {  
                            $state.go('backstage.list');
                        } 
                    });  
                }  
            });  
        };
    }
    else{
        //编辑 
        $scope.ttitle="编辑Article";
        articleOper.getArticle($stateParams.id)//获取单个article
        .then(function(response){
            if(response.data.code==0){
                console.log(response);
                $scope.param=response.data.data.article;
                $scope.imageSrc=response.data.data.article.img;
                editor.txt.html($scope.param.content);
            }           
        });
        $scope.submit=function(param,imageSrc,value){
            $scope.param.img=imageSrc;
            $scope.param.status=value;//value=1 上线  value=2 草稿
            $scope.param.content=editor.txt.html();
            articleOper.editList($stateParams.id,$scope.param)//编辑请求
            .then(function(response){
                console.log(response);
                if(response.data.code==0){                   
                    bootbox.alert({  
                        buttons: {  
                           ok: {  
                                label: '确定',  
                                className: 'btn-myStyle'  
                            }  
                        },  
                        message: '编辑成功',  
                        callback: function() {  
                            $state.go('backstage.list');
                        } 
                    });  
                }  
            });     
        };
    }    
});

