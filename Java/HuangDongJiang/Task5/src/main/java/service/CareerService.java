package service;

import pojo.Career;

import java.util.List;

public interface CareerService {
	/**
	 * 根据职业的名称查询职业相关信息
	 * @param
	 * @return List<Career>
	 */
    List<Career> queryCareerByName();
}
