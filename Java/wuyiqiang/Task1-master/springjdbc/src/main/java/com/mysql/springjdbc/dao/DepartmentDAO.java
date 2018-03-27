package com.mysql.springjdbc.dao;

import java.util.List;
import com.mysql.springjdbc.bean.Department;

public interface DepartmentDAO {

    public List<Department> queryDepartment() throws Exception;

}
