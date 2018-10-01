package com.ptteng.rmi;

import com.ptteng.rmi.server.ServerA;
import com.ptteng.rmi.server.ServerB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Distributor {
    @Autowired
    ServerA serverA;
    @Autowired
    ServerB serverB;

}