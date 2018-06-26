function(){
	// 1.写出法官日记
	// （拿到之前的玩家人数数组all，根据all.length渲染玩家数量，加if判断根据玩家角色渲染身份）
	【之后状态机所有数据都要保存，在法官日志都要拿下来】
	// 2.一共游戏界面、杀人页面、投票页面、法官日志四个页面，每个页面执行后，信息都要保存在sessionStorage上，用的时候要拿下来；
	// 3.每天有杀手杀人→发表遗言→玩家发言→投票为四个状态，分别有4个事件daytime、think、decision、dark四个事件来连接起来，成为一个循环。画的图就不贴在这了
	// 4.杀人时也是一个状态机，有杀平民和结束状态，由watch事件连接，写methods:{}的时候要加 if 判断，选择杀手身份的弹出框提示， else 添加class 样式用class先写在less中，点击后对应角色背景变暗；
	//   投票时同理，只是可以杀任意人；  
	// 5.从杀人页面跳转回游戏界面的时候，要从sessionStorage拿出在杀人页面已经保存在sessionStorage上的状态，使用 goto(result)传参直接到发表遗言状态(避免跳转回来后回到初始状态) ，然后使用对应methods:{}，添加class，改变样式；                                                                                                            
	// 6.在法官台本页面中点击非当前状态的时候，执行alert（“请按游戏顺序进行”）
	// 7.添加4个点击事件，分别为对应状态机里的状态；
	// 8.写状态机里的methods:{}函数，
	  杀手杀人状态结束后（杀手杀人之后 发表遗言之前，）OnLeaveKill: function(){加if判断,如果杀手大于平民人数，游戏结束；else 显示被杀者信息},
	//   发表遗言：OnEnterSpeak: function(){弹出提示框，给这个按钮添加对应class，样式用class先写在less中，点击后按钮背景变暗}
	//   玩家发言同理；
	// 9.法官台本每一天的状态都有，点击“第几天”后出现，再次点击隐藏，添加点击事件；
	10.将每次杀手杀死或者投票杀死的人都放到一个死亡数组died[]里,通过for循环+$(".people").eq(died-1).css("opacity","0.5");改变eq里的值来渲染死者样式;通过天数获取died[]索引值;
	died=[1,2,3,4];
	var a= 2;
	if(killer=="kill"){
		fsm.goto("kill"); 
		$(".died").text(died[a]+"号玩家被杀死，真实身份是平民");
	}
	// 11.投票页面确定时，添加胜负判断跳转; 
	//    杀手只有在投票页面才有可能会死,把这个页面死掉的杀手放入diedKiller[]数组里,
	//    // 生存者人数=all.length-died.length; //总人数-死亡的人数
	//    幸存者人数:survivor.length=(all.length-Math.floor((1/3)*all.length))-(died.length-diedKiller.length) //总平民人数-死亡的平民人数 
	   // diedKiller[]在投票页面，条件判断后放入构成;`                                                                                                                                                                                     
	   // 健在的杀手人数:survivorKiller.length=Math.floor((1/3)*all.length)-diedKiller.length //杀人总人数-死亡的杀人人数
	   // diedKiller[]需要构造，其他的只需要长度，不需要构建数组;
	12.如何跳转到下一个状态机，渲染第二天标签;   $(".main").append($(".day").eq(0).clone(true)); 
	13.footer的两个按钮用goto来实现跳转。
}
// 	GOTO - Changing State Without a Transition
//     You can use a conditional transition, combined with a wildcard from, to implement arbitrary goto behavior:

// var fsm = new StateMachine({
//     init: 'A'
//     transitions: [
//      	{ name: 'step', from: 'A', to: 'B'                      },
//      	{ name: 'step', from: 'B', to: 'C'                      },
//      	{ name: 'step', from: 'C', to: 'D'                      },
//      	{ name: 'goto', from: '*', to: function(s) { return s } }
//     ]
//   })
//   fsm.state;     // 'A'
//   fsm.goto('D');
//   fsm.state;     // 'D'

// A full set of Lifecycle Events still apply when using goto.
// }
