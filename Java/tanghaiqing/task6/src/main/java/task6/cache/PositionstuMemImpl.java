package task6.cache;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import task6.dao.PositionStuDao;
import task6.pojo.PositionStu;
import task6.util.FastJsonUtil;
import task6.util.MemcachedUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class PositionstuMemImpl implements PositionstuMem {
    private static Logger logger = Logger.getLogger(PositionstuMemImpl.class);
    @Resource(name = "positionStuDao")
    private PositionStuDao positionStuDao;

    /**
     * 第一张页面，优秀学员展示缓存接口
     *
     * @return
     */
    @Override
    public List<PositionStu> queryPositionStuM() {
        logger.info("queryPositionStuM()");
        List<Integer> list1 = JSON.parseArray((String) MemcachedUtils.get("goodShow"), Integer.class);
        logger.info(list1);
        synchronized (this) {if (list1==null) {
                logger.info("没有缓存！");
                this.saveMemcached();
                list1 = JSON.parseArray((String) MemcachedUtils.get("goodShow"), Integer.class);
            }
        }
        List<PositionStu> positionStus = new ArrayList<>();
        for (Integer id : list1) {
            PositionStu p = FastJsonUtil.JsonTransition(MemcachedUtils.get(id.toString()).toString());
            System.out.println("数据：" + p.toString());
            positionStus.add(p);
        }
        logger.info(positionStus);
        return positionStus;
    }

    @Override
    public Integer savePositionStuM(PositionStu positionStu) {
        logger.info("savePositionStuM()");
        Integer i = positionStuDao.savePosition(positionStu);
        if (i > 0) {
            this.saveMemcached();
        }
        return i;
    }

    private void saveMemcached() {
        logger.info("saveMemcached()");
        //调用dao层的接口，取出数据库里面的数据
        List<PositionStu> positionStus = positionStuDao.goodShow();
        logger.info(positionStus);
        //加一个集合，用于装取出来优秀学员的id
        List<Integer> list = new ArrayList<>();
        //遍历集合，一个个存入缓存
        if (positionStus.size() != 0) {
            for (PositionStu positionStu : positionStus) {
                //以id作为key值，positionStu对象为values
                boolean flag = MemcachedUtils.set(positionStu.getPosId().toString(), FastJsonUtil.TransitionJson(positionStu));
                logger.info(flag);
                if (flag) {
                    list.add(positionStu.getPosId());
                } else {
                    break;
                }
            }
        }
        logger.info(list);
        //调用工具类存取优秀学员展示的id的信息
        String str = JSON.toJSONString(list);
        logger.info(str);
        MemcachedUtils.set("goodShow", str);
    }
    //public PositionStu queryPos(Integer id){
    //
    //    PositionStu positionStu =positionStuDao.queryPosition(id);
    //    if (positionStu!=null){
    //        MemcachedUtils.set(positionStu.getPosId().toString(),FastJsonUtil.TransitionJson(positionStu));
    //    }else {
    //        MemcachedUtils.set(id.toString(),null);
    //    }
    //    return null;
    //}


    public static void main(String[] args) {
        System.out.println(MemcachedUtils.get("55"));
        System.out.println(MemcachedUtils.delete("goodShow"));
    }
}
