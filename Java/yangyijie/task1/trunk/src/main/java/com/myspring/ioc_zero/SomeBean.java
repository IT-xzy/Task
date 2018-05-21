package com.myspring.ioc_zero;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.myJDBC.util.DruidUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Arike
 * Create_at 2017/12/1 10:57
 */
@Data
@Configuration
@ComponentScan(basePackages = "com.myspring.ioc_zero")
public class SomeBean {
   
   /* @Bean
    public Bean1 bean1(Bean2 bean2) {
        return new Bean1(bean2);
    }*/
   /* @Bean
    public Bean2 bean2() {
        return new Bean2();
    }*/
    @Bean()
    public DataSource getDruid() throws Exception {
        Properties properties = new Properties();
        InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(in);
        in.close();
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        return ds;
        
    }
    
}
