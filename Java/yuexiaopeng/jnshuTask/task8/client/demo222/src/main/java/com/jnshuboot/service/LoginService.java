package com.jnshuboot.service;

import com.jnshuboot.pojo.Login;

import java.util.List;

public interface LoginService {

    /**
     * 注册账号
     *
     * @param login；账户信息 密码必填；账户，手机，邮箱选一
     * @return 成功为1；失败为-999
     */
    int register(Login login);

    /**
     * 删除账号
     *
     * @param loginId 账户的loginId
     * @return 成功为1；失败为-999
     */
    int delete(Long loginId);

    /**
     * 更新账户的非手机号，账户，邮箱信息；
     *
     * @param login 更新后的账户信息和条件
     * @return 成功为1；失败为-999
     */
    int changInfo(Login login);

    /**
     * 更改密码
     *
     * @param login 密码及账号；
     * @return 修改结果;
     */
    int changePass(Login login);

    /**
     * 登录验证账号
     *
     * @param login 填写的账户信息
     * @return 成功为1；失败为-999
     */
    boolean logining(Login login);

    /**
     * 验证账户存在
     *
     * @param login 填写的账户信息
     * @return 存在为true；
     */
    boolean existAll(Login login);

    /**
     * 验证账户存在
     *
     * @param loginAccount 填写的通用账户信息
     * @return 存在为true；
     */
    int existAccount(String loginAccount);

    /**
     * 验证账户存在
     *
     * @param loginMobile 填写的手机账户信息
     * @return 存在为true；
     */
    int existMobile(String loginMobile);

    /**
     * 验证账户存在
     *
     * @param loginMail 填写的邮箱账户信息
     * @return 存在为true；
     */
    int existMail(String loginMail);

    /**
     * 联合验证账户格式
     *
     * @param login 账户信息；账户,手机，邮箱
     * @return 符合其一为true；都不符合为false
     */
    boolean verifyFormat(Login login);

    /**
     * 验证手机号，并发送验证码
     *
     * @param loginMobile 提交的手机号
     * @return 正确为true；
     */
    String verifyMobile(String loginMobile);

    /**
     * 验证邮箱号，并发送验证码
     *
     * @param loginMail 账户邮箱；
     * @return 正确为true；
     */
    String verifyMail(String loginMail);

    /**
     * 进行分页查询
     *
     * @param pageNum  页码数，最小为1，最大根据情况判断；
     * @param pageSize 每页数目；上限为10，下线为1
     * @return 查出的分页记录；
     */
    List pageLogin(Integer pageNum, Integer pageSize);

    long countLogin();

    List<Login> selectById(Long loginId);
}
