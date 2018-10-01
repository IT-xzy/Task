var gulp =require('gulp');
var cssmin=require("gulp-clean-css");
var concat =require('gulp-concat');
var rename=require('gulp-rename');
var sass=require('gulp-sass');
var jsmin =require('gulp-uglify');
var imgmin =require('gulp-imagemin');
var htmlmin  =require('gulp-htmlmin');
gulp.task('html', function() {
    gulp.src('src/*.html')
        .pipe(gulp.dest('lib'))
        .pipe(gulp.dest('dist'))
  });
gulp.task('scss',function(){
    gulp.src('src/scss/*.scss')
        .pipe(sass().on('error',sass.logError))
        .pipe(gulp.dest('lib/css'))
        .pipe(rename({suffix:".min"}))
        .pipe(cssmin())
        .pipe(gulp.dest('dist/css'))
});
gulp.task('uglify',function(){
    gulp.src('src/js/*.js')
        .pipe(gulp.dest('lib/js'))
        .pipe(jsmin())
        .pipe(rename({suffix:'.min'}))
        .pipe(gulp.dest('dist/js'))
});
gulp.task('imgmin',function(){
    gulp.src('src/img/*')
        .pipe(gulp.dest('lib/img'))
        .pipe(imgmin())
        .pipe(gulp.dest('dist/img'))

});
gulp.task('default',['html','scss','uglify','imgmin']);
gulp.task('watch',function(){
    gulp.watch('src/*html',['html']);
    gulp.watch('src/js/*.js',['uglify']);
    gulp.watch('src/scss/*.scss',['scss']);
});
