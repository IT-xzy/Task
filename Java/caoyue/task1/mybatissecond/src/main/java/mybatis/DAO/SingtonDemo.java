package mybatis.DAO;

public class SingtonDemo {
    private SingtonDemo(){
         System.out.println("构造");
    }
    private static SingtonDemo a = new SingtonDemo();
    static SingtonDemo getInstance(){
        return a;
    }
    
}

class TestDemo{
    public static void main(String[] args) {
    
    }
}
