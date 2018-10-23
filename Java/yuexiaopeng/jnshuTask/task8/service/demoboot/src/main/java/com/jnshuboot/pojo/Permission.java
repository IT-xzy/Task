package com.jnshuboot.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Created by yangyibo on 17/1/20.
 */
@Component
@Data
public class Permission {

    private int id;
    //权限名称
    private String name;

    //权限描述
    private String description;

    //授权链接
    private String url;

    //父节点id
    private int pid;


}
