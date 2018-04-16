 // js控制响应式导航
 $('#navbarToggle').on('click', function () {
    var $list = $('.nav-list').css('display');
    if ($list == 'none') {
        $('.nav-list').css('display', 'block');
    } else {
        $('.nav-list').css('display', 'none');
    }
});

$(window).resize(function () {
    if (window.innerWidth > 768) {
        $('.nav-list').css('display', 'block');
    } else {
        $('.nav-list').css('display', 'none');

    }

});
//jquery控制输入框字符为数字
$('input[type=text]')
$(function () {
    $("input[type=text]").keyup(function () {
      //如果输入非数字，则替换为''
      this.value = this.value.replace(/[^\d]/g, '');
    })
  });

  //jquery来设置下拉框选中单选按钮
      var  $texts;
      $("select").change(function(){
        //   选择option节点
        var options=$(this).children("option:selected"); //也可以获取到选中的option
        // 获得文本节点
        $texts=options.text();
        // 根据文本节点查找元素
        var $label=$('label:contains('+$texts+')')    
        // 根据label元素的for获得radio的id
        var id =$label.attr('for');
        // 根据ID值来设置相关元素的checked的状态为true          
            $('#'+id).prop("checked",true)
       });
