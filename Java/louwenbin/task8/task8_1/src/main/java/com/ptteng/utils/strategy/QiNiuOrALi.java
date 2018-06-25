package com.ptteng.utils.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface QiNiuOrALi {
    void convert(String name, InputStream inputStream) throws IOException;
}
