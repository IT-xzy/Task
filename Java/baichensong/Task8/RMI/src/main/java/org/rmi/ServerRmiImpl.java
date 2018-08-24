package org.rmi;


public class ServerRmiImpl implements ServerRmi {
    @Override
    public String sayHi(String name) {

        return name.toString();
    }

}
