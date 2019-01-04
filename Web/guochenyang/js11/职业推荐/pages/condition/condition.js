Page({

  /**
   * 页面的初始数据
   */
  data: {
    education: ["初中及以下", "高中", "大专", "本科", "硕士", "博士"],
    sex: ["男", "女"],
    age: ["18岁以下", "18-24岁", "25-30岁", "30岁以上"],
    base: ["零基础", "绘画基础", "网络相关", "原型设计"],
    major: ["无专业", "计算机相关", "理工科", "文科"],
    logic: ["渣渣", "普通", "卓越"],
    total: {
      education: 0,
      sex: 0,
      age: 0,
      base: 0,
      major: 0,
      logic: 0
    },
    rule: [
      { //css
        xl: [1, 2, 3, 5, 5, 3],
        xb: [5, 5],
        nl: [5, 5, 5, 4],
        jc: [4, 5, 5, 5],
        zy: [5, 4, 4, 5],
        lj: [5, 5, 5]
      },
      { //js
        xl: [1, 2, 3, 5, 5, 5],
        xb: [5, 5],
        nl: [5, 5, 5, 4],
        jc: [3, 5, 5, 5],
        zy: [5, 4, 3, 5],
        lj: [5, 5, 5]
      },
      {  //Android
        xl: [0, 2, 3, 5, 5, 5],
        xb: [5, 5],
        nl: [4, 4, 5, 4],
        jc: [6, 6, 6, 6],
        zy: [5, 4, 6, 6],
        lj: [6, 6, 5]
      },
      {  //ios
        xl: [0, 2, 3, 5, 5, 5],
        xb: [5, 5],
        nl: [4, 4, 5, 4],
        jc: [4, 5, 3, 6],
        zy: [5, 4, 4, 5],
        lj: [3, 6, 5]
      },
      {  //JAVA
        xl: [-3, 0, 1, 3, 7, 9],
        xb: [7, 3],
        nl: [4, 4, 3, 6],
        jc: [3, 6, 7, 3],
        zy: [3, 6, 3, 6],
        lj: [7, 3, 3]
      },
      {  //op
        xl: [0, 3, 3, 5, 5, 3],
        xb: [5, -5],
        nl: [5, 5, 4, 2],
        jc: [4, 5, 6, 7],
        zy: [4, 2, 4, 5],
        lj: [6, 7, 4]
      },
      {  //pm
        xl: [2, 2, 3, 5, 5, 7],
        xb: [5, 5],
        nl: [3, 6, 4, 4],
        jc: [6, 4, 2, 9],
        zy: [4, 4, 6, 4],
        lj: [2, 9, 4]
      },
      {  //ui
        xl: [2, 2, 3, 5, 7, 5],
        xb: [4, 6],
        nl: [4, 7, 4, 3],
        jc: [2, 4, 5, 7],
        zy: [4, 3, 2, 4],
        lj: [5, 7, 4]
      },
    ]
  },
  
  // Education: function (e) {
  //   console.log('picker选择了: ' + e.detail.value);
  //   this.setData({
  //     index: e.detail.value
  //   })
  // },
  
  // Sex: function (e) {
  //   console.log('picker选择了: ' + e.detail.value);
  //   this.setData({
  //     sex1: e.detail.value
  //   })
  // },

  // Age: function (e) {
  //   console.log('picker选择了: ' + e.detail.value);
  //   this.setData({
  //     age1: e.detail.value
  //   })
  // },

  // Base: function (e) {
  //   console.log('picker选择了: ' + e.detail.value);
  //   this.setData({
  //     base1: e.detail.value
  //   })
  // },
  
  // Major: function (e) {
  //   console.log('picker选择了: ' + e.detail.value);
  //   this.setData({
  //     major1: e.detail.value
  //   })
  // },

  // Logic: function (e) {
  //   console.log('picker选择了: ' + e.detail.value);
  //   this.setData({
  //     logic1: e.detail.value
  //   })
  // },
  
  bindChange: function (e) {
    console.log(e)
    console.log(this)
    let x = e.target.id;
    switch (x) {
      case "education":
        this.setData({
          "total.education": e.detail.value
        });
        break;
      case "sex":
        this.setData({
          "total.sex": e.detail.value
        });
        break;
      case "age":
        this.setData({
          "total.age": e.detail.value
        });
        break;
      case "base":
        this.setData({
          "total.base": e.detail.value
        });
        break;
      case "major":
        this.setData({
          "total.major": e.detail.value
        });
        break;
      case "logic":
        this.setData({
          "total.logic": e.detail.value
        });
        break;
    }
    console.log(this.data)
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    console.log(this)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    console.log("页面渲染完毕")
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log("页面显示")
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    console.log("页面隐藏")
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    console.log("页面关闭")
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    console.log("下拉")
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    console.log("上拉")
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    
  },


   primary: function () {
  var that = this.data;
  console.log(that);
  console.log(that.rule[1].xl[that.total.education]);
    //  把得到的职业的rule分值计算出来，排序，选出前三名的分数
     var score = [];
     for (var i = 0; i < that.rule.length; i++) {
       score[i] = {
         grade: that.rule[i].xl[that.total.education] +
           that.rule[i].xb[that.total.sex] +
           that.rule[i].nl[that.total.age] +
           that.rule[i].jc[that.total.base] +
           that.rule[i].zy[that.total.major] +
           that.rule[i].lj[that.total.logic],
         index: i
         //代表科目的身份
       }
     }
     console.log(score)
     //得到socre总分
     //排序sort()方法,冒泡排序
     function compare(prop) {
       return function (a, b) {
         var value1 = a[prop];
         var value2 = b[prop];
         return value2 - value1
       }
     }
     score.sort(compare("grade"))
     console.log(score);
     var newScore = score.slice(0, 3);
     
     wx.navigateTo({
       url: '../jabs/jabs?list=' + JSON.stringify(newScore),
     })
     console.log(newScore);
}

})