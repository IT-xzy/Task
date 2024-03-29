var app= angular.module('app', ['angularFileUpload']);
app.controller('AppController', function($scope, FileUploader) {
    var uploader = $scope.uploader = new FileUploader({
        url: 'http://localhost//carrots-admin-ajax/a/u/img/task'
    });

    uploader.onSuccessItem = function(fileItem, response, status, headers) {
        console.info('onSuccessItem', fileItem, response, status, headers);
        $scope.omg=response.data.url
    };
})
















<body ng-controller="AppController" nv-file-drop="" uploader="uploader">

    <div class="container">

    <div class="navbar navbar-default">
    <div class="navbar-header">
    <a class="navbar-brand" href="https://github.com/nervgh/angular-file-upload">Angular File Upload</a>
</div>
<div class="navbar-collapse collapse">
    <ul class="nav navbar-nav">
    <li class="active dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Demos <b class="caret"></b></a>
<ul class="dropdown-menu">
    <li><a href="../simple">Simple example</a></li>
<li class="active"><a href="#">Uploads only images (with canvas preview)</a></li>
<li><a href="../without-bootstrap">Without bootstrap example</a></li>
</ul>
</li>
<li><a href="https://github.com/nervgh/angular-file-upload">View on Github</a></li>
<li><a href="https://raw.githubusercontent.com/nervgh/angular-file-upload/master/dist/angular-file-upload.min.js">Download</a></li>
</ul>
</div>
</div>

<div class="row">

    <div class="col-md-3">

    <h3>Select files</h3>

<div ng-show="uploader.isHTML5">
    <!-- 3. nv-file-over uploader="link" over-class="className" -->
    <div class="well my-drop-zone" nv-file-over="" uploader="uploader">
    Base drop zone
</div>

<!-- Example: nv-file-drop="" uploader="{Object}" options="{Object}" filters="{String}" -->
<div nv-file-drop="" uploader="uploader" options="{ url: '/foo' }">
    <div nv-file-over="" uploader="uploader" over-class="another-file-over-class" class="well my-drop-zone">
    Another drop zone with its own settings
</div>
</div>
</div>

<!-- Example: nv-file-select="" uploader="{Object}" options="{Object}" filters="{String}" -->
<input type="file" nv-file-select="" uploader="uploader" multiple  /><br/>

</div>

<div class="col-md-9" style="margin-bottom: 40px">
    <h2>Uploads only images (with canvas preview)</h2>
<h3>The queue</h3>
<p>Queue length: {{ uploader.queue.length }}</p>

<table class="table">
    <thead>
    <tr>
    <th width="50%">Name</th>
    <th ng-show="uploader.isHTML5">Size</th>
    <th ng-show="uploader.isHTML5">Progress</th>
    <th>Status</th>
    <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="item in uploader.queue">
    <td>
    <strong>{{ item.file.name }}</strong>
<!-- Image preview -->
<!--auto height-->
<!--<div ng-thumb="{ file: item.file, width: 100 }"></div>-->
    <!--auto width-->
    <div ng-show="uploader.isHTML5" ng-thumb="{ file: item._file, height: 100 }"></div>
    <!--fixed width and height -->
    <!--<div ng-thumb="{ file: item.file, width: 100, height: 100 }"></div>-->
    </td>
    <td ng-show="uploader.isHTML5" nowrap>{{ item.file.size/1024/1024|number:2 }} MB</td>
<td ng-show="uploader.isHTML5">
    <div class="progress" style="margin-bottom: 0;">
    <div class="progress-bar" role="progressbar" ng-style="{ 'width': item.progress + '%' }"></div>
    </div>
    </td>
    <td class="text-center">
    <span ng-show="item.isSuccess"><i class="glyphicon glyphicon-ok"></i></span>
<span ng-show="item.isCancel"><i class="glyphicon glyphicon-ban-circle"></i></span>
<span ng-show="item.isError"><i class="glyphicon glyphicon-remove"></i></span>
</td>
<td nowrap>
<button type="button" class="btn btn-success btn-xs" ng-click="item.upload()" ng-disabled="item.isReady || item.isUploading || item.isSuccess">
    <span class="glyphicon glyphicon-upload"></span> Upload
    </button>
    <button type="button" class="btn btn-warning btn-xs" ng-click="item.cancel()" ng-disabled="!item.isUploading">
    <span class="glyphicon glyphicon-ban-circle"></span> Cancel
    </button>
    <button type="button" class="btn btn-danger btn-xs" ng-click="item.remove()">
    <span class="glyphicon glyphicon-trash"></span> Remove
    </button>
    </td>
    </tr>
    </tbody>
    </table>
    <img src="" alt="" ng-src="{{omg}}">
    <div>
    <div>
    Queue progress:
    <div class="progress" style="">
    <div class="progress-bar" role="progressbar" ng-style="{ 'width': uploader.progress + '%' }"></div>
    </div>
    </div>
    <button type="button" class="btn btn-success btn-s" ng-click="uploader.uploadAll()" ng-disabled="!uploader.getNotUploadedItems().length">
    <span class="glyphicon glyphicon-upload"></span> Upload all
    </button>
    <button type="button" class="btn btn-warning btn-s" ng-click="uploader.cancelAll()" ng-disabled="!uploader.isUploading">
    <span class="glyphicon glyphicon-ban-circle"></span> Cancel all
    </button>
    <button type="button" class="btn btn-danger btn-s" ng-click="uploader.clearQueue()" ng-disabled="!uploader.queue.length">
    <span class="glyphicon glyphicon-trash"></span> Remove all
    </button>
    </div>

    </div>

    </div>

    </div>

    </body>