
var arr = [];
for (var i = 0; i < 10; i ++) {
    arr[i] =  function(){
        return i;
    };
}
console.log( arr[3]() ); // 10

var fnArr = [];
for (var i = 0; i < 10; i ++) {
    (function(i){
        fnArr[i] =  function(){
            return i;
        }
    })(i)
}
console.log( fnArr[3]() ); // 3