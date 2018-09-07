package task06.service;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.tools.ant.util.RegexpPatternMapper;
import org.apache.tools.ant.util.SymbolicLinkUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;
import task06.dao.CategoryMapper;
import task06.pojo.Category;
import task06.util.IsEqualCollection;
import task06.util.MemcacheUtil;
import task06.util.Page;
import task06.util.RedisUtil;

import javax.swing.*;
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
public class CategoryServiceRedisImpl implements CategoryServiceMemCache {
	@SuppressWarnings("resource")
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
	private static RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

	// 失效时间6min
	private static Long FailureTime = 1000*360L;
	// 用于防止穿透的失效时间 10 s
	private static Long FailureTimeShort = 1000*10L;

	// IdGroup 缓存名字
	private List<Integer> idGroupCache = null;
	// 单个 category 的缓存
	private Category categoryObjectCache;
	// 用于存放向前端传递数据的 category 集合
	// private List<Category> categoryListJsp =new ArrayList<Category>() ;
	//写入单个 category 的名字
	private String categoryObjectCacheKey ="";
	// 写入缓存（json 格式）
	private List<Category > categoryListJon =null;



	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public int total() {
		if (redisUtil.get("total")!= null){
			int total = Integer.parseInt(String.valueOf(redisUtil.get("total")));
			LOGGER.info("从缓存中读取到的 total 数据：" + total );
			return total;
		}else {
			int total = categoryMapper.total();
			boolean isSuccess = redisUtil.set("total",total,FailureTime);
			LOGGER.info("缓存写入是否成功：" + isSuccess);
			int totalNewCache = Integer.parseInt(String.valueOf(redisUtil.get("total")));
			LOGGER.info("测试刚写入缓存的数据 totalNewCache ：" + totalNewCache);
			return totalNewCache;
		}
		}

	@Override
	public List<Category> list(Page page) {
		page.firstJudge(total());
		LOGGER.info("前端返回的 page 的数据：" + page );
		// 从数据库中取出当前页的 idGroup
		idGroupCache = categoryMapper.idCacheGroupList(page);
		LOGGER.info("数据库中获取到当前页面的 idGroupCache ：" + idGroupCache );
		if (IsEqualCollection.isEqualCollection((Collection) redisUtil.get("idGroupCache"),idGroupCache)
				& redisUtil.get("idGroupCache")!= null ) {
			List<Category> categoryListJsp = (List<Category>) redisUtil.get("categoryListJsp");
			LOGGER.info("读取缓存中的 categoryListJsp 数据：" + categoryListJsp);
			return categoryListJsp;
		 }else {
			redisUtil.del("categoryListJsp","idGroupCache");
			LOGGER.info("删除之后 categoryListJsp: "  + redisUtil.get("categoryListJsp") + "; " +
					    "idGroupCache" + redisUtil.get("idGroupCache") );
			redisUtil.set("idGroupCache",idGroupCache , FailureTime);
			LOGGER.info("idGroupCache 写入缓存后的值为： " + idGroupCache );
			List<Category> categoryListJsp = new ArrayList<Category>();

			//   遍历 idGroupCache，将与 value 对应的对象写入缓存
			for (Integer anIdGroupCache : idGroupCache) {
				// 单个 category 写入缓存
				if (anIdGroupCache != null) {
					int categoryId = anIdGroupCache;
					// LOGGER.info("categoryObjectCache:" + categoryObjectCache );
					categoryObjectCacheKey = "categoryObjectCache" + anIdGroupCache;
					// LOGGER.info("categoryObjectCacheKey :" + categoryObjectCacheKey);
					categoryObjectCache = (Category) redisUtil.get(categoryObjectCacheKey);
					// 对不存在于缓冲的单个 category 写入缓存
					if (redisUtil.get(categoryObjectCacheKey) == null && categoryObjectCache == null) {
						// LOGGER.info("categoryId:" + categoryId);
						categoryObjectCache = categoryMapper.get(categoryId);
						redisUtil.set(categoryObjectCacheKey, categoryObjectCache, FailureTime);
						LOGGER.info(categoryObjectCacheKey + "写入缓存是否成功：" + redisUtil.get(categoryObjectCacheKey));
					}
					categoryListJsp.add(categoryObjectCache);
					LOGGER.info("categoryListJsp:" + categoryListJsp);
				} else {
					break;
				}
			}
			redisUtil.set("categoryListJsp",categoryListJsp,FailureTime);
			return categoryListJsp;
		}
	}


	@Override
	public List<Category> list() {
		if (redisUtil.get("categoryListJon")!= null ){
			categoryListJon = (List<Category>) redisUtil.get("categoryListJon");
			LOGGER.info("调用缓存：" + categoryListJon );
			return categoryListJon;
		}else {
			categoryListJon = categoryMapper.list();
			LOGGER.info("-------------------------------------------");
			redisUtil.set("categoryListJon",categoryListJon,FailureTime);
			return categoryListJon;
		}
	}


