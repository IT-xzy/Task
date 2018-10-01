// 'use strict';


// angular


//     .module('app')


//     // Angular File Upload module does not include this directive
//     // Only for example


//     /**
//     * The ng-thumb directive
//     * @author: nerv
//     * @version: 0.1.2, 2014-01-09
//     */
//     .directive('ngThumb', ['$window', function($window) {
//         var helper = {
//             support: !!($window.FileReader && $window.CanvasRenderingContext2D),
//             isFile: function(item) {
//                 return angular.isObject(item) && item instanceof $window.File;
//             },
//             isImage: function(file) {
//                 var type =  '|' + file.type.slice(file.type.lastIndexOf('/') + 1) + '|';
//                 return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
//             }
//         };

//         return {
//             restrict: 'A',
//             template: '<canvas/>',
//             link: function(scope, element, attributes) {
//                 if (!helper.support) return;

//                 var params = scope.$eval(attributes.ngThumb);

//                 if (!helper.isFile(params.file)) return;
//                 if (!helper.isImage(params.file)) return;

//                 var canvas = element.find('canvas');
//                 var reader = new FileReader();

//                 reader.onload = onLoadFile;
//                 reader.readAsDataURL(params.file);

//                 function onLoadFile(event) {
//                     var img = new Image();
//                     img.onload = onLoadImage;
//                     img.src = event.target.result;
//                 }

//                 function onLoadImage() {
//                     var width = params.width || this.width / this.height * params.height;
//                     var height = params.height || this.height / this.width * params.width;
//                     canvas.attr({ width: width, height: height });
//                     canvas[0].getContext('2d').drawImage(this, 0, 0, width, height);
//                 }
//             }
//         };
//     }]);



// 我的自定义指令
// 来源自慕课大漠穷秋。指令第二节
// 首先app   自定义指令避免以ng为前缀开头
// var module = angular.module('myApp', []);

// // 还得有个对应的controller
// module.controller('ctrl', ['$scope', function ($scope) {
//     $scope.customer = {
//         name: 'Naomi',
//         address: '1600',
//     };
// }])

// module.directive('naomi', function () {
//     return {
//         restrict:'AEMC',
//         templateUrl: 'hello.html'
//     }
// })

// module.run(function ($templateCache) {
//     $templateCache.put("hello.html", "<div>hello directive</div>")
// })

// 这里hello 
// module.directive('hello', function () {
// // module.directive('hello', function ($templateCache) {
//     // 指令定义放这里  一个指令定义对象
//     return {
//         // 通过设置项来定义指令，在这里添加设置，详情见html，默认为A
//         restrict: 'AEMC',
//         // 输入元素属性
//         // template: '<div>hello directive</div>',
//         // template: '<div>hello directive<div ng-transclude></div></div>',
//         // angularJs提供的url模板
//         templateUrl: 'hello.html',
//         // put get缓存方法
//         // template: $templateCache.get('hello.html'),
//         // 替换
//         replace: true,
//         // 默认值意味着模板会被当作子元素插入到调用此指令的元素内部

//         // 显示内部内容,包含
//         // transclude:true,
//     }
// })

// var module = angular.module('myApp', []);
// // 这里hello 对应html中 <hello>
// // module.directive('hello', function () {
// //     // 指令定义放这里  一个指令定义对象  
// //     return {
// //         // 通过设置项来定义指令，在这里添加设置，详情见html，默认为A    
// //         restrict: 'AEMC',
// //         // 输入元素属性       
// //         template: '<div>hello directive</div>',
// //         // template: '<div>hello directive<div ng-transclude></div></div>',   
// //         // angularJs提供的url模板     
// //         // templateUrl: 'hello.html',       
// //         replace: true,
// //         // 默认值意味着模板会被当作子元素插入到调用此指令的元素内部  
// //     }
// // })

// module.directive('hello', function ($templateCache) {

//     return {
//         restrict: 'AEMC',
//         // template: '<div>hello directive</div>',
//         // put get缓存方法
//         template: $templateCache.get('hello.html'),
//         // 替换
//         // replace: true,
//         // 显示内部内容,包含
//         transclude: true,
//     }
// })


// module.directive('imgUpload', function ($http) {
//     return {
//         restrict: 'AEMC',
//         replace: true,
//         transclude: true,
//         templateUrl: 'imgUpload.html',
//         // link下面是没有$符号的 ，scope代表作用域，ele表示本身，attr表示属性   
//         link: function (scope, ele, attr) {
//             scope.abc = "abc";
//         }
//     }
// })




