var a=document.getElementsByClassName('p');
var nav=document.getElementsByClassName('nav1');
var click=0;

nav[0].onclick=function(){
	click++
	if (click%2==1) {
		p[0].style.display="block";
		p[1].style.display="block";
	}else{
		p[0].style.display="none";
		p[1].style.display="none";
	}

}
