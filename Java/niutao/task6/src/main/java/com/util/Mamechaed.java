package com.util;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeoutException;


@Component
public class Mamechaed {

    @Autowired
    MemcachedClient memcachedClient;


    public void heihei(){
        try {
            memcachedClient.set("key",0,"hehe");
            String k = memcachedClient.get("key");
            System.out.println(k);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }

    }


    public void main(String[] args){
            heihei();


    }
}
