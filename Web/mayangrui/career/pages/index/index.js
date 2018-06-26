const app = getApp()
Page({
     data:{
       defaultsize:"default"
     },
     default:function(){
       wx.navigateTo({
         url: '../choice/x'
       })
     }
})