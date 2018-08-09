package mapper;

import pojo.Category;
import util.Page;

import java.util.List;

public interface CategoryMapper {
    public void add(Category category);

    public void delete(int id);

    public Category get(int id);

    public void update(Category category);

    public List<Category> list();

    public List<Category> list(Page page);

    public int total();


}
