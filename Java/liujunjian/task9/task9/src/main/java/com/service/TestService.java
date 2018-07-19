package com.service;

import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface TestService {
    double average(double a, double b);

    String read();
}
