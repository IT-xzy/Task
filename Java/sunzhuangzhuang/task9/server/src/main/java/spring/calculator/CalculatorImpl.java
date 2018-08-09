package spring.calculator;


import org.oasisopen.sca.annotation.Reference;
import spring.except.Except;
import spring.plus.Plus;
import spring.reduce.Reduce;
import spring.ride.Ride;

public class CalculatorImpl implements Calculator {
    private Plus plus;
    private Reduce reduce;
    private Ride ride;
    private Except except;

    @Reference
    public void setPlus(Plus plus) {
        this.plus = plus;
    }

    @Reference
    public void setReduce(Reduce reduce) {
        this.reduce = reduce;
    }

    @Reference
    public void setRide(Ride ride) {
        this.ride = ride;
    }

    @Reference
    public void setExcept(Except except) {
        this.except = except;
    }

    @Override
    public double plus(double a, double b) {
        return plus.plus(a, b);
    }

    @Override
    public double reduce(double a, double b) {
        return reduce.reduce(a, b);
    }

    @Override
    public double ride(double a, double b) {
        return ride.ride(a, b);
    }

    @Override
    public double except(double a, double b) {
        return except.except(a, b);
    }

}
