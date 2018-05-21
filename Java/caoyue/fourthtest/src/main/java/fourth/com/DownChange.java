package fourth.com;

public class DownChange extends Quadrangle{
    public static void main(String[] args) {
        draw(new DownChange());//将此类对象看作是四边形对象，称为向上转型操作
        Quadrangle q =new DownChange();
        //DownChange d = q;
        //将父类对象赋予子类对象，这种写法是错误的
        //将父类对象赋予子类对象，并强制转换为子类型，这种写法是正确的
        DownChange d= (DownChange)q;
        //向下转型时，必须使用显式类型转换，向编译器指明将父类对象转为哪一个类型的子类对象
    }
}
