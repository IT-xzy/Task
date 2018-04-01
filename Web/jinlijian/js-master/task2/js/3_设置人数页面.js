//分别获取两个input的值，得到互相关联
var a = document.getElementById("text_rel");
var b =document.getElementById("bar");
if(a.value >18){
    alert("请输入6～18之间的数字");
    a.value =18 ;
}
if(a.value < 6){
    alert("请输入6～18之间的数字");
    a.value =6 ;
}
function bar() {
    a.value = b.value ;
}
function text_rel() {
    b.value = a.value ;
}
//加
function plus() {
    if(a.value ==18 || b.value ==18){
        alert("请输入6～18之间的数字");
        a.value =18 ;
        b.value = 18;
    }else if(a.value < 6){
        alert("请输入6～18之间的数字");
        a.value =6 ;
        b.value = 6;}
    else {
        ++a.value ;
        ++b.value ;
    }
}
function reduce() {
    if(a.value ==6 ||b.value ==6 ){
        alert("请输入6～18之间的数字");
        a.value =6 ;
        b.value = 6;
    }else if(a.value >18){
        alert("请输入6～18之间的数字");
        a.value =18 ;
        b.value = 18;
    } else{
        --a.value ;
        --b.value ;
    }
}
//随机取值

var get_0;
var get ;
//取值！！！
function get_number() {
    get_0 = document.getElementById("text_rel").value;
    get = parseInt(get_0);
    determine();
}
//判定输入的内容是否正确；
function determine() {
    if(isNaN(get)) {
        alert("你得输入数字");
    }
    random();
}

//如果正确，给数组重新排序
var civilian_arr = [] ;
var killer_arr = [] ;
var all_arr = [] ;
var random_arr =[] ;
function random() {

    //清空所有数组
    civilian_arr.length = 0;
    killer_arr.length = 0;
    all_arr.length =0 ;
    random_arr.length = 0;

    //判定人数
    if (6 <= get && get <= 9) {
        for (i = 0; i < 2; i++) {
            killer_arr[i] = "杀手";
        }
        for (i = 0; i < (get - 2); i++) {
            civilian_arr[i] = "平民";
        }
    }
    else if (10 <= get && get <= 13) {
        for (i = 0; i < 3; i++) {
            killer_arr[i] = "杀手";
        }
        for (i = 0; i < (get - 3); i++) {
            civilian_arr[i] = "平民";
        }
    }
    else if (14 <= get && get <= 16) {
        for (i = 0; i < 4; i++) {
            killer_arr[i] = "杀手";
        }
        for (i = 0; i < (get - 4); i++) {
            civilian_arr[i] = "平民";
        }
    }
    else if (17 <= get && get <= 18) {
        for (i = 0; i < 5; i++) {
            killer_arr[i] = "杀手";
        }
        for (i = 0; i < (get - 5); i++) {
            civilian_arr[i] = "平民";
        }
    }

    console.log("杀手" + "=" + killer_arr);
    console.log("平民"+ "=" + civilian_arr);



    all_arr =  killer_arr.concat(civilian_arr) ;  //合并
    console.log("所有" + "=" + all_arr);
    localStorage.setItem('所有组',JSON.stringify(all_arr));


    for(i = get ; i > 0 ;i-- ){
        var z = Math.floor(Math.random()* i) ;
        random_arr.push(all_arr[z]);
        all_arr.splice(z,1) ;
    }
    console.log("随机" + "=" + random_arr) ;

    //给text2添加文字。
    //先清空所有的列表
    var ul =document.getElementById("player") ;

    document.getElementById("player").innerHTML ="" ;

    for(i = 0; i< get ;i++){
        var li = document.createElement("li") ;
        var span = document.createElement("span") ;
        var player1 = document.createTextNode("水   民  1人");
        var player2 = document.createTextNode("杀   手  1人");
        if(random_arr[i] === "杀手"){
            span.appendChild(player2);
            li.appendChild(span);
            ul.appendChild(li);
            li.style.color = "#fea500";
            li.style.fontSize ="20px" ;
        }else{
            span.appendChild(player1);
            li.appendChild(span);
            ul.appendChild(li);
            li.style.color = "#29bde0";
            li.style.fontSize ="20px" ;
        }
    }
    // 开始传值！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    // 设置一个对象。名字水民杀手， 状态生存 ；声明在后面

    for(i =0; i < get; i++){
        condition[i] = {
            name : random_arr[i],
        state :'living'
    }
    }

    //打印检查
    console.log("被杀"+ "=" + be_killed);
    console.log("被投"+ "=" + be_vote);
    console.log("对象"+ "=" + condition);


    var arr_5 =killer_arr ;

    console.log("arr_5"+ "=" + arr_5);
//平民数组
    var arr_6 =civilian_arr ;

    console.log("arr_6"+ "=" + arr_6);


}

var condition =[] ;
//被杀数组
var be_killed =[];
//被投票投死数组
var be_vote =[];


//最后跳转
function give_num() {
    var hello =  document.getElementById("player").innerText ;
    if(hello ==false){
        alert("请设置玩家数量！") ;
    }else{
//sessionStorage.setItem('key', JSON.stringify(info));
//localStorage.setItem('key', JSON.stringify(info));

        sessionStorage.setItem('杀手组',JSON.stringify(killer_arr)) ;
        sessionStorage.setItem('平民组',JSON.stringify(civilian_arr));
        sessionStorage.setItem('随机组',JSON.stringify(random_arr));
        sessionStorage.setItem('对象组',JSON.stringify(condition));
        location.href= "../html/4_请玩家翻牌页面.html" ;
    }
}