package task06.service;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task06.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task06.pojo.Category;
import task06.util.MemcacheUtil;
import task06.util.Page;

import java.util.List;

/**
 * @author Administrator
 */
@Service
// @ContextConfiguration(locations = "/spring/memcachedContext.xml")
public class CategoryServiceImpl implements CategoryService {
	@SuppressWarnings("resource")
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	private static ClassPathXmlApplicationContext cpacon = new ClassPathXmlApplicationContext("spring/memcachedContext.xml");
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> list(Page page) {
		return categoryMapper.list( page );
	}


	@Override
	public List<Category> list() {
		return categoryMapper.list();
	}


	@Override
	public int total() {
		return categoryMapper.total();
	}

	@Override
	public void add(Category c) {
		categoryMapper.add(c);
	}


	@Override
	public void update(Category c) {
		categoryMapper.update(c);
	}


	@Override
	public void delete(Category c) {
		categoryMapper.delete(c.getId());
	}


	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.get(id);
	}

	@Override
	public void replaceCategoryListCache() {

	}
}

