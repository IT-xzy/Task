package spring.except;

public class ExceptImpl implements Except {
    @Override
    public double except(double a, double b) {
        return a / b;
    }
}
