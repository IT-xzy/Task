  // 定义播放暂停代码
  window.onload = function () {

      var playerStr = localStorage.getItem('randomPlays'),
          gamersVote = document.getElementById('gamersVote'),
          playersArr = playerStr.split(','),
          len = playersArr.length,
          domStr = '';
      for (var i = 0; i < len; i++) {
          domStr +=` <div class="vote-container">
              <div class="gamer">
                      <span class="gamer-id">${playersArr[i]}</span>
                      <span class="gamer-num">${i+1}号</span>
                      <div class="gamer-select">
                          <i class="kill"></i>
                      </div>
                  </div>
              </div>`;
      }
      console.log(domStr);
      gamersVote.innerHTML = domStr;

      $("#ctrl").on('click', function () {
          var audio = document.getElementById('music');
          if (audio.paused) {
              audio.play(); //audio.play();// 播放
          } else {
              audio.pause(); // 暂停
          }
      });
      // 雪碧图小图标显现
      var $select = $(".gamer-select");
      $('.gamer').on('click', function () {
          $select.css('visibility', 'hidden');
          if ($(this).find($select).css('visibility') == 'hidden') {
              $(this).find($select).css('visibility', 'visible');
          }
      });
      // 跳转页面
      $('#btn-skip').on('click', function () {
          window.location.href = "result-1.html";
      });
      //关闭页面

      var close = document.getElementById('closeBtn');
      close.addEventListener('click', function () {
          var r = confirm("您确定离开游戏吗？");
          if (r == true) {
              window.location.href = "headerPage.html";
          }
      }, false);
  };