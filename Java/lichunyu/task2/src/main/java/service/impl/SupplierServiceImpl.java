package service.impl;

import dao.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Page;
import pojo.Supplier;
import service.SupplierService;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;



    @Override
    public List<Supplier> getSupplierList(Supplier supplier) throws Exception {
        return supplierMapper.getSupplierList(supplier);
    }

    @Override
    public Supplier getSupplierById(String  supplierId) throws Exception {
        return supplierMapper.getSupplierById(supplierId);
    }

    @Override
    public void addSupplier(Supplier supplier) throws Exception {
        supplierMapper.addSupplier(supplier);

    }

    @Override
    public void deleteSupplier(String  supplierId) throws Exception {
        supplierMapper.deleteSupplier(supplierId);

    }

    @Override
    public void updateSupplier(Supplier supplier) throws Exception {
        supplierMapper.updateSupplier(supplier);

    }
    @Override
    public List<Supplier> listAll() throws Exception{
        return supplierMapper.listAll();
    }

    /**
     * 分页查询实现
     * @return
     */
    @Override
    public List<Supplier> listByPage() {
        return supplierMapper.listByPage();
    }

    @Override
    public int total() {
        return supplierMapper.total();
    }

    //分页查询
    @Override
    public List<Supplier> listByPage(Page<Supplier> page) {
        //封装总记录数
        int totalSize = supplierMapper.total();
        page.setTotalSize(totalSize);

        //封装总页数
        if(page.getTotalSize()%page.getPageSize()==0)
            page.setTotalPage(page.getTotalSize()/page.getPageSize());
        else
            page.setTotalPage(page.getTotalSize()/page.getPageSize()+1);

        //封装查询开始位置start
        page.setStart((page.getCurrentPage()-1)*page.getPageSize());

        //封装每页显示的数据
        return supplierMapper.listByPage(page);
    }
}
