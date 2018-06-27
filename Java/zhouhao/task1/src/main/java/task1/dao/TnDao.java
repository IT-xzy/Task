package task1.dao;


import org.springframework.stereotype.Repository;
import task1.domain.Trainees;

import java.util.List;

/**
 * @Author: Zhou Hao
 * @Date: 2018-5-19 14:00
 * @Description: DAO接口，定义了对学员Trainees数据的操作
 * @Modify:
 */

@Repository
public interface TnDao {

    public Trainees findById(int id);//根据主键ID查询单个学员信息

    public List<Trainees> findByName(String name);//根据姓名name查询多个学员信息

    public void addTrainees(Trainees tn);//添加学员信息到数据库,成功返回true

    public void updateTrainees(Trainees tn);//根据主键ID更新单个学员信息

    public void deleteById(int id);//根据主键ID删除学员记录,成功返回true

}
