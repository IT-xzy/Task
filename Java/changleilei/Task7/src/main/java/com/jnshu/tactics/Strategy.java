package com.jnshu.tactics;
import java.io.IOException;
import java.io.InputStream;

public interface Strategy {
    public String migration() throws IOException;
    public String fileUpload(String filename, InputStream inputStream) throws IOException;
    public String filedown(String filename, InputStream inputStream) throws IOException;
    public String getUrl(String filename) throws IOException;
    public Boolean checkFile(String filename) throws IOException;
}
