package task06.service;

import sun.security.krb5.internal.PAData;
import task06.pojo.Category;
import task06.util.Page;

import java.util.List;


public interface CategoryServiceMemCache {

	/**
	 *
	 * @return List<Category> 列表清单
	 */
	List<Category> list();

	/**
	 *
	 * @return total category 总数
	 */

	int total();

	/**
	 *
	 * @param  page 页数
	 * @return List <Category>
	 */

	List <Category> list(Page page);


	/**
	 *
	 * @param  c 增加新的category
	 */
	void add(Category c);

	/**
	 *
	 * @param c 更新 category
	 */
	void update(Category c,Page page);

	/**
	 *
	 * @param c 删除 category
	 */
	void delete(Category c, Page page);

	/**
	 *
	 * @param id id
	 * @return category
	 */
	Category get(int id);

	/**
	 * 更新缓存中的 category 列表
	 */
	void replaceCategoryListCache();
}
