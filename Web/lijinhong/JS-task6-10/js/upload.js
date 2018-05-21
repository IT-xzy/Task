

angular.module('app').controller('imgCtrl', function($scope,serviceHTTP,$state,$stateParams) {   //新增页面
	$scope.ctrlScope = $scope;
	 //初始化富文本
        var E = window.wangEditor
        // var editor = new E('#editor')
        var editor = new E( document.getElementById('editor') )
        editor.create();

var id =$stateParams.id;

if (id) {
		$scope.editPage = true;
		var id =id;
		serviceHTTP. articleHTTP(id).then(function (res) {   //渲染页面
			console.log(res);
			$scope.title= res.data.data.article.title;  	
			$scope.type= res.data.data.article.type+"";
			$scope.url= res.data.data.article.url;
			$scope.img= res.data.data.article.img;
			$scope.industry= res.data.data.article.industry+"";
			editor.txt.html(res.data.data.content);

		});
		console.log(id);
		var obj={};
		$scope.status2= function(){    //编辑上线
			
				obj.title=$scope.title,
				obj.content="",
				obj.url=$scope.url,
				obj.industry="",
				obj.status=2,
				obj.img=$scope.img,
				obj.type=$scope.type,
			console.log(obj);
		serviceHTTP. editHTTP(id,obj).then(function(data) {
			console.log(data);
		
			 	$state.go("page.list");
			 	location.reload();

			
		});  
	};
	}else{
		$scope.newPage = true;
		var imgParams={};
		$scope.status2= function(){    //点击上线
				imgParams.type=$scope.type,
				imgParams.title=$scope.title,
				imgParams.content=editor.txt.text(),
				imgParams.url=$scope.url,
				imgParams.industry=$scope.ctrlScope.industry,
				imgParams.status=2,
				imgParams.img=$scope.img
		
			console.log(imgParams);
		
		serviceHTTP.newHTTP(imgParams).then(function(data) {
			console.log(data);
			if (data.data.code == 0) {
				$state.go("page.list");
				location.reload();

			}
		});  
	};

	//存为草稿

	$scope.status1= function(){      
		var imgParams={
			type:$scope.type,
			title:$scope.title,
				content:$scope.content,
				url:$scope.url,
				industry:$scope.ctrlScope.industry,
				status:1,
				img:$scope.img
		};
		serviceHTTP.newHTTP(imgParams).then(function(data) {
			console.log(data);
			if (data.data.code == 0) {
				$state.go("page.list");
				location.reload();
			}

		})
	};

	}
	
	console.log($scope.img);

	$scope.upload= function(){ 
		var formdata = new FormData();            
		formdata.append("file" , $("#file")[0].files[0]);
		var a=($("#file")[0].files[0]);        
		console.log(a);
		$scope.imgName=a.name; 

		//转换图片内存          
		$scope.imgSize= (a.size / (1024 * 1024)).toFixed(2) + "MB";  
		console.log($scope.imgSize);
		$scope.flag = true;  

		//进度条
		var pg=document.getElementById('pg'); 
		setInterval(function(e){
			if(pg.value!=100) pg.value++;
			else pg.value=0;
		},50);
		serviceHTTP.imgHTTP(formdata).then(function (img) {
			console.log(img);    
		$scope.img=img.data.data.url;      //图片上传后获取URl预览图片
		$scope.success = true;
	});  


	};


//   点击取消


$scope.cancel= function(){
	$state.go("page.list"); 
	location.reload();
};


 //   // 图片上传之前预览图片

	// file.onchange=function(){              
 //       var read=new FileReader() // 创建FileReader对像;

 //  read.readAsDataURL(this.files[0])  // 调用readAsDataURL方法读取文件;

 //  read.onload=function(){

 //                    url=read.result  // 拿到读取结果;
 //                    var img=new Image();

 //                    img.width = 500;  //设置图片页面展示大小

 //                    img.src=url;

 //                    div.appendChild(img);
 //                }
 //            }


 //   console.log(read);


});


