var killer_arr = JSON.parse(sessionStorage.getItem('杀手组'));
var kill_rell = JSON.parse(sessionStorage.getItem('kill_rell')) ;
if(kill_rell == null){
    kill_rell  =  killer_arr.length ;
}
var w = JSON.parse(sessionStorage.getItem('w'));
console.log("杀手组" + "====" + killer_arr) ;
console.log("平民组" + "====" + w) ;
var result1 = JSON.parse(sessionStorage.getItem('随机组'));


var p =JSON.parse(sessionStorage.getItem("p")) ;






var a =document.getElementsByClassName("id1-1") ;
// var be_killed  =  JSON.parse(sessionStorage.getItem("be_killed")) ;
//得到数组后隐藏盒子(盒子是写好的）
var be_killed  =  JSON.parse(sessionStorage.getItem("be_killed")) ;
console.log(be_killed) ;
console.log(p) ;
// var be_killed_2 =[] ;
// if(be_killed != null){
//     for(i = 0 ;i < be_killed.length ;i++){
//         a[be_killed[i]].style.cssText="background-color:rgb(255,0,255)" ;
//     }
// }
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


        //死了不能点！！！！！！！！！！！！！！！！！！！

        if(p[this.index].state != "living"){
            alert("别乱奖杯点！")
            if(be_killed != null){
                for(i = 0 ;i <be_killed.length ;i++){
                    a[be_killed[i]].style.cssText="background-color:rgb(255,0,255)" ;
                }
            }
        }
        else{
            a[this.index].style.cssText='background-color:rgb(105,105,105)' ;
            g = this.index ;
            if(be_killed != null){
                for(i = 0 ;i <be_killed.length ;i++){
                    a[be_killed[i]].style.cssText="background-color:rgb(255,0,255)" ;



                    console.log("被杀的人足足组" +  be_killed ) ;
                }
            }
        }
    }
}
var u ;
function kill() {
    if( g ==  undefined ){
        alert("您特么倒是选一个呀");
    }else {
        var u = p[g].name;
        be_killed.push(g);           //被杀的脚标
        if (u == "杀手") {
            kill_rell--;
            p[g].state = "die" ;
        } else {
            w--;
            p[g].state = "die" ;
        }


        if (kill_rell >= w) {
            sessionStorage.setItem("rrrsul", JSON.stringify("0"));
            location.href = "../html/9_游戏结果页面.html";
            return false;
        } else if (kill_rell == 0) {
            sessionStorage.setItem("rrrsul", JSON.stringify("1"));
            location.href = "../html/9_游戏结果页面.html"
            return false;
        } else {
            console.log(kill_rell + "+" + w);
            console.log(be_killed);      //打印被杀数组 ；
            p[g].state = 'die';
            console.log(p);
            sessionStorage.setItem("p",JSON.stringify(p)) ;
            sessionStorage.setItem("be_killed", JSON.stringify(be_killed));
            sessionStorage.setItem("w", JSON.stringify(w));
            sessionStorage.setItem("kill_rell", JSON.stringify(kill_rell));
            location.href = "../html/6_天黑请闭眼页面.html";
        }
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