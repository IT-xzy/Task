package com.mysql.springjdbc;

import com.mysql.springjdbc.bean.Department;
import com.mysql.springjdbc.dao.DepartmentDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainDemo {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-module.xml");

        DepartmentDAO deptDAO = (DepartmentDAO) context
                .getBean("departmentDAO");

        List<Department> depts = deptDAO.queryDepartment();

        for (Department dept : depts) {
            System.out.println("Dept ID " + dept.getDeptId());
            System.out.println("Dept No " + dept.getDeptNo());
            System.out.println("Dept Name " + dept.getDeptName());
        }
    }

}
