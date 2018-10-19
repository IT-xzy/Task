package com.leo.service;

import com.leo.model.Student5VO;

/**  
 * @Belong: task5
 * @Description: 用于注册登录验证 （login5Service与Student5Service应该合并的）
 * @Author: jk-leo
 * @Date: 2018/9/12 16:39
 */ 
public interface Login5Service {
	
	Long validate(Student5VO student5VO);
	
	String generatorToken(Student5VO student5VO);
	
//	Boolean validateCode(String key, String code);
}
