$(document).ready(function () {
    var sTep=sessionStorage.getItem('step');
    if (sTep==='dead'){
        $('#kill').css('background-color', '#204EE0');
    }
    var fsm={
        state : sessionStorage.getItem('step'),
        killStep : function () {
            switch(fsm.state){
                case 'none':
                    sessionStorage.setItem('step','killer');
                    $('#kill').css('background-color', '#204EE0');
                    location.href='./task-0206.html';
                    break;
                case 'dead':
                    alert('请不要重复点击');
                    break;
                case 'speak':
                case 'vote' :
                    alert('请按步骤来');
                    break;
            }
        },
        deadStep: function () {
            switch (fsm.state){
                case 'dead':
                    fsm.state='speak';
                    sessionStorage.setItem('step',fsm.state);
                    $('#lastWords').css('background-color', '#204EE0');
                    break;
                case 'speak':
                    alert('请不要重复点击');
                    break;
                case 'none':
                case 'vote':
                    alert('请按步骤来');
                    break
            }
        },
        spaekStep: function () {
            switch (fsm.state){
                case 'speak':
                    fsm.state ='vote';
                    sessionStorage.setItem('step','vote');
                    $('#speak').css('background-color', '#204EE0');
                    break;
                case 'vote':
                    alert('请不要重复点击');
                    break;
                case 'none':
                case 'dead':
                    alert('请按步骤来');
                    break;
            }
        },
        voteStep: function () {
            switch (fsm.state) {
                case 'vote':
                    location.href = './task-0206.html';
                    break;
                case 'none':
                case 'dead':
                case 'speak':
                    alert('请按步骤来');
                    break;

            }
        }
    };
    var dienum=JSON.parse(sessionStorage.getItem('dieNum'));
    if (dienum){
        var day = Math.floor(dienum.length/2)+1;
        console.log(dienum);
        $('.day-title').text('第'+day+'天');
    }
    $('#kill').click(function () {
            fsm.killStep()
    });
    $('#lastWords').click(function () {
        fsm.deadStep()
    });
    $('#speak').click(function () {
        fsm.spaekStep();
    });
    $('#vote').click(function () {
        fsm.voteStep();
    });
    $('#close').click(function () {
        var close = confirm("确定离开");
        if(close === true){
            location.href='./index.html';
            sessionStorage.clear();
        }
    });
    $('#break').click(function () {
        var clos = confirm("返回配置界面？");
        if(clos === true){
            location.href='./task-0202.html';
            sessionStorage.clear();
        }
    });
});
