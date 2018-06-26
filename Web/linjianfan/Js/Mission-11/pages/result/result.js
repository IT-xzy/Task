// pages/result/result.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // 页面需要的数据
    theResultValue1: 0,
    theResultValue2: 0,
    theResultValue3: 0,
    theItem: [],
    theMoney1: [],
    theMoney2: [],
    theMoney3: [],
    winWidth: 0,
    winHeight: 0,
    currentTab: 0 
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options, theItem) {
    var that = this;

    // 将传递过来的参数用JSON转化成原始的数组格式
    var thevalue = JSON.parse(options.key);

    // 直接var变量是没有用的
    // html页面要想获得这些数据，只能放在data里面
    // 先在data里面定义好变量名称，然后通过this.setData的方式来进行赋值
    this.setData ({
      theResultValue1: (thevalue[0]-1), 
      theResultValue2: (thevalue[1]-1), 
      theResultValue3: (thevalue[2]-1)
    })
    
    // 向后台请求数据
    wx.request({
      url: 'http://www.jnshu.com/a/occupation/list',
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data.data.occupations);
        var aaa = (JSON.parse(res.data.data.occupations[thevalue[0] - 1].salary));
        var bbb = (JSON.parse(res.data.data.occupations[thevalue[1] - 1].salary));
        var ccc = (JSON.parse(res.data.data.occupations[thevalue[2] - 1].salary));

        // 这里的赋值，需要通过setData来进行赋值，同时需要将this用一个变量来代替
        // 需要先在data上面定义好一个theItem，也就是这里的变量
        // request是异步执行，所以这里无法打印theItem
        that.setData({
          theItem: res.data.data.occupations,
          theMoney1: aaa,
          theMoney2: bbb,
          theMoney3: ccc,
        });
      }
    })

    // navbar
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          winWidth: res.windowWidth,
          winHeight: res.windowHeight
        });
      }
    }); 
  },

  bindChange: function (e) {
    var that = this;
    that.setData({ currentTab: e.detail.current });
  },
  swichNav: function (e) {
    var that = this;
    if (this.data.currentTab === e.target.dataset.current) {
      return false;
    } else {
      that.setData({
        currentTab: e.target.dataset.current
      })
    }
  }, 

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})