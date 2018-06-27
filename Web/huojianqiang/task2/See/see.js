//读取本地存储
var value = JSON.parse(sessionStorage.getItem("key"));
//随机
function ran(value){
    var m = value.length,
        t,i;
    while(m){
        i = Math.floor(Math.random() * m--);
        t = value[m];
        value[m] = value[i];
        value[i] = t;
    };
    return value;
};
value = ran(value);
//存储
sessionStorage.setItem('key',JSON.stringify(value));
var read = JSON.parse(sessionStorage.getItem("key"));
console.table(read);
//删除翻牌
function delect(){
    var delectPho = document.getElementById('pretend');
    var delectSon = delectPho.getElementsByTagName('img')[0];
    delectPho.removeChild(delectSon); 
};
//添加角色
var frequency = 0;//点击次数
var res = value.length * 2;
function addPho(){
    if(frequency < value.length){
        var addPho = document.createElement("img");
        addPho.src = "WOW.png";
        var addFth = document.getElementById('pretend');
        addFth.appendChild(addPho);
        var one = document.getElementById('fixed');
        var two = document.getElementById('change');
        var three = document.getElementById('change-one');
        one.style.display='block';
        two.style.display='block';
        three.style.display='block';
        var role = document.getElementById('role');
        for(var i = 0; i <= frequency; i++){
            if(value[i] == 0){
                role.innerHTML = '杀手';
            }else{
                role.innerHTML = '平民';            
            }
        }
        frequency++;
    }
};
console.log(frequency); 
//删除角色
function delectImg(){
    var addPho = document.getElementById('pretend');
    var delectImg = addPho.getElementsByTagName('img')[0];
    addPho.removeChild(delectImg);
    var one = document.getElementById('fixed');
    var two = document.getElementById('change');
    var three = document.getElementById('change-one');
    one.style.display='none';
    two.style.display='none';
    three.style.display='none';
};
//添加翻牌
function dedctPho(){
    var delectPho = document.getElementById('pretend');
    var addPho = document.createElement("img");
    addPho.src = "WOW1.png";
    delectPho.appendChild(addPho);
};
//点击添加，点击删除
var x = 1;
var number = 1;
var nsm = 0;
function Paging(){
    nsm++;
    var math = document.getElementById('math');
    var hide = document.getElementById('hide');
    if(res == nsm){
        window.location.href = '../Judge/Judge.html'; 
    }else{
        math.innerHTML = number;
        if(x == 1){
            delect();
            addPho();
            x = 2;
            if(nsm == res - 1){
                hide.innerHTML = '法官日志';
            }else{
                number++;
                hide.innerHTML = "查看身份并传递给"+number+"号";
            }
        }else{
            delectImg();
            dedctPho();
            x = 1;  
            hide.innerHTML = "查看"+number+"号身份";
        }
    }
    console.log(nsm);
    console.log(number)
    // console.log(res);
};