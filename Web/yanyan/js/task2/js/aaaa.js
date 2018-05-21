var arg;
foo(3);
console.log(arg);
function foo(arg) {
    console.log(arg)
    var arg;
    return arg;
}console.log(arg);

console.log(arg);

var arg = 1;
console.log(arg);
foo(3);
console.log(arg);
function foo(arg) {
    console.log(arg);
    var arg = 2;
    return arg;
    console.log(arg);
}console.log(arg);


var input = [1,2,3,4,5];
console.log(input[1]);