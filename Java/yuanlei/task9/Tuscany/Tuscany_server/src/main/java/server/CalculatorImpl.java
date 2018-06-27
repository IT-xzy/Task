package server;

import org.oasisopen.sca.annotation.Reference;

public class CalculatorImpl implements Calculator{
    private AddService addService;
    public AddService getAddService(){
       return addService;
    }

    @Reference
    public void setAddService(AddService addService){
        this.addService = addService;
    }

    
    public double add(double a,double b){
        return addService.add(a,b);
    }
}
