var param = {};
Page({

  /**
   * 页面的初始数据
   */
  data: {

    //职业推荐分数表
    objectEdu: [
      /*name: '学　　历：'*/
      {
        1: -1000, 2: 30, 3: 50, 4: 40, 5: 50, 6: 30, 7: 50, 8: 30, 9: -30, 10: -1000, 11: -1000, 12: 50,
        name: '博士'
      },
      {
        1: -1000, 2: 30, 3: 50, 4: 40, 5: 50, 6: 30, 7: 50, 8: 30, 9: -30, 10: -1000, 11: -1000, 12: 50,
        name: '硕士'
      },
      {
        1: -1000, 2: 30, 3: 40, 4: 40, 5: 40, 6: 40, 7: 40, 8: 40, 9: 30, 10: -1000, 11: -1000, 12: 40,
        name: '本科'
      },
      {
        1: -1000, 2: 30, 3: 30, 4: 30, 5: 30, 6: 30, 7: 30, 8: 30, 9: 50, 10: -1000, 11: -1000, 12: 30,
        name: '大专'
      },
      {
        1: -1000, 2: 20, 3: 0, 4: 0, 5: -50, 6: 10, 7: 30, 8: 50, 9: 50, 10: -1000, 11: -1000, 12: 30,
        name: '高中'
      },
      {
        1: -1000, 2: 10, 3: -50, 4: -50, 5: -100, 6: -50, 7: 30, 8: 50, 9: 50, 10: -1000, 11: -1000, 12: 30,
        name: '初中以下'
      }
    ],
    
    objectSex: [
      /*name: '性　　别：'*/
      {
        1: -1000, 2: 50, 3: 50, 4: 50, 5: 50, 6: 50, 7: 50, 8: 30, 9: 30, 10: -1000, 11: -1000, 12: 30,
        name: '男'
      },
      {
        1: -1000, 2: 50, 3: 30, 4: 30, 5: 10, 6: -30, 7: 50, 8: 50, 9: 50, 10: -1000, 11: -1000, 12: 50,
        name: '女'
      }
    ],

    objectAge: [
      /*name: '年　　龄：'*/
      {
        1: -1000, 2: 5, 3: 0, 4: 0, 5: -50, 6: 15, 7: 20, 8: 30, 9: 50, 10: -1000, 11: -1000, 12: 20,
        name: '18岁以下'
      },
      {
        1: -1000, 2: 20, 3: 20, 4: 20, 5: 20, 6: 20, 7: 20, 8: 20, 9: 20, 10: -1000, 11: -1000, 12: 20,
        name: '18~24岁'
      },
      {
        1: -1000, 2: 20, 3: 20, 4: 20, 5: 20, 6: 20, 7: 20, 8: 20, 9: 20, 10: -1000, 11: -1000, 12: 20,
        name: '25~30岁'
      },
      {
        1: -1000, 2: -30, 3: -30, 4: -30, 5: -30, 6: -30, 7: 50, 8: 0, 9: 0, 10: -1000, 11: -1000, 12: 50,
        name: '30岁以上'
      }
    ],

    objectBase: [
      /*name: '基础：'*/
      {
        1: -1000, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 0, 8: 0, 9: 0, 10: -1000, 11: -1000, 12: 0,
        name: '无基础'
      },
      {
        1: -1000, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 0, 8: 50, 9: 0, 10: -1000, 11: -1000, 12: 30,
        name: '绘画基础' 
      },
      {
        1: -1000, 2: 10, 3: 10, 4: 10, 5: 10, 6: 50, 7: 0, 8: 0, 9: 10, 10: -1000, 11: -1000, 12: 0,
        name: '网络相关'
      },
      {
        1: -1000, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 50, 8: 30, 9: 10, 10: -1000, 11: -1000, 12: 30,
        name: '原型设计'
      },
      {
        1: -1000, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 30, 8: 0, 9: 0, 10: -1000, 11: -1000, 12: 50,
        name: '文字功底'
      }
    ],

    objectPro: [
      /*name: '专　　业：'*/
      {
        1: -1000, 2: 30, 3: 0, 4: 0, 5: 0, 6: 0, 7: 30, 8: 50, 9: 50, 10: -1000, 11: -1000, 12: 30,
        name: '无专业'
      },
      {
        1: -1000, 2: 35, 3: 35, 4: 35, 5: 50, 6: 40, 7: 40, 8: 40, 9: 30, 10: -1000, 11: -1000, 12: 40,
        name: '计算机相关'
      },
      {
        1: -1000, 2: 30, 3: 35, 4: 35, 5: 40, 6: 30, 7: 30, 8: 30, 9: 30, 10: -1000, 11: -1000, 12: 30,
        name: '理工科'
      },
      {
        1: -1000, 2: 10, 3: 10, 4: 10, 5: 10, 6: 10, 7: 50, 8: 50, 9: 30, 10: -1000, 11: -1000, 12: 50,
        name: '文科'
      }
    ],
    
    objectLogic: [
      /*name: '逻　　辑：'*/
      {
        1: -1000, 2: 40, 3: 10, 4: 10, 5: 10, 6: 10, 7: 20, 8: 50, 9: 50, 10: -1000, 11: -1000, 12: 20,
        name: '渣渣'
      },
      {
        1: -1000, 2: 30, 3: 30, 4: 30, 5: 30, 6: 30, 7: 30, 8: 30, 9: 30, 10: -1000, 11: -1000, 12: 30,
        name: '普通'
      },
      {
        1: -1000, 2: 40, 3: 40, 4: 40, 5: 50, 6: 40, 7: 30, 8: 0, 9: 0, 10: -1000, 11: -1000, 12: 30,
        name: '卓越'
      }
    ],

    eduIndex: 2,
    sexIndex: 1,
    ageIndex: 1,
    baseIndex: 0,
    proIndex: 2,
    logicIndex: 1
  },
  //普通选择器
  educationChange: function(e) {
    this.setData({
      eduIndex: e.detail.value
    })
  },
  sexChange: function(e) {
    this.setData({
      sexIndex: e.detail.value
    })
  },
  ageChange: function(e) {
    this.setData({
      ageIndex: e.detail.value
    })
  },
  baseChange: function(e){
    this.setData({
      baseIndex: e.detail.value
    })
  },
  proChange: function(e) {
    this.setData({
      proIndex: e.detail.value
    })
  },
  logicChange: function(e){
    this.setData({
      logicIndex: e.detail.value
    })
  },
  //跳转职业页面
  checkTap: function() {
    let [objectEdu, objectSex, objectAge] = [this.data.objectEdu, this.data.objectSex, this.data.objectAge];
    let [objectBase, objectPro, objectLogic] = [this.data.objectBase, this.data.objectPro, this.data.objectLogic];
    let [eduIndex, sexIndex, ageIndex] = [this.data.eduIndex, this.data.sexIndex, this.data.ageIndex];
    let [baseIndex, proIndex, logicIndex] = [this.data.baseIndex, this.data.proIndex, this.data.logicIndex]
    let score = { 1: -1000, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 0, 8: 0, 9: 0, 10: -1000, 11: -1000, 12: 1 }
    for(var i=1; i<13; i++) {
      score[i] = objectEdu[eduIndex][i]+objectSex[sexIndex][i]+objectAge[ageIndex][i]+objectBase[baseIndex][i]+objectPro[proIndex][i]+objectLogic[logicIndex][i]
    }
    let scores = Object.keys(score).sort(function (a, b) { return score[b] - score[a] });
    //console.log(score);
    //console.log(scores);
    let [a, b, c] = [scores[0], scores[1], scores[2]];
    //console.log([a, b, c])
    wx.setStorageSync('show', [a, b, c])
    wx.navigateTo({
      url: '../profession/profession',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
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