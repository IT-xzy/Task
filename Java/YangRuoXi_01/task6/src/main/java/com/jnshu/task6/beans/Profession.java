package com.jnshu.task6.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Data
@Component
public class Profession {
    private Integer id;
    private String img;
    private String developmentDirectior;
    private String professionName;
    private String description;


}
