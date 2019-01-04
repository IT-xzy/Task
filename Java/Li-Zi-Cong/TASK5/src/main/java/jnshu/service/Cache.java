package jnshu.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author:user
 */
public interface Cache {

    //    无条件更新缓存
    void update(String key )throws Exception;
}
