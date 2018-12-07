package jnshu.service.impl;

import com.alibaba.fastjson.JSON;
import jnshu.dao.ExcellentStudentMapper;
import jnshu.dao.RestUserMapper;
import jnshu.model.ExcellentStudent;
import jnshu.model.RestUser;
import jnshu.service.StudentService;
import jnshu.tool.MD5;
import jnshu.tool.memcache.MemcacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
@Service
public class StudentServiceImpl implements StudentService {
    private static Logger logger = Logger.getLogger (String.valueOf (StudentServiceImpl.class));
    @Autowired
    ExcellentStudentMapper studentMapper;
    @Autowired
    RestUserMapper userMapper;
    @Autowired
    MemcacheUtil memcacheUtil;


    @Override
    public int insertStudent(ExcellentStudent record) {
        return studentMapper.insert (record);
    }

//    /**
//     *     查询优秀学员信息
//     * @return优秀学员信息
//     */
//    @Override
//    public List<ExcellentStudent> selectStudent() {
////        List<ExcellentStudent> list = (List<ExcellentStudent>) memcacheUtil.getMemcache ("excellentStudent");
//
////        if (list==null){
//            List es=studentMapper.selectStudent ();
////            memcacheUtil.saveMemcache ("excellentStudent", 1800, es);
//            return es;
////        }
////        return list;
//        }
    /**
     *     查询优秀学员信息
     * @return优秀学员信息
     */
    @Override
    public List<ExcellentStudent> selectStudent() {
        List<ExcellentStudent> list = (List<ExcellentStudent>) memcacheUtil.getMemcache ("excellentStudent");
        logger.info (JSON.toJSONString ("缓存中的值为："+list));

//       如果缓存不存在则查询数据库
        if (list==null){
            List<ExcellentStudent> students =studentMapper.selectStudent ();
            logger.info ("查询数据库结果："+JSON.toJSONString (students));
//            如果数据库查询为空则返回空
            if (students==null){ return null;}


            list = new ArrayList<> ();
            list.addAll (students);
            memcacheUtil.saveMemcache ("excellentStudent", 0, list);
            logger.info (JSON.toJSONString ("查询出来的值为"+JSON.toJSONString (list)));
        }


        //        生成一个int的随机数
        Random random = new Random ();
        int rd = random.nextInt (list.size ()-4);

        //取出四条数据
        List rs = new ArrayList ();
        rs.add (list.get (rd));
        rs.add (list.get (rd + 1));
        rs.add (list.get (rd + 2));
        rs.add (list.get (rd + 3));

        logger.info ("返回的值为："+JSON.toJSONString (rs));
        return rs;
    }

    /**
     * 注册
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
     *     判断登录角色是否存在，密码是否正确
     * @param name 角色的名字
     * @param pwd 密码
     * @return
     */
    @Override
    public Boolean exists(String name,String pwd) {
           RestUser  rs= userMapper.selectByName (name);
            //判断角色是否存在，空则返回false
            if (rs==null){return false;}
            //判断密码是否正确，正确则返回true
            if (MD5.verify (rs.getPwd (), pwd, rs.getSalt ())) { return true;}
        return false;
    }

    /**
     * @return学员信息
     */
    @Override
    public List selectInfo() {
        List<ExcellentStudent> rs =(List<ExcellentStudent>) memcacheUtil.getMemcache ("info");
        if (rs!=null){ return rs;}

           List<ExcellentStudent> list1= studentMapper.selectInfo ();
        if (list1!=null){
            memcacheUtil.saveMemcache ("info", 18000, list1);}
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
        int rs=studentMapper.deleteByPrimaryKey (id);

        if (rs==1){
            List<ExcellentStudent> list = (List<ExcellentStudent>) memcacheUtil.getMemcache ("info");
            list.removeIf (student -> student.getId ().equals (id));
        }

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
        if (rs==1){
            memcacheUtil.delMemcache ("info");}
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
      int rs=  studentMapper.updateByPrimaryKeySelective (record);

        if (rs==1){
            memcacheUtil.delMemcache ("info");}
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
//        防穿透判断是否为空，是否包含数字
        if (name==null || name.matches (".*[0-9].*") ){
            logger.info ("防穿透");
            return null;}

        List<ExcellentStudent> rs=(List<ExcellentStudent>) memcacheUtil.getMemcache (name);
        if (rs.equals ("+")){return null;}

        if (rs!=null && !rs.isEmpty ()){
            logger.info ("取出来的为："+name+"值为："+ JSON.toJSONString (rs));
            return rs;
        }

        List<ExcellentStudent> list=studentMapper.selectByName (name);
        if (list!=null && !list.isEmpty ()){
            memcacheUtil.saveMemcache (name, 1200, list);
            logger.info ("存进去的key为："+name+"值为："+ JSON.toJSONString (list));
        }else {
            //防穿透，填个自定义字符
            memcacheUtil.saveMemcache (name, 100, "+");}

        return list; }
}
