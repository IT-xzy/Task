package jnshu.taskeight.service;

import jnshu.taskeight.model.Profession;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-20
 * @Time: 下午 6:35
 * Description:
 **/
public interface CountNumberService {


     /**
      * count Profession Study
      * 获取所有职业的学习人数
      *@param professions all profession information
      * @return 返回学生列表的全部信息 int[]
      */
     Integer[] countProfessionStudy(List<Profession> professions);
}