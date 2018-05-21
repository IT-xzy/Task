package com.myspring.ioc_zero;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author Arike
 * Create_at 2017/12/1 10:57
 */
@Component()
@Data
public class Bean2 {
    public Bean2() {
        System.out.println("Bean2构造");
    }
}
