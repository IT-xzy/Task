
//初始化页面  
  $(function(){
        $('#ttt').css('display','none'); 
  });
  
  
  // 跳转页面
   $('#btn-skip').on('click',function(){
    sessionStorage.clear();
    window.location.href="allot.html";
});
//左侧导航栏出现和消失
$('#toggle').on('click',function(){
    $('#ttt').toggle();
});
// var arr=localStorage.getItem('randomPlays');
// console.log(arr);
