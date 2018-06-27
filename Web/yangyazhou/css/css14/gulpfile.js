/*!
 * gulp 所需插件
 * $ cnpm install gulp gulp-sass gulp-cached gulp-uglify gulp-rename gulp-concat gulp-notify gulp-filter jshint gulp-jshint gulp-rev-append gulp-csso gulp-imagemin browser-sync gulp-file-include gulp-autoprefixer del --save-dev
 */

// Load plugins
var gulp = require('gulp'), // 必须先引入gulp插件
    del = require('del'),  // 文件删除
    sass = require('gulp-sass'), // sass 编译
    cached = require('gulp-cached'), // 缓存当前任务中的文件，只让已修改的文件通过管道
    uglify = require('gulp-uglify'), // js 压缩
    rename = require('gulp-rename'), // 重命名
    concat = require('gulp-concat'), // 合并文件
    notify = require('gulp-notify'), // 相当于 console.log()
    filter = require('gulp-filter'), // 过滤筛选指定文件
    jshint = require('gulp-jshint'), // js 语法校验
    rev = require('gulp-rev-append'), // 插入文件指纹（MD5）
    csso = require('gulp-csso'), // CSS 压缩
    imagemin = require('gulp-imagemin'), // 图片优化
    browserSync = require('browser-sync'), // 保存自动刷新
    fileinclude = require('gulp-file-include'), // 可以 include html 文件
    autoprefixer = require('gulp-autoprefixer'), // 添加 CSS 浏览器前缀
    sequence = require('gulp-sequence'); // 使gulp任务按顺序执行

// sass
gulp.task('sass', function () {
    return gulp.src('src/sass/**/*.scss')  // 传入 sass 目录及子目录下的所有 .scss 文件生成文件流通过管道并设置输出格式
        .pipe(sass({ style: 'expanded' })) 
        .pipe(cached('sass'))  // 缓存传入文件，只让已修改的文件通过管道（第一次执行是全部通过，因为还没有记录缓存）
        .pipe(autoprefixer('last 6 version')) // 添加 CSS 浏览器前缀，兼容最新的5个版本
        .pipe(gulp.dest('dist/css')) // 输出到 dist/css 目录下（不影响此时管道里的文件流）
        .pipe(rename({ suffix: '.min' })) // 对管道里的文件流添加 .min 的重命名
        .pipe(csso()) // 压缩 CSS
        .pipe(gulp.dest('dist/css')) // 输出到 dist/css 目录下，此时每个文件都有压缩（*.min.css）和未压缩(*.css)两个版本
});

// css （拷贝 *.min.css，常规 CSS 则输出压缩与未压缩两个版本）
gulp.task('css', function () {
    return gulp.src('src/css/**/*.css')
        .pipe(cached('css'))
        .pipe(gulp.dest('dist/css')) // 把管道里的所有文件输出到 dist/css 目录
        .pipe(filter(['**/*', '!**/*.min.css'])) // 筛选出管道中的非 *.min.css 文件
        .pipe(autoprefixer('last 6 version'))
        .pipe(gulp.dest('dist/css')) // 把处理过的 css 输出到 dist/css 目录
        .pipe(rename({ suffix: '.min' }))
        .pipe(csso())
        .pipe(gulp.dest('dist/css'))
});  
 
// styleReload （结合 watch 任务，无刷新CSS注入）
gulp.task('styleReload', ['sass', 'css'], function () {
    return gulp.src(['dist/css/**/*.css'])
        .pipe(cached('style'))
        .pipe(browserSync.reload({ stream: true })); // 使用无刷新 browserSync 注入 CSS
});

// script （拷贝 *.min.js，常规 js 则输出压缩与未压缩两个版本）
gulp.task('script', function () {
    return gulp.src(['src/js/**/*.js'])
        .pipe(cached('script'))
        .pipe(gulp.dest('dist/js'))
        .pipe(filter(['**/*', '!**/*.min.js'])) // 筛选出管道中的非 *.min.js 文件
        // .pipe(jshint('.jshintrc')) // js的校验与合并，根据需要开启
        // .pipe(jshint.reporter('default'))
        // .pipe(concat('main.js'))
        // .pipe(gulp.dest('dist/js'))
        .pipe(rename({ suffix: '.min' }))
        .pipe(uglify())
        .pipe(gulp.dest('dist/js'))
});

// image
gulp.task('image', function () {
    return gulp.src('src/image/**/*.{jpg,jpeg,png,gif}')
        .pipe(cached('image'))
        .pipe(imagemin({ optimizationLevel: 3, progressive: true, interlaced: true, multipass: true }))
        // 取值范围：0-7（优化等级）,是否无损压缩jpg图片，是否隔行扫描gif进行渲染，是否多次优化svg直到完全优化
        .pipe(gulp.dest('dist/images'))
});

// html 编译 html 文件并复制字体
gulp.task('html', function () {
    return gulp.src('src/view/*.html')
        .pipe(fileinclude({
            prefix: '@@', //变量名前缀@@
            indent: 'true' //保留文本缩进
        })) // include html
        // .pipe(rev()) // 生成并插入 MD5 ！！！这里插入无效，占时未找到原因-2018.4.19
        .pipe(gulp.dest('dist/'))
});

// clean 清空 dist 目录
gulp.task('clean', function () {
    return del('dist/**/*');
});

// build，关连执行全部编译任务
gulp.task('build', sequence(['sass', 'css', 'script', 'image'], 'html'));

// default 默认任务，依赖清空任务
gulp.task('default', sequence('clean', 'build'));

// watch 开启本地服务器并监听
gulp.task('watch', function () {
    browserSync.init({
        server: {
            baseDir: 'dist' // 在 dist 目录下启动本地服务器环境，自动启动默认浏览器
        }
    });

    // 监控 SASS 文件，有变动则执行CSS注入
    gulp.watch('src/sass/**/*.scss', ['styleReload']);
    // 监控 CSS 文件，有变动则执行CSS注入
    gulp.watch('src/css/**/*.css', ['styleReload']);
    // 监控 js 文件，有变动则执行 script 任务
    gulp.watch('src/js/**/*.js', ['script']);
    // 监控图片文件，有变动则执行 image 任务
    gulp.watch('src/img/**/*', ['image']);
    // 监控 html 文件，有变动则执行 html 任务
    gulp.watch('src/**/*.html', ['html']);
    // 监控 dist 目录下除 css 目录以外的变动（如js，图片等），则自动刷新页面
    gulp.watch(['dist/**/*', 'dist/css/**/*']).on('change', browserSync.reload);

});