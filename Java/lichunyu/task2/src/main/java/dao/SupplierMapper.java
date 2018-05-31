package dao;

import pojo.Page;
import pojo.Supplier;

import java.util.List;

public interface SupplierMapper {
    /**
     * 根据名字模糊查询获取供应商列表
     * @param supplier
     * @return
     * @throws Exception
     */
    List<Supplier> getSupplierList(Supplier supplier);

    /**
     * 根据Id获取供应商信息
     * @param supplierId
     * @return
     * @throws Exception
     */
    Supplier getSupplierById(String supplierId);

    /**
     * 增加供应商
     * @param supplier
     * @throws Exception
     */
    void addSupplier(Supplier supplier);

    /**
     * 删除供应商
     * @param supplierId
     * @throws Exception
     */
    void deleteSupplier(String supplierId);

    /**
     * 编辑供应商
     * @param supplier
     * @throws Exception
     */
    void updateSupplier(Supplier supplier);


    /**
     * 获取所有供应商信息
     */

    List<Supplier> listAll();

    /**
     * 分页查询实现
     * @return
     */
    List<Supplier> listByPage();
    //查询总数
    int total();
    //分页查询
    List<Supplier> listByPage(Page<Supplier> page);

}
