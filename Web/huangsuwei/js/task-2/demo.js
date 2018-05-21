var v1, v2, v3 = 'hello', v4 =42, v5;
var a = 1;
var b = 2;
a + 1;
b + 2;
a + b;
var c = a + b;
c;
1+2
function multiplyeytome(a,b,c,callback){
    var i,ar =[];
    for(i =0;i < 3;i++){
        ar[i] = callback(arguments[i*2]);
    }
    return ar;
}