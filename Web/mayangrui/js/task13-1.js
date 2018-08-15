function bf(){
    var audio = document.getElementById('music1');
               if(audio.paused)                     {
            audio.play();//audio.play();// 这个就是播放
        }else{
            audio.pause();// 这个就是暂停
        }
}
$(document).ready(function () {
    $(".item1").click(function () {
        bf();
    })
});
function jump() {
    window.location.href="https://bradmatt213.github.io/learngit/task13-2"
}