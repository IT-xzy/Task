//普通写法
var obj = {
    name: '赵日天',
    age: 18,
    jib: 'web',
    sayHi: function () {
        console.log('赵日天' + '大战金刚葫芦娃');
    }
}
var say = obj.sayHi();

//工厂模式
function person(name, age, job) {
    var x = {};
    x.name = name;
    x.age = age;
    x.job = job;
    x.sayHi = function () {
        console.log(this.name + '大战金刚葫芦娃')
    }
    return x;
}
var p1 = person('奥特曼','18','web');

p1.sayHi();

//构造函数
function Person(name,age,job){
    this.name = name;
    this.age = age;
    this.job = job;
    this.sayHi = function(){
        console.log(this.name + '大战地狱三头犬')
    }
}
var p1 = new Person('孙悟空','500','杀手');
p1.sayHi();

class Person {
    constructor(name, age, job) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.sayHi = function () {
            console.log(this.name + '大战三头犬');
        };
    }
}
var p2 = new Person('孙悟空','500','杀手');
p2.sayHi();