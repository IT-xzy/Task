package jnshu.service.impl;

import com.alibaba.fastjson.JSON;
import jnshu.dao.ExcellentStudentMapper;
import jnshu.dao.RestUserMapper;
import jnshu.model.ExcellentStudent;
import jnshu.model.RestUser;
import jnshu.service.StudentService;
import jnshu.tool.MD5;
import jnshu.tool.redis.RedisTakes;
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
    RedisTakes redisTakes;

    @Override
    public int insertStudent(ExcellentStudent record) {
        return studentMapper.insert (record);
    }


    /**
     *     查询优秀学员信息
     * @return优秀学员信息
     */
    @Override
    public List<ExcellentStudent> selectStudent() {
        List<ExcellentStudent> list=(List<ExcellentStudent>)redisTakes.getObj ("student", "excellentStudent");
        logger.info  ("缓存中的值为："+JSON.toJSONString (list));

//       如果缓存不存在则查询数据库
        if (list==null){
            List<ExcellentStudent> students =studentMapper.selectStudent ();
            logger.info ("查询数据库结果："+JSON.toJSONString (students));
//            如果数据库查询为空则返回空
            if (students==null){ return null;}



            list = new ArrayList<> ();
            list.addAll (students);
            redisTakes.addObj ("student", "excellentStudent",list);
            logger.info (JSON.toJSONString ("查询出来的值为"+JSON.toJSONString (list)));
        }


        Random random = new Random ();
//        new一个集合用来保存数据
        List rs = new ArrayList ();
     for (int i=0 , max = list.size ()-1;i<4;i++,max--){
//         从有效长度中随机一个数
         int rd = random.nextInt (max);
//    把随机数对应的值取出来存到集合rs中
         rs.add (list.get (rd));

        if (rd!=max){
            logger.info ("有效长度为："+max+"总长度为："+list.size ());
//            用list集合的最后一个值覆盖随机数的值
            list.set (rd, list.get (max));
        }

     }

        logger.info ("返回的值为："+JSON.toJSONString (rs));
        return rs;
    }

//    /**
//     *     查询优秀学员信息
//     * @return优秀学员信息
//     */
//    @Override
//    public List<ExcellentStudent> selectStudent() {
//        List<ExcellentStudent> list=(List<ExcellentStudent>)redisTakes.getObj ("student", "excellentStudent");
//        logger.info (JSON.toJSONString ("缓存中的值为："+list));
//
////       如果缓存不存在则查询数据库
//        if (list==null){
//            List<ExcellentStudent> students =studentMapper.selectStudent ();
//            logger.info ("查询数据库结果："+JSON.toJSONString (students));
////            如果数据库查询为空则返回空
//            if (students==null){ return null;}
//
//
//
//            list = new ArrayList<> ();
//            list.addAll (students);
//            redisTakes.addObj ("student", "excellentStudent",list);
//            logger.info (JSON.toJSONString ("查询出来的值为"+JSON.toJSONString (list)));
//        }
//
//
//        //        生成一个int的随机数
//        Random random = new Random ();
//        int rd = random.nextInt (list.size ()-4);
//
//        //取出四条数据
//        List rs = new ArrayList ();
//        rs.add (list.get (rd));
//        rs.add (list.get (rd + 1));
//        rs.add (list.get (rd + 2));
//        rs.add (list.get (rd + 3));
//
//        logger.info ("返回的值为："+JSON.toJSONString (rs));
//        return rs;
//    }

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
     *     判断登录角色是否存在，密码是否正确
     * @param name 角色的名字
     * @param pwd 密码
     * @return
     */
    @Override
    public Boolean exists(String name,String pwd) {
        //        取出缓存
        RestUser rs= (RestUser) redisTakes.getObj ("user",name );

//        如果缓存为空，查询数据库
        if (rs==null){
             rs= userMapper.selectByName (name);
            //判断角色是否存在，空则返回false
            if (rs==null){return false;}
          //对没有缓存的用户做缓存
            redisTakes.addObj ("user", name, rs);
            //判断密码是否正确，正确则返回true
            if (MD5.verify (rs.getPwd (), pwd, rs.getSalt ())) { return true;}
        }

//        如果缓存不为空，则判断密码是否正确，正确则返回true
        if (MD5.verify (rs.getPwd (), pwd, rs.getSalt ())) { return true;}
        return false;
    }

    /**
     * @return学员信息
     */
    @Override
    public List selectInfo() {
      List list=(List)  redisTakes.getObj ("student", "info");
      logger.info (JSON.toJSONString ("缓存里的List："+list));
        if (list==null) {
            logger.info ("判断成功");
           List<ExcellentStudent> list1= studentMapper.selectInfo ();
           redisTakes.addObj ("student","info" ,list1 );
           logger.info ("查出来的List："+list1);
           return list1;
        }
        return list;
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
//////        把缓存里的学员信息也删掉
//        if (1 == rs) {
//            redisTakes.delete ("student");
//        }
        if (1 == rs) {
            redisTakes.delete ("studentName");
            redisTakes.addObj ("student", "excellentStudent", null);
            List<ExcellentStudent> list=(List)  redisTakes.getObj ("student", "info");
            list.removeIf (student -> student.getId ().equals (id));
            redisTakes.addObj ("student", "info", list);
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
           redisTakes.delete ("student");
            logger.info ("信息表的缓存已清空");}

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
      if (rs==1){redisTakes.delete ("student");
      redisTakes.delete ("studentName");
      logger.info ("信息表的缓存已清空");
      }

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
        logger.info ("进入server");

//        防穿透判断是否为空，是否包含数字
        if (name==null || name.matches (".*[0-9].*") ){
            logger.info ("防穿透");
            return null;}
        logger.info ("name规范");

        List<ExcellentStudent> list =(List<ExcellentStudent>) redisTakes.getObj ("studentName", name);
        if (list!=null){return list;}
        logger.info (JSON.toJSONString (list));


        logger.info ("不存在缓存");
        List rs = studentMapper.selectByName (name);

//        存进缓存
        if (rs != null || !rs.isEmpty ()) {
            redisTakes.addObj ("studentName", name, rs);
            logger.info ("缓存储存完毕");

        }else {
            logger.info ("开始存值防穿透");
         redisTakes.addObj ("studentName", name, "10");
        }

    return rs;

        }

}

//    @Override
//    public List<ExcellentStudent> selectByName(String name) {
//        logger.info ("进入server");
//
//        //        防穿透判断是否为空，是否包含数字
//        if (name==null || name.matches (".*[0-9].*") ){
//            logger.info ("防穿透");
//            return null;}
//        logger.info ("name规范");
//
//        List list =(List) redisTakes.get (name);
//
////        有缓存则取出
//        if (list != null ) {
//            logger.info ("存在缓存");
//            return list;
//        }
//
//        logger.info ("不存在缓存");
//        List rs = studentMapper.selectByName (name);
//
////        存进缓存
//        if (rs != null || !rs.isEmpty ()) {
//            redisTakes.add (name,rs );
//        }else {
//            logger.info ("开始存值防穿透");
//            List rs111 = new ArrayList ();
//            rs111.add ("10");
//            redisTakes.add (name,rs111 );
//        }
//
//        return rs;
//
//    }