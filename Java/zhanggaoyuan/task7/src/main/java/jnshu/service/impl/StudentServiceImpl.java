package jnshu.service.impl;

import com.alibaba.fastjson.JSON;
import jnshu.dao.RestUserMapper;
import jnshu.dao.StudentMapper;
import jnshu.model.RestUser;
import jnshu.model.Student;
import jnshu.service.StudentService;
import jnshu.tool.MD5;
import jnshu.tool.TokenUtil;
import jnshu.tool.redis.RedisTakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Administrator
 */
@Service
public class StudentServiceImpl implements StudentService {
    private static Logger logger = Logger.getLogger (String.valueOf (StudentServiceImpl.class));
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RestUserMapper userMapper;
    @Autowired
    RedisTakes redisTakes;
    long timeStamp = System.currentTimeMillis ();

    @Override
    public int insertStudent(Student record) {
        return studentMapper.insert (record);
    }

    /**
     * 查询优秀学员信息
     *
     * @return优秀学员信息
     */
    @Override
    public List<Student> selectStudent() {
        List es = studentMapper.selectStudent ();
        return es;
    }

    /**
     * 注册
     *
     * @param record 角色信息
     * @return 0或1
     */
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
        List<Student> list1 = studentMapper.selectInfo ();
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
    public int insertInfo(Student record) {
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
    public int updateByPrimaryKeySelective(Student record) {
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
    public List<Student> selectByName(String name) {
        List<Student> list = studentMapper.selectByName (name);
        return list;
    }

    /**
     * 根据姓名更新个人信息
     *
     * @param record
     * @return
     */
    @Override
    public int updateByName(RestUser record) {
        return userMapper.updateByName (record);
    }

    @Override
    public RestUser userMd5(RestUser restUser) {

        restUser.setCreatTime (timeStamp);
        restUser.setUpdateTime (timeStamp);
        logger.info (JSON.toJSONString (restUser));

//        给密码加密
        String salt = MD5.salt ();//生成盐
        String pwd = MD5.encoder (restUser.getPwd (), salt);//得到加密后的密码
        restUser.setPwd (pwd);
        restUser.setSalt (salt);
        logger.info ("加密后的信息为"+JSON.toJSONString (restUser));
        return restUser;
    }

    @Override
    public Map login(RestUser restUser) {
        logger.info ("传进loginImpl的值为"+JSON.toJSONString (restUser));
        RestUser rs1 = selectUserByName (restUser.getName ()); //查询登录角色

        String eToken = TokenUtil.makeToken (rs1.getId (), TokenUtil.jSalt ());//生成加盐的token，用的是粗盐......
        logger.info ("生成加密后的的token是：" + eToken);

        Cookie cookie = new Cookie ("token", eToken);
        String sds = null;
        try {
            sds = URLEncoder.encode (restUser.getName (), "utf-8");
        } catch ( UnsupportedEncodingException e ) {
            logger.info ("编码失败");
            e.printStackTrace ();
        }
        Cookie cookie1 = new Cookie ("status", sds);
        logger.info ("登录时存进去的status是：" + JSON.toJSONString (cookie1));
        Map map = new HashMap ();

        map.put ("cookie", cookie);
        map.put ("cookie1", cookie1);

        return map;
    }

}
