package com.jnshutask.service;

import com.jnshutask.pojo.TaStudent;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 24569
 */
@Service
public interface TaStudentService {

    /**增加student数据
     * @param student 学生数据
     * @return 学生数据
     */
    @CacheEvict(key = "'id:'+#taStudent.id", value = "student",allEntries = true)
    TaStudent insertSelective(TaStudent student);

    /**删除单个student数据
     * @param id 学生id
     * @return 学生数据影响结果
     */
    @CacheEvict(key = "'id:'+#id", allEntries = true, value = "student")
    int deleteById(Integer id);

    /**更新单个student数据
     * @param student 需要更新的数据
     * @return 学生数据
     */
    @CacheEvict(key = "'id:'+#taStudent.id", allEntries = true,value = "student")
    TaStudent updateById(TaStudent student);

    /**查询单个student数
     * @param id 学生id
     * @return 学生数据
     */
    @Cacheable(key = "'id:'+#id", value = "student")
    TaStudent selectById(Integer id);

    /**查询分页student数据
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return 学生数据列表
     */
    @Cacheable(key = "'page:'+#pageNum+','+#pageSize", value = "student")
    List<TaStudent> selectPage(Integer pageNum, Integer pageSize);

    /**
     * @param student 包含student信息
     * @return
     */
    int exist(TaStudent student);

    /**计算所有student数量
     * @return 学生数据数量
     */
    long countAll();
}
