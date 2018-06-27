
var arr = sessionStorage.players;
players = JSON.parse(arr);

console.log(players);
//取序号


var para=document.getElementById('num');
var search=document.getElementById("search");//按钮键
var btnNum=0;//
var hid1=document.getElementsByClassName('hidden1');
var hid2=document.getElementsByClassName('hidden2');
var num=0;//身份号
var roles=0;//身份
//页面初始化
function reset(){
	for (var i = 0; i < hid2.length; i++) {
		hid2[i].style.display="none";
		}
		num+=1
		para.textContent=num;
		search.textContent="查看"+num+"号身份";

};
//点击按钮进入不同页面



window.onload=reset;
document.getElementById("search").onclick=function btnClick(){
	    //！！！！！！判断人数到达设定值！！！！！
		if(btnNum==2*players.length-1){
			document.getElementById("search").onclick=location.href="js2-4.html";
			alert("法官查看")
			 //！！！！！！判断为偶数时！！！！！！
		}else if(btnNum%2==0){
//显示角色图片
			for (var i = 0; i < hid2.length; i++) {
				hid2[i].style.display="block";
			}
//隐藏翻牌图片
			hid1[0].style.display="none";
//修改角色内容
			hid2[1].textContent="角色:"+players[roles];
			roles++
//修改身份号
		para.textContent=num;
		num++
//修改按钮内容
		search.textContent="隐藏并传递给"+num+"号";
		console.log(btnNum)
		btnNum+=1;

		if(btnNum==2*players.length-1){
		search.textContent="法官查看";

		}
        //！！！！！判断为奇数时！！！！！！！！
		}else{
//隐藏角色图片
			for (var i = 0; i < hid2.length; i++) {
				hid2[i].style.display="none";
			}
//显示翻牌图片
			hid1[0].style.display="block";
//修改身份号
		para.textContent=num;
//修改按钮内容
		search.textContent="查看"+num+"号身份";
			btnNum+=1;

		}
	}
