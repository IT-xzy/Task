//引用模块
const gulp = require('gulp');
const $ = require('gulp-load-plugins')();
const del = require('del');
const stylish = require('jshint-stylish');

//初始目录,开发目录bulid,上线目录dist,源目录src
const src = './app/src';
const bulid = './app/bulid';
const dist = './app/dist';
const rev = './app/rev';
//目录对象
const path = {
    //源目录
    src: {
        html: src + '/*.html',
        scss: src + '/scss/*.scss',
        img: src + 'img/**/*',
        js: src + 'js/*.js'
    },
    //开发目录
    bulid: {
        html: bulid,
        css: bulid + '/css',
        js: bulid + '/js',
        img: bulid + '/img'
    },
    //上线目录
    dist: {
        html: dist,
        css: dist + '/js',
        js: dist + '/js',
        img: dist + '/img'
    },
    rev:{
        css:'/css',
        js:'/js'
    }
};


//gulp的删除的命令
const clean = {
    //删除开发目录，使用回调函数
    // bulid: function (done) {
    //     del([bulid]);
    //     done();
    // },
    //返回一个文件流 
    bulid: function () {
        return del([bulid]);
    },
    //删除上线目录
    dist: function (done) {
        del([rev, dist]);
        done();
    },
    //删除所有目录
    all:function(done){
        del([rev,dist,bulid]);
        done()
    }
};
//定义开发目录里用到的函数
const develop = {
    //html任务
    html: function () {
        return gulp.src(path.src.html)
            .pipe($.plumber())
            .pipe(gulp.dest(path.bulid));
    },
    //css文件
    css: function () {
        return gulp.src(path.src.scss)
            .pipe($.debug()) //读取文件
            .pipe($.sourcemaps.init()) //写入sourcemaps
            .pipe($.sass().on('error', sass.logError)) //编译sass
            .pipe($.autoprefixer({ //添加前缀
                browsers: ['last 2 versions'],
                cascade: false
            }))
            .pipe($.sourcemaps.write()) //输出sourcemaps
            .pipe(gulp.dest(path.bulid.css))
    },
    //js文件
    js: function () {
        return gulp.src(path.src.js)
            .pipe($.plumber())
            .pipe($.jshint())
            .pipe($.jshint.report(stylish))
            .pipe(gulp.dest(path.bulid.js));
    },
    //img文件
    img: function () {
        return gulp.src(path.src.img)
            .pipe(gulp.dest(path.bulid.img));

    }

};

//定义上线目录中要使用的函数
const online = {
    //css任务
    css: function () {
        return gulp.src(path.src.scss)
            .pipe($.sass().on('error', $.sass.logError)) //编译sass
            .pipe($.autoprefixer({ //添加前缀
                browsers: ['last 2 versions'],
                cascade: false
            }))
            .pipe($.sourcemaps.init())
            .pipe($.cleanCss())
            .pipe($.rev())
            .pipe($.sourcemaps.write())
            .pipe(path.dist.css)
            .pipe($.rev.manifest())
            .pipe(gulp.dest(path.rev.css))
    },
    //js任务
    js: function () {
        return gulp.src(path.bulid.js + '/*.js')
            .pipe($.sourcemaps.init())
            .pipe($.uglify()) 
            .pipe($.rev())
            //压缩js
            // .pipe($.concat('all.min.js')) //合并所有的js
            .pipe($.sourcemaps.write())
            .pipe(path.dist.js)
            .pipe($.rev.manifest())
            .pipe(gulp.dest(path.rev.js));
    },
    //img任务
    img: function () {
        return gulp.src(path.src.img)
            .pipe($.imgagemin()) //图片压缩
            .pipe(gulp.dest(path.dist.img));
    },
    //md5签名任务
    rev:function(){
        return gulp.src(['rev/**/*.json',path.src.html])
            .pipe($.revCollector({
                replaceReved:true
            }))
            .pipe(gulp.dest(dist));
    }
};

//定义clean任务
gulp.task('cleanB',clean.bulid); //清除开发目录
gulp.task('cleanD',clean.dist);  //清除上线目录
gulp.task('cleanA',clean.all);   //清除开发上线目录

//定义开发任务
gulp.task('dev-html',develop.html); 
gulp.task('dev-css',develop.css);
gulp.task('dev-js',develop.js);
gulp.task('dev-img',develop.img);
//定义一个完整开发任务
gulp.task('dev',gulp.series('cleanB',gulp.parallel(
    'dev-html',
    'dev-css',
    'dev-js',
    'dev-img'
)));




//定义上线任务
gulp.task('online-css',online.css);
gulp.task('online-js',online.js);
gulp.task('online-img',online.img);
gulp.task('online-rev',online.rev);
//定义一个完整的上线任务
gulp.task('online',gulp.series('cleanA',gulp.parallel(
    'online-css',
    'online-js',
    'online-img'
),'online-rev'));

//定义一个监听任务
gulp.task('watch',function(done){
    //只运行开发目录
    gulp.watch(path.src.js,gulp.parallel('dev-js'));
    gulp.watch(path.src.scss,gulp.parallel('dev-css'));
    gulp.watch(path.src.html,gulp.parallel('dev-html'));
    gulp.watch(path.src.img,gulp.parallel('dev-img'));
    done();
})