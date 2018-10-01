package spring.reduce;

public class ReduceImpl implements Reduce {

    @Override
    public double reduce(double a, double b) {
        return a - b;
    }
}
