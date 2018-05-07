//提取sessionStorage中储蓄的order()和role()数组。
strorder=sessionStorage.objorder;
strrole=sessionStorage.objrole;
objorder=JSON.parse(strorder);
objrole=JSON.parse(strrole);
console.log(objorder);
console.log(objrole);

var count=0;
function goBack(){
    window.history.back();
}
function goForward(){
    window.history.forward();
}
//根据点击次数改变页面内容
function goAhead(){
    count=count+1 ;
    if(count<(objrole.length*2-1)){
        //点击次数是偶数时，隐藏角色信息
        if(count%2==0){
            document.getElementById("number").innerHTML=(count/2+1);
            document.getElementById("imageshow").style.display="none";
            document.getElementById("imagehide").style.display="block";
            document.getElementById("role").innerHTML="";
            document.getElementById("check").innerHTML="查看"+(count/2+1)+"号身份";

        }
        //点击次数为奇数时，显示角色信息
        else{
            document.getElementById("imageshow").style.display="block";
            document.getElementById("imagehide").style.display="none";     
            document.getElementById("role").innerHTML=objrole[Math.floor(count/2)];
            document.getElementById("check").innerHTML="隐藏并传递给"+(Math.ceil(count/2)+1)+"号";

        }
    }
    //最后一个角色信息显示时，按钮文字改变
    else if(count==(objrole.length*2-1)){
        document.getElementById("imageshow").style.display="block";
        document.getElementById("imagehide").style.display="none";     
        document.getElementById("role").innerHTML=objrole[Math.floor(count/2)];
        document.getElementById("check").innerHTML="法官查看";
    }
    //再次点击按钮跳转至法官日记页面
    else if(count==objrole.length*2){
        window.location.href="allrole.html";
    }
}