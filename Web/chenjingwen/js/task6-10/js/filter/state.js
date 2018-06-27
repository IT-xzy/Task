var app=angular.module('app');
app.filter('state',function(){
    var stateArr=[
        {value:1,text:"上线"},
        {value:2,text:"草稿"}
    ];
    return function(state){
        for(i=0;i<2;i++){
            if(state==stateArr[i].value){
                state=stateArr[i].text;
                return state;
            }
        }
    };
});