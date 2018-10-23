package tuscanyTest.impl;

import org.oasisopen.sca.annotation.Reference;
import tuscanyTest.service.AddService;
import tuscanyTest.service.CalculatorService;
import tuscanyTest.service.MultiplyService;

public class CalculatorServiceImpl implements CalculatorService {

    private AddService add;//加法组件
    private MultiplyService multiply;//乘法组件


    //相当于注入add
//    @Reference
    public void setAdd(AddService add) {
        this.add = add;
    }

    public AddService getAdd() {
        return add;
    }

    //    @Reference
    public void setMultiply(MultiplyService multiply) {
        this.multiply = multiply;
    }

    public MultiplyService getMultiply() {
        return multiply;
    }


    @Override
    public double add(double a, double b) {
        return this.add.add(a, b);
    }

    @Override
    public int multiply(int a, int b) {
        return this.multiply.multiply(a, b);
    }

}
