package service.cache;


import domain.entity.Prof;
import domain.entity.StuInfo;

/**
 * @Description: 缓存service层接口，实现两种缓存之间切换
 */
public interface CacheService {

    public StuInfo get(StuInfo stuInfo);

    public Integer getCount(StuInfo stuInfo);

    public Prof get(String profession);
}
