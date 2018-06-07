package mapper;

import POJO.Company;
import POJO.Cooperation;
import POJO.GreatStudent;
import POJO.HowToStudy;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 对应实现类
 * @create: 2018/5/7 下午5:45
 */

public interface OtherPageMapper {
    List<GreatStudent> findStudentByName();
    List<Cooperation> findCooperation();
    List<HowToStudy> findStudy();
    List<Company> findCompany();
}
