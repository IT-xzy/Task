package tuscanyTest.impl;

import tuscanyTest.service.MultiplyService;

/**
 * @Description: 定义乘法组件实现类
 */
public class MultiplyServiceImpl implements MultiplyService {
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}
