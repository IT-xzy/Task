package service.impl;

import dao.CareerMapper;
import org.springframework.stereotype.Service;
import pojo.Career;
import service.CareerService;

import javax.annotation.Resource;
import java.util.List;

@Service("careerServiceImpl")
public class CareerServiceImpl implements CareerService {
	@Resource
	private CareerMapper careerMapper;

	@Override
	public List<Career> queryCareerByName() {
		List<Career> listCareer = careerMapper.queryCareerByName();
		return listCareer;
	}
}
