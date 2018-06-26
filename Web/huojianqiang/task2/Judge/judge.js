//读取本地存储
var value = JSON.parse(sessionStorage.getItem("key"));
//格子样式添加
// console.table(value);
function block(){
    var number = 0;
    for(var i = 0; i < value.length; i++){
        var Oversize = document.getElementById('Oversize');//获取id
        var New = document.createElement('div');//添加div
        Oversize.appendChild(New);//dic添加进id
        New.classList.add("large");//div添加类名
        var p_One = document.createElement('p');//创建p标签
        New.appendChild(p_One);//添加p至div
        p_One.classList.add("small");//p标签添加class
        var p_Two = document.createElement('p');//创建p标签
        p_Two.classList.add('small-two');//p标签添加类名
        New.appendChild(p_Two);//p添加进div
        if(value[i] === 0){
            p_One.innerHTML = '杀手';
        }else{
            p_One.innerHTML = '平民';
        };
        number++;
        p_Two.innerHTML = number + '号';
    };    
};  
block();       
//对象
var objArr = [];
for(var i = 0;i < value.length; i++){
    objArr[i] = {
        death: true,
    }
    if(value[i] == 0){
        objArr[i].name = "杀手";
    }else{
        objArr[i].name = "平民";
    }
}
console.table(objArr);
sessionStorage.setItem('obj',JSON.stringify(objArr));
sessionStorage.setItem('days','1');