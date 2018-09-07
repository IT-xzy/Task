package task06.controller;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import task06.pojo.Category;
import task06.service.CategoryServiceImpl;
import task06.service.CategoryServiceRedisImpl;
import task06.util.Page;
import task06.util.RedisUtil;

import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class CategoryControllerRedis {
	@Autowired
	CategoryServiceRedisImpl categoryServiceRedis;

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryControllerRedis.class);

	//获取数据库的所有信息
	@RequestMapping(value = "/categoryR", method = RequestMethod.GET)
	public ModelAndView listCategoryR(Page page) {

		ModelAndView mav = new ModelAndView();
		int total = categoryServiceRedis.total();
		List<Category> cs = categoryServiceRedis.list(page);
		page.caculateLast(total);
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategoryR");
		LOGGER.info("categoryM GET : " + cs);
		return mav;

	}

	//跳转至 JSON`格式的页面
	@RequestMapping(value = "/categoryJR", method = RequestMethod.GET)
	public String listCategoryJ(Model model) {
		List<Category> categoryListJ = categoryServiceRedis.list();
		model.addAttribute("categoryListJR", categoryListJ);
		return "listCategoryJ";
	}

	// 返回五条记录的 json 格式
	@RequestMapping(value = "/categoryJR2" ,method = RequestMethod.GET)
	@ResponseBody
	public Object listCategory1(Page page) {
		List<Category> cs = categoryServiceRedis.list(page);
		int total = categoryServiceRedis.total();
		page.caculateLast(total);
		return cs;
	}

	//增加信息
	@RequestMapping(value = "/categoryR", method = RequestMethod.POST)
	public ModelAndView addCategory(Category category) {
		categoryServiceRedis.add(category);
		ModelAndView mav = new ModelAndView("redirect:/categoryR");
		LOGGER.info("categoryM POST : " );
		return mav;
	}

	//根据ID删除相应的信息
	@RequestMapping(value = "/categoryR/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteCategory(Category category,Page page) {
		categoryServiceRedis.delete(category,page);
		ModelAndView mav = new ModelAndView("redirect:/categoryR");
		LOGGER.info("/categoryR/{id}  DELETE : " );
		return mav;
	}

	//根据ID获取相应的信息
	@RequestMapping(value = "/categoryR/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(Category category) {
		Category c = categoryServiceRedis.get(category.getId());
		ModelAndView mav = new ModelAndView("editCategoryR");
		mav.addObject("c", c);
		LOGGER.info("/categoryR/{id}  GET : " + c  );
		return mav;
	}

	//根据ID更新相应的信息
	@RequestMapping(value = "/categoryR/{id}", method = RequestMethod.PUT)
	public ModelAndView updateCategory(Category category,Page page) {

		categoryServiceRedis.update(category,page);
		ModelAndView mav = new ModelAndView("redirect:/categoryR");
		LOGGER.info("/categoryR/{id}  PUT : "   );
		return mav;
	}

}
