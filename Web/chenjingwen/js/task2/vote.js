//提取设置页面数组和序号信息   
objorder=JSON.parse(sessionStorage.objorder);
objrole=JSON.parse(sessionStorage.objrole);
console.log(objorder);
console.log(objrole);
votestate=sessionStorage.votestate;


//创建角色对应的标签，并给标签添加classname
for(i=0;i<objrole.length;i++){
    var  parent=document.getElementById("squares");
    var  div=document.createElement("div");
    parent.appendChild(div);
    div.className="square";
    var parentDiv=document.getElementsByClassName("square");
    var  upper=document.createElement("div");
    var  lower=document.createElement("div");
    var  image=document.createElement("img");
    parentDiv[i].appendChild(upper);
    parentDiv[i].appendChild(lower);
    parentDiv[i].appendChild(image);
    upper.className="upper";
    lower.className="lower";
    image.className="image";
    document.getElementsByClassName("upper")[i].innerHTML=objrole[i];
    document.getElementsByClassName("lower")[i].innerHTML=objorder[i]+"号";
    document.getElementsByClassName("image")[i].setAttribute("src","./img/19.png");
}

//根据流程页面有限状态机状态判断出现杀人还是投票页面。
if(votestate=="vote"){
    $("#header").text("投票");
    $("#indicate").text("发言讨论结束，大家请投票");
    $("#point").text("点击得票数最多人的投票");
    $("#confirm").text("投死");
}
else{
    $("#header").text("杀手杀人");
    $("#indicate").text("杀手请睁眼，选择要杀的对象");
    $("#point").text("点击下方玩家头像，对被杀的玩家进行标记");
    $("#confirm").text("确定");
}


//重新建立数组，加入角色状态，数组元素为对象
var testArr=[];
for(i=0;i<objrole.length;i++){
    testArr.push(
        {
            isAlive:true,
            role:objrole[i],
            num:i,
            state:0,
        }      
    );
}
console.log(testArr);

//利用index和eq确定点击的小方框
$(".square").on("click",function(){
    var index=$(".square").index(this);
    k=index;
    console.log(index);
    $(".image").css("display","none");//出现点击效果之前清除所有效果，确保一次只点击小方块下的图片
    $(".image").eq(index).css("display","block");
});
//未标记状态下isAlive:true,标记后，标记的角色isAlive:false,
//其他元素还原为原始状态，判断isAlive:false可确定此次要杀死的人或投死的人
$(".image").on("click",function(){
    var k=$(".image").index(this);
    console.log(k);
    for(j=0;j<objrole.length;j++){
        testArr[j].isAlive="true";
    }           
        testArr[k].isAlive="false";
        console.log(testArr);
});
//剩余杀手人数和贫民人数 
var killernum=0,personnum=0;
var day;
var bekilled=[],bevoted=[];
function livenum(){
    for(a=0;a<objorder.length;a++){
        if(testArr[a].state==0){
            if(testArr[a].role=="杀手"){
                killernum=killernum+1;
            }
            else{
                personnum=personnum+1;
            }
        }

    }
    sessionStorage.killernum=killernum;
    sessionStorage.personnum=personnum;
    day=Math.floor((objorder.length-killernum-personnum)/2);
}
//判断剩余杀手人数和平民人数是否相等或杀手人数为0
function jumpurl(){
    if(killernum!=0){
        if(killernum==personnum){
            window.location.href="result.html";
        }
        else{
            window.location.href="diary.html";
        }       
    }
    else{
        window.location.href="result.html";
    }
}


//判断游戏是否结束，和跳转页面
$("#confirm").on("click",function(){
    var word=$("#confirm").text();
    for(n=0;n<objorder.length;n++){
        if(testArr[n].isAlive=="false"){//选出被标记的人
            if(testArr[n].state==1){//state=1，角色已经死亡，不能再次杀死
                alert("请选择状态是活着的人");
            }
            else{
                if(word=="确定"){//杀人页面不能杀死杀手
                    if(testArr[n].role=="杀手"){
                        alert("请选择平民进行操作");
                    }
                    else{
                        testArr[n].state=1;                        
                        livenum();  
                        jumpurl(); 
                        bekilled[day]="晚上："+(testArr[n].num+1)+"号被杀死，身份是"+testArr[n].role;                                        
                    }
                }
                else{
                    testArr[n].state=1;
                    livenum();  
                    jumpurl();  
                    bevoted[(day-1)]="白天："+(testArr[n].num+1)+"号被投死，身份是"+testArr[n].role;  
                }
            }
        }
    }
    sessionStorage.testArr=JSON.stringify(testArr);   
    sessionStorage.bekilled=JSON.stringify(bekilled);
    sessionStorage.bevoted=JSON.stringify(bevoted);
    console.log(bekilled);
    console.log(bevoted);
});

//每次进页面，自动循环找到已经是死亡状态的玩家，添加新的类名，改变方块颜色
for(x=0;x<objorder.length;x++){
    testArr=JSON.parse(sessionStorage.testArr);
    bekilled=JSON.parse(sessionStorage.bekilled);
    bevoted=JSON.parse(sessionStorage.bevoted);
    if(testArr[x].state==1){
        $(".upper").eq(x).addClass("upperchange");
    }
}
//保存杀人记录；

