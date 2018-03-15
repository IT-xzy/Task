package com.myspring.ioc_zero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arike
 * Create_at 2017/12/1 10:57
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bean1 {
    @Autowired
    private Bean2 bean2;
    
}
