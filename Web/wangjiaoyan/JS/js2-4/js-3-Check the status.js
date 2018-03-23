/*
 * Created by Administrator on 2017/11/26.
 */
s = sessionStorage.TotalArr;
//重新转换为数组
TotalArr = JSON.parse(s);
console.log(TotalArr);
console.log(TotalArr.length);

var ClicksNum = 1;
var n = 0;

trans(); //自执行一次
function trans() {
    if (ClicksNum >= (2 * TotalArr.length+1)) {
       location.href = "js-4-The%20judge%20page.html";//身份查看完后进入下一个界面
    }
    else {

        if (ClicksNum % 2 !== 0) {
            CheckiDentity();    //显示查看身份页面
        }

        else {
            DeliverDentity();   //显示传递身份页面
        }
    }
    ClicksNum++;
    console.log(ClicksNum);
}

//查看身份页
function CheckiDentity() {
    document.getElementById("num").innerHTML = n+1;
    document.getElementById("btn").innerHTML = "查看" + (n+ 1) + "号身份";
    document.getElementById("draw").style.display="inline";
    document.getElementById("stute").style.display="none";
    n++;
}

//隐藏并传递身份页
function DeliverDentity() {
    if (n == TotalArr.length) {
        document.getElementById("btn").innerHTML="查看法官日志";//当n等于数组长度时候，身份显示完后，进入下一个页面
    }
    else {
        document.getElementById("btn").innerHTML = "隐藏并传递到"+ (n+1) +"号";
    }

    document.getElementById("draw").style.display="none";
    document.getElementById("stute").style.display="block";
    document.getElementById("role").innerHTML = "角色:"+TotalArr[n-1];

}
