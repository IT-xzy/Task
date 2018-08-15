package samples.tuscany.impl;

import org.oasisopen.sca.annotation.Reference;
import samples.tuscany.IAdd;
import samples.tuscany.ICalculator;

/**
 * @author baich
 */
public class Calculator implements ICalculator{
    private IAdd add;

    /**注解的意思大概和 spring里的 @Autowired
    注解意思差不多 。。。。 把实现类注入到 add.composite中*/

    @Reference
    public void setAdd(IAdd add) {
        this.add = add;
    }

    @Override
    public double add(double n1, double n2) {
        // TODO Auto-generated method stub
        //this 就代表这个类 。 this.add代表  调用 本类里的 变量add 。就是调用 这个IAdd接口。 .add(n1,n2)代表 接口的方法。
        return this.add.add(n1, n2);
    }



}

