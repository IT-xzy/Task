package tuscanyTest.serviceCo;

import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface Add {
    double add(double a, double b);
}
