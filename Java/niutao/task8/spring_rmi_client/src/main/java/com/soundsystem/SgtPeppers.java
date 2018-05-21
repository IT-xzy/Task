package com.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

    private String title = "sge";
    private String artist = "the beatles";

    @Override
    public void play(){
        System.out.println("playing"+title+"by"+artist);
    }
}