	@Override
	public void add(Category c) {
		redisUtil.del("total","idGroupCache","categoryListJsp");
		LOGGER.info("删除 total idGroupCache categoryListJsp 是否成功："+ redisUtil.get("total"));
		LOGGER.info("删除 total idGroupCache categoryListJsp 是否成功："+ redisUtil.get("idGroupCache"));
		LOGGER.info("删除 total idGroupCache categoryListJsp 是否成功："+ redisUtil.get("categoryListJsp"));
		LOGGER.info("------------------------------------------------------------------");
		categoryMapper.add(c);
	}

	@Override
	public void update(Category c,Page page) {

		// 删除 categoryListJsp 缓存
		redisUtil.del("categoryListJsp");
		redisUtil.del("idGroupCache");
		String categoryObjectCacheKey = "categoryObjectCache" + c.getId();
		redisUtil.set(categoryObjectCacheKey,c,FailureTime);
		categoryMapper.update(c);


		// 该修改项目的起点数
		// int categoryId = c.getId();

		//从缓存中取出这个页面的 IdGroup 的数值
		// List<Integer> idGroupCache = (List<Integer>) redisUtil.get("idGroupCache");

		// 对 IdGroup 的数值进行判断是否进行了修改，并封装
		// List<Category> categoryListJsp = null;

		// 遍历集合，单个 category 重新写入
		// for (Integer anIdGroupCache : idGroupCache) {
			// String categoryObjectCacheKey = "categoryObjectCache" + anIdGroupCache;
			// if (idGroupCache.get(anIdGroupCache) == c.getId()){
				// redisUtil.del("categoryObjectCacheKey");
				// 在缓存中重写修改后的 category
				// redisUtil.set(categoryObjectCacheKey,c,FailureTime);

			// }
			// categoryListJsp = (List<Category>) redisUtil.get(categoryObjectCacheKey);
		// }
		// 修改项写入数据库中,这里也可以采用异步
		// categoryMapper.update(c);

		// categoryListJsp 写入缓存中
		// redisUtil.set("categoryListJsp",categoryListJsp,FailureTime);
		// redisUtil.del("idGroupCache");

		}



	@Override
	public void delete(Category c, Page page) {

		redisUtil.del("total");
		String deleteObjectCacheKey = "idGroupCache" + c.getId();
		MemcacheUtil.delete(deleteObjectCacheKey);
		redisUtil.del("categoryListJsp","idGroupCache");
		categoryMapper.delete(c.getId());



		// redisUtil.del("categoryListJsp");
		// // 定义删除 category 之后，重新在数据库查询的起点
		// int afterDeleteQueryId = 0;
		// // 获取删除项的 id
		// int categoryId = c.getId();
		//
		// // 删除该单个对象的缓存
		// String deleteObjectCacheKey = "idGroupCache" + c.getId();
		// redisUtil.del(deleteObjectCacheKey);
		//
		// idGroupCache = (List<Integer>) redisUtil.get("idGroupCache");
		// if (idGroupCache.get(0) == categoryId ){
		// 	afterDeleteQueryId = idGroupCache.get(1);
		// }else {
		// 	afterDeleteQueryId =idGroupCache.get(0);
		// }
		// page.setStart(afterDeleteQueryId);
		// List<Integer> idGroupCache = categoryMapper.idCacheGroupList(page);
		//
		// List<Category> categoryListJsp = null;
		//
		// for (Integer anIdGroupCache : idGroupCache) {
		// 	String categoryObjectCacheKey = "categoryObjectCache" + anIdGroupCache;
		// 	if (redisUtil.get(categoryObjectCacheKey) == null){
		// 		redisUtil.set(categoryObjectCacheKey,c,FailureTime);
		//
		// 	}
		// 	categoryListJsp = (List<Category>) redisUtil.get(categoryObjectCacheKey);
		// }
		//
		// categoryMapper.delete(c.getId());
		// // categoryListJsp 写入缓存中
		// redisUtil.set("categoryListJsp",categoryListJsp,FailureTime);

	}


	@Override
	public Category get(int id) {
		categoryObjectCacheKey = "categoryObjectCache" + id ;
		if (redisUtil.get(categoryObjectCacheKey)!= null){
			return (Category) redisUtil.get(categoryObjectCacheKey);
		}else{
			categoryObjectCache = categoryMapper.get(id);
			if (categoryMapper.get(id) == null){
				Category nullCategory = new Category();
				nullCategory.setName("非法 ID ");
				// 数据库中不存在的数据,设定缓存失效时间短
				redisUtil.set(categoryObjectCacheKey,nullCategory,FailureTimeShort);
			} else {
				redisUtil.set(categoryObjectCacheKey,categoryObjectCache,FailureTimeShort);
			}
			return (Category) redisUtil.get(categoryObjectCacheKey);
		}
	}

	@Override

	public void replaceCategoryListCache() {

	}
}
