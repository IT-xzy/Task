Page({
  /**
   * 页面的初始数据
   */
  data: {
    //初始加载页面
    click: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // console.log(this)
    // console.log(options)
    var list = JSON.parse(options.list)
    // 获取数据   
    // console.log(list)
    wx.request({
      url: 'https://www.jnshu.com/a/occupation/list',
      success: res => {
        // console.log(res)
        var resData = res.data.data.occupations;
        console.log(resData);
        console.log(resData[list[0].index]);
        console.log(resData[list[1].index]);
        console.log(resData[list[2].index]);
        var list1 = [resData[list[0].index], resData[list[1].index], resData[list[2].index]]
        var list2 = [{ name: list1[0].name, btn: 0 },
        { name: list1[1].name, btn: 1 },
        { name: list1[2].name, btn: 2 }
        ];
        var list3 = [JSON.parse(list1[0].salary), JSON.parse(list1[1].salary), JSON.parse(list1[2].salary)]
        console.log(list3)
        console.log(list1)
        this.setData({
          viewList1: list1,
          viewList2: list2,
          viewList3: list3
        })

      }, fail: function (err) {
        console.log(err)
      }
    })
  },
  //
  bindChange: function (e) {
    this.setData({
      click: e.target.dataset.btn
    })
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