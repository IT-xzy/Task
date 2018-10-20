package com.tuscany.demo.server;

import org.osoa.sca.annotations.Reference;

/**
 * #Title: ICalculatorImpl
 * #ProjectName task9_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/13-9:03
 */


public class ICalculatorImpl implements ICalculator {
    private IDivide divide;
    private ISum sum;

    @Override
    public Double sum(Double a, Double b) {
        return this.sum.add(a, b);
    }

    @Override
    public Double divide(Double a, Double b) {
        return this.divide.divide(a, b);
    }

    public IDivide getDivide() {
        return divide;
    }

    @Reference
    public void setDivide(IDivide divide) {
        this.divide = divide;
    }

    public ISum getSum() {
        return sum;
    }

    @Reference
    public void setSum(ISum sum) {
        this.sum = sum;
    }
}
