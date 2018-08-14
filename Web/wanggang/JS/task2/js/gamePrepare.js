//获取存储缓存json字符串并转换为数组
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
//获取玩家数量并转换为number
var players = +sessionStorage.getItem("players");
//声明点击计数
var i = 0;
//提取身份数组进行身份分配
function prepare() {
  if (playersArray[i] == 1) {
    $("#photo").css({
      "background": "url(./狼人杀/lang.jpg) no-repeat",
      "background-size": "cover"
    });
    $("p.prepare").text("狼人");
  } else {
    $("#photo").css({
      "background": "url(./狼人杀/cunmin.jpg) no-repeat",
      "background-size": "cover"
    });
    $("p.prepare").text("村民");

  };
  i++;
};
//对按钮进行判断
//声明按钮计数器
var a = 0;
//针对按钮点击进行样式更改
function buttonText() {
  //按钮计数器为0，则隐藏身份，1查看身份
  if (a == 0) {
    a += 1;
  } else {
    a -= 1;
  };
  //隐藏身份文字及样式
  if (a == 0) {
    $("p.prepare").text("");
    $("#typeChange").text("查看" + (i + 1) + "号玩家身份")
    $(photo).css({
      "background": "url(./狼人杀/kabei.png) no-repeat",
      "background-size": "cover"
    })
  } else if (i < players - 1) {
    $("#typeChange").text("隐藏并传递给" + (i + 2) + "号")
  }
  //进行最后玩家判断
  else if (i == players - 1) {
    $("#typeChange").text("法官查看");
  }
  //更改序号值
  $("#number").text(i + 1);
}

//调用函数
$(function () {
  $("#typeChange").click(function () {
    //对按钮进行判断，当玩家身份全部表名，跳转下一页面
    if (i < players) {
      //调用方法更改文字
      buttonText();
      //如果按钮属于显示身份状态。更改卡背
      if (a == 1) {
        prepare();
      }
    } else {
      location.href = "allPrepare.html";
    };
  })
})
