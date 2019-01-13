package com.suger.service.impl;

import com.suger.service.*;
/*import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;*/
import org.oasisopen.sca.annotation.Reference;
import org.oasisopen.sca.annotation.Service;


/**
 * @author suger
 * @date 2019/1/6 20:26
 * 计算器的实现类
 */
@Service(CalculatorService.class)

public class CalculatorServiceImpl implements CalculatorService {

    public AddService addService;

    public SubtractService subtractService;

    public DivideService divide;

    public MultiplyService multiply;



    @Reference
    public void setMultiplyService(MultiplyService multiply) {
        this.multiply = multiply;
    }

    public MultiplyService getMultiplyService() {
        return multiply;
    }


    @Reference
    public void setAddService(AddService addService) {
        this.addService = addService;
    }

    public AddService getAddService() {
        return addService;
    }

    @Reference
    public void setSubtractService(SubtractService subtractService) {
        this.subtractService = subtractService;
    }

    public SubtractService getSubtractService() {
        return subtractService;
    }

    @Reference
    public void setDivideService(DivideService divide) {
        this.divide = divide;
    }

    public DivideService getDivideService() {
        return divide;
    }


    @Override
    public double add(double n1, double n2) {
        return addService.add(n1, n2);
    }

    @Override
    public double subtract(double n1, double n2) {
        return subtractService.subtract(n1, n2);
    }

    @Override
    public double divide(double n1, double n2) {
        return divide.divide(n1, n2);
    }

    @Override
    public double multiply(double n1, double n2) {
        return multiply.multiply(n1, n2);
    }


}
