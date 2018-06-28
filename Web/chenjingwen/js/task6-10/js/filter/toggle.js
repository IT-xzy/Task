var app=angular.module('app');
app.filter('toggle',function(){
    var stateArr=[
        {value:1,text:"下线"},
        {value:2,text:"上线"}
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