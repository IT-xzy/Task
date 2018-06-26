
//初始化页面  
  $(function(){
        $('#ttt').css('display','none'); 
  });
  
  
  // 跳转页面
   $('#btn-skip').on('click',function(){
    window.location.href="vote.html";
});

$('#toggle').on('click',function(){
    $('#ttt').toggle();
});