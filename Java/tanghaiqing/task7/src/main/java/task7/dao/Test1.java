package task7.dao;

public interface Test1 {
    public void test1();
}
interface Test3 extends Test1{
    public void test3();
}
class Test4 extends Test2 implements Test3{
    @Override
    public void test3() {
        System.out.println("+++++++++++++++++++");
    }
}


class Test2 implements Test1{
    @Override
    public void test1() {
        System.out.println("重写接口中的方法");
    }
    public void test2(){
        System.out.println("自己的方法！");
    }

    public static void main(String[] args) {
        //Test1 test1 =new Test2();
        //test1.test1();
        //((Test2) test1).test2();

        Test3 test3 =new Test4();
        test3.test3();
        test3.test1();
    }
}


