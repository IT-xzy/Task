package com.ptteng.controller;

import com.ptteng.pojo.*;
import com.ptteng.service.*;
import com.ptteng.utils.*;
import org.apache.commons.logging.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import javax.annotation.*;
import java.util.*;

@Controller
public class CategoryController {

	private static org.apache.commons.logging.Log logger = LogFactory.getLog(CategoryController.class);

	@Resource
	private GetRandomSerUtils getRandomSerUtils;

	//获取数据库的所有信息
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView listCategory(Page page) throws Exception {
		System.out.println("GET    category");
		ModelAndView mav = new ModelAndView();

		// 获得随机服务
		CategoryService categoryService = getRandomSerUtils.getRandomServices();
		List<Category> cs =categoryService.list(page);
		int total =categoryService.total();
		page.caculateLast(total);
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		return mav;
	}

	//跳转至 JSON格式的页面
		@RequestMapping(value = "/categoryJ", method = RequestMethod.GET)
	public String listCategoryJ(Model model) throws Exception {
		System.out.println("开始写入");

		// 随机获取CategoryService
		CategoryService categoryService = getRandomSerUtils.getRandomServices();

		List<Category> categoryListJ = categoryService.list();

		model.addAttribute("categoryListJ", categoryListJ);
		logger.info("这是服务器2");
		return "listCategoryJ";
	}

	//增加信息
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ModelAndView addCategory(Category category) throws Exception {
		System.out.println("POST    category");
		System.out.println("category.getName():" + category.getName());

		// 随机获取CategoryService
		CategoryService categoryService = getRandomSerUtils.getRandomServices();

		categoryService.add(category);
		ModelAndView mav = new ModelAndView("redirect:/category");
		logger.info("这是服务器2");
		return mav;
	}

	//根据ID删除相应的信息
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteCategory(Category category) throws Exception{
		System.out.println("DELETE/id    category");
		// 随机获取CategoryService
		CategoryService categoryService = getRandomSerUtils.getRandomServices();

		categoryService.delete(category);
		ModelAndView mav = new ModelAndView("listCategory");
		logger.info("这是服务器2");
		return mav;
	}

	//根据ID获取相应的信息
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(Category category) throws Exception{
		System.out.println("GET/id    category");
//        System.out.println (id);
		// 随机获取CategoryService
		CategoryService categoryService = getRandomSerUtils.getRandomServices();
		Category c = categoryService.get(category.getId());
		ModelAndView mav = new ModelAndView("editCategory");
		mav.addObject("c", c);
		logger.info("这是服务器2");
		return mav;
	}

	//根据ID更新相应的信息
	@RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
	public ModelAndView updateCategory(Category category) throws Exception {
		System.out.println("PUT/id    category");
		System.out.println("category\t" + category);
		// 随机获取CategoryService
		CategoryService categoryService = getRandomSerUtils.getRandomServices();
		categoryService.update(category);
		System.out.println("category.name" + category.getName());
		ModelAndView mav = new ModelAndView("redirect:/category");
		logger.info("这是服务器2");
		return mav;

	}

}

