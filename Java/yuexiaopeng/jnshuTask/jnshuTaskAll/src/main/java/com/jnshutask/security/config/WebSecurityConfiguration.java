package com.jnshutask.security.config;

import com.jnshutask.security.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("serviceRMI");
    }
    @Autowired(required = false)
    TaSecurityProperties taSecurityProperties;
    @Autowired(required = false)
    TaUserDetailsServiceImp taUserDetailsServiceImp;
    // 数据库处理 rememberMe 自动登录认证；使用缓存的记住我功能
    @Autowired(required = false)
    private DataSource dataSource;
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();

        jdbcTokenRepository.setDataSource(dataSource);
        //true表示在数据库创建表；
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }
    //使用自定义失效session策略，指定失效后的重定向网址
    @Bean
    public InvalidSessionStrategy invalidSessionStrategy(){
        return new TaInvalidSessionStrategy();
    }
    //使用自定义失效session策略，处理并发登陆
    @Bean
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new TaExpiredSessionStrategy();
    }
    //session注册中心
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //将路径拆分成单个字符
        String[] anonResourcesUrl =
                StringUtils.splitByWholeSeparatorPreserveAllTokens(taSecurityProperties.getAnonResourcesUrl(),",");

        http
                .csrf().disable()//关闭csrf认证
                .authorizeRequests() //任何请求所有认证
                .antMatchers(anonResourcesUrl).permitAll()//不认证资源
                .anyRequest().authenticated()
                .and()
                .formLogin()// 表单登录
                .loginProcessingUrl(taSecurityProperties.getLoginUrl()) // 登录 Action 的 URI
                .loginPage(taSecurityProperties.getLoginUrl()) // 登录页面 URI
                .successForwardUrl("/bsHome")
                .failureForwardUrl("/error")
                .and()
                .rememberMe() // 添加记住我功能
                .tokenRepository(persistentTokenRepository()) // 配置 token 持久化仓库
                .tokenValiditySeconds(taSecurityProperties.getRememberMeTimeout()) // rememberMe 过期时间，单为秒
                .userDetailsService(taUserDetailsServiceImp) // 处理自动登录逻辑
                .and()
                .sessionManagement()//配置 session管理器
                .invalidSessionStrategy(invalidSessionStrategy())//处理 session失效,可不配，使用默认
                .maximumSessions(taSecurityProperties.getMaximumSessions())//最大并发登录数
                .expiredUrl("/login")//失效后的重定向地址
//                .expiredSessionStrategy(sessionInformationExpiredStrategy())//处理并发登录被踢出后的吹,自定义类
//                .maxSessionsPreventsLogin(false)//false后登录踢掉前登录,true则不允许之后登录，默认为false
                .sessionRegistry(sessionRegistry())//配置 session注册中心，可不配，使用默认
                .and()
                // 登录失败后的页面URI
                .and()
                .logout().logoutUrl(taSecurityProperties.getLogoutUrl())//登出url
                .logoutSuccessUrl(taSecurityProperties.getLoginUrl());//登出后的跳转
//        http.authorizeRequests().anyRequest().permitAll();//任何请求不用认证
//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }


    // spring security自带的密码加密工具类
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN")
//                .and().withUser("user").password("{noop}123456").roles("USER");
        //user Details Service验证,指定使用默认密码加密方式；不指定为默认；
        auth.userDetailsService(taUserDetailsServiceImp).passwordEncoder(passwordEncoder());
    }
}
