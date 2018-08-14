import com.jnshu.czm.encryp.DES;

public class Test {
    @org.junit.Test
    public void add() throws Exception {
        String num="陈泽铭";
        System.out.println("原文："+num);
        DES str =new DES();
        String asc=str.encrypt(num);
        str.decrypt(asc);
    }
}
