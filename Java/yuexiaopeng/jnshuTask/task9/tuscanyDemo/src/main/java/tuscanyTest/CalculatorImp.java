package tuscanyTest;

import org.oasisopen.sca.annotation.Reference;

public class CalculatorImp implements Calculator {

    private Add add;

    public Add getAdd() {
        return add;
    }

    //相当于注入add
//      @Reference
    public void setAdd(Add add) {
        this.add = add;
    }

    @Override
    public double add(double a, double b) {
        return this.add.add(a, b);
    }
}
