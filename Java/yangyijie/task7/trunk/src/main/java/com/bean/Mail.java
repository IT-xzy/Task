package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Arike
 * Create_at 2018/1/21 10:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
    private String address;
    private String name;
    private String url;
}
