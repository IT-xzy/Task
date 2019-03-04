package com.jnshu.clroom.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class MonitorTime {
    private String className;
    private String methodName;
    private Date logTime;
    private long comsumeTime;
}
