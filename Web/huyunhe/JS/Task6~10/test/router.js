myTest.config(function ($stateProvider) {
  $stateProvider.state({
    name: 'producer',
    url: '/producer',
    template: '<h1>123</h1>',
    controller: 'producerCtrl'
  })
  .state({
    name: 'producers',
    url: '/producers',
    template:'<h1 ng-click="toPage2(3)">Producers</h1>',
    controller: 'producersCtrl'
  })
})