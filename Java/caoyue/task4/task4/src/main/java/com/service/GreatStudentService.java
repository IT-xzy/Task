package com.service;

import java.io.IOException;
import java.util.List;
import com.POJO.GreatStudent;

/**
 * @author: 曹樾
 * @program: task4
 * @description: 优秀学员
 * @create: 2018/4/24 下午4:00
 */

public interface GreatStudentService {
    public List<GreatStudent> findUserByName() throws IOException;
}
