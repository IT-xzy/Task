  // 定义播放暂停代码
  $("#ctrl").on('click',function(){
    var audio = document.getElementById('music');
    if (audio.paused) {
        audio.play();//audio.play();// 播放
    }
    else {
        audio.pause();// 暂停
    }
});
// 雪碧图小图标显现
var $select=$(".gamer-select");
$('.gamer').on('click',function(){
    $select.css('visibility','hidden');
    if( $(this).find($select).css('visibility') == 'hidden'){
         $(this).find($select).css('visibility','visible');
    }else{
       
    }
   
});
// 跳转页面
$('#btn-skip').on('click',function(){
    window.location.href="result-1.html";
});