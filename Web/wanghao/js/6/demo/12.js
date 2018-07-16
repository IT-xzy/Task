angular.module("myApp")
// .constant('testb', '222') //constant设置全局变量
.value('testc', '333') //value设置全局变量
.controller("ww", function (testc,hh) {
        var testa = '111' //直接var全局变量
        console.log(hh)
        hh=66;
        console.log(testa)
        console.log(hh)
        console.log(testc)
    })
   
   

    