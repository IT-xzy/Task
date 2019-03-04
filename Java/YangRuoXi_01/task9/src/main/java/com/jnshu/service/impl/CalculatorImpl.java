package com.jnshu.service.impl;

import com.jnshu.service.*;
import lombok.Getter;
import org.oasisopen.sca.annotation.Reference;


@Getter
public class CalculatorImpl implements Calculator {

    private Add add;
    private Minus minus;
    private Time time;
    private Divide divide;

    @Reference
    public void setAdd(Add add) {
        this.add = add;
    }
    @Reference
    public void setMinus(Minus minus) {
        this.minus = minus;
    }
    @Reference
    public void setTime(Time time) {
        this.time = time;
    }
    @Reference
    public void setDivide(Divide divide) {
        this.divide = divide;
    }

    @Override
    public Integer add(Integer i1, Integer i2) {
        return this.add.add(i1,i2);
    }

    @Override
    public Integer minus(Integer i1, Integer i2) {
        return this.minus.minus(i1,i2);
    }

    @Override
    public Integer time(Integer i1, Integer i2) {
        return this.time.time(i1,i2);
    }

    @Override
    public Integer divide(Integer i1, Integer i2) {
        return this.divide.divide(i1,i2);
    }
}
