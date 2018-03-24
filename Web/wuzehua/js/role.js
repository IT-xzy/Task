var check = document.getElementById('check');
var img = document.getElementById('img');
var fang = true;
var chara = check.value;
var i=1; 
var ipt =document.getElementById('ipt');
var s=document.getElementById('s');
var arr;
      arr=localStorage.getItem('arr').split(',');
      console.log(arr);

check.onclick = function() {
	fang = !fang;
	if(fang) {
		
		img.src = '../img/draw.png';
		check.value ='查看'+i+"号身份";
		ipt.value=i
		
	} else {
		img.src = '../img/draw2.png';
		check.value = '隐藏'+i+'号身份显示'+(i+1)+'号身份';
i++;
    
	}
	console.log(i)

}

document.getElementsByClassName('left')[0].onclick = function() {
	window.location.href = "player.html";
}
document.getElementsByClassName('right')[0].onclick = function() {
	window.location.href = "player.html";
}