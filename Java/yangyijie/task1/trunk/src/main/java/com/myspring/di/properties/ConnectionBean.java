package com.myspring.di.properties;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Arike
 * Create_at 2017/11/29 19:25
 */
@Data
public class ConnectionBean {
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private Properties properties;
    private String [] strings;
}
