package com.ssm.utils;

import java.io.InputStream;

public interface UploadStrategyDao  {

    void upload(String fileName, InputStream stream)throws Exception;

}
