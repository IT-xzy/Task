package com.tuscany.demo.server;

import jdk.nashorn.internal.ir.annotations.Reference;

/**
 * @ClassName: ICalculatorImpl
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/7/4 11:14
 * @Version: 1.0
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
