angular.module('zcjApp')
  //下拉框
  .constant('type',{            //类型下拉框
    0:'首页Banner',
    1:'找职位Banner',
    2:'找精英Banner',
    3:'行业大图'
  })
  .constant('status',{         //上下线
    2:'上线',
    1:'草稿'
  })
  .constant('bigPicture',{     //行业大图子类型
    1:'移动互联网',
    2:'电子商务',
    3:'企业服务',
    4:'O2O',
    5:'教育',
    6:'金融',
    7:'游戏'
  });