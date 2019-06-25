package cn.wp.service;

import cn.wp.model.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: BannerService
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:14
 * @Version: 1.0
 */
public interface BannerService {
    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> selectAll();

    List<Banner> selectByDynamicCondition(@Param("state") Integer state, @Param("createBy") String createBy);
}
