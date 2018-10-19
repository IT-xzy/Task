package task08client.service;


import task08base.pojo.Category;
import task08base.util.Page;

import java.util.List;


public interface CategoryService {
    List<Category> list();

    int total();

    List<Category> list(Page page);

    void add(Category c);

    void update(Category c);

    void delete(Category c);

    Category get(int id);

}
