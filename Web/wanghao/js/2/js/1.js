var loading=document.getElementsByClassName("loading")[0];
console.log(loading)
document.onreadystatechange = subSomething;//当页面加载状态改变的时候执行这个方法.
function subSomething()
{
if(document.readyState == "complete") //当页面加载状态为完全结束时进入
loading.style.display="none";
}
//-->