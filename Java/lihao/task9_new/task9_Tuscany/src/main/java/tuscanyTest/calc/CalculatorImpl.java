package tuscanyTest.calc;

import tuscanyTest.serviceCo.Add;

public class CalculatorImpl implements Calculator {

    private Add add;

    public Add getAdd() {
        return add;
    }

    public void setAdd(Add add) {
        this.add = add;
    }

    @Override
    public double add(double a, double b) {
        return this.add.add(a, b);
    }
}
