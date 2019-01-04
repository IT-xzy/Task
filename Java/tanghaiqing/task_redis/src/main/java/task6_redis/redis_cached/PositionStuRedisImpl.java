package task6_redis.redis_cached;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import task6_redis.dao.PositionStuDao;
import task6_redis.pojo.PositionStu;
import task6_redis.util.RedisUtil;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class PositionStuRedisImpl implements PositionStuRedis {
    @Resource(name = "positionStuDao")
    private PositionStuDao positionStuDao;
    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    private Logger logger=Logger.getLogger(PositionStuRedisImpl.class);

    @Override
    public List<PositionStu> queryPositionStuR() {
        logger.info("进入queryPositionStuR()");
        List<Object> list =redisUtil.lGet("goodShow",0,-1);
        logger.info(list);
        if (list.size()==0){
            logger.info("没有优秀学员的缓存！");
            this.saveRedisCached();
            list =redisUtil.lGet("goodShow",0,-1);
            logger.info(list);
        }
        List<PositionStu> positionStus =new ArrayList<>();

    for (Object i:list){
            logger.info(i.toString());
            PositionStu p =(PositionStu) redisUtil.get(i.toString());
            logger.info("一位优秀学员："+p.toString());
            positionStus.add(p);
        }
        return positionStus;
    }

    @Override
    public Integer savePositionStuR(PositionStu positionStu) {
        logger.info("savePositionStuM()");
        Integer i=positionStuDao.savePosition(positionStu);
        if (i>0){
            redisUtil.del("goodShow");
            this.saveRedisCached();
        }
        return i;
    }

    @Override
    public PositionStu queryPosiM(Integer id){
        PositionStu positionStu=null;
        if (redisUtil.hasKey(id.toString())){
            logger.info("缓存里面有");
            return (PositionStu) redisUtil.get(id.toString());
        }else {
            logger.info("缓存里面没有");
             positionStu =positionStuDao.queryPos(id);
            if (positionStu!=null){
                logger.info("数据库里面取出来的不为空");
                redisUtil.set(positionStu.getPosId().toString(),positionStu);
            }else {
                logger.info("数据库里面取出来的为空");
                redisUtil.set(id.toString(),null,200);
            }
        }
        return (PositionStu) redisUtil.get(id.toString());
    }


    private void saveRedisCached(){
        logger.info("saveRedisCached()");
        List<PositionStu> positionStus =positionStuDao.goodShow();
        logger.info(positionStus);
        //List<Integer> list=new ArrayList<>();
        if (positionStus.size()!=0){
            for (PositionStu p:positionStus){
                logger.info("优秀学员："+p);
                boolean b =redisUtil.set(p.getPosId().toString(),p);
                logger.info("是否成功："+b);
                if (b) {
                    logger.info("正在保存优秀学员集合的信息！");
                    //list.add(p.getPosId());
                    redisUtil.lSet("goodShow",p.getPosId());
                }
            }
        } else {
            redisUtil.set("goodShow",null);
        }
        logger.info("优秀学员展示信息："+redisUtil.lGet("goodShow",0,-1));
    }

    public static void main(String[] args) {
        final PositionStuRedis positionStuRedis =new PositionStuRedisImpl();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                PositionStu positionStu = positionStuRedis.queryPosiM(11);
                System.out.println(positionStu);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                PositionStu positionStu = positionStuRedis.queryPosiM(10);
                System.out.println(positionStu);
            }
        };
        t1.start();
        t2.start();
    }
}
