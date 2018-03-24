var btn = document.getElementById("btn");

    var car = (function(){
        var speed = 0;
        function set(s){
            speed = s
        }
        function get(){
            return speed
        }
        function speedUp(){
            speed++
        }
        function speedDown(){
            speed--
        }
        return {
            set: set,
            get: get,
            speedUp: speedUp,
            speedDown: speedDown
        }
    })();

    car.set(30);
    console.log(car.get());//30
console.log(car);
    car.speedUp();
    car.get() ;//31
    car.speedDown();
    car.get();  //30

// function nvShen(){
//     this.name = "Alice";
// }
// var hand = {
//     whichOne: "right hand",
//     someFunction: function(){
//         console.log("not safe for work.");
//     }
// };
// nvShen().prototype = hand;
// var myObject = new nvShen();
// console.log(myObject.__proto__ === NvShen.prototype);


function NvShen () {
    this.name = "Alice";
}
//现在我设置NvShen这个函数的prototype属性
//一般来说直接用匿名的对象就行，我这里是为了方便理解，
//先定义一个hand对象再把hand赋值给NvShen的prototype
var hand = {
    whichOne: "right hand",
    someFunction: function(){
        console.log("not safe for work.");
    }
};
NvShen.prototype = hand;

//这个时候，我们可以用NvShen作为构造函数，构造出myObject对象
var myObject = new NvShen();
console.log(myObject.__proto__ === NvShen.prototype);//true


