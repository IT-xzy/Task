package com.ptt.mapper;

import com.ptt.pojo.StudyStep;

import java.util.List;

/**
 * @ProjectName: task4
 * @Package: com.ptt.mapper
 * @ClassName: IStudyStepMapper
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/25 10:19
 * @UpdateUser:
 * @UpdateDate: 2018/5/25 10:19
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IStudyStepMapper {
    List<StudyStep> selectAll();
}
