// const app = getApp()
Page({
  data: {
    defaultsize: "default",
    index: 0,
    indexage: 0,
    indexlogic: 0,
    indexel: 0,
    indexsex: 0,
    indexmajor: 0,
    array: ['博士', "硕士", '本科', '大专', '高中', ''],
    objectArray: [{
      name: "博士",
      num: [-1000, 10, -50, -40, -100, -50, 30, 50, 50, -1000, -1000, 30]
    },
    {
      name: "硕士",
      num: [-1000, 30, 40, 40, 50, 30, 50, 30, -30, -1000, -1000, 50]
    },
    {
      name: "本科",
      num: [-1000, 30, 40, 40, 50, 30, 50, 30, -30, -1000, -1000, 50]
    },
    {
      name: "高中",
      num: [-1000, 20, 0, 0, 0, 10, 40, 50, 50, -1000, -1000, 30
      ]
    },
    {
      name: "初中",
      num: [-1000, 10, -50, -40, -100, -50, 30, 50, 50, -1000, -1000, 30
      ]
    },
    {
      name: "大专",
      num: [-1000, 30, 30, 30, 30, 30, 30, 30, 30, -1000, -1000, 30
      ]
    },
    ],
    arraysex: [
      {
        sex: '男',
        num: [-1000, 50, 50, 50, 50, 50, 50, 30, 30, -1000, -1000, 30]
      }
      , {
        sex: '女',
        num: [-1000, 50, 30, 30, 10, -30, 50, 50, 50, -1000, -1000, 50]
      }],
    arrayage: [
      {
        age: '18岁以下',
        num: [-1000, 5, 0, 0, -50, 15, 20, 30, 50, -1000, -1000, 20
        ]
      },
      {
        age: '18~25岁',
        num: [-1000, 20, 20, 20, 20, 20, 20, 20, 20, -1000, -1000, 20]
      },
      {
        age: "25~30岁",
        num: [-1000, 20, 20, 20, 20, 20, 20, 20, 20, -1000, -1000, 20]
      },
      {
        age: '30岁以上',
        num: [-1000, -30, -30, -30, -30, -30, 50, 0, 0, -1000, -1000, 50
        ]
      }],
    arrayel: [
      {
        el: '零基础',
        num: [-1000, 0, 0, 0, 0, 0, 10, 20, 50, -1000, -1000, 10]
      },
      {
        el: '绘图基础',
        num: [-1000, 10, 10, 10, 10, 50, 0, 80, 10, -1000, -1000, 10]
      },
      {
        el: "网络相关",
        num: [-1000, 10, 10, 10, 10, 50, 0, 0, 10, -1000, -1000, 0]
      },
      {
        el: '原型设计',
        num: [-1000, 0, 0, 0, 0, 0, 50, 30, 10, -1000, -1000, 30]
      }
    ],
    arraymajor: [
      {
        major: '理工科',
        num: [-1000, 30, 35, 35, 40, 30, 30, 30, 30, -1000, -1000, 30]
      },
      {
        major: '无专业',
        num: [-1000, 30, 0, 0, 0, 0, 30, 50, 50, -1000, -1000, 30
        ]
      },
      {
        major: "计算机相关",
        num: [-1000, 35, 35, 35, 50, 40, 40, 40, 30, -1000, -1000, 40
        ]
      },
      {
        major: '文科',
        num: [-1000, 10, 10, 10, 10, 10, 50, 50, 30, -1000, -1000, 50
        ]
      }],
    arraylogic: [
      {
        logic: '渣渣',
        num: [-1000, 40, 10, 10, 10, 10, 20, 50, 50, -1000, -1000, 20
        ]
      },
      {
        logic: '普通',
        num: [-1000, 30, 30, 30, 30, 30, 30, 30, 30, -1000, -1000, 30
        ]
      },
      {
        logic: "卓越",
        num: [-1000, 40, 40, 40, 50, 40, 30, 0, 0, -1000, -1000, 30
        ]
      }]
  },
  bindPickerChange: function (e) {
    this.setData({
      index: e.detail.value
    })
    console.log(this.data.objectArray[e.detail.value]);
  },
  bindPickerChangesex: function (e) {
    this.setData({
      indexsex: e.detail.value
    })
  },
  bindPickerChangelogic: function (e) {
    this.setData({
      indexlogic: e.detail.value
    })
  },
  bindPickerChangeage: function (e) {
    this.setData({
      indexage: e.detail.value
    })
  },
  bindPickerChangemajor: function (e) {
    this.setData({
      indexmajor: e.detail.value
    })
  },
  bindPickerChangeel: function (e) {
    this.setData({
      indexel: e.detail.value
    })
  },
  default: function () {
    wx.clearStorage();
    var arr = [];
    var i = 0;
    for (i = 0; i < 12; i++) {
      arr.push(
        this.data.objectArray[this.data.index].num[i] +
        this.data.arraysex[this.data.indexsex].num[i] +
        this.data.arrayage[this.data.indexage].num[i] +
        this.data.arrayel[this.data.indexel].num[i] +
        this.data.arraylogic[this.data.indexlogic].num[i] +
        this.data.arraymajor[this.data.indexmajor].num[i]
      )
    }
    console.log(arr);
    var results = [{ name: 'css', value: arr[0] }, { name: 'js', value: arr[1] }, { name: 'android', value: arr[2] },
    { name: 'ios', value: arr[3] }, { name: 'java', value: arr[4] }, { name: 'op', value: arr[5] }, { name: 'pm', value: arr[6] }, { name: 'ui', value: arr[7] },
    { name: 'qa', value: arr[8] }, { name: 'su', value: arr[9] }, { name: 'python', value: arr[10] }, { name: 'operation', value: arr[11] }]
    function compare(obj1, obj2) {
      var value1 = obj1.value;
      var value2 = obj2.value;
      if (value1 > value2) {
        return -1
      } else if (value1 < value2) {
        return 1
      } else {
        return 0;
      }
    } 
    results.sort(compare);
    console.log(results);
    var majorarr = ['css', 'js', 'android', 'ios', 'java', 'op', 'pm', 'ui', 'qa', 'su', 'python', 'operation']
    console.log(majorarr.indexOf(results[0].name));
    var tem1 = [];
    tem1.push(majorarr.indexOf(results[0].name), majorarr.indexOf(results[1].name), majorarr.indexOf(results[2].name)),
      console.log(tem1);
    wx.navigateTo({
      url: "../outcome/outcome?list=" + JSON.stringify(tem1)
    });
  }
})