// 5.28日报 自定义指令

var app = angular.module('myApp', []);
app.controller("ctrl", ["$scope", function ($scope) {
    // $scope.customer = {
    //     name: 'xiaomi',
    //     address: 'wuhan'
    // }
    $scope.naomi = {
        name: 'xiaomi',
        address: 'wuhan'
    }
    $scope.igor = {
        name: 'xiaomi',
        address: 'wuhan'
    }
}])
app.directive('mycustomer', function () {
    return {
        restrict: 'E',

        // scope的作用
        scope: {
            customerInfo: '=info'
        },
        templateUrl: 'myCustomer.html'
        // templateUrl还可以是函数
        // templateUrl: function (elem, attr) {
        //     return 'customer-' + attr.type + '.html'
        // }
    }
})


// //angular指令的定义，myDirective ，使用驼峰命名法
// angular.module('myApp', [])
// .directive('myDirective', function ($timeout, UserDefinedService) {
// // 指令操作代码放在这里
// });

// //angular自定义指令 的使用，使用 “-” 来代替驼峰命名法
// <div my-directive></div>
// // 注意：为了避免与未来的HTML标准冲突，给自定义的指令加入前缀来代表自定义的
// // 命名空间。AngularJS本身已经使用了 ng- 前缀，所以可以选择除此以外的名字。
// // 在例子中我们使用 my- 前缀（比如 my-derictive ） 。

// // 指令的生命周期开始于 $compile 方法并
// // 结束于 link 方法

// //自定义指令的全部可设置的属性大致如下
// // 指令的选项如下所示，每个键的值说明了可以将这个属性设置为何种类型或者什么样的
// // 函数：
// angular.module('myApp', [])
// .directive('myDirective', function() {               //指令名称myDirective
// return {                //返回一个对象
// restrict: String,      //可选字符串参数，可以设置这个指令在DOM中可以何种形式被声明，
//             //默认为A（attr(当做标签属性来使用)）<div my-directive></div> 
//             // 设置为“E”(ele,(直接当做标签来使用)) <my-directive></my-directive>
//             //C（类名）
//             //<div class="my-directive:expression;"></div>
//             //M（注释）
//             //<--directive:my-directive expression-->
//             //这些选项可以单独使用，也可以混合在一起使用：
//             //angular.module('myDirective', function(){
//             //    return {
//             //        restrict: 'EA' // 输入元素或属性
//             //    };
//             //})

// priority: Number, //优先级，可忽略，默认为0， ngRepeat的优先级为1000，这样就可以保证在同一元素上，它总是在其他指令之前被调用。
// terminal: Boolean,//（布尔型），true或false,如果为false,则这个参数用来告诉AngularJS停止运行当前元素上比本指令优先级低的指令。优先级相同的指令还是会被执行。 ngIf 的优先级略高于 ngView ，
// template: String or Template Function: //（字符串或函数）指令中的一个重要的一个属性，必须被设置其中一种
//                     //1，  一段HTML文本；
//                     //2，可以接收两个参数的函数，参数为 tElement 和 tAttrs 
//                     //在html模板中必须只有一个根html标签,且如果有换行则需要使用“\”
//                     //例如template: '\
//                     //    <div> <-- single root element -->\
//                     //        <a href="http://google.com">Click me</a>\
//                     //        <h1>When using two elements, wrap them in a parent element</h1>\
//                     //    </div>\
//                     //function(tElement, tAttrs) (...},
//                     //更好的选择是使用 templateUrl 参数引用外部模板，参考下面的参数
// templateUrl: String,        //（字符串或函数）1，外部路径的字符串，2，接受两个参数的函数，参数为 tElement 和 tAttrs ，并返回一个外部HTML文件路径的字符串
//                 //模板加载后，AngularJS会将它默认缓存到 $templateCache 服务中。（可以提前加载模块到缓存中，提高加载速度）
// replace: Boolean or String,  //（布尔型）默认为false(模板内容会加载到标签内部)，true(模板内容会替换当前标签)
// scope: Boolean or Object,  //（布尔型或对象）,默认为false, 设置为true 时，会从父作用域继承并创建一个新的作用域对象。
//             // ng-controller 的作用，就是从父级作用域继承并创建一个新的子作用域。
//             //如果要创建一个能够从外部原型继承作用域的指令，将 scope 属性设置为 true 
//             //设置为一个对象，则能设置 隔离作用域， scope 属性设置为一个空对象 {} 。如果这样做了，指令的模板就无法访问外部作用域了：
//             //例如.directive('myDirective', function() {
//             //        return {
//             //            restrict: 'A',
//             //            scope: {},
//             //            priority: 100,
//             //            template: '<div>Inside myDirective {{ myProperty }}</div>'
//             //        };
//             //    });

