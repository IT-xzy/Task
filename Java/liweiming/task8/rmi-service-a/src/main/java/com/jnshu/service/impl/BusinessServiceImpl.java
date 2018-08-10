package com.jnshu.service.impl;

import com.jnshu.dao.UserDTODAO;
import com.jnshu.entity.User;
import com.jnshu.entity.UserDTO;
import com.jnshu.service.BussinessService;
import com.jnshu.tools.Md5Util;
import com.jnshu.tools.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Tiles
 * @description: 处理注册登录逻辑
 * @author: Mr.Lee
 * @create: 2018-07-04 09:57
 **/
@Service
public class BusinessServiceImpl implements BussinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessServiceImpl.class);


    @Autowired
    UserDTODAO userDTODAO;

    /**
    * @Description: 注册
    * @Param: [userDto]
    * @return: void
    * @Author: Mr.Lee
    * @Date: 2018\7\4 0004
    */

    public void register(UserDTO userDTO){
        userDTODAO.add(userDTO);
    }

    public Boolean findByUserName(String username){
        return userDTODAO.findByUserName(username);
    }

    public UserDTO getByUsername(String username){
        return userDTODAO.getByUsername(username);
    }

    public UserDTO getByEmail(String username){return userDTODAO.getByEmail(username);}

    public UserDTO getByPhone (String username){return userDTODAO.getByPhone(username);}


    public UserDTO login(String username){
         return userDTODAO.checkout(username);
    }

    public Boolean update(UserDTO userDTO){return userDTODAO.update(userDTO);}

    public Boolean alogin(UserDTO dto){

        /**定义邮箱和手机号的正则*/
        String email = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String phone = "^[1][3578]\\d{9}$";

        String account = dto.getUsername();
        String password = dto.getPassword();

        if (account.matches(email)) {
            UserDTO userDTO = userDTODAO.getByEmail(account);
            if (userDTO == null) {
                LOGGER.info("邮箱登录失败");
                return false;
            }
            String pwd = userDTO.getPassword();
            if (Md5Util.getSaltverifyMD5(password, pwd)) {
                LOGGER.info("邮箱登录成功！！");
                return true;
            }
        }
        else if (account.matches(phone)){
            UserDTO userDTO = userDTODAO.getByPhone(account);
            if (userDTO == null){
                LOGGER.info("手机登录失败");
                return false;
            }
            String pwd = userDTO.getPassword();
            if (Md5Util.getSaltverifyMD5(password,pwd)){
                LOGGER.info("手机登录成功！！");
                return true;
            }
        }else {
            UserDTO userDTO = userDTODAO.checkout(account);
            if (userDTO == null){
                LOGGER.info("用户名登录失败");
                return false;
            }
            String pwd = userDTO.getPassword();
            if (Md5Util.getSaltverifyMD5(password,pwd)){
                LOGGER.info("用户名登录成功");
                return true;
            }
        }

        return false;
    }
}
