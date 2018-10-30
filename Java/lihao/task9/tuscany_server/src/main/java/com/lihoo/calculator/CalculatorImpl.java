package com.lihoo.calculator;

import com.lihoo.add.Add;
import com.lihoo.divide.Divide;
import com.lihoo.subtract.Subtract;
import com.lihoo.multiply.Multiply;
import org.oasisopen.sca.annotation.Reference;

/**
 * #Title: CalculatorImpl
 * #ProjectName task9_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/18-10:16
 */


public class CalculatorImpl implements Calculator {
    private Add add;
    private Subtract subtract;
    private Multiply multiply;
    private Divide divide;

    @Reference
    public void setAdd(Add add) {
        this.add = add;
    }

    @Reference
    public void setSubtract(Subtract subtract) {
        this.subtract = subtract;
    }

    @Reference
    public void setMultiply(Multiply multiply) {
        this.multiply = multiply;
    }

    @Reference
    public void setDivide(Divide divide) {
        this.divide = divide;
    }

    @Override
    public double add(double a, double b) {
        return add.add(a, b);
    }

    @Override
    public double subtract(double a, double b) {
        return subtract.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        return multiply.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        return divide.divide(a, b);
    }

}
