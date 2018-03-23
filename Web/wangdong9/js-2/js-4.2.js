/**
 * Created by Administrator on 2017/12/7.
 */
strl=sessionStorage.l;
l=JSON.parse(strl);
// strln=sessionStorage.n;
// n=JSON.parse(strln);
var m=[];
window.onload=function cDiv(){
    // oTextname=document.createTextNode(l[i]);
    for   (i=0;  i<l.length; i++) {
        m[i]=i;
        var main=document.getElementsByClassName("main");
        var footer=document.getElementById("footer");
        var oDiv=document.createElement("div");
        var oDivsi=document.createElement("div");
        var oDivnumber=document.createElement("div");
        var oText=document.createTextNode((i+1)+"号");
        oDiv.className="squar";
        oDivsi.className="si";
        oDivnumber.className="number";
        oDiv.appendChild(oDivnumber);
        oDiv.appendChild(oDivsi);
        oTextname=document.createTextNode(l[i]);
        console.log(oTextname);
        // oTn=oTextname;
        oDivnumber.appendChild(oText);
        oDivsi.appendChild(oTextname);
        oDiv.id='div'+m[i];
        document.getElementById("all").appendChild(oDiv);
    }
};
//在数组中查找所有出现的x，并返回一个包含匹配索引的数组
function findall(a,x){
    var results=[],
        len=l.length,
        pos=0;
    while(pos<len){
        pos=a.indexOf(x,pos);
        if(pos===-1){//未找到就退出循环完成搜索
            break;
        }
        results.push(pos);//找到就存储索引
        pos+=1;//并从下个位置开始搜索
        // alert(results);
        re=results;         //re是杀手的下标数组
        console.log(re);
    }
    return results;
}
findall(l,"杀手");

$(document).ready(function(){
    var si=sessionStorage.getItem("nn");
    if(si==null){
        sin=[];
    }
    else  if (si!==null){
        sin=JSON.parse(si);
        for(mi=0;mi<sin.length;mi++){
            document.getElementById("div"+sin[mi]).style.background="#ccc"}
    }
    console.log(sin);
    k=sessionStorage.getItem('knum');
    kk=k-1;
    console.log(k);

    s=sessionStorage.getItem('snum');
    ss=s-1;
    console.log(s);
    voted=sessionStorage.getItem("voted");
    if(voted!==null){
        document.getElementById("star").innerHTML="投死";
    }
    console.log(re);
    a=null;
    // console.log(a);
// console.log(oTextname);
    $(".squar").click (function () {
        voted=sessionStorage.getItem("voted");
        // dont=sessionStorage.getItem("dont");
        a = $(this).index();
        b=$(this).css('background-color');
        console.log(b);
        // console.log(a);
        ai=re.indexOf(a);
        console.log(ai);
        ni=null;
        if(b=='rgb(204, 204, 204)'){alert('你要鞭尸么?杀活人')
        }
      else if(ai>-1&&voted==null){                  //ai>-1表示a在re也就是在说选中的是杀手
            $(".squar").removeClass("iportant change");
                alert("不能杀杀手");
                a=null;
              // console.log(a);
        }
        else 
        {
            $(".squar").removeClass("iportant change");
            $(this).addClass("important change");
        }
});

});
function star() {
    voted=sessionStorage.getItem("voted");
    if(a==null){
        alert("杀个人再走");
    }
    else if(a!==null&&voted==null){//杀人页，同时已经选过人了
        if(k>=ss){                   //杀过人之后杀手人数大于等于水民人数，杀手胜
            sessionStorage.setItem('killer','win');
            sin.push(a);
            stn = JSON.stringify(sin);
            sessionStorage.nn=stn;
           location. href="js-4.3.html"
        }
        else  {                 //杀手杀完人之后水民人数还多于杀手人数，游戏继续，水民人数减一
            s--;
            sessionStorage.setItem('snum',s);
            sin.push(a);
            stn = JSON.stringify(sin);
            sessionStorage.nn=stn;
            location.href = "js-4.1.html"
        }
    }
    else if(a!==null&&voted!==null){           //投票页
if(ai>-1&&kk<s&&kk!==0){                //如果选中的是杀手，同时杀手人数大于1,游戏可继续，跳到第一个页面，杀手人数减一
    k--;
    sessionStorage.setItem('knum',k);
    sessionStorage.removeItem("voted");
    sessionStorage.removeItem("speaked");
    sessionStorage.removeItem("ghosted");
    sessionStorage.removeItem("killed");
    sin.push(a);
    stn = JSON.stringify(sin);
    sessionStorage.nn=stn;
    location.href = "js-4.1.html";
}
        else  if(ai>-1&&kk==0){                 //投票选中的是杀手，同时把这个杀手杀了之后杀手人数为0，水民胜利
    sessionStorage.setItem('siller','win');
    sin.push(a);
    stn = JSON.stringify(sin);
    sessionStorage.nn=stn;
    location.href="js-4.3.html";
}
else if(ai=-1&&ss>k){                         //投票选中的是水民,同时杀一个水民之后水民的人数大于杀手人数，游戏继续
    s--;                                          //水民人数减一
    sessionStorage.setItem('snum',s);

    sessionStorage.removeItem("voted");
    sessionStorage.removeItem("speaked");
    sessionStorage.removeItem("ghosted");
    sessionStorage.removeItem("killed");
    sin.push(a);
    stn = JSON.stringify(sin);
    sessionStorage.nn=stn;
    location.href = "js-4.1.html";
}
        else if(ai=-1&&ss<=k){              //投票选中的是水民，杀了这个水民之后水民人数少于杀手人数，杀手胜利
    sessionStorage.setItem('killer','win');
    sin.push(a);
    stn = JSON.stringify(sin);
    sessionStorage.nn=stn;
    location. href="js-4.3.html"
}
    }
}

