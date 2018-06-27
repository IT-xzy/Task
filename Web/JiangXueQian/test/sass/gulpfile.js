 var gulp = require('gulp');
 var sass = require('gulp-ruby-sass');

 gulp.task('sass', function(){
        return sass('scss/index.scss')// 编译文件
            .on('error', sass.logError) // 错误信息
             .pipe(gulp.dest('css'));//输出路径
        });
gulp.task('dist',function(){
        gulp.watch('./scss/*.scss',['sass']);// 监听的文件
});