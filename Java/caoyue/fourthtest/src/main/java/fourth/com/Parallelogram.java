package fourth.com;

public class Parallelogram extends Quadrangle{
    public static void main(String args[]){
        Parallelogram p = new Parallelogram();//这就相当于"Quadrangle obj=new Parallelogram()"，就是把子类对象赋值给父类类型的变量，这就是向上转型
        draw(p);
    }
}
