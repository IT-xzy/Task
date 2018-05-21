package com.student.util;

import java.io.IOException;
import java.io.InputStream;

public interface Storage {

    public void uploadFile(InputStream inputStream, String key) throws IOException;

    public  InputStream download(String key) throws IOException;


}
