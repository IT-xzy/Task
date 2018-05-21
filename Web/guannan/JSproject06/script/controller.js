"use strict"

//后台页面控制器+++
app.controller('backstageCtrl', function($scope) {
    $scope.oneAtATime = true;
    $scope.isNavCollapsed = true;
    
//菜单+++
    $scope.menus = [
        {
            title: '信息管理',
            content: '信息管理',
            open: false,
            sref: ''
        },
        {
            title: 'Article管理',
            content: 'Article列表',
            open: false,
            sref: 'backstage.list'
        },
        {
            title: '人才管理',
            content: '人才管理',
            open: false,
            sref: ''
        },
        {
            title: '后台管理',
            content: '后台管理',
            open: false,
            sref: ''
        },
    ]
//列表+++
    $scope.lists = [
        {
            id: '1',
            name: '首页banner图',
            type: '首页Banner',
            releaseTime: '2011-11-11 11:11:11',
            changeTime: '2011-11-11 11:11:11',
            publisher: 'admin',
            state: '上线',
            control: 'tip'
        },
        {
            id: '2',
            name: '首页banner图',
            type: '首页Banner',
            releaseTime: '2011-11-11 11:11:11',
            changeTime: '2011-11-11 11:11:11',
            publisher: 'admin',
            state: '上线',
            control: 'tip'
        },
        {
            id: '3',
            name: '首页banner图',
            type: '首页Banner',
            releaseTime: '2011-11-11 11:11:11',
            changeTime: '2011-11-11 11:11:11',
            publisher: 'admin',
            state: '上线',
            control: 'tip'
        },
        {
            id: '4',
            name: '首页banner图',
            type: '首页Banner',
            releaseTime: '2011-11-11 11:11:11',
            changeTime: '2011-11-11 11:11:11',
            publisher: 'admin',
            state: '上线',
            control: 'tip'
        },
        {
            id: '5',
            name: '首页banner图',
            type: '首页Banner',
            releaseTime: '2011-11-11 11:11:11',
            changeTime: '2011-11-11 11:11:11',
            publisher: 'admin',
            state: '上线',
            control: 'tip'
        },
        {
            id: '6',
            name: '首页banner图',
            type: '首页Banner',
            releaseTime: '2011-11-11 11:11:11',
            changeTime: '2011-11-11 11:11:11',
            publisher: 'admin',
            state: '上线',
            control: 'tip'
        }
    ]
});

//登录页面控制器
app.controller('loginCtrl', function($scope, $http, $state) {
	$scope.submit = function() {
		/*简写
		$http.post('/carrots-admin-ajax/a/login', 'name=' + $scope.username + '&pwd=' + $scope.password, {headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
		.then(function successCallback(xhr) {
		console.log('success code:' + xhr.data.code + '-message:' + xhr.data.message);
		}, function errorCallback(xhr) {
		console.log('connection error');
		});
		*/
		
		$http({
			method: 'POST',
			url: '/carrots-admin-ajax/a/login',
			data: 'name=' + $scope.username + '&pwd=' + $scope.password,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		})
		.then(function successCallback(xhr) {
			if (xhr.data.code == 0) {
				$state.go('backstage');
			}
			//console.log('success code:' + xhr.data.code + '-message:' + xhr.data.message);
		}, function errorCallback(xhr) {
			console.log('connection error');
		});
		
	}
});