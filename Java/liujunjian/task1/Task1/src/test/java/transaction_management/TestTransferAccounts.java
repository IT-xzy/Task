package transaction_management;

import com.affair.TransferAccounts;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransferAccounts {
    private ApplicationContext context;

    @Before
    public void setContext() {
        context = new ClassPathXmlApplicationContext("transaction_management.xml");
    }

    @Test
    public void testTransferAccounts() {
        TransferAccounts transferAccounts = context.getBean(TransferAccounts.class);
        try {
            transferAccounts.transferAccounts("张三", "李四", 500);
        } catch (Exception e) {
            System.out.println("转账失败！请重新操作");
        }
    }
}
