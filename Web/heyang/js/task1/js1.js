var nn = document.getElementsByTagName("span"),//获取九个格子
    qq = [],//空数组
    id;
function c(){
	    for (var i = 0; i < nn.length; i++) {
    	nn[i].style.backgroundColor = "orange";
    }
}//定义格子颜色初始值

function nnNum(){
	for (var i = 0; i < nn.length; i++) {
		qq.push(i);//将九个格子放入qq数组
	}
}
nnNum();//生产全局的数组
function suiji(){
	for (var i=qq.length-1; i>=0; i--) {
		var aaa = Math.floor(Math.random()*(i+1));//产生随机数
		var bbb = qq[aaa];
		qq[aaa] = qq[i];
		qq[i] = bbb;	
	}
}//洗牌算法、打乱qq数组之间的顺序
function ncolor(){
	var r = Math.floor(Math.random()*256);
	var g = Math.floor(Math.random()*256);
	var b = Math.floor(Math.random()*256);
	return "rgb("+r+","+g+","+b+")";
}//随机颜色

function suijiColor(){
	c();//定义格子颜色初始值
	suiji();//洗牌算法、打乱qq数组之间的顺序
	console.log(qq);//控制台监测qq数组的变化
	nn[qq[0]].style.backgroundColor = ncolor();//变色一
	nn[qq[1]].style.backgroundColor = ncolor();//变色二
	nn[qq[2]].style.backgroundColor = ncolor();//变色三
}//随机变化三种颜色的格子

function dodge() {//点击按钮
	clearInterval(id);//初始化时间
	id = setInterval("suijiColor()",1000);//一秒变化一次
}

function nododge(){ 
    clearInterval(id);
    c();
}//停止
