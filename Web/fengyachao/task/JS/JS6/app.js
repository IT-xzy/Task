

//入口模块
angular.module("App", ['ui.router', 'ngMessages', 'oc.lazyLoad', 'ui.bootstrap', 'angularFileUpload'])
    .config(httpConfig);
    function httpConfig($httpProvider) {
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
    }
