package org.spring.annotion;

import org.springframework.stereotype.Service;

@Service
public class Monkey {
    private String monkeyName = "MonkeyKing";

    public String toString(){
        return "MonkeyName: " + monkeyName;
    }
}
