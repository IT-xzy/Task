package task06.controller;


import com.sun.media.jfxmedia.logging.Logger;
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
import task06.service.CategoryServiceMemCache;
import task06.service.CategoryServiceMemCacheImpl;
import task06.util.Page;

import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class CategoryControllerMencache {
	@Autowired
	CategoryServiceMemCacheImpl categoryServiceMemcacheImpl;

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

	//获取数据库的所有信息
	@RequestMapping(value = "/categoryM", method = RequestMethod.GET)
	public ModelAndView listCategory(Page page) {
		System.out.println("11111111111");
		ModelAndView mav = new ModelAndView();
		int total = categoryServiceMemcacheImpl.total();
		List<Category> cs = categoryServiceMemcacheImpl.list(page);
		page.caculateLast(total);
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategoryM");
		LOGGER.info("categoryM GET : " + cs);
		return mav;

	}

	// 返回五条记录的 json 格式
	@RequestMapping(value = "/categoryJM2" ,method = RequestMethod.GET)
	@ResponseBody
	public Object listCategory1(Page page) {
		List<Category> cs = categoryServiceMemcacheImpl.list(page);
		int total = categoryServiceMemcacheImpl.total();
		page.caculateLast(total);
		return cs;
	}

	//跳转至 JSON`格式的页面
	@RequestMapping(value = "/categoryRJ", method = RequestMethod.GET)
	public String listCategoryJ(Model model) {
		List<Category> categoryListJ = categoryServiceMemcacheImpl.list();
		model.addAttribute("categoryListJ", categoryListJ);
		return "listCategoryJ";
	}

	//增加信息
	@RequestMapping(value = "/categoryM", method = RequestMethod.POST)
	public ModelAndView addCategory(Category category) {
		categoryServiceMemcacheImpl.add(category);
		ModelAndView mav = new ModelAndView("redirect:/categoryM");
		LOGGER.info("categoryM POST : " );
		return mav;
	}

	//根据ID删除相应的信息
	@RequestMapping(value = "/categoryM/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteCategory(Category category,Page page) {
		categoryServiceMemcacheImpl.delete(category,page);
		ModelAndView mav = new ModelAndView("redirect:/categoryM");
		LOGGER.info("/categoryM/{id}  DELETE : " );
		return mav;
	}

	//根据ID获取相应的信息
	@RequestMapping(value = "/categoryM/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(Category category) {
		Category c = categoryServiceMemcacheImpl.get(category.getId());
		ModelAndView mav = new ModelAndView("editCategoryM");
		mav.addObject("c", c);
		LOGGER.info("/categoryM/{id}  GET : " + c  );
		return mav;
	}

	//根据ID更新相应的信息
	@RequestMapping(value = "/categoryM/{id}", method = RequestMethod.PUT)
	public ModelAndView updateCategory(Category category,Page page) {
		categoryServiceMemcacheImpl.update(category,page);
		ModelAndView mav = new ModelAndView("redirect:/categoryM");
		LOGGER.info("/categoryM/{id}  PUT : "   );
		return mav;
	}

}
