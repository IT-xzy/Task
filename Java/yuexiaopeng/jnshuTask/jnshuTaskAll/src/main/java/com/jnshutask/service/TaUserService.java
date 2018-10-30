package com.jnshutask.service;



import com.jnshutask.pojo.TaUser;
import com.jnshutask.pojo.TaUserRole;

import java.util.List;

public interface TaUserService {

    /**查询所有user数据成功
     * @return use数据列表
     */
    List<TaUser> selectUsers();

    /**查询所有user-role用户数据
     * @return user-role列表
     */
    List<TaUserRole> selectUserRoles();

    /**通过userId查询单个user数据
     * @param userId
     * @return 单个user数据
     */
    TaUser selectUserByUserId(Long userId);

    /**查询username单个user数据
     * @param userName 用户名
     * @return 单个user数据
     */
    TaUser selectUserByUsername(String userName);

    /**查询单个user-role用户数据表
     * @param userId 用户id
     * @return user-role数据
     */
    TaUserRole selectUserRoleByUserId(Long userId);

    /**插入user数据和user-role数据
     * @param taUser
     * @param taUserRole
     * @return 返回值为影响数据的结果
     */
    int insertUser(TaUser taUser, TaUserRole taUserRole);

    /**删除user数据和user-role数据
     * @param userId
     * @return 返回值为影响数据的结果
     */
    int deleteUser(Long userId);

    /**更新user-role数据
     * @param userId
     * @param taUserRole
     * @return 返回值为影响数据的结果
     */
    int updateUserRole(Long userId, TaUserRole taUserRole);

    /**更新单条user数据
     * @param userId
     * @param taUser
     * @return
     */
    int updateUser(Long userId, TaUser taUser);


}
