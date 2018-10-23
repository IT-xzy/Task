package tuscanyTest.impl;

import org.oasisopen.sca.annotation.Remotable;
import tuscanyTest.service.AddService;

//@Remotable
//组件的实现类
public class AddServiceImpl implements AddService {

    @Override
    public double add(double a, double b) {
        return a + b;
    }
}
