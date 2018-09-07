package com.service.impl;

import com.dao.PaperDao;
import com.pojo.PageBean;
import com.pojo.Paper;
import com.service.PaperService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;


@Service//("paperService")
public class PaperServiceImpl implements PaperService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(PaperServiceImpl.class);

    @Autowired
    private PaperDao paperDao;

    @Autowired
    private MemcachedClient memcachedClient;

    //新增论文信息
    @Override
    public void addPaper(Paper paper) throws Exception {
        paperDao.addPaper(paper);
        logger.info("\n最新插入数据：" + paper);
        memcachedClient.delete("paperList");
        logger.info("\n新增信息,刷新缓存");
    }


    //删除论文
    @Override
    public boolean deletePaperById(long id) throws Exception {
        logger.info("\n即将删除的id：" + id);
        if (memcachedClient.get(String.valueOf(id)) != null) {
            Boolean b = memcachedClient.delete(String.valueOf(id));
            logger.info("\n---是否删除缓存数据成功：" + b + "---");
        } else {
            logger.info("\n---没有对应的缓存数据可以删除---");
        }
        return paperDao.deletePaperById(id);
    }

    //修改论文数据
    @Override
    public boolean updatePaper(Paper paper) throws Exception {
        boolean b = memcachedClient.set(String.valueOf(paper.getPaperId()), 0, paper);
        logger.info("\n---修改缓存数据：" + b + "---");
        return paperDao.updatePaper(paper);
    }

    //查询所有数据信息
    @Override
    public List<Paper> queryAllPaper() throws Exception {
        List<Paper> paperList = memcachedClient.get("paperList");
        try {
            if (paperList != null) {
                logger.info("\n---从缓存中查询所有---");
            } else {
                logger.info("\n---从数据库中查询所有---");
                paperList = paperDao.queryAllPaper();
                memcachedClient.set("paperList", 0, paperList);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return paperDao.queryAllPaper();
    }

    @Override
    //根据ID查询记录
    public Paper queryById(int paperId) throws Exception {
        Paper paperOne;
        if ("@".equals(memcachedClient.get(String.valueOf(paperId)))){
            logger.info("\nMemcache缓存防穿透直接返回。");
            return null;
        }
        paperOne = memcachedClient.get(String.valueOf(paperId));
        logger.info("\n前端传过来的paperId是：" + paperId);
        logger.info("\n判断前该id的缓存是：" + paperOne);
        if (memcachedClient.get(String.valueOf(paperId)) != null) {
            logger.info("\n从缓存中查询结果");
            return paperOne;

        } else if (paperDao.queryById(paperId) != null) {
            paperOne = paperDao.queryById(paperId);
            memcachedClient.set(String.valueOf(paperId), 0, paperOne);
            logger.info("\n从数据库添加缓存的数据是：" + paperOne);
            return paperOne;
        }else {
        memcachedClient.set(String.valueOf(paperId), 3 * 60, "@");

            logger.info("\n数据库中不存在数据，设置缓存为空，防穿透");
        }
        return paperOne;
    }

 //
 //if(memcachedClient.add(key_mutex,3*60*1000)==true){
 //       value=paperDao.queryById(paperId);
 //       memcachedClient.set(paperId,value);
 //       memcachedClient.delete(key_mutex);
 //
 //   }else {sleep(50);
 //
 //       retry();
 //   }


    ////根据ID查询记录
    //public Paper queryById(int paperId) throws Exception {
    //    Paper paperOne = memcachedClient.get(String.valueOf(paperId));
    //    logger.info("\n前端传过来的paperId是：" + paperId);
    //    logger.info("\n判断前该id的缓存是：" + paperOne);
    //    if (memcachedClient.get(String.valueOf(paperId)) != null) {
    //        logger.info("\n从缓存中查询结果");
    //        return paperOne;
    //
    //    } else {
    //        paperOne = paperDao.queryById(paperId);
    //        memcachedClient.set(String.valueOf(paperId), 0, paperOne);
    //        logger.info("\n从数据库添加缓存的数据是：" + paperOne);
    //        return paperOne;
    //    }
    //}


    @Override
    public List<Paper> findPaperByName() throws Exception {
        return paperDao.findPaperByName();
    }


    @Override
    public Paper getPaperById(String paperId) {
        return paperDao.getPaperById(paperId);
    }


    @Override
    public int selectCount() {
        return paperDao.selectCount();
    }

    //分页显示
    @Override
    public PageBean<Paper> findByPage(int currentPage) {
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Paper> pageBean = new PageBean<>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize = 8;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = paperDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);//向上取整,除不尽的时候都向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start", (currentPage - 1) * pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Paper> lists = paperDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;

    }
}