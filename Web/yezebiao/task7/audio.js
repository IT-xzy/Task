$(function(){
    var audio = document.getElementById('mp3Btn');
    audio.volume = 0.3;
    $('.vote-audio').click(function() {
        if(audio.paused){ //如果当前是暂停状态
            audio.play(); //播放
            return;
        }else{//当前是播放状态
            audio.pause(); //暂停
        }
    });
})
