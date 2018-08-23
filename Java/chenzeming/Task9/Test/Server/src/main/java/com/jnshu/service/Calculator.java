package com.jnshu.service;

import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface Calculator {
    double add(double n1, double n2);
}
