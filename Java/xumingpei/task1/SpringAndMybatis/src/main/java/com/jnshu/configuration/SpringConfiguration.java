package com.jnshu.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author pipiretrak
 * @date 2019/1/3 - 16:21
 */
@Configuration //表示配置文件类
@ComponentScan("com.jnshu") //扫描的包，代替<context:component-scan base-package="com.jnshu"/>
@PropertySource(value = {"classpath:db.properties",},ignoreResourceNotFound = true) //添加指定的配置文件
@MapperScan(basePackages = {"com.jnshu.dao"},sqlSessionFactoryRef = "sqlSessionFactory") //指导需要注入数据原的包路径
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driverClass;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;
    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl(jdbcUrl);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        return comboPooledDataSource;
    }

    @Bean// 带参数的bean ,有参数的bean方法。 spring会从ioc中找对应的bean注入，如果ioc中没有会报错
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new org.mybatis.spring.SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setTypeAliasesPackage("com.jnshu.dao");
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:StudentMapper.xml"));
        return sessionFactoryBean;
    }
}
