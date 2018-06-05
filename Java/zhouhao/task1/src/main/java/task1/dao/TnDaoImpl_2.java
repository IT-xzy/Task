package task1.dao;


import task1.domain.Trainees;

import java.util.List;

/**
 * @Author: Zhou Hao
 * @Date: 2018-5-19 14:00
 * @Description: DAO接口实现类，继承sqlSessionDaoSupport
 * @Modify:
 */

public class TnDaoImpl_2 extends BaseDao implements TnDao_2 {


    public Trainees findById(int id) {
        Trainees tn = this.getSqlSession().selectOne("trainees.findById", id);
        return tn;
    }

    public List<Trainees> findByName(String name) {
        List<Trainees> list = this.getSqlSession().selectList("trainees.findByName", name);
        return list;
    }

    public boolean addTrainees(Trainees tn) {
        if (tn.getName() == null || tn.getSenior() == null || tn.getNoturl() == null)
            throw new RuntimeException("必学输入姓名、师兄和日报链接信息");
        int i = this.getSqlSession().insert("trainees.addTrainees", tn);
        if (i > 0)
            return true;
        else
            return false;
    }

    public boolean updateTrainees(Trainees tn) {
        if (tn.getName() == null || tn.getSenior() == null || tn.getNoturl() == null)
            throw new RuntimeException("必学输入姓名、师兄和日报链接信息");
        int i = this.getSqlSession().update("trainees.updateTrainees", tn);
        if (i > 0)
            return true;
        else
            return false;
    }

    public boolean deleteById(int id) {
        int i = this.getSqlSession().delete("trainees.deleteById", id);
        if (i > 0)
            return true;
        else
            return false;
    }
}
