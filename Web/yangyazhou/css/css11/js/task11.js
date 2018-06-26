$(function () {
    $("#phone").keyup(function () {
      //如果输入非数字，则替换为''，如果输入数字，则在每4位之后添加一个空格分隔
      this.value = this.value.replace(/[^\d]/g, '');
    })
  });
