package com.ptt.mapper;

import com.ptt.pojo.ITProfession;

import java.util.List;

/**
 * @ProjectName: task4
 * @Package: com.ptt.mapper
 * @ClassName: ITProfessionMapper
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 9:31
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 9:31
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface ITProfessionMapper {
    //查询全部
    List<ITProfession> selectAll();
    List<ITProfession> selectFrontEndDevelop(String FrontEndDevelop);//前端
    List<ITProfession> selectBackEndDevelop(String BackEndDevelop);//后端
    List<ITProfession> selectMobileDevelop(String MobileDevelop);//移动端
    List<ITProfession> selectOperations(String Operations);//运维
    List<ITProfession> selectFullStackDevelop(String FullStackDevelop);//全站
}
