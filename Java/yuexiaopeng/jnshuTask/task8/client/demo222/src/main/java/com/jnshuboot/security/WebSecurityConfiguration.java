//package com.example111.demoboot.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * TODO
// *
// * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
// * @see
// * @since 2017.08.23
// */
//@Configuration
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////        //CSRF
////        http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository()).requireCsrfProtectionMatcher(
////                httpServletRequest -> httpServletRequest.getMethod().equals("POST")
////        );
////
////        // CSP header
////        http.headers().contentSecurityPolicy("script-src https://code.jquery.com/");
////
////        // X-Frame-Options header
////        // 相同域名是允许的
////        // http.headers().frameOptions().sameOrigin();
////
////        // 实现白名单方式
////        http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new AllowFromStrategy() {
////            @Override
////            public String getAllowFromValue(HttpServletRequest request) {
////                return "xiaomage.com";
////            }
////        }));
////
////        // XSS header
////        http.headers().xssProtection().block(false);
//
//
////        // 授权
////        http.authorizeRequests().anyRequest().fullyAuthenticated()
////                .and().
////                formLogin().usernameParameter("name") // 用户名参数
////                .passwordParameter("pwd") // 密码参数
////                .loginProcessingUrl("/loginAction") // 登录 Action 的 URI
////                .loginPage("/login") // 登录页面 URI
////                .failureForwardUrl("/error") // 登录失败后的页面URI
////                .permitAll()
////                .and().logout().permitAll();
//        http
////                .csrf().disable()//禁用csrf验证；
//                .authorizeRequests()//所有请求验证
//                .antMatchers("/index","/css/**").permitAll()//不需要验证的路径
//                .antMatchers("/user/**").hasRole("USER")// 需要用户权限的路径
//                .antMatchers("/admin/**").hasRole("admin")//需要admin权限的路径
//                .and().formLogin()
//                .loginPage("/login")// 登录页面 URI
//                .failureForwardUrl("/error") // 登录失败后的页面URI
//                .and().logout().permitAll();
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("{noop}123456").roles("admin")
//                .and()
//                .withUser("user").password("{noop}password").roles("USER");
//
//    }
//}
