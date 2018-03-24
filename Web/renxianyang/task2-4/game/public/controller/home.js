angular.module('app').controller('home', ['$rootScope', 'softHeader', 'games', function ($rootScope, softHeader, games) {
    $rootScope.softHeader = softHeader.home;
    var vm = this;
    vm.games = games;
    vm.setPreGame = function (name, uiSref) {
        $rootScope.deskGame.preGame.name = name;
        $rootScope.deskGame.preGame.uiSref = uiSref;
        $rootScope.saveDeskGame();
    }
}]);