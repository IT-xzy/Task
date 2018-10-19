package com.service.impl;

import com.dao.PaperDao;
import com.pojo.PageBean;
import com.pojo.Paper;
import com.service.PaperService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PaperServiceImpl implements PaperService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(PaperServiceImpl.class);

    @Autowired
    private PaperDao paperDao;

    @Autowired
    private RedisTemplate redisTemplate;

    //private RedisCacheUtil cache;

    @Override
    //添加用户
    public boolean addPaper(Paper paper) {
        boolean addPaper = paperDao.addPaper(paper);
        try {
            if (addPaper) {
                redisTemplate.opsForValue().set(String.valueOf(paper.getPaperId()), paperDao.queryById(paper.getPaperId()));
                redisTemplate.delete(String.valueOf("userList"));
                logger.info("\n\n已添加数据到缓存");
            } else {
                logger.info("\n\n未添加缓存成功");
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return addPaper;
    }

    //删除论文
    @Override
    public boolean deletePaperById(int id) {
        boolean delete = paperDao.deletePaperById(id);
        try {
            if (delete) {
                if (redisTemplate.opsForValue().get(String.valueOf(id)) != null) {
                    redisTemplate.delete(String.valueOf(id));
                    //redisTemplate.delete(String.valueOf("userList"));
                    logger.info("\n\n已从缓存删除");
                } else {
                    logger.info("\n\n没有对应缓存可以删除：");
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return delete;
    }

    //修改论文信息
    @Override
    public boolean updatePaper(Paper paper) {
        boolean update = paperDao.updatePaper(paper);
        logger.info("\n\n准备进入更新逻辑判断---");
        try {
            if (update) {
                logger.info("\n\n如果数据库更新成功---");
                if (redisTemplate.opsForValue().get(String.valueOf(paper.getPaperId())) != null) {
                    redisTemplate.opsForValue().set(String.valueOf(paper.getPaperId()), paper);
                    logger.info("\n\n" + "修改了缓存数据");
                } else {
                    logger.info("\n\n" + "不存在缓存");
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return update;
    }


    //@Override
    //根据ID查询记录
    //public Paper queryById(int paperId) {
    //    Paper paperOne = (Paper) redisTemplate.opsForValue().get(String.valueOf(paperId));
    //    logger.info("\n前端传过来的paperId是：" + paperId);
    //    logger.info("\n判断前该id的缓存是：" + paperOne);
    //    if (paperOne!= null) {
    //        logger.info("\n从缓存中查询结果");
    //        return paperOne;
    //    } else {
    //        paperOne = paperDao.queryById(paperId);
    //        redisTemplate.opsForValue().set(String.valueOf(paperId), paperOne);
    //        logger.info("\n从数据库添加缓存的数据是：" + paperOne);
    //        return paperOne;
    //    }
    //}

    //根据ID查询记录
    @Override
    public Paper queryById(int paperId) {
        Paper paperOne=null;
        logger.info("\n前端传过来的paperId是：" + paperId);
        if ("@".equals(redisTemplate.opsForValue().get(String.valueOf(paperId)))){
            logger.info("\n防缓存穿透，直接返回");
            return null;
        }
       paperOne = (Paper) redisTemplate.opsForValue().get(String.valueOf(paperId));
        logger.info("\n判断前该id的缓存是：" + paperOne);
        if (paperOne !=null) {
            logger.info("\n第一层判断，缓存中存在数据，查询结果："+paperOne);
            return paperOne;
        } else if (paperDao.queryById(paperId)!=null){
            paperOne = paperDao.queryById(paperId);
            //添加从数据库中缓存
            redisTemplate.opsForValue().set(String.valueOf(paperId), paperOne);
            logger.info("\n 数据库中存在数据，返回数据"+paperOne);
        }else {
          redisTemplate.opsForValue().set(String.valueOf(paperId), "@",120, TimeUnit.SECONDS);
            logger.info("\n数据库中不存在数据，设置缓存为空，防穿透");
        }
            return paperOne;
        }

    //查询全部
    @Override
    public List<Paper> queryAllPaper() {
        List<Paper> paperList = (List<Paper>) redisTemplate.opsForValue().get("paperList");
        try {
            if (paperList != null) {
                logger.info("\n" + "从缓存中查询所有");
            } else {
                logger.info("\n" + "从数据库中查询所有");
                paperList = paperDao.queryAllPaper();
                redisTemplate.opsForValue().set("paperList", paperList);
                //logger.info("\n" + "添加缓存，所有缓存数据如下:" + redisTemplate.opsForValue().get("userList"));
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return paperList;
    }


    @Override
    public Paper getPaperById(String paperId) {
        return paperDao.getPaperById(paperId);
    }

    @Override
    public int selectCount() {
        return paperDao.selectCount();
    }

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