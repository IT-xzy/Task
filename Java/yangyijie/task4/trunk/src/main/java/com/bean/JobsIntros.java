package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author Arike
 * Create_at 2018/1/2 11:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class JobsIntros {
    private Long id;
    private Long createAt;
    private Long updateAt;
    private String intros;
}
