var postdata = require('../../data/data-base.js')
Page({
  data: {
    selected: true,
    selected1: false,
    selected2: false
  },
  onLoad: function (option) {
    var a = JSON.parse(option.list);
    console.log(a);
    this.setData({
      postdata: postdata.postList
    })
    this.setData({
      num:a
    })
  },
  selected: function (e) {
    this.setData({
      selected1: false,
      selected2: false,
      selected: true
    })
  },
  selected1: function (e) {
    this.setData({
      selected1: true,
      selected2: false,
      selected: false
    })
  },
  selected2: function (e) {
    this.setData({
      selected1: false,
      selected2: true,
      selected: false
    })
  },



});
