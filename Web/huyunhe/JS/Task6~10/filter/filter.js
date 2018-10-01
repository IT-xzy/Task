angular.module("app").filter("typeFilter", function () {
  return function (input) {
    switch (input) {
      case '0':
        return '首页banner';
      case 1:
        return '找职位banner';
      case 2:
        return '找精英banner';
      case 3:
        return '行业大图';
      default:
        return input;
    }
  }
}).filter("industryFilter", function () {
  return function (input) {
    switch (input) {
      case 0:
        return '移动互联网';
      case 1:
        return '电子商务';
      case 2:
        return '企业服务';
      case 3:
        return 'O2O';
      case 4:
        return '教育';
      case 5:
        return '金融';
      case 6:
        return '游戏';
      default:
        return input;
    }
  }
}).filter("validFilter", function () {
  return function (input) {
    switch (input) {
      case 1:
        return '未认证';
      case 2:
        return '已认证';
      default:
        return input;
    }
  }
}).filter("freezeFilter", function () {
  return function (input) {
    switch (input) {
      case 1:
        return '正常';
      case 2:
        return '冻结';
      default:
        return input;

    }
  }
}).filter("scaleFilter", function () {
  return function (input) {
    switch (input) {
      case 0:
        return '无需融资';
      case 1:
        return '天使轮';
      case 2:
        return 'A轮';
      case 3:
        return 'B轮';
      case 4:
        return 'C轮';
      case 5:
        return 'D轮及以上';
      case 6:
        return '上市公司';
      default:
        return input;
    }
  }
}).filter("experienceFilter", function () {
  return function (input) {
    switch (input) {
      case 0:
        return '应届';
      case 1:
        return '1~2年';
      case 2:
        return '3~5年';
      case 3:
        return '6~9年';
      case 4:
        return '10年及以上';
      default:
        break;
    }
  }
}).filter("eduFilter", function () {
  return function (input) {
    switch (input) {
      case 0:
        return '大专';
      case 1:
        return '本科';
      case 2:
        return '硕士';
      case 3:
        return '博士及以上';
      default:
        break;
    }
  }
}).filter("categoryFilter", function () {
  return function (input) {
    switch (input) {
      case 0:
        return '产品';
      case 1:
        return '运营';
      case 2:
        return '技术';
      case 3:
        return '设计';
      case 4:
        return '测试';
      default:
        break;
    }
  }
}).filter("subFilter", function () {
  return function (input) {
    switch (input) {
      case 0:
        return '产品经理';
      case 1:
        return 'JAVA';
      case 2:
        return 'iOS';
      case 3:
        return 'Android';
      case 4:
        return 'Web前端';
      case 5:
        return '运维';
      case 6:
        return 'UI设计';
      case 7:
        return "功能测试";
      default:
        break;
    }
  }
}).filter("salaryFilter", function () {
  return function (input) {
    switch (input) {
      case 0:
        return '8k以下';
      case 1:
        return '8k~15k';
      case 2:
        return '16~25k';
      case 3:
        return '25k以上';
      default:
        break;
    }
  }
}).filter("statusFilter", function () {
  return function (input) {
    switch (input) {
      case 2:
        return '上架';
      case 1:
        return '下架';
      default:
        break;
    }
  }
}).filter("typeFilter", function () {
  return function (input) {
    switch (input) {
      case 0:
        return '首页Banner';
      case 1:
        return '找职位Banner';
      case 2:
        return '找精英Banner';
      case 3:
        return '行业大图';
      default:
        break;
    }
  }
}).filter("inverseStatusFilter",function () {
  return function (input) {
    switch (input) {
      case 1:
        return '上架';
      case 2:
        return '下架';
      default:
        break;
    }
  }
}).filter("numberToDate", function () {
  return function (input) {
    if (angular.isNumber(input)) {
      return new Date(input);
    }
  }
}).filter("pageCount", function () {
  return function (data, size) {
    if (angular.isArray(data)) {
      let result = [];
      for (let i = 0; i < Math.ceil(data.length / size); i++) {
        result.push(i);
      }
      return result;
    } else {
      return data;
    }
  }
}).filter("range", function ($filter) {
  return function (data, page, size) {
    if (angular.isArray(data)) {
      let start_index = (page - 1) * size;
      if (data.length < start_index) {
        return [];
      } else {
        return $filter("limitTo")(data.slice(start_index), size);
      }
    }
    else{
      return data;
    }
  }
})
