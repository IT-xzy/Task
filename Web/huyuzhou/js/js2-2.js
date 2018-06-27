var people;
var line;
var str="";
sessionStorage.clear()
//输入框滑块之间改变
function changeOne(){
	people=document.getElementById('people');
	 line=document.getElementById("Slider");
	line.value=people.value;
}
function changeTwo(){
	 people=document.getElementById('people');
	 line=document.getElementById("Slider");
	people.value=line.value;

}
//点击减少人数
function minus(){
	line=document.getElementById("Slider").value;
	if (line==4) {
		return false;
	}else{
		line--;
	}

	document.getElementById("Slider").value=line;
	document.getElementById('people').value=line;

}
//点击增加人数
function add(){
	line=document.getElementById("Slider").value;
	if (line==18) {
		return false;
	}else{
		line++;
	}

	document.getElementById("Slider").value=line;
	document.getElementById('people').value=line;
}
//输入框
function over(){
	people=document.getElementById('people').value;
	if (people>18) {
		alert("请输入4-18个人数");
	}else if(people<4){
		alert("请输入4-18个人数");
	}
}
//人数分配
function setting(){
	people=document.getElementById('people');
	var myPeople=parseInt(people.value);
	var oUl=document.getElementById("oUl");
	var oLi=oUl.getElementsByTagName("li");
		 str="";
	var TotalArr=new Array();
	var killer=Math.floor(myPeople/3);
	var number=new Array();
	//遍历所有为平民
		for (var n = 0; n < myPeople; n++) {
		TotalArr[n]="平民";
		}
	//抽取杀手
	for (var j = 0; j < killer; j++) {
		 number[j]=Math.floor(Math.random()*myPeople);
		 TotalArr[number[j]]="杀手";
		 //去重
	}
	//判断显示结果
	for (var i = 0; i <myPeople; i++) {
	if (TotalArr[i]=="杀手") {
		str+='<li>'+'<div class="color-killer">'+'</div>'+'<p>'+(i+1)+'号'+TotalArr[i]+'</p>'+
		'</li>';
		}else{
			str+='<li>'+'<div class="color">'+'</div>'+'<p>'+(i+1)+'号'+TotalArr[i]+'</p>'+
		'</li>';
		}
		oUl.innerHTML=str;

		arr=JSON.stringify(TotalArr);
		sessionStorage.players=arr;
		}

}
	window.onload=function(){
	document.getElementById("next").onclick=function(){
		if(str==''){
				alert("请分配身份");
			}else{
				location.href="js2-3.html";
			}
		}
	}
	//存值
