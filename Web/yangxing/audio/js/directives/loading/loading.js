angular.module('admin').directive('loading', function () {
    return {
        templateUrl: 'js/directives/loading/loading.html',
        // template: '<div class="list-replace" ng-if="!getData"><div class="loader">loading...</div></div></div>',
        restrict: 'E',
        replace: true,
        scope: {
            info: "="
        },
        link: function (scope, ele, attrs) {
            scope.getData = false;
            scope.info.then(function (res) {
                if (res.data.code === 0) {
                    scope.getData = true;
                }
            });

        },

        controller: function ($scope, $state) {
        }
    }
});


