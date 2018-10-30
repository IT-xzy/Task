package tuscanyTest.impl;

import org.oasisopen.sca.annotation.Remotable;
import tuscanyTest.service.AddService;


/**
 * @Description: 定义加法组件实现类
 */
//@Remotable
public class AddServiceImpl implements AddService {

    @Override
    public double add(double a, double b) {
        return a + b;
    }
}
