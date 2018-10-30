package tuscanyTest.impl;

import tuscanyTest.service.MultiplyService;

public class MultiplyServiceImpl implements MultiplyService {
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}
