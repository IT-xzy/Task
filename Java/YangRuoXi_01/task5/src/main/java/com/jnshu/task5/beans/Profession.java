package com.jnshu.task5.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
public class Profession  implements Serializable{
    private Integer id;
    private String img;
    private String developmentDirectior;
    private String professionName;
    private String description;


}
