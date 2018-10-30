package com.jnshuboot.security.configure;

import com.jnshuboot.security.CustomUserService;
import com.jnshuboot.security.filterFile.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * TODO
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see
 * @since 2017.08.23
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("serviceRMI");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//关闭csrf认证
                .authorizeRequests() //任何请求所有认证
//                .anyRequest().permitAll()
                .antMatchers("s/user/**").hasAuthority("ROLE_USER")
                .antMatchers("s/admin/**").hasAuthority("ROLE_ADMIN")
                .and()
                .formLogin()// 表单登录
                .loginProcessingUrl("/denglu") // 登录 Action 的 URI
                .loginPage("/denglu") // 登录页面 URI
                .failureForwardUrl("/error")
                // 登录失败后的页面URI
                .and().logout().logoutUrl("/dengchu")//登出url
                .logoutSuccessUrl("/denglu");//登出后的跳转
//        http.authorizeRequests().anyRequest().permitAll();//任何请求不用认证
//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }

    @Bean
    UserDetailsService customUserService() { //注册UserDetailsService 的bean
        return new CustomUserService();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN")
//                .and().withUser("user").password("{noop}123456").roles("USER");
        auth.userDetailsService(customUserService()); //user Details Service验证
    }
}
