angular.module('myApp',[])
.directive('toggleChildren',function () {
     $('.Accordion').click(function(){
        $(this).children('.glyphicon-chevron-left').toggleClass('hidden');
        $(this).children('.glyphicon-chevron-down').toggleClass('hidden');
    });
});