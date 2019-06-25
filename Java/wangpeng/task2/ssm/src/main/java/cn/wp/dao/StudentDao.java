package cn.wp.dao;

import cn.wp.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: StudentDao
 * @Description: dao接口
 * @Author: 老王
 * @Date: 2019/4/27 15:37
 * @Version: 1.0
 */
public interface StudentDao {
    /**
     * @Author: wp
     * @Description: 增
     * @Param: [student]
     * @return: int
     * @Exception:
     * @Date: 2019/4/27 15:51
     **/
    int add(Student student);

    boolean delete(int id);

    boolean update(Student student);

    List<Student> findAll();

    Student findById(int id);

    /**
     * 获取我想要的得到的数据，在接口中方法如果有两个参数，每个参数前需要加@Param
     */
    List<Student> selectProductsPage(@Param("startNum") int first, @Param("pageSize") int second);

    /**
     * 数据库里总共有多少条
     */
    int selectCount();

    int selectRom();
}


