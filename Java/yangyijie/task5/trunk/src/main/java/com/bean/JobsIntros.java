package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Arike
 * Create_at 2018/1/2 11:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class JobsIntros implements Serializable {
    private Long id;
    private Long createAt;
    private Long updateAt;
    private String intros;
}
