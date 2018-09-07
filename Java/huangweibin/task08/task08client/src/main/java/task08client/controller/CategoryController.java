package task08client.controller;


import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import task08base.pojo.Category;
import task08base.util.Page;
import task08client.service.CategoryService;
import task08client.utils.GetRandomSerUtils;

import java.util.List;


@Controller
public class CategoryController {

	private static org.apache.commons.logging.Log logger = LogFactory.getLog(GetRandomSerUtils.class);
	private String ConfigurationPath = "classpath:/spring/applicationContext-rmi-client.xml";


	public CategoryController() {
		System.out.println("进入controller");

	}

	//获取数据库的所有信息
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView listCategory(Page page) {
		System.out.println("GET    category");
		ModelAndView mav = new ModelAndView();

		// 随机获取CategoryService
		Object categoryService =
				GetRandomSerUtils.getRandomServices(ConfigurationPath,"clentrmi1","clentrmi2");

		List<Category> cs =((CategoryService) categoryService).list(page);
		int total = ((CategoryService) categoryService).total();
		page.caculateLast(total);
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		logger.info("这是服务器2");
		return mav;
	}

	//跳转至 JSON格式的页面
	@RequestMapping(value = "/categoryJ", method = RequestMethod.GET)
	public String listCategoryJ(Model model) {
		System.out.println("开始写入");

		// 随机获取CategoryService
		Object categoryService =
				GetRandomSerUtils.getRandomServices(ConfigurationPath,"clentrmi1","clentrmi2");

		List<Category> categoryListJ = ((CategoryService) categoryService).list();

		model.addAttribute("categoryListJ", categoryListJ);
		logger.info("这是服务器2");
		return "listCategoryJ";
	}

	//增加信息
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ModelAndView addCategory(Category category) {
		System.out.println("POST    category");
		System.out.println("category.getName():" + category.getName());

		// 随机获取CategoryService
		Object categoryService =
				GetRandomSerUtils.getRandomServices(ConfigurationPath,"clentrmi1","clentrmi2");

		((CategoryService)categoryService).add(category);
		ModelAndView mav = new ModelAndView("redirect:/category");
		logger.info("这是服务器2");
		return mav;
	}

	//根据ID删除相应的信息
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteCategory(Category category) {
		System.out.println("DELETE/id    category");
		// 随机获取CategoryService
		Object categoryService =
				GetRandomSerUtils.getRandomServices(ConfigurationPath,"clentrmi1","clentrmi2");
		((CategoryService)categoryService).delete(category);
		ModelAndView mav = new ModelAndView("listCategory");
		logger.info("这是服务器2");
		return mav;
	}

	//根据ID获取相应的信息
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(Category category) {
		System.out.println("GET/id    category");
//        System.out.println (id);
		// 随机获取CategoryService
		Object categoryService =
				GetRandomSerUtils.getRandomServices(ConfigurationPath,"clentrmi1","clentrmi2");
		Category c = ((CategoryService)categoryService).get(category.getId());
		ModelAndView mav = new ModelAndView("editCategory");
		mav.addObject("c", c);
		logger.info("这是服务器2");
		return mav;
	}

	//根据ID更新相应的信息
	@RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
	public ModelAndView updateCategory(Category category) {
		System.out.println("PUT/id    category");
		System.out.println("category\t" + category);
		// 随机获取CategoryService
		Object categoryService =
				GetRandomSerUtils.getRandomServices(ConfigurationPath,"clentrmi1","clentrmi2");
		((CategoryService)categoryService).update(category);
		System.out.println("category.name" + category.getName());
		ModelAndView mav = new ModelAndView("redirect:/category");
		logger.info("这是服务器2");
		return mav;

	}

}

