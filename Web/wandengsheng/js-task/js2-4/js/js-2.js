var time;
    var p;
    var s;
    var killer='<li class ="killer">杀手1人</li>';
    var cvl='<li class ="pm">平民1人</li>';
    var allNumber=document.getElementById("mynumber")
    var range=document.getElementById("slider3");
    var pfs = document.getElementById("fe");


    // sessionStorage.clear();



    console.log(document.getElementById('slider3').value);
    document.getElementById('ce').onclick = function() {
        if (allNumber.value>=18){
            alert("人数不能超过18人");
        }
        else {
            allNumber.value++;
            range.value++;

        }
//        time  =document.getElementById('slider3').value++;
//        console.log(document.getElementById('slider3').value);
//        document.getElementById("mynumber").value=document.getElementById("slider3").value;
    }
    document.getElementById("ca").onclick = function () {
        if (allNumber.value<=6){
            alert("人数不能少于6人");
        }
        else {
            allNumber.value--;
            range.value--;

        }
//        time=document.getElementById("slider3").value--;
//        document.getElementById("mynumber").value=document.getElementById("slider3").value;
    }
    console.log(time)

//    document.getElementById("slider3").onchange = function () {
//        document.getElementById("mynumber").value=document.getElementById("slider3").value;
//        time = document.getElementById("mynumber").value;
//    }
    range.oninput =function () {
        allNumber.value = range.value;

    }
    allNumber.onblur = function () {
        if (allNumber.value  < 6){
            alert("人数少不够，至少6人起");
            allNumber.value = 6;

        }
        else if (allNumber.value > 18){
            alert("人数过多，不能超过18人");
            allNumber.value = 18;
        }
        range.value = allNumber.value;

    }







    sessionStorage.clear();
    document.getElementById("se").onclick = function () {
        var time = allNumber.value;
        console.log(time);
        console.log(p)
        //判断杀手和平民的人数

        if (time<8){
            s=1;
            p=time-s;
        }
        else if (time>7 && time<12){
            s=2;
            p=time-s;

        }
        else if (time>11 && time<19){
            s=4;
            p=time-s;

        }
//
//
        //杀手人数
        var kill=[];
        var civilian=[];
        var allnumber=[];
        document.getElementById("fe").innerHTML="";

        for(var i=0;i<s;i++){
            kill[i]=killer;
        //    console.log(kill)



        }
        //平民人数
        for(var i=0;i<p;i++){
            civilian[i]=cvl;
        //    console.log(civilian)

        }
        allnumber=kill.concat(civilian);
        console.log(allnumber)
        //随机数组
        function shuffle() {
            var a=(allnumber);
            var b=[];
            while (a.length>0){
                var index = parseInt(Math.random()*(a.length-1));
                b.push(a[index]);
                a.splice(index,1);
            }
//            console.log(b);
            return b;
        }
        var random = shuffle();
        for (var i=0;i<random.length;i++){
            document.getElementById("fe").innerHTML +=random[i]
        }


    }
    document.getElementById("bn").addEventListener("click",function () {
        if (allNumber.value!=pfs.getElementsByTagName("li").length){
            alert("请设置游戏人数");
        }
        else {
            sessionStorage.setItem("player",pfs.textContent);
                       
            location.href = "js2-3.html";
            // localStorage.setItem("killss","123")
        }
        
    })




    //判断杀手和平民的人数
//    if (time<8){
//        s=1;
//        p=time-s;
//    }
//    else if (time>7 && time<12){
//        s=2;
//        p=time-s;
//
//    }
//    else if (time>11 && time<18){
//        s=4;
//        p=time-s;
//
//    }
//    //杀手人数
//
//    for(var i=0;i<=s;i++){
//        var node=document.createTextNode("杀手1人");
//        div.appendChild(node);
//        div.setAttribute("class","color")
//        var element= document.getElementById("fe");
//        element.appendChild(div);
//
//    }
//    //平民人数
//    for(var i=0;i<=p;i++){
//        var node=document.createTextNode("杀手1人");
//        div.appendChild(node);
//        div.setAttribute("class","color")
//        var element= document.getElementById("fe");
//        element.appendChild(div);
//    }