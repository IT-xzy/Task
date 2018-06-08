import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Supplier;
import service.SupplierService;
import service.impl.SupplierServiceImpl;

import java.util.List;

public class SupplierServiceTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    private SupplierService supplierService = context.getBean(SupplierServiceImpl.class);

    @Test
    public void addTest() throws Exception {
        for(int i=0;i<30;i++) {
            Supplier supplier = new Supplier();
            supplier.setSupplierName("中科大");
            supplier.setContactName("韩非");
            supplier.setContactMobile("18856781234");
            supplier.setRemark("信用很好");
            supplier.setValidFlag("Y");
            supplierService.addSupplier(supplier);
        }
    }

    @Test
    public void listTest() throws Exception {
        Supplier supplier = new Supplier();
        supplier.setSupplierName("小");
        List<Supplier> list = supplierService.getSupplierList(supplier);
        for (Supplier o : list)
            System.out.println(o.toString());

    }

    @Test
    public void getTest() throws Exception {

        Supplier o = supplierService.getSupplierById("10");
        System.out.println(o.toString());

    }

    @Test
    public void deleteTest() throws Exception {

       supplierService.deleteSupplier("8");

    }

    @Test
    public void updateTest() throws Exception {

        Supplier supplier = new Supplier();
        supplier.setSupplierId("25");
        supplier.setSupplierName("中电信");
        supplier.setContactName("项羽");
        supplier.setContactMobile("18856785696");
        supplier.setRemark("信用较优");
        supplierService.updateSupplier(supplier);
    }

}
