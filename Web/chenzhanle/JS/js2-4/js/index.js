var gameVer = document.querySelector('.game-ver');
var gameLink = gameVer.querySelectorAll('.game-link  a');

gameLink[0].addEventListener('click', changePage);
// 跳转页面
function changePage() {
  window.location.href = 'player-init.html' ;
}