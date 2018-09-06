package com.leo.service;

import com.leo.model.Student5VO;

public interface Login5Service {
	
	public Long validate(Student5VO student5VO);
	
	public String generatorToken(Student5VO student5VO, Long loginTime);
}
