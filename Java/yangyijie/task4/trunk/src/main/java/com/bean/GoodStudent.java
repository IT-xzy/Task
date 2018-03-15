package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author Arike
 * Create_at 2017/12/28 15:43
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodStudent {
    private Long id;
    private Long createAt;
    private Long updateAt;
    private String name;
    private String job;
    private String head;
    private String intro;
}
