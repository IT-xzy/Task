angular.module("myApp")
.filter('wh',function(){
    return function(value){
          if(value==1) return 'wh'  ;
          if(value==3) return "3" ;
    }
    })