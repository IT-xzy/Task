package com.service;
import com.dao.Mapper;
import com.pojo.OcT;
import com.pojo.Occupation;
import com.pojo.Trainees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceImpl implements ServiceIF {
    @Resource
    private Mapper mp;

    @Override
    //累计在学人数统计
    public int accountStudents() {
        return mp.accountTrainees();
    }

    @Override
    //找到工作人数统计
    public int countOccupation() {
        return mp.countWork();
    }

    @Override
    //课程在学人数统计
    public int lessonAll(int number) {
        return mp.lessonCount(number);
    }

    @Override
    //获取优秀学员类
    public List<Trainees> niceStudents() {
        return mp.niceTrainees();
    }

    @Override
    //遍历所有职业对象并且输出
    public List<Occupation> queryAllOccupation() {
        return mp.queryAllCareers();
    }

    @Override
    //得到职业对象和在学人数的复合类
    public List<OcT> queryAllOccupationAndLesson() {
        List<OcT> ocTS=mp.queryAllCareersAndLesson();
        for (int i=0;i<ocTS.size();i++){
            ocTS.get(i).setCourseSum(mp.lessonCount(ocTS.get(i).getId()));
        }
        return ocTS;
    }
    //根据账号查询密码
    @Override
    public Trainees checkPwd(String account) {
        return mp.checkPwd(account);
    }

    //注册学员
    @Override
    public int loginTrainees(Trainees trainees) {
        //查找该账号有没有被使用
        Trainees tr=mp.checkPwd(trainees.getAccount());



        if(tr==null){
            //账号没有被注册，进行注册，并且返回1；
            Trainees add=new Trainees();
            add.setAccount(trainees.getAccount());
            add.setPassword(trainees.getPassword());
            add.setSalt(trainees.getSalt());
            mp.loginTrainees(add);
            return 0;
        }else {
            //账号已经被注册，不进行注册，并且返回0；
            return 1;
        }
    }

    @Override
    //登录接口
    public int enterPage(Trainees trainees) {
        Trainees tr= mp.checkPwd(trainees.getAccount());
        if(tr!=null){
            if(trainees.getPassword().equals(tr.getPassword())){
                //如果输入密码和账号密码相等，返回0值；
                return 0;

            }else {
                //如果输入密码和账号密码不等，返回1值；
                return 1;
            }
        }else {
            //如果没有这个账号，返回值2；
            return 2;
        }

    }
}
