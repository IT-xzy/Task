package com.service.impl;

import com.Plug.PageBean;
import com.danga.MemCached.MemCachedClient;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import com.tool.MemCachedManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    //公有标志位，任何用户必须同步
    private boolean change=false;
    //防止缓存雪崩的随机数
    private Random random=new Random();
    private Logger logger=Logger.getLogger(UserServiceImpl.class);

    @Override
    //添加一个用户
    public boolean addUser(User user) {
        //先调用数据访问层的增加方法，判断操作是否成功
        if(userMapper.insertUser(user)!=0) {
            //如果成功，调用MemCache在内存中以用户Id为键，放置用户信息.
            MemCachedClient mcc = MemCachedManager.getInstance();
            //""+数值：将数值转换为字符串
            //缓存设置时效，牺牲一部分性能，减小脏数据的影响 设置30分钟+5分钟的时间值防止缓存雪崩
            mcc.add(""+user.getId(),user,new Date(1000*60*30+random.nextInt(1000*60*5)));
            change=false;
            //并返回true
            return true;
        }
        //如果操作失败返回false
        return false;
    }

    //减少一个用户
    @Override
    public boolean cutUserById(long id) {
        //判断数据层操作是否成功
        if(userMapper.deleteUserById(id) != 0){
            //调用MemCacheClient删除掉id值对应的数据
            MemCachedClient mcc=MemCachedManager.getInstance();
            mcc.delete(""+id);
            change=false;
            return true;
        }
        return false;
    }

    @Override
    //修改一个用户
    public boolean reviseUserById(User user) {
        if(userMapper.updateUserById(user) != 0){
            MemCachedClient mcc=MemCachedManager.getInstance();
            mcc.delete(""+user.getId());
            change=false;
            return true;
        }
        return false;
    }

    @Override
    //查询一个用户
    public User queryUserById(long id) {
        //获得MemCachedManager的实例
        MemCachedClient mcc=MemCachedManager.getInstance();
        User user;
        if(getRedisConnect()) {
            logger.info("判断键值：" + mcc.get("time" + id));
            // 如果对应的时间缓存已经存在则判定进入防止缓存击穿的状态
            if (!("@@".equals(mcc.get("time" + id)))) {
                //通过Memcache获得缓存数据
                user = (User) mcc.get("" + id);
                //如果成功获得对象
                if (user != null) {
                    logger.info("缓存中存在可信数据，直接返回数据，键值" + id);
                    //直接返回对象
                    return user;
                } else {
                    logger.info("缓存中不存在可信数据，从数据库中获取，键值：" + id);
                    //如果不成功，则先调用数据访问层的方法获得对象
                    user = userMapper.selectUserById(id);
                    //并将获得的对象设置到MenCache中
                    if (user != null) {
                        logger.info("将数据库中获取的数据保存到缓存中，键值：" + id);
                        //缓存设置时效，牺牲一部分性能，减小脏数据的影响 设置30分钟+5分钟的时间值防止缓存雪崩
                        mcc.add("" + id, user,new Date(1000*60*30+random.nextInt(1000*60*5)));
                    } else {
                        logger.info("查询" + id + "不存在，进入缓存穿透状态");
                        //加一个时间标志位的缓存
                        logger.info("添加标志键值成功:" + mcc.add("time" + id, "@@", new Date(5 * 60 * 1000)));
                        logger.info("标志键值是:" + mcc.get("time" + id));
                    }
                }
            } else {
                logger.info("键值" + id + "已被判断为缓存穿透，不进行数据库查询，直接返回null");
                return null;
            }
        }else {
            user=userMapper.selectUserById(id);
        }
        //返回到显示层
        logger.info("查询单个用户："+user);
        return user;
    }

    //查询所有用户
    @Override
    public List<User> queryUser() {
        return userMapper.selectUser();
    }

    //分页 pageNum：当前页； paeSze：页面尺寸(思路：获得当前页的第一条记录id号，
    //并到数据库中根据页面尺寸查询一页记录)
    //分页的逻辑导致永远不可能出现缓存穿透的情况，不管传入的当前页是多少，完全不会改变到刷新缓存的逻辑，
    // 不存在数据查询不到数据的情况
    @Override
    public PageBean findAllUserWithPage(int pageNum,int pageSize) {
        PageBean pageBean;
        //获得MemCache操作对象
        MemCachedClient mcc = MemCachedManager.getInstance();
        //判断MemCache是否挂了
        if(getRedisConnect()) {
            logger.info("是否进入缓存穿透状态："+("@@".equals(mcc.get("pageTime" + pageNum))));
            //判断当前用户访问页是否进入缓存穿透状态
            if (!("@@".equals(mcc.get("pageTime" + pageNum)))) {
                //从缓存获得当前页的记录
                pageBean = (PageBean) mcc.get("page" + pageNum);
                //变动位改变即代表缓存中数据不可信，需要刷新数据
                logger.info("数据库是否被修改:"+!change+" "+"缓存中第"+pageNum+"页的数据是否为空："+(pageBean==null));
                if (!change || pageBean == null) {
                    logger.info("缓存中不存在可信数据，分页遍历数据库");
                    //在这里要将pageBean中的数据创建好，然后将该对象传回去
                    //先要从数据库中获取所有用户的数据量有多少，获得totalRecord
                    List<User> allUser = userMapper.selectUser();
                    //获得总记录数
                    int totalRecord = allUser.size();
                    //有了三个初始数据，将能够创建PageBean对象了
                    pageBean = new PageBean(pageNum, pageSize, totalRecord);
                    //获得总页数
                    int totalPage = pageBean.getTotalPage();
                    //遍历每一页，更新每一页的缓存
                    for (int pageNumNow = 1; pageNumNow <= totalPage; pageNumNow++) {
                        PageBean pageBeanNow = new PageBean(pageNumNow, pageSize, totalRecord);
                        //获取pageBean对象中的每一页的starIndex
                        int starIndex = pageBeanNow.getStartIndex();
                        //有了starIndex和pageSize,就可以拿到每页的数据了
                        List<User> list = userMapper.selectPage(starIndex, pageSize);
                        pageBeanNow.setList(list);
                        if (list != null) {
                            //缓存设置时效，牺牲一部分性能，减小脏数据的影响 设置30分钟+5分钟的时间值防止缓存雪崩
                            mcc.set("page" + pageNumNow, pageBeanNow,new Date(1000*60*30+random.nextInt(1000*60*5)));
                        } else {
                            mcc.add("page" + pageNumNow, null);
                        }
                    }
                    change = true;
                } else {
                    logger.info("缓存中存在可信数据，直接从缓存中获取,当前页为:"+pageNum);
                    logger.info("最终的返回数据"+pageBean);
                    return pageBean;
                }
                //最后才从缓存中获得数据
                pageBean = (PageBean) mcc.get("page" + pageNum);
                logger.info("从缓存取得的数据:" + pageBean);
                //如果更新后的缓存中不存在即视为缓存穿透
                if (pageBean == null) {
                    //添加一个标志键值对,设置5分钟
                    mcc.add("pageTime" + pageNum, "@@", new Date(1000 * 60 * 5));
                    logger.info("分页进入缓存穿透状态，键值为：" + pageNum+"缓存穿透标志位已添加");
                }
                //如果缓存挂了，直接从来数据库中取
            } else {
                logger.info("进入缓存穿透状态，被限制的键值为："+pageNum);
                logger.info("最终的返回数据:null");
                return null;
            }
        }else {
            logger.info("缓存已经挂了，直接访问数据库");
            //在这里要将pageBean中的数据创建好，然后将该对象传回去
            //先要从数据库中获取所有用户的数据量有多少，获得totalRecord
            List<User> allUser = userMapper.selectUser();
            //获得总记录数
            int totalRecord = allUser.size();
            //创建当前页对象(没有数据、只拥有获得数据需要的参数)
            pageBean = new PageBean(pageNum, pageSize, totalRecord);
            //通过当前页对象获得当前页第一条记录id号
            int starIndex = pageBean.getStartIndex();
            //从第一个索引位置开始，取一页的记录
            List<User> list = userMapper.selectPage(starIndex, pageSize);
            //封装到pageBean中
            pageBean.setList(list);
        }
        logger.info("最终的返回数据"+pageBean);
        return pageBean;
    }

    //判断缓存连接是否异常
    private boolean getRedisConnect(){
        boolean Connect=true;
        //获得MemCache操作对象
        MemCachedClient mcc = MemCachedManager.getInstance();
        //通过Map获取MemCachedClient的状态
        Map stats = mcc.stats();
        //如果size为0则说明MemCache已经挂了，返回false
        if(stats.size()==0){
            Connect=false;
        }
        //如果size为0则代表缓存连接断开，logger为true
        logger.info("缓存是否挂了："+ (stats.size() == 0));
        return Connect;
    }
}
