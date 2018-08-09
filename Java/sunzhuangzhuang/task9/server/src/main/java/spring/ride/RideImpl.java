package spring.ride;

public class RideImpl implements Ride {
    @Override
    public double ride(double a, double b) {
        return a * b;
    }
}
