function easy() {
	window.location.href = "js2.html";
}
function back() {
	window.location.href = "task13.html";
}

var change = function(num) {
	num.value=num.value.replace(/\D/g,'').substring(0,2);//除了数字以外都去除，长度限制，2是长度
}
var killer = document.getElementById("killer");
var civilian = document.getElementById("civilian");
var role = document.getElementById("role");
var kill;
var allNum;
var TotalArr = [];
var save = window.sessionStorage;
var sumNum = document.getElementById("sum");
var rangeNum = document.getElementById("myRange");
getsum()
$(".down").click(function(){
	if (rangeNum.value === "4") {
        alert("最小人数为4人");
    } else {
        rangeNum.value = (Number(rangeNum.value) - 1).toString();
        sumNum.value = rangeNum.value;
    }
    getsum()
})
$(".up").click(function(){
	if (rangeNum.value === "18") {
        alert("最大人数为4人");
    } else {
        rangeNum.value = (Number(rangeNum.value) + 1).toString();
        sumNum.value = rangeNum.value;
    }
    getsum()
})
rangeNum.onchange = function(){
	sumNum.value = rangeNum.value;
	getsum()
}
function getsum(){
	var sum = sumNum.value;
	$(".up").click(function(){
		sum.value++;
	})
	if (sum>18 || sum<4) {
		alert("请输入正确的数字");
		kill = null;
		sum = null;
		civilian.innerHTML = null;
	} else if (sum <= 5) {
		kill = 1;
	} else if (sum <=8 && sum >5){
		kill = 2;
	} else if (sum <=11 && sum >8) {
		kill = 3;
	} else if (sum <=15 && sum >11) {
		kill = 4;
	} else {
		kill = 5;
	}
	killer.innerHTML = kill;
    if (sum>18 || sum <4){
    	civilian.innerHTML = null
    } else {
    civilian.innerHTML = sum - kill;
    }
    allNum = sum;
    window.sessionStorage.setItem("allNum",allNum);
}

function distribute() {
    role.innerHTML = ""; //初始化分配内容
    allocation(); //根据设置重新洗牌进行分配
}
function allocation() {
	TotalArr = [];
	for(var n=0;n<kill;n++){
    TotalArr[n]="杀手"
}
    for(n=kill;n<allNum;n++){
    TotalArr[n]="平民"
}
    TotalArr.sort(function (){return 0.5 - Math.random() });//数组乱序
    var output;
    for (i=0;i<TotalArr.length;i++) {
    	output = "<li>" + (i+1) + "号" + TotalArr[i] + "</li>";
    role.innerHTML += output;
    }
    save.setItem("name",TotalArr);
}
function end() {
	if(allNum<=18 && allNum>=4 &&sessionStorage.getItem('name') !== null){
		window.location.href = "js2-1.html";
	} else {
	    alert("请输入正确的玩家数量,并设置身份");	    
	}
};
$(".back").click(function(){
	save.removeItem("name");
})
