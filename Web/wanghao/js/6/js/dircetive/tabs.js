angular.module("myApp")
    .directive("myTabs", function () {
        return {
            restrict: 'AE',
            replace: true,
            scope: {
                page: "=",
            },
            template: " <li ng-repeat='item in pagenum' ><a ng-click='skip(item.num,size)' class='ahref' ng-class={'ahrefturn':isa(item.num)}>{{item.title}}</a></li> ",
            // compile: function (scope) {
            // }
            link: function (scope) {
                scope.$watch('page', function (newValue, oldValue) {
                    scope.pagenum = paging()
                }, true)

                // function run(){
                //   return  [paging(),isa()]
                // }
                function paging() { //分页函数
                    if (scope.page.allpage > 6) {
                        scope.pagenum = []
                        for (let i = 0; i < 7; i++) {
                            if (scope.page.page) { //循环填入数据
                                let w = {
                                    title: scope.page.page + i,
                                    num: scope.page.page + i
                                }
                                scope.pagenum.push(w);
                            } else { //z第一次加载防止没有数据
                                let w = {
                                    title: 1 + i,
                                    num: 1 + i
                                };
                                scope.pagenum.push(w);
                            }
                        }
                        if (scope.pagenum[0].num > 1) { //如果页数大于1，则填入上一页
                            let lastpage = {
                                title: "<",
                                num: scope.page.page - 1
                            }
                            scope.pagenum.unshift(lastpage)
                        }
                        if (scope.pagenum[6].num < scope.page.allpage) { //如果数组的最后一项数组大于总页数
                            let omit = {
                                title: '...',
                                num: ''
                            }
                            scope.pagenum.push(omit)
                            let next = {
                                title: '>',
                                num: scope.page.page + 1,
                            }
                            scope.pagenum.push(next)
                        }
                     
                        return scope.pagenum;

                    } else {
                        scope.pagenum = []
                        for (let i = 0; i < scope.page.allpage; i++) {
                            if (scope.page.page) { //循环填入数据
                                let w = {
                                    title: scope.page.page + i,
                                    num: scope.page.page + i
                                }
                                scope.pagenum.push(w);
                            } else { //z第一次加载防止没有数据
                                let w = {
                                    title: 1 + i,
                                    num: 1 + i
                                };
                                scope.pagenum.push(w);
                            }
                        }
                        return scope.pagenum;
                    }
                }
              
            }
        }
    })












// .directive('xxxx',function(){  //xxxx使用驼峰命名法则。当使用时候使用‘oneTags’ 写成'one-tags'
//     return{    //return 一个对象是指令的输出
//         restrict:'EACM' ,
//         //分别限定指令的使用方法，
//         //E对应的时候元素方法例如<xxx></xxx>
//         // A对应的是元素的标签使用方法例如 <div xxx></div>
//         // C对应的是class名使用方法例如<div class='xxx'></div>
//         // M使用方法为注释使用方法(现在已经不使用)例如 <---xxxx--->
//         replace: true/false, 
//         //replace 方法ture为替换指令写的那一行的元素，flase则不替换
//         template:x,  //function/'HTMl模板',
//         //里面写着指令要显示的html模板,也可以是一个函数
//         templateUrl:url,  //里面写着要显示的html模板的链接
//         //templateUrl和template只生效一个
//         priority: 100, //指令的优先级 默认就是0级按照书写顺序编译
//         compile: function(){ //指令编译一开始就会执行的函数
//             return {  //如果return一个对象函数那么就是link函数
//                 pre:function perLink(){
//                     //在指令编译后链接子元素前生效
//                 },
//                 post:function postLink(){
//                     // 指令在所有子元素指令链接完才会执行
//                     //通常DOM操作都是在postlink中执行,因为这个时候dom对象完整的生成了
//                 }
//             }
//         }, 
//         //link和compile只会生效一个,link表示的是postlink
//         link:function(){}, 
//     }

//     })