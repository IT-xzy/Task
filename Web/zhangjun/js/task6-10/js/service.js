angular.module("myApp")
   // session 刷新还存在 退出浏览器不存在
  .factory("session", function($window) {
      return {
        //存储单个属性
        set: function(key, value) {
          sessionStorage.setItem(key, value);
        },
        //读取单个属性
        get: function(key) {
          return sessionStorage.getItem(key);
        },
        //删除单个属性
        remove: function (key) {
          return sessionStorage.removeItem(key);
        },
        //存储对象，以JSON格式存储
        setObject: function(key, value) {
          sessionStorage.setItem(key, JSON.stringify(value)); //将对象以字符串保存
        },
        //读取对象
        getObject: function(key) {
          return JSON.parse(sessionStorage.getItem(key)); //获取字符串并解析成对象
        },
        //清楚所有
        clear: function () {
          sessionStorage.clear();
        }
      };
  });