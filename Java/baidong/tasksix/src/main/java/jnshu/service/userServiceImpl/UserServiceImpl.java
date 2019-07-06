package jnshu.service.userServiceImpl;

import com.danga.MemCached.MemCachedClient;
import jnshu.service.UserService;
import jnshu.cache.Cached;
import jnshu.dao.UserMapper;
import jnshu.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Resource(name="MemCache")
    Cached cached;
    @Autowired
    private MemCachedClient memCachedClient;


    @Override
    public List<User> selectAll() {
        Object object = memCachedClient.get("User");
        List<User> Users = (List<User>) object;
        logger.info("Users==============" + Users);
        if (Users == null) {
            Users = userMapper.selectAll();
            boolean state = memCachedClient.set("User", Users);
            System.out.println("state===========" + state);
            logger.info("已存入缓存");
        }
        return Users;
    }
//插入数据的时候，先在将数据放入数据库，然后将数据的的键值对中的key设置为命名+id，将数据放入
    @Override
    public boolean insert(User user) {
        logger.info("输入user============" + user);
        boolean start = userMapper.insert(user);
        logger.info("是否插入数据库" + start);
        boolean sta = memCachedClient.set("User"+user.getId(), user);
        logger.info("是否插入缓存" + sta);
        return start;
    }




        @Override
        public boolean deleteByPrimaryKey (Long id){


            boolean dbState = userMapper.deleteByPrimaryKey(id);
            logger.info("删除数据与否===========" + dbState);
            boolean cacheState = cached.delete("" + id);
            logger.info("删除缓存与否=========" + cacheState);
            return dbState;
        }


        @Override
        public boolean updateByPrimaryKey (User User){
            boolean dbState = userMapper.updateByPrimaryKey(User);
            logger.info("更新数据与否" + dbState);
            boolean cacheState = cached.set("" + User.getId(), User);
            logger.info("更新缓存与否" + cacheState);

            return dbState;
        }


        @Override
        public User selectByPrimaryKey (Long id){
            logger.info("id=================is" + id);
            User User = (User) cached.get("" + id);
            logger.info("User id = ============" + User);
            logger.info("缓存是==========" + User);
            if (ObjectUtils.isEmpty(User)) {
                User = userMapper.selectByPrimaryKey(id);
                boolean state = cached.set("" + id, User);
                logger.info("缓存插入与否" + state);
            }
            return User;
        }

        @Override
        public List<Long> selectAllIds () {

            return userMapper.selectAllIds();
        }

        /*在缓存中首先判断缓存中有没有用数据，如果没有，根据ids去数据库中查找数据，返回，并
        将查找到的数据放入缓存中(一个一个查）
         */
        @Override
        public List<User> selectByIdList (List < Long > ids) {
            logger.info("ids==================" + ids);
            List<User> list = (List<User>)memCachedClient.get("user" + ids);
            logger.info("UserList cache======" + list);
            if(list==null){
                list = userMapper.selectByIdList(ids);
                logger.info("DBlist" + list);
                memCachedClient.set("user" + ids,list);
                logger.info("add to cache success======");
            }
            return list;


        }


    }