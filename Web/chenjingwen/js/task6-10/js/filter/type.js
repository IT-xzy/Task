var app=angular.module('app');
app.filter('type',function(){
    var stateArr=[
        {value:0,text:"首页Banner"},
        {value:1,text:"找职业Banner"},
        {value:2,text:"找精英Banner"},
        {value:3,text:"行业大图"},
    ];
    return function(type){
        for(i=0;i<4;i++){
            if(type==stateArr[i].value){
                type=stateArr[i].text;
                return type;
            }
        }
    };
});