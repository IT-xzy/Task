package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Arike
 * Create_at 2018/1/6 15:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class User implements Serializable {
    private Long id;
    private Long createAt;
    private Long updateAt;
    private String userName;
    private String passWord;
    private String salt;
    private String email;
}
