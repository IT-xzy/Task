package com.mysql.springjdbc.daoimpl;

import com.mysql.springjdbc.bean.Department;
import com.mysql.springjdbc.dao.DepartmentDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentImplDAO implements DepartmentDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Department> queryDepartment() throws Exception {
        Connection conn = dataSource.getConnection();

        String sql = "Select d.dept_id, d.dept_no, d.dept_name from department d";

        Statement smt = conn.createStatement();

        ResultSet rs = smt.executeQuery(sql);
        List<Department> list= new ArrayList<Department>();
        while (rs.next()) {
            Long deptId = rs.getLong("dept_id");
            String deptNo = rs.getString("dept_no");
            String deptName = rs.getString("dept_name");
            Department dept = new Department(deptId, deptNo, deptName);
            list.add(dept);
        }
        return list;
    }
}
