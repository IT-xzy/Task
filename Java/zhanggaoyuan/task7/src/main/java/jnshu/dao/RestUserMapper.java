package jnshu.dao;

import jnshu.model.RestUser;

public interface RestUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RestUser record);

    RestUser selectByName(String name);

        int updateByName(RestUser record);

    /**
     * 根据id查询盐
     * @param id
     * @return
     */
    String selectSalt (Long id);
}