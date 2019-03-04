package com.jnshu.task4.beans;

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

    //重写equals方法;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profession that = (Profession) o;

        return developmentDirectior != null ? developmentDirectior.equals(that.developmentDirectior) : that.developmentDirectior == null;
    }

    @Override
    public int hashCode() {
        return developmentDirectior != null ? developmentDirectior.hashCode() : 0;
    }
}
