package com.mutesaid.rmi_demo_core.model;


import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * students
 *
 * @author
 */
@Data
public class Student implements Serializable {
    private Long id;

    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull(message = "QQ不能为空")
    @Min(value = 10000, message = "QQ位数不能小于5位")
    @Max(value = 9999999999L, message = "QQ位数不能大于10位")
    private Long qq;

    private String type;

    private String timeOf;

    private String gradeSchool;

    private String onlineId;

    private String link;

    private String wish;

    private String fellow;

    private String understand;

    private Long createAt;

    private Long updateAt;

    private static final long serialVersionUID = 1L;
}
