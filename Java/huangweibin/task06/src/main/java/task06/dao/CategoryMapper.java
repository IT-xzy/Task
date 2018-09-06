package task06.dao;

import org.springframework.stereotype.Repository;
import task06.pojo.Category;
import task06.util.Page;

import java.util.List;

/**
 * @author Administrator
 */
@Repository
public interface CategoryMapper {
	// 增加单个 category
	 void add(Category category);

	 // 根据 id 删除单个 category
	 void delete(int id);

	 // 根据id 获取单个 category
	 Category get(int id);

	 // 更新单个 category 的信息
	 void update(Category category);

	 // 查询全部 category  (json)
	 List<Category> list();

	 // 查询全部 category (Jsp)
	 List<Category> list(Page page);

	 // 统计 category 的总数
	 int total();

	 List<Integer> idCacheGroupList(Page page);

}
