package service.impl;



import org.oasisopen.sca.annotation.Reference;
import org.oasisopen.sca.annotation.Remotable;
import org.oasisopen.sca.annotation.Service;
import org.springframework.stereotype.Component;
import service.AddService;
import service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

    private AddService addService;

    @Reference
    public void setAddService(AddService addService) {
        this.addService = addService;
    }


    @Override
    public double add(double a, double b) {
        return addService.add(a,b);
    }
}
