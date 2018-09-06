package task06.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import task06.dao.CategoryMapper;
import task06.pojo.Category;
import task06.util.IsEqualCollection;
import task06.util.MemcacheUtil;
import task06.util.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
@Service
public class CategoryServiceMemCacheImpl implements CategoryServiceMemCache {
    @SuppressWarnings("resource")
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private static ClassPathXmlApplicationContext cpacon = new ClassPathXmlApplicationContext("spring/memcachedContext.xml");

    // 失效时间6min
    private static Date FailureTime = new Date(1000 * 360);
    // 用于防止穿透的失效时间 10 s
    private static Date FailureTimeShort = new Date(1000 * 10);
    // IdGroup 缓存名  字
    private List<Integer> idGroupCache = null;
    // 单个 category 的缓存
    private Category categoryObjectCache;
    // 用于存放向前端传递数据的 category 集合
    // private List<Category> categoryListJsp =new ArrayList<Category>() ;
    //写入单个 category 的名字
    private String categoryObjectCacheKey = "";
    // 写入缓存（json 格式）
    private List<Category> categoryListJon = null;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int total() {

        if (MemcacheUtil.get("total") != null) {
            int total = Integer.parseInt(String.valueOf(MemcacheUtil.get("total")));
            LOGGER.info("从缓存中读取到的 total 数据：" + total);
            return total;
        } else {
            int total = categoryMapper.total();
            System.out.println("total:" + total);
            boolean isSuccess = MemcacheUtil.add("total", total, FailureTime);
            LOGGER.info("缓存写入是否成功：" + isSuccess);
            int totalNewCache = Integer.parseInt(String.valueOf(MemcacheUtil.get("total")));
            LOGGER.info("测试刚写入缓存的数据 totalNewCache ：" + totalNewCache);
            return totalNewCache;
        }
    }

    @Override
    public List<Category> list(Page page) {
        page.firstJudge(total());
        LOGGER.info("前端返回的 page 的数据：" + page);
        // 从数据库中取出当前页的 idGroup
        idGroupCache = categoryMapper.idCacheGroupList(page);
        LOGGER.info("数据库中获取到当前页面的 idGroupCache ：" + idGroupCache);
        if (IsEqualCollection.isEqualCollection((Collection) MemcacheUtil.get("idGroupCache"), idGroupCache) &
                MemcacheUtil.get("idGroupCache") != null) {
            List<Category> categoryListJsp = (List<Category>) MemcacheUtil.get("categoryListJsp");
            LOGGER.info("读取缓存中的 categoryListJsp 数据：" + categoryListJsp);
            return categoryListJsp;
        } else {
            boolean delete1IsSuccess = MemcacheUtil.delete("categoryListJsp");
            boolean delete2IsSuccess = MemcacheUtil.delete("idGroupCache");
            LOGGER.info("delete1IsSuccess:" + delete1IsSuccess);
            LOGGER.info("delete2IsSuccess:" + delete2IsSuccess);
            boolean isSuccess = MemcacheUtil.add("idGroupCache", idGroupCache, FailureTime);
            LOGGER.info("idGroupCache 写入缓存是否成功：" + isSuccess);
            List<Category> categoryListJsp = new ArrayList<Category>();

            //   遍历 idGroupCache，将与 value 对应的对象写入缓存
            for (Integer anIdGroupCache : idGroupCache) {
                // 单个 category 写入缓存
                if (anIdGroupCache != null) {
                    int categoryId = anIdGroupCache;
                    // LOGGER.info("categoryObjectCache:" + categoryObjectCache );
                    categoryObjectCacheKey = "categoryObjectCache" + anIdGroupCache;
                    // LOGGER.info("categoryObjectCacheKey :" + categoryObjectCacheKey);
                    categoryObjectCache = (Category) MemcacheUtil.get(categoryObjectCacheKey);
                    // 对不存在于缓冲的单个 category 写入缓存
                    if (MemcacheUtil.get(categoryObjectCacheKey) == null && categoryObjectCache == null) {
                        // LOGGER.info("categoryId:" + categoryId);
                        categoryObjectCache = categoryMapper.get(categoryId);
                        boolean isSuccess1 = MemcacheUtil.add(categoryObjectCacheKey, categoryObjectCache, FailureTime);
                        LOGGER.info(categoryObjectCacheKey + "写入缓存是否成功：" + isSuccess1);
                    }
                    LOGGER.info("categoryObjectCache:" + categoryObjectCache);
                    categoryListJsp.add(categoryObjectCache);
                    LOGGER.info("categoryListJsp:" + categoryListJsp);
                } else {
                    break;
                }
            }
            // 将单个 category 统一封装至 categoryListJsp
            MemcacheUtil.set("categoryListJsp", categoryListJsp, FailureTime);
            return categoryListJsp;
        }
    }


    @Override
    public List<Category> list() {
        if (MemcacheUtil.get("categoryListJon") != null) {
            categoryListJon = (List<Category>) MemcacheUtil.get("categoryListJon");
            LOGGER.info("调用缓存：");
            LOGGER.info("调用缓存：" + categoryListJon);
            return categoryListJon;
        } else {
            categoryListJon = categoryMapper.list();
            LOGGER.info("-------------------------------------------");
            MemcacheUtil.set("categoryListJon", categoryListJon, FailureTime);
            return categoryListJon;
        }
    }


