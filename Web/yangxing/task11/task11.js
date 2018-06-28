
Page({

data: {
  edu: 0,
  sexy: 0,
  year:0,
  basic:0,
  specia:0,
  log:0,

  Education: ["初中及其以下", "高中","大专","本科","硕士","博士"],
  objEducation:[
    {
      id: 0,
      name: "初中及其以下",
      num:[
       {
        css:-1000,
        js:10,
        android:-50,
        ios:-40,
        java:-100 ,
        op:- 50,
        pm:30,
        ui:50,
        qa:50,
        求职辅导:-1000,
        python:-1000,
        运营:30      
        }
      ]
    },
    {
      id: 1,
      name: "高中",
      num: [
        {
          css: -1000,
          js: 20,
          android: 0,
          ios: 0,
          java: 0,
          op: 10,
          pm: 40,
          ui: 50,
          qa: 50,
          求职辅导: -1000,
          python: -1000,
          运营: 30
        }
      ]
    },
    {
      id: 2,
      name: "大专",
      num: [
        {
          css: -1000,
          js: 30,
          android: 30,
          ios:30,
          java: 30,
          op: 30,
          pm: 30,
          ui: 30,
          qa: 30,
          求职辅导: -1000,
          python: -1000,
          运营: 30
        }
      ]
    },
    {
      id: 3,
      name: "本科",
      num: [
        {
          css: -1000,
          js: 30,
          android: 40,
          ios: 40,
          java: 40,
          op: 40,
          pm: 40,
          ui: 40,
          qa: 30,
          求职辅导: -1000,
          python: -1000,
          运营: 30
        }
      ]
    },
    {
      id: 4,
      name: "硕士",
      num: [
        {
          css: -1000,
          js: 30,
          android: 40,
          ios: 40,
          java: 50,
          op: 30,
          pm: 50,
          ui: 40,
          qa: 30,
          求职辅导: -1000,
          python: -1000,
          运营: 30
        }
      ]
    },
    {
      id: 6,
      name: "博士",
      num: [
        {
          css: -1000,
          js: 30,
          android: 40,
          ios: 40,
          java: 50,
          op: 30,
          pm: 50,
          ui: 40,
          qa: 30,
          求职辅导: -1000,
          python: -1000,
          运营: 30
        }
      ]
    },
  ],
 

  sex:["男", "女"],
  objsex:[
    {
      id: 0,
      name: "男",
      num: [
        {
          css: -1000,
          js: 50,
          android: 50,
          ios: 50,
          java: 50,
          op: 50,
          pm: 50,
          ui: 30,
          qa: 30,
          求职辅导: -1000,
          python: -1000,
          运营: 30
        }
      ]
    },
    {
      id: 1,
      name: "女",
      num: [
        {
          css: -1000,
          js: 50,
          android: 30,
          ios: 30,
          java: 10,
          op: -30,
          pm: 50,
          ui: 50,
          qa: 50,
          求职辅导: -1000,
          python: -1000,
          运营: 50
        }
      ]
    }
  ],



   age:["18岁以下","18-24岁","25-30岁","30岁以上"],
   objage:[
     {
      id:0,
      name:"18岁以下",
      num: [
        {
          css: -1000,
          js: 5,
          android: 0,
          ios: 0,
          java: -50,
          op: 15,
          pm: 20,
          ui: 30,
          qa: 50,
          求职辅导: -1000,
          python: -1000,
          运营: 20
        }
      ]
   },
     {
       id: 1,
       name: "18-24岁",
       num: [
         {
           css: -1000,
           js: 20,
           android: 20,
           ios:20,
           java: 20,
           op: 20,
           pm: 20,
           ui: 20,
           qa: 20,
           求职辅导: -1000,
           python: -1000,
           运营: 20
         }
       ]
     },
     {
       id: 2,
       name: "25-30岁",
       num: [
         {
           css: -1000,
           js: 20,
           android: 20,
           ios: 20,
           java: 20,
           op: 20,
           pm: 20,
           ui: 20,
           qa: 20,
           求职辅导: -1000,
           python: -1000,
           运营: 20
         }
       ]
     },
     {
       id: 3,
       name: "30岁以上",
       num: [
         {
           css: -1000,
           js: -30,
           android: -30,
           ios: -30,
           java: -30,
           op: -30,
           pm: 50,
           ui: 0,
           qa: 0,
           求职辅导: -1000,
           python: -1000,
           运营: 50
         }
       ]
     }
   ],

   base: ["零基础", "绘画基础","网络相关","原型设计"],
   objbase:[
     {
       id:0,
       name:"零基础",
       num: [
         {
           css: -1000,
           js: 0,
           android: 0,
           ios: 0,
           java: 0,
           op: 0,
           pm: 10,
           ui:20,
           qa: 50,
           求职辅导: -1000,
           python: -1000,
           运营: 10
         }
       ]
     },
     {
       id: 1,
       name: "绘画基础",
       num: [
         {
           css: -1000,
           js: 10,
           android: 10,
           ios: 10,
           java: 10,
           op: 50,
           pm: 0,
           ui: 80,
           qa: 10,
           求职辅导: -1000,
           python: -1000,
           运营: 10
         }
       ]
     },
     {
       id: 2,
       name: "网络相关",
       num: [
         {
           css: -1000,
           js: 10,
           android: 10,
           ios: 10,
           java: 10,
           op: 50,
           pm: 0,
           ui: 0,
           qa: 10,
           求职辅导: -1000,
           python: -1000,
           运营: 0
         }
       ]
     },
     {
       id: 3,
       name: "原型设计",
       num: [
         {
           css: -1000,
           js: 0,
           android: 0,
           ios: 0,
           java: 0,
           op: 0,
           pm: 50,
           ui: 30,
           qa: 10,
           求职辅导: -1000,
           python: -1000,
           运营: 30
         }
       ]
       
     },  
 ],


   specialty:["无专业","计算机相关","理工科","文科"],
   objspecialty:[
     {
       id:0,
       name:"无专业",
       num: [
         {
           css: -1000,
           js: 30,
           android: 0,
           ios: 0,
           java: 0,
           op: 0,
           pm: 30,
           ui: 50,
           qa: 50,
           求职辅导: -1000,
           python: -1000,
           运营: 30
         }
       ]
     },
     {
       id: 1,
       name: "计算机相关",
       num: [
         {
           css: -1000,
           js: 35,
           android: 35,
           ios: 35,
           java: 50,
           op: 40,
           pm: 40,
           ui: 40,
           qa: 30,
           求职辅导: -1000,
           python: -1000,
           运营: 40
         }
       ]
     },
     {
       id: 2,
       name: "理工科",
       num: [
         {
           css: -1000,
           js: 30,
           android: 35,
           ios: 35,
           java: 40,
           op: 30,
           pm: 30,
           ui: 30,
           qa: 30,
           求职辅导: -1000,
           python: -1000,
           运营: 30
         }
       ]
     },
     {
       id: 3,
       name: "文科",
       num: [
         {
           css: -1000,
           js: 10,
           android: 10,
           ios: 10,
           java: 10,
           op: 10,
           pm: 50,
           ui: 50,
           qa: 30,
           求职辅导: -1000,
           python: -1000,
           运营: 50
         }
       ]
     }
   ],



   logic:["渣渣","普通","卓越"],
   objlogic:[
     {
       id:0,
       name:"渣渣",
       num: [
         {
           css: -1000,
           js: 40,
           android: 10,
           ios: 10,
           java: 10,
           op: 10,
           pm: 20,
           ui: 50,
           qa: 50,
           求职辅导: -1000,
           python: -1000,
           运营: 20
         }
       ]
     },
     {
       id: 1,
       name: "普通",
       num: [
         {
           css: -1000,
           js: 30,
           android: 30,
           ios: 30,
           java: 30,
           op: 30,
           pm: 30,
           ui: 30,
           qa: 30,
           求职辅导: -1000,
           python: -1000,
           运营: 30
         }
       ]
     },
     {
       id: 2,
       name: "卓越",
       num: [
         {
           css: -1000,
           js: 40,
           android: 40,
           ios: 40,
           java: 50,
           op: 40,
           pm: 30,
           ui: 0,
           qa: 0,
           求职辅导: -1000,
           python: -1000,
           运营: 30
         },
       ],
     },
   ],
},



  bindPickerChangeedu: function (e) {
  console.log(e.detail)
  this.setData({
    edu: e.detail.value
  })
  console.log(this.data.objEducation[e.detail.value])
  var Education = this.data.objEducation[e.detail.value].num
  console.log(Education)

},


  bindPickerChangesexy: function (e) {
  console.log(e.detail.value)
  this.setData({
    sexy: e.detail.value
  })

  console.log(this.data.objsex[e.detail.value])
  var sex = this.data.objsex[e.detail.value].num
  console.log(sex)


},



  bindPickerChangeyear: function (e) {
  console.log( e.detail.value)
  this.setData({
    year: e.detail.value
  })
  console.log(this.data.objage[e.detail.value])
  var age = this.data.objage[e.detail.value].num
  console.log(age)

},


  bindPickerChangebasic: function (e) {
  console.log( e.detail.value)
  this.setData({
    basic: e.detail.value
  })
  console.log(this.data.objbase[e.detail.value])
  var base = this.data.objbase[e.detail.value].num
  console.log(base)
},


  bindPickerChangespecia: function (e) {
  console.log(e.detail.value)
  this.setData({
    specia: e.detail.value
  })
  console.log(this.data.objspecialty[e.detail.value])
  var specialty = this.data.objspecialty[e.detail.value].num
  console.log(specialty)

},



  bindPickerChangelog: function (e) {
  console.log(e.detail.value)
  this.setData({
    log: e.detail.value
  })
  console.log(this.data.objlogic[e.detail.value])
  var logic = this.data.objlogic[e.detail.value].num
  console.log(logic)

},





  // android css ios java js op pm python qa ui 求职辅导 运营  按这个顺序排列的
   
  tapName: function (e) {
    console.log(this)

    //学历
    var edu = this.data.edu
    console.log(this.data.objEducation[edu])
    var education = this.data.objEducation[edu].num
    console.log(education)

    //性别
    var sexy = this.data.sexy
    console.log(this.data.objsex[sexy])
    var sex = this.data.objsex[sexy].num
    console.log(sex)

    //年龄
    var year=this.data.year
    console.log(this.data.objage[year])
    var age = this.data.objage[year].num
    console.log(age)


    //基础
    var basic = this.data.basic
    console.log(this.data.objbase[basic])
    var base = this.data.objbase[basic].num
    console.log(base)

    //专业
    var specia = this.data.specia
    console.log(this.data.objspecialty[specia])
    var specialty = this.data.objspecialty[specia].num
    console.log(specialty)

    //逻辑
    var log = this.data.log
    console.log(this.data.objlogic[log])
    var logic = this.data.objlogic[log].num
    console.log(logic)





 
  

var map = new Map;
var result_list = new Array;

    for (var i = 0; i < age.length; i++) {
      for (var key in age[i]) {
        var value = education[i][key] + age[i][key] + sex[i][key] + base[i][key] +                 specialty[i][key] + logic[i][key]
          map.set(key,value)
        var obj = {
          "key": key,
          "value": value
        }
        result_list.push(obj);
        
      }
    }
    console.log(map) 
    console.log(result_list)
   
   
     
   
    function sortNumber(a, b) {
      return b["value"] - a["value"]
    }

    var final = result_list.sort(sortNumber);
    console.log(final)


   var  before=[]
    before.push(final[0].key, final[1].key, final[2].key);
     console.log(before)

   

    wx.setStorageSync("before",before)



     wx.navigateTo({
       url: 'task',
       success: function (res) { },
       fail: function (res) { },
       complete: function (res) { },
     })





  },

});












