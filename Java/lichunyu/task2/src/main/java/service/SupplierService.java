package service;

import pojo.Page;
import pojo.Supplier;

import java.util.List;

public interface SupplierService {
    /**
     * 获取供应商列表
     * @param supplier
     * @return
     * @throws Exception
     */
    List<Supplier> getSupplierList(Supplier supplier)throws Exception;

    /**
     * 根据Id获取供应商信息
     * @param supplierId
     * @return
     * @throws Exception
     */
    Supplier getSupplierById(String  supplierId) throws Exception;

    /**
     * 增加供应商
     * @param supplier
     * @throws Exception
     */
    void addSupplier(Supplier supplier) throws Exception;

    /**
     * 删除供应商
     * @param supplierId
     * @throws Exception
     */
    void deleteSupplier(String  supplierId)throws Exception;

    /**
     * 编辑供应商
     * @param supplier
     * @throws Exception
     */
    void updateSupplier(Supplier supplier) throws Exception;

    /**
     * 查询所有供应商
     * @return
     * @throws Exception
     */
    List<Supplier> listAll() throws Exception;


    /**
     * 分页查询实现
     * @return
     */
    List<Supplier> listByPage();
    int total();

    //查询所有信息，分页
    List<Supplier> listByPage(Page<Supplier> page) ;
}
