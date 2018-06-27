package mapper;

import POJO.Profession;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 对应实现类
 * @create: 2018/5/7 下午5:46
 */

public interface ProfessionMapper {
    List<Profession> findFront();
    List<Profession> findAfter();
    List<Profession> findOP();
    List<Profession> findPM();
}
