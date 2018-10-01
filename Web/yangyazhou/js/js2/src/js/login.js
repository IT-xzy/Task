window.onload=function(){
    var timeValue=this.document.getElementsByTagName('time')[0],
        i=2;
    var timer =function(){
        setInterval(function(){
            timeValue.innerHTML = i +'s';
            i--;
        },950);
        
        setTimeout(function(){
            window.location.href='headerPage.html';
        },3500);
    };
    timer();
};