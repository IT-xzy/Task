app
    .filter('article', function () {
        return function (element, name) {
            var res = '';
            switch (name) {
                case "type":
                    res = element === 0 ? "首页banner" : element === 1 ? "找职位banner" : element === 2 ? "找精英banner" : element === 3 ? "行业大图" : "";
                    break;
                case "status":
                    res = element === 1 ? "草稿" : element === 2 ? "上线" : "";
                    break;
            }
            return res;
        }
    })
    .filter('profession', function () {
        return function (element, name) {
            var res = '';
            switch (name) {
                // case "category":
                //     res = element === 0 ? "产品" : element === 1 ? "运营" : element === 2 ? "技术" : element === 3 ? "设计" : element === 4 ? "测试" : "";
                //     break;
                case "subCategory":
                    res = element === 0 ? "产品经理" : element === 1 ? "JAVA" : element === 2 ? "IOS" : element === 3 ? "Android" : element === 4 ? "Web前端" :
                        element === 5 ? "运维" : element === 6 ? "UI设计" : element === 7 ? "QA" : "";
                    break;
                case "compensation":
                    res = element === 0 ? "0~8K" : element === 1 ? "8~15K" : element === 2 ? "16~25K" : element === 3 ? "26K以上" : "";
                    break;
                case "education":
                    res = element === 0 ? "大专" : element === 1 ? "本科" : element === 2 ? "硕士" : element === 3 ? "博士" : "";
                    break;
                case "experience":
                    res = element === 0 ? "应届" : element === 1 ? "1~2年" : element === 2 ? "3~5年" : element === 3 ? "6~9年" : element === 4 ? "10年以上" : "";
                    break;
                case "status":
                    res = element === 0 ? "上架" : element === 1 ? "下架" : "";
                    break;
            }
            return res;
        }
    })