package service.impl;


import dao.PaperDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.PageBean;
import pojo.Paper;
import service.PaperService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(PaperServiceImpl.class);

    @Autowired
    private PaperDao paperDao;

    @Override
    public boolean addPaper(Paper paper) {
        logger.info("8091端口，业务层新增论文数据 \n");
        return paperDao.addPaper(paper);
    }

    @Override
    public boolean deletePaperById(int id) {
        logger.info("8091端口，业务层根据id删除数据 \n");
        return paperDao.deletePaperById(id);
    }

    @Override
    public boolean updatePaper(Paper paper) {
        logger.info("8091端口，业务层根据id更新数据 \n");
        return paperDao.updatePaper(paper);
    }

    @Override
    public Paper queryById(int id) {
        logger.info("8091端口，业务层取到的paperId=" + id);
        return paperDao.queryById(id);
    }

    @Override
    public List<Paper> queryAllPaper() {
        logger.info("8091端口，业务层查询所有数据 \n");
        return paperDao.queryAllPaper();
    }

    @Override
    public Paper getPaperById(String paperId) {
        logger.info("8091端口，业务层根据id查询数据 \n");
        return paperDao.getPaperById(paperId);
    }

    @Override
    public int selectCount() {
        logger.info("8091端口，业务层查询数据库总数 \n");
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