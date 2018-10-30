package com.jnshutask.util;

import lombok.Data;

@Data
public class Page {
    private Integer pageNum;
    private Integer pageHome;
    private Integer pageLast;
    private Integer pageNext;
    private Integer pageFinal;
    private Integer pageNumTotal;
}
