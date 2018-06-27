package com.ssm_yl.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm_yl.pojo.Category;


import com.ssm_yl.dao.Mapper;
import com.ssm_yl.service.*;


import org.oasisopen.sca.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    Mapper mapper;


    private DeleteInterface deleteInterface;
    private InsertCategoryInterface insertCategoryInterface;
    private PageInterface pageInterface;
    private SelectInterface selectInterface;
    private UpdateInterface updateInterface;


    public DeleteInterface getDeleteInterface() {
        return deleteInterface;
    }

   @Reference
    public void setDeleteInterface(DeleteInterface deleteInterface) {
        this.deleteInterface = deleteInterface;
    }

    public InsertCategoryInterface getInsertCategoryInterface() {
        return insertCategoryInterface;
    }

    @Reference
    public void setInsertCategoryInterface(InsertCategoryInterface insertCategoryInterface) {
        this.insertCategoryInterface = insertCategoryInterface;
    }

    public PageInterface getPageInterface() {
        return pageInterface;
    }

    @Reference
    public void setPageInterface(PageInterface pageInterface) {
        this.pageInterface = pageInterface;
    }

    public SelectInterface getSelectInterface() {
        return selectInterface;
    }

    @Reference
    public void setSelectInterface(SelectInterface selectInterface) {
        this.selectInterface = selectInterface;
    }

    public UpdateInterface getUpdateInterface() {
        return updateInterface;
    }

    @Reference
    public void setUpdateInterface(UpdateInterface updateInterface) {
        this.updateInterface = updateInterface;
    }

    public Category select(int id) {
        //不使用缓存
        return selectInterface.select(id);

    }

    public void insertCategory(Category category) {
        insertCategoryInterface.insertCategory(category);
    }

    public void delete(int id) {
        deleteInterface.delete(id);
    }

    public int update(Category category) {
        System.out.println(category.toString());
        return updateInterface.update(category);
    }
    public PageInfo page(Integer pageNum){

        return pageInterface.page(pageNum);
    }

}
