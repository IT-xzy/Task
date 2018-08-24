package dao;

import pojo.Career;

import java.util.List;

public interface CareerMapper {
	List<Career> queryCareerByName();
}
