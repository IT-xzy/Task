/**
 * Created by Administrator on 2018/4/10.
 */
function numrandom(){
            var blocks=Array(0,1,2,3,4,5,6,7,8);
            var newblock=new Array();
            var runNum=3;
            for(k=0;k<runNum;k++){
                var  ran= Math.round(Math.random() *(blocks.length-1));
                newblock.push(blocks[ran]);
                blocks.splice(ran, 1)
            }
            return newblock;
        }
function colorrandom(){
            return Math.round(Math.random()*256);
}
function restore(){
    for(x=0;x<document.querySelectorAll(".block").length;x++){
        document.querySelectorAll(".block")[x].style.backgroundColor="orange";
    }  
}
function circle(){
    /*随机三种颜色*/
    restore();
    var colors=new Array();
    for(i=0;i<3;i++){
        colors[i]="rgb("+colorrandom()+","+colorrandom()+","+colorrandom()+")";
    }
    /*随机选取三个小方块*/      
    var triblock=numrandom();
    for(j=0;j<3;j++){ 
        document.querySelectorAll(".block")[triblock[j]].style.backgroundColor=colors[j]; 
    }
}

var text;
function starting(){
    clearInterval(text);
    text=setInterval("circle()",1000);
}

function finished(){
    clearInterval(text);
    restore();  
}



