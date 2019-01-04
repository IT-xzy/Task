package jnshu.service.impl;

import com.alibaba.fastjson.JSON;
import jnshu.dao.ExcellentStudentMapper;
import jnshu.dao.RestUserMapper;
import jnshu.model.ExcellentStudent;
import jnshu.model.RestUser;
import jnshu.service.StudentService;
import jnshu.tool.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author Administrator
 */
@Service
public class StudentServiceImpl implements StudentService {
    private static Logger logger = Logger.getLogger (String.valueOf (StudentServiceImpl.class));
    @Autowired
    ExcellentStudentMapper studentMapper;
    @Autowired
    RestUserMapper userMapper;

    @Override
    public int insertStudent(ExcellentStudent record) {
        return studentMapper.insert (record);
    }

    /**
     * 查询优秀学员信息
     *
     * @return优秀学员信息
     */
    @Override
    public List<ExcellentStudent> selectStudent() {
        return studentMapper.selectStudent ();
    }


    //    注册
    @Override
    public int insertUser(RestUser record) {

        return userMapper.insert (record);
    }

    @Override
    public RestUser selectUserByName(String name) {
        return userMapper.selectByName (name);
    }

    /**
     * 判断登录角色是否存在，密码是否正确
     *
     * @param name 角色的名字
     * @param pwd  密码
     * @return
     */
    @Override
    public Boolean exists(String name, String pwd) {

        RestUser rs = userMapper.selectByName (name);
        //判断角色是否存在，空则返回false
        if (rs == null) {
            return false;
        }

        //判断密码是否正确，正确则返回true
        if (MD5.verify (rs.getPwd (), pwd, rs.getSalt ())) {
            return true;
        }

        return false;
    }

    /**
     * @return学员信息
     */
    @Override
    public List selectInfo() {
        logger.info ("进入selectInfo方法");

        List<ExcellentStudent> list1 = studentMapper.selectInfo ();
        return list1;
    }

    /**
     * 删除学员信息
     *
     * @param id 学员id
     * @return 成功返回0
     */
    @Override
    public int deleteStudent(Long id) {
        int rs = studentMapper.deleteByPrimaryKey (id);
        return rs;
    }

    /**
     * 新增学员信息
     *
     * @param record 学员信息
     * @return
     */
    @Override
    public int insertInfo(ExcellentStudent record) {
        int rs = studentMapper.insert (record);
        return rs;
    }

    /**
     * 更新
     *
     * @param record 需要更新的学员信息
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(ExcellentStudent record) {
        logger.info ("进入updateByPrimaryKeySelective方法" + JSON.toJSONString (record));
        int rs = studentMapper.updateByPrimaryKeySelective (record);
        return rs;
    }

    /**
     * 查询学员信息
     *
     * @param name 学员名字
     * @return 学员记录
     */
    @Override
    public List<ExcellentStudent> selectByName(String name) {
        logger.info ("进入姓名查询" + name);

        List rs = studentMapper.selectByName (name);
        return rs;
    }
}
