package com.leo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leo.model.Student5DO;
import com.leo.model.Student5VO;
import com.leo.service.Student5Service;
import com.leo.utils.ImageUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ListIterator;

/**
 * @Belong: task7
 * @Description: 对student5表的相关处理
 * @Author: jk-leo
 * @Date: 2018/9/20 21:00
 */
@Controller
public class Student5Controller {
	
	private static final Logger logger = (Logger) LogManager.getLogger("mylog");
	
	@Autowired
	Student5Service student5Service;
	
	/**
	 * @Desciption: 显示全部学生的非敏感数据，图片来自七牛云
	 * @Param:
	 * @Return:
	 * @Author: jk-leo
	 * @Date: 2018/9/22 10:41
	 */
	@RequestMapping("/u/studentByQ")
	public ModelAndView listStudentByQ(@RequestParam(required = false,defaultValue = "1",value = "pageNumber")Integer pageNumber){
		ModelAndView mav = new ModelAndView();
		// 设置每页有多少条记录
		PageHelper.startPage(pageNumber,10);
		List<Student5DO> student5DOS = student5Service.selectAll();
		// 通过迭代设置图片URL，突然发现在前端页面直接加前缀也能解决问题
		ListIterator<Student5DO> listIterator = student5DOS.listIterator();
		while(listIterator.hasNext()){
			Student5DO student5DO = listIterator.next();
			String fileName = student5DO.getImage();
			String url = "http://pfc7dn1zw.bkt.clouddn.com/"+fileName;
			student5DO.setImage(url);
		}
		
		// 用pageInfo包装查询结果，只需将pageinfo交给页面即可，同时可指定连续显示的页数
		PageInfo pageInfo = new PageInfo(student5DOS,5);
		
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("body","student");
		mav.setViewName("myView");
		logger.debug("使用七牛云图片");
		return mav;
	}
	
	/**
	 * @Desciption: 显示全部学生的非敏感数据，图片来自腾讯云
	 * @Param:
	 * @Return:
	 * @Author: jk-leo
	 * @Date: 2018/9/22 10:41
	 */
	@RequestMapping("/u/studentByT")
	public ModelAndView listStudentByT(@RequestParam(required = false,defaultValue = "1",value = "pageNumber")Integer pageNumber){
		ModelAndView mav = new ModelAndView();
		// 设置每页有多少条记录
		PageHelper.startPage(pageNumber,10);
		List<Student5DO> student5DOS = student5Service.selectAll();
		// 通过迭代设置图片URL，突然发现在前端页面直接加前缀也能解决问题
		ListIterator<Student5DO> listIterator = student5DOS.listIterator();
		while(listIterator.hasNext()){
			Student5DO student5DO = listIterator.next();
			String fileName = student5DO.getImage();
			String url = "https://timages-1257033436.cos.ap-beijing.myqcloud.com/"+fileName;
			student5DO.setImage(url);
		}
		
		// 用pageInfo包装查询结果，只需将pageinfo交给页面即可，同时可指定连续显示的页数
		PageInfo pageInfo = new PageInfo(student5DOS,5);
		
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("body","student");
		mav.setViewName("myView");
		logger.debug("使用腾讯云图片");
		return mav;
	}
	
	/**
	 * @Desciption: 删除学生列表中单个学生记录
	 * @Param:
	 * @Return:
	 * @Author: jk-leo
	 * @Date: 2018/9/22 10:40
	 */
	@RequestMapping("delete")
	public ModelAndView deleteById(@RequestParam Long studentID){
		ModelAndView mav = new ModelAndView();
		student5Service.deleteById(studentID);
		mav.setViewName("redirect:/u/studentByT");
		return mav;
	}
	
	/**
	 * @Desciption: 个人中心信息显示
	 * @Param: 用户ID
	 * @Return: 用户数据
	 * @Author: jk-leo
	 * @Date: 2018/9/21 17:19
	 */
	@RequestMapping(value="u/personCenter/{id}")
	public String personCenter(@PathVariable("id")long id, Model model){
		Student5VO student5VO = student5Service.selectById(id);
		String fileName = student5VO.getImage();
		String url = "http://pfc7dn1zw.bkt.clouddn.com/"+fileName;
		student5VO.setImage(url);
		model.addAttribute("student5",student5VO);
		return "personCenter";
	}
	
	/**
	 * @Desciption: 图片提交处理，上传到七牛云
	 * @Param: [imageFile]
	 * @Return: 
	 * @Author: jk-leo
	 * @Date: 2018/9/21 16:29
	 */ 
	@RequestMapping("u/imageSubmit2Q")
	public String imageSubmitToQ(@RequestParam("ImageFile") MultipartFile imageFile , @RequestParam("id")long id) {
		if (!imageFile.isEmpty()) {
			try {
				InputStream imageFileStream = imageFile.getInputStream();
				String newFileName = ImageUtil.qUploadImage(imageFileStream);
				if (newFileName != null){
					System.out.println(newFileName);
					Student5VO student5VO = student5Service.selectById(id);
					student5VO.setImage(newFileName);
					logger.debug(student5VO);
					student5Service.updateById(student5VO);
					logger.debug("七牛云图片更新完毕");
					return "redirect:/home";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:failed";
	}
	/**
	 * @Desciption: 图片提交处理，上传到腾讯云
	 * @Param:
	 * @Return:
	 * @Author: jk-leo
	 * @Date: 2018/9/22 20:56
	 */
	@RequestMapping("u/imageSubmit2T")
	public String imageSubmit2T(@RequestParam("ImageFile") MultipartFile imageFile , @RequestParam("id")long id) {
		if (!imageFile.isEmpty()) {
			try {
				InputStream imageFileStream = imageFile.getInputStream();
				long contentLength = imageFile.getSize();
				String newFileName = ImageUtil.tUploadImage(imageFileStream,contentLength);
				if (newFileName != null){
					System.out.println(newFileName);
					Student5VO student5VO = student5Service.selectById(id);
					student5VO.setImage(newFileName);
					logger.debug(student5VO);
					student5Service.updateById(student5VO);
					logger.debug("腾讯云图片更新完毕");
					return "redirect:/home";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:failed";
	}
}
