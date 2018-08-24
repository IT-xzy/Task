package com.jnshu.imp;

import com.jnshu.dao.IRmiServer;

public class RmiServerImpl implements IRmiServer {
    @Override
    public boolean test() {

        System.out.println("调用了我--服务端 O(∩_∩)O哈！");

        return true;
    }

}
