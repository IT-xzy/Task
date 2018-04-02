package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Arike
 * Create_at 2018/1/16 08:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Test implements Serializable {
    private static final long serialVersionUID=1L;
    private String name;
    private String age;
}
