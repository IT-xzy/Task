//初始化变量

var gulp = require('gulp');
var gulpLoad = require('gulp-load-plugins');
var $ = gulpLoad();
var del = require('del');
var stylish = require('jshint-stylish');
let lazypipe = require('lazypipe');
//设置路径，开发目录bulid,发布目录dist，源目录src
var src = './src',
    bulid = './bulid',
    dist = './dist',
    rev = './rev';
var path = {
    html: {
        src: src + '/*.html',
        bulid: bulid,
        dist: dist
    },
    scss: src + '/scss/*.scss',
    css: {
        bulid: bulid + '/css',
        dist: dist + '/css'
    },
    js: {
        src: src + '/js/*.js',
        bulid: bulid + '/js',
        dist: dist + '/js'
    },
    img: {
        src: src + '/img/**/*',
        bulid: bulid + '/img',
        dist: dist + '/img'
    },
    video: src + '/**/*.mp3'
};
//定义清除文件目录的对象
let clean = {
    //开发目录
    bulid: function (done) {
        del([bulid]);
        done();
    },
    //发布目录
    dist: function (done) {
        del([dist]);
        done();
    },
    //dev目录
    rev: function (done) {
        del([rev]);
        done();
    },
    //除源目录以外的目录一起删除
    all: function (done) {
        del([dist, rev, bulid]);
        done();
    }
}

//html,css,js,img图片进入开发目录的过程，这里面没有对相关文件进行压缩，以及添加MD5签名
var develop = {
    html: function () {
        return gulp.src(path.html.src)
            .pipe($.plumber())
            .pipe(gulp.dest(path.html.bulid))
            .pipe(gulp.dest(path.html.dist));
    },
    css: function () {
        return gulp.src(path.scss)
            .pipe($.sass().on('error', $.sass.logError))
            .pipe(gulp.dest(path.css.bulid))
    },
    js: function () {
        return gulp.src(path.js.src)
            .pipe($.plumber())
            .pipe($.jshint())
            .pipe($.jshint.reporter(stylish))
            .pipe(gulp.dest(path.js.bulid))
    },
    img: function () {
        return gulp.src(path.img.src)
            .pipe(gulp.dest(path.img.bulid))
            .pipe($.imagemin())
            .pipe(gulp.dest(path.img.dist));
    },
    video: function () {
        return gulp.src(path.video)
            .pipe(gulp.dest(bulid))
            .pipe(gulp.dest(dist));
    }
};
//定义压缩css js以及添加版本号，使用gulp-useref和gulp-if
var onLine = {
    //压缩css
    css: function () {
        return gulp.src(path.css.bulid + '/*.css')
            .pipe($.sourcemaps.init())
            .pipe($.cleanCss())
            .pipe($.rev())
            .pipe($.sourcemaps.write())
            .pipe(gulp.dest(path.css.dist))
            .pipe($.rev.manifest())
            .pipe(gulp.dest(rev + '/css'))
    },
    //压缩js
    js: function () {
        return gulp.src(path.js.bulid + '/*.js')
            .pipe($.sourcemaps.init())
            .pipe($.plumber())
            .pipe($.uglify())
            .pipe($.sourcemaps.write())
            .pipe($.rev())
            .pipe(gulp.dest(path.js.dist))
            .pipe($.rev.manifest())
            .pipe(gulp.dest(rev + '/js'))
    },
    //添加MD5签名
    collector: function () {
        return gulp.src([rev + '/**/*.json', dist + '/**/*.html'])
            .pipe($.revCollector({
                replaceReved: true
            }))
            .pipe(gulp.dest(dist))
    }
};
//定义清除开发目录的任务
gulp.task('clean-dev', clean.bulid);
gulp.task('clean-dist', clean.dist);
gulp.task('clean-all', clean.all);

//定义开发任务
gulp.task('html', develop.html);
gulp.task('de-css', develop.css);
gulp.task('de-js', develop.js);
gulp.task('img', develop.img);
gulp.task('video', develop.video);
gulp.task('develop', gulp.series('clean-dev', gulp.parallel('html', 'img', 'video', 'de-css', 'de-js')));

//定义发布任务
gulp.task('online-css', onLine.css);
gulp.task('online-js', onLine.js);
gulp.task('collector', onLine.collector);
gulp.task('online', gulp.series('develop', gulp.parallel('online-css', 'online-js'), 'collector'));


//定义gulp.watch任务
gulp.task('watch', function (done) {
    gulp.watch(path.img.src,develop.img);
    gulp.watch(path.html.src, develop.html);
    gulp.watch(path.scss, develop.css);
    gulp.watch(path.js.src, develop.js);
});
//定义最终的default任务
gulp.task('default', gulp.series('clean-all', 'develop', gulp.parallel('online-css', 'online-js'), 'collector'));