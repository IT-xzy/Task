var app = angular.module('app', []);
app.controller("myCtrl", function ($scope) {
    $scope.ctrlFlavor = "百威";
    $scope.sayHello = function (name) {
        alert("hello" + name);
    };
    $scope.moduleList = [
        {
            "id": 256,
            "icon": "",
            "parentID": "",
            "name": "档案管理",
            "menuID": "",
            "url": "field.dossier",
            "type": "",
            "level": "",
            "createBy": 101,
            "updateBy": 101,
            "updateAt": 1522761184451,
            "createAt": 1521629864875,
            "nodes": [
                {
                    "id": 263,
                    "icon": "",
                    "parentID": 256,
                    "name": "未通过",
                    "menuID": "",
                    "url": "field.refuseDossiers",
                    "type": "",
                    "level": 7,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1522807216168,
                    "createAt": 1522291405945
                },
                {
                    "id": 261,
                    "icon": "",
                    "parentID": 256,
                    "name": "审核记录",
                    "menuID": "",
                    "url": "field.recordDossiers",
                    "type": "",
                    "level": 6,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1521894404035,
                    "createAt": 1521630242128
                },
                {
                    "id": 260,
                    "icon": "",
                    "parentID": 256,
                    "name": "已存档",
                    "menuID": "",
                    "url": "field.doneDossiers",
                    "type": "",
                    "level": 7,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1521630207292,
                    "createAt": 1521630207292
                },
                {
                    "id": 259,
                    "icon": "",
                    "parentID": 256,
                    "name": "申请中",
                    "menuID": "",
                    "url": "field.applyDossiers",
                    "type": "",
                    "level": 8,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1521630173826,
                    "createAt": 1521630173826
                },
                {
                    "id": 258,
                    "icon": "",
                    "parentID": 256,
                    "name": "未提交",
                    "menuID": "",
                    "url": "field.noDossiers",
                    "type": "",
                    "level": 9,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1521630122562,
                    "createAt": 1521630122562
                },
                {
                    "id": 257,
                    "icon": "",
                    "parentID": 256,
                    "name": "全部列表",
                    "menuID": "",
                    "url": "field.allDossiers",
                    "type": "",
                    "level": 10,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1521630067807,
                    "createAt": 1521630067807
                }
            ]
        },
        {
            "id": 245,
            "icon": "",
            "parentID": "",
            "name": "问答管理",
            "menuID": "",
            "url": "",
            "type": "",
            "level": "",
            "createBy": 101,
            "updateBy": 101,
            "updateAt": 1516632587469,
            "createAt": 1516632587469,
            "nodes": [
                {
                    "id": 253,
                    "icon": "",
                    "parentID": 245,
                    "name": "回答列表",
                    "menuID": "",
                    "url": "field.answerList",
                    "type": "",
                    "level": 9,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1516973423257,
                    "createAt": 1516972993879
                },
                {
                    "id": 252,
                    "icon": "",
                    "parentID": 245,
                    "name": "问题列表",
                    "menuID": "",
                    "url": "field.questionList",
                    "type": "",
                    "level": "",
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1516973054024,
                    "createAt": 1516972967359
                },
                {
                    "id": 246,
                    "icon": "",
                    "parentID": 245,
                    "name": "标签列表",
                    "menuID": "",
                    "url": "field.labelList",
                    "type": "",
                    "level": "",
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1516632690833,
                    "createAt": 1516632690833
                }
            ]
        },
        {
            "id": 230,
            "icon": "",
            "parentID": "",
            "name": "复盘管理",
            "menuID": "",
            "url": "",
            "type": "",
            "level": 1,
            "createBy": 101,
            "updateBy": 101,
            "updateAt": 1506427251349,
            "createAt": 1506421356590,
            "nodes": [
                {
                    "id": 236,
                    "icon": "",
                    "parentID": 230,
                    "name": "项目列表",
                    "menuID": "",
                    "url": "field.projectList",
                    "type": "",
                    "level": 5,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1508316962983,
                    "createAt": 1506434258325
                },
                {
                    "id": 234,
                    "icon": "",
                    "parentID": 230,
                    "name": "小组列表",
                    "menuID": "",
                    "url": "field.groupList",
                    "type": "",
                    "level": 7,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1508316930041,
                    "createAt": 1506434160675
                },
                {
                    "id": 233,
                    "icon": "",
                    "parentID": 230,
                    "name": "阶段列表",
                    "menuID": "",
                    "url": "field.stageList",
                    "type": "",
                    "level": 8,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1508316859305,
                    "createAt": 1506434121036
                },
                {
                    "id": 232,
                    "icon": "",
                    "parentID": 230,
                    "name": "迭代列表",
                    "menuID": "",
                    "url": "field.iterationList",
                    "type": "",
                    "level": 9,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1508316843778,
                    "createAt": 1506434065122
                },
                {
                    "id": 231,
                    "icon": "",
                    "parentID": 230,
                    "name": "产品列表",
                    "menuID": "",
                    "url": "field.productList",
                    "type": "",
                    "level": 10,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1513697068976,
                    "createAt": 1506421540642
                }
            ]
        },
        {
            "id": 217,
            "icon": "",
            "parentID": 0,
            "name": "日报管理",
            "menuID": "",
            "url": "",
            "type": "",
            "level": 1,
            "createBy": 101,
            "updateBy": 101,
            "updateAt": 1504859633251,
            "createAt": 1503306131994,
            "nodes": [
                {
                    "id": 216,
                    "icon": "2",
                    "parentID": 217,
                    "name": "日报管理",
                    "menuID": "dailyList",
                    "url": "field.dailyList",
                    "type": "",
                    "level": 1,
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1505189796860,
                    "createAt": 1503304902824
                }
            ]
        },
        {
            "id": 181,
            "icon": "",
            "parentID": 0,
            "name": "卡券管理",
            "menuID": "",
            "url": "",
            "type": "",
            "level": "",
            "createBy": 101,
            "updateBy": 101,
            "updateAt": 1500280841123,
            "createAt": 1500108877485,
            "nodes": [
                {
                    "id": 214,
                    "icon": "",
                    "parentID": 181,
                    "name": "卡券类型",
                    "menuID": "",
                    "url": "field.cardType",
                    "type": "",
                    "level": "",
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1502523031907,
                    "createAt": 1502092828193
                },
                {
                    "id": 213,
                    "icon": "",
                    "parentID": 181,
                    "name": "全部卡券",
                    "menuID": "",
                    "url": "field.card",
                    "type": "",
                    "level": "",
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1503470284690,
                    "createAt": 1502092812099
                },
                {
                    "id": 212,
                    "icon": "",
                    "parentID": 181,
                    "name": "已过期",
                    "menuID": "",
                    "url": "field.cardOverdue",
                    "type": "",
                    "level": "",
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1503470235401,
                    "createAt": 1502092787996
                },
                {
                    "id": 211,
                    "icon": "",
                    "parentID": 181,
                    "name": "申请中",
                    "menuID": "",
                    "url": "field.cardUse",
                    "type": "",
                    "level": "",
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1503470340400,
                    "createAt": 1502092770703
                },
                {
                    "id": 210,
                    "icon": "",
                    "parentID": 181,
                    "name": "未发放",
                    "menuID": "",
                    "url": "field.cardNoissue",
                    "type": "",
                    "level": "",
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1502527018070,
                    "createAt": 1502092749884
                },
                {
                    "id": 209,
                    "icon": "",
                    "parentID": 181,
                    "name": "未使用",
                    "menuID": "",
                    "url": "field.cardUnused",
                    "type": "",
                    "level": "",
                    "createBy": 101,
                    "updateBy": 101,
                    "updateAt": 1503470436405,
                    "createAt": 1502092733614
                }]
        }];
})
app.controller('demoCtrl', function ($scope) {
    $scope.user = {
        userName: 'matt',
        password: ''
    };
    $scope.save = function () {
        alert("保存数据")
    }
});
app.directive('superman', function () {
    return {
        scope: {},
        restrict: 'AE',
        controller: function ($scope) {
            $scope.abilities = [];
            this.addStrength = function () {
                $scope.abilities.push("strength");
            };
            this.addSpeed = function () {
                $scope.abilities.push("Speed");
            };
            this.addLight = function () {
                $scope.abilities.push("Light");
            };
        },
        link: function (scope, element, attrs) {
            element.addClass('btn btn-primary');
            element.bind("mouseenter", function () {
                console.log(scope.abilities);
            })
        }
    }
});
app.directive("strength", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addStrength();
        }
    }
});
app.directive("speed", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addSpeed();
        }
    }
});
app.directive("light", function () {
    return {
        require: '^superman',
        link: function (scope, element, attrs, supermanCtrl) {
            supermanCtrl.addLight();
        }
    }
});

app.directive("hello", function () {
    return {
        scope: {},
        restrict: 'AE',
        template: '<div><input type="text" ng-model="userName"/>{{userName}}</div> ',
        replace: true
    }
});

app.directive("drink", function () {
    return {
        restrict: "AE",
        scope: {
            flavor: '='
        },
        template: '<input type="text" ng-model="flavor"/>'
    }
});

app.directive("greeting", function () {
    return {
        restrict: "AE",
        scope: {greet: '&'},
        template: '<input type="text" ng-model="userName" /><br/>' + '<button class="btn btn-default" ng-click="greet({name:userName})">greetings</button>'
    }
});