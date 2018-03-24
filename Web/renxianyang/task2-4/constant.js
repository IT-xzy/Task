app.constant('softHeader', {
    //没有图片的 URL给 image/none/none.png
    home: {
        left: {
            imgSrc: 'image/header/indexHeader.png',
            uiSref: ''
        },
        center: {
            content: '',
            uiSref: ''
        },
        right: {
            imgSrc: 'image/header/headerbar-sigh.png',
            uiSref: ''
        },
        bodyBg: '#f0f0f0',
    },
    setPlayerNumber: {
        left: {
            imgSrc: 'image/header/headerbar-back.png',
            uiSref: 'home'
        },
        center: {
            content: '参数设置',
            uiSref: ''
        },
        right: {
            imgSrc: 'image/header/headerbar-doubt.png',
            uiSref: ''
        },
        bodyBg: '#f0f0f0',
    },
    checkSelf: {
        left: {
            imgSrc: 'image/header/headerbar-back.png',
            uiSref: ''
        },
        center: {
            content: '查看身份',
            uiSref: ''
        },
        right: {
            imgSrc: 'image/header/headerbar-close.png',
            uiSref: 'home'
        },
        bodyBg: '#f0f0f0',
    },
    checkAll: {
        left: {
            imgSrc: 'image/header/headerbar-back.png',
            uiSref: ''
        },
        center: {
            content: '法官日记',
            uiSref: ''
        },
        right: {
            imgSrc: 'image/header/headerbar-close.png',
            uiSref: 'home'
        },
        bodyBg: '#29bde0',
    },
    easyKillGamePlay: {
        left: {
            imgSrc: 'image/header/headerbar-back.png',
            uiSref: ''
        },
        center: {
            content: '杀手杀人',
            uiSref: ''
        },
        right: {
            imgSrc: 'image/header/headerbar-close.png',
            uiSref: 'home'
        },
        bodyBg: '#29bde0',
    },
    easyKillGameLog: {
        left: {
            imgSrc: 'image/header/headerbar-back.png',
            uiSref: ''
        },
        center: {
            content: '法官日记',
            uiSref: ''
        },
        right: {
            imgSrc: 'image/header/headerbar-close.png',
            uiSref: 'home'
        },
        bodyBg: '#f0f0f0',
    },
}).constant('games', {
    ghostGame: [
        {
            gameName: '简化版',
            uiSref: '',
        },
        {
            gameName: '猜词版',
            uiSref: '',
        },
        {
            gameName: '白痴版',
            uiSref: '',
        }
    ],
    killGame: [
        {
            gameName: '简化版',
            uiSref: 'easyKillGame',
        },
        {
            gameName: '猜词版',
            uiSref: '',
        },
        {
            gameName: '白痴版',
            uiSref: '',
        }
    ],
})