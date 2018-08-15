//读取本地存储
var value = JSON.parse(sessionStorage.getItem("key"));
//格子样式添加
// console.table(value);
function block(){
    var number = 0;
    for(var i = 0; i < value.length; i++){
        var Oversize = document.getElementById('Oversize');//获取id
        var New = document.createElement('div');//添加div
        var p_One = document.createElement('p');//创建p标签
        var p_Two = document.createElement('p');//创建p标
        Oversize.appendChild(New);//dic添加进id
        New.classList.add("large");//div添加类
        New.appendChild(p_One);//添加p至div
        p_One.classList.add("small");//p标签添加class
        p_Two.classList.add('small-two');//p标签添加类名
        New.appendChild(p_Two);//p添加进div
        var img1 = document.createElement('img');
        New.appendChild(img1);
        img1.src='../Judge/tool.png';
        img1.classList.add('img76');
        if(value[i] === 0){
            p_One.innerHTML = '杀手';
        }else{
            p_One.innerHTML = '平民';
        };
        number++;
        p_Two.innerHTML = number + '号';
        var btn = document.getElementById('btn');
        btn.innerHTML = '确定';
    };    
};  
block();
// console.log(value.length);
//对象读取
var obj =JSON.parse(sessionStorage.getItem('obj'));
// console.log(obj);
//事件委托
$(function(){
    obj_3 = JSON.parse(sessionStorage.getItem('obj'));
    //判断是否存在kel
    if(sessionStorage.getItem('killer')){
        kil = JSON.parse(sessionStorage.getItem('killer'))
    }else{
        kil = 0;
    };
    //判断是否可以点杀手  
    //点击处
    var clickDath;
    $('.huge').delegate('p','click',function(e){
        $('div').css("border","3px solid white");
        $('.img76').removeClass('opac1'); 
        var target = $(event.target);
        var ind = $(e.target.parentNode).index();
        var obj_2 = JSON.parse(sessionStorage.getItem("obj"));
        //点击处
        clickDath = ind;
        var ci
        if(kil == 0){
            if(obj[ind].name == '平民'){
                $(e.target.parentNode).css("border","3px solid red");
                $('.img76').eq(ind).addClass('opac1');
                ci = 0;
                sessionStorage.setItem('cishu',JSON.stringify(ci));
            }else if(obj[ind].name == '杀手'){
                alert('点平民');
                ci = 1;
                sessionStorage.setItem('cishu',JSON.stringify(ci));
            };
        };
        //点击投票改变样式
        if(JSON.parse(sessionStorage.getItem('killer')) == 1){
            if(obj[ind].name == '平民' || obj[ind].name == '杀手'){
                $(e.target.parentNode).css("border","3px solid red");
                $('.img76').eq(ind).addClass('opac1');
                ci = 4;
                sessionStorage.setItem('cishu',JSON.stringify(ci));             
            };
        };
        //点击
        if(!obj_3[ind].death){
            $('div').css("border","3px solid white");
            $('.img76').eq(ind).css('opacity', '0');
            alert('死翘翘了');
            ci = 3;
            sessionStorage.setItem('cishu',JSON.stringify(ci));  
        };
    });
    //胜利条件
    //过滤
    // var killerd = [];
    // obj.map(function(track){
    //     if(track.name =='杀手' && track.death == true){
    //         killerd.push(track);
    //     };
    // });
    // console.log(killerd);
    // var people = [];
    // obj.map(function(track){
    //     if(track.name == '平民' && track.death == true){
    //         people.push(track);
    //     };
    // });
    // console.log(people);
    $('#btn').click(function(){
        if(JSON.parse(sessionStorage.getItem('cishu')) == 0){
            obj[clickDath].death = false;
            obj[clickDath].name
            sessionStorage.setItem('obj',JSON.stringify(obj)); 
            kil = 1;
            ci = 1;
            sessionStorage.setItem('killer',JSON.stringify(kil));
            sessionStorage.setItem('cishu',JSON.stringify(ci));
            //杀手的死亡
            if(JSON.parse(sessionStorage.getItem('who'))){
                arrDath = JSON.parse(sessionStorage.getItem('who'));
            }else{
                arrDath = [];
            };
            clickDath++;
            var neb = {numb : clickDath , who : obj[clickDath - 1].name};
            arrDath.push(neb);
            sessionStorage.setItem('who',JSON.stringify(arrDath));


            // var killerd = [];
            // $('.large').each(function(obj){
            //     if(obj.name == '平民' && obj.death == 'false'){
            //         killerd.push(0);
            //     }
            // })
            // console.log(killerd);
            // var people = [];
            // $.each(function(obj){
            //     if(obj.name == '杀手' && obj.death == 'false'){
            //         people.push(1);
            //     }
            // })
            // console.log(people);\
            //跳转判定
            var killerd = [];
            $.each(obj,function(i){
                if(obj[i].name== '杀手' && obj[i].death){
                    killerd.push(0);
                };
            });
            console.log(killerd);
            var people = [];
            $.each(obj,function(i){
                if(obj[i].name == '平民' && obj[i].death){
                    people.push(1);
                };
            });
            console.log(people);
            if(killerd.length >= people){
                // sessionStorage.setItem('win',JSON.stringify(杀手胜利))
                // alert('杀手');
                sessionStorage.setItem('win','杀手胜利');
                window.location.href = "../win/win.html";
            }else if(killerd.length == 0){
                window.location.href = "../win/win.html";
                // alert('平民');
                sessionStorage.setItem('win','平民胜利');
            }else{
                window.location.href = "../法官日志/judge.html";
            }
        }else if(JSON.parse(sessionStorage.getItem('cishu')) == 4){
            // window.location.href = "../法官日志/judge.html";  x
            var days = sessionStorage.getItem('days');
            judge = 0;
            sessionStorage.setItem('judge',judge);
            obj[clickDath].death = false;
            sessionStorage.setItem('obj',JSON.stringify(obj));
            if(sessionStorage.getItem('vote')){
                var vote = sessionStorage.getItem('vote');
            }else{
                var vote = 0;
            }
            vote++;
            sessionStorage.setItem('vote',vote);
            //投票的死亡
            if(JSON.parse(sessionStorage.getItem('who1'))){
                arrDath = JSON.parse(sessionStorage.getItem('who1'));
            }else{
                arrDath = [];
            };
            clickDath++;
            var neb = {numb : clickDath , who : obj[clickDath - 1].name};
            arrDath.push(neb);
            sessionStorage.setItem('who1',JSON.stringify(arrDath))
            //跳转判定
            var killerd = [];
            $.each(obj,function(i,valu){
                if(obj[i].name== '杀手' && obj[i].death){
                    killerd.push(0);
                };
            });
            console.log(killerd);
            var people = [];
            $.each(obj,function(i){
                if(obj[i].name == '平民' && obj[i].death){
                    people.push(1);
                };
            });
            console.log(people);
            if(killerd.length >= people.length){
                // sessionStorage.setItem('win',JSON.stringify(杀手胜利))
                // alert('杀手');
                sessionStorage.setItem('win','杀手胜利');
                window.location.href = "../win/win.html";
            }else if(killerd.length == 0){
                window.location.href = "../win/win.html";
                // alert('平民');
                sessionStorage.setItem('win','平民胜利');
            }else{
                window.location.href = "../法官日志/judge.html";
                days++;
                sessionStorage.setItem('days',days);
            }
        }else{
            alert('杀一个吧');
        };
    });
    //判断是否有人死亡，添加样式
    obj_3 = JSON.parse(sessionStorage.getItem('obj'));
    for(var i = 0; i < obj_3.length; i++){
      if(!obj_3[i].death){
          $('.small').eq(i).addClass('small-one');
      };
    };
    if(JSON.parse(sessionStorage.getItem('judge')) == 3){
        $('#btn').text('投票');
    };
});