app.filter('typefilter', function () {
        return function (text) {
            switch (text) {
                case 0:
                    return '首页banner';
                    break;
                case 1:
                    return '找职位banner';
                    break;
                case 2:
                    return '找精英banner';
                    break;
                case 3:
                    return '行业大图';
                    break;
            }
        }
    },
    app.filter('statusfilter', function () {
        return function (text) {
            switch (text) {
                case 1:
                    return '草稿';
                    break;
                case 2:
                    return '上线';
                    break;
            }
        }
    })


);