package task8services.mapper;


import org.springframework.stereotype.Repository;
import task08base.pojo.Category;
import task08base.util.Page;

import java.util.List;


@Repository
public interface CategoryMapper {
    public void add(Category category);

    public void delete(int id);

    public Category get(int id);

    public void update(Category category);

    public List<Category> list();

    public List<Category> list(Page page);

    public int total();


}
