package com.lihoo.jnshu.admin.dao;

import com.lihoo.jnshu.admin.domain.StudentList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihoo
 * @since 2018-09-28
 */
@Component
public interface StudentListMapper extends BaseMapper<StudentList> {

    Long updateLoginTimeById(StudentList record);

}
