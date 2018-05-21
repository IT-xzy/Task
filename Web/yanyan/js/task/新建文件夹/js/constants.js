angular.module("myApp")
    //列表

    .constant("Status",  {
        1: "草稿",
        2: "上线"
    })

    .constant("Online", {
        1: "上线",
        2: "下线"
    })

    .constant("types",{
        0:"首页banner",
        1:"找职位banner",
        2:"找精英banner",
        3:"行业大图"
    })


    // .constant("addIndustry", [
    //     {name: "移动互联网",    type: 0},
    //     {name: "电子商务",      type: 1},
    //     {name: "企业服务",      type: 2},
    //     {name: "O2O",          type: 3},
    //     {name: "教育",          type: 4},
    //     {name: "金融",          type: 5},
    //     {name: "游戏",          type: 6}
    // ])
    .constant("addIndustry", {
        0:"移动互联网",
        1:"电子商务",
        2:"企业服务",
        3:"O2O",
        4:"教育",
        5:"金融",
        6:"游戏"
    });