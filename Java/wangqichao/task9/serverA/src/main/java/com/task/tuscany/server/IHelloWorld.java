package com.task.tuscany.server;

import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface IHelloWorld {
    String sayHello(String world);
}
