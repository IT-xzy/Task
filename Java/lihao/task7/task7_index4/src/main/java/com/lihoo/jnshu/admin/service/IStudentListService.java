package com.lihoo.jnshu.admin.service;

import com.lihoo.jnshu.admin.domain.StudentList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihoo
 * @since 2018-09-28
 */
@Component
public interface IStudentListService extends IService<StudentList> {

    Long updateLoginTimeById(StudentList studentList);

    Boolean verifyPwd(StudentList studentList);

}