    @Override
    public void add(Category c) {
        boolean deleteTotalIsSuccess = MemcacheUtil.delete("total");
        boolean deleteIdGroupIsSuccess = MemcacheUtil.delete("idGroupCache");
        boolean deleteCategoryListIsSuccess = MemcacheUtil.delete("categoryListJsp");
        LOGGER.info("删除 total 是否成功:" + deleteTotalIsSuccess);
        LOGGER.info("删除 idGroupCache 是否成功:" + deleteIdGroupIsSuccess);
        LOGGER.info("删除 categoryListJsp 是否成功:" + deleteCategoryListIsSuccess);
        categoryMapper.add(c);
        if (categoryMapper.get(c.getId()) != null) {
            String key = "categoryObjectCache" + c.getId();
            boolean issuccess = MemcacheUtil.set(key, c, FailureTime);
            LOGGER.info("单个 category 是否成功写入数据库" + issuccess);
        }
    }

    @Override
    public void update(Category c, Page page) {

        MemcacheUtil.delete("categoryListJsp");
        MemcacheUtil.delete("idGroupCache");

        String categoryObjectCacheKey = "categoryObjectCache" + c.getId();

        categoryMapper.update(c);
        if (categoryMapper.get(c.getId()) != null) {
            boolean issuccess = MemcacheUtil.set(categoryObjectCacheKey, c, FailureTime);
            LOGGER.info("更新数据之后，用户信息是否成功重新写入缓存：" + issuccess);
        }


        // 该修改项目的起点数
        // int categoryId = c.getId();

        // 计算更改页面的起始数
        // int updateStart = ((categoryId -1) / page.getCount()) * page.getCount();

        // 得出该页面的缓存id名字,这个不变
        // String updateStartCacheName = "idGroupCache" + updateStart;

        //从缓存中取出这个页面的 IdGroup 的数值
        // List<Integer> updateStartCacheNameList = (List<Integer>) MemcacheUtil.get(updateStartCacheName);

        // 对 IdGroup 的数值进行判断是否进行了修改，并封装
        // List<Category> categoryListJsp = null;

        // 遍历集合，单个 category 重新写入


        // for (int i = 0 ; i < page.getCount() ;  updateStart ++){
        // 	String categoryObjectCacheKey = "categoryObjectCache" + updateStartCacheNameList.get(i);
        // 	if (updateStartCacheNameList.get(i) == c.getId()){
        // 		MemcacheUtil.set(categoryObjectCacheKey,c,FailureTime);
        // }
        // categoryListJsp = (List<Category>) MemcacheUtil.get(categoryObjectCacheKey);
        // }

        // 删除原有缓存，重新列入
        // MemcacheUtil.delete("categoryListJsp");
        // MemcacheUtil.set("categoryListJsp",categoryListJsp,FailureTime);
    }


    @Override
    public void delete(Category c, Page page) {
        MemcacheUtil.delete("total");
        String deleteObjectCacheKey = "idGroupCache" + c.getId();
        MemcacheUtil.delete(deleteObjectCacheKey);
        MemcacheUtil.delete("categoryListJsp");
        MemcacheUtil.delete("idGroupCache");
        categoryMapper.delete(c.getId());
    }


    // int updateStart = ((categoryId -1) / page.getCount()) * page.getCount();
    // String updateStartCacheName = "idGroupCache" + updateStart;
    // 删除该单个对象的缓存

    // 删除该 idGroupCache 的缓存
    // MemcacheUtil.delete(updateStartCacheName);
    // MemcacheUtil.delete("categoryListJsp");

    //重新写入一份 IdGroup
    // List<Integer> afterDeleteStartCacheNameList =  categoryMapper.idCacheGroupList(page);

    // 遍历集合，单个 category 重新写入
    // List<Category> categoryListJsp = null;
    // for (int i = 0 ; i < page.getCount() ;  updateStart ++){
    // 	String categoryObjectCacheKey = "categoryObjectCache" + afterDeleteStartCacheNameList.get(i);
    // 	if (MemcacheUtil.get(categoryObjectCacheKey) == null){
    // 删除后替补上来的 category
    // Category riseCategory = categoryMapper.get(afterDeleteStartCacheNameList.get(i));
    // MemcacheUtil.set(categoryObjectCacheKey,riseCategory,FailureTime);
    // }
    // categoryListJsp = (List<Category>) MemcacheUtil.get(categoryObjectCacheKey);
    // }
    // categoryMapper.delete(c.getId());
    // MemcacheUtil.set("categoryListJsp",categoryListJsp,FailureTime);
    // }


    @Override
    public Category get(int id) {
        categoryObjectCacheKey = "categoryObjectCache" + id;
        if (MemcacheUtil.get(categoryObjectCacheKey) != null) {
            return (Category) MemcacheUtil.get(categoryObjectCacheKey);
        } else {
            categoryObjectCache = categoryMapper.get(id);
            if (categoryMapper.get(id) == null) {
                Category nullCategory = new Category();
                nullCategory.setName("非法 ID ");
                // 数据库中不存在的数据,设定缓存失效时间短
                MemcacheUtil.set(categoryObjectCacheKey, nullCategory, FailureTimeShort);
            } else {
                MemcacheUtil.set(categoryObjectCacheKey, categoryObjectCache, FailureTime);
            }
            return (Category) MemcacheUtil.get(categoryObjectCacheKey);
        }
    }

    @Override
    public void replaceCategoryListCache() {

    }
}
