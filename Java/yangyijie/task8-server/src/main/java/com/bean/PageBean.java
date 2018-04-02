package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/22 10:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class PageBean<T> implements Serializable{
    private static final long serialVersionUID=1L;
    private int currPage;//当前页数
    private int pageSize;//每页显示的记录数
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private List<T> lists;//每页接收的数据
    private List<StudentPut> list;//每页显示的数据
    
}