//             //在scope对象中，还可以使用“@” “=” “&”,来设置模板中数据的作用域和绑定规则
//             //"@"  本地作用域属性：使用当前指令中的数据和DOM属性的值进行绑定
//             //“=” 双向绑定：本地作用域上的属性同父级作用域上的属性进行双向的数据绑定。
//             //“&” 父级作用域绑定：通过 & 符号可以对父级作用域进行绑定
//             //例如
//             //scope: {
//             //    ngModel: '=', // 将ngModel同指定对象绑定
//             //    onSend: '&', // 将引用传递给这个方法
//             //    fromName: '@' // 储存与fromName相关联的字符串
//             //}

// transclude: Boolean,  //默认为false.只有当你希望创建一个可以包含任意内容的指令时， 才使用 transclude: true 。
//             //如果指令使用了 transclude 参数，那么在控制器（下面马上会介绍）中就无法正常监听数
//             //据模型的变化了。
// controller: String or function(scope, element, attrs, transclude, otherInjectables) { ... }, //（字符串或函数)注册在应用中的控制器的构造函数
//             //使用函数创建内联控制器，例如
//             //angular.module('myApp',[])
//             //    .directive('myDirective', function() {
//             //    restrict: 'A',
//             //    controller:
//             //   function($scope, $element, $attrs, $transclude) {
//             //    // 控制器逻辑放在这里
//             //    }
//             //})

// controllerAs: String,   //可以在指令中创建匿名控制器,例如
//             //.directive('myDirective', function() {
//             //    return {
//             //    restrict: 'A',
//             //    template: '<h4>{{ myController.msg }}</h4>',
//             //    controllerAs: 'myController',
//             //    controller: function() {
//             //        this.msg = "Hello World"
//             //        }
//             //    };
//             //});    


// require: String, //（字符串或数组）字符串代表另外一个指令的名字,如果没有前缀，指令将会在自身所提供的控制器中进行查找，如果没有找到任何控制器（或
//         //具有指定名字的指令）就抛出一个错误。
//         //例如
//         //如果不使用 ^ 前缀，指令只会在自身的元素上查找控制器。
//         //require: 'ngModel'
//         // 使用 ?   如果在当前指令中没有找到所需要的控制器，会将 null 作为传给 link 函数的第四个参数
//         //require: '?ngModel'
//         //使用  ^  如果添加了 ^ 前缀，指令会在上游的指令链中查找 require 参数所指定的控制器。
//         //require: '^ngModel'
//         // 使用 ^？  将前面两个选项的行为组合起来，我们可选择地加载需要的指令并在父指令链中进行查找。
//         //require: '^?ngModel',

// link: function(scope, iElement, iAttrs) { ... }, //compile 选项本身并不会被频繁使用，但是 link 函数则会被经常使用。
//                         //当我们设置了 link 选项， 实际上是创建了一个 postLink() 链接函数， 以便 compile() 函数可以定义链接函数。
//                         //compile 和 link 选项是互斥的。如果同时设置了这两个选项，那么会把 compile
//                         //所返回的函数当作链接函数，而 link 选项本身则会被忽略。
//                         //通常情况下，如果设置了 compile 函数，说明我们希望在指令和实时数据被放到DOM中之前
//                         //进行DOM操作，在这个函数中进行诸如添加和删除节点等DOM操作是安全的。
//         //用 link 函数创建可以操作DOM的指令。
//         //require 'SomeController',
//         //link: function(scope, element, attrs, SomeController) {
//             // 在这里操作DOM，可以访问required指定的控制器
//         //}
// compile: function(tElement, tAttrs, transclude) {  
//         return {
//             pre: function(scope, iElement, iAttrs, controller) { ... },
//             post: function(scope, iElement, iAttrs, controller) { ... }
//         }
//         // 或者
//         return function postLink(...) { ... }
//     }
// };
// });