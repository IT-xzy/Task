
Page({

  /**
   * 页面的初始数据
   */
  data: {
    currentTab: 0,
    movies: [],
    title: ['职业门槛', '难易程度', '成长周期', '求贤企业', '入学基础', '薪资待遇']
  },
  navbarTap: function (e) {
    this.setData({
      currentTab: e.currentTarget.dataset.idx
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 将传递过来的参数用JSON转化成原始的数组格式
    var thevalue = JSON.parse(options.key);
    console.log(thevalue);
    var that = this;
    var newJob = [];
    var newSalary = [];
    var name = [];
    // 直接var变量是没有用的
    // html页面要想获得这些数据，要放在data里面
    // 先在data里面定义好变量名称，然后通过this.setData的方式来进行赋值
    // this.setData({
    //   theResultValue1: thevalue[0],
    //   theResultValue2: thevalue[1],
    //   theResultValue3: thevalue[2],
    // })
  
    wx.request({
      url: 'http://www.jnshu.com/a/occupation/list',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data.data.occupations);
        if (res.data.code === 0) {
          for (var i = 0; i < 3; i++) {
            newJob.push(res.data.data.occupations[thevalue[i] - 1]);
            newSalary.push(JSON.parse(newJob[i].salary));
            name.push(newJob[i].name);
          }
          console.log(newJob)
          console.log(newSalary[0])
          that.setData({
            newJob,
            newSalary,
            name
          })
        }
      }
    })

  }
})