var kill_rell = JSON.parse(sessionStorage.getItem("kill_rell"));
var civilian = JSON.parse(sessionStorage.getItem('平民组'));
console.log("剩余杀手组" + "====" + kill_rell) ;
console.log("平民组" + "====" + civilian) ;
var result1 = JSON.parse(sessionStorage.getItem('随机组'));
var be_vote = JSON.parse(sessionStorage.getItem('被投组'));
var condition = JSON.parse(sessionStorage.getItem('对象组'));
//对象组也不能！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！mmp ；



var p = JSON.parse(sessionStorage.getItem('p'));
if( p == null){
    p =condition ;
}





//得到数组后隐藏盒子(盒子是写好的）


var w = JSON.parse(sessionStorage.getItem('w')) ;
if( w == null){
    w = civilian.length ;
}
var i;
for(i = 17 ; i > result1.length - 1 ; i-- ){
    document.getElementsByClassName("id12f")[i].style.display="none";
}
//给每个盒子的身份赋值
var a = document.getElementsByClassName("id1-1") ;
for(b = 0 ; b <result1.length;b++){
    if(result1[b] =="杀手"){
        a[b].innerHTML ="杀手" ;
    }else{
        a[b].innerHTML ="平民" ;
    }
}


var be_killed  =  JSON.parse(sessionStorage.getItem("be_killed")) ;
console.log(be_killed) ;
var be_killed_2 =[] ;
if(be_killed != null){
    for(i = 0 ;i <be_killed.length ;i++){
        a[be_killed[i]].style.cssText="background-color:rgb(255,0,255)" ;
    }
}

var b,c,d,e,g;
var f = []  ;
for (q = 0 ;q < result1.length;q++){
    a[q].index = q
    a[q].onclick = function () {
        for(e = 0; e < result1.length;e++){
            a[e].style.cssText='' ;
        }
        d = "rgb(105,105,105)" ;
        if(this.innerHTML == "杀手"){
            alert("不能杀自己人");
            if(be_killed != null){
                for(i = 0 ;i <be_killed.length ;i++){
                    a[be_killed[i]].style.cssText="background-color:rgb(255,0,255)" ;
                }
            }
        }else if(p[this.index].state != "living"){
            alert("别乱奖杯点！")
            if(be_killed != null){
                for(i = 0 ;i <be_killed.length ;i++){
                    a[be_killed[i]].style.cssText="background-color:rgb(255,0,255)" ;
                }
            }
        }else if(be_killed_2.indexOf(this.index) != -1 ){
            alert("你点个屁yo！") ;
            if(be_killed != null){
                for(i = 0 ;i <be_killed.length ;i++){
                    a[be_killed[i]].style.cssText="background-color:rgb(255,0,255)" ;
                }
            }
        }else {
            a[this.index].style.cssText='background-color:rgb(105,105,105)' ;
            g = this.index ;
            console.log(g) ;
            if(be_killed != null){
                for(i = 0 ;i <be_killed.length ;i++){
                    a[be_killed[i]].style.cssText="background-color:rgb(255,0,255)" ;
                }
            }
        }
        //重新赋值！！！！！！！！！！！！！！！！！！别忘了
    }
}
function kill() {
    if( g ==  undefined ){
        alert("您特么倒是选一个呀");
    }else {
        if (be_killed == null) {
            be_killed = be_killed_2;
        }
        be_killed.push(g);//被杀的脚标
        w--;        //公民-1
        console.log(be_killed);      //打印被杀
        //做完删除比较大小！！
        if (kill_rell != null) {
            if (kill_rell >= w) {
                sessionStorage.setItem("rrrsul", JSON.stringify("0"));
                location.href = "../html/9_游戏结果页面.html";
            } else if (kill_rell == 0) {
                sessionStorage.setItem("rrrsul", JSON.stringify("1"));
                location.href = "../html/9_游戏结果页面.html"
            }
        }





        p[g].state = 'die';
        console.log(p);
        sessionStorage.setItem("be_killed", JSON.stringify(be_killed));
        sessionStorage.setItem("w", JSON.stringify(w));

        console.log(p)
        sessionStorage.setItem("p", JSON.stringify(p));
        location.href = "../html/6_天黑请闭眼页面.html";
    }
}
function clear1() {
    sessionStorage.removeItem("对象组") ;
    sessionStorage.removeItem("随机组") ;
    sessionStorage.removeItem("杀手组") ;
    sessionStorage.removeItem("平民组") ;
    sessionStorage.removeItem("civilian") ;
    sessionStorage.removeItem("condition") ;
    sessionStorage.removeItem("step") ;
    sessionStorage.removeItem("kill_rell") ;
    sessionStorage.removeItem("w");
    sessionStorage.removeItem("u") ;
    sessionStorage.removeItem("p") ;
    sessionStorage.removeItem("rrrsul");
    sessionStorage.removeItem("be_killed") ;
    location.href="../1_index.html" ;
}
