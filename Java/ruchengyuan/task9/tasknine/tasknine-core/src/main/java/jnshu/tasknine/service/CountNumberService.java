package jnshu.tasknine.service;

import jnshu.tasknine.model.Profession;
import org.oasisopen.sca.annotation.Remotable;
import org.oasisopen.sca.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-20
 * @Time: 下午 6:35
 * Description:
 **/
@Remotable
@org.springframework.stereotype.Service("countNumberService")
public interface CountNumberService {


     /**
      * count Profession Study
      * 获取所有职业的学习人数
      *@param professions all profession information
      * @return 返回学生列表的全部信息 int[]
      */
     Integer[] countProfessionStudy(List<Profession> professions);
}