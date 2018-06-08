function playerId(num) {
    var pId = document.getElementsByClassName('player-id');
    pId[0].innerHTML = num;
}

function hidePng(str) {
    var identity = document.getElementsByClassName('identity');
    (getComputedStyle(identity[0]).display == 'block') ? (identity[0].style.display = 'none') : (identity[0].style.display = 'block');
    identity[0].getElementsByTagName('p')[0].innerHTML = str;
}

function btnSwitch(elem,str) {
    var num = 1;
    var pRole = null;
    this.currentState = 'toShow';
    var that = this;
    this.init = function() {
        elem.addEventListener("click", function(){return that.transition()});
        playerId(num);
        elem.innerHTML = '查看' + num + '号身份';
    }　　　

    this.transition = function() {　　　

        switch (this.currentState) {　　　　　　　　
            case "toShow":
                this.currentState = 'toNext';

                playerId(num);
                if (str[num - 1].role == 'civilian') {
                	console.log(str[num - 1].role+'-id-'+str[num - 1].id);
                    pRole = '角色：平民';
                    hidePng(pRole);
                } else {
                	console.log(str[num - 1].role+'-id-'+str[num - 1].id);
                    pRole = '角色：杀手';
                    hidePng(pRole);
                }
                num++;
                if (num < str.length+1) {
                	elem.innerHTML = '隐藏并传递给' + num + '号';
                }else{
                	num = 1;
                	elem.innerHTML = '查看法官日志';
                	elem.removeEventListener("click", function(){return that.transition()});
        			elem.addEventListener("click", function (){window.location.href = "judge-log.html"});
                }
                break;

            case "toNext":
                this.currentState = 'toShow';

                playerId(num);
                hidePng();
        		elem.innerHTML = '查看' + num + '号身份';　　　
                break;　
                　　　　　　　
            default:
                console.log('Invalid State!');　　　　　　　　　　
                break;　　　　　　
        }　　　　
    }

}

console.log(JSON.parse(sessionStorage.getItem('arrR')));
var arrRandom = JSON.parse(sessionStorage.getItem('arrR'));
var nextBtn = document.getElementsByClassName('next-btn');
var nBtn = new btnSwitch(nextBtn[0],arrRandom);
nBtn.init();

var backBtn = document.getElementsByClassName('back-btn');
backBtn[0].onclick = function (){
	window.location.href = "player-setting.html"
}