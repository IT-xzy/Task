//过滤器--把article约定数字转换为文字
angular.module('zcjApp').filter("type",function () {
  return function (type) {
    switch(type){
      case 0:
        return '首页banner';
      case 1:
        return '找职位banner';
      case 2:
        return '找精英banner';
      case 3:
        return '行业大图';
    }
  }
});
angular.module('zcjApp').filter('status',function () {
  return function (status) {
    switch(status){
      case 1:
        return '草稿';
      case 2:
        return '上线';
    }
  }
});
angular.module('zcjApp').filter('upline',function () {
  return function (status) {
    switch(status){
      case 1:
        return '上线';
      case 2:
        return '下线';
    }
  }
});




