angular.module('myApp')
    .directive('ggSidebar', function () {
        return {
            restrict: 'EA',
            replace: true,
            scope: {},
            templateUrl: 'js/directive/gg-sidebar/gg-sidebar.html',
            controllerAs: 'vm',
            bindToController: true,
            controller: function ($window,sidebar) {
                let vm =this;
                //手风琴配置
                let  media= window.matchMedia('(max-width:768px)');//判断分辨率
                vm.open =true;
                if(!media.matches){
                    vm.open =false;
                }
                vm.navOpen=function(){
                    if(media.matches){
                        vm.open=!vm.open
                    }
                };
                vm.sidebar=sidebar;
                vm.first=$window.sessionStorage.getItem('first');
                vm.second=$window.sessionStorage.getItem('second');
                vm.toggleList= function (x) {
                    vm.first= (vm.first === x)? undefined:x;
                };
                vm.currentList = function (y,index) {
                    vm.second=y;
                    $window.sessionStorage.setItem('first',index);
                    $window.sessionStorage.setItem('second',y)
                };
            },
            link: function () {}
        }
        });
app.animation(".animateUl",["$animateCss", function ($animateCss) {
    return {
        enter : function (element) {
            let height = element[0].offsetHeight;
            return $animateCss(element, {
                from: { height:'0px',opacity : 0},
                to: { height:height + 'px',opacity : 1 },
                duration: .2
            })
        },
        leave : function (element) {
            let height = element[0].offsetHeight;
            return $animateCss(element,{
                from : { height:height + 'px' ,opacity : 1},
                to : { height:'0px',opacity : 0 },
                duration : .1
            });
        }
    }
}]);


